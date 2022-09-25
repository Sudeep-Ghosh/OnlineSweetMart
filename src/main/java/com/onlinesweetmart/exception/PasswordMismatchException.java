package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PasswordMismatchException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
}
