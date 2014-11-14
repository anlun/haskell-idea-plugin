// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.haskell.parser.HaskellToken;
import org.jetbrains.haskell.parser.HaskellElementType;
import generated.psi.impl.*;

public interface GeneratedTypes {

  IElementType ANY = new HaskellToken("ANY");
  IElementType BODY = new HaskellToken("BODY");
  IElementType DECL = new HaskellToken("DECL");
  IElementType EXPDOCLIST = new HaskellToken("EXPDOCLIST");
  IElementType EXPORT = new HaskellToken("EXPORT");
  IElementType EXPORTLIST = new HaskellToken("EXPORTLIST");
  IElementType EXPORTLIST_1 = new HaskellToken("EXPORTLIST_1");
  IElementType EXPORT_SUBSPEC = new HaskellToken("EXPORT_SUBSPEC");
  IElementType EXP_DOC = new HaskellToken("EXP_DOC");
  IElementType IMPORTDECL = new HaskellToken("IMPORTDECL");
  IElementType IMPORTDECLS = new HaskellToken("IMPORTDECLS");
  IElementType IMPSPEC = new HaskellToken("IMPSPEC");
  IElementType LHS = new HaskellToken("LHS");
  IElementType MAYBEAS = new HaskellToken("MAYBEAS");
  IElementType MAYBEIMPSPEC = new HaskellToken("MAYBEIMPSPEC");
  IElementType MAYBE_PKG = new HaskellToken("MAYBE_PKG");
  IElementType MAYBE_SAFE = new HaskellToken("MAYBE_SAFE");
  IElementType MAYBE_SRC = new HaskellToken("MAYBE_SRC");
  IElementType MODID = new HaskellToken("MODID");
  IElementType MODULE = new HaskellToken("MODULE");
  IElementType OPTQUALIFIED = new HaskellToken("OPTQUALIFIED");
  IElementType QCNAME = new HaskellToken("QCNAME");
  IElementType QCNAMES = new HaskellToken("QCNAMES");
  IElementType QCNAME_EXT = new HaskellToken("QCNAME_EXT");
  IElementType QCON = new HaskellToken("QCON");
  IElementType QCONID = new HaskellToken("QCONID");
  IElementType QVAR = new HaskellToken("QVAR");
  IElementType REST = new HaskellToken("REST");
  IElementType RHS = new HaskellToken("RHS");

