package org.jetbrains.haskell.debugger

import com.intellij.xdebugger.evaluation.XDebuggerEvaluator
import com.intellij.xdebugger.breakpoints.XBreakpointProperties
import com.intellij.xdebugger.breakpoints.XLineBreakpoint
import org.jetbrains.haskell.debugger.parser.HsStackFrameInfo
import com.intellij.openapi.util.Key
import org.jetbrains.haskell.debugger.protocol.AbstractCommand
import org.jetbrains.haskell.debugger.parser.ParseResult
import org.jetbrains.haskell.debugger.protocol.HiddenCommand
import org.jetbrains.haskell.debugger.protocol.TraceCommand
import org.jetbrains.haskell.debugger.parser.Parser
import org.json.simple.JSONObject
import com.intellij.execution.ui.ConsoleViewContentType
import org.jetbrains.haskell.debugger.protocol.BreakpointListCommand
import org.jetbrains.haskell.debugger.protocol.SetBreakpointCommand
import org.jetbrains.haskell.debugger.parser.HsFilePosition
import org.jetbrains.haskell.debugger.parser.LocalBinding
import java.util.ArrayList
import org.json.simple.JSONArray
import org.jetbrains.haskell.debugger.protocol.FlowCommand
import org.jetbrains.haskell.debugger.protocol.ResumeCommand
import org.jetbrains.haskell.debugger.protocol.StepIntoCommand
import org.jetbrains.haskell.debugger.protocol.StepOverCommand
import org.jetbrains.haskell.debugger.protocol.RemoveBreakpointCommand
import org.jetbrains.haskell.debugger.protocol.CommandCallback
import org.jetbrains.haskell.debugger.parser.BreakpointCommandResult
import org.jetbrains.haskell.debugger.protocol.ForceCommand
import org.jetbrains.haskell.debugger.frames.HsDebugValue
import org.jetbrains.haskell.debugger.protocol.EvalCommand
import org.jetbrains.haskell.debugger.frames.HsSuspendContext
import org.jetbrains.haskell.debugger.frames.ProgramThreadInfo
import org.jetbrains.haskell.debugger.frames.HsTopStackFrame
import org.jetbrains.haskell.debugger.protocol.PrintCommand
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.Condition
import org.jetbrains.haskell.debugger.utils.HaskellUtils
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.notification.Notifications
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import org.jetbrains.haskell.debugger.frames.HsDebuggerEvaluator
import com.intellij.xdebugger.frame.XValue
import org.jetbrains.haskell.debugger.frames.HsHistoryFrame
import org.jetbrains.haskell.debugger.protocol.BackCommand

/**
 * Created by vlad on 7/30/14.
 */

public class RemoteDebugger(val debugProcess: HaskellDebugProcess) : ProcessDebugger {
    private val queue: CommandQueue
    private val handler: JSONHandler = JSONHandler()
    private val writeLock = Any()

    private var lastCommand: AbstractCommand<out ParseResult?>? = null;

    {
        queue = CommandQueue({(command: AbstractCommand<out ParseResult?>) -> execute(command) })
        queue.start()
    }

    public var debugStarted: Boolean = false
        private set

    private fun execute(command: AbstractCommand<out ParseResult?>) {
        val text = command.getText()

        synchronized(writeLock) {
            lastCommand = command

            command.callback?.execBeforeSending()

            if (command !is HiddenCommand) {
                debugProcess.printToConsole(text, ConsoleViewContentType.SYSTEM_OUTPUT)
            }

            val os = debugProcess.getProcessHandler().getProcessInput()!!
            os.write(text.toByteArray())
            os.flush()

            if (command is TraceCommand) {
                debugStarted = true
            }
        }
    }

    override fun evaluateExpression(expression: String, callback: XDebuggerEvaluator.XEvaluationCallback) =
            queue.addCommand(EvalCommand(expression, object : CommandCallback<ParseResult?>() {
                override fun execAfterParsing(result: ParseResult?) {
                }
                override fun execBeforeSending() {
                    handler.evaluateCallback = callback
                }
            }))

    override fun trace() =
            queue.addCommand(TraceCommand("main", null))

    override fun setBreakpoint(module: String, line: Int) =
            queue.addCommand(SetBreakpointCommand(module, line, null))

    override fun removeBreakpoint(module: String, breakpointNumber: Int) =
            queue.addCommand(RemoveBreakpointCommand(module, breakpointNumber, null))

