package ru.kirkazan.common.exception;

/**
 * Date: 10.04.12
 * Time: 14:43
 */
public interface ExceptionResolver<T extends Throwable>
{
	Class<T> getTargetClass();
	MessageInfo resolve(T throwable);
}
