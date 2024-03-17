package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import main.Exceptions.RuntimeError;
import main.models.Function;
import main.models.Procedure;
import main.models.Variable;

/**
 * Class representing a symbol table with scope management.
 */

public class SymbolTable {
    private final Stack<Map<String, Object>> scopeStack;
    static public SymbolTable symbolTable = new SymbolTable();

    public SymbolTable() {
        this.scopeStack = new Stack<>();
        this.scopeStack.push(new HashMap<>()); // Global scope
    }

    public void addFunction(String name, Function function) {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            // TODO show error line and column
            throw new RuntimeError("SymbolTable: Function '" + name + "' already defined in the current scope");

        }
        currentScope.put(name, function);
    }


    public Function getFunction(String name) {
        // search all scopes
        for (Map<String, Object> currentScope : scopeStack) {
            if (currentScope.containsKey(name)) {
                if (currentScope.get(name) instanceof Function)
                    return (Function) currentScope.get(name);
            }
        }
        throw new RuntimeError("SymbolTable, Undeclared function called: " + name);
    }

    public void addProcedure(String name, Procedure procedure) {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            // TODO show error line and column
            throw new RuntimeError("SymbolTable: Procedure '" + name + "' already defined in the current scope");
        }
        currentScope.put(name, procedure);
    }

    public Procedure getProcedure(String name) {
        for (Map<String, Object> currentScope : scopeStack) {
            if (currentScope.containsKey(name)) {
                if (currentScope.get(name) instanceof Procedure)
                    return (Procedure) currentScope.get(name);
            }
        }
        throw new RuntimeError("SymbolTable, Undeclared procedure called: " + name);

    }

    public void addVariable(String name, Variable variableNode) {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            throw new RuntimeError("SymbolTable: Variable '" + name + "' already defined in the current scope");
        }
        currentScope.put(name, variableNode);
    }

    public Variable getVariable(String name) {
        Map<String, Object> currentScope = scopeStack.peek();
        if (currentScope.containsKey(name)) {
            if (currentScope.get(name) instanceof Variable)
                return (Variable) currentScope.get(name);
        }
        throw new RuntimeError("SymbolTable: Variable '" + name + "' is undeclared in the scope");
    }


    public boolean getVariableType(String name) {
        return true;
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
     * Returns a string representation of the symbol table with scopes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol Table with Scopes: #" + scopeStack.size() + "\n");
        for (int scopeLevel = 0; scopeLevel < scopeStack.size(); scopeLevel++) {
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
