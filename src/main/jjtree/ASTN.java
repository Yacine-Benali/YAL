/* Generated By:JJTree: Do not edit this line. ASTN.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

import main.SymbolTable;
import main.models.Variable;

public
class ASTN extends ASTExpression {
  public ASTN(int id) {
    super(id);
  }
  public boolean isVariable = false;
  public String variableName;

  public ASTN(MyGrammar p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MyGrammarVisitor visitor, Object data) {
    if(isVariable)
    {
      Variable variable = SymbolTable.symbolTable.getVariableDeclaration(variableName);
      return variable.value;
    }
    return execute(visitor, data);
  }
}
/* JavaCC - OriginalChecksum=add8061fa7799fbe07e8f43918a11802 (do not edit this line) */
