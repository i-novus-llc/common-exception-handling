package ru.kirkazan.common.exception;

/**
 * User: tnurtdinov
 * Date: 15.11.13
 * Time: 11:01
 */

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
