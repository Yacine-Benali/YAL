/* Generated By:JJTree: Do not edit this line. ASTsimpleStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTsimpleStatement extends SimpleNode {
  public ASTsimpleStatement(int id) {
    super(id);
  }

  public ASTsimpleStatement(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=982c89d13c9b70f8828445e2c4505474 (do not edit this line) */
