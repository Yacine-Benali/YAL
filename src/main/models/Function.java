package main.models;

import main.jjtree.ASTfunctionBody;
import main.jjtree.ASTfunctionHeading;


public class Function {

    public ASTfunctionHeading heading;
    public ASTfunctionBody body;

    @Override
    public String toString() {
        return "Function{" +
                "heading=" + heading +
                ", body=" + body +
                '}';
    }

}
