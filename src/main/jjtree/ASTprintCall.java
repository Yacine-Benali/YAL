/* Generated By:JJTree: Do not edit this line. ASTprintCall.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTprintCall extends SimpleNode {
  public ASTprintCall(int id) {
    super(id);
  }

  public ASTprintCall(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {
    System.out.println(jjtGetChild(0).jjtAccept(visitor,data));
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=55e4e20caab11c27f0b3347536b9c1e8 (do not edit this line) */