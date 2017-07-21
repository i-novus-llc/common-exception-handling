package ru.kirkazan.common.exception;

import java.util.List;

/**
 * @author Rushan Makhmutov
 * @since 24.03.14
 */
public class ParsedSQLException
{
	private String messageCode;
	private List<String> parameters;

	public ParsedSQLException()
	{
	}

	public ParsedSQLException(String messageCode, List<String> parameters)
	{
		this.messageCode = messageCode;
		this.parameters = parameters;
	}

	public String getMessageCode()
	{
		return messageCode;
	}

	public void setMessageCode(String messageCode)
	{
		this.messageCode = messageCode;
	}

	public List<String> getParameters()
	{
		return parameters;
	}

	public void setParameters(List<String> parameters)
	{
		this.parameters = parameters;
	}
}
