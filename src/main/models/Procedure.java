package main.models;

import main.jjtree.ASTprocedureBody;
import main.jjtree.ASTprocedureHeading;

import java.util.ArrayList;
import java.util.List;

public class Procedure {
    public ASTprocedureHeading heading;
    public ASTprocedureBody body;

    @Override
    public String toString() {
        return "Procedure{" +
                "heading=" + heading +
                ", body=" + body +
                '}';
    }
}
