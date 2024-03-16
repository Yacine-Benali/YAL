package main.models;

import main.SemanticHelper;

public class Parameter {
    public String name;
    public int type;

    public Parameter(String name, int type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "name='" + name + '\'' +
                ", type='" + SemanticHelper.getStringFromIntType(type) + '\'' +
                '}';
    }
}
