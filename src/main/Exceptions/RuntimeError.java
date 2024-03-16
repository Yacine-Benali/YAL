package main.Exceptions;

public class RuntimeError extends RuntimeException{
    public RuntimeError(String str) {
        super(str);
    }
}
