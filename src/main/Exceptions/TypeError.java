package main.Exceptions;

public class TypeError extends RuntimeException {
    public TypeError(String message) {
        super("TypeError: "+message);
    }
    // Additional constructors or methods if needed
}
