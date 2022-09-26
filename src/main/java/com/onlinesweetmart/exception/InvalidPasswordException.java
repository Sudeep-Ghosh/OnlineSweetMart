package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidPasswordException extends RuntimeException{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;		
}
