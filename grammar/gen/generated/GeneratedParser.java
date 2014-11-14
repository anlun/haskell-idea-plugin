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
    else if (root_ == DECL) {
      result_ = decl(builder_, 0);
    }
    else if (root_ == EXP_DOC) {
      result_ = exp_doc(builder_, 0);
    }
    else if (root_ == EXPDOCLIST) {
      result_ = expdoclist(builder_, 0);
    }
    else if (root_ == EXPORT) {
      result_ = export(builder_, 0);
    }
    else if (root_ == EXPORT_SUBSPEC) {
      result_ = export_subspec(builder_, 0);
    }
    else if (root_ == EXPORTLIST) {
      result_ = exportlist(builder_, 0);
    }
    else if (root_ == EXPORTLIST_1) {
      result_ = exportlist1(builder_, 0);
    }
    else if (root_ == LHS) {
      result_ = lhs(builder_, 0);
    }
    else if (root_ == MODID) {
      result_ = modid(builder_, 0);
    }
    else if (root_ == MODULE) {
      result_ = module(builder_, 0);
    }
    else if (root_ == QCNAME) {
      result_ = qcname(builder_, 0);
    }
    else if (root_ == QCNAME_EXT) {
      result_ = qcname_ext(builder_, 0);
    }
    else if (root_ == QCNAMES) {
      result_ = qcnames(builder_, 0);
    }
    else if (root_ == QCON) {
      result_ = qcon(builder_, 0);
    }
    else if (root_ == QVAR) {
      result_ = qvar(builder_, 0);
    }
    else if (root_ == REST) {
      result_ = rest(builder_, 0);
    }
    else if (root_ == RHS) {
      result_ = rhs(builder_, 0);
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
  // vocurly decl* vccurly
  public static boolean body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "body")) return false;
    if (!nextTokenIs(builder_, VOCURLY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VOCURLY);
    result_ = result_ && body_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VCCURLY);
    exit_section_(builder_, marker_, BODY, result_);
    return result_;
  }

  // decl*
  private static boolean body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "body_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!decl(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "body_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // lhs '=' rhs
  public static boolean decl(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "decl")) return false;
    if (!nextTokenIs(builder_, VARID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = lhs(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQUAL);
    result_ = result_ && rhs(builder_, level_ + 1);
    exit_section_(builder_, marker_, DECL, result_);
    return result_;
  }

  /* ********************************************************** */
  // docsection
  //         | docnamed
  //         | docnext
  public static boolean exp_doc(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exp_doc")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<exp doc>");
    result_ = consumeToken(builder_, DOCSECTION);
    if (!result_) result_ = consumeToken(builder_, DOCNAMED);
    if (!result_) result_ = consumeToken(builder_, DOCNEXT);
    exit_section_(builder_, level_, marker_, EXP_DOC, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (exp_doc expdoclist)?
  public static boolean expdoclist(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expdoclist")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expdoclist>");
    expdoclist_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPDOCLIST, true, false, null);
    return true;
  }

  // exp_doc expdoclist
  private static boolean expdoclist_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expdoclist_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = exp_doc(builder_, level_ + 1);
    result_ = result_ && expdoclist(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // qcname_ext export_subspec?
  //         |  'module' modid
  //         |  'pattern' qcon
  public static boolean export(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<export>");
    result_ = export_0(builder_, level_ + 1);
    if (!result_) result_ = export_1(builder_, level_ + 1);
    if (!result_) result_ = export_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPORT, result_, false, null);
    return result_;
  }

  // qcname_ext export_subspec?
  private static boolean export_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = qcname_ext(builder_, level_ + 1);
    result_ = result_ && export_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // export_subspec?
  private static boolean export_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_0_1")) return false;
    export_subspec(builder_, level_ + 1);
    return true;
  }

  // 'module' modid
  private static boolean export_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MODULE_T);
    result_ = result_ && modid(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // 'pattern' qcon
  private static boolean export_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PATTERN);
    result_ = result_ && qcon(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '(' '..' ')'
  //         | '(' ')'
  //         | '(' qcnames ')'
  public static boolean export_subspec(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_subspec")) return false;
    if (!nextTokenIs(builder_, OPAREN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = export_subspec_0(builder_, level_ + 1);
    if (!result_) result_ = export_subspec_1(builder_, level_ + 1);
    if (!result_) result_ = export_subspec_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, EXPORT_SUBSPEC, result_);
    return result_;
  }

  // '(' '..' ')'
  private static boolean export_subspec_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_subspec_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPAREN);
    result_ = result_ && consumeToken(builder_, DOTDOT);
    result_ = result_ && consumeToken(builder_, CPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '(' ')'
  private static boolean export_subspec_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_subspec_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPAREN);
    result_ = result_ && consumeToken(builder_, CPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '(' qcnames ')'
  private static boolean export_subspec_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_subspec_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPAREN);
    result_ = result_ && qcnames(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // expdoclist ',' expdoclist
  //         | exportlist1
  public static boolean exportlist(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exportlist")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<exportlist>");
    result_ = exportlist_0(builder_, level_ + 1);
    if (!result_) result_ = exportlist1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPORTLIST, result_, false, null);
    return result_;
  }

  // expdoclist ',' expdoclist
  private static boolean exportlist_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exportlist_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = expdoclist(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ",");
    result_ = result_ && expdoclist(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // expdoclist export expdoclist ',' exportlist1
  //         | expdoclist export expdoclist
  //         | expdoclist
  public static boolean exportlist1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exportlist1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<exportlist 1>");
    result_ = exportlist1_0(builder_, level_ + 1);
    if (!result_) result_ = exportlist1_1(builder_, level_ + 1);
    if (!result_) result_ = expdoclist(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPORTLIST_1, result_, false, null);
    return result_;
  }

  // expdoclist export expdoclist ',' exportlist1
  private static boolean exportlist1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exportlist1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = expdoclist(builder_, level_ + 1);
    result_ = result_ && export(builder_, level_ + 1);
    result_ = result_ && expdoclist(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ",");
    result_ = result_ && exportlist1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expdoclist export expdoclist
  private static boolean exportlist1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exportlist1_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = expdoclist(builder_, level_ + 1);
    result_ = result_ && export(builder_, level_ + 1);
    result_ = result_ && expdoclist(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARID
  public static boolean lhs(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lhs")) return false;
    if (!nextTokenIs(builder_, VARID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VARID);
    exit_section_(builder_, marker_, LHS, result_);
    return result_;
  }

  /* ********************************************************** */
  // ('(' exportlist ')')?
  static boolean maybeexports(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "maybeexports")) return false;
    maybeexports_0(builder_, level_ + 1);
    return true;
  }

  // '(' exportlist ')'
  private static boolean maybeexports_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "maybeexports_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPAREN);
    result_ = result_ && exportlist(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CPAREN);
    exit_section_(builder_, marker_, null, result_);
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
  // 'module' modid maybeexports 'where' body? rest?
  public static boolean module(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module")) return false;
    if (!nextTokenIs(builder_, MODULE_T)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MODULE_T);
    result_ = result_ && modid(builder_, level_ + 1);
    result_ = result_ && maybeexports(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, WHERE);
    result_ = result_ && module_4(builder_, level_ + 1);
    result_ = result_ && module_5(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODULE, result_);
    return result_;
  }

  // body?
  private static boolean module_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_4")) return false;
    body(builder_, level_ + 1);
    return true;
  }

  // rest?
  private static boolean module_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_5")) return false;
    rest(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // qvar
  //         |  qcon
  public static boolean qcname(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcname")) return false;
    if (!nextTokenIs(builder_, "<qcname>", CONID, VARID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<qcname>");
    result_ = qvar(builder_, level_ + 1);
    if (!result_) result_ = qcon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, QCNAME, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // qcname
  //         |  'type' qcname
  public static boolean qcname_ext(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcname_ext")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<qcname ext>");
    result_ = qcname(builder_, level_ + 1);
    if (!result_) result_ = qcname_ext_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, QCNAME_EXT, result_, false, null);
    return result_;
  }

  // 'type' qcname
  private static boolean qcname_ext_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcname_ext_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TYPE);
    result_ = result_ && qcname(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // qcname_ext ',' qcnames
  //         |  qcname_ext
  public static boolean qcnames(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcnames")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<qcnames>");
    result_ = qcnames_0(builder_, level_ + 1);
    if (!result_) result_ = qcname_ext(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, QCNAMES, result_, false, null);
    return result_;
  }

  // qcname_ext ',' qcnames
  private static boolean qcnames_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcnames_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = qcname_ext(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ",");
    result_ = result_ && qcnames(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (modid '.')? CONID
  public static boolean qcon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcon")) return false;
    if (!nextTokenIs(builder_, CONID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = qcon_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CONID);
    exit_section_(builder_, marker_, QCON, result_);
    return result_;
  }

  // (modid '.')?
  private static boolean qcon_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcon_0")) return false;
    qcon_0_0(builder_, level_ + 1);
    return true;
  }

  // modid '.'
  private static boolean qcon_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qcon_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = modid(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, DOT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (modid '.')? VARID
  public static boolean qvar(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qvar")) return false;
    if (!nextTokenIs(builder_, "<qvar>", CONID, VARID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<qvar>");
    result_ = qvar_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VARID);
    exit_section_(builder_, level_, marker_, QVAR, result_, false, null);
    return result_;
  }

  // (modid '.')?
  private static boolean qvar_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qvar_0")) return false;
    qvar_0_0(builder_, level_ + 1);
    return true;
  }

  // modid '.'
  private static boolean qvar_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "qvar_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = modid(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, DOT);
    exit_section_(builder_, marker_, null, result_);
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
  // (VARID | STRING)+
  public static boolean rhs(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rhs")) return false;
    if (!nextTokenIs(builder_, "<rhs>", STRING, VARID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<rhs>");
    result_ = rhs_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!rhs_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "rhs", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, RHS, result_, false, null);
    return result_;
  }

  // VARID | STRING
  private static boolean rhs_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rhs_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VARID);
    if (!result_) result_ = consumeToken(builder_, STRING);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // module
  static boolean root(PsiBuilder builder_, int level_) {
    return module(builder_, level_ + 1);
  }

}
