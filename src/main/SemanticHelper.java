package main;

import main.jjtree.*;

import java.util.ArrayList;
import java.util.List;

// the possible ways a right hand side can be

public class SemanticHelper {

    static public int getIntFromStringType(String str) {
        if (str.equals("int")) return 0;
        if (str.equals("real")) return 1;
        if (str.equals("string")) return 2;
        if (str.equals("bool")) return 3;
        throw new RuntimeException("getIntFromStringType could not solve " + str);

    }

    static public String getStringFromIntType(int numberType) {
        if (numberType == 0) return "int";
        if (numberType == 1) return "real";
        if (numberType == 2) return "string";
        if (numberType == 3) return "bool";
        throw new RuntimeException("getStringFromIntType could not solve " + numberType);

    }

    static public int getType(Object ob) {

        if (ob instanceof Integer) return 0;
        if (ob instanceof Double) return 1;
        if (ob instanceof String) return 2;
        if (ob instanceof Boolean) return 3;
        return -1;
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
