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
  IElementType MODID = new HaskellToken("MODID");
  IElementType MODULE = new HaskellToken("MODULE");
  IElementType QCONID = new HaskellToken("QCONID");
  IElementType REST = new HaskellToken("REST");

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
  IElementType DATA = new HaskellElementType("data");
  IElementType DCOLON = new HaskellElementType("::");
  IElementType DEFAULT = new HaskellElementType("default");
  IElementType DERIVING = new HaskellElementType("deriving");
  IElementType DO = new HaskellElementType("do");
  IElementType DOT = new HaskellElementType(".");
  IElementType DOTDOT = new HaskellElementType("..");
  IElementType DYNAMIC = new HaskellElementType("dynamic");
  IElementType ELSE = new HaskellElementType("else");
  IElementType EQUAL = new HaskellElementType("=");
  IElementType EXPORT = new HaskellElementType("export");
  IElementType FAMILY = new HaskellElementType("family");
  IElementType FORALL = new HaskellElementType("forall");
  IElementType FOREIGN = new HaskellElementType("foreign");
  IElementType GROUP = new HaskellElementType("group");
  IElementType HIDING = new HaskellElementType("hiding");
  IElementType IF = new HaskellElementType("if");
  IElementType IMPORT = new HaskellElementType("import");
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
  IElementType MDO = new HaskellElementType("mdo");
  IElementType MODULE_T = new HaskellElementType("module");
  IElementType NEWTYPE = new HaskellElementType("newtype");
  IElementType NEW_LINE = new HaskellElementType("\\n");
  IElementType OCURLY = new HaskellElementType("{");
  IElementType OF = new HaskellElementType("of");
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
      else if (type == MODID) {
        return new ModidImpl(node);
      }
      else if (type == MODULE) {
        return new ModuleImpl(node);
      }
      else if (type == QCONID) {
        return new QconidImpl(node);
      }
      else if (type == REST) {
        return new RestImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
