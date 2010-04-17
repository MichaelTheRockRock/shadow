package shadow.TAC;

import shadow.TAC.nodes.TACAssign;
import shadow.TAC.nodes.TACBinaryOperation;
import shadow.TAC.nodes.TACBranch;
import shadow.TAC.nodes.TACInterface;
import shadow.TAC.nodes.TACJoin;
import shadow.TAC.nodes.TACNoOp;
import shadow.TAC.nodes.TACNode;
import shadow.TAC.nodes.TACUnaryOperation;

public abstract class AbstractTACVisitor {
	private TACNode root;
	
	public AbstractTACVisitor(TACNode root) {
		this.root = root;
	}
	
	public TACNode getRoot() {
		return root;
	}
	
	public void visit(TACInterface node) {
		node.accept(this);
	}
	
	abstract public void start();
	abstract public void end();
	
	public void visit(TACAssign node) {
		System.out.println(node);
	}
	
	public void visit(TACBinaryOperation node) {
		System.out.println(node);
	}
	
	public void visit(TACBranch node) {
		System.out.println(node);
	}
	
	public void visit(TACJoin node) {
		System.out.println(node);
	}
	
	public void visit(TACNoOp node) {
		System.out.println(node);
	}

	public void visit(TACUnaryOperation node) {
		System.out.println(node);
	}
}