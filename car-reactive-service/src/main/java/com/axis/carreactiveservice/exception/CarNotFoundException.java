package com.axis.carreactiveservice.exception;

public class CarNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -465320L;

	public CarNotFoundException() {
		super();		
	}

	public CarNotFoundException(String message) {
		super(message);
	}
	
}
