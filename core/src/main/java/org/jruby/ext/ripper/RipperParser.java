// created by jay 1.0.2 (c) 2002-2004 ats@cs.rit.edu
// skeleton Java 1.0 (c) 2002 ats@cs.rit.edu

					// line 2 "RipperParser.y"
/*
 ***** BEGIN LICENSE BLOCK *****
 * Version: EPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Eclipse Public
 * License Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/epl-v20.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2013-2017 The JRuby Team (jruby@jruby.org)
 * 
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the EPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the EPL, the GPL or the LGPL.
 ***** END LICENSE BLOCK *****/

package org.jruby.ext.ripper;

import org.jruby.RubyArray;
import org.jruby.lexer.LexerSource;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;
import static org.jruby.lexer.LexingCommon.EXPR_BEG;
import static org.jruby.lexer.LexingCommon.EXPR_FITEM;
import static org.jruby.lexer.LexingCommon.EXPR_FNAME;
import static org.jruby.lexer.LexingCommon.EXPR_ENDFN;
import static org.jruby.lexer.LexingCommon.EXPR_ENDARG;
import static org.jruby.lexer.LexingCommon.EXPR_END;
import static org.jruby.lexer.LexingCommon.EXPR_LABEL;

public class RipperParser extends RipperParserBase {
    public RipperParser(ThreadContext context, IRubyObject ripper, LexerSource source) {
        super(context, ripper, source);
    }
					// line 53 "-"
  // %token constants
  public static final int keyword_class = 257;
  public static final int keyword_module = 258;
  public static final int keyword_def = 259;
  public static final int keyword_undef = 260;
  public static final int keyword_begin = 261;
  public static final int keyword_rescue = 262;
  public static final int keyword_ensure = 263;
  public static final int keyword_end = 264;
  public static final int keyword_if = 265;
  public static final int keyword_unless = 266;
  public static final int keyword_then = 267;
  public static final int keyword_elsif = 268;
  public static final int keyword_else = 269;
  public static final int keyword_case = 270;
  public static final int keyword_when = 271;
  public static final int keyword_while = 272;
  public static final int keyword_until = 273;
  public static final int keyword_for = 274;
  public static final int keyword_break = 275;
  public static final int keyword_next = 276;
  public static final int keyword_redo = 277;
  public static final int keyword_retry = 278;
  public static final int keyword_in = 279;
  public static final int keyword_do = 280;
  public static final int keyword_do_cond = 281;
  public static final int keyword_do_block = 282;
  public static final int keyword_return = 283;
  public static final int keyword_yield = 284;
  public static final int keyword_super = 285;
  public static final int keyword_self = 286;
  public static final int keyword_nil = 287;
  public static final int keyword_true = 288;
  public static final int keyword_false = 289;
  public static final int keyword_and = 290;
  public static final int keyword_or = 291;
  public static final int keyword_not = 292;
  public static final int modifier_if = 293;
  public static final int modifier_unless = 294;
  public static final int modifier_while = 295;
  public static final int modifier_until = 296;
  public static final int modifier_rescue = 297;
  public static final int keyword_alias = 298;
  public static final int keyword_defined = 299;
  public static final int keyword_BEGIN = 300;
  public static final int keyword_END = 301;
  public static final int keyword__LINE__ = 302;
  public static final int keyword__FILE__ = 303;
  public static final int keyword__ENCODING__ = 304;
  public static final int keyword_do_lambda = 305;
  public static final int tIDENTIFIER = 306;
  public static final int tFID = 307;
  public static final int tGVAR = 308;
  public static final int tIVAR = 309;
  public static final int tCONSTANT = 310;
  public static final int tCVAR = 311;
  public static final int tLABEL = 312;
  public static final int tCHAR = 313;
  public static final int tUPLUS = 314;
  public static final int tUMINUS = 315;
  public static final int tUMINUS_NUM = 316;
  public static final int tPOW = 317;
  public static final int tCMP = 318;
  public static final int tEQ = 319;
  public static final int tEQQ = 320;
  public static final int tNEQ = 321;
  public static final int tGEQ = 322;
  public static final int tLEQ = 323;
  public static final int tANDOP = 324;
  public static final int tOROP = 325;
  public static final int tMATCH = 326;
  public static final int tNMATCH = 327;
  public static final int tDOT = 328;
  public static final int tDOT2 = 329;
  public static final int tDOT3 = 330;
  public static final int tAREF = 331;
  public static final int tASET = 332;
  public static final int tLSHFT = 333;
  public static final int tRSHFT = 334;
  public static final int tANDDOT = 335;
  public static final int tCOLON2 = 336;
  public static final int tCOLON3 = 337;
  public static final int tOP_ASGN = 338;
  public static final int tASSOC = 339;
  public static final int tLPAREN = 340;
  public static final int tLPAREN2 = 341;
  public static final int tRPAREN = 342;
  public static final int tLPAREN_ARG = 343;
  public static final int tLBRACK = 344;
  public static final int tRBRACK = 345;
  public static final int tLBRACE = 346;
  public static final int tLBRACE_ARG = 347;
  public static final int tSTAR = 348;
  public static final int tSTAR2 = 349;
  public static final int tAMPER = 350;
  public static final int tAMPER2 = 351;
  public static final int tTILDE = 352;
  public static final int tPERCENT = 353;
  public static final int tDIVIDE = 354;
  public static final int tPLUS = 355;
  public static final int tMINUS = 356;
  public static final int tLT = 357;
  public static final int tGT = 358;
  public static final int tPIPE = 359;
  public static final int tBANG = 360;
  public static final int tCARET = 361;
  public static final int tLCURLY = 362;
  public static final int tRCURLY = 363;
  public static final int tBACK_REF2 = 364;
  public static final int tSYMBEG = 365;
  public static final int tSTRING_BEG = 366;
  public static final int tXSTRING_BEG = 367;
  public static final int tREGEXP_BEG = 368;
  public static final int tWORDS_BEG = 369;
  public static final int tQWORDS_BEG = 370;
  public static final int tSTRING_DBEG = 371;
  public static final int tSTRING_DVAR = 372;
  public static final int tSTRING_END = 373;
  public static final int tLAMBDA = 374;
  public static final int tLAMBEG = 375;
  public static final int tNTH_REF = 376;
  public static final int tBACK_REF = 377;
  public static final int tSTRING_CONTENT = 378;
  public static final int tINTEGER = 379;
  public static final int tIMAGINARY = 380;
  public static final int tFLOAT = 381;
  public static final int tRATIONAL = 382;
  public static final int tREGEXP_END = 383;
  public static final int tIGNORED_NL = 384;
  public static final int tCOMMENT = 385;
  public static final int tEMBDOC_BEG = 386;
  public static final int tEMBDOC = 387;
  public static final int tEMBDOC_END = 388;
  public static final int tSP = 389;
  public static final int tHEREDOC_BEG = 390;
  public static final int tHEREDOC_END = 391;
  public static final int tSYMBOLS_BEG = 392;
  public static final int tQSYMBOLS_BEG = 393;
  public static final int tDSTAR = 394;
  public static final int tSTRING_DEND = 395;
  public static final int tLABEL_END = 396;
  public static final int tLOWEST = 397;
  public static final int k__END__ = 398;
  public static final int yyErrorCode = 256;

  /** number of final state.
    */
  protected static final int yyFinal = 1;

