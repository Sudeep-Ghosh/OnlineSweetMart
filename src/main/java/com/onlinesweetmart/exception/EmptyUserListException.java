package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
public class EmptyUserListException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	String msg;
}
