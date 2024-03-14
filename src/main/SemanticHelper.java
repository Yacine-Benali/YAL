package main;

import main.jjtree.ASTactualParameter;
import main.jjtree.ASTactualParameterList;
import main.jjtree.ASTvariableDeclaration;
import main.jjtree.Node;

import java.util.ArrayList;
import java.util.List;

// the possible ways a right hand side can be

public class SemanticHelper {

    static public List<String> getTypesFromActualParameters(ASTactualParameterList actualParamList, SymbolTable symbolTable) {
        List<String> actualParamTypes = new ArrayList<>();
        for (int i = 0; i < actualParamList.jjtGetNumChildren(); i++) {
            Node paramNode = actualParamList.jjtGetChild(i);
            if (paramNode instanceof ASTactualParameter) {
                String paramType;
                if (((ASTactualParameter) paramNode).isIdentifier) {
                    // variable passed as parameter needs to be checked
                    ASTvariableDeclaration variableNode = symbolTable.getVariableDeclaration(((ASTactualParameter) paramNode).type);

                    paramType = (variableNode).type;

                } else {
                    paramType = ((ASTactualParameter) paramNode).type;
                }
                actualParamTypes.add(paramType);
            }
        }
        return actualParamTypes;
    }
}
