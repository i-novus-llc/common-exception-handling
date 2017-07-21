package ru.kirkazan.common.exception;

import org.springframework.stereotype.Component;

@Component
public class CodifiedExceptionResolver implements ExceptionResolver<CodifiedException>
{
	@Override
	public Class<CodifiedException> getTargetClass()
	{
		return CodifiedException.class;
	}

	@Override
	public MessageInfo resolve(CodifiedException throwable)
	{
		return new MessageInfo(throwable.getCode(), throwable.getArgs());
	}
}
