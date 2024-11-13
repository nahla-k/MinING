import antlr.MinINGBaseListener;
import antlr.MinINGParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

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

            if (name.contains("[")) {

                String baseName = name.substring(0, name.indexOf('['));
                String arraySizeStr = name.substring(name.indexOf('[') + 1, name.indexOf(']'));

                try {
                    int arraySize = Integer.parseInt(arraySizeStr);
                    if (arraySize<=0){throw new NumberFormatException("Array size must be positive");}
                    symbol.setDimension(1);
                    symbol.setArraySize(arraySize);
                    name = baseName;
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing array size for identifier: " + name);
                    return;
                }
            }
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
            if (isNumeric(expr)) {
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
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // or Double.parseDouble(str) for floating-point numbers
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
