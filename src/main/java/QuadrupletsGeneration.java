import antlr.MinINGBaseVisitor;
import antlr.MinINGParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuadrupletsGeneration extends MinINGBaseVisitor {
    private final Quadruplets quadruplets;
    private static HashMap<String,String> comparators;
    ExpressionEvaluator evaluator;
    int tempCounter = 0;
    public QuadrupletsGeneration( ) {
        this.quadruplets = new Quadruplets();
    }
    @Override
    public Object visitDeclaration(MinINGParser.DeclarationContext ctx) {
        String type = ctx.TYPE().getText();  // Get the type of the variable(s)

        // Extract the variable names and initial values (if any)
        List<String> variableNames = new ArrayList<>();
        List<String> initialValues = new ArrayList<>();

        for (int i = 0; i < ctx.indexing().size(); i++) {
            MinINGParser.IndexingContext idxCtx = ctx.indexing(i);  // Get the indexing context (variable)
            variableNames.add(idxCtx.ID().getText());  // Add the variable name

            // If there is an initial value, visit it, otherwise add null for no initial value
            if (ctx.initialValue() != null && ctx.initialValue().size() > i) {
                if (ctx.initialValue(i).STRING_LITERAL()!=null){
                    initialValues.add(ctx.initialValue(i).getText()); // Get each initial value as text

                }
                else
                { initialValues.add(visit(ctx.initialValue(i)).toString());}  // Visit each initial value
            } else {
                initialValues.add(null);  // No initial value
            }
        }

        // Generate the quadruplets for the declaration
        for (int i = 0; i < variableNames.size(); i++) {
            String varName = variableNames.get(i);
            String initialValue = initialValues != null && initialValues.size() > i ? initialValues.get(i) : null;

            // If there is an initial value, generate the assignment quadruplet
            if (initialValue != null) {
                if (initialValue.startsWith("\"") && initialValue.endsWith("\"") && type.equals("CHAR")) {
                    // Handle CHAR array initialized with a string literal
                    String stringLiteral = initialValue.substring(1, initialValue.length() - 1); // Remove quotes
                    for (int j = 0; j < stringLiteral.length(); j++) {
                        String tempIndex = generateTempVar(); // Temporary variable for the index
                        addQuadruplet("=", String.valueOf(j), "", tempIndex); // Index calculation (optional for explicit representation)
                        addQuadruplet("=", "'" + stringLiteral.charAt(j) + "'", "", varName + "[" + tempIndex + "]"); // Assign character
                    }
                } else {
                    // Handle scalar initialization or other types
                    addQuadruplet("=", initialValue, "", varName);
                }
            }

        }

        return null;
    }

    @Override
    public Object visitAffectation(MinINGParser.AffectationContext ctx) {
        String varName = ctx.indexing().getText();
        if (ctx.STRING_LITERAL()!=null) {
            // Handle CHAR array initialized with a string literal
            String stringLiteral =ctx.STRING_LITERAL().toString();
             stringLiteral = stringLiteral.substring(1, stringLiteral.length() - 1); // Remove quotes
            for (int j = 0; j < stringLiteral.length(); j++) {
                String tempIndex = generateTempVar(); // Temporary variable for the index
                addQuadruplet("=", String.valueOf(j), "", tempIndex); // Index calculation (optional for explicit representation)
                addQuadruplet("=", "'" + stringLiteral.charAt(j) + "'", "", varName + "[" + tempIndex + "]"); // Assign character
            }
        }else{
        String evaluatedExpr =(String) visit(ctx.expr_arith());
        quadruplets.addQuad(new Quadruple("=", evaluatedExpr, "", varName));}
        return null;
    }


    //the next  6 methods are the arithmetic expression methods
    @Override
    public String visitMultDiv(MinINGParser.MultDivContext ctx) {
        String left = (String) visit(ctx.expr_arith(0)); // Visit the left operand
        String right =(String) visit(ctx.expr_arith(1)); // Visit the right operand
        String temp = generateTempVar(); // Generate a temporary variable
        addQuadruplet(ctx.op.getText(), left, right, temp); // Add quadruplet
        return temp;
    }

    @Override
    public String visitAddSub(MinINGParser.AddSubContext ctx) {
        String left =(String) visit(ctx.expr_arith(0)); // Visit the left operand
        String right =(String) visit(ctx.expr_arith(1)); // Visit the right operand
        String temp = generateTempVar(); // Generate a temporary variable
        addQuadruplet(ctx.op.getText(), left, right, temp); // Add quadruplet
        return temp;
    }

    @Override
    public Object visitParens(MinINGParser.ParensContext ctx) {
        return visit(ctx.expr_arith()); // Visit the inner expression
    }

    @Override
    public String visitNum(MinINGParser.NumContext ctx) {
        return ctx.NUM().getText(); // Return the number as is
    }

    @Override
    public String visitChar(MinINGParser.CharContext ctx) {
        return ctx.CHAR().getText(); // Removes single quotes
    }


    @Override
    public String visitId(MinINGParser.IdContext ctx) {
       return visitIndexing(ctx.indexing());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIndexing(MinINGParser.IndexingContext ctx) {
        if (ctx.getChildCount() == 1) {
            return ctx.ID().getText();
        } else {
            String arrayName = ctx.ID().getText();
            String indexResult = (String) visit(ctx.expr_arith());
            return arrayName + "[" + indexResult + "]";
        }
    }



    @Override
    public Object visitSortie(MinINGParser.SortieContext ctx) {
        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode && ((TerminalNode) child).getSymbol().getType() == MinINGParser.STRING_LITERAL) {
                String stringLiteral = child.getText();
                addQuadruplet("WRITE", stringLiteral, "", "");
            }
            else if (child instanceof MinINGParser.Expr_arithContext) {
                String expr = (String) visit(child); // Visit the expression context to evaluate it
                String tempVar = generateTempVar(); // Generate a temporary variable
                addQuadruplet("=", expr, "", tempVar); // Store the result in the temporary variable
                addQuadruplet("WRITE", tempVar, "", ""); // Write the value of the temporary variable
            }
        }
        return null;
    }

    @Override
    public Object visitEntree(MinINGParser.EntreeContext ctx) {
        String tempVar = generateTempVar();
        addQuadruplet("READ", "", "", tempVar);
        String varName= visitIndexing(ctx.indexing());
        addQuadruplet("=", tempVar, "", varName);
        return null;
    }


