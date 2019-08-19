package ru.i_novus.components.common.exception;

public class MessageInfo
{
    private String code;
    private Object[] args;

    public MessageInfo(String code, Object... args)
    {
        this.code = code;
        this.args = args;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public void setArgs(Object[] args)
    {
        this.args = args;
    }
}
