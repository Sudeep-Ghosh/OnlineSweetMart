package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmptyProductListException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
}
