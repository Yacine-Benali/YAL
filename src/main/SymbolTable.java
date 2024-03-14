package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import main.jjtree.ASTfunctionHeading;
import main.jjtree.ASTprocedureHeading;
import main.jjtree.ASTvariableDeclaration;

/**
 * Class representing a symbol table with scope management.
 */

public class SymbolTable {
    private final Stack<Map<String, Object>> scopeStack;

    public SymbolTable() {
        this.scopeStack = new Stack<>();
        this.scopeStack.push(new HashMap<>()); // Global scope
    }

    public void addFunction(String name, ASTfunctionHeading functionNode)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            // TODO show error line and column
            throw new RuntimeException("SymbolTable: Function '" + name + "' already defined in the current scope");

        }
        currentScope.put(name, functionNode);
    }
    public boolean doesFunctionExist(String name)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)  ) {
            return currentScope.get(name) instanceof ASTfunctionHeading;
        }
        return false;
    }
    public ASTfunctionHeading getFunctionHeading(String name)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)  ) {
            if(currentScope.get(name) instanceof ASTfunctionHeading)
                return (ASTfunctionHeading)currentScope.get(name);
        }
        throw new RuntimeException("SymbolTable: function '" + name + "' could not be retrieved");
    }

    public void addProcedure(String name, ASTprocedureHeading procedureNode)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            // TODO show error line and column
            throw new RuntimeException("SymbolTable: Procedure '" + name + "' already defined in the current scope");
        }
        currentScope.put(name, procedureNode);
    }


    public boolean doesProcedureExist(String name)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)  ) {
            return currentScope.get(name) instanceof ASTprocedureHeading;
        }
        return false;
    }

    public ASTprocedureHeading getProcedureHeading(String name)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)  ) {
            if(currentScope.get(name) instanceof ASTprocedureHeading)
                return (ASTprocedureHeading)currentScope.get(name);
        }
        throw new RuntimeException("Procedure '" + name + "' could not be retrieved");

    }

    public void addVariable(String name, ASTvariableDeclaration variableNode)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            throw new RuntimeException("SymbolTable: Variable '" + name + "' already defined in the current scope");
        }
        currentScope.put(name, variableNode);
    }

    public boolean doesVariableExist(String name)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)  ) {
            return currentScope.get(name) instanceof ASTvariableDeclaration;
        }
        return false;
    }
    public ASTvariableDeclaration getVariableDeclaration(String name)  {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)  ) {
            if(currentScope.get(name) instanceof ASTvariableDeclaration)
                return (ASTvariableDeclaration)currentScope.get(name);
        }
        throw new RuntimeException("SymbolTable: Variable '" + name + "' could not be retrieved");
    }


    public boolean getVariableType(String name)
    {
        return true;
    }



    /**
     * Retrieves the type of the closest declaration of a symbol.
     */
    public Object getSymbolType(String name) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            Map<String, Object> scope = scopeStack.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        throw new RuntimeException("Symbol  '" + name + "' not found in any scope");
    }

    /**
     * Enters a new scope.
     */
    public void enterScope() {
        scopeStack.push(new HashMap<>());
    }

    /**
     * Leaves the current scope.
     */
    public void leaveScope() {
        if (!scopeStack.isEmpty()) {
            scopeStack.pop();
        }
    }

    /**
     * Adds a symbol to the current scope.
     */
    public boolean addSymbol(String name, String type) {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            return false; // Symbol already exists in current scope
        }

        currentScope.put(name, type);
        return true;
    }

    /**
     * Checks if a symbol is declared in any accessible scope.
     */
    public boolean symbolExists(String name) {
        for (Map<String, Object> scope : scopeStack) {
            if (scope.containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the symbol table with scopes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol Table with Scopes: #" + scopeStack.size() + "\n" );
        for (int scopeLevel = 0 ; scopeLevel < scopeStack.size();scopeLevel++)
        {
            for (Map<String, Object> scope : scopeStack) {
                sb.append("Scope level ").append(scopeLevel).append(":\n");
                for (Map.Entry<String, Object> entry : scope.entrySet()) {
                    sb.append("  Name: ").append(entry.getKey()).append(", Type: ").append(entry.getValue().toString()).append("\n");
                }
                scopeLevel++;
            }
        }
        return sb.toString();
    }
}
