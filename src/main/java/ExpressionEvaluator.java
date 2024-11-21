import javax.script.ScriptException;
import java.util.*;

public class ExpressionEvaluator {

    public static double evaluateExpression(String expr, Map<String, Double> symbolTable) throws Exception {
        List<String> postfix = infixToPostfix(expr, symbolTable);
        return evaluatePostfix(postfix);
    }

    private static List<String> infixToPostfix(String expr, Map<String, Double> symbolTable) throws Exception {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(expr, "+-*/() ", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (isNumeric(token)) {
                output.add(token);
            } else if (symbolTable.containsKey(token)) {
                output.add(String.valueOf(symbolTable.get(token))); // Replace ID with value
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (stack.isEmpty() || !stack.pop().equals("(")) {
                    throw new Exception("Mismatched parentheses");
                }
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else {
                throw new Exception("Unknown token: " + token);
            }
        }

        while (!stack.isEmpty()) {
            String op = stack.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new Exception("Mismatched parentheses");
            }
            output.add(op);
        }

        return output;
    }

    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(a, b, token));
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    private static double applyOperator(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
    ///**************************************************************************
    private boolean evaluateCondition(String expr, SymbolTable symbolTable) throws ScriptException {
        // Tokenize the expression by splitting based on spaces
        String[] tokens = expr.split("\\s+");

        // Stack for operands
        Stack<Boolean> operandStack = new Stack<>();

        // Stack for operators
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (CostumeMinINGListener.isIdentifier(token)) { // If token is an identifier (variable)
                if (!symbolTable.contains(token)) {
                    throw new IllegalArgumentException("Undeclared identifier: " + token);
                }
                Object value = symbolTable.getSymbol(token).getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Uninitialized identifier: " + token);
                }
                operandStack.push((Boolean) value); // Push the evaluated value to stack
            } else if (isComparisonOperator(token)) {
                // Process comparison operators: <, >, ==, etc.
                Object left = operandStack.pop();
                Object right = operandStack.pop();
                boolean result = applyComparisonOperator(left, right, token);
                operandStack.push(result); // Push the result to operand stack
            } else if (isLogicalOperator(token)) {
                // Process logical operators: &&, ||, !
                boolean operand = operandStack.pop();
                boolean result = applyLogicalOperator(operand, token);
                operandStack.push(result); // Push the result to operand stack
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        return operandStack.pop(); // Return the final evaluation result
    }

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

