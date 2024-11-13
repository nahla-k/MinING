import java.util.ArrayList;
import java.util.List;

public class Symbol {
    String type;
    String scope;
    Object value;

    Float size;
    String offset;
    int lineDeclarationNbr;
    int dimension;
    int arraySize;
    boolean isConstant;
    ArrayList<int> linesOfUsage;

    public Symbol(String type, boolean isConstant) {
        this.type = type;
        this.isConstant = isConstant;
        linesOfUsage = new ArrayList<int>();
        this.dimension=0;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public void setConstant(boolean constant) {
        isConstant = constant;
    }

    public List<int> getLinesOfUsage() {
        return linesOfUsage;
    }

    public void setLinesOfUsage(ArrayList<int> linesOfUsage) {
        this.linesOfUsage = linesOfUsage;
    }

    public Symbol(String type, String scope, Object value, Float size, Object initialValue, String offset, int lineDeclarationNbr, int arraySize) {
        this.type = type;
        this.scope = scope;
        this.value = value;
        this.size = size;
        this.offset = offset;
        this.lineDeclarationNbr = lineDeclarationNbr;
        this.arraySize = arraySize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }




    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getLineDeclarationNbr() {
        return lineDeclarationNbr;
    }

    public void setLineDeclarationNbr(int lineDeclarationNbr) {
        this.lineDeclarationNbr = lineDeclarationNbr;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
}
enum Type{INTEGER, CHAR, FLOAT}
enum Scope{LOCAL, GLOBAL}