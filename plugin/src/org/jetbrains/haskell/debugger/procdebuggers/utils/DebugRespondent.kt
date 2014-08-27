package org.jetbrains.haskell.debugger.procdebuggers.utils

import org.jetbrains.haskell.debugger.frames.HsSuspendContext
import com.intellij.xdebugger.breakpoints.XBreakpoint
import com.intellij.xdebugger.breakpoints.XLineBreakpoint
import com.intellij.xdebugger.breakpoints.XBreakpointProperties
import org.jetbrains.haskell.debugger.breakpoints.HaskellExceptionBreakpointProperties
import org.jetbrains.haskell.debugger.history.HistoryManager
import org.jetbrains.haskell.debugger.frames.HsHistoryFrame
import org.jetbrains.haskell.debugger.parser.HistoryResult


public trait DebugRespondent {

    public fun traceFinished()

    public fun positionReached(context: HsSuspendContext)

    public fun breakpointReached(breakpoint: XBreakpoint<*>,
                                 evaluatedLogExpression: String?,
                                 context: HsSuspendContext)

    public fun exceptionReached(context: HsSuspendContext)

    public fun breakpointRemoved()

    public fun getBreakpointAt(module: String, line: Int): XLineBreakpoint<XBreakpointProperties<*>>?

    public fun setBreakpointNumberAt(breakpointNumber: Int, module: String, line: Int)

    public fun resetHistoryStack()

    public fun historyFrameAppeared(frame: HsHistoryFrame, history: HistoryResult?)

    public fun getModuleByFile(filename: String): String

}