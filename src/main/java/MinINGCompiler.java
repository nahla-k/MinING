import antlr.MinINGBaseListener;
import antlr.MinINGLexer;
import antlr.MinINGParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class MinINGCompiler {
    @Test
    public void testSimpleVariableDeclaration() {
        // Create a mock context
        MinINGParser.DeclarationContext ctx = createMockContext("INTEGER A = 5;");

        SymbolTable symbolTable = new SymbolTable();
        CostumeMinINGListener listener = new CostumeMinINGListener(symbolTable); // Replace with your actual listener class

        listener.enterDeclaration(ctx);

        // Validate the symbol table
        Symbol symbol = symbolTable.getSymbol("A");
        assertNotNull(symbol);
        assertEquals("INTEGER", symbol.getType());
        assertEquals(5, symbol.getValue());
    }

    @Test
    public void testArrayInitialization() {
        MinINGParser.DeclarationContext ctx = createMockContext("INTEGER ARR = [1, 2, 3];");

        SymbolTable symbolTable = new SymbolTable();
        CostumeMinINGListener listener = new CostumeMinINGListener(symbolTable);

        listener.enterDeclaration(ctx);

        Symbol symbol = symbolTable.getSymbol("ARR");
        assertNotNull(symbol);
        assertEquals(1, symbol.getDimension());
        assertEquals(Arrays.asList(1, 2, 3), symbol.getValue());
    }
    private MinINGParser.DeclarationContext createMockContext(String input) {
        MinINGLexer lexer = new MinINGLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MinINGParser parser = new MinINGParser(tokens);
        return parser.declaration(); // Adjust based on your grammar rule
    }
    public static void main(String[] args) {
        String testInput = "INTEGER  F , A=6; ";
        MinINGLexer lexer = new MinINGLexer(CharStreams.fromString(testInput));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MinINGParser parser = new MinINGParser(tokens);

        MinINGParser.DeclarationContext ctx = parser.declaration();
        SymbolTable symbolTable = new SymbolTable();

        CostumeMinINGListener listener = new CostumeMinINGListener(symbolTable);
        listener.enterDeclaration(ctx);

        // Print the symbol table for validation
        System.out.println(symbolTable.toString());
    }


}


