package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidCategoryDataException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
}
