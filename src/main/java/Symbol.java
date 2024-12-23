import java.util.ArrayList;
import java.util.List;

public class Symbol {
    String type;
    String scope;
    Object value;
    boolean isInitialised;
    int lineDeclarationNbr;
    int dimension;
    int arraySize;
    boolean isConstant;
    ArrayList<Integer> linesOfUsage;

    public Symbol(String type, boolean isConstant) {
        this.type = type;
        this.isConstant = isConstant;
        linesOfUsage = new ArrayList<>();
        this.dimension=0;
        this.isInitialised=false;
    }

    public boolean isInitialised() {
        return isInitialised;
    }

    public void setInitialised(boolean initialised) {
        isInitialised = initialised;
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

    public ArrayList<Integer> getLinesOfUsage() {
        return linesOfUsage;
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
        this.isInitialised=true;
    }
    public void setArrayValue(Object value, int index) {
        if (this.dimension==1) {
            ((Object[]) this.value)[index] = value;
        }
        this.isInitialised=true;
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

    public Object getArrayValue(int index) {
        if (this.dimension==1) {
            return ((Object[]) value)[index];
        }else {
            return null;
        }
    }
    @Override
    public String toString() {
        return "Symbol{" +
                "type='" + type + '\'' +
                ", scope='" + scope + '\'' +
                ", value=" + value +
                ", isInitialised=" + isInitialised +
                ", lineDeclarationNbr=" + lineDeclarationNbr +
                ", dimension=" + dimension +
                ", arraySize=" + arraySize +
                ", isConstant=" + isConstant +
                ", linesOfUsage=" + linesOfUsage +
                '}';
    }
}
