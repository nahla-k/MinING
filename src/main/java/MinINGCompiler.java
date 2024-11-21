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
        String testInput = """
        VAR_GLOBAL{}
        DECLARATION{
        INTEGER A=6,B=10,D=1;
        }
        INSTRUCTION{
        IF(A + B  < D){
        A = A+10;
        WRITE("haha");
        }ELSE{
        B = 0;
        WRITE("hoho");
        }
        }
        """;

        // Step 1: Lexical Analysis
        MinINGLexer lexer = new MinINGLexer(CharStreams.fromString(testInput));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Step 2: Parsing
        MinINGParser parser = new MinINGParser(tokens);

        // Add an error listener for better diagnostics
        parser.removeErrorListeners(); // Remove default console error listener
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.err.printf("Syntax error at line %d:%d - %s%n", line, charPositionInLine, msg);
            }
        });

        // Parse the input
        MinINGParser.ProgContext progContext = parser.prog();

        // Step 3: Walking the Parse Tree
        SymbolTable symbolTable = new SymbolTable();
        CostumeMinINGListener listener = new CostumeMinINGListener(symbolTable);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, progContext);

        // Step 4: Output Results
        System.out.println("Parse Tree: ");
        System.out.println(progContext.toStringTree(parser)); // Print parse tree
        System.out.println("\nSymbol Table:");
        System.out.println(symbolTable.toString()); // Print the symbol table
    }



}


