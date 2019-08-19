package ru.i_novus.components.common.exception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLExceptionParser
{
	public static MessageInfo getMessageInfo(SQLException ex)
	{
		SQLStateEnum stateEnum = SQLStateEnum.getSQLStateEnum(ex.getSQLState());
		if (stateEnum != null)
			return resolveSQLException(stateEnum, ex.getMessage());

		return null;
	}

	public static ParsedSQLException getParsedExceptionMessage(SQLException ex)
	{
		SQLStateEnum stateEnum = SQLStateEnum.getSQLStateEnum(ex.getSQLState());
		if (stateEnum != null)
			return parseExceptionMessage(stateEnum, ex.getMessage());

		return null;
	}

	private static MessageInfo resolveSQLException(SQLStateEnum sqlStateEnum, String errorMsg)
	{
		ParsedSQLException parsedSQLException = parseExceptionMessage(sqlStateEnum, errorMsg);
		if (parsedSQLException == null) /// if empty pattern
			return new MessageInfo(sqlStateEnum.getMessageCodes()[0]);

		if (parsedSQLException.getMessageCode() == null) /// if patterns doesn't match
			return null;

		return new MessageInfo(parsedSQLException.getMessageCode(), parsedSQLException.getParameters().toArray());
	}

	private static ParsedSQLException parseExceptionMessage(SQLStateEnum stateEnum, String errorMsg)
	{
		if (stateEnum.getPatterns() == null || stateEnum.getPatterns().length == 0)
			return null;

		List<String> parameterList = new ArrayList<>();
		for (int i=0; i<stateEnum.getPatterns().length; i++)
		{
			Pattern compiledPattern = Pattern.compile(stateEnum.getPatterns()[i], Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
			Matcher matcher = compiledPattern.matcher(errorMsg);
			while (matcher.find())
				for (int j=1; j<=matcher.groupCount(); j++)
					parameterList.add(matcher.group(j));

			if (parameterList.size() > 0)
			{
				return new ParsedSQLException(stateEnum.getMessageCodes()[i], parameterList);
			}
		}

		return new ParsedSQLException();
	}
}
