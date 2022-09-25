package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InvalidUserNameException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
}
