import antlr.MinINGBaseVisitor;
import antlr.MinINGParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class ExpressionTypeChecker extends MinINGBaseVisitor<String> {

    private final Map<String, Symbol> symbolTable;

    public ExpressionTypeChecker(Map<String, Symbol> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public String visitMultDiv(MinINGParser.MultDivContext ctx) {
        // Visit the left and right expressions
        String leftType = visit(ctx.expr_arith(0));
        String rightType = visit(ctx.expr_arith(1));

        // Check if both operands are numeric types (either INTEGER or FLOAT)
        if (!isNumericType(leftType) || !isNumericType(rightType)) {
            throw new IllegalArgumentException("Type mismatch: Cannot apply " + ctx.op.getText() + " to " + leftType + " and " + rightType);
        }

        // Result is FLOAT if either operand is FLOAT; otherwise, it's INTEGER
        return leftType.equals("FLOAT") || rightType.equals("FLOAT") ? "FLOAT" : "INTEGER";
    }

    @Override
    public String visitAddSub(MinINGParser.AddSubContext ctx) {
        // Visit the left and right expressions
        String leftType = visit(ctx.expr_arith(0));
        String rightType = visit(ctx.expr_arith(1));

        // Check if both operands are numeric types (either INTEGER or FLOAT)
        if (!isNumericType(leftType) || !isNumericType(rightType)) {
            throw new IllegalArgumentException("Type mismatch: Cannot apply " + ctx.op.getText() + " to " + leftType + " and " + rightType);
        }

        // Result is FLOAT if either operand is FLOAT; otherwise, it's INTEGER
        return leftType.equals("FLOAT") || rightType.equals("FLOAT") ? "FLOAT" : "INTEGER";
    }

    @Override
    public String visitParens(MinINGParser.ParensContext ctx) {

        return visit(ctx.expr_arith());  // It should return the result of the inside expression
    }

    @Override
    public String visitNum(MinINGParser.NumContext ctx) {
        // Return the type directly from the number
        String numText = ctx.NUM().getText();
        return numText.contains(".") ? "FLOAT" : "INTEGER";
    }

    @Override
    public String visitChar(MinINGParser.CharContext ctx) {
        // Always return CHAR type for characters
        return "CHAR";
    }

    @Override
    public String visitIndexing(MinINGParser.IndexingContext ctx) {
        // Retrieve the type from the symbol table for the given variable
        String variable = ctx.getText();
        if (variable.contains("[")) {
            int index = Integer.parseInt(variable.substring(variable.indexOf("[") + 1, variable.indexOf("]")));
            variable = variable.substring(0, variable.indexOf("["));
        }
        if (symbolTable.containsKey(variable)) {
            return symbolTable.get(variable).getType();  // Return the variable's type
        } else {
            throw new IllegalArgumentException("Undeclared symbol: " + variable);  // If not declared
        }
    }
    @Override
    public String visitExpr_logical(MinINGParser.Expr_logicalContext ctx) {
        if (ctx.expr_comparison() != null) {
            return visit(ctx.expr_comparison());
        } else if (ctx.expr_logical().size() == 1) {
            // Handle NOT operator
            return visit(ctx.expr_logical(0));
        } else if (ctx.expr_logical().size() == 2) {
            // Handle AND/OR operators
            visit(ctx.expr_logical(0));
            visit(ctx.expr_logical(1));
            // no type compatibility checks needed for logical expressions
            return "BOOLEAN";
        } else if (ctx.LPAREN() != null) {
            return visit(ctx.expr_logical(0));
        }

        return null;
    }

    private boolean isNumericType(String type) {
        return type.equals("INTEGER") || type.equals("FLOAT");
    }


}
