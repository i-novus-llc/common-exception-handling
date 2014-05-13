package ru.kirkazan.common.exception;

/**
 * @author Rushan Makhmutov
 * @since 05.03.14
 */
public interface EntityExceptionResolver<T extends Throwable, E> extends ExceptionResolver<T>
{
	Class<E> getEntityClass();
}
