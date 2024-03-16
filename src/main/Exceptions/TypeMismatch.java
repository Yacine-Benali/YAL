package main.Exceptions;

import main.jjtree.Token;

public class TypeMismatch extends RuntimeException{
    public TypeMismatch(Token firstToken, String message) {
        super(String.format("TypeError at line %s, column %s: %s",
                firstToken.beginLine,firstToken.beginColumn, message));
    }
}
