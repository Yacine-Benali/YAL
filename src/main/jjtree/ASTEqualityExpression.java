/* Generated By:JJTree: Do not edit this line. ASTEqualityExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTEqualityExpression extends ASTExpression {
  public ASTEqualityExpression(int id) {
    super(id);
  }

  public ASTEqualityExpression(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {
    return execute(visitor, data);
  }
}
/* JavaCC - OriginalChecksum=739469668405a7f0892d515517beb5b0 (do not edit this line) */
