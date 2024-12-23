// Generated from C:/Users/nahla/Downloads/Segaleo-master/MinING0/src/main/java/antlr/MinING.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinINGParser}.
 */
public interface MinINGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MinINGParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MinINGParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MinINGParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#globaldeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGlobaldeclaration(MinINGParser.GlobaldeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#globaldeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGlobaldeclaration(MinINGParser.GlobaldeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#localdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocaldeclaration(MinINGParser.LocaldeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#localdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocaldeclaration(MinINGParser.LocaldeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MinINGParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MinINGParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#indexing}.
	 * @param ctx the parse tree
	 */
	void enterIndexing(MinINGParser.IndexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#indexing}.
	 * @param ctx the parse tree
	 */
	void exitIndexing(MinINGParser.IndexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#array_init}.
	 * @param ctx the parse tree
	 */
	void enterArray_init(MinINGParser.Array_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#array_init}.
	 * @param ctx the parse tree
	 */
	void exitArray_init(MinINGParser.Array_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MinINGParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MinINGParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(MinINGParser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(MinINGParser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#expr_logical}.
	 * @param ctx the parse tree
	 */
	void enterExpr_logical(MinINGParser.Expr_logicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#expr_logical}.
	 * @param ctx the parse tree
	 */
	void exitExpr_logical(MinINGParser.Expr_logicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#expr_comparison}.
	 * @param ctx the parse tree
	 */
	void enterExpr_comparison(MinINGParser.Expr_comparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#expr_comparison}.
	 * @param ctx the parse tree
	 */
	void exitExpr_comparison(MinINGParser.Expr_comparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void enterParens(MinINGParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void exitParens(MinINGParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(MinINGParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(MinINGParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void enterNum(MinINGParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void exitNum(MinINGParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code char}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void enterChar(MinINGParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code char}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void exitChar(MinINGParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void enterId(MinINGParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void exitId(MinINGParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(MinINGParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(MinINGParser.MultDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(MinINGParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(MinINGParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#sortie}.
	 * @param ctx the parse tree
	 */
	void enterSortie(MinINGParser.SortieContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#sortie}.
	 * @param ctx the parse tree
	 */
	void exitSortie(MinINGParser.SortieContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#entree}.
	 * @param ctx the parse tree
	 */
	void enterEntree(MinINGParser.EntreeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#entree}.
	 * @param ctx the parse tree
	 */
	void exitEntree(MinINGParser.EntreeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#boucle}.
	 * @param ctx the parse tree
	 */
	void enterBoucle(MinINGParser.BoucleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#boucle}.
	 * @param ctx the parse tree
	 */
	void exitBoucle(MinINGParser.BoucleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MinINGParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MinINGParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#affectation}.
	 * @param ctx the parse tree
	 */
	void enterAffectation(MinINGParser.AffectationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#affectation}.
	 * @param ctx the parse tree
	 */
	void exitAffectation(MinINGParser.AffectationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MinINGParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MinINGParser.BlockContext ctx);
}