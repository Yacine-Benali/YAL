/* Generated By:JJTree: Do not edit this line. ASTprocedureDeclaration.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTprocedureDeclaration extends SimpleNode {
  public ASTprocedureDeclaration(int id) {
    super(id);
  }

  public ASTprocedureDeclaration(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=bc7f27b2195ce232438cce9f4bbe9a4c (do not edit this line) */
