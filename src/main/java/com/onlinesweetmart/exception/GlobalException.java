package com.onlinesweetmart.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> idNotfoundException(IdNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorInfo> productNotfoundException(ProductNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}

}