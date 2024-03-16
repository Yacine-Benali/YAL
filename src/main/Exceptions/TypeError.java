package main.Exceptions;

import main.jjtree.Token;

public class TypeError extends RuntimeException {
    public TypeError(Token firstToken, String message) {
        super(String.format("TypeError at line %s, column %s: %s",
                firstToken.beginLine,firstToken.beginColumn, message));
    }
    // Additional constructors or methods if needed
}
