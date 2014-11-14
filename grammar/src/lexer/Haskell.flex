package lexer;

import java.util.*;
import com.intellij.lexer.*;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import generated.GeneratedTypes;

%%

%unicode
%class _KitHaskellLexer
%implements FlexLexer

%{
    private int commentStart;
    private int commentDepth;
%}


%function advance
%type IElementType


%xstate BLOCK_COMMENT, TEX

unispace    = \x05
white_no_nl = [\ \r\t\f]|{unispace}
whitechar   = {white_no_nl}|[\n]
tab         = \t

ascdigit  = [0-9]
unidigit  = \x03
decdigit  = {ascdigit}
digit     = {ascdigit}|{unidigit}

special   = [\(\)\,\;\[\]\`\{\}]
ascsymbol = [\!\#\$\%\&\*\+\.\/\<\=\>\?\@\\\^\|\-\~]
unisymbol = [[\p{P}\p{S}]&&[^(),;\[\]`{}_\"\']]
symbol    = {ascsymbol}|{unisymbol}

large     = [:uppercase:]
ascsmall  = [:lowercase:]
ascLarge  =	[A-Z]
small     = {ascsmall}|"_"

graphic   = {small}|{large}|{symbol}|{digit}|{special}|[\:\"\']

octit     = [0-7]
hexit     = {decdigit}|[A-Fa-f]
symchar   = {symbol}|[\:]
nl        = [\n\r]
idchar      = {small}|{large}|{digit}|[\']

pragmachar = [$small $large $digit]

docsym      = [\| \^ \* \$]



//----- Strings --------

gap        = \\{whitechar}*\\
cntrl      = {ascLarge} | [@\[\\\]\^_]
charesc    = [abfnrtv\\\"\'&]
ascii      = ("^"{cntrl})|(NUL)|(SOH)|(STX)|(ETX)|(EOT)|(ENQ)|(ACK)|(BEL)|(BS)|(HT)|(LF)|(VT)|(FF)|(CR)|(SO)|(SI)|(DLE)|(DC1)|(DC2)|(DC3)|(DC4)|(NAK)|(SYN)|(ETB)|(CAN)|(EM)|(SUB)|(ESC)|(FS)|(GS)|(RS)|(US)|(SP)|(DEL)
escape     = \\({charesc}|{ascii}|({decdigit}+)|(o({octit}+))|(x({hexit}+)))

character  = (\'([^\'\\\n]|{escape})\')
string     = \"([^\"\\\n]|{escape}|{gap})*(\"|\n)

//----- Indent -------

EOL_COMMENT = "--"[^\n]*



%%

<TEX> {
    [^\\]+            { return GeneratedTypes.BLOCK_COMMENT; }
    "\\begin{code}"   { yybegin(YYINITIAL); return GeneratedTypes.BLOCK_COMMENT; }
    \\+*              { return GeneratedTypes.BLOCK_COMMENT; }

}


<BLOCK_COMMENT> {
    "{-" {
         commentDepth++;
    }

    <<EOF>> {
        int state = yystate();
        yybegin(YYINITIAL);
        zzStartRead = commentStart;
        return GeneratedTypes.BLOCK_COMMENT;
    }

    "-}" {
        if (commentDepth > 0) {
            commentDepth--;
        }
        else {
             int state = yystate();
             yybegin(YYINITIAL);
             zzStartRead = commentStart;
             return GeneratedTypes.BLOCK_COMMENT;
        }
    }

    .|{whitechar} {}
}

"{-" {
    yybegin(BLOCK_COMMENT);
    commentDepth = 0;
    commentStart = getTokenStart();
}


{white_no_nl}+        { return TokenType.WHITE_SPACE; }
"\n"                  { return GeneratedTypes.NEW_LINE; }
//{EOL_COMMENT}         { return TokenPackage.getEND_OF_LINE_COMMENT(); }
"{"                   { return GeneratedTypes.OCURLY; }
"}"                   { return GeneratedTypes.CCURLY; }

//"["                   { return TokenPackage.getLEFT_BRACKET(); }
//"]"                   { return TokenPackage.getRIGHT_BRACKET(); }
"("                   { return GeneratedTypes.OPAREN; }
")"                   { return GeneratedTypes.CPAREN; }
//":"                   { return TokenPackage.getCOLON();}
//"::"                  { return TokenPackage.getDOUBLE_COLON(); }
//";"                   { return TokenPackage.getSEMICOLON();}
"."                   { return GeneratedTypes.DOT; }
//".."                  { return TokenPackage.getDOT_DOT(); }
//"$"                   { return TokenPackage.getDOLLAR(); }
//","                   { return TokenPackage.getCOMMA(); }
"="                   { return GeneratedTypes.EQUAL; }
//"|"                   { return TokenPackage.getVERTICAL_BAR();}
//"\\"                  { return TokenPackage.getBACK_SLASH(); }
//"<-"                  { return TokenPackage.getLEFT_ARROW(); }
//(->)|(\u2192)         { return TokenPackage.getRIGHT_ARROW(); }

//"?"                   { return TokenPackage.getQUESTION(); }
//"#"                   { return TokenPackage.getHASH(); }
//"@"                   { return TokenPackage.getAT(); }
//"~"                   { return TokenPackage.getTILDE(); }
//"`"                   { return TokenPackage.getBACKQUOTE(); }
//"=>"                  { return TokenPackage.getDOUBLE_ARROW(); }
//"!"                   { return TokenPackage.getEXCLAMATION(); }
//"_"                   { return TokenPackage.getUNDERSCORE(); }
//":"{symbol}+          { return TokenPackage.getOPERATOR_CONS(); }
//{symbol}+             { return TokenPackage.getOPERATOR_ID(); }

// - Keywords

//"as"                  { return TokenPackage.getAS_KW(); }
//"case"                { return TokenPackage.getCASE_KW(); }
//"class"               { return TokenPackage.getCLASS_KW(); }
//"data"                { return TokenPackage.getDATA_KW(); }
//"default"             { return TokenPackage.getDEFAULT_KW(); }
//"deriving"            { return TokenPackage.getDERIVING_KW(); }
//"do"                  { return TokenPackage.getDO_KW(); }
//"else"                { return TokenPackage.getELSE_KW(); }
//"export"              { return TokenPackage.getEXPORT(); }
//"hiding"              { return TokenPackage.getHIDING_KW(); }
//"if"                  { return TokenPackage.getIF_KW(); }
"import"              { return GeneratedTypes.IMPORT; }
//"in"                  { return TokenPackage.getIN_KW(); }
//"infix"               { return TokenPackage.getINFIX_KW(); }
//"infixl"              { return TokenPackage.getINFIXL_KW(); }
//"infixr"              { return TokenPackage.getINFIXR_KW(); }
//"instance"            { return TokenPackage.getINSTANCE_KW(); }
//("forall")|(\u2200)   { return TokenPackage.getFORALL_KW(); }
//"foreign"             { return TokenPackage.getFOREIGN_KW(); }
//"let"                 { return TokenPackage.getLET_KW(); }
"module"              { return GeneratedTypes.MODULE_T; }
//"newtype"             { return TokenPackage.getNEWTYPE_KW(); }
//"of"                  { return TokenPackage.getOF_KW(); }
//"then"                { return TokenPackage.getTHEN_KW(); }
//"qualified"           { return TokenPackage.getQUALIFIED_KW(); }
//"safe"                { return TokenPackage.getSAFE(); }
//"type"                { return TokenPackage.getTYPE_KW(); }
//"unsafe"              { return TokenPackage.getUNSAFE(); }
"where"               { return GeneratedTypes.WHERE; }
//"{-#".*"#-}"          { return TokenPackage.getPRAGMA(); }
//(0(o|O){octit}*) |
//(0(x|X){hexit}*) |
//({digit}+)            { return TokenPackage.getNUMBER(); }

{character}           { return GeneratedTypes.CHAR; }
{string}              { return GeneratedTypes.STRING;}

//"\\end{code}"         { yybegin(TEX); return TokenPackage.getBLOCK_COMMENT(); }

//"''"                  { return TokenPackage.getTH_TY_QUOTE(); }
//"'"                   { return TokenPackage.getTH_VAR_QUOTE(); }
{large}{idchar}*      { return GeneratedTypes.CONID;}
{small}{idchar}*      { return GeneratedTypes.VARID; }
.                     { return TokenType.BAD_CHARACTER; }