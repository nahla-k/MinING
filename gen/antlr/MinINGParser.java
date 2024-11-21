// Generated from C:/Users/nahla/Downloads/Segaleo-master/MinING0/src/main/java/antlr/MinING.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MinINGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LBRACE=3, RBRACE=4, EQUAL=5, SEMICOLON=6, AND=7, OR=8, 
		NOT=9, LT=10, LE=11, GT=12, GE=13, EQ=14, NEQ=15, LPAREN=16, RPAREN=17, 
		PLUS=18, MINUS=19, MULT=20, DIV=21, TO=22, COMA=23, IF=24, ELSE=25, FOR=26, 
		WRITE=27, READ=28, COMMENT=29, WS=30, TYPE=31, NUM=32, CONST=33, ID=34, 
		INTEGER=35, FLOAT=36, CHAR=37, STRING_LITERAL=38, VAR_GLOBAL=39, DECLARATION=40, 
		INSTRUCTION=41;
	public static final int
		RULE_prog = 0, RULE_globaldeclaration = 1, RULE_localdeclaration = 2, 
		RULE_declaration = 3, RULE_array_init = 4, RULE_expr = 5, RULE_initialValue = 6, 
		RULE_expr_logical = 7, RULE_expr_comparison = 8, RULE_expr_arith = 9, 
		RULE_instruction = 10, RULE_sortie = 11, RULE_entree = 12, RULE_boucle = 13, 
		RULE_condition = 14, RULE_affectation = 15, RULE_block = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "globaldeclaration", "localdeclaration", "declaration", "array_init", 
			"expr", "initialValue", "expr_logical", "expr_comparison", "expr_arith", 
			"instruction", "sortie", "entree", "boucle", "condition", "affectation", 
			"block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'{'", "'}'", "'='", "';'", "'&&'", "'||'", "'!'", 
			"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'('", "')'", "'+'", "'-'", 
			"'*'", "'/'", "':'", "','", "'IF'", "'ELSE'", "'FOR'", "'WRITE'", "'READ'", 
			null, null, null, null, "'CONST'", null, null, null, null, null, "'VAR_GLOBAL'", 
			"'DECLARATION'", "'INSTRUCTION'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LBRACE", "RBRACE", "EQUAL", "SEMICOLON", "AND", "OR", 
			"NOT", "LT", "LE", "GT", "GE", "EQ", "NEQ", "LPAREN", "RPAREN", "PLUS", 
			"MINUS", "MULT", "DIV", "TO", "COMA", "IF", "ELSE", "FOR", "WRITE", "READ", 
			"COMMENT", "WS", "TYPE", "NUM", "CONST", "ID", "INTEGER", "FLOAT", "CHAR", 
			"STRING_LITERAL", "VAR_GLOBAL", "DECLARATION", "INSTRUCTION"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MinING.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MinINGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode VAR_GLOBAL() { return getToken(MinINGParser.VAR_GLOBAL, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(MinINGParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MinINGParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MinINGParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MinINGParser.RBRACE, i);
		}
		public TerminalNode DECLARATION() { return getToken(MinINGParser.DECLARATION, 0); }
		public TerminalNode INSTRUCTION() { return getToken(MinINGParser.INSTRUCTION, 0); }
		public TerminalNode EOF() { return getToken(MinINGParser.EOF, 0); }
		public List<GlobaldeclarationContext> globaldeclaration() {
			return getRuleContexts(GlobaldeclarationContext.class);
		}
		public GlobaldeclarationContext globaldeclaration(int i) {
			return getRuleContext(GlobaldeclarationContext.class,i);
		}
		public List<LocaldeclarationContext> localdeclaration() {
			return getRuleContexts(LocaldeclarationContext.class);
		}
		public LocaldeclarationContext localdeclaration(int i) {
			return getRuleContext(LocaldeclarationContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(VAR_GLOBAL);
			setState(35);
			match(LBRACE);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==CONST) {
				{
				{
				setState(36);
				globaldeclaration();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(RBRACE);
			setState(43);
			match(DECLARATION);
			setState(44);
			match(LBRACE);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==CONST) {
				{
				{
				setState(45);
				localdeclaration();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(RBRACE);
			setState(52);
			match(INSTRUCTION);
			setState(53);
			match(LBRACE);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17666408448L) != 0)) {
				{
				{
				setState(54);
				instruction();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(RBRACE);
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobaldeclarationContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public GlobaldeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globaldeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterGlobaldeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitGlobaldeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitGlobaldeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobaldeclarationContext globaldeclaration() throws RecognitionException {
		GlobaldeclarationContext _localctx = new GlobaldeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globaldeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocaldeclarationContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public LocaldeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterLocaldeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitLocaldeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitLocaldeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocaldeclarationContext localdeclaration() throws RecognitionException {
		LocaldeclarationContext _localctx = new LocaldeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_localdeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(MinINGParser.TYPE, 0); }
		public List<TerminalNode> ID() { return getTokens(MinINGParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MinINGParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(MinINGParser.SEMICOLON, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(MinINGParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(MinINGParser.EQUAL, i);
		}
		public List<InitialValueContext> initialValue() {
			return getRuleContexts(InitialValueContext.class);
		}
		public InitialValueContext initialValue(int i) {
			return getRuleContext(InitialValueContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MinINGParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MinINGParser.COMA, i);
		}
		public TerminalNode CONST() { return getToken(MinINGParser.CONST, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(TYPE);
				setState(68);
				match(ID);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(69);
					match(EQUAL);
					setState(70);
					initialValue();
					}
				}

				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(73);
					match(COMA);
					setState(74);
					match(ID);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(75);
						match(EQUAL);
						setState(76);
						initialValue();
						}
					}

					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(SEMICOLON);
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(CONST);
				setState(86);
				match(TYPE);
				setState(87);
				match(ID);
				setState(88);
				match(EQUAL);
				{
				setState(89);
				initialValue();
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(90);
					match(COMA);
					setState(91);
					match(ID);
					setState(92);
					match(EQUAL);
					setState(93);
					initialValue();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_initContext extends ParserRuleContext {
		public List<Expr_arithContext> expr_arith() {
			return getRuleContexts(Expr_arithContext.class);
		}
		public Expr_arithContext expr_arith(int i) {
			return getRuleContext(Expr_arithContext.class,i);
		}
		public List<TerminalNode> CHAR() { return getTokens(MinINGParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(MinINGParser.CHAR, i);
		}
		public List<TerminalNode> COMA() { return getTokens(MinINGParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MinINGParser.COMA, i);
		}
		public Array_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterArray_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitArray_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitArray_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_initContext array_init() throws RecognitionException {
		Array_initContext _localctx = new Array_initContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__0);
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
			case ID:
				{
				setState(104);
				expr_arith(0);
				}
				break;
			case CHAR:
				{
				setState(105);
				match(CHAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(108);
				match(COMA);
				setState(111);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUM:
				case ID:
					{
					setState(109);
					expr_arith(0);
					}
					break;
				case CHAR:
					{
					setState(110);
					match(CHAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Expr_logicalContext expr_logical() {
			return getRuleContext(Expr_logicalContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			expr_logical(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitialValueContext extends ParserRuleContext {
		public Expr_arithContext expr_arith() {
			return getRuleContext(Expr_arithContext.class,0);
		}
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public TerminalNode CHAR() { return getToken(MinINGParser.CHAR, 0); }
		public InitialValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterInitialValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitInitialValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitInitialValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialValueContext initialValue() throws RecognitionException {
		InitialValueContext _localctx = new InitialValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_initialValue);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				expr_arith(0);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				array_init();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(CHAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_logicalContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(MinINGParser.NOT, 0); }
		public List<Expr_logicalContext> expr_logical() {
			return getRuleContexts(Expr_logicalContext.class);
		}
		public Expr_logicalContext expr_logical(int i) {
			return getRuleContext(Expr_logicalContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public Expr_comparisonContext expr_comparison() {
			return getRuleContext(Expr_comparisonContext.class,0);
		}
		public Expr_arithContext expr_arith() {
			return getRuleContext(Expr_arithContext.class,0);
		}
		public TerminalNode AND() { return getToken(MinINGParser.AND, 0); }
		public TerminalNode OR() { return getToken(MinINGParser.OR, 0); }
		public Expr_logicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_logical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterExpr_logical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitExpr_logical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitExpr_logical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_logicalContext expr_logical() throws RecognitionException {
		return expr_logical(0);
	}

	private Expr_logicalContext expr_logical(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_logicalContext _localctx = new Expr_logicalContext(_ctx, _parentState);
		Expr_logicalContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(128);
				match(NOT);
				setState(129);
				expr_logical(4);
				}
				break;
			case 2:
				{
				setState(130);
				match(LPAREN);
				setState(131);
				expr_logical(0);
				setState(132);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(134);
				expr_comparison();
				}
				break;
			case 4:
				{
				setState(135);
				expr_arith(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(144);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_logicalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_logical);
						setState(138);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(139);
						match(AND);
						setState(140);
						expr_logical(7);
						}
						break;
					case 2:
						{
						_localctx = new Expr_logicalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_logical);
						setState(141);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(142);
						match(OR);
						setState(143);
						expr_logical(6);
						}
						break;
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_comparisonContext extends ParserRuleContext {
		public List<Expr_arithContext> expr_arith() {
			return getRuleContexts(Expr_arithContext.class);
		}
		public Expr_arithContext expr_arith(int i) {
			return getRuleContext(Expr_arithContext.class,i);
		}
		public TerminalNode GT() { return getToken(MinINGParser.GT, 0); }
		public TerminalNode LT() { return getToken(MinINGParser.LT, 0); }
		public TerminalNode GE() { return getToken(MinINGParser.GE, 0); }
		public TerminalNode LE() { return getToken(MinINGParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MinINGParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MinINGParser.NEQ, 0); }
		public Expr_comparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterExpr_comparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitExpr_comparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitExpr_comparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_comparisonContext expr_comparison() throws RecognitionException {
		Expr_comparisonContext _localctx = new Expr_comparisonContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			expr_arith(0);
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(151);
			expr_arith(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_arithContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(MinINGParser.NUM, 0); }
		public TerminalNode ID() { return getToken(MinINGParser.ID, 0); }
		public List<Expr_arithContext> expr_arith() {
			return getRuleContexts(Expr_arithContext.class);
		}
		public Expr_arithContext expr_arith(int i) {
			return getRuleContext(Expr_arithContext.class,i);
		}
		public TerminalNode MULT() { return getToken(MinINGParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MinINGParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(MinINGParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MinINGParser.MINUS, 0); }
		public Expr_arithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_arith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterExpr_arith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitExpr_arith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitExpr_arith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_arithContext expr_arith() throws RecognitionException {
		return expr_arith(0);
	}

	private Expr_arithContext expr_arith(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_arithContext _localctx = new Expr_arithContext(_ctx, _parentState);
		Expr_arithContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr_arith, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(154);
				match(NUM);
				}
				break;
			case ID:
				{
				setState(155);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(164);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_arithContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_arith);
						setState(158);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(159);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						expr_arith(5);
						}
						break;
					case 2:
						{
						_localctx = new Expr_arithContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_arith);
						setState(161);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(162);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(163);
						expr_arith(4);
						}
						break;
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public AffectationContext affectation() {
			return getRuleContext(AffectationContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BoucleContext boucle() {
			return getRuleContext(BoucleContext.class,0);
		}
		public EntreeContext entree() {
			return getRuleContext(EntreeContext.class,0);
		}
		public SortieContext sortie() {
			return getRuleContext(SortieContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_instruction);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				affectation();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				condition();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				boucle();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				entree();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				sortie();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SortieContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MinINGParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MinINGParser.SEMICOLON, 0); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(MinINGParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(MinINGParser.STRING_LITERAL, i);
		}
		public List<TerminalNode> ID() { return getTokens(MinINGParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MinINGParser.ID, i);
		}
		public List<TerminalNode> COMA() { return getTokens(MinINGParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MinINGParser.COMA, i);
		}
		public SortieContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortie; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterSortie(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitSortie(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitSortie(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortieContext sortie() throws RecognitionException {
		SortieContext _localctx = new SortieContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sortie);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(WRITE);
			setState(177);
			match(LPAREN);
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(179);
				match(COMA);
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(RPAREN);
			setState(187);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntreeContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MinINGParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(MinINGParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MinINGParser.SEMICOLON, 0); }
		public EntreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterEntree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitEntree(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitEntree(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntreeContext entree() throws RecognitionException {
		EntreeContext _localctx = new EntreeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_entree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(READ);
			setState(190);
			match(LPAREN);
			setState(191);
			match(ID);
			setState(192);
			match(RPAREN);
			setState(193);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoucleContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MinINGParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(MinINGParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(MinINGParser.EQUAL, 0); }
		public List<Expr_arithContext> expr_arith() {
			return getRuleContexts(Expr_arithContext.class);
		}
		public Expr_arithContext expr_arith(int i) {
			return getRuleContext(Expr_arithContext.class,i);
		}
		public List<TerminalNode> TO() { return getTokens(MinINGParser.TO); }
		public TerminalNode TO(int i) {
			return getToken(MinINGParser.TO, i);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BoucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterBoucle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitBoucle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitBoucle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoucleContext boucle() throws RecognitionException {
		BoucleContext _localctx = new BoucleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(FOR);
			setState(196);
			match(LPAREN);
			setState(197);
			match(ID);
			setState(198);
			match(EQUAL);
			setState(199);
			expr_arith(0);
			setState(200);
			match(TO);
			setState(201);
			expr_arith(0);
			setState(202);
			match(TO);
			setState(203);
			expr_arith(0);
			setState(204);
			match(RPAREN);
			setState(205);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MinINGParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MinINGParser.ELSE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(IF);
			setState(208);
			match(LPAREN);
			setState(209);
			expr();
			setState(210);
			match(RPAREN);
			setState(211);
			block();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(212);
				match(ELSE);
				setState(213);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AffectationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MinINGParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(MinINGParser.EQUAL, 0); }
		public Expr_arithContext expr_arith() {
			return getRuleContext(Expr_arithContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MinINGParser.SEMICOLON, 0); }
		public AffectationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterAffectation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitAffectation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitAffectation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectationContext affectation() throws RecognitionException {
		AffectationContext _localctx = new AffectationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(ID);
			setState(217);
			match(EQUAL);
			setState(218);
			expr_arith(0);
			setState(219);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MinINGParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MinINGParser.RBRACE, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(LBRACE);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17666408448L) != 0)) {
				{
				{
				setState(222);
				instruction();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expr_logical_sempred((Expr_logicalContext)_localctx, predIndex);
		case 9:
			return expr_arith_sempred((Expr_arithContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_logical_sempred(Expr_logicalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean expr_arith_sempred(Expr_arithContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00e7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000/\b\u0000\n\u0000\f\u00002\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00008\b\u0000\n\u0000\f\u0000"+
		";\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003H\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003N\b\u0003\u0005\u0003P\b\u0003\n\u0003\f\u0003S\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003_\b\u0003\n\u0003"+
		"\f\u0003b\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003f\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004k\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004p\b\u0004\u0005\u0004r\b\u0004\n\u0004\f\u0004"+
		"u\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0089\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0091\b\u0007\n\u0007"+
		"\f\u0007\u0094\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u009d\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00a5\b\t\n\t\f\t\u00a8\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u00af\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00b6\b\u000b\n\u000b\f\u000b\u00b9\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00d7\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00e0\b\u0010\n\u0010\f\u0010\u00e3\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0000\u0002\u000e\u0012\u0011\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \u0000\u0004\u0001\u0000\n\u000f\u0001\u0000\u0014\u0015\u0001\u0000"+
		"\u0012\u0013\u0002\u0000\"\"&&\u00f1\u0000\"\u0001\u0000\u0000\u0000\u0002"+
		"?\u0001\u0000\u0000\u0000\u0004A\u0001\u0000\u0000\u0000\u0006e\u0001"+
		"\u0000\u0000\u0000\bg\u0001\u0000\u0000\u0000\nx\u0001\u0000\u0000\u0000"+
		"\f}\u0001\u0000\u0000\u0000\u000e\u0088\u0001\u0000\u0000\u0000\u0010"+
		"\u0095\u0001\u0000\u0000\u0000\u0012\u009c\u0001\u0000\u0000\u0000\u0014"+
		"\u00ae\u0001\u0000\u0000\u0000\u0016\u00b0\u0001\u0000\u0000\u0000\u0018"+
		"\u00bd\u0001\u0000\u0000\u0000\u001a\u00c3\u0001\u0000\u0000\u0000\u001c"+
		"\u00cf\u0001\u0000\u0000\u0000\u001e\u00d8\u0001\u0000\u0000\u0000 \u00dd"+
		"\u0001\u0000\u0000\u0000\"#\u0005\'\u0000\u0000#\'\u0005\u0003\u0000\u0000"+
		"$&\u0003\u0002\u0001\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000"+
		"\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000"+
		"\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005\u0004\u0000\u0000+,\u0005"+
		"(\u0000\u0000,0\u0005\u0003\u0000\u0000-/\u0003\u0004\u0002\u0000.-\u0001"+
		"\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000034\u0005\u0004\u0000\u000045\u0005)\u0000\u000059\u0005\u0003\u0000"+
		"\u000068\u0003\u0014\n\u000076\u0001\u0000\u0000\u00008;\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005\u0004\u0000\u0000=>\u0005"+
		"\u0000\u0000\u0001>\u0001\u0001\u0000\u0000\u0000?@\u0003\u0006\u0003"+
		"\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0003\u0006\u0003\u0000B\u0005"+
		"\u0001\u0000\u0000\u0000CD\u0005\u001f\u0000\u0000DG\u0005\"\u0000\u0000"+
		"EF\u0005\u0005\u0000\u0000FH\u0003\f\u0006\u0000GE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HQ\u0001\u0000\u0000\u0000IJ\u0005\u0017\u0000"+
		"\u0000JM\u0005\"\u0000\u0000KL\u0005\u0005\u0000\u0000LN\u0003\f\u0006"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000"+
		"\u0000\u0000OI\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000Tf\u0005\u0006\u0000\u0000UV\u0005!\u0000\u0000"+
		"VW\u0005\u001f\u0000\u0000WX\u0005\"\u0000\u0000XY\u0005\u0005\u0000\u0000"+
		"Y`\u0003\f\u0006\u0000Z[\u0005\u0017\u0000\u0000[\\\u0005\"\u0000\u0000"+
		"\\]\u0005\u0005\u0000\u0000]_\u0003\f\u0006\u0000^Z\u0001\u0000\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ac\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0005"+
		"\u0006\u0000\u0000df\u0001\u0000\u0000\u0000eC\u0001\u0000\u0000\u0000"+
		"eU\u0001\u0000\u0000\u0000f\u0007\u0001\u0000\u0000\u0000gj\u0005\u0001"+
		"\u0000\u0000hk\u0003\u0012\t\u0000ik\u0005%\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000ji\u0001\u0000\u0000\u0000ks\u0001\u0000\u0000\u0000lo\u0005"+
		"\u0017\u0000\u0000mp\u0003\u0012\t\u0000np\u0005%\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000on\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"ql\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000vw\u0005\u0002\u0000\u0000w\t\u0001\u0000\u0000\u0000xy\u0003"+
		"\u000e\u0007\u0000y\u000b\u0001\u0000\u0000\u0000z~\u0003\u0012\t\u0000"+
		"{~\u0003\b\u0004\u0000|~\u0005%\u0000\u0000}z\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\r\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0006\u0007\uffff\uffff\u0000\u0080\u0081\u0005\t\u0000"+
		"\u0000\u0081\u0089\u0003\u000e\u0007\u0004\u0082\u0083\u0005\u0010\u0000"+
		"\u0000\u0083\u0084\u0003\u000e\u0007\u0000\u0084\u0085\u0005\u0011\u0000"+
		"\u0000\u0085\u0089\u0001\u0000\u0000\u0000\u0086\u0089\u0003\u0010\b\u0000"+
		"\u0087\u0089\u0003\u0012\t\u0000\u0088\u007f\u0001\u0000\u0000\u0000\u0088"+
		"\u0082\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088"+
		"\u0087\u0001\u0000\u0000\u0000\u0089\u0092\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\n\u0006\u0000\u0000\u008b\u008c\u0005\u0007\u0000\u0000\u008c\u0091"+
		"\u0003\u000e\u0007\u0007\u008d\u008e\n\u0005\u0000\u0000\u008e\u008f\u0005"+
		"\b\u0000\u0000\u008f\u0091\u0003\u000e\u0007\u0006\u0090\u008a\u0001\u0000"+
		"\u0000\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u000f\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0003\u0012\t\u0000\u0096\u0097\u0007\u0000\u0000"+
		"\u0000\u0097\u0098\u0003\u0012\t\u0000\u0098\u0011\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0006\t\uffff\uffff\u0000\u009a\u009d\u0005 \u0000\u0000"+
		"\u009b\u009d\u0005\"\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009c"+
		"\u009b\u0001\u0000\u0000\u0000\u009d\u00a6\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\n\u0004\u0000\u0000\u009f\u00a0\u0007\u0001\u0000\u0000\u00a0\u00a5"+
		"\u0003\u0012\t\u0005\u00a1\u00a2\n\u0003\u0000\u0000\u00a2\u00a3\u0007"+
		"\u0002\u0000\u0000\u00a3\u00a5\u0003\u0012\t\u0004\u00a4\u009e\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u0013\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a9\u00af\u0003\u001e\u000f\u0000\u00aa\u00af\u0003\u001c"+
		"\u000e\u0000\u00ab\u00af\u0003\u001a\r\u0000\u00ac\u00af\u0003\u0018\f"+
		"\u0000\u00ad\u00af\u0003\u0016\u000b\u0000\u00ae\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00ae\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u0015\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u001b\u0000"+
		"\u0000\u00b1\u00b2\u0005\u0010\u0000\u0000\u00b2\u00b7\u0007\u0003\u0000"+
		"\u0000\u00b3\u00b4\u0005\u0017\u0000\u0000\u00b4\u00b6\u0007\u0003\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0005\u0011\u0000\u0000\u00bb\u00bc\u0005\u0006\u0000"+
		"\u0000\u00bc\u0017\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u001c\u0000"+
		"\u0000\u00be\u00bf\u0005\u0010\u0000\u0000\u00bf\u00c0\u0005\"\u0000\u0000"+
		"\u00c0\u00c1\u0005\u0011\u0000\u0000\u00c1\u00c2\u0005\u0006\u0000\u0000"+
		"\u00c2\u0019\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u001a\u0000\u0000"+
		"\u00c4\u00c5\u0005\u0010\u0000\u0000\u00c5\u00c6\u0005\"\u0000\u0000\u00c6"+
		"\u00c7\u0005\u0005\u0000\u0000\u00c7\u00c8\u0003\u0012\t\u0000\u00c8\u00c9"+
		"\u0005\u0016\u0000\u0000\u00c9\u00ca\u0003\u0012\t\u0000\u00ca\u00cb\u0005"+
		"\u0016\u0000\u0000\u00cb\u00cc\u0003\u0012\t\u0000\u00cc\u00cd\u0005\u0011"+
		"\u0000\u0000\u00cd\u00ce\u0003 \u0010\u0000\u00ce\u001b\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0005\u0018\u0000\u0000\u00d0\u00d1\u0005\u0010\u0000"+
		"\u0000\u00d1\u00d2\u0003\n\u0005\u0000\u00d2\u00d3\u0005\u0011\u0000\u0000"+
		"\u00d3\u00d6\u0003 \u0010\u0000\u00d4\u00d5\u0005\u0019\u0000\u0000\u00d5"+
		"\u00d7\u0003 \u0010\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d7\u001d\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0005\"\u0000\u0000\u00d9\u00da\u0005\u0005\u0000\u0000\u00da\u00db\u0003"+
		"\u0012\t\u0000\u00db\u00dc\u0005\u0006\u0000\u0000\u00dc\u001f\u0001\u0000"+
		"\u0000\u0000\u00dd\u00e1\u0005\u0003\u0000\u0000\u00de\u00e0\u0003\u0014"+
		"\n\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0005\u0004\u0000\u0000\u00e5!\u0001\u0000\u0000\u0000"+
		"\u0016\'09GMQ`ejos}\u0088\u0090\u0092\u009c\u00a4\u00a6\u00ae\u00b7\u00d6"+
		"\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}