  /** parser tables.
      Order is mandated by <i>jay</i>.
    */
  protected static final short[] yyLhs = {
//yyLhs 656
    -1,   156,     0,   139,   140,   140,   140,   140,   141,   141,
   155,   159,    37,    37,    36,    38,    38,    38,    38,    44,
   160,    44,   161,    39,    39,    39,    39,    39,    39,    39,
    39,    39,    39,    39,    39,    39,    39,    39,    39,    31,
    31,    31,    31,    31,    31,    31,    31,    61,    61,    61,
    40,    40,    40,    40,    40,    40,    45,    32,    32,    60,
    60,   113,   148,    43,    43,    43,    43,    43,    43,    43,
    43,    43,    43,    43,   116,   116,   127,   127,   117,   117,
   117,   117,   117,   117,   117,   117,   117,   117,    74,    74,
   103,   103,   104,   104,    75,    75,    75,    75,    75,    75,
    75,    75,    75,    75,    75,    75,    75,    75,    75,    75,
    75,    75,    75,    80,    80,    80,    80,    80,    80,    80,
    80,    80,    80,    80,    80,    80,    80,    80,    80,    80,
    80,    80,     8,     8,    30,    30,    30,     7,     7,     7,
     7,     7,   120,   120,   121,   121,    64,   163,    64,     6,
     6,     6,     6,     6,     6,     6,     6,     6,     6,     6,
     6,     6,     6,     6,     6,     6,     6,     6,     6,     6,
     6,     6,     6,     6,     6,     6,     6,     6,   134,   134,
   134,   134,   134,   134,   134,   134,   134,   134,   134,   134,
   134,   134,   134,   134,   134,   134,   134,   134,   134,   134,
   134,   134,   134,   134,   134,   134,   134,   134,   134,   134,
   134,   134,   134,   134,   134,   134,   134,   134,   134,   134,
   134,   134,   134,   134,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,   136,   136,   136,   136,    51,
    51,    76,    79,    79,    79,    79,    62,    62,    54,    58,
    58,   130,   130,   130,   130,   130,    52,    52,    52,    52,
    52,   165,    56,   107,   106,   106,    82,    82,    82,    82,
    35,    35,    73,    73,    73,    42,    42,    42,    42,    42,
    42,    42,    42,    42,    42,    42,   166,    42,   167,    42,
   168,   169,    42,    42,    42,    42,    42,    42,    42,    42,
    42,    42,    42,    42,    42,    42,    42,    42,    42,    42,
    42,   170,   171,    42,   172,   173,    42,    42,    42,   174,
   175,    42,   176,    42,   178,    42,   179,    42,   180,    42,
   181,   182,    42,    42,    42,    42,    42,    46,   152,   154,
   153,   151,   150,   150,   150,   149,   149,    49,    49,    47,
    47,   129,   129,   131,   131,    87,    87,   132,   132,   132,
   132,   132,   132,   132,   132,   132,    94,    94,    94,    94,
    93,    93,    69,    69,    69,    69,    69,    69,    69,    69,
    69,    69,    69,    69,    69,    69,    69,    71,    71,    70,
    70,    70,   124,   124,   123,   123,   133,   133,   183,   184,
   126,    68,    68,   125,   125,   112,    59,    59,    59,    59,
    22,    22,    22,    22,    22,    22,    22,    22,    22,   111,
   111,   185,   114,   186,   115,    77,    48,    48,   118,   118,
    78,    78,    78,    50,    50,    53,    53,    28,    28,    28,
    15,    16,    16,    16,    17,    18,    19,    25,    84,    84,
    27,    27,    90,    88,    88,    26,    91,    83,    83,    89,
    89,    20,    20,    21,    21,    24,    24,    23,   187,    23,
   188,   189,   190,   191,   192,    23,    65,    65,    65,    65,
     2,     1,     1,     1,     1,    29,    33,    33,    34,    34,
    34,    34,    57,    57,    57,    57,    57,    57,    57,    57,
    57,    57,    57,    57,   119,   119,   119,   119,   119,   119,
   119,   119,   119,   119,   119,   119,    66,    66,   193,    55,
    55,    72,   194,    72,    95,    95,    95,    95,    92,    92,
    67,    67,    67,    67,    67,    67,    67,    67,    67,    67,
    67,    67,    67,    67,    67,   135,   135,   135,   135,     9,
     9,   147,   122,   122,    85,    85,   144,    96,    96,    97,
    97,    98,    98,    99,    99,   142,   142,   143,   143,    63,
   128,   105,   105,    86,    86,    10,    10,    13,    13,    12,
    12,   110,   109,   109,    14,   195,    14,   100,   100,   101,
   101,   102,   102,   102,   102,     3,     3,     3,     4,     4,
     4,     4,     5,     5,     5,    11,    11,   145,   145,   146,
   146,   157,   157,   162,   162,   137,   138,   164,   164,   164,
   177,   177,   158,   158,    81,   108,
    }, yyLen = {
//yyLen 656
     2,     0,     2,     2,     1,     1,     3,     2,     1,     2,
     3,     0,     6,     3,     2,     1,     1,     3,     2,     1,
     0,     3,     0,     4,     3,     3,     3,     2,     3,     3,
     3,     3,     3,     4,     1,     3,     3,     3,     1,     3,
     3,     6,     5,     5,     5,     5,     3,     1,     3,     1,
     1,     3,     3,     3,     2,     1,     1,     1,     1,     1,
     4,     3,     1,     2,     3,     4,     5,     4,     5,     2,
     2,     2,     2,     2,     1,     3,     1,     3,     1,     2,
     3,     5,     2,     4,     2,     4,     1,     3,     1,     3,
     2,     3,     1,     3,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     4,     3,     3,     3,
     3,     2,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     4,     3,     3,     3,     3,
     2,     1,     1,     1,     2,     1,     3,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     0,     4,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     3,     3,     6,     5,     5,     5,
     5,     4,     3,     3,     3,     2,     2,     3,     3,     3,
     3,     3,     3,     4,     2,     2,     3,     3,     3,     3,
     1,     3,     3,     3,     3,     3,     2,     2,     3,     3,
     3,     3,     3,     6,     1,     1,     1,     1,     1,     3,
     3,     1,     1,     2,     4,     2,     1,     3,     3,     1,
     1,     1,     1,     2,     4,     2,     1,     2,     2,     4,
     1,     0,     2,     2,     2,     1,     1,     2,     3,     4,
     1,     1,     3,     4,     2,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     0,     4,     0,     3,
     0,     0,     5,     3,     3,     2,     3,     3,     1,     4,
     3,     1,     5,     4,     3,     2,     1,     2,     2,     6,
     6,     0,     0,     7,     0,     0,     7,     5,     4,     0,
     0,     9,     0,     6,     0,     7,     0,     5,     0,     6,
     0,     0,     9,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     2,     1,     1,     1,     5,     1,
     2,     1,     1,     1,     3,     1,     3,     1,     4,     6,
     3,     5,     2,     4,     1,     3,     4,     2,     2,     1,
     2,     0,     6,     8,     4,     6,     4,     2,     6,     2,
     4,     6,     2,     4,     2,     4,     1,     1,     1,     3,
     1,     4,     1,     4,     1,     3,     1,     1,     0,     0,
     4,     4,     1,     3,     3,     3,     2,     4,     5,     5,
     2,     4,     4,     3,     3,     3,     2,     1,     4,     3,
     3,     0,     3,     0,     3,     5,     1,     1,     6,     0,
     1,     1,     1,     2,     1,     2,     1,     1,     1,     1,
     1,     1,     1,     2,     3,     3,     3,     4,     0,     3,
     1,     2,     4,     0,     3,     4,     4,     0,     3,     0,
     3,     0,     2,     0,     2,     0,     2,     1,     0,     3,
     0,     0,     0,     0,     0,     8,     1,     1,     1,     1,
     2,     1,     1,     1,     1,     3,     1,     2,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     0,     4,
     0,     3,     0,     3,     4,     2,     2,     1,     2,     0,
     6,     8,     4,     6,     4,     6,     2,     4,     6,     2,
     4,     2,     4,     1,     0,     1,     1,     1,     1,     1,
     1,     1,     1,     3,     1,     3,     1,     2,     1,     2,
     1,     1,     3,     1,     3,     1,     1,     2,     1,     3,
     3,     1,     3,     1,     3,     1,     1,     2,     1,     1,
     1,     2,     2,     0,     1,     0,     4,     1,     2,     1,
     3,     3,     2,     4,     2,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     0,     1,     0,     1,     2,     2,     0,     1,     1,
     1,     1,     1,     2,     0,     0,
    }, yyDefRed = {
//yyDefRed 1110
     1,     0,     0,     0,   368,   370,     0,     0,   316,     0,
     0,     0,   341,   344,     0,     0,     0,   365,   366,   371,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
   471,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   491,   493,   495,     0,     0,   428,   546,
   547,   518,   521,   519,   520,     0,     0,   468,    62,   306,
     0,   472,   307,   308,     0,   309,   310,   305,   469,    34,
    50,   467,   516,     0,     0,     0,     0,     0,     0,     0,
   313,     0,    58,     0,     0,    88,     0,     4,   311,   312,
     0,     0,    74,     0,     2,     0,     5,     0,     0,     0,
     0,     7,   188,   199,   189,   212,   185,   205,   195,   194,
   215,   216,   210,   193,   192,   187,   213,   217,   218,   197,
   186,   200,   204,   206,   198,   191,   207,   214,   209,     0,
     0,     0,     0,   184,   203,   202,   219,   220,   221,   222,
   223,   183,   190,   181,   182,     0,     0,     0,     0,   139,
   524,   523,     0,   526,   173,   174,   170,   152,   153,   154,
   161,   158,   160,   155,   156,   175,   176,   162,   163,   615,
   167,   166,   151,   172,   169,   168,   164,   165,   159,   157,
   149,   171,   150,   177,   140,   358,     0,   614,   141,   208,
   201,   211,   196,   178,   179,   180,   137,   138,   143,   142,
   145,     0,   144,   146,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,   650,   651,     0,     0,
     0,   652,     0,     0,   363,   364,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   367,     0,     0,   381,   382,     0,
     0,   328,     0,     0,     0,     0,   491,     0,     0,   286,
    72,     0,     0,     0,   619,   290,    73,     0,    70,     0,
     0,   446,    69,     0,   644,     0,     0,    22,     0,     0,
     9,     0,   244,     0,     0,     0,     0,     0,    20,     0,
     0,     0,     0,    16,    15,     0,     0,     0,     0,     0,
   272,     0,     0,     0,   617,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   257,    54,   256,   513,   512,   514,
   510,   511,     0,     0,     0,     0,   478,   487,   338,     0,
   483,   489,   473,   453,   451,   337,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   267,   268,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   266,   265,     0,     0,     0,     0,
   453,   436,   637,   638,     0,     0,     0,     0,   640,   639,
     0,     0,    90,     0,     0,     0,     0,     0,     0,     3,
     0,   440,     0,   335,    71,   528,   527,   529,   530,   532,
   531,   533,     0,     0,     0,     0,   135,     0,     0,   314,
   356,     0,     0,   635,   636,   360,   147,     0,     0,     0,
   373,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   653,     0,     0,     0,   517,     0,     0,
     0,     0,   349,   622,   297,   293,     0,   624,     0,     0,
   287,   295,     0,   288,     0,   330,     0,   292,   282,   281,
     0,     0,     0,     0,   334,    53,    24,    26,    25,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   323,    14,     0,     0,   319,     0,   326,     0,   648,
   273,     0,   275,   327,   618,     0,    92,     0,     0,     0,
     0,     0,   500,   498,   515,   497,   492,   474,   475,   494,
   476,   496,     0,     0,   580,   577,   576,   575,   578,   586,
   595,     0,     0,   606,   605,   610,   609,   596,   581,     0,
     0,     0,   603,   432,   429,     0,     0,   573,   593,     0,
   557,   584,   579,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,    28,    29,    30,    31,    32,    51,    52,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   443,     0,
   445,     0,     0,   630,     0,     0,   631,   444,     0,   628,
   629,     0,    49,     0,     0,     0,    46,   232,     0,     0,
     0,     0,    39,   224,    36,   296,     0,     0,     0,     0,
    91,    35,    37,   300,     0,    40,   225,     6,   451,    64,
     0,   132,     0,   134,   548,   352,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   317,     0,
   374,     0,     0,     0,     0,     0,     0,     0,     0,   348,
   376,   342,   375,   345,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   621,     0,     0,     0,   294,   620,   329,
   645,     0,     0,   278,   333,    23,     0,    10,    33,     0,
   231,    21,     0,    17,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   501,     0,   477,   480,     0,   485,     0,
     0,     0,   383,     0,   385,     0,     0,   607,   611,     0,
   571,     0,     0,   566,     0,   569,     0,   555,   597,     0,
   556,   587,     0,   482,     0,   486,     0,   450,   420,     0,
   418,     0,   417,   449,     0,     0,   435,     0,     0,   442,
     0,     0,     0,     0,     0,   280,     0,   441,   279,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,    89,
     0,     0,     0,     0,     0,     0,     0,     0,   136,     0,
     0,   616,     0,     0,     0,   361,   148,   461,     0,     0,
   462,     0,   369,    13,   466,    11,     0,   377,     0,   379,
     0,     0,     0,     0,     0,     0,     0,   347,     0,     0,
     0,     0,     0,     0,   623,   299,   289,     0,   332,   322,
   274,    93,     0,   502,   506,   507,   508,   499,   509,   479,
   481,   488,     0,     0,     0,     0,   583,     0,     0,     0,
   558,   582,     0,     0,   430,     0,     0,   585,     0,   604,
     0,   594,   612,     0,   599,   484,   490,     0,     0,     0,
   416,   591,     0,     0,   399,     0,   601,     0,     0,     0,
   454,   452,     0,    45,   229,    44,   230,    68,     0,   646,
    42,   227,    43,   228,    66,   439,   438,    48,     0,     0,
     0,     0,     0,     0,     0,     0,     0,    61,     0,     0,
     0,   448,   357,   551,   359,   553,     0,     0,     0,   464,
   465,     0,     0,   339,   380,     0,   340,   298,     0,     0,
     0,   350,     0,   503,   384,     0,     0,     0,   386,   431,
     0,     0,   572,     0,     0,     0,   564,     0,   562,     0,
   567,   570,   554,     0,   414,     0,     0,   409,     0,   397,
     0,   412,   419,   398,     0,     0,     0,     0,     0,     0,
     0,    41,     0,     0,     0,   549,   353,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   463,     0,     0,     0,   456,   455,   457,
   343,   346,     0,   504,     0,     0,     0,     0,   426,     0,
   424,   427,   434,   433,     0,     0,     0,     0,     0,   400,
   421,     0,     0,   592,     0,     0,     0,   602,   325,     0,
     0,   355,     0,     0,     0,     0,     0,     0,    12,     0,
     0,     0,     0,     0,     0,   423,   565,     0,   560,   563,
   568,     0,   415,     0,   406,     0,   404,   396,     0,   410,
   413,     0,     0,   362,     0,     0,     0,     0,     0,   458,
   378,   351,     0,     0,   425,     0,     0,     0,     0,     0,
     0,   505,   561,   408,     0,   402,   405,   411,     0,   403,
    }, yyDgoto = {
//yyDgoto 196
     1,   350,    67,    68,   696,   618,   619,   209,   436,   558,
   559,   445,   560,   561,   196,    69,    70,    71,    72,    73,
   352,   354,    74,   536,   355,    75,    76,   737,    77,    78,
   437,    79,    80,    81,    82,   652,   447,   448,   311,   312,
    84,    85,    86,    87,   313,   230,   303,   827,  1018,   828,
   938,    89,   488,   823,   620,   665,   288,    90,   787,    91,
    92,   642,   643,   562,   211,   857,   232,   563,   564,   888,
   770,   771,   672,   644,    94,    95,   281,   462,   819,   319,
   233,   314,   490,   543,   542,   565,   566,   743,   577,   578,
    98,    99,   750,   974,  1039,   870,   568,   891,   892,   569,
   325,   491,   284,   100,   527,   893,   480,   285,   481,   757,
   570,   423,   401,   659,   581,   579,   101,   102,   677,   234,
   212,   213,   571,  1029,   867,   874,   358,   316,   896,   269,
   492,   744,   745,  1030,   198,   572,   399,   485,   781,   104,
   105,   106,   573,   574,   575,   668,   410,   871,   107,   691,
   451,   108,   109,   110,   830,   300,     2,   239,   240,   941,
   509,   499,   486,   675,   520,   289,   214,   317,   318,   724,
   242,   840,   243,   841,   701,  1022,   805,   452,   803,   669,
   442,   674,   936,   359,   751,   582,   580,   734,   733,   853,
   953,  1023,  1061,   804,   673,   441,
    }, yySindex = {
//yySindex 1110
     0,     0, 19594, 20891,     0,     0, 23697, 23588,     0, 22052,
 22052, 18939,     0,     0, 22568, 19981, 19981,     0,     0,     0,
  -253,  -169,     0,     0,     0,     0,    44, 23479,   177,  -140,
  -130,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0, 22181, 22181,   826,   -60, 19723,     0, 20371, 20761,  4839,
 22181, 22310, 23805,     0,     0,     0,   254,   284,     0,     0,
     0,     0,     0,     0,     0,   300,   307,     0,     0,     0,
  -113,     0,     0,     0,  -156,     0,     0,     0,     0,     0,
     0,     0,     0,  1231,   357,  5920,     0,    78,   293,   -44,
     0,   -59,     0,    43,   301,     0,   334,     0,     0,     0,
 22697,   372,     0,   110,     0,   140,     0,   -89, 19981, 22826,
 22955,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,  -185,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   509,     0,     0, 19852,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,   280, 19852,   357,
   228,   424,   270,   538,   272,   228,     0,     0,   140,   353,
   555,     0, 22052, 22052,     0,     0,  -253,  -169,     0,     0,
     0,     0,   289,   177,     0,     0,     0,     0,     0,     0,
     0,     0,   826,   341,     0,   658,     0,     0,     0,   376,
   -89,     0, 22181, 22181, 22181, 22181,     0, 22181,  5920,     0,
     0,   325,   625,   630,     0,     0,     0, 17432,     0, 19981,
 19981,     0,     0, 19068,     0, 22052,  -159,     0, 21149, 19594,
     0, 19852,     0,   686,   359,   363,   360, 21020,     0, 19723,
   362,   140,  1231,     0,     0,     0,   177,   177, 21020,   354,
     0,   144,   164,   325,     0,   345,   164,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,   406,
 23084,   765,     0,   674,     0,     0,     0,     0,     0,     0,
     0,     0,  1221,  1322,  1380,   563,     0,     0,     0,  4297,
     0,     0,     0,     0,     0,     0, 22052, 22052, 22052, 22052,
 21020, 22052, 22052, 22181, 22181, 22181, 22181, 22181,     0,     0,
 22181, 22181, 22181, 22181, 22181, 22181, 22181, 22181, 22181, 22181,
 22181, 22181, 22181, 22181,     0,     0, 22181, 22181, 22181, 22181,
     0,     0,     0,     0,  6256, 19981,  6392, 22181,     0,     0,
  5402, 22310,     0, 21278, 19723, 19207,   679, 21278, 22310,     0,
 19336,     0,   379,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0, 22052,   231,     0,   377,  1032,     0,
     0, 22052,   392,     0,     0,     0,     0,   482,   481,   360,
     0, 19852,   491,  6768, 19981,  6904, 22181, 22181, 22181, 19852,
   353, 21407,   499,     0,    80,    80,   426,     0,     0,  7280,
 19981,  7370,     0,     0,     0,     0,  1253,     0, 22181, 20111,
     0,     0, 20501,     0,   177,     0,   429,     0,     0,     0,
   729,   742,   177,    66,     0,     0,     0,     0,     0, 23588,
 22052,  5920,   428,   430,  6768,  6904, 22181, 22181,  1231,  -140,
   177,     0,     0, 19465,     0,     0,  1231,     0, 20631,     0,
     0, 20761,     0,     0,     0,     0,     0,   743, 23969, 19981,
 24025, 23084,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,  1457,   -49,     0,     0,     0,     0,     0,     0,
     0,  1342,  2760,     0,     0,     0,     0,     0,     0,   483,
   505,   768,     0,     0,     0,   771,   772,     0,     0,   776,
     0,     0,     0,   515,   785, 22181,   784,  1477,   234,   568,
    15,   486,    15,     0,     0,     0,     0,     0,     0,     0,
   359,  3334,  3334,  3334,  3334,  4367,  5232,  3334,  3334,  3855,
  3855,   805,   805,   359,  1844,   359,   359,   848,   848,  1819,
  1819, 10280,  2730,   590,   530,     0,   533,  -169,     0,     0,
     0,   177,   534,     0,   541,  -169,     0,     0,  2730,     0,
     0,  -169,     0,   583,  5781,  1098,     0,     0,    43,   821,
 22181,  5781,     0,     0,     0,     0,   840,   177, 23084,   850,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
   357,     0,     0,     0,     0,     0, 24081, 19981, 24137, 19852,
    66,  2760, 19852,  2760, 23913, 23588, 21536,   -18,     0,   422,
     0,   558,   565,   177,   572,   578,   687,   694,    81,     0,
     0,     0,     0,     0,     0,     0,  -169,   177,     0,     0,
  -169, 22052, 22181,     0, 22181,   325,   630,     0,     0,     0,
     0, 20111, 20501,     0,     0,     0,    66,     0,     0,   359,
     0,     0,     0,     0,   177,   164, 23084,     0,     0,   177,
     0,     0,   743,     0,   427,     0,     0,     4,     0,   931,
  1342,   490,     0,   922,     0,   177,   177,     0,     0,  3266,
     0,  -230,  2760,     0,  2760,     0,   661,     0,     0,   242,
     0,     0, 22181,     0,   151,     0,   943,     0,     0,  2356,
     0, 19852,     0,     0, 19852,   909,     0, 22310, 22310,     0,
   379,   639,   635, 22310, 22310,     0,   379,     0,     0,    78,
  -156, 21020, 22181, 24193, 19981, 24249, 22310,     0, 21665,     0,
   743, 23084,   620,   140, 22052, 19852,     0,     0,     0,   177,
   721,     0,   177,   724,   140,     0,     0,     0,     0,   670,
     0, 19852,     0,     0,     0,     0, 22052,     0,   731,     0,
 19852, 22181, 22181,   675, 22181, 22181,   755,     0, 21794, 19852,
 19852, 19852,     0,    80,     0,     0,     0,   984,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,   177,  1183,   986,  1349,     0,   700,   985,  1005,
     0,     0, 19852, 19852,     0,  1006,  1014,     0,  1015,     0,
  1005,     0,     0,   785,     0,     0,     0,  1017,   177,  1019,
     0,     0,  1020,  1021,     0,   712,     0,   785, 23213,  1018,
     0,     0, 22181,     0,     0,     0,     0,     0, 22310,     0,
     0,     0,     0,     0,     0,     0,     0,     0,  5920,   530,
   533,   177,   534,   541, 22181,     0,   743,     0, 19852,   140,
   818,     0,     0,     0,     0,     0,   392, 23342,   228,     0,
     0, 19852,   228,     0,     0, 22181,     0,     0,   -85,   819,
   822,     0, 20501,     0,     0,  1041,  1183,   737,     0,     0,
  1145,  3266,     0,   833,   727,  3266,     0,  2760,     0,  3266,
     0,     0,     0,  3266,     0,   739,  2760,     0,   661,     0,
  2760,     0,     0,     0,     0,     0,   799,  1131, 23213,  5920,
  5920,     0,   639,     0,   846,     0,     0, 19852,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
   802,  1185,     0,     0, 19852,   854, 19852,     0,     0,     0,
     0,     0, 19852,     0,  1183,  1041,  1183,  1074,     0,   458,
     0,     0,     0,     0,  1005,  1076,  1005,  1005,  1077,     0,
     0,  1080,  1091,     0,   785,  1097,  1077,     0,     0, 24305,
  1131,     0,   865,     0, 24361, 19981, 24417,   482,     0,   422,
   878, 19852,  1041,  1183,  1145,     0,     0,  3266,     0,     0,
     0,  3266,     0,  3266,     0,  2760,     0,     0,  3266,     0,
     0,     0,     0,     0,     0,     0,   177,     0,     0,     0,
     0,     0,   754,  1041,     0,  1005,  1077,  1108,  1077,  1077,
     0,     0,     0,     0,  3266,     0,     0,     0,  1077,     0,
    }, yyRindex = {
//yyRindex 1110
     0,     0,   165,     0,     0,     0,     0,     0,     0,     0,
     0,   886,     0,     0,     0, 10956, 11059,     0,     0,     0,
  5151,  4639, 12566, 12716, 12867, 13017, 22439,     0, 21923,     0,
     0, 13168, 13318, 13469,  5513,  3615, 13619, 13770,  5652, 13920,
     0,     0,     0,     0,     0,   137, 18810,   824,   801,    24,
     0,     0,  1480,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
 10221,     0,     0,     0, 10410,     0,     0,     0,     0,     0,
     0,     0,     0,    74, 14325,  9066, 10527,  9918,     0, 14076,
     0, 10770,     0, 14221,     0,     0,     0,     0,     0,     0,
   221,     0,     0,     0,     0,    62,     0, 20241, 11171,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,  1734,
  2693,  3205,  3292,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,  3717,  3804,  4229,  4316,     0,
     0,     0,  4741,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0, 15255,     0,     0,   655,  8277,  8400,  8517,  8706,  8823,
  8946,  9129,  2452,  9252,  9369,  2591,  9558,     0,   137,  2081,
     0,     0,  9981,     0,     0,     0,     0,     0,   886,     0,
   896,     0,     0,     0,     0,     0, 10650,  9675,   820,   868,
   935,  1201,     0,   830,  1396,  1619,  2288,  1595,  2323,  2365,
  2739,  2878,     0,     0,     0,     0,  3291,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0, 16727,     0,
     0, 16880,  1644,  1644,     0,     0,     0,   832,     0,     0,
   124,     0,     0,   832,     0,     0,     0,     0,     0,    46,
     0,    46,     0,     0, 11605, 10833, 14375,     0,     0,   137,
     0,  2062,   915,     0,     0,   152,   832,   832,     0,     0,
     0,   831,   831,     0,     0,     0,   812,  1043,  1586,  1859,
  7564,  8617,  8888,  9891,  1427, 10743, 11426,  1504, 11686,     0,
     0,     0, 12048,   260,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,  -208,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0, 11365, 11502,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,    60,     0,     0,     0,     0,
     0,     0,     0,     0,   137,   261,   302,     0,     0,     0,
    63,     0, 17002,     0,     0,     0,     0,     0,     0,     0,
     0,     0, 17571, 17712,     0,     0,     0, 18411,     0,     0,
     0,     0,  1663,     0,     0,     0,     0,   431,     0, 10104,
     0,   951, 18272,     0,    60,     0,     0,     0,     0,   827,
     0,     0,     0,     0,     0,     0,     0,     0,  3390,     0,
    60,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   832,     0,     0,     0,     0,     0,
   116,   116,   832,   832,     0,     0,     0,     0,     0,     0,
     0,  5343,     0,     0,     0,     0,     0,     0,   998,     0,
   832,     0,     0,  2170,   248,     0,   167,     0,   842,     0,
     0,  -133,     0,     0,     0, 12204,     0,   318,     0,    60,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,   236,     0,     0,     0,     0,     0,     0,    54,
     0,   226,     0,     0,     0,   226,   226,     0,     0,   264,
     0,     0,     0,   245,   264,   112,   122,     0,     0,     0,
 18552,     0, 18681,     0,     0,     0,     0,     0,     0,     0,
 11742,  1293, 15773, 15896, 15999, 16086, 16363, 16173, 16276,  1452,
  2125, 14954, 15073, 11878, 15183, 11987, 12104, 14527, 14681, 15318,
 15427,  1127, 15547,     0,  6025,  3988,  7561, 20241,     0,  4127,
     0,   845,  6164,     0,  6537,  5012,     0,     0, 15656,     0,
     0,  7923,     0, 11308, 16818,     0,     0,     0, 14833,     0,
     0, 17333,     0,     0,     0,     0,     0,   832,     0,   343,
     0,     0,     0,     0, 17370,     0,     0,     0,     0,     0,
   180,     0, 18131,     0,     0,     0,     0,    60,     0,   655,
   832,   200,   655,   188,     0,     0,   324,   927,     0,   927,
     0,  2964,  4500,   845,  3103,  3476,   927,     0,     0,     0,
     0,     0,     0,     0,  2779,   809,     0,   845,  3251,  3763,
  9798,     0,     0,     0,     0, 16966,  1644,     0,     0,     0,
     0,   132,   175,     0,     0,     0,   832,     0,     0, 12260,
     0,     0,   109,     0,   832,   831,     0,  5842,  1751,   845,
  6354,  6866,   535,     0,     0,     0,     0,     0,     0,     0,
     0,   206,     0,   213,     0,   832,     8,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     6,
     0,   655,     0,     0,    46,     0,     0,     0,     0,     0,
 17091,  1956,     0,     0,     0,     0, 17127,     0,     0, 17242,
  2211,     0,     0,     0,    60,     0,     0,  2336,     0,     0,
   606,     0,     0,     0,     0,   655, 17851, 17992,     0,   845,
     0,     0,   832,     0,     0,     0,     0,     0,   333,   305,
     0,    98,     0,     0,     0,     0,     0,     0,     0,     0,
    98,     0,     0,  8062,     0,     0,     0,     0,     0,   683,
    98,    98,  1205,     0,     0,     0,     0,   116,     0,     0,
     0,     0,  7378,     0,     0,     0,     0,     0,     0,     0,
     0,     0,   832,     0,   223,     0,     0,     0,  -145,   226,
     0,     0,   655,    46,     0,   226,   226,     0,   226,     0,
   226,     0,     0,   264,     0,     0,     0,    72,     6,    72,
     0,     0,    77,    72,     0,     0,     0,    77,    27,    79,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0, 16450,  6676,
  7700,   845,  7049,  7188,     0, 17182,   626,     0,   655,     0,
     0,     0,     0,     0,     0,     0,  1663,     0,     0,     0,
     0,   972,     0,     0,     0,     0,     0,     0,   927,     0,
     0,     0,   193,     0,     0,   224,     0,   232,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,   104,     0,     0,     0,
     0,     0,     0,     0,  1617,  2249,     0,   117,     0, 16553,
 16640,     0, 12410, 17279,     0,     0,     0,   655,  1122,  1344,
  1701,  1720,  2306,  2311,  2351,   656,  2832,  3344,  8162,  3856,
     0,     0,  4368,     0,   655,   927,   951,     0,     0,     0,
     0,     0,    98,     0,     0,   246,     0,   247,     0,   217,
     0,     0,     0,     0,   226,   226,   226,   226,    72,     0,
     0,    72,    72,     0,    77,    72,    72,     0,     0,     0,
   134,     0,     0,  8164,     0,    60,     0,   431,     0,   927,
     0,    58,   252,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,  5340,  1274,     0,  8650,  1022,   845,  9039,  9469,     0,
     0,     0,     0,   256,     0,   226,    72,    72,    72,    72,
  9502,     0,     0,     0,     0,     0,     0,     0,    72,     0,
    }, yyGindex = {
//yyGindex 196
     0,     0,    17,     0,  -246,     0,    14,     7,  -336,  -250,
     0,     0,     0,   135,     0,     0,     0,  1124,     0,     0,
   102,     0,     0,  -294,     0,     0,     0,   615,     0,    26,
  1088,  -146,   143,     0,    64,     0,   195,   501,     0,    37,
   759,  1025,    -7,   113,   682,    21,     1,  -613,     0,   169,
     0,     0,   603,   208,    28,     0,     9,  1220,   598,     0,
     0,  -100,   497,  -662,     0,     0,    92,   173,     0,     0,
     0,   651,   298,  -338,   -91,    -4,   866,  -437,     0,     0,
   166,   157,    65,     0,     0,   397,   485,   136,     0,     0,
     0,     0,  -305,  2087,   470,   299,   484,   269,     0,     0,
     0,    10,  -444,     0,  -459,   266,  -265,  -431,     0,  -546,
   268,   -73,   461,  -455,   593,   853,  1240,   -16,   201,   447,
     0,   -13,  -264,     0,  -669,     0,     0,  -179,  -834,     0,
  -350,  -787,   524,   209,     0,  -864,  1176,   585,  -614,   983,
     0,    19,     0,  1085,  -223,   -83,     0,  -324,  1503,  -446,
  -229,  1724,     0,     0,   608,   781,     0,   528,    47,     0,
     0,     0,   -26,     0,  -279,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,    16,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,
    };
    protected static final short[] yyTable = YyTables.yyTable();
    protected static final short[] yyCheck = YyTables.yyCheck();

