package org.jetbrains.grammar

import org.jetbrains.grammar.HaskellTokens
import com.intellij.lang.PsiBuilder
import org.jetbrains.haskell.parser.rules.ParserState


public class HaskellParser(state : ParserState) : BaseHaskellParser(state) {

  // module : 'module' conid 'where'
  fun parseModule() : Boolean {
    var res = true
    var mark = makeMark()
    res = res && token(HaskellLexerTokens.MODULE)
    res = res && token(HaskellLexerTokens.CONID)
    res = res && token(HaskellLexerTokens.WHERE)
    if (res) {
      mark.done(HaskellTokens.MODULE)
      return true
    }
    mark.rollbackTo()
    return res
  }
}
