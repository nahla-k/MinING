import org.apache.commons.jexl3.*;

import javax.script.ScriptException;
import java.util.*;

public class ExpressionEvaluator {
    private final SymbolTable symbolTable;

    public ExpressionEvaluator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Object evaluateExpression(String expression) {
        try {
            JexlEngine jexl = new JexlBuilder().create();
            JexlExpression jexlExpression = jexl.createExpression(expression);
            JexlContext context = new MapContext();

            // Populate the context with variables and their values from the symbol table
            for (Map.Entry<String, Symbol> entry : symbolTable.getSymbols().entrySet()) {
                String variableName = entry.getKey();
                Object variableValue = entry.getValue().getValue(); // Assuming getValue() provides the stored value
                context.set(variableName, variableValue);
            }

            // Evaluate the expression
            return jexlExpression.evaluate(context);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error evaluating expression: " + e.getMessage(), e);
        }
    }
    ///**************************************************************************
//    private boolean evaluateCondition(String expr, SymbolTable symbolTable) throws ScriptException {
//        // Tokenize the expression by splitting based on spaces
//        String[] tokens = expr.split("\\s+");
//
//        // Stack for operands
//        Stack<Boolean> operandStack = new Stack<>();
//
//        // Stack for operators
//        Stack<String> operatorStack = new Stack<>();
//
//        for (String token : tokens) {
//            if (CostumeMinINGListener.isIdentifier(token)) { // If token is an identifier (variable)
//                if (!symbolTable.contains(token)) {
//                    throw new IllegalArgumentException("Undeclared identifier: " + token);
//                }
//                Object value = symbolTable.getSymbol(token).getValue();
//                if (value == null) {
//                    throw new IllegalArgumentException("Uninitialized identifier: " + token);
//                }
//                operandStack.push((Boolean) value); // Push the evaluated value to stack
//            } else if (isComparisonOperator(token)) {
//                // Process comparison operators: <, >, ==, etc.
//                Object left = operandStack.pop();
//                Object right = operandStack.pop();
//                boolean result = applyComparisonOperator(left, right, token);
//                operandStack.push(result); // Push the result to operand stack
//            } else if (isLogicalOperator(token)) {
//                // Process logical operators: &&, ||, !
//                boolean operand = operandStack.pop();
//                boolean result = applyLogicalOperator(operand, token);
//                operandStack.push(result); // Push the result to operand stack
//            } else {
//                throw new IllegalArgumentException("Invalid token: " + token);
//            }
//        }
//
//        return operandStack.pop(); // Return the final evaluation result
//    }

    // Check if token is a comparison operator (like ==, >, <, etc.)
    private boolean isComparisonOperator(String token) {
        return token.equals("==") || token.equals("!=") || token.equals("<") || token.equals(">") || token.equals("<=") || token.equals(">=");
    }

    // Apply comparison operator
    private boolean applyComparisonOperator(Object left, Object right, String operator) {
        if (left instanceof Integer && right instanceof Integer) {
            int leftValue = (Integer) left;
            int rightValue = (Integer) right;
            switch (operator) {
                case "==": return leftValue == rightValue;
                case "!=": return leftValue != rightValue;
                case "<": return leftValue < rightValue;
                case ">": return leftValue > rightValue;
                case "<=": return leftValue <= rightValue;
                case ">=": return leftValue >= rightValue;
                default: throw new IllegalArgumentException("Invalid comparison operator: " + operator);
            }
        }
        // Handle Float or other types similarly...
        return false;
    }

    // Check if token is a logical operator (like &&, ||, !)
    private boolean isLogicalOperator(String token) {
        return token.equals("&&") || token.equals("||") || token.equals("!");
    }

    // Apply logical operator
    private boolean applyLogicalOperator(boolean operand, String operator) {
        switch (operator) {
            case "&&": return operand && true; // Apply AND logic
            case "||": return operand || false; // Apply OR logic
            case "!": return !operand; // Apply NOT logic
            default: throw new IllegalArgumentException("Invalid logical operator: " + operator);
        }
    }

}

