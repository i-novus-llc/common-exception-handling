package ru.i_novus.components.common.exception;

public class CodifiedException extends RuntimeException
{
	private String code;
    private Object[] args;

	public CodifiedException(String code, Object... args)
	{
		super(code);
        this.code = code;
        this.args = args;
	}

	public CodifiedException(String code, Throwable cause, Object... args)
	{
		super(code, cause);
		this.code = code;
        this.args = args;
	}

	public String getCode()
	{
		return code;
	}

    public Object[] getArgs()
    {
        return args;
    }
}
