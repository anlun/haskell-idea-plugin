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

  IElementType ASID = new HaskellElementType("as");
  IElementType BLOCK_COMMENT = new HaskellElementType("BLOCK_COMMENT");
  IElementType BYID = new HaskellElementType("by");
  IElementType CAPIID = new HaskellElementType("capi");
  IElementType CASEID = new HaskellElementType("case");
  IElementType CCALLID = new HaskellElementType("ccall");
  IElementType CCURLYID = new HaskellElementType("}");
  IElementType CLASSID = new HaskellElementType("class");
  IElementType CONID = new HaskellElementType("CONID");
  IElementType DATAID = new HaskellElementType("data");
  IElementType DEFAULTID = new HaskellElementType("default");
  IElementType DERIVINGID = new HaskellElementType("deriving");
  IElementType DOID = new HaskellElementType("do");
  IElementType DOT = new HaskellElementType(".");
  IElementType DYNAMICID = new HaskellElementType("dynamic");
  IElementType ELSEID = new HaskellElementType("else");
  IElementType EXPORTID = new HaskellElementType("export");
  IElementType FAMILYID = new HaskellElementType("family");
  IElementType FORALLID = new HaskellElementType("forall");
  IElementType FOREIGNID = new HaskellElementType("foreign");
  IElementType GROUPID = new HaskellElementType("group");
  IElementType HIDINGID = new HaskellElementType("hiding");
  IElementType IFID = new HaskellElementType("if");
  IElementType IMPORTID = new HaskellElementType("import");
  IElementType INFIXID = new HaskellElementType("infix");
  IElementType INFIXLID = new HaskellElementType("infixl");
  IElementType INFIXRID = new HaskellElementType("infixr");
  IElementType INID = new HaskellElementType("in");
  IElementType INSTANCEID = new HaskellElementType("instance");
  IElementType INTERRUPTIBLEID = new HaskellElementType("interruptible");
  IElementType JAVASCRIPTID = new HaskellElementType("javascript");
  IElementType LABELID = new HaskellElementType("label");
  IElementType LETID = new HaskellElementType("let");
  IElementType MDOID = new HaskellElementType("mdo");
  IElementType MODULEID = new HaskellElementType("module");
  IElementType NEWTYPEID = new HaskellElementType("newtype");
  IElementType NEW_LINE = new HaskellElementType("\\n");
  IElementType OCURLYID = new HaskellElementType("{");
  IElementType OFID = new HaskellElementType("of");
  IElementType PATTERNID = new HaskellElementType("pattern");
  IElementType PRIMID = new HaskellElementType("prim");
  IElementType PROCID = new HaskellElementType("proc");
  IElementType QUALIFIEDID = new HaskellElementType("qualified");
  IElementType RECID = new HaskellElementType("rec");
  IElementType ROLEID = new HaskellElementType("role");
  IElementType SAFEID = new HaskellElementType("safe");
  IElementType STDCALLID = new HaskellElementType("stdcall");
  IElementType THENID = new HaskellElementType("then");
  IElementType TYPEID = new HaskellElementType("type");
  IElementType UNDERSCOREID = new HaskellElementType("_");
  IElementType UNSAFEID = new HaskellElementType("unsafe");
  IElementType USINGID = new HaskellElementType("using");
  IElementType VARID = new HaskellElementType("VARID");
  IElementType VCCURLY = new HaskellElementType("vccurly");
  IElementType VOCURLY = new HaskellElementType("vocurly");
  IElementType VSEMICOLON = new HaskellElementType("vsemicolon");
  IElementType WHEREID = new HaskellElementType("where");

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
