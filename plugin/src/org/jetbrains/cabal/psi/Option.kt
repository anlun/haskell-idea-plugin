package org.jetbrains.cabal.psi

import com.intellij.lang.ASTNode
import com.intellij.extapi.psi.ASTWrapperPsiElement
import org.jetbrains.cabal.psi.Checkable
import org.jetbrains.cabal.psi.PropertyValue
import org.jetbrains.cabal.highlight.ErrorMessage

public class Option(node: ASTNode) : ASTWrapperPsiElement(node), Checkable, PropertyValue {

    public override fun check(): List<ErrorMessage> {
        if (!getNode().getText()!!.matches("^(\\w|[.\\-@])*$")) return listOf(ErrorMessage(this, "invalid option", "error"))
        return listOf()
    }
}
