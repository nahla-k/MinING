import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SymbolTable {
    private Map<String, Symbol> symbols;

    public SymbolTable() {
        symbols = new HashMap<>();
    }

    // Method to add a new symbol
    public void insert(String name, Symbol symbol) {
        if (name.contains("[")) {
            int size = Integer.parseInt(name.substring(name.indexOf("[")+1,name.indexOf("]")));
            name = name.substring(0, name.indexOf("["));
            symbol.setDimension(1);
            symbol.setArraySize(size);
        }
        symbols.put(name, symbol);
    }



    public Set<String> getKeys() {
        return symbols.keySet(); // Directly call keySet() on the HashMap
    }
    // Method to add a line of usage for a symbol
    public boolean addUsageLine(String name, int line) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            symbol.getLinesOfUsage().add(line);
            return true;
        }
        return false;
    }

    // Retrieve a symbol (for inspection or other purposes)
    public Symbol getSymbol(String name) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        return symbols.get(name);
    }
    public Object getValue(String name) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
            int index = Integer.parseInt(name.substring(name.indexOf("[")+1,name.indexOf("]")));
            Symbol symbol = symbols.get(name);
            return symbol != null ? symbol.getArrayValue(index) : null;
        }else {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getValue() : null;}
    }


    public boolean contains(String name) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        Symbol symbol = symbols.get(name);
        return symbol != null ;
    }

    @Override
    public String toString() {
        return "SymbolTable{" +
                "symbols=" + symbols +
                '}';
    }

    public String getType(String name) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getType() : null;
    }

    // Retrieve the scope of a symbol
    public String getScope(String name) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getScope() : null;
    }

    // Retrieve the line number where the symbol was declared
    public Integer getLineDeclarationNbr(String name)
    {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getLineDeclarationNbr() : null;
    }

    // Retrieve the value of a symbol



    // Retrieve the array size of a symbol (if it's an array)
    public Integer getArraySize(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getArraySize() : null;
    }
    public Boolean isInitialised(String name){
        Symbol symbol =symbols.get(name);
        return symbol.isInitialised();
    }

    // Retrieve the dimension of a symbol (for arrays)
    public Integer getDimension(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getDimension() : null;
    }

    // Check if a symbol is a constant
    public Boolean isConstant(String name) {
        if (name.contains("[")) {
            name = name.substring(0, name.indexOf("["));
        }
        Symbol symbol = symbols.get(name);
        return symbol != null && symbol.isConstant();
    }

    // Retrieve lines where the symbol was used


    // Update the value of a symbol

    public void initialise(String name){
        if (name.contains("[")) {
            //int index = Integer.parseInt(name.substring(name.indexOf("[")+1,name.indexOf("]")));
            name = name.substring(0, name.indexOf("["));}
            Symbol symbol = symbols.get(name);
            if (symbol != null) {
                symbol.setInitialised(true);
                symbols.put(name, symbol);
            }
    }


    public Map<String, Symbol> getSymbols() {
        return symbols;
    }
}