  /** maps symbol value to printable name.
      @see #yyExpecting
    */
  protected static final String[] yyNames = {
    "end-of-file",null,null,null,null,null,null,null,null,null,"'\\n'",
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,"' '",null,null,null,null,null,
    null,null,null,null,null,null,"','",null,null,null,null,null,null,
    null,null,null,null,null,null,null,"':'","';'",null,"'='",null,"'?'",
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,
    "'['",null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,
"class","module","def","undef",
"begin","rescue","ensure","end",
"if","unless","then","elsif",
"else","case","when","while",
"until","for","break","next",
"redo","retry","in","do",
"do (for condition)","do (for block)","return","yield",
"super","self","nil","true",
"false","and","or","not",
"if (modifier)","unless (modifier)","while (modifier)","until (modifier)",
"rescue (modifier)","alias","defined","BEGIN",
"END","__LINE__","__FILE__",
"__ENCODING__","do (for lambda)","tIDENTIFIER","tFID",
    "tGVAR","tIVAR","tCONSTANT","tCVAR","tLABEL","tCHAR","unary+",
"unary-","tUMINUS_NUM","**","<=>","==","===","!=",">=",
"<=","&&","||","=~","!~","'.'","..","...",
"[]","[]=","<<",">>","&.","::",":: at EXPR_BEG",
    "tOP_ASGN","=>","'('","'('","')'","( arg",
"'['","']'","'{'","{ arg","'*'","'*'","'&'",
"'&'","'`'","'%'","'/'","'+'","'-'","'<'","'>'",
"'|'","'!'","'^'","'{'","'}'","'`'","tSYMBEG",
    "tSTRING_BEG","tXSTRING_BEG","tREGEXP_BEG","tWORDS_BEG","tQWORDS_BEG",
    "tSTRING_DBEG","tSTRING_DVAR","tSTRING_END","->","tLAMBEG",
    "tNTH_REF","tBACK_REF","tSTRING_CONTENT","tINTEGER","tIMAGINARY",
    "tFLOAT","tRATIONAL","tREGEXP_END","tIGNORED_NL","tCOMMENT",
    "tEMBDOC_BEG","tEMBDOC","tEMBDOC_END","tSP","tHEREDOC_BEG",
    "tHEREDOC_END","tSYMBOLS_BEG","tQSYMBOLS_BEG","tDSTAR","tSTRING_DEND",
    "tLABEL_END","tLOWEST","k__END__",
    };

