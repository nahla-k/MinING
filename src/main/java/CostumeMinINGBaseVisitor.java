import antlr.MinINGBaseVisitor;
import antlr.MinINGLexer;
import antlr.MinINGParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.jexl3.*;

import javax.script.ScriptException;
import java.util.*;

public class CostumeMinINGBaseVisitor extends MinINGBaseVisitor {
    private SymbolTable symbolTable;
    private boolean isGlobalScope = false;
    private Deque<Set<ParseTree>> contextStack = new ArrayDeque<>();

    public CostumeMinINGBaseVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    @Override
    public Object visitExpr(MinINGParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitInitialValue(MinINGParser.InitialValueContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpr_logical(MinINGParser.Expr_logicalContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpr_comparison(MinINGParser.Expr_comparisonContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpr_arith(MinINGParser.Expr_arithContext ctx) {
        return visitChildren(ctx);
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
    public Object visitGlobaldeclaration(MinINGParser.GlobaldeclarationContext ctx) {
        isGlobalScope = true;
        return super.visitGlobaldeclaration(ctx);

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
    public Object visitLocaldeclaration(MinINGParser.LocaldeclarationContext ctx) {
        isGlobalScope = false;
        return super.visitLocaldeclaration(ctx);
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
    public Void visitDeclaration(MinINGParser.DeclarationContext ctx) {
        String type;
        if (ctx.TYPE() != null) {  // Add this null check
            type = ctx.TYPE().getText();
            System.out.println("Type: " + type);
        } else {
            System.err.println("Error: TYPE is null in declaration.");
            return null;
        }
        boolean isConstant = ctx.CONST() != null;
        int count=0;

        for (TerminalNode idNode : ctx.ID()) {
            String name = idNode.getText();
            Symbol symbol = new Symbol(type, isConstant);
            String scope = isGlobalScope ? "GLOBAL" : "LOCAL";
            symbol.setScope(scope);
            if (symbolTable.contains(name)) {
                System.err.println("Error: Duplicate declaration for variable " + name);
                return null;
            }
            int lineNumber = ctx.start.getLine();
            symbol.setLineDeclarationNbr(lineNumber);
            if (name.contains("[")) { //in case it's an array
                handleArrayDeclaration(name,symbol);
                name = name.substring(0, name.indexOf('['));

                if (count < ctx.initialValue().size() && ctx.initialValue(count) != null){ //in case the array is initialized
                    handleArrayInitial(ctx.initialValue(count).array_init().getText(),type,symbol);
                }
            }else if (count < ctx.initialValue().size() && ctx.initialValue(count)!=null && ctx.initialValue(count).getText().trim().length() > 0){ //if it's not an array

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
            return null;
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
    public Object visitArray_init(MinINGParser.Array_initContext ctx) {
        return super.visitArray_init(ctx);
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
    public Object visitInstruction(MinINGParser.InstructionContext ctx) {
        return super.visitInstruction(ctx);
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
    public Object visitSortie(MinINGParser.SortieContext ctx) {
        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode) {
                TerminalNode terminalNode = (TerminalNode) child;

                // Handle string literals
                if (terminalNode.getSymbol().getType() == MinINGLexer.STRING_LITERAL) {
                    String literal = terminalNode.getText();
                    // Remove the surrounding double quotes
                    String value = literal.substring(1, literal.length() - 1);
                    System.out.print(value + " ");
                }

                // Handle variable identifiers
                else if (terminalNode.getSymbol().getType() == MinINGLexer.ID) {
                    String name = terminalNode.getText();
                    Symbol symbol = symbolTable.getSymbol(name);
                    if (symbol == null) {
                        System.err.println("\nError: Variable " + name + " not declared before usage.");
                    } else {
                        symbolTable.addUsageLine(name, ctx.start.getLine());
                        System.out.print(symbol.value);
                    }
                }
            }
        }
        return null;
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
    public Object visitEntree(MinINGParser.EntreeContext ctx) {
        String varName = ctx.ID().getText();
        boolean symbol = symbolTable.contains(varName);
        if (!symbol) {
            System.err.println("Error: Variable " + varName + " not declared before usage.");
            return null;
        }
        if (symbolTable.isConstant(varName)) {
            System.err.println("Error: Attempt to modify constant variable " + varName);
            return null;
        }
        String type = symbolTable.getType(varName);
        Object value = null;
        Scanner scanner = new Scanner(System.in);  // Assuming Scanner is used for input

        try {
            switch (type) {
                case "INTEGER":
                    value = Integer.parseInt(scanner.nextLine());
                    break;
                case "FLOAT":
                    value = Float.parseFloat(scanner.nextLine());
                    break;
                case "CHAR":
                    String charInput = scanner.nextLine();
                    if (isChar(charInput)) {
                        value = extractChar(charInput); // Get the character from 'a'
                    } else {
                        throw new IllegalArgumentException("Invalid CHAR value: " + charInput);
                    }
                    break;
                default:
                    System.err.println("Error: Unsupported type for variable " + varName);
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error reading value for " + varName + ": " + e.getMessage());
            return null;
        }
        symbolTable.setValue(varName,value);
        int lineNumber = ctx.start.getLine();
        symbolTable.addUsageLine(varName, lineNumber);
        return super.visitEntree(ctx);
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
    public Object visitBoucle(MinINGParser.BoucleContext ctx) {
        String counterId = ctx.ID().getText(); // Counter identifier

        // Check if the counter variable is declared
        if (!symbolTable.contains(counterId)) {
            System.err.println("Error: Variable " + counterId + " not declared before usage.");
            return null;
        }
        if (symbolTable.isConstant(counterId)) {
            System.err.println("Error: Attempt to modify constant variable " + counterId);
            return null;
        }
        // Log usage of the loop counter
        symbolTable.addUsageLine(counterId, ctx.start.getLine());

        try {
            // Evaluate start, stop, and step using the counter's type
            double start = (double) evaluate(ctx.expr_arith(0).getText(), "FLOAT");
            double step = (double) evaluate(ctx.expr_arith(1).getText(), "FLOAT");
            double stop = (double) evaluate(ctx.expr_arith(2).getText(), "FLOAT");
            // treating the loop logic
            symbolTable.setValue(counterId,start);
            if (step == 0) {
                System.err.println("Error: Step value cannot be zero.");
                return null;
            }
            while ((step > 0 && (double) symbolTable.getValue(counterId) <= stop) || (step < 0 && (double) symbolTable.getValue(counterId) >= stop)) {
                if (ctx.block() != null) {
                    visitBlock(ctx.block());
                }
                // Update the counter variable in the symbol table
                symbolTable.setValue(counterId,(double) symbolTable.getValue(counterId) + step);
            }

        } catch (IllegalArgumentException | ScriptException e) {
            System.err.println("Error in loop expressions: " + e.getMessage());
        }
        return null;
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
    public Object visitCondition(MinINGParser.ConditionContext ctx) {
        List<String> ids = new ArrayList<>();
        findIdentifiers(ctx.expr(), ids);

        // Ensure all identifiers in the condition are declared
        for (String id : ids) {
            if (!symbolTable.contains(id)) {
                System.err.println("Error: Variable '" + id + "' used in condition is not declared.");
                return null;
            } else {
                symbolTable.addUsageLine(id, ctx.start.getLine());
            }
        }

        // Create a JEXL context to evaluate the expressions
        JexlEngine jexl = new JexlBuilder().create();
        JexlContext jexlContext = new MapContext();

        // Populate the context with values from the symbol table
        for (String id : ids) {
            Symbol symbol = symbolTable.getSymbol(id);
            if (symbol != null && symbol.getValue() != null) {
                jexlContext.set(id, symbol.getValue());
            }
        }

        try {
            // Evaluate the condition expression
            String condition = ctx.expr().getText();
            JexlExpression expression = jexl.createExpression(condition);
            Object result = expression.evaluate(jexlContext);

            // Handle the result based on its type (should be a boolean for conditions)
            if (result instanceof Boolean) {
                boolean conditionResult = (Boolean) result;
                if (conditionResult) {
                    visitBlock(ctx.block(0));
                } else if (ctx.ELSE() != null) {

                    visitBlock(ctx.block(1));
                }
            } else {
                System.err.println("Error: Condition did not evaluate to a boolean.");
            }
        } catch (Exception e) {
            System.err.println("Error evaluating condition: " + e.getMessage());
        }
    return null;
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
    public Object visitAffectation(MinINGParser.AffectationContext ctx) {
        String varName = ctx.ID().getText();
        boolean symbol = symbolTable.contains(varName);
        if (!symbol) {
            System.err.println("Error: Variable " + varName + " not declared before usage.");
            return null;
        }
        if (symbolTable.isConstant(varName)) {
            System.err.println("Error: Attempt to modify constant variable " + varName);
            return null;
        } else {
            String type = symbolTable.getType(varName);
            String value = ctx.expr_arith().getText();
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
                System.err.println("Error evaluating initial value for variable " + varName + ": " + e.getMessage());

            }
            symbolTable.setValue(varName,evaluatedValue);
            int lineNumber = ctx.start.getLine();
            symbolTable.addUsageLine(varName, lineNumber);

        }
        return null;
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
    public Object visitBlock(MinINGParser.BlockContext ctx) {
        for (MinINGParser.InstructionContext instructionCtx : ctx.instruction()) {
            // Dispatch to appropriate methods based on the type of instruction
            if (instructionCtx.affectation() != null) {
                visitAffectation(instructionCtx.affectation());
            } else if (instructionCtx.condition() != null) {
                visitCondition(instructionCtx.condition());
            } else if (instructionCtx.boucle() != null) {
                visitBoucle(instructionCtx.boucle());
            } else if (instructionCtx.entree() != null) {
                visitEntree(instructionCtx.entree());
            } else if (instructionCtx.sortie() != null) {
                visitSortie(instructionCtx.sortie());
            } else {
                System.err.println("Unknown instruction type at line " + instructionCtx.start.getLine());
            }
        }
        return null;
    }

    private void findIdentifiers(ParseTree expr, List<String> ids) {
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
    public  Object evaluate(String expr, String type) throws ScriptException {

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
                if (value instanceof Integer && "FLOAT".equals(type)) {
                    value = ((Integer) value).doubleValue(); // Promote INTEGER to FLOAT
                }
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
                    return  result; // It's already a double
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
    public static boolean isIdentifier(String token) {
        return token.matches("[A-Z][a-z0-9]*(\\[[0-9]+\\])?");
        // Regex for identifiers
    }

    private boolean isArithmeticExpression(String expr) {
        return expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/");
    }

    // Method to handle arithmetic expressions (this could involve parsing the expression further)

    private void handleArrayDeclaration(String name, Symbol symbol){
        String baseName = extractArrayName(name);
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

        }
    }
    private boolean isArray(String name){
        return name.contains("[") && name.contains("]");
    }
    private String extractArrayName(String name){
        return name.substring(0, name.indexOf('['));
    }
    private int extractArrayIndex(String name){
        String indexStr = name.substring(name.indexOf('[') + 1, name.indexOf(']'));
        return Integer.parseInt(indexStr);
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
