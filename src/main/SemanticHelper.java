package main;

import main.Exceptions.RuntimeError;
import main.jjtree.*;
import main.models.Parameter;

import java.util.ArrayList;
import java.util.List;

// the possible ways a right hand side can be

public class SemanticHelper {

    static public int getIntFromStringType(String str) {
        if (str.equals("int")) return 0;
        if (str.equals("real")) return 1;
        if (str.equals("string")) return 2;
        if (str.equals("bool")) return 3;
        throw new RuntimeError("getIntFromStringType could not solve " + str);

    }

    static public String getStringFromIntType(int numberType) {
        if (numberType == 0) return "int";
        if (numberType == 1) return "real";
        if (numberType == 2) return "string";
        if (numberType == 3) return "bool";
        if (numberType == -1) return "null";
        throw new RuntimeError("getStringFromIntType could not solve " + numberType);

    }

    static public int getType(Object ob) {

        if (ob instanceof Integer) return 0;
        if (ob instanceof Double) return 1;
        if (ob instanceof String) return 2;
        if (ob instanceof Boolean) return 3;
        return -1;
    }

    public static boolean getSolve(Object ob) {
        int type = SemanticHelper.getType(ob);
        boolean bo = true;
        if (type == 0 && ((Integer) ob).equals(0)) bo = false;
        if (type == 1 && (Double) ob == 0) bo = false;
        if (type == 3 && (Boolean) ob == false) bo = false;
        return bo;
    }

    static public List<Integer> getTypesFromActualParameters(ASTactualParameterList actualParamList) {
        List<Integer> actualParamTypes = new ArrayList<>();
        for (int i = 0; i < actualParamList.jjtGetNumChildren(); i++) {
            Node paramNode = actualParamList.jjtGetChild(i);
            if (paramNode instanceof ASTactualParameter) {
                Integer type = ((ASTactualParameter) paramNode).type;
                actualParamTypes.add(type);
            }
        }
        return actualParamTypes;
    }

    static public List<Object> getValuesFromActualParameters(ASTactualParameterList actualParamList) {
        List<Object> actualParamValues = new ArrayList<>();
        for (int i = 0; i < actualParamList.jjtGetNumChildren(); i++) {
            Node paramNode = actualParamList.jjtGetChild(i);
            if (paramNode instanceof ASTactualParameter) {
                actualParamValues.add(((ASTactualParameter) paramNode).value);
            }
        }
        return actualParamValues;
    }



    static public List<Parameter> getParamsFromFormalParametersList(ASTformalParameterList formalParamList) {
        List<Parameter> parameters = new ArrayList<Parameter>();
        for (int i = 0; i < formalParamList.jjtGetNumChildren(); i++) {
            Node child = formalParamList.jjtGetChild(i);

            if (child instanceof ASTformalParameterSection paramSection) {
                String paramName = paramSection.paramName;
                int paramType = paramSection.paramType;
                // Process the parameter here, like adding it to a list in ASTFunctionHeading
                parameters.add(new Parameter(paramName, paramType));
            }
        }
        return parameters;
    }
}