  IElementType AS = new HaskellElementType("as");
  IElementType BLOCK_COMMENT = new HaskellElementType("BLOCK_COMMENT");
  IElementType BY = new HaskellElementType("by");
  IElementType CAPI = new HaskellElementType("capi");
  IElementType CASE = new HaskellElementType("case");
  IElementType CCALL = new HaskellElementType("ccall");
  IElementType CCURLY = new HaskellElementType("}");
  IElementType CHAR = new HaskellElementType("char");
  IElementType CLASS = new HaskellElementType("class");
  IElementType COLON = new HaskellElementType(":");
  IElementType CONID = new HaskellElementType("CONID");
  IElementType CPAREN = new HaskellElementType(")");
  IElementType DATA = new HaskellElementType("data");
  IElementType DCOLON = new HaskellElementType("::");
  IElementType DEFAULT = new HaskellElementType("default");
  IElementType DERIVING = new HaskellElementType("deriving");
  IElementType DO = new HaskellElementType("do");
  IElementType DOCNAMED = new HaskellElementType("docnamed");
  IElementType DOCNEXT = new HaskellElementType("docnext");
  IElementType DOCSECTION = new HaskellElementType("docsection");
  IElementType DOT = new HaskellElementType(".");
  IElementType DOTDOT = new HaskellElementType("..");
  IElementType DYNAMIC = new HaskellElementType("dynamic");
  IElementType ELSE = new HaskellElementType("else");
  IElementType EQUAL = new HaskellElementType("=");
  IElementType EXPORT_T = new HaskellElementType("export");
  IElementType FAMILY = new HaskellElementType("family");
  IElementType FORALL = new HaskellElementType("forall");
  IElementType FOREIGN = new HaskellElementType("foreign");
  IElementType GROUP = new HaskellElementType("group");
  IElementType HIDING = new HaskellElementType("hiding");
  IElementType IF = new HaskellElementType("if");
  IElementType IMPORT = new HaskellElementType("import");
  IElementType IMPORTDECLS_3_0 = new HaskellElementType("importdecls_3_0");
  IElementType IN = new HaskellElementType("in");
  IElementType INFIX = new HaskellElementType("infix");
  IElementType INFIXL = new HaskellElementType("infixl");
  IElementType INFIXR = new HaskellElementType("infixr");
  IElementType INSTANCE = new HaskellElementType("instance");
  IElementType INTERRUPTIBLE = new HaskellElementType("interruptible");
  IElementType JAVASCRIPT = new HaskellElementType("javascript");
  IElementType LABEL = new HaskellElementType("label");
  IElementType LAM = new HaskellElementType("\\\\");
  IElementType LET = new HaskellElementType("let");
  IElementType MAYBEAS_1_0 = new HaskellElementType("maybeas_1_0");
  IElementType MAYBEIMPSPEC_1_0 = new HaskellElementType("maybeimpspec_1_0");
  IElementType MAYBE_PKG_1_0 = new HaskellElementType("maybe_pkg_1_0");
  IElementType MAYBE_SAFE_1_0 = new HaskellElementType("maybe_safe_1_0");
  IElementType MAYBE_SRC_1_0 = new HaskellElementType("maybe_src_1_0");
  IElementType MDO = new HaskellElementType("mdo");
  IElementType MODULE_T = new HaskellElementType("module");
  IElementType NEWTYPE = new HaskellElementType("newtype");
  IElementType NEW_LINE = new HaskellElementType("\\n");
  IElementType OCURLY = new HaskellElementType("{");
  IElementType OF = new HaskellElementType("of");
  IElementType OPAREN = new HaskellElementType("(");
  IElementType OPTQUALIFIED_1_0 = new HaskellElementType("optqualified_1_0");
  IElementType PATTERN = new HaskellElementType("pattern");
  IElementType PRIM = new HaskellElementType("prim");
  IElementType PROC = new HaskellElementType("proc");
  IElementType QUALIFIED = new HaskellElementType("qualified");
  IElementType REC = new HaskellElementType("rec");
  IElementType ROLE = new HaskellElementType("role");
  IElementType SAFE = new HaskellElementType("safe");
  IElementType STDCALL = new HaskellElementType("stdcall");
  IElementType STRING = new HaskellElementType("string");
  IElementType THEN = new HaskellElementType("then");
  IElementType TYPE = new HaskellElementType("type");
  IElementType UNDERSCORE = new HaskellElementType("_");
  IElementType UNSAFE = new HaskellElementType("unsafe");
  IElementType USING = new HaskellElementType("using");
  IElementType VARID = new HaskellElementType("VARID");
  IElementType VCCURLY = new HaskellElementType("vccurly");
  IElementType VOCURLY = new HaskellElementType("vocurly");
  IElementType VSEMICOLON = new HaskellElementType("vsemicolon");
  IElementType WHERE = new HaskellElementType("where");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ANY) {
        return new AnyImpl(node);
      }
      else if (type == BODY) {
        return new BodyImpl(node);
      }
      else if (type == DECL) {
        return new DeclImpl(node);
      }
      else if (type == EXPDOCLIST) {
        return new ExpdoclistImpl(node);
      }
      else if (type == EXPORT) {
        return new ExportImpl(node);
      }
      else if (type == EXPORTLIST) {
        return new ExportlistImpl(node);
      }
      else if (type == EXPORTLIST_1) {
        return new Exportlist1Impl(node);
      }
      else if (type == EXPORT_SUBSPEC) {
        return new ExportSubspecImpl(node);
      }
      else if (type == EXP_DOC) {
        return new ExpDocImpl(node);
      }
      else if (type == IMPORTDECL) {
        return new ImportdeclImpl(node);
      }
      else if (type == IMPORTDECLS) {
        return new ImportdeclsImpl(node);
      }
      else if (type == IMPSPEC) {
        return new ImpspecImpl(node);
      }
      else if (type == LHS) {
        return new LhsImpl(node);
      }
      else if (type == MAYBEAS) {
        return new MaybeasImpl(node);
      }
      else if (type == MAYBEIMPSPEC) {
        return new MaybeimpspecImpl(node);
      }
      else if (type == MAYBE_PKG) {
        return new MaybePkgImpl(node);
      }
      else if (type == MAYBE_SAFE) {
        return new MaybeSafeImpl(node);
      }
      else if (type == MAYBE_SRC) {
        return new MaybeSrcImpl(node);
      }
      else if (type == MODID) {
        return new ModidImpl(node);
      }
      else if (type == MODULE) {
        return new ModuleImpl(node);
      }
      else if (type == OPTQUALIFIED) {
        return new OptqualifiedImpl(node);
      }
      else if (type == QCNAME) {
        return new QcnameImpl(node);
      }
      else if (type == QCNAMES) {
        return new QcnamesImpl(node);
      }
      else if (type == QCNAME_EXT) {
        return new QcnameExtImpl(node);
      }
      else if (type == QCON) {
        return new QconImpl(node);
      }
      else if (type == QCONID) {
        return new QconidImpl(node);
      }
      else if (type == QVAR) {
        return new QvarImpl(node);
      }
      else if (type == REST) {
        return new RestImpl(node);
      }
      else if (type == RHS) {
        return new RhsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