    override fun close() = queue.stop()

    override fun stepInto() = queue.addCommand(StepIntoCommand(null))

    override fun stepOver() = queue.addCommand(StepOverCommand(null))

    override fun runToPosition(module: String, line: Int) =
            queue.addCommand(SetBreakpointCommand(module, line,
                    object : CommandCallback<BreakpointCommandResult?>() {
                        override fun execAfterParsing(result: BreakpointCommandResult?) {
                        }
                        override fun execBeforeSending() {
                            handler.inRunToPosition = true
                        }
                    }))

    override fun resume() = queue.addCommand(ResumeCommand(null))

    override fun prepareDebugger() {
    }

    override fun back(backCommand: BackCommand) {
    }

    override fun forward() {

    }

    override fun updateBinding(binding: LocalBinding, lock: Lock, condition: Condition) {
        throw UnsupportedOperationException()
    }

    override fun force(forceCommand: ForceCommand) = queue.addCommand(forceCommand)

    override fun print(printCommand: PrintCommand) = queue.addCommand(printCommand)

    override fun sequenceCommand(command: AbstractCommand<*>, length: Int) {
        for(i in 0..length) {
            queue.addCommand(command)
        }
    }

    override fun onTextAvailable(text: String, outputType: Key<out Any?>?) {
        handler.handle(Parser.parseJSONObject(text).json)
        queue.setReadyForInput()
    }

    private fun breakpointList(module: String, lineToSet: Int? = null) =
            queue.addCommand(BreakpointListCommand(module, lineToSet, null))

