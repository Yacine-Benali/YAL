/* Generated By:JJTree: Do not edit this line. ASTprogramHeading.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

public
class ASTprogramHeading extends SimpleNode {
  public ASTprogramHeading(int id) {
    super(id);
  }

  public ASTprogramHeading(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e081d846263950426aa7831229dc605d (do not edit this line) */
