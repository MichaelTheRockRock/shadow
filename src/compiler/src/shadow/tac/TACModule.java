package shadow.tac;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import shadow.output.text.TextOutput;
import shadow.parser.javacc.ShadowException;
import shadow.typecheck.type.ClassInterfaceBaseType;
import shadow.typecheck.type.ClassType;
import shadow.typecheck.type.InterfaceType;
import shadow.typecheck.type.Type;

public class TACModule
{
	private ClassInterfaceBaseType type;
	private Set<ClassInterfaceBaseType> references =
			new HashSet<ClassInterfaceBaseType>();
	private Map<String, Type> fields = new HashMap<String, Type>();
	private List<TACMethod> methods = new ArrayList<TACMethod>();
	public TACModule(ClassInterfaceBaseType moduleType)
	{
		type = moduleType;
		for (String fieldName : moduleType.getFields().keySet())
			fields.put(fieldName, moduleType.getField(fieldName).getType());
		add(moduleType);

		add(Type.BOOLEAN);
		add(Type.CODE);
		add(Type.BYTE);
		add(Type.UBYTE);
		add(Type.SHORT);
		add(Type.USHORT);
		add(Type.INT);
		add(Type.UINT);
		add(Type.LONG);
		add(Type.ULONG);
		add(Type.FLOAT);
		add(Type.DOUBLE);
	}
	private void add(ClassInterfaceBaseType type)
	{
		if (references.add(type))
		{
			if (type instanceof ClassType)
			{
				ClassType classType = (ClassType)type;
				add(classType.getExtendType());
				for (Type referenced : classType.getReferencedTypes())
					if (referenced instanceof ClassInterfaceBaseType)
						add((ClassInterfaceBaseType)referenced);
			}
		}
	}

	public ClassInterfaceBaseType getType()
	{
		return type;
	}
	public boolean isClass()
	{
		return type instanceof ClassType;
	}
	public ClassType getClassType()
	{
		return (ClassType)type;
	}
	public boolean isInterface()
	{
		return type instanceof InterfaceType;
	}
	public InterfaceType getInterfaceType()
	{
		return (InterfaceType)type;
	}

	public String getQualifiedName()
	{
		return type.getQualifiedName();
	}

	public Set<ClassInterfaceBaseType> getReferences()
	{
		return references;
	}

	public Set<String> getFieldNames()
	{
		return fields.keySet();
	}
	public Collection<Type> getFieldTypes()
	{
		return fields.values();
	}
	public Type getFieldType(String name)
	{
		return fields.get(name);
	}

	public void addMethod(TACMethod method)
	{
		methods.add(method);
	}
	public List<TACMethod> getMethods()
	{
		return methods;
	}

	@Override
	public String toString()
	{
		StringWriter writer = new StringWriter();
		try
		{
			new TextOutput(writer).build(this);
		}
		catch (ShadowException ex)
		{
			return "Error";
		}
		return writer.toString();
	}
}