public Object visitCondition(MinINGParser.ConditionContext ctx) {
    String exprResult = (String) visit(ctx.expr());  // Get the result of the condition expression
    int jumpToElse = addQuadruplet("BZ", "", exprResult, ""); // Branch if tempVar is 0 (false)
    visitBlock(ctx.block(0));  //visit the statements inside the IF block
    if (ctx.ELSE() != null) {
        int endIf = addQuadruplet("BR", "", "", "");  // Jump to the end of the IF block (after the ELSE if exists)
        // the ELSE block exists, so we need to add a quadruplet to jump here if the condition is false
        updateQuadruplet(jumpToElse, String.valueOf(getQuadrupletsCount()+1)); // Update the "BZ" to jump to the ELSE block
        visitBlock(ctx.block(1));  // Visit the statements inside the ELSE block
        // update the address for the final jump (to skip over the ELSE block if it exists)
        updateQuadruplet(endIf, String.valueOf(getQuadrupletsCount()+1));
    }else {
        updateQuadruplet(jumpToElse, String.valueOf(getQuadrupletsCount()+1));

    }
    return null;
}

    public void updateQuadruplet(int quadrupletIndex, String newAddress) {
        // Validate the index
        if (quadrupletIndex < 0 || quadrupletIndex >= quadruplets.size()) {
            throw new IllegalArgumentException("Invalid quadruplet index: " + quadrupletIndex);
        }

        // Get the quadruplet to update
        Quadruple quad = quadruplets.getQuad(quadrupletIndex);

        // Update the target address (assumed to be the 3rd argument, adjust as needed)
        quad.setOperand1(newAddress);
    }



    @Override
    public Object visitExpr_logical(MinINGParser.Expr_logicalContext ctx) {
        // Handle logical AND
        if (ctx.AND() != null) {
            String left = (String) visit(ctx.expr_logical(0)); // Evaluate left operand
            int falseBranchIndex = addQuadruplet("BZ", "", left, ""); // If left is false, branch to false result

            String right = (String) visit(ctx.expr_logical(1)); // Evaluate right operand
            int rightFalseBranchIndex = addQuadruplet("BZ", "", right, ""); // If right is false, branch to false result

            String temp = generateTempVar(); // Temporary variable for the result
            addQuadruplet("=", "1", "", temp); // Set result to true
            int trueBranchIndex = addQuadruplet("BR", "", "", ""); // Branch to skip false assignment

            // Update false branch addresses
            updateQuadruplet(falseBranchIndex, getQuadrupletsCount()+1 + "");
            updateQuadruplet(rightFalseBranchIndex, getQuadrupletsCount()+1 + "");
            addQuadruplet("=", "0", "", temp); // Set result to false
            updateQuadruplet(trueBranchIndex, getQuadrupletsCount() +1+ ""); // Skip false assignment

            return temp;
        }

        // Handle logical OR
        else if (ctx.OR() != null) {
            String left = (String) visit(ctx.expr_logical(0)); // Evaluate left operand
            int trueBranchIndex = addQuadruplet("BNZ", "", left, ""); // If left is true, branch to true result

            String right = (String) visit(ctx.expr_logical(1)); // Evaluate right operand
            int rightTrueBranchIndex = addQuadruplet("BNZ", "", right, ""); // If right is true, branch to true result

            String temp = generateTempVar(); // Temporary variable for the result
            addQuadruplet("=", "0", "", temp); // Set result to false
            int falseBranchIndex = addQuadruplet("BR", "", "", ""); // Branch to skip true assignment

            // Update true branch addresses
            updateQuadruplet(trueBranchIndex, getQuadrupletsCount() + 1+"");
            updateQuadruplet(rightTrueBranchIndex, getQuadrupletsCount() +1+ "");
            addQuadruplet("=", "1", "", temp); // Set result to true
            updateQuadruplet(falseBranchIndex, getQuadrupletsCount()+1 + ""); // Skip true assignment

            return temp;
        }

        // Handle logical NOT
        else if (ctx.NOT() != null) {
            String expr = (String) visit(ctx.expr_logical(0)); // Evaluate operand
            String temp = generateTempVar(); // Temporary variable for the result

            int trueBranchIndex = addQuadruplet("BNZ", "", expr, ""); // If operand is true, branch to true result
            addQuadruplet("=", "0", "", temp); // Set result to false
            int falseBranchIndex = addQuadruplet("BR", "", "", ""); // Branch to skip true assignment

            updateQuadruplet(trueBranchIndex, getQuadrupletsCount() +1+ "");
            addQuadruplet("=", "1", "", temp); // Set result to true
            updateQuadruplet(falseBranchIndex, getQuadrupletsCount()+1 + ""); // Skip true assignment

            return temp;
        }

        // Handle comparison
        else if (ctx.expr_comparison() != null) {
            return visit(ctx.expr_comparison()); // Visit the comparison part
        }

        // Handle parentheses (just visit the inner expression)
        else if (ctx.LPAREN() != null) {
            return visit(ctx.expr_logical(0)); // Visit the inner expression
        }

        return null;
    }