  /** printable rules for debugging.
    */
  protected static final String [] yyRule = {
    "$accept : program",
    "$$1 :",
    "program : $$1 top_compstmt",
    "top_compstmt : top_stmts opt_terms",
    "top_stmts : none",
    "top_stmts : top_stmt",
    "top_stmts : top_stmts terms top_stmt",
    "top_stmts : error top_stmt",
    "top_stmt : stmt",
    "top_stmt : keyword_BEGIN begin_block",
    "begin_block : tLCURLY top_compstmt tRCURLY",
    "$$2 :",
    "bodystmt : compstmt opt_rescue k_else $$2 compstmt opt_ensure",
    "bodystmt : compstmt opt_rescue opt_ensure",
    "compstmt : stmts opt_terms",
    "stmts : none",
    "stmts : stmt_or_begin",
    "stmts : stmts terms stmt_or_begin",
    "stmts : error stmt",
    "stmt_or_begin : stmt",
    "$$3 :",
    "stmt_or_begin : keyword_BEGIN $$3 begin_block",
    "$$4 :",
    "stmt : keyword_alias fitem $$4 fitem",
    "stmt : keyword_alias tGVAR tGVAR",
    "stmt : keyword_alias tGVAR tBACK_REF",
    "stmt : keyword_alias tGVAR tNTH_REF",
    "stmt : keyword_undef undef_list",
    "stmt : stmt modifier_if expr_value",
    "stmt : stmt modifier_unless expr_value",
    "stmt : stmt modifier_while expr_value",
    "stmt : stmt modifier_until expr_value",
    "stmt : stmt modifier_rescue stmt",
    "stmt : keyword_END tLCURLY compstmt tRCURLY",
    "stmt : command_asgn",
    "stmt : mlhs '=' command_call",
    "stmt : lhs '=' mrhs",
    "stmt : mlhs '=' mrhs_arg",
    "stmt : expr",
    "command_asgn : lhs '=' command_rhs",
    "command_asgn : var_lhs tOP_ASGN command_rhs",
    "command_asgn : primary_value '[' opt_call_args rbracket tOP_ASGN command_rhs",
    "command_asgn : primary_value call_op tIDENTIFIER tOP_ASGN command_rhs",
    "command_asgn : primary_value call_op tCONSTANT tOP_ASGN command_rhs",
    "command_asgn : primary_value tCOLON2 tCONSTANT tOP_ASGN command_rhs",
    "command_asgn : primary_value tCOLON2 tIDENTIFIER tOP_ASGN command_rhs",
    "command_asgn : backref tOP_ASGN command_rhs",
    "command_rhs : command_call",
    "command_rhs : command_call modifier_rescue stmt",
    "command_rhs : command_asgn",
    "expr : command_call",
    "expr : expr keyword_and expr",
    "expr : expr keyword_or expr",
    "expr : keyword_not opt_nl expr",
    "expr : tBANG command_call",
    "expr : arg",
    "expr_value : expr",
    "command_call : command",
    "command_call : block_command",
    "block_command : block_call",
    "block_command : block_call call_op2 operation2 command_args",
    "cmd_brace_block : tLBRACE_ARG brace_body tRCURLY",
    "fcall : operation",
    "command : fcall command_args",
    "command : fcall command_args cmd_brace_block",
    "command : primary_value call_op operation2 command_args",
    "command : primary_value call_op operation2 command_args cmd_brace_block",
    "command : primary_value tCOLON2 operation2 command_args",
    "command : primary_value tCOLON2 operation2 command_args cmd_brace_block",
    "command : keyword_super command_args",
    "command : keyword_yield command_args",
    "command : k_return call_args",
    "command : keyword_break call_args",
    "command : keyword_next call_args",
    "mlhs : mlhs_basic",
    "mlhs : tLPAREN mlhs_inner rparen",
    "mlhs_inner : mlhs_basic",
    "mlhs_inner : tLPAREN mlhs_inner rparen",
    "mlhs_basic : mlhs_head",
    "mlhs_basic : mlhs_head mlhs_item",
    "mlhs_basic : mlhs_head tSTAR mlhs_node",
    "mlhs_basic : mlhs_head tSTAR mlhs_node ',' mlhs_post",
    "mlhs_basic : mlhs_head tSTAR",
    "mlhs_basic : mlhs_head tSTAR ',' mlhs_post",
    "mlhs_basic : tSTAR mlhs_node",
    "mlhs_basic : tSTAR mlhs_node ',' mlhs_post",
    "mlhs_basic : tSTAR",
    "mlhs_basic : tSTAR ',' mlhs_post",
    "mlhs_item : mlhs_node",
    "mlhs_item : tLPAREN mlhs_inner rparen",
    "mlhs_head : mlhs_item ','",
    "mlhs_head : mlhs_head mlhs_item ','",
    "mlhs_post : mlhs_item",
    "mlhs_post : mlhs_post ',' mlhs_item",
    "mlhs_node : tIDENTIFIER",
    "mlhs_node : tIVAR",
    "mlhs_node : tGVAR",
    "mlhs_node : tCONSTANT",
    "mlhs_node : tCVAR",
    "mlhs_node : keyword_nil",
    "mlhs_node : keyword_self",
    "mlhs_node : keyword_true",
    "mlhs_node : keyword_false",
    "mlhs_node : keyword__FILE__",
    "mlhs_node : keyword__LINE__",
    "mlhs_node : keyword__ENCODING__",
    "mlhs_node : primary_value '[' opt_call_args rbracket",
    "mlhs_node : primary_value call_op tIDENTIFIER",
    "mlhs_node : primary_value tCOLON2 tIDENTIFIER",
    "mlhs_node : primary_value call_op tCONSTANT",
    "mlhs_node : primary_value tCOLON2 tCONSTANT",
    "mlhs_node : tCOLON3 tCONSTANT",
    "mlhs_node : backref",
    "lhs : tIDENTIFIER",
    "lhs : tIVAR",
    "lhs : tGVAR",
    "lhs : tCONSTANT",
    "lhs : tCVAR",
    "lhs : keyword_nil",
    "lhs : keyword_self",
    "lhs : keyword_true",
    "lhs : keyword_false",
    "lhs : keyword__FILE__",
    "lhs : keyword__LINE__",
    "lhs : keyword__ENCODING__",
    "lhs : primary_value '[' opt_call_args rbracket",
    "lhs : primary_value call_op tIDENTIFIER",
    "lhs : primary_value tCOLON2 tIDENTIFIER",
    "lhs : primary_value call_op tCONSTANT",
    "lhs : primary_value tCOLON2 tCONSTANT",
    "lhs : tCOLON3 tCONSTANT",
    "lhs : backref",
    "cname : tIDENTIFIER",
    "cname : tCONSTANT",
    "cpath : tCOLON3 cname",
    "cpath : cname",
    "cpath : primary_value tCOLON2 cname",
    "fname : tIDENTIFIER",
    "fname : tCONSTANT",
    "fname : tFID",
    "fname : op",
    "fname : reswords",
    "fsym : fname",
    "fsym : symbol",
    "fitem : fsym",
    "fitem : dsym",
    "undef_list : fitem",
    "$$5 :",
    "undef_list : undef_list ',' $$5 fitem",
    "op : tPIPE",
    "op : tCARET",
    "op : tAMPER2",
    "op : tCMP",
    "op : tEQ",
    "op : tEQQ",
    "op : tMATCH",
    "op : tNMATCH",
    "op : tGT",
    "op : tGEQ",
    "op : tLT",
    "op : tLEQ",
    "op : tNEQ",
    "op : tLSHFT",
    "op : tRSHFT",
    "op : tPLUS",
    "op : tMINUS",
    "op : tSTAR2",
    "op : tSTAR",
    "op : tDIVIDE",
    "op : tPERCENT",
    "op : tPOW",
    "op : tBANG",
    "op : tTILDE",
    "op : tUPLUS",
    "op : tUMINUS",
    "op : tAREF",
    "op : tASET",
    "op : tBACK_REF2",
    "reswords : keyword__LINE__",
    "reswords : keyword__FILE__",
    "reswords : keyword__ENCODING__",
    "reswords : keyword_BEGIN",
    "reswords : keyword_END",
    "reswords : keyword_alias",
    "reswords : keyword_and",
    "reswords : keyword_begin",
    "reswords : keyword_break",
    "reswords : keyword_case",
    "reswords : keyword_class",
    "reswords : keyword_def",
    "reswords : keyword_defined",
    "reswords : keyword_do",
    "reswords : keyword_else",
    "reswords : keyword_elsif",
    "reswords : keyword_end",
    "reswords : keyword_ensure",
    "reswords : keyword_false",
    "reswords : keyword_for",
    "reswords : keyword_in",
    "reswords : keyword_module",
    "reswords : keyword_next",
    "reswords : keyword_nil",
    "reswords : keyword_not",
    "reswords : keyword_or",
    "reswords : keyword_redo",
    "reswords : keyword_rescue",
    "reswords : keyword_retry",
    "reswords : keyword_return",
    "reswords : keyword_self",
    "reswords : keyword_super",
    "reswords : keyword_then",
    "reswords : keyword_true",
    "reswords : keyword_undef",
    "reswords : keyword_when",
    "reswords : keyword_yield",
    "reswords : keyword_if",
    "reswords : keyword_unless",
    "reswords : keyword_while",
    "reswords : keyword_until",
    "reswords : modifier_if",
    "reswords : modifier_unless",
    "reswords : modifier_while",
    "reswords : modifier_until",
    "reswords : modifier_rescue",
    "arg : lhs '=' arg_rhs",
    "arg : var_lhs tOP_ASGN arg_rhs",
    "arg : primary_value '[' opt_call_args rbracket tOP_ASGN arg",
    "arg : primary_value call_op tIDENTIFIER tOP_ASGN arg_rhs",
    "arg : primary_value call_op tCONSTANT tOP_ASGN arg_rhs",
    "arg : primary_value tCOLON2 tIDENTIFIER tOP_ASGN arg_rhs",
    "arg : primary_value tCOLON2 tCONSTANT tOP_ASGN arg_rhs",
    "arg : tCOLON3 tCONSTANT tOP_ASGN arg_rhs",
    "arg : backref tOP_ASGN arg_rhs",
    "arg : arg tDOT2 arg",
    "arg : arg tDOT3 arg",
    "arg : arg tDOT2",
    "arg : arg tDOT3",
    "arg : arg tPLUS arg",
    "arg : arg tMINUS arg",
    "arg : arg tSTAR2 arg",
    "arg : arg tDIVIDE arg",
    "arg : arg tPERCENT arg",
    "arg : arg tPOW arg",
    "arg : tUMINUS_NUM simple_numeric tPOW arg",
    "arg : tUPLUS arg",
    "arg : tUMINUS arg",
    "arg : arg tPIPE arg",
    "arg : arg tCARET arg",
    "arg : arg tAMPER2 arg",
    "arg : arg tCMP arg",
    "arg : rel_expr",
    "arg : arg tEQ arg",
    "arg : arg tEQQ arg",
    "arg : arg tNEQ arg",
    "arg : arg tMATCH arg",
    "arg : arg tNMATCH arg",
    "arg : tBANG arg",
    "arg : tTILDE arg",
    "arg : arg tLSHFT arg",
    "arg : arg tRSHFT arg",
    "arg : arg tANDOP arg",
    "arg : arg tOROP arg",
    "arg : keyword_defined opt_nl arg",
    "arg : arg '?' arg opt_nl ':' arg",
    "arg : primary",
    "relop : tGT",
    "relop : tLT",
    "relop : tGEQ",
    "relop : tLEQ",
    "rel_expr : arg relop arg",
    "rel_expr : rel_expr relop arg",
    "arg_value : arg",
    "aref_args : none",
    "aref_args : args trailer",
    "aref_args : args ',' assocs trailer",
    "aref_args : assocs trailer",
    "arg_rhs : arg",
    "arg_rhs : arg modifier_rescue arg",
    "paren_args : tLPAREN2 opt_call_args rparen",
    "opt_paren_args : none",
    "opt_paren_args : paren_args",
    "opt_call_args : none",
    "opt_call_args : call_args",
    "opt_call_args : args ','",
    "opt_call_args : args ',' assocs ','",
    "opt_call_args : assocs ','",
    "call_args : command",
    "call_args : args opt_block_arg",
    "call_args : assocs opt_block_arg",
    "call_args : args ',' assocs opt_block_arg",
    "call_args : block_arg",
    "$$6 :",
    "command_args : $$6 call_args",
    "block_arg : tAMPER arg_value",
    "opt_block_arg : ',' block_arg",
    "opt_block_arg : none_block_pass",
    "args : arg_value",
    "args : tSTAR arg_value",
    "args : args ',' arg_value",
    "args : args ',' tSTAR arg_value",
    "mrhs_arg : mrhs",
    "mrhs_arg : arg_value",
    "mrhs : args ',' arg_value",
    "mrhs : args ',' tSTAR arg_value",
    "mrhs : tSTAR arg_value",
    "primary : literal",
    "primary : strings",
    "primary : xstring",
    "primary : regexp",
    "primary : words",
    "primary : qwords",
    "primary : symbols",
    "primary : qsymbols",
    "primary : var_ref",
    "primary : backref",
    "primary : tFID",
    "$$7 :",
    "primary : keyword_begin $$7 bodystmt keyword_end",
    "$$8 :",
    "primary : tLPAREN_ARG $$8 rparen",
    "$$9 :",
    "$$10 :",
    "primary : tLPAREN_ARG $$9 stmt $$10 rparen",
    "primary : tLPAREN compstmt tRPAREN",
    "primary : primary_value tCOLON2 tCONSTANT",
    "primary : tCOLON3 tCONSTANT",
    "primary : tLBRACK aref_args tRBRACK",
    "primary : tLBRACE assoc_list tRCURLY",
    "primary : k_return",
    "primary : keyword_yield tLPAREN2 call_args rparen",
    "primary : keyword_yield tLPAREN2 rparen",
    "primary : keyword_yield",
    "primary : keyword_defined opt_nl tLPAREN2 expr rparen",
    "primary : keyword_not tLPAREN2 expr rparen",
    "primary : keyword_not tLPAREN2 rparen",
    "primary : fcall brace_block",
    "primary : method_call",
    "primary : method_call brace_block",
    "primary : tLAMBDA lambda",
    "primary : keyword_if expr_value then compstmt if_tail keyword_end",
    "primary : keyword_unless expr_value then compstmt opt_else keyword_end",
    "$$11 :",
    "$$12 :",
    "primary : keyword_while $$11 expr_value do $$12 compstmt keyword_end",
    "$$13 :",
    "$$14 :",
    "primary : keyword_until $$13 expr_value do $$14 compstmt keyword_end",
    "primary : keyword_case expr_value opt_terms case_body keyword_end",
    "primary : keyword_case opt_terms case_body keyword_end",
    "$$15 :",
    "$$16 :",
    "primary : keyword_for for_var keyword_in $$15 expr_value do $$16 compstmt keyword_end",
    "$$17 :",
    "primary : k_class cpath superclass $$17 bodystmt keyword_end",
    "$$18 :",
    "primary : k_class tLSHFT expr $$18 term bodystmt keyword_end",
    "$$19 :",
    "primary : k_module cpath $$19 bodystmt keyword_end",
    "$$20 :",
    "primary : keyword_def fname $$20 f_arglist bodystmt keyword_end",
    "$$21 :",
    "$$22 :",
    "primary : keyword_def singleton dot_or_colon $$21 fname $$22 f_arglist bodystmt keyword_end",
    "primary : keyword_break",
    "primary : keyword_next",
    "primary : keyword_redo",
    "primary : keyword_retry",
    "primary_value : primary",
    "k_class : keyword_class",
    "k_else : keyword_else",
    "k_module : keyword_module",
    "k_return : keyword_return",
    "then : term",
    "then : keyword_then",
    "then : term keyword_then",
    "do : term",
    "do : keyword_do_cond",
    "if_tail : opt_else",
    "if_tail : keyword_elsif expr_value then compstmt if_tail",
    "opt_else : none",
    "opt_else : k_else compstmt",
    "for_var : lhs",
    "for_var : mlhs",
    "f_marg : f_norm_arg",
    "f_marg : tLPAREN f_margs rparen",
    "f_marg_list : f_marg",
    "f_marg_list : f_marg_list ',' f_marg",
    "f_margs : f_marg_list",
    "f_margs : f_marg_list ',' tSTAR f_norm_arg",
    "f_margs : f_marg_list ',' tSTAR f_norm_arg ',' f_marg_list",
    "f_margs : f_marg_list ',' tSTAR",
    "f_margs : f_marg_list ',' tSTAR ',' f_marg_list",
    "f_margs : tSTAR f_norm_arg",
    "f_margs : tSTAR f_norm_arg ',' f_marg_list",
    "f_margs : tSTAR",
    "f_margs : tSTAR ',' f_marg_list",
    "block_args_tail : f_block_kwarg ',' f_kwrest opt_f_block_arg",
    "block_args_tail : f_block_kwarg opt_f_block_arg",
    "block_args_tail : f_kwrest opt_f_block_arg",
    "block_args_tail : f_block_arg",
    "opt_block_args_tail : ',' block_args_tail",
    "opt_block_args_tail :",
    "block_param : f_arg ',' f_block_optarg ',' f_rest_arg opt_block_args_tail",
    "block_param : f_arg ',' f_block_optarg ',' f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : f_arg ',' f_block_optarg opt_block_args_tail",
    "block_param : f_arg ',' f_block_optarg ',' f_arg opt_block_args_tail",
    "block_param : f_arg ',' f_rest_arg opt_block_args_tail",
    "block_param : f_arg ','",
    "block_param : f_arg ',' f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : f_arg opt_block_args_tail",
    "block_param : f_block_optarg ',' f_rest_arg opt_block_args_tail",
    "block_param : f_block_optarg ',' f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : f_block_optarg opt_block_args_tail",
    "block_param : f_block_optarg ',' f_arg opt_block_args_tail",
    "block_param : f_rest_arg opt_block_args_tail",
    "block_param : f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : block_args_tail",
    "opt_block_param : none",
    "opt_block_param : block_param_def",
    "block_param_def : tPIPE opt_bv_decl tPIPE",
    "block_param_def : tOROP",
    "block_param_def : tPIPE block_param opt_bv_decl tPIPE",
    "opt_bv_decl : opt_nl",
    "opt_bv_decl : opt_nl ';' bv_decls opt_nl",
    "bv_decls : bvar",
    "bv_decls : bv_decls ',' bvar",
    "bvar : tIDENTIFIER",
    "bvar : f_bad_arg",
    "$$23 :",
    "$$24 :",
    "lambda : $$23 f_larglist $$24 lambda_body",
    "f_larglist : tLPAREN2 f_args opt_bv_decl tRPAREN",
    "f_larglist : f_args",
    "lambda_body : tLAMBEG compstmt tRCURLY",
    "lambda_body : keyword_do_lambda bodystmt keyword_end",
    "do_block : keyword_do_block do_body keyword_end",
    "block_call : command do_block",
    "block_call : block_call call_op2 operation2 opt_paren_args",
    "block_call : block_call call_op2 operation2 opt_paren_args brace_block",
    "block_call : block_call call_op2 operation2 command_args do_block",
    "method_call : fcall paren_args",
    "method_call : primary_value call_op operation2 opt_paren_args",
    "method_call : primary_value tCOLON2 operation2 paren_args",
    "method_call : primary_value tCOLON2 operation3",
    "method_call : primary_value call_op paren_args",
    "method_call : primary_value tCOLON2 paren_args",
    "method_call : keyword_super paren_args",
    "method_call : keyword_super",
    "method_call : primary_value '[' opt_call_args rbracket",
    "brace_block : tLCURLY brace_body tRCURLY",
    "brace_block : keyword_do do_body keyword_end",
    "$$25 :",
    "brace_body : $$25 opt_block_param compstmt",
    "$$26 :",
    "do_body : $$26 opt_block_param bodystmt",
    "case_body : keyword_when args then compstmt cases",
    "cases : opt_else",
    "cases : case_body",
    "opt_rescue : keyword_rescue exc_list exc_var then compstmt opt_rescue",
    "opt_rescue :",
    "exc_list : arg_value",
    "exc_list : mrhs",
    "exc_list : none",
    "exc_var : tASSOC lhs",
    "exc_var : none",
    "opt_ensure : keyword_ensure compstmt",
    "opt_ensure : none",
    "literal : numeric",
    "literal : symbol",
    "literal : dsym",
    "strings : string",
    "string : tCHAR",
    "string : string1",
    "string : string string1",
    "string1 : tSTRING_BEG string_contents tSTRING_END",
    "xstring : tXSTRING_BEG xstring_contents tSTRING_END",
    "regexp : tREGEXP_BEG regexp_contents tREGEXP_END",
    "words : tWORDS_BEG ' ' word_list tSTRING_END",
    "word_list :",
    "word_list : word_list word ' '",
    "word : string_content",
    "word : word string_content",
    "symbols : tSYMBOLS_BEG ' ' symbol_list tSTRING_END",
    "symbol_list :",
    "symbol_list : symbol_list word ' '",
    "qwords : tQWORDS_BEG ' ' qword_list tSTRING_END",
    "qsymbols : tQSYMBOLS_BEG ' ' qsym_list tSTRING_END",
    "qword_list :",
    "qword_list : qword_list tSTRING_CONTENT ' '",
    "qsym_list :",
    "qsym_list : qsym_list tSTRING_CONTENT ' '",
    "string_contents :",
    "string_contents : string_contents string_content",
    "xstring_contents :",
    "xstring_contents : xstring_contents string_content",
    "regexp_contents :",
    "regexp_contents : regexp_contents string_content",
    "string_content : tSTRING_CONTENT",
    "$$27 :",
    "string_content : tSTRING_DVAR $$27 string_dvar",
    "$$28 :",
    "$$29 :",
    "$$30 :",
    "$$31 :",
    "$$32 :",
    "string_content : tSTRING_DBEG $$28 $$29 $$30 $$31 $$32 compstmt tSTRING_DEND",
    "string_dvar : tGVAR",
    "string_dvar : tIVAR",
    "string_dvar : tCVAR",
    "string_dvar : backref",
    "symbol : tSYMBEG sym",
    "sym : fname",
    "sym : tIVAR",
    "sym : tGVAR",
    "sym : tCVAR",
    "dsym : tSYMBEG string_contents tSTRING_END",
    "numeric : simple_numeric",
    "numeric : tUMINUS_NUM simple_numeric",
    "simple_numeric : tINTEGER",
    "simple_numeric : tFLOAT",
    "simple_numeric : tRATIONAL",
    "simple_numeric : tIMAGINARY",
    "var_ref : tIDENTIFIER",
    "var_ref : tIVAR",
    "var_ref : tGVAR",
    "var_ref : tCONSTANT",
    "var_ref : tCVAR",
    "var_ref : keyword_nil",
    "var_ref : keyword_self",
    "var_ref : keyword_true",
    "var_ref : keyword_false",
    "var_ref : keyword__FILE__",
    "var_ref : keyword__LINE__",
    "var_ref : keyword__ENCODING__",
    "var_lhs : tIDENTIFIER",
    "var_lhs : tIVAR",
    "var_lhs : tGVAR",
    "var_lhs : tCONSTANT",
    "var_lhs : tCVAR",
    "var_lhs : keyword_nil",
    "var_lhs : keyword_self",
    "var_lhs : keyword_true",
    "var_lhs : keyword_false",
    "var_lhs : keyword__FILE__",
    "var_lhs : keyword__LINE__",
    "var_lhs : keyword__ENCODING__",
    "backref : tNTH_REF",
    "backref : tBACK_REF",
    "$$33 :",
    "superclass : tLT $$33 expr_value term",
    "superclass :",
    "f_arglist : tLPAREN2 f_args rparen",
    "$$34 :",
    "f_arglist : $$34 f_args term",
    "args_tail : f_kwarg ',' f_kwrest opt_f_block_arg",
    "args_tail : f_kwarg opt_f_block_arg",
    "args_tail : f_kwrest opt_f_block_arg",
    "args_tail : f_block_arg",
    "opt_args_tail : ',' args_tail",
    "opt_args_tail :",
    "f_args : f_arg ',' f_optarg ',' f_rest_arg opt_args_tail",
    "f_args : f_arg ',' f_optarg ',' f_rest_arg ',' f_arg opt_args_tail",
    "f_args : f_arg ',' f_optarg opt_args_tail",
    "f_args : f_arg ',' f_optarg ',' f_arg opt_args_tail",
    "f_args : f_arg ',' f_rest_arg opt_args_tail",
    "f_args : f_arg ',' f_rest_arg ',' f_arg opt_args_tail",
    "f_args : f_arg opt_args_tail",
    "f_args : f_optarg ',' f_rest_arg opt_args_tail",
    "f_args : f_optarg ',' f_rest_arg ',' f_arg opt_args_tail",
    "f_args : f_optarg opt_args_tail",
    "f_args : f_optarg ',' f_arg opt_args_tail",
    "f_args : f_rest_arg opt_args_tail",
    "f_args : f_rest_arg ',' f_arg opt_args_tail",
    "f_args : args_tail",
    "f_args :",
    "f_bad_arg : tCONSTANT",
    "f_bad_arg : tIVAR",
    "f_bad_arg : tGVAR",
    "f_bad_arg : tCVAR",
    "f_norm_arg : f_bad_arg",
    "f_norm_arg : tIDENTIFIER",
    "f_arg_asgn : f_norm_arg",
    "f_arg_item : f_arg_asgn",
    "f_arg_item : tLPAREN f_margs rparen",
    "f_arg : f_arg_item",
    "f_arg : f_arg ',' f_arg_item",
    "f_label : tLABEL",
    "f_kw : f_label arg_value",
    "f_kw : f_label",
    "f_block_kw : f_label primary_value",
    "f_block_kw : f_label",
    "f_block_kwarg : f_block_kw",
    "f_block_kwarg : f_block_kwarg ',' f_block_kw",
    "f_kwarg : f_kw",
    "f_kwarg : f_kwarg ',' f_kw",
    "kwrest_mark : tPOW",
    "kwrest_mark : tDSTAR",
    "f_kwrest : kwrest_mark tIDENTIFIER",
    "f_kwrest : kwrest_mark",
    "f_opt : f_arg_asgn '=' arg_value",
    "f_block_opt : f_arg_asgn '=' primary_value",
    "f_block_optarg : f_block_opt",
    "f_block_optarg : f_block_optarg ',' f_block_opt",
    "f_optarg : f_opt",
    "f_optarg : f_optarg ',' f_opt",
    "restarg_mark : tSTAR2",
    "restarg_mark : tSTAR",
    "f_rest_arg : restarg_mark tIDENTIFIER",
    "f_rest_arg : restarg_mark",
    "blkarg_mark : tAMPER2",
    "blkarg_mark : tAMPER",
    "f_block_arg : blkarg_mark tIDENTIFIER",
    "opt_f_block_arg : ',' f_block_arg",
    "opt_f_block_arg :",
    "singleton : var_ref",
    "$$35 :",
    "singleton : tLPAREN2 $$35 expr rparen",
    "assoc_list : none",
    "assoc_list : assocs trailer",
    "assocs : assoc",
    "assocs : assocs ',' assoc",
    "assoc : arg_value tASSOC arg_value",
    "assoc : tLABEL arg_value",
    "assoc : tSTRING_BEG string_contents tLABEL_END arg_value",
    "assoc : tDSTAR arg_value",
    "operation : tIDENTIFIER",
    "operation : tCONSTANT",
    "operation : tFID",
    "operation2 : tIDENTIFIER",
    "operation2 : tCONSTANT",
    "operation2 : tFID",
    "operation2 : op",
    "operation3 : tIDENTIFIER",
    "operation3 : tFID",
    "operation3 : op",
    "dot_or_colon : tDOT",
    "dot_or_colon : tCOLON2",
    "call_op : tDOT",
    "call_op : tANDDOT",
    "call_op2 : call_op",
    "call_op2 : tCOLON2",
    "opt_terms :",
    "opt_terms : terms",
    "opt_nl :",
    "opt_nl : '\\n'",
    "rparen : opt_nl tRPAREN",
    "rbracket : opt_nl tRBRACK",
    "trailer :",
    "trailer : '\\n'",
    "trailer : ','",
    "term : ';'",
    "term : '\\n'",
    "terms : term",
    "terms : terms ';'",
    "none :",
    "none_block_pass :",
    };

