/* Generated By:JJTree: Do not edit this line. ASTSingletonInstance.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
class ASTSingletonInstance extends SimpleNode {
  public ASTSingletonInstance(int id) {
    super(id);
  }
  

  public ASTSingletonInstance(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean data) throws ShadowException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=82d4a33bd39c6e193c126ce9251c05a4 (do not edit this line) */
