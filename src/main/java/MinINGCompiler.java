import antlr.MinINGLexer;
import antlr.MinINGParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.nio.file.*;

public class MinINGCompiler {
    public static void main(String[] args)  {

    String filePath = "src/main/java/tests/test1";

    String code = readFile(filePath);
    SymbolTable symbolTable = new SymbolTable();
    CharStream input = CharStreams.fromString(code);

    MinINGLexer lexer = new MinINGLexer(input);


    CommonTokenStream tokens = new CommonTokenStream(lexer);

    MinINGParser parser = new MinINGParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(ConsoleErrorListener.INSTANCE);
    ParseTree tree = parser.prog();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Syntactic Errors Detected:");

            return;
        }
    SemanticAnalysis visitor = new SemanticAnalysis(symbolTable);
    visitor.visit(tree);
    if(!visitor.getSemanticErrors().isEmpty()){
    System.err.println(STR."\n\{visitor.getSemanticErrors()}");}
    else{
        QuadrupletsGeneration quadrupletGenerator = new QuadrupletsGeneration();
        quadrupletGenerator.visit(tree);
        Quadruplets quadruplets = quadrupletGenerator.getQuadruplets();
        System.out.println("\ngenerated quadruplets : ");
        for(Quadruple quad : quadruplets){
            System.out.println(quad);
        }
        System.out.println(symbolTable);
    }
}

    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
}


