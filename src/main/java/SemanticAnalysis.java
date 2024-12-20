import antlr.MinINGBaseVisitor;
import antlr.MinINGLexer;
import antlr.MinINGParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


import javax.script.ScriptException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalysis extends MinINGBaseVisitor {
    private final SymbolTable symbolTable;
    private boolean isGlobalScope = false;
    private final ArrayList<String> semanticErrors;
    ExpressionEvaluator evaluator;
    private final ExpressionTypeChecker typeChecker;

    public SemanticAnalysis(SymbolTable symbolTable) {
        this.semanticErrors = new ArrayList<>();
        this.symbolTable = symbolTable;
        this.evaluator = new ExpressionEvaluator(symbolTable);
        typeChecker = new ExpressionTypeChecker(symbolTable.getSymbols());
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
        int count=0;

        if (ctx.TYPE() != null) {  // Add this null check
            type = ctx.TYPE().getText();

        } else {
            semanticErrors.add("Error: TYPE is null in declaration.");
            return null;}
        boolean isConstant = ctx.CONST() != null;
        for (MinINGParser.IndexingContext indexingCtx : ctx.indexing()) {
            boolean initialised = false;
            String name = indexingCtx.getText();
            Symbol symbol = new Symbol(type, isConstant);
            String scope = isGlobalScope ? "GLOBAL" : "LOCAL";
            symbol.setScope(scope);
            if (symbolTable.contains(name)) {
                semanticErrors.add("Error: Duplicate declaration for variable " + name);
                return null;
            }
            int lineNumber = ctx.start.getLine();
            symbol.setLineDeclarationNbr(lineNumber);
            if (name.contains("[")) { //in case it's an array
                handleArrayDeclaration(name,symbol);
                name = name.substring(0, name.indexOf('['));
                if (count < ctx.initialValue().size() && ctx.initialValue(count) != null){ //in case the array is initialized
                    if (ctx.initialValue(count).STRING_LITERAL() != null && type.equals("CHAR")) {
                        // Initialize CHAR array with a string literal
                        String stringLiteral = ctx.initialValue(count).STRING_LITERAL().getText();
                        stringLiteral = stringLiteral.substring(1, stringLiteral.length() - 1); // Remove quotes

                        if (stringLiteral.length() > symbol.getArraySize()) {
                            semanticErrors.add("Error: String literal exceeds size of CHAR array " + name);
                        } else {
                            initialised = true;
                        }
                    } else {
                        handleArrayInitial(ctx.initialValue(count).array_init().getText(), type, symbol);
                        initialised = true;
                    }
                }
            }else if (count < ctx.initialValue().size() && ctx.initialValue(count)!=null && !ctx.initialValue(count).getText().trim().isEmpty()){ //if it's not an array
                MinINGParser.Expr_arithContext valueCtx = ctx.initialValue(count).expr_arith();
                String valueType;
                if (valueCtx != null) {
                try {
                    valueType = typeChecker.visit(valueCtx); // Check the type of the expression
                } catch (Exception e) {
                    semanticErrors.add("Error evaluating expression for variable " + name + ": " + e.getMessage());
                    continue;
                }
                    if(!areTypesCompatible(type, valueType)){
                        semanticErrors.add("Error evaluating initial value for variable " + name );
                    }else {
                        initialised = true;
                    }
            }}
            count++;
            symbolTable.insert(name, symbol);
            if (initialised) {
                symbolTable.initialise(name);
            }

        }
            return null;
    }
    private boolean areTypesCompatible(String declaredType, String expressionType) {
        if (declaredType.equals("FLOAT")) {
            // FLOAT can accept INTEGER or FLOAT
            return expressionType.equals("INTEGER") || expressionType.equals("FLOAT");
        } else if (declaredType.equals("CHAR")) {
            // CHAR can only accept CHAR
            return expressionType.equals("CHAR");
        } else if (declaredType.equals("INTEGER")) {
            // INTEGER can only accept INTEGER
            return expressionType.equals("INTEGER");
        }
        // Fallback: types must match exactly
        return declaredType.equals(expressionType);
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
            if (child instanceof TerminalNode terminalNode) {

                // Check if it's a string literal
                if (terminalNode.getSymbol().getType() == MinINGLexer.STRING_LITERAL) {
                    String literal = terminalNode.getText();
                    // Ensure proper formatting, such as surrounding quotes
                    if (!literal.startsWith("\"") || !literal.endsWith("\"")) {
                        semanticErrors.add("Invalid string literal format: " + literal);
                    }
                }
            } else if (child instanceof MinINGParser.Expr_arithContext) {
                String expr = child.getText();
                try {
                    List<String> variables = extractVariablesFromExpression(expr);
                    for (String var : variables) {
                        if (!symbolTable.contains(var)) {
                            semanticErrors.add("Undeclared variable used in expression: " + var);
                        }else {
                            int lineNumber = ctx.start.getLine();
                            symbolTable.addUsageLine(var, lineNumber);
                        }
                    }
                } catch (Exception e) {
                    semanticErrors.add("Error analyzing arithmetic expression: " + expr + ". " + e.getMessage());
                }
            }
        }
        return null;
    }

    private List<String> extractVariablesFromExpression(String expr) {
        List<String> variables = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z]([a-z]|[0-9])*");
        Matcher matcher = pattern.matcher(expr);
        while (matcher.find()) {
            variables.add(matcher.group());
        }
        return variables;
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
        String varName = ctx.indexing().getText();
        boolean symbol = symbolTable.contains(varName);
        if (!symbol) {
            semanticErrors.add("Error: Variable " + varName + " not declared before usage.");
            return null;
        }
        if (symbolTable.isConstant(varName)) {
            semanticErrors.add("Error: Attempt to modify constant variable " + varName);
            return null;
        }
        int lineNumber = ctx.start.getLine();
        symbolTable.addUsageLine(varName, lineNumber);
        symbolTable.initialise(varName);
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
        String counterId = ctx.indexing().getText(); // Counter identifier

        // Check if the counter variable is declared
        if (!symbolTable.contains(counterId)) {
            semanticErrors.add("Error: Variable " + counterId + " not declared before usage.");
            return null;
        }

        // Check if the counter variable is a constant
        if (symbolTable.isConstant(counterId)) {
            semanticErrors.add("Error: Attempt to use constant variable " + counterId + " as a loop counter.");
            return null;
        }
        String counterType = symbolTable.getType(counterId);
        if (!"INTEGER".equals(counterType) && !"FLOAT".equals(counterType)) {
            semanticErrors.add("Error: Loop counter '" + counterId + "' must be of type INTEGER or FLOAT.");
        }
        // Check the validity of start, stop, and step expressions
        for (int i = 0; i < 3; i++) {
            if (ctx.expr_arith(i) != null) {
                try {
                    String exprType = typeChecker.visit(ctx.expr_arith(i)); // Use type checker
                    if (!"INTEGER".equals(exprType) && !"FLOAT".equals(exprType)) {
                        semanticErrors.add("Error: Loop expression at position " + (i + 1) + " must be of type INTEGER or FLOAT.");
                    }
                } catch (Exception e) {
                    semanticErrors.add("Error in loop expression at position " + (i + 1) + ": " + e.getMessage());
                }
            } else {
                semanticErrors.add("Error: Missing loop expression at position " + (i + 1) + ".");
            }
        }

        return null;
    }



    @Override
    public Object visitExpr_logical(MinINGParser.Expr_logicalContext ctx) {
        if (ctx.expr_comparison() != null) {
            // Delegate to comparison expression visitor
            return visit(ctx.expr_comparison());
        }

        if (ctx.expr_logical().size() == 1) {
            // Handle NOT operator
            String subExpressionType = visit(ctx.expr_logical(0)).toString();
            if (!"BOOLEAN".equals(subExpressionType)) {
                semanticErrors.add("Error: Logical NOT operator requires a BOOLEAN operand.");
            }
            return "BOOLEAN";
        }

        if (ctx.expr_logical().size() == 2) {
            // Handle AND/OR operators
            String leftType = visit(ctx.expr_logical(0)).toString();
            String rightType = visit(ctx.expr_logical(1)).toString();

            if (!"BOOLEAN".equals(leftType) || !"BOOLEAN".equals(rightType)) {
                semanticErrors.add("Error: Logical AND/OR operators require BOOLEAN operands.");
            }
            return "BOOLEAN";
        }

        if (ctx.LPAREN() != null) {
            // Handle parentheses
            return visit(ctx.expr_logical(0));
        }

        // If the grammar is valid, this line should never be reached
        semanticErrors.add("Error: Invalid logical expression.");
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
        String conditionType = visit(ctx.expr().expr_logical()).toString();

        // Ensure the logical expression is valid
        if (conditionType == null) {
            semanticErrors.add("Error: Invalid condition expression.");
            return null;
        }
        List<String> ids = new ArrayList<>();
        findIdentifiers(ctx.expr(), ids);

        // ensure all identifiers in the condition are declared
        for (String id : ids) {
            if (!symbolTable.contains(id)) {
                semanticErrors.add("Error: Variable '" + id + "' used in condition is not declared.");
                return null;
            } else {
                symbolTable.addUsageLine(id, ctx.start.getLine());
                if (!symbolTable.isInitialised(id)) {
                    semanticErrors.add("Error: Variable '" + id + "' used in condition has no assigned value.");
                }
            }
        }
        visitBlock(ctx.block(0));
        if (ctx.ELSE()!=null){
            visitBlock(ctx.block(1));
        }
        return null;
    }
    @Override
    public String visitExpr_comparison(MinINGParser.Expr_comparisonContext ctx) {
        String leftType = typeChecker.visit(ctx.expr_arith(0));
        String rightType = typeChecker.visit(ctx.expr_arith(1));

        // Ensure compatibility
        if (!areTypesComparable(leftType, rightType)) {
            semanticErrors.add("Error: Incompatible types for comparison. Cannot compare "
                    + leftType + " with " + rightType + ".");
            return null;
        }

        // Comparisons always result in BOOLEAN
        return "BOOLEAN";
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
        String varName = ctx.indexing().getText();

        // Check if the variable is declared
        if (!symbolTable.contains(varName)) {
            semanticErrors.add("Error: Variable '" + varName + "' not declared before usage.");
            return null;
        }

        // Check if the variable is a constant
        if (symbolTable.isConstant(varName)) {
            semanticErrors.add("Error: Attempt to modify constant variable '" + varName + "'.");
            return null;
        }

        String declaredType = symbolTable.getType(varName);

        if (ctx.STRING_LITERAL()==null){

        String expressionType;
        try {
            expressionType = typeChecker.visit(ctx.expr_arith());
        } catch (Exception e) {
            semanticErrors.add("Error checking expression type for variable '" + varName + "': " + e.getMessage());
            return null;
        }

        if (!areTypesCompatible(declaredType, expressionType)) {
            semanticErrors.add("Error: Type mismatch in assignment to variable '" + varName +
                    "'. Expected: " + declaredType + ", but found: " + expressionType);
            return null;
        }}else {
            if (declaredType.equals("CHAR") && symbolTable.getDimension(varName)==1 ){
                String stringLiteral = ctx.STRING_LITERAL().getText();
                stringLiteral = stringLiteral.substring(1, stringLiteral.length() - 1); // Remove quotes
                if (stringLiteral.length() > symbolTable.getArraySize(varName)) {
                    semanticErrors.add("Error: String literal exceeds size of CHAR array " + varName);
                }
            }
        }
        symbolTable.initialise(varName);
        int lineNumber = ctx.start.getLine();
        symbolTable.addUsageLine(varName, lineNumber);

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
    public Object visitBlock(MinINGParser.BlockContext ctx) { //i'll remove it late,no need for it during the semantic analysis
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
                semanticErrors.add("Unknown instruction type at line " + instructionCtx.start.getLine());
            }
        }
        return null;
    }

    private void findIdentifiers(ParseTree expr, List<String> ids) {
        if (expr instanceof TerminalNode && ((TerminalNode) expr).getSymbol().getType() == MinINGParser.ID) {
            ids.add(expr.getText());
        }


        for (int i = 0; i < expr.getChildCount(); i++) {
            findIdentifiers(expr.getChild(i), ids);
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
                Object value = symbolTable.getValue(token);
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

        if (isArithmeticExpression(expr)) {
            return evaluator.evaluateExpression(expr);
        } else {
            if (type.equals("INTEGER")) {
                return Integer.parseInt(expr);
            } else if (type.equals("FLOAT")) {
                return Double.parseDouble(expr);
            } else {
                throw new IllegalArgumentException("Unsupported type: " + type);
            }
        }

    }
    public static boolean isIdentifier(String token) {
        return token.matches("[A-Z][a-z0-9]*(\\[[0-9]+])?");
        // Regex for identifiers
    }

    private boolean isArithmeticExpression(String expr) {
        return expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/");
    }



    private void handleArrayDeclaration(String name, Symbol symbol){
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

        } catch (NumberFormatException e) {
            semanticErrors.add("Error parsing array size for identifier: " + name + " - " + e.getMessage());

        }
    }



    private void handleArrayInitial(String arrayContent, String type,Symbol symbol){
        arrayContent = arrayContent.substring(1, arrayContent.length() - 1); // Remove '[' and ']'
        String[] elements = arrayContent.split(","); // Split the array elements

        int count=0;
        try {
            for (String element : elements) {
                element = element.trim();
                Object evaluatedValue = evaluator.evaluateExpression(element); // Evaluate the element
                if (isTypeCorrect(evaluatedValue, type))
                {count++; // Add the evaluated value to the array}
            }}
            if (symbol.arraySize < count){throw new Exception("Array size is inferior to the initizlized array");}
            if (count < symbol.arraySize) {

                throw new Exception("Array not fully initialized; expected " + symbol.arraySize + " elements.");
            }
        } catch (Exception e) {
            semanticErrors.add("Error parsing array initialization for identifier: " + " - " + e.getMessage());
        }
    }

    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
    }
    // Method to check if the type of a given value matches the expected type
    private boolean isTypeCorrect(Object value, String expectedType) {
        if (value == null) {
            return false;  // Null values are considered incorrect
        }
        try {
        if ( expectedType.equals("CHAR")) {
            if (isChar((String) value)) {
                throw new IllegalArgumentException("Type mismatch in array: expected CHAR but got " + expectedType);
            }
        } else {
            // Ensure type compatibility
            if ((expectedType.equals("INTEGER") && !(value instanceof Integer)) ||
                    (expectedType.equals("FLOAT") && !(value instanceof Double))) {
                throw new IllegalArgumentException("Type mismatch in array: expected " + expectedType + " but got " + value.getClass().getSimpleName());
            }
        }}
        catch (Exception e) {
            semanticErrors.add("Error parsing array initialization for identifier: " + " - " + e.getMessage());
            return false;
        }
        return true;
    }
    private boolean areTypesComparable(String leftType, String rightType) {
        // Allow INTEGER and FLOAT to be compared
        if ((leftType.equals("INTEGER") || leftType.equals("FLOAT")) &&
                (rightType.equals("INTEGER") || rightType.equals("FLOAT"))) {
            return true;
        }

        // Allow CHAR to CHAR comparisons only
        if (leftType.equals("CHAR") && rightType.equals("CHAR")) {
            return true;
        }

        // Other type combinations are incompatible
        return false;
    }



}

