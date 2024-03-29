/* Generated By:JJTree: Do not edit this line. ASTReadStringCall.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package main.jjtree;

import java.util.InputMismatchException;
import java.util.Scanner;

public
class ASTReadStringCall extends ASTbuiltInCalls {
    @Override
    public int getReturnType() {
        return 2;
    }

    public ASTReadStringCall(int id) {
        super(id);
    }

    public ASTReadStringCall(MyGrammar p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(MyGrammarVisitor visitor, Object data) {

        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine(); // Attempt to read an integer
        } catch (InputMismatchException e) {
            return null;
        } finally {
            scanner.close();

        }
    }
}
/* JavaCC - OriginalChecksum=803f9162a17497e5907e75cf38b31196 (do not edit this line) */
