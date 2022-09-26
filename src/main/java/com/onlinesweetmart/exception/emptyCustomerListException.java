package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class emptyCustomerListException extends Exception{
	private static final long serialVersionUID = 1L;
	String msg;
}
