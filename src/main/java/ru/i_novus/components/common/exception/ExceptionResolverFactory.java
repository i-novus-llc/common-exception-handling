package ru.i_novus.components.common.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ExceptionResolverFactory
{
    @Autowired(required = false)
	private Collection<ExceptionResolver> exceptionResolvers;

    public String resolve(Throwable throwable)
    {
        return resolveMessageInfo(throwable).getCode();
    }

	public MessageInfo resolveMessageInfo(Throwable throwable)
	{
        if (exceptionResolvers == null)
            return null;

		ExceptionResolver exceptionResolverForClass = null;
		for (ExceptionResolver exceptionResolver : exceptionResolvers)
		{
			if (!exceptionResolver.getTargetClass().isAssignableFrom(throwable.getClass()))
				continue;
			if (exceptionResolverForClass == null ||
					exceptionResolverForClass.getTargetClass().isAssignableFrom(exceptionResolver.getTargetClass()))
				exceptionResolverForClass = exceptionResolver;
		}
		//noinspection unchecked
		return exceptionResolverForClass == null ? null : exceptionResolverForClass.resolve(throwable);
	}
}
