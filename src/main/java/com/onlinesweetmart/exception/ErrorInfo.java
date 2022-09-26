package com.onlinesweetmart.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorInfo {

	private String errorMessage;
	
	private String status;
	
	private LocalDateTime localDateTime;
}
