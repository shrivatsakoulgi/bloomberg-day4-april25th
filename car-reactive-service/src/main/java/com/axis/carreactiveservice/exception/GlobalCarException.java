package com.axis.carreactiveservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ControllerAdvice -> Global exception class, which handles all Exceptions
@ControllerAdvice
public class GlobalCarException {
	
	// Individual Exception handlers
	
	@ExceptionHandler(value = CarNotFoundException.class)
	public ResponseEntity<String> carNotFoundExceptionHandler(CarNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}
