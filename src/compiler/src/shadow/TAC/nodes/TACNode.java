package shadow.TAC.nodes;

import java.util.LinkedList;

import shadow.TAC.AbstractTACVisitor;

public abstract class TACNode implements TACInterface {
	private static int labelCounter = 0;
	protected String name;
	protected TACNode parent;
	protected TACNode next;
	
	private static LinkedList<TACNode> allNodes = new LinkedList<TACNode>();
	
	public TACNode(String name, TACNode parent) {
		this.name = "label_" + labelCounter++ + ": " + name;
		this.parent = parent;
		this.next = null;
		this.allNodes.add(this);
	}
	
	public TACNode(String name, TACNode parent, TACNode next) {
		this(name, parent);
		this.next = next;
	}
	
	public void accept(AbstractTACVisitor visitor) {
		visitor.visit(this);
	}
	
	public LinkedList<TACNode> getNodes() {
		return allNodes;
	}
	
	public TACNode getParent() {
		return this.parent;
	}

	public void setParent(TACNode node) {
		this.parent = node;
	}
	
	public TACNode getNext() {
		return this.next;
	}

	public void setNext(TACNode node) {
		this.next = node;
	}
	
	/**
	 * Inserts a node after this node
	 * @param node The node to link onto the end of this node
	 */
	public void insertAfter(TACNode node) {
		node.parent = this;
		node.next = this.next;

		if(this.next != null)
			this.next.parent = node;

		this.next = node;
	}

	/**
	 * Inserts a node before this node
	 * @param node The node to link onto the end of this node
	 */
	public void insertBefore(TACNode node) {
		node.parent = this.parent;
		node.next = this;

		if(this.parent != null)
			this.parent.next = node;

		this.parent = node;
	}
	
	public String toString() {
		return name;
	}
	
	public void dump(String prefix) {
		System.out.println(prefix + this);
		
		if(next == null)
			return;
		
		if(next instanceof TACJoin) {
			return;
		}
		
		next.dump(prefix);
	}
}