package ru.kirkazan.common.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * Date: 10.04.12
 * Time: 14:46
 */
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
