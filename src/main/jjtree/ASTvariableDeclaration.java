/* Generated By:JJTree: Do not edit this line. ASTvariableDeclaration.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTvariableDeclaration extends SimpleNode {
  public ASTvariableDeclaration(int id) {
    super(id);
  }

  public String name;
  public String type;

  public ASTvariableDeclaration(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }

  @Override
  public String toString() {
    return "ASTvariableDeclaration{" +
            "name='" + name + '\'' +
            ", type='" + type + '\'' +
            '}';
  }
}
/* JavaCC - OriginalChecksum=0cef36746cc2baeaaeb201a21f46e729 (do not edit this line) */
