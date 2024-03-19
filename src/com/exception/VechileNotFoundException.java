package com.exception;

public class VechileNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;
	
	public VechileNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
