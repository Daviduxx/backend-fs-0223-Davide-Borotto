package com.epicode.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> notFoundException(EntityNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//può esserci anche una eccezione di tipo exists. questo perché ad esempio ci possono essere dei
	// dati che deveno essere unique, come ad esempio l'email.
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> existsException(EntityExistsException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
	}

}
