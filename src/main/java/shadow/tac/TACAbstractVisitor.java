package shadow.tac;

import shadow.ShadowException;
import shadow.tac.nodes.TACBinary;
import shadow.tac.nodes.TACBranch;
import shadow.tac.nodes.TACCall;
import shadow.tac.nodes.TACCast;
import shadow.tac.nodes.TACCatch;
import shadow.tac.nodes.TACClass;
import shadow.tac.nodes.TACClass.TACClassData;
import shadow.tac.nodes.TACClass.TACMethodTable;
import shadow.tac.nodes.TACCopyMemory;
import shadow.tac.nodes.TACLabel;
import shadow.tac.nodes.TACLabelAddress;
import shadow.tac.nodes.TACLandingpad;
import shadow.tac.nodes.TACLength;
import shadow.tac.nodes.TACLiteral;
import shadow.tac.nodes.TACLoad;
import shadow.tac.nodes.TACLocalLoad;
import shadow.tac.nodes.TACLocalStore;
import shadow.tac.nodes.TACLongToPointer;
import shadow.tac.nodes.TACMethodRef;
import shadow.tac.nodes.TACNewArray;
import shadow.tac.nodes.TACNewObject;
import shadow.tac.nodes.TACNode;
import shadow.tac.nodes.TACParameter;
import shadow.tac.nodes.TACPhi;
import shadow.tac.nodes.TACPointerToLong;
import shadow.tac.nodes.TACResume;
import shadow.tac.nodes.TACReturn;
import shadow.tac.nodes.TACSequence;
import shadow.tac.nodes.TACSequenceElement;
import shadow.tac.nodes.TACStore;
import shadow.tac.nodes.TACThrow;
import shadow.tac.nodes.TACTypeId;
import shadow.tac.nodes.TACUnary;

public abstract class TACAbstractVisitor implements TACVisitor {
	
	protected TACNode current = null;

	public void walk(TACNode nodes) throws ShadowException
	{
		current = nodes;
		do
		{
			visit(current);
			current = current.getNext();
		}
		while (current != nodes);
	}
	
	protected void visit(TACNode node) throws ShadowException
	{
		node.accept(this);
	}

	@Override
	public void visit(TACBinary node) throws ShadowException { }	
	@Override
	public void visit(TACBlock node) throws ShadowException { }
	@Override
	public void visit(TACBranch node) throws ShadowException { }
	@Override
	public void visit(TACCall node) throws ShadowException { }
	@Override
	public void visit(TACCast node) throws ShadowException { }
	@Override
	public void visit(TACCatch node) throws ShadowException { }
	@Override
	public void visit(TACClass node) throws ShadowException { }
	@Override
	public void visit(TACClassData node) throws ShadowException { }
	@Override
	public void visit(TACCopyMemory node) throws ShadowException { }	
	@Override
	public void visit(TACLabel node) throws ShadowException { }	
	@Override
	public void visit(TACLabelAddress node) throws ShadowException { }
	@Override
	public void visit(TACLandingpad node) throws ShadowException { }
	@Override
	public void visit(TACLength node) throws ShadowException { }
	@Override
	public void visit(TACLiteral node) throws ShadowException { }
	@Override
	public void visit(TACLoad node) throws ShadowException { }	
	@Override
	public void visit(TACLocalLoad node) throws ShadowException { }
	@Override
	public void visit(TACLocalStore node) throws ShadowException { }
	@Override
	public void visit(TACLongToPointer node) throws ShadowException { }	
	@Override
	public void visit(TACMethodRef node) throws ShadowException { }
	@Override
	public void visit(TACMethodTable node) throws ShadowException { }
	@Override
	public void visit(TACNewArray node) throws ShadowException { }
	@Override
	public void visit(TACNewObject node) throws ShadowException { }	
	@Override
	public void visit(TACPhi node) throws ShadowException { }
	@Override
	public void visit(TACPointerToLong node) throws ShadowException { }	
	@Override
	public void visit(TACSequenceElement node) throws ShadowException { }	
	@Override
	public void visit(TACResume node) throws ShadowException { }
	@Override
	public void visit(TACReturn node) throws ShadowException { }
	@Override
	public void visit(TACSequence node) throws ShadowException { }
	@Override
	public void visit(TACStore node) throws ShadowException { }
	@Override
	public void visit(TACThrow node) throws ShadowException { }
	@Override
	public void visit(TACTypeId node) throws ShadowException { }
	@Override
	public void visit(TACUnary node) throws ShadowException { }
	@Override
	public void visit(TACParameter node) throws ShadowException { }	
}
