package ru.i_novus.components.common.exception;

public class CodifiedValidationException extends CodifiedException
{
    public CodifiedValidationException(String code, Object... args)
    {
        super(code, args);
    }

    public CodifiedValidationException(String code, Throwable cause, Object... args)
    {
        super(code, cause, args);
    }
}
