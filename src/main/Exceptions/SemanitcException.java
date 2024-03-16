package main.Exceptions;

import main.jjtree.Token;

public class SemanitcException extends RuntimeException{

    public SemanitcException(Token firstToken, String message) {
        super(String.format("SemanitcException at line %s, column %s: %s",
                firstToken.beginLine,firstToken.beginColumn, message));
    }
}
