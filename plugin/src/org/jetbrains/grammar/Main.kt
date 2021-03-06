package org.jetbrains.grammar

import java.io.File
import java.io.FileReader
import org.jetbrains.haskell.parser.lexer.HaskellLexer
import com.intellij.lang.PsiBuilder
import com.intellij.lang.impl.PsiBuilderImpl
import java.util.ArrayList
import com.intellij.psi.tree.IElementType
import com.intellij.psi.TokenType
import org.jetbrains.haskell.parser.token.NEW_LINE
import org.jetbrains.haskell.parser.token.COMMENTS
import java.io.FilenameFilter
import java.io.FileWriter
import java.io.PrintStream
import org.jetbrains.grammar.dumb.LazyLLParser
import org.jetbrains.haskell.parser.getCachedTokens
import org.jetbrains.haskell.parser.newLexerState
import java.io.BufferedReader
import org.jetbrains.haskell.parser.CachedTokens
import org.jetbrains.grammar.dumb.Rule

/**
 * Created by atsky on 15/11/14.
 */
fun main(args : Array<String>) {
    val path = File("./data")
    val filter = object : FilenameFilter {
        override fun accept(dir: File, name: String): Boolean {
            return name.endsWith("Test.hs")
        }

    }
    for (file in path.listFiles(filter)) {
        val name = file.getName()
        parseFile(file, File(path, name.substring(0, name.length() - 3) + "_tree.txt"))
    }
}


fun parseFile(inFile : File, outFile : File) {
    val data = readData(inFile)

    val lexer = HaskellLexer()
    lexer.start(data)

    val stream = PrintStream(outFile)
    val cachedTokens = getCachedTokens(lexer, stream)

    printTokens(cachedTokens)

    val grammar = HaskellParser(null).getGrammar()

    HaskellParser(null).findFirst(grammar)

    //evaluateManyTimes(cachedTokens, grammar)

    val parser = LazyLLParser(grammar, cachedTokens)
    parser.writeLog = true;
    val tree = parser.parse()
    stream.println(tree?.prettyPrint(0))
    stream.close()
}

private fun printTokens(cachedTokens: CachedTokens) {
    var state = newLexerState(cachedTokens)
    while (state.getToken() != null) {
        println(state.getToken());
        state = state.next()
    }
}

private fun evaluateManyTimes(cachedTokens: CachedTokens, grammar: MutableMap<String, Rule>) {
    val start = System.currentTimeMillis()
    for (i in 1..200) {
        val parser = LazyLLParser(grammar, cachedTokens)
        parser.parse()
    }
    val time = System.currentTimeMillis() - start
    println("time = ${time}")
}

fun readData(file: File): String {
    val reader = BufferedReader(FileReader(file))
    return reader.readText()
}