  protected org.jruby.parser.YYDebug yydebug;

  /** index-checked interface to {@link #yyNames}.
      @param token single character or <tt>%token</tt> value.
      @return token name or <tt>[illegal]</tt> or <tt>[unknown]</tt>.
    */
  public static final String yyName (int token) {
    if (token < 0 || token > yyNames.length) return "[illegal]";
    String name;
    if ((name = yyNames[token]) != null) return name;
    return "[unknown]";
  }


  /** computes list of expected tokens on error by tracing the tables.
      @param state for which to compute the list.
      @return list of token names.
    */
  protected String[] yyExpecting (int state) {
    int token, n, len = 0;
    boolean[] ok = new boolean[yyNames.length];

    if ((n = yySindex[state]) != 0)
      for (token = n < 0 ? -n : 0;
           token < yyNames.length && n+token < yyTable.length; ++ token)
        if (yyCheck[n+token] == token && !ok[token] && yyNames[token] != null) {
          ++ len;
          ok[token] = true;
        }
    if ((n = yyRindex[state]) != 0)
      for (token = n < 0 ? -n : 0;
           token < yyNames.length && n+token < yyTable.length; ++ token)
        if (yyCheck[n+token] == token && !ok[token] && yyNames[token] != null) {
          ++ len;
          ok[token] = true;
        }

    String result[] = new String[len];
    for (n = token = 0; n < len;  ++ token)
      if (ok[token]) result[n++] = yyNames[token];
    return result;
  }

