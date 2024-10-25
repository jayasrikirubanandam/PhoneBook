package com.net.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContactException {

	@ExceptionHandler(ContactNotFound.class)
	public ResponseEntity<ErrorDetails> ContactSpecificException(ContactNotFound e){
		ErrorDetails error = new ErrorDetails("405", e.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleExceptionGlobally(Exception e){
		ErrorDetails error = new ErrorDetails("404", e.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
