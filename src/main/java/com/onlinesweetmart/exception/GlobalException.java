package com.onlinesweetmart.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorInfo> sweetItemNotFoundException(SweetItemNotFoundException exception){
		
		ErrorInfo errorInfo =  new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> customException(CustomException exception){
		
		ErrorInfo errorInfo =  new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
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
	
	@ExceptionHandler(EmptyProductListException.class)
	public ResponseEntity<ErrorInfo> emptyProductListException(EmptyProductListException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyCategoryListException.class)
	public ResponseEntity<ErrorInfo> emptyCategoryListException(EmptyCategoryListException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCategoryDataException.class)
	public ResponseEntity<ErrorInfo> invalidCategoryDataException(InvalidCategoryDataException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserNameException.class)
	public ResponseEntity<ErrorInfo> invalidUserNameException(InvalidUserNameException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorInfo> invalidPasswordException(InvalidPasswordException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<ErrorInfo> passwordMismatchException(PasswordMismatchException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyCustomerListException.class)
	public ResponseEntity<ErrorInfo> emptyCustomerListException(EmptyCustomerListException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyUserListException.class)
	public ResponseEntity<ErrorInfo> emptyUserListException(EmptyUserListException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> userAlreadyExistsException(UserAlreadyExistsException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	
}
