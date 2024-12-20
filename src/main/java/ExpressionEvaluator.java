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


}

