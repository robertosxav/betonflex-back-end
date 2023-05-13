package com.betonflex.exceptions;

public class BetonflexException extends RuntimeException{

	private static final long serialVersionUID = -409889946864421783L;

	public BetonflexException(String message, Throwable cause) {
		super(message, cause);
	}

	public BetonflexException(String message) {
		super(message);
	}
	
}
