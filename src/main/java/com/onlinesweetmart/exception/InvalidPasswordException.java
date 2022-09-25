package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InvalidPasswordException extends RuntimeException{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
}
