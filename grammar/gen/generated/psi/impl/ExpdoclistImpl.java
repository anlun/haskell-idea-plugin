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

public class ExpdoclistImpl extends ASTWrapperPsiElement implements Expdoclist {

  public ExpdoclistImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitExpdoclist(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ExpDoc getExpDoc() {
    return findChildByClass(ExpDoc.class);
  }

  @Override
  @Nullable
  public Expdoclist getExpdoclist() {
    return findChildByClass(Expdoclist.class);
  }

}
