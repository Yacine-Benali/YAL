/* Generated By:JJTree: Do not edit this line. ASTassignmentStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTassignmentStatement extends SimpleNode {
  public String variableName;

  public ASTassignmentStatement(int id) {
    super(id);
  }

  public ASTassignmentStatement(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=106098c748ea999d34fa4c4da5526ab3 (do not edit this line) */
