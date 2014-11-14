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

public class ExportlistImpl extends ASTWrapperPsiElement implements Exportlist {

  public ExportlistImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitExportlist(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Expdoclist> getExpdoclistList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expdoclist.class);
  }

  @Override
  @Nullable
  public Exportlist1 getExportlist1() {
    return findChildByClass(Exportlist1.class);
  }

}
