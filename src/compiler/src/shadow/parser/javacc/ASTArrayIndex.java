/* Generated By:JJTree: Do not edit this line. ASTArrayIndex.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
class ASTArrayIndex extends SimpleNode {
  public ASTArrayIndex(int id) {
    super(id);
  }

  public ASTArrayIndex(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean data) throws ShadowException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=371a7e41da0f17226dae954084b1ad6e (do not edit this line) */