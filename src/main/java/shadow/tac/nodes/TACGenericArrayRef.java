package shadow.tac.nodes;

import java.util.Collection;

import shadow.typecheck.type.ArrayType;
import shadow.typecheck.type.Type;

public class TACGenericArrayRef extends TACArrayRef {
	
	//in most situations, these two are the same
	//it's possible to have different values in the case of an array
	//e.g. if T is Wombat[], then T[] is Wombat[][]
	//internalParameter would be Wombat[]
	//genericParameter would be Array<Wombat>
	//private TACOperand internalParameter;
	private TACClass genericParameter;
	private boolean isNullable;

	public TACGenericArrayRef(TACNode node, TACOperand reference,
			Collection<TACOperand> ops) {
		this(node, reference, ops, true);
	}
	
	public TACGenericArrayRef(TACNode node, TACOperand reference,
			Collection<TACOperand> ops, boolean check) {
		super(node, reference, ops, check);
		
		ArrayType arrayType = (ArrayType) reference.getType();
		Type baseType = arrayType.getBaseType();
		genericParameter = new TACClass(node, baseType);		
		isNullable =  reference.getModifiers().isNullable(); 
	}
	
	public TACClass getGenericParameter() {
		return genericParameter;
	}
	
	public boolean isNullable() {
		return isNullable;
	}
	
}