  /** the generated parser, with debugging messages.
      Maintains a dynamic state and value stack.
      @param yyLex scanner.
      @param ayydebug debug message writer implementing <tt>yyDebug</tt>, or <tt>null</tt>.
      @return result of the last reduction, if any.
    */
  public Object yyparse (RipperLexer yyLex, Object ayydebug)
				throws java.io.IOException {
    this.yydebug = (org.jruby.parser.YYDebug)ayydebug;
    return yyparse(yyLex);
  }

  /** initial size and increment of the state/value stack [default 256].
      This is not final so that it can be overwritten outside of invocations
      of {@link #yyparse}.
    */
  protected int yyMax;

  /** executed at the beginning of a reduce action.
      Used as <tt>$$ = yyDefault($1)</tt>, prior to the user-specified action, if any.
      Can be overwritten to provide deep copy, etc.
      @param first value for <tt>$1</tt>, or <tt>null</tt>.
      @return first.
    */
  protected Object yyDefault (Object first) {
    return first;
  }

  /** the generated parser.
      Maintains a dynamic state and value stack.
      @param yyLex scanner.
      @return result of the last reduction, if any.
    */
  public Object yyparse (RipperLexer yyLex) throws java.io.IOException {
    if (yyMax <= 0) yyMax = 256;			// initial size
    int yyState = 0, yyStates[] = new int[yyMax];	// state stack
    Object yyVal = null, yyVals[] = new Object[yyMax];	// value stack
    int yyToken = -1;					// current input
    int yyErrorFlag = 0;				// #tokens to shift

    yyLoop: for (int yyTop = 0;; ++ yyTop) {
      if (yyTop >= yyStates.length) {			// dynamically increase
        int[] i = new int[yyStates.length+yyMax];
        System.arraycopy(yyStates, 0, i, 0, yyStates.length);
        yyStates = i;
        Object[] o = new Object[yyVals.length+yyMax];
        System.arraycopy(yyVals, 0, o, 0, yyVals.length);
        yyVals = o;
      }
      yyStates[yyTop] = yyState;
      yyVals[yyTop] = yyVal;
      if (yydebug != null) yydebug.push(yyState, yyVal);

      yyDiscarded: for (;;) {	// discarding a token does not change stack
        int yyN;
        if ((yyN = yyDefRed[yyState]) == 0) {	// else [default] reduce (yyN)
          if (yyToken < 0) {
//            yyToken = yyLex.advance() ? yyLex.token() : 0;
            yyToken = yyLex.nextToken();
            if (yydebug != null)
              yydebug.lex(yyState, yyToken, yyName(yyToken), yyLex.value());
          }
          if ((yyN = yySindex[yyState]) != 0 && (yyN += yyToken) >= 0
              && yyN < yyTable.length && yyCheck[yyN] == yyToken) {
            if (yydebug != null)
              yydebug.shift(yyState, yyTable[yyN], yyErrorFlag-1);
            yyState = yyTable[yyN];		// shift to yyN
            yyVal = yyLex.value();
            yyToken = -1;
            if (yyErrorFlag > 0) -- yyErrorFlag;
            continue yyLoop;
          }
          if ((yyN = yyRindex[yyState]) != 0 && (yyN += yyToken) >= 0
              && yyN < yyTable.length && yyCheck[yyN] == yyToken)
            yyN = yyTable[yyN];			// reduce (yyN)
          else
            switch (yyErrorFlag) {
  
            case 0:
              yyerror("syntax error", yyExpecting(yyState), yyNames[yyToken]);
              if (yydebug != null) yydebug.error("syntax error");
  
            case 1: case 2:
              yyErrorFlag = 3;
              do {
                if ((yyN = yySindex[yyStates[yyTop]]) != 0
                    && (yyN += yyErrorCode) >= 0 && yyN < yyTable.length
                    && yyCheck[yyN] == yyErrorCode) {
                  if (yydebug != null)
                    yydebug.shift(yyStates[yyTop], yyTable[yyN], 3);
                  yyState = yyTable[yyN];
                  yyVal = yyLex.value();
                  continue yyLoop;
                }
                if (yydebug != null) yydebug.pop(yyStates[yyTop]);
              } while (-- yyTop >= 0);
              if (yydebug != null) yydebug.reject();
              yyerror("irrecoverable syntax error");
  
            case 3:
              if (yyToken == 0) {
                if (yydebug != null) yydebug.reject();
                yyerror("irrecoverable syntax error at end-of-file");
              }
              if (yydebug != null)
                yydebug.discard(yyState, yyToken, yyName(yyToken),
  							yyLex.value());
              yyToken = -1;
              continue yyDiscarded;		// leave stack alone
            }
        }
        int yyV = yyTop + 1-yyLen[yyN];
        if (yydebug != null)
          yydebug.reduce(yyState, yyStates[yyV-1], yyN, yyRule[yyN], yyLen[yyN]);
        RipperParserState state = states[yyN];
        if (state == null) {
            yyVal = yyDefault(yyV > yyTop ? null : yyVals[yyV]);
        } else {
            yyVal = state.execute(this, yyVal, yyVals, yyTop);
        }
//        switch (yyN) {
// ACTIONS_END
//        }
        yyTop -= yyLen[yyN];
        yyState = yyStates[yyTop];
        int yyM = yyLhs[yyN];
        if (yyState == 0 && yyM == 0) {
          if (yydebug != null) yydebug.shift(0, yyFinal);
          yyState = yyFinal;
          if (yyToken < 0) {
            yyToken = yyLex.nextToken();
//            yyToken = yyLex.advance() ? yyLex.token() : 0;
            if (yydebug != null)
               yydebug.lex(yyState, yyToken,yyName(yyToken), yyLex.value());
          }
          if (yyToken == 0) {
            if (yydebug != null) yydebug.accept(yyVal);
            return yyVal;
          }
          continue yyLoop;
        }
        if ((yyN = yyGindex[yyM]) != 0 && (yyN += yyState) >= 0
            && yyN < yyTable.length && yyCheck[yyN] == yyState)
          yyState = yyTable[yyN];
        else
          yyState = yyDgoto[yyM];
        if (yydebug != null) yydebug.shift(yyStates[yyTop], yyState);
        continue yyLoop;
      }
    }
  }

static RipperParserState[] states = new RipperParserState[656];
static {
states[1] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  p.setState(EXPR_BEG);
                  p.pushLocalScope();
  return yyVal;
};
states[2] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = p.dispatch("on_program", ((IRubyObject)yyVals[0+yyTop]));
                  p.popCurrentScope();
  return yyVal;
};
states[3] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[4] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), p.dispatch("on_void_stmt"));
  return yyVal;
};
states[5] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[6] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = p.dispatch("on_stmts_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[7] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[9] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[10] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  if (p.isInDef()) p.yyerror("BEGIN in method");
                  yyVal = p.dispatch("on_BEGIN", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[11] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  if (((IRubyObject)yyVals[-1+yyTop]) == null) p.yyerror("else without rescue is useless");
  return yyVal;
};
states[12] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = p.dispatch("on_bodystmt", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[13] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = p.dispatch("on_bodystmt", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[14] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[15] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), p.dispatch("on_void_stmt"));
  return yyVal;
};
states[16] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[17] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_stmts_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[18] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[19] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[20] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("BEGIN is permitted only at toplevel");
  return yyVal;
};
states[21] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[22] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_FNAME|EXPR_FITEM);
  return yyVal;
};
states[23] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_alias", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[24] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_alias", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[25] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_alias", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[26] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_alias_error", p.dispatch("on_var_alias", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
  return yyVal;
};
states[27] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_undef", ((RubyArray)yyVals[0+yyTop]));
  return yyVal;
};
states[28] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_if_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
  return yyVal;
};
states[29] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unless_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
  return yyVal;
};
states[30] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_while_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
  return yyVal;
};
states[31] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_until_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
  return yyVal;
};
states[32] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_rescue_mod", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[33] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    if (p.isInDef()) {
                        p.warn("END in method; use at_exit");
                    }
                    yyVal = p.dispatch("on_END", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[35] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_massign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[36] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[37] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_massign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[39] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[40] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[41] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_aref_field", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[42] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[43] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field",((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[44] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[-1+yyTop]),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[45] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[46] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_assign", 
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
  return yyVal;
};
states[47] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[48] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_rescue_mod", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[51] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("and"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[52] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("or"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[53] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("not"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[54] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("!"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[56] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[60] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_arg", 
                                    p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[61] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[63] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_command", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[64] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_command", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[65] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_command_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[66] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop])); 
  return yyVal;
};
states[67] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_command_call", ((IRubyObject)yyVals[-3+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[68] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[69] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_super", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[70] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_yield", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[71] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_return", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[72] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_break", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[73] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_next", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[75] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[77] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[78] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[79] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[80] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[81] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post",
                                    p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[82] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-1+yyTop]), null);
  return yyVal;
};
states[83] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post",
                                    p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-3+yyTop]), null),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[84] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[85] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post",
                                    p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[86] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), null);
  return yyVal;
};
states[87] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post",
                                    p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), null),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[89] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[90] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[91] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[92] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[93] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[94] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.assignableIdentifier(p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[95] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[96] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[97] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.assignableConstant(p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[98] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[99] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[100] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[101] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[102] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[103] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[104] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[105] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to __ENCODING__");
  return yyVal;
};
states[106] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_aref_field", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[107] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
                    
  return yyVal;
};
states[108] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[109] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
		    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[110] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef()) {
                        yyVal = p.dispatch("on_assign_error", ((IRubyObject)yyVal));
                        p.error();
                    }
  return yyVal;
};
states[111] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_top_const_field", ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef()) {
                        yyVal = p.dispatch("on_assign_error", ((IRubyObject)yyVal));
                        p.error();
                    }
  return yyVal;
};
states[112] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error", p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
  return yyVal;
};
states[113] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", p.assignableIdentifier(((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[114] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[115] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[116] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.assignableConstant(p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[117] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[118] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[119] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[120] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[121] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[122] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[123] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[124] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[125] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_aref_field", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[126] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[127] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), p.intern("::"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[128] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[129] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    IRubyObject val = p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef()) {
                        val = p.dispatch("on_assign_error", val);
                        p.error();
                    }

                    yyVal = val;
  return yyVal;
};
states[130] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    IRubyObject val = p.dispatch("on_top_const_field", ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef()) {
                        val = p.dispatch("on_assign_error", val);
                        p.error();
                    }

                    yyVal = val;
  return yyVal;
};
states[131] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error",
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
  return yyVal;
};
states[132] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_class_name_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
  return yyVal;
};
states[134] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_top_const_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[135] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_const_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[136] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_const_path_ref", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[140] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   p.setState(EXPR_ENDFN);
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[141] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   p.setState(EXPR_ENDFN);
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[142] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[143] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[144] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.dispatch("on_symbol_literal", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[145] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[146] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[147] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_FNAME|EXPR_FITEM);
  return yyVal;
};
states[148] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-3+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[224] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[225] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[226] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_aref_field", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[227] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[228] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[229] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[230] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_opassign", 
                                               p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                               ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[231] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_opassign", 
                                               p.dispatch("on_top_const_field", ((IRubyObject)yyVals[-2+yyTop])),
                                               ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[232] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_opassign",
                                               p.dispatch("on_var_field", ((IRubyObject)yyVals[-2+yyTop])),
                                               ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
  return yyVal;
};
states[233] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_dot2", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[234] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_dot3", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[235] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_dot2", ((IRubyObject)yyVals[-1+yyTop]), p.new_nil_at());
  return yyVal;
};
states[236] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_dot3", ((IRubyObject)yyVals[-1+yyTop]), p.new_nil_at());
  return yyVal;
};
states[237] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("+"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[238] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("-"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[239] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("*"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[240] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("/"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[241] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("%"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[242] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("**"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[243] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", 
                                    p.intern("-@"), 
                                    p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("**"), ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[244] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("+@"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[245] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("-@"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[246] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("|"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[247] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("^"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[248] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("&"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[249] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("<=>"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[250] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[251] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("=="), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[252] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("==="), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[253] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("!="), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[254] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("=~"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[255] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("!~"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[256] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("!"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[257] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("~"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[258] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("<<"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[259] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern(">>"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[260] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("&&"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[261] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("||"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[262] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_defined", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[263] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_ifop", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[264] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[265] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.intern(">");
  return yyVal;
};
states[266] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.intern("<");
  return yyVal;
};
states[267] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.intern(">=");
  return yyVal;
};
states[268] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.intern("<=");
  return yyVal;
};
states[269] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

  return yyVal;
};
states[270] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     p.warning("comparison '" + ((IRubyObject)yyVals[-1+yyTop]) + "' after comparison");
                     yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[271] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[273] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[274] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", 
                                    ((IRubyObject)yyVals[-3+yyTop]),
                                    p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
  return yyVal;
};
states[275] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", 
                                    p.dispatch("on_args_new"),
                                    p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
  return yyVal;
};
states[276] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[277] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_rescue_mod", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[278] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_arg_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[283] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[284] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", ((IRubyObject)yyVals[-3+yyTop]), p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
  return yyVal;
};
states[285] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", 
                                    p.dispatch("on_args_new"),
                                    p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
  return yyVal;
};
states[286] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[287] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.arg_add_optblock(((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[288] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal =  p.arg_add_optblock(p.dispatch("on_args_add", 
                                                        p.dispatch("on_args_new"),
                                                        p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop]))),
                                             ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[289] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.arg_add_optblock(p.dispatch("on_args_add", 
                                            ((IRubyObject)yyVals[-3+yyTop]),
                                            p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop]))),
                                            ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[290] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add_block", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[291] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = Long.valueOf(p.getCmdArgumentState().getStack());
                    p.getCmdArgumentState().begin();
  return yyVal;
};
states[292] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getCmdArgumentState().reset(((Long)yyVals[-1+yyTop]).longValue());
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[293] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[294] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[296] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[297] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add_star", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[298] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[299] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_args_add_star", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[300] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[301] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[302] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mrhs_add", 
                                    p.dispatch("on_mrhs_new_from_args", ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[303] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mrhs_add_star",
                                    p.dispatch("on_mrhs_new_from_args", ((IRubyObject)yyVals[-3+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[304] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mrhs_add_star", p.dispatch("on_mrhs_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[311] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]); /* FIXME: Why complaining without $$ = $1;*/
  return yyVal;
};
states[312] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]); /* FIXME: Why complaining without $$ = $1;*/
  return yyVal;
};
states[315] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_arg", p.dispatch("on_fcall", ((IRubyObject)yyVals[0+yyTop])), p.dispatch("on_args_new"));
  return yyVal;
};
states[316] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.getCmdArgumentState().getStack();
                    p.getCmdArgumentState().reset();
  return yyVal;
};
states[317] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getCmdArgumentState().reset(((Long)yyVals[-2+yyTop]).longValue());
                    yyVal = p.dispatch("on_begin", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[318] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_ENDARG);
  return yyVal;
};
states[319] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_paren", null);
  return yyVal;
};
states[320] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.getCmdArgumentState().getStack();
                    p.getCmdArgumentState().reset();
  return yyVal;
};
states[321] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_ENDARG); 
  return yyVal;
};
states[322] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getCmdArgumentState().reset(((Long)yyVals[-3+yyTop]).longValue());
                    p.warning("(...) interpreted as grouped expression");
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-2+yyTop]));
  return yyVal;
};
states[323] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[324] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_const_path_ref", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[325] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_top_const_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[326] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[327] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_hash", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[328] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_return0");
  return yyVal;
};
states[329] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_yield", p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop])));
  return yyVal;
};
states[330] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_yield", p.dispatch("on_paren", p.dispatch("on_args_new")));
  return yyVal;
};
states[331] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_yield0");
  return yyVal;
};
states[332] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_defined", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[333] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("not"), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[334] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("not"), null);
  return yyVal;
};
states[335] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_method_add_arg", 
                                               p.dispatch("on_fcall", ((IRubyObject)yyVals[-1+yyTop])), 
                                               p.dispatch("on_args_new")), 
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[337] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_block", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[338] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[339] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_if", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[340] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unless", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[341] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getConditionState().begin();
  return yyVal;
};
states[342] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getConditionState().end();
  return yyVal;
};
states[343] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_while", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[344] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  p.getConditionState().begin();
  return yyVal;
};
states[345] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  p.getConditionState().end();
  return yyVal;
};
states[346] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_until", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[347] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_case", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[348] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_case", null, ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[349] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getConditionState().begin();
  return yyVal;
};
states[350] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getConditionState().end();
  return yyVal;
};
states[351] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_for", ((IRubyObject)yyVals[-7+yyTop]), ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[352] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    if (p.isInDef()) {
                        p.yyerror("class definition in method body");
                    }
                    p.pushLocalScope();
                    yyVal = p.isInClass(); /* MRI reuses $1 but we use the value for position.*/
                    p.setIsInClass(true);
  return yyVal;
};
states[353] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_class", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
                    p.setIsInClass(((Boolean)yyVals[-2+yyTop]).booleanValue());
  return yyVal;
};
states[354] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = new Integer((p.isInClass() ? 0b10 : 0) |
                                     (p.isInDef()   ? 0b01 : 0));
                    p.setInDef(false);
                    p.setIsInClass(false);
                    p.pushLocalScope();
  return yyVal;
};
states[355] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_sclass", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));

                    p.popCurrentScope();
                    p.setInDef(((((Integer)yyVals[-3+yyTop]).intValue())     & 0b01) != 0);
                    p.setIsInClass(((((Integer)yyVals[-3+yyTop]).intValue()) & 0b10) != 0);
  return yyVal;
};
states[356] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    if (p.isInDef()) { 
                        p.yyerror("module definition in method body");
                    }
                    yyVal = p.isInClass();
                    p.setIsInClass(true);
                    p.pushLocalScope();
  return yyVal;
};
states[357] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_module", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
  return yyVal;
};
states[358] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setInDef(true);
                    p.pushLocalScope();
                    yyVal = p.getCurrentArg();
                    p.setCurrentArg(null);
  return yyVal;
};
states[359] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_def", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));

                    p.popCurrentScope();
                    p.setInDef(false);
                    p.setCurrentArg(((IRubyObject)yyVals[-3+yyTop]));
  return yyVal;
};
states[360] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_FNAME);
                    yyVal = p.isInDef();
                    p.setInDef(true);
  return yyVal;
};
states[361] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.pushLocalScope();
                    p.setState(EXPR_ENDFN|EXPR_LABEL); /* force for args */
                    yyVal = p.getCurrentArg();
                    p.setCurrentArg(null);                    
  return yyVal;
};
states[362] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_defs", ((IRubyObject)yyVals[-7+yyTop]), ((IRubyObject)yyVals[-6+yyTop]), ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));

                    p.popCurrentScope();
                    p.setInDef(((Boolean)yyVals[-5+yyTop]).booleanValue());
                    p.setCurrentArg(((IRubyObject)yyVals[-3+yyTop]));
  return yyVal;
};
states[363] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_break", p.dispatch("on_args_new"));
  return yyVal;
};
states[364] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_next", p.dispatch("on_args_new"));
  return yyVal;
};
states[365] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_redo");
  return yyVal;
};
states[366] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_retry");
  return yyVal;
};
states[367] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[368] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[369] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[370] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[371] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    if (p.isInClass() && !p.isInDef() && !p.getCurrentScope().isBlockScope()) {
                        p.compile_error("Invalid return in class/module body");
                    }
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[372] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = null;
  return yyVal;
};
states[374] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[375] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = null;
  return yyVal;
};
states[378] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_elsif", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[380] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_else", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[382] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
  return yyVal;
};
states[383] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[384] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[385] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[386] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[387] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[388] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[389] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post", 
                                    p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[390] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-2+yyTop]), null);
  return yyVal;
};
states[391] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post", 
                                    p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-4+yyTop]), null),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[392] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star",
                                    p.dispatch("on_mlhs_new"),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[393] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post", 
                                    p.dispatch("on_mlhs_add_star",
                                               p.dispatch("on_mlhs_new"),
                                               ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[394] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_star",
                                    p.dispatch("on_mlhs_new"),
                                    null);
  return yyVal;
};
states[395] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_add_post", 
                                    p.dispatch("on_mlhs_add_star",
                                               p.dispatch("on_mlhs_new"),
                                               null),
                                    ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[396] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[397] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-1+yyTop]), null, ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[398] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(null, ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[399] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(null, null, ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[400] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((ArgsTailHolder)yyVals[0+yyTop]);
  return yyVal;
};
states[401] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(null, null, null);
  return yyVal;
};
states[402] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[403] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-7+yyTop]), ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[404] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[405] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[406] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[407] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_excessed_comma", 
                                    p.new_args(((RubyArray)yyVals[-1+yyTop]), null, null, null, null));
  return yyVal;
};
states[408] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[409] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-1+yyTop]), null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[410] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[411] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[412] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[413] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[414] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));     
  return yyVal;
};
states[415] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[416] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[418] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCommandStart(true);
  return yyVal;
};
states[419] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);  
                    yyVal = p.dispatch("on_block_var", 
                                    p.new_args(null, null, null, null, null), 
                                    ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[420] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_block_var", 
                                    p.new_args(null, null, null, null, null), 
                                    null);
  return yyVal;
};
states[421] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);
                    yyVal = p.dispatch("on_block_var", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[422] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.getContext().getRuntime().getFalse();
  return yyVal;
};
states[423] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-1+yyTop]);
  return yyVal;
};
states[424] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[425] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[426] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_bv(((IRubyObject)yyVals[0+yyTop]));

  return yyVal;
};
states[427] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = null;
  return yyVal;
};
states[428] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.pushBlockScope();
                    yyVal = p.getLeftParenBegin();
                    p.setLeftParenBegin(p.incrementParenNest());
  return yyVal;
};
states[429] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = Long.valueOf(p.getCmdArgumentState().getStack());
                    p.getCmdArgumentState().reset();
  return yyVal;
};
states[430] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.getCmdArgumentState().reset(((Long)yyVals[-1+yyTop]).longValue());
                    p.getCmdArgumentState().restart();
                    yyVal = p.dispatch("on_lambda", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
                    p.setLeftParenBegin(((Integer)yyVals[-3+yyTop]));
                    p.popCurrentScope();
  return yyVal;
};
states[431] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-2+yyTop]));
  return yyVal;
};
states[432] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[433] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[434] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[435] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);  
  return yyVal;
};
states[436] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_block", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[437] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[438] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_add_block(p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[439] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_add_block(p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[440] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_method_add_arg", p.dispatch("on_fcall", ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[441] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[442] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[443] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_call", ((IRubyObject)yyVals[-2+yyTop]), p.intern("::"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[444] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), p.intern("call")), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[445] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-2+yyTop]), p.intern("::"), p.intern("call")), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[446] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_super", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[447] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_zsuper");
  return yyVal;
};
states[448] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_aref", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[449] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[450] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[451] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.pushBlockScope();
                    yyVal = Long.valueOf(p.getCmdArgumentState().getStack()) >> 1;
                    p.getCmdArgumentState().reset();
  return yyVal;
};
states[452] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_brace_block", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
                    p.getCmdArgumentState().reset(((Long)yyVals[-2+yyTop]).longValue());
                    p.popCurrentScope();
  return yyVal;
};
states[453] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.pushBlockScope();
                    yyVal = Long.valueOf(p.getCmdArgumentState().getStack());
                    p.getCmdArgumentState().reset();
  return yyVal;
};
states[454] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_do_block", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
                    p.getCmdArgumentState().reset(((Long)yyVals[-2+yyTop]).longValue());
                    p.popCurrentScope();
  return yyVal;
};
states[455] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_when", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

  return yyVal;
};
states[458] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_rescue", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[459] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = null;
  return yyVal;
};
states[460] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[461] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[463] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[465] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_ensure", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[468] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_symbol_literal", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[470] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[471] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[472] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[473] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_string_concat", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[474] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.heredoc_dedent(((IRubyObject)yyVals[-1+yyTop]));
                    p.setHeredocIndent(0);
                    yyVal = p.dispatch("on_string_literal", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[475] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.heredoc_dedent(((IRubyObject)yyVals[-1+yyTop]));
                    p.setHeredocIndent(0);
                    yyVal = p.dispatch("on_xstring_literal", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[476] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_regexp_literal", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[477] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[478] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_words_new");
  return yyVal;
};
states[479] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_words_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[480] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_word_add", p.dispatch("on_word_new"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[481] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_word_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[482] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[483] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_symbols_new");
  return yyVal;
};
states[484] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_symbols_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[485] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[486] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[487] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_qwords_new");
  return yyVal;
};
states[488] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_qwords_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[489] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_qsymbols_new");
  return yyVal;
};
states[490] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_qsymbols_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[491] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_string_content");
  return yyVal;
};
states[492] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_string_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[493] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_xstring_new");
  return yyVal;
};
states[494] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_xstring_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[495] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_regexp_new");
  return yyVal;
};
states[496] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_regexp_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[498] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.getStrTerm();
                    p.setStrTerm(null);
                    p.setState(EXPR_BEG);
  return yyVal;
};
states[499] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setStrTerm(((StrTerm)yyVals[-1+yyTop]));
                    yyVal = p.dispatch("on_string_dvar", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[500] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.getStrTerm();
                   p.setStrTerm(null);
                   p.getConditionState().stop();
  return yyVal;
};
states[501] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.getCmdArgumentState().getStack();
                   p.getCmdArgumentState().reset();
  return yyVal;
};
states[502] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.getState();
                   p.setState(EXPR_BEG);
  return yyVal;
};
states[503] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.getBraceNest();
                   p.setBraceNest(0);
  return yyVal;
};
states[504] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.getHeredocIndent();
                   p.setHeredocIndent(0);
  return yyVal;
};
states[505] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   p.getConditionState().restart();
                   p.setStrTerm(((StrTerm)yyVals[-6+yyTop]));
                   p.getCmdArgumentState().reset(((Long)yyVals[-5+yyTop]).longValue());
                   p.setState(((Integer)yyVals[-4+yyTop]));
                   p.setBraceNest(((Integer)yyVals[-3+yyTop]));
                   p.setHeredocIndent(((Integer)yyVals[-2+yyTop]));
                   yyVal = p.dispatch("on_string_embexpr", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[506] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[507] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[508] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[510] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     p.setState(EXPR_END|EXPR_ENDARG);
                     yyVal = p.dispatch("on_symbol", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[515] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     p.setState(EXPR_END|EXPR_ENDARG);
                     yyVal = p.dispatch("on_dyna_symbol", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[516] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[517] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_unary", p.intern("-@"), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[518] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[519] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[520] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[521] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[522] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    if (p.is_id_var()) {
                        yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
                    } else {
                        yyVal = p.dispatch("on_vcall", ((IRubyObject)yyVals[0+yyTop]));
                    }
  return yyVal;
};
states[523] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[524] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[525] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[526] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[527] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[528] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[529] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[530] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[531] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[532] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[533] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[534] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", p.assignableIdentifier(((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[535] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[536] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[537] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.assignableConstant(p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[538] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[539] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to nil");
  return yyVal;
};
states[540] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't change the value of self");
  return yyVal;
};
states[541] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to true");
  return yyVal;
};
states[542] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to false");
  return yyVal;
};
states[543] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to __FILE__");
  return yyVal;
};
states[544] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to __LINE__");
  return yyVal;
};
states[545] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.yyerror("Can't assign to __ENCODING__");
  return yyVal;
};
states[548] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   p.setState(EXPR_BEG);
                   p.setCommandStart(true);
  return yyVal;
};
states[549] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
  return yyVal;
};
states[550] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = null;
  return yyVal;
};
states[551] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_BEG);
                    p.setCommandStart(true);
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[552] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
  /* $$ = lexer.inKwarg;*/
                   /*                   p.inKwarg = true;*/
                   p.setState(p.getState() | EXPR_LABEL);
  return yyVal;
};
states[553] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
  /* p.inKwarg = $<Boolean>1;*/
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
                    p.setState(EXPR_BEG);
                    p.setCommandStart(true);
  return yyVal;
};
states[554] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[555] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-1+yyTop]), null, ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[556] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(null, ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[557] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(null, null, ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[558] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((ArgsTailHolder)yyVals[0+yyTop]);
  return yyVal;
};
states[559] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args_tail(null, null, null);
  return yyVal;
};
states[560] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[561] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-7+yyTop]), ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[562] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[563] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[564] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[565] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[566] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(((RubyArray)yyVals[-1+yyTop]), null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[567] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[568] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[569] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[570] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[571] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[572] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[573] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
  return yyVal;
};
states[574] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_args(null, null, null, null, null);
  return yyVal;
};
states[575] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
  return yyVal;
};
states[576] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
  return yyVal;
};
states[577] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
  return yyVal;
};
states[578] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
  return yyVal;
};
states[580] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.arg_var(p.formal_argument(((IRubyObject)yyVals[0+yyTop])));
  return yyVal;
};
states[581] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(((IRubyObject)yyVals[0+yyTop]));
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[582] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[583] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[584] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[585] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[586] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.arg_var(p.formal_argument(((IRubyObject)yyVals[0+yyTop])));
                    p.setCurrentArg(((IRubyObject)yyVals[0+yyTop]));
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[587] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[588] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[0+yyTop]), p.getContext().getRuntime().getFalse());
  return yyVal;
};
states[589] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[590] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[0+yyTop]), p.getContext().getRuntime().getFalse());
  return yyVal;
};
states[591] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[592] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[593] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[594] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[595] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[596] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[597] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.shadowing_lvar(((IRubyObject)yyVals[0+yyTop]));
                    yyVal = p.dispatch("on_kwrest_param", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[598] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_kwrest_param", null);
  return yyVal;
};
states[599] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);
                    yyVal = p.new_assoc(((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

  return yyVal;
};
states[600] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setCurrentArg(null);
                    yyVal = p.new_assoc(((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[601] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[602] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[603] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[604] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[607] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.arg_var(p.shadowing_lvar(((IRubyObject)yyVals[0+yyTop])));
                    yyVal = p.dispatch("on_rest_param", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[608] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_rest_param", null);
  return yyVal;
};
states[611] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.arg_var(p.shadowing_lvar(((IRubyObject)yyVals[0+yyTop])));
                    yyVal = p.dispatch("on_blockarg", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[612] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[613] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = null;
  return yyVal;
};
states[614] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[615] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    p.setState(EXPR_BEG);
  return yyVal;
};
states[616] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop]));
  return yyVal;
};
states[618] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assoclist_from_args", ((RubyArray)yyVals[-1+yyTop]));
  return yyVal;
};
states[619] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[620] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[621] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assoc_new", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[622] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assoc_new", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[623] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assoc_new", p.dispatch("on_dyna_symbol", ((IRubyObject)yyVals[-2+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[624] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.dispatch("on_assoc_splat", ((IRubyObject)yyVals[0+yyTop]));
  return yyVal;
};
states[635] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[636] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[637] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.intern(".");
  return yyVal;
};
states[638] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = p.intern("&.");
  return yyVal;
};
states[639] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[640] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                   yyVal = p.intern("::");
  return yyVal;
};
states[645] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[646] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
  return yyVal;
};
states[654] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                      yyVal = null;
  return yyVal;
};
states[655] = (RipperParser p, Object yyVal, Object[] yyVals, int yyTop) -> {
                  yyVal = null;
  return yyVal;
};
}
					// line 2270 "RipperParser.y"
}
					// line 9865 "-"
