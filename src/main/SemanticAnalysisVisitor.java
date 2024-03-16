package main;

import main.jjtree.*;

import java.util.List;


public class SemanticAnalysisVisitor implements MyGrammarVisitor {

    public SemanticAnalysisVisitor() {
    }

    @Override
    public Object visit(SimpleNode node, Object data) {
        // General visit method for all nodes
        System.out.println("visit SimpleNode");
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTStart node, Object data) {
        System.out.println("ASTStart");
        node.childrenAccept(this, data);
        System.out.println(SymbolTable.symbolTable);
        // careful if not all nodes are being called
        return null;
    }

    @Override
    public Object visit(ASTprogramHeading node, Object data) {

        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTfunctionDeclaration node, Object data) {

        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTfunctionHeading node, Object data) {

        Node formalParamList = node.jjtGetChild(1);

        if (formalParamList instanceof ASTformalParameterList) {
            List<Parameter> list = SemanticHelper.getParamsFromFormalParametersList((ASTformalParameterList) formalParamList);
            node.parameters.addAll(list);
            SymbolTable.symbolTable.addFunction(node.functionName, node);
        } else {
            throw new RuntimeException("Semantic: Procedure ArgumentList not found ");
        }
        return node.childrenAccept(this, data);

    }

    @Override
    public Object visit(ASTfunctionBody node, Object data) {

        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTformalParameterList node, Object data) {
        // System.out.println("ASTformalParameterList");
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTformalParameterSection node, Object data) {
        // System.out.println("ASTformalParameterSection");

        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTprocedureDeclaration node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTprocedureHeading node, Object data) {
        Node formalParamList = node.jjtGetChild(1);

        if (formalParamList instanceof ASTformalParameterList) {
            List<Parameter> list = SemanticHelper.getParamsFromFormalParametersList((ASTformalParameterList) formalParamList);
            node.parameters.addAll(list);
            SymbolTable.symbolTable.addProcedure(node.name, node);
        } else {
            throw new RuntimeException("Semantic: Procedure ArgumentList not found ");
        }


        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTprocedureBody node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTblock node, Object data) {

        if (node.jjtGetParent() instanceof ASTStart) {
            // dont push into the stack if its the first block
            node.childrenAccept(this, data);
            return null;
        }
        SymbolTable.symbolTable.enterScope();
        node.childrenAccept(this, data);
        SymbolTable.symbolTable.leaveScope();
        return null;

    }

    @Override
    public Object visit(ASTvariableDeclarationPart node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTvariableDeclaration node, Object data) {
        // symbol table will throw error if variable already declared
        SymbolTable.symbolTable.addVariable(node.name, node);
        return null;
    }

    @Override
    public Object visit(ASTstatementPart node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTstatementSequence node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTstatement node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTsimpleStatement node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTbreak2 node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTprintCall node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTprocedureCall node, Object data) {

        // Check if procedure is declared
        if (!SymbolTable.symbolTable.doesProcedureExist(node.name)) {
            throw new RuntimeException("Semantic: Undeclared procedure used: " + node.name);
        }
        // get the procedure heading
        ASTprocedureHeading procedureHeading = SymbolTable.symbolTable.getProcedureHeading(node.name);
        // get function heading formal parameter
        List<Integer> formalParameter = procedureHeading.getFormalParameterTypes();

        // check procedure actual param types
        Node actualParamList = node.jjtGetChild(1);
        if (!(actualParamList instanceof ASTactualParameterList)) {
            System.err.println("Semantic: visit(ASTprocedureCall)");
            System.exit(1);
        }

        // visit the actualParameters before getting the types
        ((ASTactualParameterList)actualParamList).childrenAccept(this, data);
        List<Integer> actualParamTypes = SemanticHelper.getTypesFromActualParameters(
                (ASTactualParameterList) actualParamList        );

        boolean isEqual = actualParamTypes.equals(formalParameter);
        if (!isEqual) {
            System.err.println("Error in calling procedure expected parameters " + formalParameter + " got " + actualParamTypes);
            System.exit(1);
        }

        return null;
    }

    @Override
    public Object visit(ASTstructuredStatement node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTwhileStatement node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTifStatement node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTidentifierList node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTtypeIdentifier node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTidentifier node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTvariableIdentifier node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTassignmentStatement node, Object data) {
        // Check if variable is declared
        if (!SymbolTable.symbolTable.doesVariableExist(node.variableName)) {
            throw new RuntimeException("Semantic: Undeclared variable used: " + node.variableName);
        }

        // 1. Get the variable
        ASTvariableDeclaration variable = SymbolTable.symbolTable.getVariableDeclaration(node.variableName);
        // 1.1 get variable type
        // TODO change all type to int
        int varType = SemanticHelper.getIntFromStringType(variable.type);
        if(node.jjtGetChild(1) instanceof  ASTExpression expressionNode)
        {
            // its an expression
            // 2. Get the expression value
            Object expres = expressionNode.jjtAccept(this, data);
            // 2.1 Get expression type
            int expType = SemanticHelper.getType(expres);

            if (varType != expType) {
                throw new RuntimeException("Semantic: Uncompatible types, variable: " + node.variableName
                        + " type is: " + variable.type + " but was assigned type: " + SemanticHelper.getStringFromIntType(expType));
            }
            // 3 Do the assignment
            variable.value = expres;
            variable.isInit = true;
        }else if (node.jjtGetChild(1) instanceof  ASTfunctionCall functioncallNode) {
           // its a function call
            // check the type
            int functionReturnType = functioncallNode.getFunctionReturnType();
            if (varType != functionReturnType) {
                throw new RuntimeException("Semantic: Uncompatible types, variable: " + node.variableName
                        + " type is: " + variable.type + " but was assigned function return type: " +
                        SemanticHelper.getStringFromIntType(functionReturnType));
            }
            return node.childrenAccept(this, data);

        }

        return null;
    }

    @Override
    public Object visit(ASTExpression node, Object data) {
        return null;
    }

    // @Override
    public Object visit(ASTAndExpression node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTEqualityExpression node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTRelationalExpression node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTAdditiveExpression node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTMultiplicativeExpression node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTUnaryExpression node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTN node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTLiteralExpression node, Object data) {
        return null;
    }


    @Override
    public Object visit(ASTfunctionCall node, Object data) {

        // Check if function is declared
        if (!SymbolTable.symbolTable.doesFunctionExist(node.functionName)) {
            System.err.println("Semantic: Undeclared function used: " + node.functionName);
            System.exit(1);
        }
        // get the function heading
        ASTfunctionHeading functionHeading = SymbolTable.symbolTable.getFunctionHeading(node.functionName);
        // get function heading formal parameter
        List<Integer> formalParameter = functionHeading.getFormalParameterTypes();
        // check procedure actual param types
        Node actualParamList = node.jjtGetChild(1);
        if (!(actualParamList instanceof ASTactualParameterList)) {
            System.err.println("Semantic: visit(ASTprocedureCall)");
            System.exit(1);
        }

        // visit the actualParameters before getting the types
        ((ASTactualParameterList)actualParamList).childrenAccept(this, data);
        List<Integer> actualParamTypes = SemanticHelper.getTypesFromActualParameters(
                (ASTactualParameterList) actualParamList        );

        boolean isEqual = actualParamTypes.equals(formalParameter);
        if (!isEqual) {
            System.err.println("Error in calling function expected parameters " + formalParameter + " got " + actualParamTypes);
            System.exit(1);
        }

        return null;

    }

    @Override
    public Object visit(ASTactualParameterList node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTactualParameter node, Object data) {
        return node.childrenAccept(this, data);
    }


}