    public inner class JSONHandler {
        private val CONNECTED_MSG = "connected to port"

        private val WARNING_MSG = "warning"
        private val EXCEPTION_MSG = "exception"

        private val PAUSED_MSG = "paused"
        private val FINISHED_MSG = "finished"

        private val BREAKPOINT_SET_MSG = "breakpoint was set"
        private val BREAKPOINT_NOT_SET_MSG = "breakpoint was not set"

        private val BREAKPOINT_REMOVED_MSG = "breakpoint was removed"
        private val BREAKPOINT_NOT_REMOVED_MSG = "breakpoint was not removed"

        private val EVALUATED_MSG = "evaluated"

        // For history command
        public var breakpoint: XLineBreakpoint<XBreakpointProperties<out Any?>>? = null
        public var topFrameInfo: HsStackFrameInfo? = null

        // For runToPosition command combination
        public var inRunToPosition: Boolean = false
        public var tempBreakpointIndex: Int? = null

        // For evaluateExpression command
        public var evaluateCallback: XDebuggerEvaluator.XEvaluationCallback? = null

        public fun handle(result: JSONObject) {
            val info = result.get("info") as String?
            when (info) {
                null ->
                    throw RuntimeException("Missing data type")
                CONNECTED_MSG ->
                    debugProcess.printToConsole("Connected to port: ${result.get("port")}\n",
                            ConsoleViewContentType.SYSTEM_OUTPUT)
                WARNING_MSG ->
                    if (evaluateCallback != null) {
                        evaluateCallback?.errorOccurred(result.getString("message"))
                        evaluateCallback = null
                    } else {
                        debugProcess.printToConsole("WARNING: ${result.getString("message")}\n",
                                ConsoleViewContentType.ERROR_OUTPUT)
                    }
                EXCEPTION_MSG ->
                    if (evaluateCallback != null) {
                        evaluateCallback?.errorOccurred(result.getString("message"))
                        evaluateCallback = null
                    } else {
                        debugProcess.printToConsole("EXCEPTION: ${result.getString("message")}\n",
                                ConsoleViewContentType.ERROR_OUTPUT)
                    }
                PAUSED_MSG ->
                    paused(result)
                FINISHED_MSG ->
                    debugProcess.getSession()!!.stop()
                BREAKPOINT_SET_MSG -> {
                    if (!inRunToPosition) {
                        debugProcess.setBreakpointNumberAtLine(result.getInt("index"),
                                (lastCommand as SetBreakpointCommand).module, result.getObject("src_span").getInt("startline"))
                    } else {
                        queue.addCommand(ResumeCommand(null), true)
                        queue.addCommand(RemoveBreakpointCommand((lastCommand as SetBreakpointCommand).module, result.getInt("index"), null), true)
                    }
                }
                BREAKPOINT_NOT_SET_MSG ->
                    debugProcess.printToConsole("Breakpoint was not set: ${result.getString("add_info")}\n",
                            ConsoleViewContentType.SYSTEM_OUTPUT)
                BREAKPOINT_REMOVED_MSG -> {
                    if (inRunToPosition) {
                        inRunToPosition = false
                    }
                }
                BREAKPOINT_NOT_REMOVED_MSG ->
                    debugProcess.printToConsole("Breakpoint was not removed: ${result.getString("add_info")}\n",
                            ConsoleViewContentType.SYSTEM_OUTPUT)
                EVALUATED_MSG -> {
                    evaluateCallback?.evaluated(HsDebugValue(LocalBinding(null, result.getString("type"), result.getString("value"))))
                    evaluateCallback = null
                }
                else ->
                    throw RuntimeException("Unknown result")
            }
        }

        private fun paused(result_json: JSONObject) {
            val srcSpan = result_json.getObject("src_span")
            val result = HsStackFrameInfo(getFilePosition(srcSpan),
                    ArrayList(result_json.getArray("vars").toArray().map {
                        (variable) ->
                        with (variable as JSONObject) {
                            LocalBinding(getString("name"), get("type") as String?, get("value") as String?)
                        }
                    }))
            val moduleName = HaskellUtils.getModuleName(debugProcess.getSession()!!.getProject(),
                    LocalFileSystem.getInstance()!!.findFileByPath(result.filePosition.filePath)!!)
            val breakpoint = debugProcess.getBreakpointAtPosition(moduleName, result.filePosition.rawStartLine)
            val condition = breakpoint?.getCondition()
            if (breakpoint != null && condition != null) {
                handleCondition(breakpoint, condition, result)
            } else if (breakpoint != null) {
                setContext(result, breakpoint)
            } else {
                Notifications.Bus.notify(Notification("", "Wrong breakpoint condition", "No breakpoint in line", NotificationType.WARNING))
                debugProcess.getSession()!!.stop()
            }
        }

        private fun handleCondition(breakpoint: XLineBreakpoint<XBreakpointProperties<out Any?>>, condition: String, result: HsStackFrameInfo) {
            val evaluator = HsDebuggerEvaluator(debugProcess.debugger)
            evaluator.evaluate(condition, object : XDebuggerEvaluator.XEvaluationCallback {
                override fun errorOccurred(errorMessage: String) {
                    val msg = "Condition \"$condition\" of breakpoint at line ${breakpoint.getLine()}" +
                            "cannot be evaluated, reason: $errorMessage"
                    Notifications.Bus.notify(Notification("", "Wrong breakpoint condition", msg, NotificationType.WARNING))
                    setContext(result, breakpoint)
                }
                override fun evaluated(evalResult: XValue) {
                    if (evalResult is HsDebugValue &&
                            evalResult.binding.typeName == HaskellUtils.HS_BOOLEAN_TYPENAME &&
                            (evalResult as HsDebugValue).binding.value == HaskellUtils.HS_BOOLEAN_TRUE) {
                        setContext(result, breakpoint)
                    } else {
                        debugProcess.debugger.resume()
                    }
                }

            }, null)
        }

        private fun setContext(result: HsStackFrameInfo, breakpoint: XLineBreakpoint<XBreakpointProperties<out Any?>>) {
            val stackFrame = HsHistoryFrame(debugProcess, result)
            val context = HsSuspendContext(debugProcess, ProgramThreadInfo(null, "Main", result))
            debugProcess.historyChanged(false, true, stackFrame)
            debugProcess.getSession()!!.breakpointReached(breakpoint, breakpoint.getLogExpression(), context)
        }

        private fun getFilePosition(srcSpan: JSONObject): HsFilePosition =
                HsFilePosition(srcSpan.getString("file"), srcSpan.getInt("startline"), srcSpan.getInt("startcol"),
                        srcSpan.getInt("endline"), srcSpan.getInt("endcol"))

        private fun JSONObject.getInt(key: String): Int {
            return (get(key) as Long).toInt()
        }

        private fun JSONObject.getString(key: String): String {
            return get(key) as String
        }

        private fun JSONObject.getObject(key: String): JSONObject {
            return get(key) as JSONObject
        }

        private fun JSONObject.getArray(key: String): JSONArray {
            return get(key) as JSONArray
        }
    }

}