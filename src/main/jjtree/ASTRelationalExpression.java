/* Generated By:JJTree: Do not edit this line. ASTRelationalExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTRelationalExpression extends ASTExpression {
  public ASTRelationalExpression(int id) {
    super(id);
  }

  public ASTRelationalExpression(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {
    return execute(visitor, data);
  }
}
/* JavaCC - OriginalChecksum=1a51de0e6c881944c617487844d0fa48 (do not edit this line) */