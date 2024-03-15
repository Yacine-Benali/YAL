/* Generated By:JJTree: Do not edit this line. ASTfunctionHeading.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

import main.Parameter;
import main.SemanticHelper;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public
class ASTfunctionHeading extends SimpleNode {

    public String functionName;
    public int returnType;
    public List<Parameter> parameters = new ArrayList<main.Parameter>();

    public List<Integer> getFormalParameterTypes() {
        List<Integer> parametersType = new ArrayList<Integer>();

        for (Parameter item : parameters) {
            parametersType.add(item.type);

        }
        return parametersType;
    }

    public void setReturnType(String returnType)
    {
        this.returnType = SemanticHelper.getIntFromStringType(returnType);
    }
    public ASTfunctionHeading(int id) {
        super(id);
    }

    public ASTfunctionHeading(MyGrammar p, int id) {
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
        return "ASTfunctionHeading{" +
                "functionName='" + functionName + '\'' +
                ", returnType='" + SemanticHelper.getStringFromIntType(returnType) + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
/* JavaCC - OriginalChecksum=a061cbfde956c59367b07d966f1306c7 (do not edit this line) */
