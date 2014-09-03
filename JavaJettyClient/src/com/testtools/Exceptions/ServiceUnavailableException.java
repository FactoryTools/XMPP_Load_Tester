package com.testtools.Exceptions;

public class ServiceUnavailableException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1593422251131300301L;

	public ServiceUnavailableException(String message)
	{
		super(message);
	}
}
