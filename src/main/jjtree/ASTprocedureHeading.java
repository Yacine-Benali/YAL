/* Generated By:JJTree: Do not edit this line. ASTprocedureHeading.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

import main.Parameter;

import java.util.ArrayList;
import java.util.List;

public
class ASTprocedureHeading extends SimpleNode {
    public String name;
    public List<Parameter> parameters = new ArrayList<Parameter>();

    public List<Integer> getFormalParameterTypes() {
        List<Integer> parametersType = new ArrayList<Integer>();

        for (Parameter item : parameters) {
            parametersType.add(item.type);

        }
        return parametersType;
    }

    public ASTprocedureHeading(int id) {
        super(id);
    }

    public ASTprocedureHeading(MyGrammar p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

        return
                visitor.visit(this, data);
    }

    @Override
    public String toString() {
        return "ASTprocedureHeading{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
/* JavaCC - OriginalChecksum=839430a7949daebb86ae571450a48970 (do not edit this line) */