@Override
public Object visitBoucle(MinINGParser.BoucleContext ctx) {
    // Step 1: Initialization
    String loopVar= visitIndexing(ctx.indexing());
    String initialValue = (String) visit(ctx.expr_arith(0)); // Initial value
    addQuadruplet("=", initialValue, "", loopVar); // Assign initial value to the loop variable

    // Step 2: Condition Check
    String stopValue = (String) visit(ctx.expr_arith(2)); // Stop value
    int conditionQuadIndex = getQuadrupletsCount(); // Save the index of this quadruplet
    int branchToEndIndex = addQuadruplet("BG", "", loopVar, stopValue); // Branch if loopVar < stopValue is false

    // Step 3: Loop Body
    visitBlock(ctx.block()); // Visit the block inside the loop

    // Step 4: Step Update
    String stepValue = (String) visit(ctx.expr_arith(1)); // Step value
    String updatedValue = generateTempVar(); // Temporary variable for updated loopVar
    addQuadruplet("+", loopVar, stepValue, updatedValue); // Add step value to loop variable
    addQuadruplet("=", updatedValue, "", loopVar); // Assign updated value back to the loop variable

    // Step 5: Branch to Condition
    addQuadruplet("BR", STR."\{conditionQuadIndex+1}", "", ""); // Branch back to condition check

    // Step 6: Update Branch to End
    updateQuadruplet(branchToEndIndex, STR."\{getQuadrupletsCount()+1}"); // Set the end of the loop

    return null;
}

    @Override
    public Object visitExpr_comparison(MinINGParser.Expr_comparisonContext ctx) {

        String leftOperand = (String) visit(ctx.expr_arith(0));
        String rightOperand = (String) visit(ctx.expr_arith(1));

        String operator;
        switch (ctx.op.getType()) {
            case MinINGParser.GT:
                operator = "BG";
                break;
            case MinINGParser.LT:
                operator = "BL";
                break;
            case MinINGParser.GE:
                operator = "BGE";
                break;
            case MinINGParser.LE:
                operator = "BLE";
                break;
            case MinINGParser.EQ:
                operator = "BE";
                break;
            case MinINGParser.NEQ:
                operator = "BNE";
                break;
            default:
                throw new IllegalStateException("Unexpected comparison operator: " + ctx.op.getText());
        }

        String tempVar = generateTempVar();

        // Add the comparison quadruplet (True branch)
        int trueBranchIndex = addQuadruplet(operator, "", leftOperand, rightOperand); // Branch if condition is true (operator)
        // Assign `0` to the result if the condition is false
        int assignFalse = addQuadruplet("=", "0", "", tempVar);
        // We store the address of where to jump to in the second operand, which is the next address
        int falseBranchIndex = addQuadruplet("BR", "", "", ""); // To skip the IF block if the condition is false

        // Assign `1` to the result if the condition is true (This is a placeholder for the true condition)
        int assignTrue = addQuadruplet("=", "1", "", tempVar);
        //update addresses
        updateQuadruplet(trueBranchIndex, String.valueOf(assignTrue));
        updateQuadruplet(falseBranchIndex, String.valueOf(assignTrue+1));

        return tempVar;
    }
    private String generateTempVar() {
        return "t" + tempCounter++;
    }

    private int addQuadruplet(String operator, String arg1, String arg2, String result) {
        Quadruple quad = new Quadruple(operator, arg1, arg2, result);
        quadruplets.addQuad(quad);
        return quad.getAddress();
    }
    @Override
    public Object visitBlock(MinINGParser.BlockContext ctx) {
        for (MinINGParser.InstructionContext instruction : ctx.instruction()) {
            visit(instruction);
        }
        return null;
    }
    public static int getQuadrupletsCount() {
        return Quadruple.getQuadrupletsCount();
    }

    public Quadruplets getQuadruplets() {
        return quadruplets;
    }
}
