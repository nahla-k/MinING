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
		INSTRUCTIONS=41;
	public static final int
		RULE_prog = 0, RULE_globaldeclaration = 1, RULE_localdeclaration = 2, 
		RULE_declaration = 3, RULE_indexing = 4, RULE_array_init = 5, RULE_expr = 6, 
		RULE_initialValue = 7, RULE_expr_logical = 8, RULE_expr_comparison = 9, 
		RULE_expr_arith = 10, RULE_instruction = 11, RULE_sortie = 12, RULE_entree = 13, 
		RULE_boucle = 14, RULE_condition = 15, RULE_affectation = 16, RULE_block = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "globaldeclaration", "localdeclaration", "declaration", "indexing", 
			"array_init", "expr", "initialValue", "expr_logical", "expr_comparison", 
			"expr_arith", "instruction", "sortie", "entree", "boucle", "condition", 
			"affectation", "block"
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
			"STRING_LITERAL", "VAR_GLOBAL", "DECLARATION", "INSTRUCTIONS"
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
		public TerminalNode INSTRUCTIONS() { return getToken(MinINGParser.INSTRUCTIONS, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
			setState(36);
			match(VAR_GLOBAL);
			setState(37);
			match(LBRACE);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==CONST) {
				{
				{
				setState(38);
				globaldeclaration();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(RBRACE);
			setState(45);
			match(DECLARATION);
			setState(46);
			match(LBRACE);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==CONST) {
				{
				{
				setState(47);
				localdeclaration();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(RBRACE);
			setState(54);
			match(INSTRUCTIONS);
			setState(55);
			block();
			setState(56);
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
			setState(58);
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
			setState(60);
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
		public List<IndexingContext> indexing() {
			return getRuleContexts(IndexingContext.class);
		}
		public IndexingContext indexing(int i) {
			return getRuleContext(IndexingContext.class,i);
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(TYPE);
				setState(63);
				indexing();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(64);
					match(EQUAL);
					setState(65);
					initialValue();
					}
				}

				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(68);
					match(COMA);
					setState(69);
					indexing();
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(70);
						match(EQUAL);
						setState(71);
						initialValue();
						}
					}

					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(SEMICOLON);
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(CONST);
				setState(82);
				match(TYPE);
				setState(83);
				indexing();
				setState(84);
				match(EQUAL);
				{
				setState(85);
				initialValue();
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(86);
					match(COMA);
					setState(87);
					indexing();
					setState(88);
					match(EQUAL);
					setState(89);
					initialValue();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
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
	public static class IndexingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MinINGParser.ID, 0); }
		public Expr_arithContext expr_arith() {
			return getRuleContext(Expr_arithContext.class,0);
		}
		public IndexingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).enterIndexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGListener ) ((MinINGListener)listener).exitIndexing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGVisitor ) return ((MinINGVisitor<? extends T>)visitor).visitIndexing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexingContext indexing() throws RecognitionException {
		IndexingContext _localctx = new IndexingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_indexing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(101);
				match(T__0);
				{
				setState(102);
				expr_arith(0);
				}
				setState(103);
				match(T__1);
				}
				break;
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
		enterRule(_localctx, 10, RULE_array_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__0);
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case NUM:
			case ID:
				{
				setState(108);
				expr_arith(0);
				}
				break;
			case CHAR:
				{
				setState(109);
				match(CHAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(112);
				match(COMA);
				setState(115);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
				case NUM:
				case ID:
					{
					setState(113);
					expr_arith(0);
					}
					break;
				case CHAR:
					{
					setState(114);
					match(CHAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
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
		enterRule(_localctx, 12, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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
		enterRule(_localctx, 14, RULE_initialValue);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case NUM:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				expr_arith(0);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				array_init();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
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
		public TerminalNode CHAR() { return getToken(MinINGParser.CHAR, 0); }
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(132);
				match(NOT);
				setState(133);
				expr_logical(5);
				}
				break;
			case 2:
				{
				setState(134);
				match(LPAREN);
				setState(135);
				expr_logical(0);
				setState(136);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(138);
				expr_comparison();
				}
				break;
			case 4:
				{
				setState(139);
				expr_arith(0);
				}
				break;
			case 5:
				{
				setState(140);
				match(CHAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_logicalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_logical);
						setState(143);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(144);
						match(AND);
						setState(145);
						expr_logical(8);
						}
						break;
					case 2:
						{
						_localctx = new Expr_logicalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_logical);
						setState(146);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(147);
						match(OR);
						setState(148);
						expr_logical(7);
						}
						break;
					}
					} 
				}
				setState(153);
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
		enterRule(_localctx, 18, RULE_expr_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			expr_arith(0);
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(156);
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
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public List<Expr_arithContext> expr_arith() {
			return getRuleContexts(Expr_arithContext.class);
		}
		public Expr_arithContext expr_arith(int i) {
			return getRuleContext(Expr_arithContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode NUM() { return getToken(MinINGParser.NUM, 0); }
		public IndexingContext indexing() {
			return getRuleContext(IndexingContext.class,0);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr_arith, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(159);
				match(LPAREN);
				setState(160);
				expr_arith(0);
				setState(161);
				match(RPAREN);
				}
				break;
			case NUM:
				{
				setState(163);
				match(NUM);
				}
				break;
			case ID:
				{
				setState(164);
				indexing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(173);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_arithContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_arith);
						setState(167);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(168);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						expr_arith(6);
						}
						break;
					case 2:
						{
						_localctx = new Expr_arithContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_arith);
						setState(170);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(171);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(172);
						expr_arith(5);
						}
						break;
					}
					} 
				}
				setState(177);
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
		enterRule(_localctx, 22, RULE_instruction);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				affectation();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				condition();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				boucle();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				entree();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
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
		public List<Expr_arithContext> expr_arith() {
			return getRuleContexts(Expr_arithContext.class);
		}
		public Expr_arithContext expr_arith(int i) {
			return getRuleContext(Expr_arithContext.class,i);
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
		enterRule(_localctx, 24, RULE_sortie);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(WRITE);
			setState(186);
			match(LPAREN);
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				{
				setState(187);
				match(STRING_LITERAL);
				}
				break;
			case LPAREN:
			case NUM:
			case ID:
				{
				setState(188);
				expr_arith(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(191);
				match(COMA);
				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(192);
					match(STRING_LITERAL);
					}
					break;
				case LPAREN:
				case NUM:
				case ID:
					{
					setState(193);
					expr_arith(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(RPAREN);
			setState(202);
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
		public IndexingContext indexing() {
			return getRuleContext(IndexingContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_entree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(READ);
			setState(205);
			match(LPAREN);
			setState(206);
			indexing();
			setState(207);
			match(RPAREN);
			setState(208);
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
		public IndexingContext indexing() {
			return getRuleContext(IndexingContext.class,0);
		}
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
		enterRule(_localctx, 28, RULE_boucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(FOR);
			setState(211);
			match(LPAREN);
			setState(212);
			indexing();
			setState(213);
			match(EQUAL);
			setState(214);
			expr_arith(0);
			setState(215);
			match(TO);
			setState(216);
			expr_arith(0);
			setState(217);
			match(TO);
			setState(218);
			expr_arith(0);
			setState(219);
			match(RPAREN);
			setState(220);
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
		enterRule(_localctx, 30, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(IF);
			setState(223);
			match(LPAREN);
			setState(224);
			expr();
			setState(225);
			match(RPAREN);
			setState(226);
			block();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(227);
				match(ELSE);
				setState(228);
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
		public IndexingContext indexing() {
			return getRuleContext(IndexingContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			indexing();
			setState(232);
			match(EQUAL);
			setState(233);
			expr_arith(0);
			setState(234);
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
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(LBRACE);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17666408448L) != 0)) {
				{
				{
				setState(237);
				instruction();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(243);
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
		case 8:
			return expr_logical_sempred((Expr_logicalContext)_localctx, predIndex);
		case 10:
			return expr_arith_sempred((Expr_arithContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_logical_sempred(Expr_logicalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean expr_arith_sempred(Expr_arithContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00f6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00001\b\u0000\n\u0000\f\u0000"+
		"4\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003C\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0005\u0003K\b\u0003\n\u0003"+
		"\f\u0003N\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\\\b\u0003\n\u0003\f\u0003_\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003c\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004j\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005o\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005t\b\u0005\u0005\u0005v\b\u0005\n\u0005\f\u0005y\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0082\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u008e\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0096\b\b\n\b\f\b\u0099"+
		"\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00a6\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u00ae\b\n\n\n\f\n\u00b1\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b8\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00be\b\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00c3\b\f\u0005\f\u00c5\b\f\n\f\f\f\u00c8\t\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00e6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00ef\b\u0011\n\u0011\f\u0011\u00f2"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0002\u0010\u0014\u0012"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"\u0000\u0003\u0001\u0000\n\u000f\u0001\u0000\u0014\u0015"+
		"\u0001\u0000\u0012\u0013\u0103\u0000$\u0001\u0000\u0000\u0000\u0002:\u0001"+
		"\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006b\u0001\u0000\u0000"+
		"\u0000\bd\u0001\u0000\u0000\u0000\nk\u0001\u0000\u0000\u0000\f|\u0001"+
		"\u0000\u0000\u0000\u000e\u0081\u0001\u0000\u0000\u0000\u0010\u008d\u0001"+
		"\u0000\u0000\u0000\u0012\u009a\u0001\u0000\u0000\u0000\u0014\u00a5\u0001"+
		"\u0000\u0000\u0000\u0016\u00b7\u0001\u0000\u0000\u0000\u0018\u00b9\u0001"+
		"\u0000\u0000\u0000\u001a\u00cc\u0001\u0000\u0000\u0000\u001c\u00d2\u0001"+
		"\u0000\u0000\u0000\u001e\u00de\u0001\u0000\u0000\u0000 \u00e7\u0001\u0000"+
		"\u0000\u0000\"\u00ec\u0001\u0000\u0000\u0000$%\u0005\'\u0000\u0000%)\u0005"+
		"\u0003\u0000\u0000&(\u0003\u0002\u0001\u0000\'&\u0001\u0000\u0000\u0000"+
		"(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*,\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,-\u0005\u0004"+
		"\u0000\u0000-.\u0005(\u0000\u0000.2\u0005\u0003\u0000\u0000/1\u0003\u0004"+
		"\u0002\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000056\u0005\u0004\u0000\u000067\u0005)\u0000\u0000"+
		"78\u0003\"\u0011\u000089\u0005\u0000\u0000\u00019\u0001\u0001\u0000\u0000"+
		"\u0000:;\u0003\u0006\u0003\u0000;\u0003\u0001\u0000\u0000\u0000<=\u0003"+
		"\u0006\u0003\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0005\u001f\u0000"+
		"\u0000?B\u0003\b\u0004\u0000@A\u0005\u0005\u0000\u0000AC\u0003\u000e\u0007"+
		"\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CL\u0001\u0000"+
		"\u0000\u0000DE\u0005\u0017\u0000\u0000EH\u0003\b\u0004\u0000FG\u0005\u0005"+
		"\u0000\u0000GI\u0003\u000e\u0007\u0000HF\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JD\u0001\u0000\u0000\u0000"+
		"KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MO\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0005\u0006"+
		"\u0000\u0000Pc\u0001\u0000\u0000\u0000QR\u0005!\u0000\u0000RS\u0005\u001f"+
		"\u0000\u0000ST\u0003\b\u0004\u0000TU\u0005\u0005\u0000\u0000U]\u0003\u000e"+
		"\u0007\u0000VW\u0005\u0017\u0000\u0000WX\u0003\b\u0004\u0000XY\u0005\u0005"+
		"\u0000\u0000YZ\u0003\u000e\u0007\u0000Z\\\u0001\u0000\u0000\u0000[V\u0001"+
		"\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000`a\u0005\u0006\u0000\u0000ac\u0001\u0000\u0000\u0000b>\u0001\u0000"+
		"\u0000\u0000bQ\u0001\u0000\u0000\u0000c\u0007\u0001\u0000\u0000\u0000"+
		"di\u0005\"\u0000\u0000ef\u0005\u0001\u0000\u0000fg\u0003\u0014\n\u0000"+
		"gh\u0005\u0002\u0000\u0000hj\u0001\u0000\u0000\u0000ie\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000j\t\u0001\u0000\u0000\u0000kn\u0005\u0001"+
		"\u0000\u0000lo\u0003\u0014\n\u0000mo\u0005%\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000nm\u0001\u0000\u0000\u0000ow\u0001\u0000\u0000\u0000ps\u0005"+
		"\u0017\u0000\u0000qt\u0003\u0014\n\u0000rt\u0005%\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000"+
		"up\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000z{\u0005\u0002\u0000\u0000{\u000b\u0001\u0000\u0000\u0000"+
		"|}\u0003\u0010\b\u0000}\r\u0001\u0000\u0000\u0000~\u0082\u0003\u0014\n"+
		"\u0000\u007f\u0082\u0003\n\u0005\u0000\u0080\u0082\u0005%\u0000\u0000"+
		"\u0081~\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0006\b\uffff\uffff\u0000\u0084\u0085\u0005\t\u0000\u0000\u0085"+
		"\u008e\u0003\u0010\b\u0005\u0086\u0087\u0005\u0010\u0000\u0000\u0087\u0088"+
		"\u0003\u0010\b\u0000\u0088\u0089\u0005\u0011\u0000\u0000\u0089\u008e\u0001"+
		"\u0000\u0000\u0000\u008a\u008e\u0003\u0012\t\u0000\u008b\u008e\u0003\u0014"+
		"\n\u0000\u008c\u008e\u0005%\u0000\u0000\u008d\u0083\u0001\u0000\u0000"+
		"\u0000\u008d\u0086\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u0097\u0001\u0000\u0000\u0000\u008f\u0090\n\u0007\u0000\u0000"+
		"\u0090\u0091\u0005\u0007\u0000\u0000\u0091\u0096\u0003\u0010\b\b\u0092"+
		"\u0093\n\u0006\u0000\u0000\u0093\u0094\u0005\b\u0000\u0000\u0094\u0096"+
		"\u0003\u0010\b\u0007\u0095\u008f\u0001\u0000\u0000\u0000\u0095\u0092\u0001"+
		"\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0011\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0003"+
		"\u0014\n\u0000\u009b\u009c\u0007\u0000\u0000\u0000\u009c\u009d\u0003\u0014"+
		"\n\u0000\u009d\u0013\u0001\u0000\u0000\u0000\u009e\u009f\u0006\n\uffff"+
		"\uffff\u0000\u009f\u00a0\u0005\u0010\u0000\u0000\u00a0\u00a1\u0003\u0014"+
		"\n\u0000\u00a1\u00a2\u0005\u0011\u0000\u0000\u00a2\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a6\u0005 \u0000\u0000\u00a4\u00a6\u0003\b\u0004\u0000"+
		"\u00a5\u009e\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00af\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\n\u0005\u0000\u0000\u00a8\u00a9\u0007\u0001\u0000\u0000\u00a9"+
		"\u00ae\u0003\u0014\n\u0006\u00aa\u00ab\n\u0004\u0000\u0000\u00ab\u00ac"+
		"\u0007\u0002\u0000\u0000\u00ac\u00ae\u0003\u0014\n\u0005\u00ad\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001"+
		"\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b0\u0015\u0001\u0000\u0000\u0000\u00b1\u00af\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b8\u0003 \u0010\u0000\u00b3\u00b8\u0003\u001e"+
		"\u000f\u0000\u00b4\u00b8\u0003\u001c\u000e\u0000\u00b5\u00b8\u0003\u001a"+
		"\r\u0000\u00b6\u00b8\u0003\u0018\f\u0000\u00b7\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b3\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b8\u0017\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u001b\u0000"+
		"\u0000\u00ba\u00bd\u0005\u0010\u0000\u0000\u00bb\u00be\u0005&\u0000\u0000"+
		"\u00bc\u00be\u0003\u0014\n\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bc\u0001\u0000\u0000\u0000\u00be\u00c6\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c2\u0005\u0017\u0000\u0000\u00c0\u00c3\u0005&\u0000\u0000\u00c1\u00c3"+
		"\u0003\u0014\n\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005"+
		"\u0011\u0000\u0000\u00ca\u00cb\u0005\u0006\u0000\u0000\u00cb\u0019\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0005\u001c\u0000\u0000\u00cd\u00ce\u0005"+
		"\u0010\u0000\u0000\u00ce\u00cf\u0003\b\u0004\u0000\u00cf\u00d0\u0005\u0011"+
		"\u0000\u0000\u00d0\u00d1\u0005\u0006\u0000\u0000\u00d1\u001b\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0005\u001a\u0000\u0000\u00d3\u00d4\u0005\u0010"+
		"\u0000\u0000\u00d4\u00d5\u0003\b\u0004\u0000\u00d5\u00d6\u0005\u0005\u0000"+
		"\u0000\u00d6\u00d7\u0003\u0014\n\u0000\u00d7\u00d8\u0005\u0016\u0000\u0000"+
		"\u00d8\u00d9\u0003\u0014\n\u0000\u00d9\u00da\u0005\u0016\u0000\u0000\u00da"+
		"\u00db\u0003\u0014\n\u0000\u00db\u00dc\u0005\u0011\u0000\u0000\u00dc\u00dd"+
		"\u0003\"\u0011\u0000\u00dd\u001d\u0001\u0000\u0000\u0000\u00de\u00df\u0005"+
		"\u0018\u0000\u0000\u00df\u00e0\u0005\u0010\u0000\u0000\u00e0\u00e1\u0003"+
		"\f\u0006\u0000\u00e1\u00e2\u0005\u0011\u0000\u0000\u00e2\u00e5\u0003\""+
		"\u0011\u0000\u00e3\u00e4\u0005\u0019\u0000\u0000\u00e4\u00e6\u0003\"\u0011"+
		"\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e6\u001f\u0001\u0000\u0000\u0000\u00e7\u00e8\u0003\b\u0004\u0000"+
		"\u00e8\u00e9\u0005\u0005\u0000\u0000\u00e9\u00ea\u0003\u0014\n\u0000\u00ea"+
		"\u00eb\u0005\u0006\u0000\u0000\u00eb!\u0001\u0000\u0000\u0000\u00ec\u00f0"+
		"\u0005\u0003\u0000\u0000\u00ed\u00ef\u0003\u0016\u000b\u0000\u00ee\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005\u0004\u0000\u0000\u00f4#\u0001\u0000\u0000\u0000\u0018)2BHL]bi"+
		"nsw\u0081\u008d\u0095\u0097\u00a5\u00ad\u00af\u00b7\u00bd\u00c2\u00c6"+
		"\u00e5\u00f0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}