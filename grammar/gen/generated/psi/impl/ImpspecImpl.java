// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static generated.GeneratedTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class ImpspecImpl extends ASTWrapperPsiElement implements Impspec {

  public ImpspecImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitImpspec(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public Exportlist getExportlist() {
    return findNotNullChildByClass(Exportlist.class);
  }

  @Override
  @NotNull
  public PsiElement getCparen() {
    return findNotNullChildByType(CPAREN);
  }

  @Override
  @Nullable
  public PsiElement getHiding() {
    return findChildByType(HIDING);
  }

  @Override
  @NotNull
  public PsiElement getOparen() {
    return findNotNullChildByType(OPAREN);
  }

}
