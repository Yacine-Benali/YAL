package main.models;

import main.SemanticAnalysisVisitor;
import main.SemanticHelper;

public class Variable {

    public String name;
    public int type;
    public Object value;
    public boolean isInit = false;

    public Variable(String name, int type, Object value, boolean isInit) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.isInit = isInit;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", type='" + SemanticHelper.getStringFromIntType(type) + '\'' +
                ", value=" + value +
                ", isInit=" + isInit +
                '}';
    }
}
