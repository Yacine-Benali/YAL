package main;

import main.Exceptions.RuntimeError;
import main.Exceptions.SemanitcException;
import main.Exceptions.TypeMismatch;
import main.jjtree.*;
import main.models.Function;
import main.models.Parameter;
import main.models.Procedure;
import main.models.Variable;

import java.util.ArrayList;
import java.util.List;


public class SemanticAnalysisVisitor implements MyGrammarVisitor {

    public SemanticAnalysisVisitor() {
    }

    @Override
    public Object visit(SimpleNode node, Object data) {
        // General visit method for all nodes
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTStart node, Object data) {
        node.childrenAccept(this, data);
        // careful if not all nodes are being called
        return null;
    }

    @Override
    public Object visit(ASTprogramHeading node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTformalParameterList node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTformalParameterSection node, Object data) {
        // System.out.println("ASTformalParameterSection");

        return node.childrenAccept(this, data);
    }


    @Override
    public Object visit(ASTfunctionDeclaration node, Object data) {
        // has two children (procedureHeading) (procedureBody)
        final Function function = new Function();
        // visit the heading
        node.jjtGetChild(0).jjtAccept(this, data);
        function.heading = ((ASTfunctionHeading) node.jjtGetChild(0));
        function.body = ((ASTfunctionBody) node.jjtGetChild(1));
        SymbolTable.symbolTable.addFunction(function.heading.name, function);
        return null;
    }

    @Override
    public Object visit(ASTfunctionHeading node, Object data) {
        // has two children (identifier) (formalParameterList)
        Node formalParamList = node.jjtGetChild(1);

        if (formalParamList instanceof ASTformalParameterList) {
            List<Parameter> list = SemanticHelper.getParamsFromFormalParametersList((ASTformalParameterList) formalParamList);
            node.parameters.addAll(list);

        } else {
            throw new RuntimeError("Semantic: function formalParameterList not found ");
        }
        return null;
    }

    @Override
    public Object visit(ASTfunctionBody node, Object data) {
        // this will execute the function
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTfunctionCall node, Object data) {
        // get the function, will throw if function is not declared
        Function function = SymbolTable.symbolTable.getFunction(node.name);
        // get procedure heading formal parameter
        List<Integer> formalParameter = function.heading.getFormalParameterTypes();
        // check procedure actual param types
        // children are (identifier) (actualParameters)
        ASTactualParameterList actualParamList = (ASTactualParameterList) node.jjtGetChild(1);
        // visit the actualParameters to fill the values in the nodes
        // before getting the types
        actualParamList.childrenAccept(this, data);
        List<Integer> actualParamTypes = SemanticHelper.getTypesFromActualParameters(actualParamList);

        boolean isEqual = actualParamTypes.equals(formalParameter);
        if (!isEqual) {
            List<String> actualParamTypesString = new ArrayList<String>();
            for (int a : actualParamTypes) {
                actualParamTypesString.add(SemanticHelper.getStringFromIntType(a));
            }
            List<String> formalParamTypesString = new ArrayList<String>();
            for (int a : formalParameter) {
                formalParamTypesString.add(SemanticHelper.getStringFromIntType(a));
            }
            throw new TypeMismatch(node.jjtGetFirstToken(),
                    String.format("Error in calling function expected parameters " +
                            "%s got %s", formalParamTypesString, actualParamTypesString));


        }
        // execute the function, enter new scope
        SymbolTable.symbolTable.enterScope();
        // fill the scope
        List<Object> actualParamValuesList = SemanticHelper.getValuesFromActualParameters(actualParamList);
        // add the actual parameters

        for (int i = 0; i < function.heading.parameters.size(); i++) {
            Object actualParamValues = actualParamValuesList.get(i);
            Parameter fParameter = function.heading.parameters.get(i);
            Variable variable = new Variable(fParameter.name, fParameter.type, actualParamValues, true);
            SymbolTable.symbolTable.addVariable(variable.name, variable);
        }
        // add Result variable
        Variable variable = new Variable("Result", function.heading.returnType, null, false);
        SymbolTable.symbolTable.addVariable(variable.name, variable);

        // call the body
        function.body.jjtAccept(this, null);
        Variable functionResult = SymbolTable.symbolTable.getVariable("Result");
        // leave the scope
        SymbolTable.symbolTable.leaveScope();
        return functionResult.value;

    }

    @Override
    public Object visit(ASTprocedureDeclaration node, Object data) {
        // has two children (procedureHeading) (procedureBody)
        final Procedure procedure = new Procedure();
        // visit the heading
        node.jjtGetChild(0).jjtAccept(this, data);
        procedure.heading = ((ASTprocedureHeading) node.jjtGetChild(0));
        procedure.body = ((ASTprocedureBody) node.jjtGetChild(1));
        SymbolTable.symbolTable.addProcedure(procedure.heading.name, procedure);
        return null;
    }

    @Override
    public Object visit(ASTprocedureHeading node, Object data) {
        // has two children (identifier) (formalParameterList)
        Node formalParamList = node.jjtGetChild(1);

        if (formalParamList instanceof ASTformalParameterList) {
            List<Parameter> list = SemanticHelper.getParamsFromFormalParametersList((ASTformalParameterList) formalParamList);
            node.parameters.addAll(list);

        } else {
            throw new RuntimeError("ASTprocedureHeading: Procedure formalParameterList not found ");
        }
        return null;

    }

