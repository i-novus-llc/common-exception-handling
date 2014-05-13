package ru.kirkazan.common.exception;

/**
 * @author Rushan Makhmutov
 * @since 06.05.14
 */
public class ServerExceptionInfo
{
	private String message;
	private String stackTrace;

	public ServerExceptionInfo(String message, Throwable throwable)
	{
		this.message = message;
		this.stackTrace = buildStackTrace(throwable);
	}

	public static String buildStackTrace(Throwable throwable)
	{
		StringBuilder stackTraceBuilder = new StringBuilder();
		while (throwable != null)
		{
			stackTraceBuilder.append(throwable).append("\n");
			for (StackTraceElement stackTraceElement : throwable.getStackTrace())
			{
				String className = stackTraceElement.getClassName();
				if (className == null)
					continue;
				if (!className.startsWith("ru.kirkazan"))
					continue;
				if (stackTraceElement.getFileName() == null)
					continue;
				if (stackTraceElement.getFileName().equals("<generated>"))
					continue;
				stackTraceBuilder.append("\t").append(stackTraceElement).append("\n");
			}
			throwable = throwable.getCause();
		}
		return stackTraceBuilder.toString();
	}

	public String getMessage()
	{
		return message;
	}

	public String getStackTrace()
	{
		return stackTrace;
	}
}
