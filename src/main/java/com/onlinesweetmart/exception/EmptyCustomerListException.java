package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmptyCustomerListException extends Exception{
	private static final long serialVersionUID = 1L;
	String msg;
}