    @Override
    public Object visit(ASTprocedureBody node, Object data) {
        // This wille execute the procedure body
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTprocedureCall node, Object data) {
        // get the procedure, will throw if procedure is not declared
        Procedure procedure = SymbolTable.symbolTable.getProcedure(node.name);
        // get procedure heading formal parameter
        List<Integer> formalParameter = procedure.heading.getFormalParameterTypes();
        // check procedure actual param types
        // children are (identifier) (actualParameters)
        ASTactualParameterList actualParamList = (ASTactualParameterList) node.jjtGetChild(1);
        // visit the actualParameters to fill the values in the nodes
        // before getting the types
        actualParamList.childrenAccept(this, data);
        List<Integer> actualParamTypes = SemanticHelper.getTypesFromActualParameters(actualParamList);
        boolean isEqual = actualParamTypes.equals(formalParameter);
        if (!isEqual) {
            List<String> actualParamTypesString = new ArrayList<String>();
            for (int a : actualParamTypes) {
                actualParamTypesString.add(SemanticHelper.getStringFromIntType(a));
            }
            List<String> formalParamTypesString = new ArrayList<String>();
            for (int a : formalParameter) {
                formalParamTypesString.add(SemanticHelper.getStringFromIntType(a));
            }
            throw new TypeMismatch(node.jjtGetFirstToken(),
                    String.format("Error in calling procedure expected parameters " +
                            "%s got %s", formalParamTypesString, actualParamTypesString));


        }
        // execute the function
        SymbolTable.symbolTable.enterScope();
        // fill the scope
        List<Object> actualParamValuesList = SemanticHelper.getValuesFromActualParameters(actualParamList);
        // add the actual parameters
        for (Parameter fParameter : procedure.heading.parameters) {
            for (Object actualParamValues : actualParamValuesList) {
                Variable variable = new Variable(fParameter.name, fParameter.type, actualParamValues, true);
                SymbolTable.symbolTable.addVariable(variable.name, variable);
            }
        }
        // call the body
        procedure.body.jjtAccept(this, null);
        // leave the scope
        SymbolTable.symbolTable.leaveScope();
        return null;
    }


    @Override
    public Object visit(ASTblock node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTvariableDeclarationPart node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTvariableDeclaration node, Object data) {
        // symbol table will throw error if variable already declared
        int varType = SemanticHelper.getIntFromStringType(node.type);
        Variable variable = new Variable(node.name, varType, null, false);
        SymbolTable.symbolTable.addVariable(node.name, variable);
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

        // 1. Get the variable, will throw if undeclared
        Variable variable = SymbolTable.symbolTable.getVariable(node.variableName);
        // 1.1 get variable type
        // TODO change all type to int
        int varType = variable.type;
        if (node.jjtGetChild(1) instanceof ASTExpression expressionNode) {
            // its an expression
            // 2. Get the expression value
            Object express = expressionNode.jjtAccept(this, data);
            // 2.1 Get expression type
            int expType = SemanticHelper.getType(express);

            if (varType != expType) {
                throw new SemanitcException(node.jjtGetFirstToken(), "Incompatible types, variable: "
                        + node.variableName + " type is: " + SemanticHelper.getStringFromIntType(variable.type) +
                        " but was assigned type: " + SemanticHelper.getStringFromIntType(expType));
            }
            // 3 Do the assignment
            variable.value = express;
            variable.isInit = true;
        } else if (node.jjtGetChild(1) instanceof ASTfunctionCall functionCallNode) {
            // it's a function call
            // check the type
            int functionReturnType = functionCallNode.getFunctionReturnType();
            if (varType != functionReturnType) {
                throw new SemanitcException(node.jjtGetFirstToken(),
                        "Incompatible types, variable: " + node.variableName +
                                " type is: " + SemanticHelper.getStringFromIntType(variable.type) +
                                " but function return type is: " +
                                SemanticHelper.getStringFromIntType(functionReturnType));
            }
            // call the function & do the assignment
            Object result = functionCallNode.jjtAccept(this, data);
            if (result == null) {
                throw new SemanitcException(node.jjtGetFirstToken(),
                        "Function returned null, variable: " + node.variableName +
                                " type is: " + SemanticHelper.getStringFromIntType(variable.type) +
                                " but function return was: null ");

            }
            variable.value = result;
            variable.isInit = true;
        } else if (node.jjtGetChild(1).jjtGetChild(0) instanceof ASTbuiltInCalls asTbuiltInCalls) {
            // jjtGetChild(1) for ASTbuiltInCalls
            // jjtGetChild(0) for either (ReadIntCall) or (ReadStringCall)
            if (varType != asTbuiltInCalls.getReturnType()) {
                throw new SemanitcException(node.jjtGetFirstToken(),
                        "Incompatible types, variable: " + node.variableName +
                                " type is: " + SemanticHelper.getStringFromIntType(variable.type) +
                                " but built-in function return type is: " +
                                SemanticHelper.getStringFromIntType(asTbuiltInCalls.getReturnType()));
            } else {
                variable.value = asTbuiltInCalls.jjtAccept(this, data);
                variable.isInit = true;
            }
        }

        return null;
    }

    @Override
    public Object visit(ASTbuiltInCalls node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTReadIntCall node, Object data) {
        return null;
    }

    @Override
    public Object visit(ASTReadStringCall node, Object data) {
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
    public Object visit(ASTactualParameterList node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTactualParameter node, Object data) {
        return node.childrenAccept(this, data);
    }


}
