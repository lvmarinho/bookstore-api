package com.leandro.bookstore.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leandro.bookstore.service.exeptions.DataIntegrityViolationException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(com.leandro.bookstore.service.exeptions.ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(
			com.leandro.bookstore.service.exeptions.ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e,
			ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

}
