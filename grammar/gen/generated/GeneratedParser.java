// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static generated.GeneratedTypes.*;
import static generated.HaskellParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GeneratedParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("generated.GeneratedParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == QCONID) {
      result_ = QCONID(builder_, 0);
    }
    else if (root_ == ANY) {
      result_ = any(builder_, 0);
    }
    else if (root_ == BODY) {
      result_ = body(builder_, 0);
    }
    else if (root_ == MODID) {
      result_ = modid(builder_, 0);
    }
    else if (root_ == MODULE) {
      result_ = module(builder_, 0);
    }
    else if (root_ == REST) {
      result_ = rest(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return root(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // (CONID '.')* CONID
  public static boolean QCONID(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "QCONID")) return false;
    if (!nextTokenIs(builder_, CONID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = QCONID_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CONID);
    exit_section_(builder_, marker_, QCONID, result_);
    return result_;
  }

  // (CONID '.')*
  private static boolean QCONID_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "QCONID_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!QCONID_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "QCONID_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // CONID '.'
  private static boolean QCONID_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "QCONID_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CONID);
    result_ = result_ && consumeToken(builder_, DOT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // !<<eof>>
  public static boolean any(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, "<any>");
    result_ = !eof(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ANY, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // rest
  public static boolean body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "body")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<body>");
    result_ = rest(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, BODY, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // CONID
  //         | QCONID
  public static boolean modid(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modid")) return false;
    if (!nextTokenIs(builder_, CONID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CONID);
    if (!result_) result_ = QCONID(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODID, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'module' modid 'where' body
  public static boolean module(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module")) return false;
    if (!nextTokenIs(builder_, MODULE_T)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MODULE_T);
    result_ = result_ && modid(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, WHERE);
    result_ = result_ && body(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODULE, result_);
    return result_;
  }

  /* ********************************************************** */
  // any*
  public static boolean rest(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rest")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<rest>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!any(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "rest", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, REST, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // module
  static boolean root(PsiBuilder builder_, int level_) {
    return module(builder_, level_ + 1);
  }

}
