package shadow.doctool;

import shadow.ShadowException;
import shadow.ShadowExceptionFactory;

@SuppressWarnings("serial")
public class DocumentationException extends ShadowException
{
	public DocumentationException(String message)
	{
		super(message);		
	}

	@Override
	public ShadowExceptionFactory getError() {
		return null;
	}
}
