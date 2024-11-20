import antlr.MinINGBaseListener;
import antlr.MinINGParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class CostumeMinINGListener extends MinINGBaseListener {
    private SymbolTable symbolTable;
    private boolean isGlobalScope = false;

    CostumeMinINGListener(SymbolTable symbolTable){
        this.symbolTable=symbolTable;
    }
    @Override
    public void enterGlobaldeclaration(MinINGParser.GlobaldeclarationContext ctx) {
        isGlobalScope = true;
    }

    @Override
    public void exitGlobaldeclaration(MinINGParser.GlobaldeclarationContext ctx) {
        isGlobalScope = false;
    }

    @Override
    public void enterLocaldeclaration(MinINGParser.LocaldeclarationContext ctx) {
        isGlobalScope = false;
    }
    @Override
    public void enterDeclaration(MinINGParser.DeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        boolean isConstant = ctx.CONST() != null;
        int count=0;
        for (TerminalNode idNode : ctx.ID()) {
            String name = idNode.getText();
            Symbol symbol = new Symbol(type, isConstant);
            String scope = isGlobalScope ? "GLOBAL" : "LOCAL";
            symbol.setScope(scope);
            if (symbolTable.contains(name)) {
                System.err.println("Error: Duplicate declaration for variable " + name);
                return;
            }
            int lineNumber = ctx.start.getLine();
            symbol.setLineDeclarationNbr(lineNumber);
            if (name.contains("[")) { //in case it's an array
                handleArrayDeclaration(name,symbol);
                name = name.substring(0, name.indexOf('['));

                if (count < ctx.initialValue().size() && ctx.initialValue(count) != null){ //in case the array is initialized
                    handleArrayInitial(ctx.initialValue(count).array_init().getText(),type,symbol);
                }
            }else if (count < ctx.initialValue().size() && ctx.initialValue(count)!=null){ //if it's not an array

                String value = ctx.initialValue(count).getText();
                Object evaluatedValue = null;
                try {
                    switch (type) {
                        case "INTEGER" -> evaluatedValue = evaluate(value, "INTEGER");
                        case "FLOAT" -> evaluatedValue = evaluate(value, "FLOAT");
                        case "CHAR" -> {
                            if (isChar(value)) {
                                evaluatedValue = extractChar(value); // Get the character from 'a'
                            } else {
                                throw new IllegalArgumentException("Invalid CHAR value: " + value);
                            }
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error evaluating initial value for variable " + name + ": " + e.getMessage());
                    continue;
                }

                symbol.setValue(evaluatedValue);
            }
            count++;
            symbolTable.insert(name, symbol);

        }
    }
    @Override
    public void enterAffectation(MinINGParser.AffectationContext ctx) {
        String varName = ctx.ID().getText();
        boolean symbol = symbolTable.contains(varName);
        if (!symbol) {
            System.err.println("Error: Variable " + varName + " not declared before usage.");
            return;
        }
        if (symbolTable.isConstant(varName)) {
            System.err.println("Error: Attempt to modify constant variable " + varName);
            return;
        }
        int lineNumber = ctx.start.getLine();
        symbolTable.addUsageLine(varName, lineNumber);

    }

    @Override
    public void enterEntree(MinINGParser.EntreeContext ctx) {
        String name = ctx.ID().getText();
        Symbol symbol = symbolTable.getSymbol(name);
        if (symbol == null) {
            System.err.println("Error: Variable " + name + " not declared before usage.");
        } else {
            symbolTable.addUsageLine(name, ctx.start.getLine());

        }
    }

    @Override
    public void enterSortie(MinINGParser.SortieContext ctx) {
        for (TerminalNode idNode : ctx.ID()) {
            String name = idNode.getText();
            Symbol symbol = symbolTable.getSymbol(name);
            if (symbol == null) {
                System.err.println("Error: Variable " + name + " not declared before usage.");
            } else {
                symbolTable.addUsageLine(name,ctx.start.getLine());
            }
        }
    }



    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */

    @Override
    public void enterBoucle(MinINGParser.BoucleContext ctx) {
        String counterId = ctx.ID().getText();  // Counter identifier
        // Determine start, stop, and step components
        String start = ctx.expr_arith(0).getText(); // Start value
        String step = ctx.expr_arith(1).getText();  // Stop value
        String stop = ctx.expr_arith(2).getText();  // Step value
        if (!symbolTable.contains(counterId)) {
            System.err.println("Error: Variable " + counterId + " not declared before usage.");
            return;
        }
        symbolTable.addUsageLine(counterId,ctx.start.getLine());

        for (int i = 0; i < 3; i++) {
            String expr = ctx.expr_arith(i).getText();

            // Check if expr is a number (literal)
            if (isInteger(expr)) {
                System.out.println("Literal found: " + expr);
            }
            // Check if expr is a valid identifier
            else if (symbolTable.contains(expr)) {
                Symbol symbol = symbolTable.getSymbol(expr);
                symbolTable.addUsageLine(expr, ctx.start.getLine());
            }
            // If neither, it's an undeclared identifier
            else {
                System.err.println("Error: Variable " + expr + " not declared before usage.");
            }
        }
        if (symbolTable.contains(start)) {
            Symbol startSymbol = symbolTable.getSymbol(start);
            // Handle start as an identifier
            symbolTable.addUsageLine(start,ctx.start.getLine());
        }
        if (symbolTable.contains(stop)) {
            Symbol stopSymbol = symbolTable.getSymbol(stop);
            symbolTable.addUsageLine(stop,ctx.start.getLine());
            // Handle stop as an identifier
        }
        if (symbolTable.contains(step)) {
            Symbol stepSymbol = symbolTable.getSymbol(step);
            symbolTable.addUsageLine(step,ctx.start.getLine());
            // Handle step as an identifier
        }

        // Additional semantic checks can be added here as needed
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterCondition(MinINGParser.ConditionContext ctx) {
        List<String> ids = new ArrayList<>();
        findIdentifiers(ctx.expr(), ids);

        for (String id : ids) {
            if (!symbolTable.contains(id)) {
                System.err.println("Error: Variable '" + id + "' used in condition is not declared.");
                return;
            } else {
                // Additional semantic checks on the symbol if needed
                Symbol symbol = symbolTable.getSymbol(id);
                symbolTable.addUsageLine(id,ctx.start.getLine());
                // Perform any type-related checks on the symbol here
            }
        }

        // Process the IF and ELSE blocks
        enterBlock(ctx.block(0));
        if (ctx.ELSE() != null) {
            enterBlock(ctx.block(1));
        }
    }
    private void findIdentifiers(ParseTree expr, List<String> ids) {
        // Check if the current node is an ID token
        if (expr instanceof TerminalNode && ((TerminalNode) expr).getSymbol().getType() == MinINGParser.ID) {
            ids.add(expr.getText());
        }

        // Recur through each child of the current expression
        for (int i = 0; i < expr.getChildCount(); i++) {
            findIdentifiers(expr.getChild(i), ids);
        }
    }
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str); // or Double.parseDouble(str) for floating-point numbers
            return true;
        } catch (NumberFormatException e) {

            return false;
        }
    }
    private boolean isFloat(String str) {
        try {
            Float.parseFloat(str); // or Double.parseDouble(str) for floating-point numbers
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isChar(String input) {
        if (input.length() == 3 && input.startsWith("'") && input.endsWith("'")) {
            return Character.isDefined(extractChar(input));
        }
        return false;
    }
    public char extractChar(String input) {
        return input.charAt(1);
    }
    public Object evaluate(String expr, String type) throws ScriptException {

        // Tokenize the expression
        String[] tokens = expr.split("\\s+");
        for (String token : tokens) {
            if (isIdentifier(token)) { // Check if token is an ID
                if (!symbolTable.contains(token)) {
                    throw new IllegalArgumentException("Undeclared identifier: " + token);
                }
                Object value = symbolTable.getSymbol(token).getValue();
                if (value == null  ) {
                    throw new IllegalArgumentException("Uninitialized identifier: " + token);
                }
                if (!symbolTable.getSymbol(token).type.equals(type)){
                    throw new IllegalArgumentException("incompatibale types: " + token);

                }
                // Replace ID with its value in the expression
                expr = expr.replace(token, value.toString());
            }
        }

        try {
            double result = ExpressionEvaluator.evaluateExpression(expr, extractSymbolTableAsMap());



        switch (type) {
            case "INTEGER":
                if (result % 1 != 0) {
                    throw new IllegalArgumentException("Expression result is not an integer: " + result);
                }
                return (int) result;
            case "FLOAT":
                return result; // It's already a double
            case "CHAR":
                throw new IllegalArgumentException("Arithmetic expressions cannot evaluate to CHAR");
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return null;
        }

    }
    public boolean isIdentifier(String token) {
        return token.matches("[A-Z][a-z0-9]*(\\[[0-9]+\\])?");
        // Regex for identifiers
    }

    private boolean isArithmeticExpression(String expr) {
        return expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/");
    }

    // Method to handle arithmetic expressions (this could involve parsing the expression further)
    private void handleArithmeticExpression(String expr, MinINGParser.BoucleContext ctx) {
        // Here, you could parse and evaluate the expression if it's only literals,
        // or check each component if it involves identifiers.
        System.out.println("Arithmetic expression found: " + expr);

        // Optional: Parse each part of the expression and check symbol table for identifiers
        // This step depends on how you want to handle further processing.
    }
    private void handleArrayDeclaration(String name, Symbol symbol){
        String baseName = name.substring(0, name.indexOf('['));
        String arraySizeStr = name.substring(name.indexOf('[') + 1, name.indexOf(']'));

        try {
            int arraySize;

            try{
                arraySize= (int) evaluate(arraySizeStr,"INTEGER");
            }catch (ScriptException e){
                System.err.println(STR."Invalid value: \{e.getMessage()}");
                return;
            }


            if (arraySize<=0){throw new NumberFormatException("Array size must be positive");
            }
            symbol.setDimension(1);
            symbol.setArraySize(arraySize);
            name = baseName;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing array size for identifier: " + name);
            return;
        }
    }
    private void handleArrayInitial(String arrayContent, String type,Symbol symbol){
        arrayContent = arrayContent.substring(1, arrayContent.length() - 1); // Remove '[' and ']'
        String[] elements = arrayContent.split(","); // Split the array elements
        List<Object> evaluatedValues = new ArrayList<>();

        try {
            for (String element : elements) {
                Object evaluatedValue;
                if (isChar(element)) {
                    if (!type.equals("CHAR")) {
                        throw new IllegalArgumentException("Type mismatch in array: expected CHAR but got " + type);
                    }
                    evaluatedValue = extractChar(element); // Get the character from 'a'
                } else {
                    evaluatedValue = evaluate(element.trim(), type); // Evaluate arithmetic expressions
                    // Ensure type compatibility
                    if ((type.equals("INTEGER") && !(evaluatedValue instanceof Integer)) ||
                            (type.equals("FLOAT") && !(evaluatedValue instanceof Double))) {
                        throw new IllegalArgumentException("Type mismatch in array: expected " + type + " but got " + evaluatedValue.getClass().getSimpleName());
                    }
                }
                evaluatedValues.add(evaluatedValue); // Add the evaluated value to the array
            }
            if (symbol.arraySize < evaluatedValues.size()){throw new Exception("Array size is inferior to the initizlized array");}
            symbol.setValue(evaluatedValues.toArray()); // Store the array values
        } catch (Exception e) {
            System.err.println("Error parsing array initialization for identifier: " + " - " + e.getMessage());

        }
    }
    private Map<String, Double> extractSymbolTableAsMap() {
        Map<String, Double> map = new HashMap<>();
        for (String key : symbolTable.getKeys()) {
            Object value = symbolTable.getSymbol(key).getValue();
            if (value instanceof Integer) {
                map.put(key, ((Integer) value).doubleValue());
            } else if (value instanceof Double) {
                map.put(key, (Double) value);
            }
        }
        return map;
    }



}
