package ru.i_novus.components.common.exception;

public interface ExceptionResolver<T extends Throwable>
{
	Class<T> getTargetClass();
	MessageInfo resolve(T throwable);
}
