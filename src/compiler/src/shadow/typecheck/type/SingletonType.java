package shadow.typecheck.type;

public class SingletonType extends ClassType {
	
	public SingletonType(String typeName, ClassType parent ) {
		super( typeName, parent );

	}

	public SingletonType(String typeName, int modifiers, ClassInterfaceBaseType outer ) {
		super( typeName, modifiers, outer );
	}
}