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

public class ExportImpl extends ASTWrapperPsiElement implements Export {

  public ExportImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitExport(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ExportSubspec getExportSubspec() {
    return findChildByClass(ExportSubspec.class);
  }

  @Override
  @Nullable
  public Modid getModid() {
    return findChildByClass(Modid.class);
  }

  @Override
  @Nullable
  public QcnameExt getQcnameExt() {
    return findChildByClass(QcnameExt.class);
  }

  @Override
  @Nullable
  public Qcon getQcon() {
    return findChildByClass(Qcon.class);
  }

  @Override
  @Nullable
  public PsiElement getModuleT() {
    return findChildByType(MODULE_T);
  }

  @Override
  @Nullable
  public PsiElement getPattern() {
    return findChildByType(PATTERN);
  }

}
