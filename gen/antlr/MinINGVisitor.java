// Generated from C:/Users/nahla/Downloads/Segaleo-master/MinING0/src/main/java/antlr/MinING.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MinINGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MinINGVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MinINGParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MinINGParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#globaldeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobaldeclaration(MinINGParser.GlobaldeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#localdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocaldeclaration(MinINGParser.LocaldeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MinINGParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#array_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_init(MinINGParser.Array_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MinINGParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#initialValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialValue(MinINGParser.InitialValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#expr_logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_logical(MinINGParser.Expr_logicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#expr_comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_comparison(MinINGParser.Expr_comparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#expr_arith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_arith(MinINGParser.Expr_arithContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(MinINGParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#sortie}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortie(MinINGParser.SortieContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#entree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntree(MinINGParser.EntreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#boucle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoucle(MinINGParser.BoucleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MinINGParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#affectation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectation(MinINGParser.AffectationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MinINGParser.BlockContext ctx);
}