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

public class ImportdeclImpl extends ASTWrapperPsiElement implements Importdecl {

  public ImportdeclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitImportdecl(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MaybePkg getMaybePkg() {
    return findNotNullChildByClass(MaybePkg.class);
  }

  @Override
  @NotNull
  public MaybeSafe getMaybeSafe() {
    return findNotNullChildByClass(MaybeSafe.class);
  }

  @Override
  @NotNull
  public MaybeSrc getMaybeSrc() {
    return findNotNullChildByClass(MaybeSrc.class);
  }

  @Override
  @NotNull
  public Maybeas getMaybeas() {
    return findNotNullChildByClass(Maybeas.class);
  }

  @Override
  @NotNull
  public Maybeimpspec getMaybeimpspec() {
    return findNotNullChildByClass(Maybeimpspec.class);
  }

  @Override
  @NotNull
  public Modid getModid() {
    return findNotNullChildByClass(Modid.class);
  }

  @Override
  @NotNull
  public Optqualified getOptqualified() {
    return findNotNullChildByClass(Optqualified.class);
  }

  @Override
  @NotNull
  public PsiElement getImport() {
    return findNotNullChildByType(IMPORT);
  }

}
