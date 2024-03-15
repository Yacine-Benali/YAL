/* Generated By:JJTree: Do not edit this line. ASTformalParameterSection.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

import main.SemanticHelper;

public
class ASTformalParameterSection extends SimpleNode {
  public String paramName;
  public int paramType;

  public void setParamType(String paramName)
  {
   this.paramType =   SemanticHelper.getIntFromStringType(paramName);
  }

  public ASTformalParameterSection(int id) {
    super(id);
  }

  public ASTformalParameterSection(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d60cd1d42f7ede3f820f9c9db845d7c7 (do not edit this line) */
