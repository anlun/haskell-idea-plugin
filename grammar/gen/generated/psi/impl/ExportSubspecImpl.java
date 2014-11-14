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

public class ExportSubspecImpl extends ASTWrapperPsiElement implements ExportSubspec {

  public ExportSubspecImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitExportSubspec(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Qcnames getQcnames() {
    return findChildByClass(Qcnames.class);
  }

  @Override
  @NotNull
  public PsiElement getCparen() {
    return findNotNullChildByType(CPAREN);
  }

  @Override
  @Nullable
  public PsiElement getDotdot() {
    return findChildByType(DOTDOT);
  }

  @Override
  @NotNull
  public PsiElement getOparen() {
    return findNotNullChildByType(OPAREN);
  }

}
