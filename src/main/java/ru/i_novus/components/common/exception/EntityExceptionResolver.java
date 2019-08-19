package ru.i_novus.components.common.exception;

public interface EntityExceptionResolver<T extends Throwable, E> extends ExceptionResolver<T>
{
	Class<E> getEntityClass();
}
