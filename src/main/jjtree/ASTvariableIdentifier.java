/* Generated By:JJTree: Do not edit this line. ASTvariableIdentifier.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTvariableIdentifier extends SimpleNode {
  public ASTvariableIdentifier(int id) {
    super(id);
  }

  public ASTvariableIdentifier(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f57f4e6961c6b0110959b6105bb3a269 (do not edit this line) */
