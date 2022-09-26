package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SweetItemNotFoundException extends RuntimeException {

	private String msg;
	
}
