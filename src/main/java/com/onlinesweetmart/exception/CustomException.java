package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CustomException extends RuntimeException {

	private String msg;
}
