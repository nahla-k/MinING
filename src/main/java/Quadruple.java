class Quadruple {
    String operator;
    String operand1;
    String operand2;
    String result;
    int address;
    static int count =0;

    public Quadruple(String operator, String operand1, String operand2, String result) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        count++;
        address =count;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getAddress() {
        return address;
    }

    public static int getQuadrupletsCount() {
        return count;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address+". (" + operator + ", " + operand1 + ", " + operand2 + ", " + result + ")";
    }
}
