import antlr.MinINGBaseListener;
import antlr.MinINGLexer;
import antlr.MinINGParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MinINGCompiler {
    public static void main(String[] args) throws Exception {
        String input = "VAR_GLOBAL { INTEGER T0[5]; CHAR A0; }";

        CharStream charStream = CharStreams.fromString(input);
        MinINGLexer lexer = new MinINGLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MinINGParser parser = new MinINGParser(tokens);


        SymbolTable symbolTable = new SymbolTable();

        ParseTree tree = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MinINGBaseListener() {
            @Override
            public void enterDeclaration(MinINGParser.DeclarationContext ctx) {
                String type = ctx.TYPE().getText();
                boolean isConstant = ctx.CONST() != null;
                for (TerminalNode idNode : ctx.ID()) {
                    String name = idNode.getText();
                    Symbol symbol = new Symbol(type, isConstant);
                    symbolTable.insert(name, symbol);
                }
            }
        }, tree);


    }
}


