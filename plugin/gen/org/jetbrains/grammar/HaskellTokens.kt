package org.jetbrains.grammar

import com.intellij.psi.tree.IElementType
import org.jetbrains.haskell.parser.HaskellCompositeElementType
import org.jetbrains.haskell.psi.*


object HaskellTokens {
  val MODULE = HaskellCompositeElementType("module", ::Module)
}
