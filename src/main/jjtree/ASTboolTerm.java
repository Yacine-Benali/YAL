/* Generated By:JJTree: Do not edit this line. ASTboolTerm.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTboolTerm extends SimpleNode {
  public ASTboolTerm(int id) {
    super(id);
  }

  public ASTboolTerm(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ccdf2f3ee72957e861ba35d453e66926 (do not edit this line) */
