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
        symbols.put(name, symbol);
    }



    public Set<String> getKeys() {
        return symbols.keySet(); // Directly call keySet() on the HashMap
    }
    public boolean updateValue(String name, Object newValue) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            symbol.setValue(newValue);
            return true;
        }
        return false;
    }

    public boolean updateSize(String name, Float newSize) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            symbol.setSize(newSize);
            return true;
        }
        return false;
    }

    // Method to update the offset of a symbol
    public boolean updateOffset(String name, String newOffset) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            symbol.setOffset(newOffset);
            return true;
        }
        return false;
    }






    // Method to add a line of usage for a symbol
    public boolean addUsageLine(String name, int line) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            symbol.getLinesOfUsage().add(line);
            return true;
        }
        return false;
    }

    // Retrieve a symbol (for inspection or other purposes)
    public Symbol getSymbol(String name) {
        return symbols.get(name);
    }

    public boolean contains(String name) {
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
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getType() : null;
    }

    // Retrieve the scope of a symbol
    public String getScope(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getScope() : null;
    }

    // Retrieve the line number where the symbol was declared
    public Integer getLineDeclarationNbr(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getLineDeclarationNbr() : null;
    }

    // Retrieve the value of a symbol
    public Object getValue(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getValue() : null;
    }

    // Retrieve the size of a symbol
    public Float getSize(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getSize() : null;
    }

    // Retrieve the offset of a symbol
    public String getOffset(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getOffset() : null;
    }

    // Retrieve the array size of a symbol (if it's an array)
    public Integer getArraySize(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getArraySize() : null;
    }

    // Retrieve the dimension of a symbol (for arrays)
    public Integer getDimension(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null ? symbol.getDimension() : null;
    }

    // Check if a symbol is a constant
    public Boolean isConstant(String name) {
        Symbol symbol = symbols.get(name);
        return symbol != null && symbol.isConstant();
    }

    // Retrieve lines where the symbol was used


    // Update the value of a symbol
    public void setValue(String name, Object value) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            symbol.setValue(value);
        }
    }


}
