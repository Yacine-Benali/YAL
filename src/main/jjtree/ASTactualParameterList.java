/* Generated By:JJTree: Do not edit this line. ASTactualParameterList.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTactualParameterList extends SimpleNode {
  public ASTactualParameterList(int id) {
    super(id);
  }

  public ASTactualParameterList(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=22dcd3cc08fb7ee81186afe8b8ff07fb (do not edit this line) */
