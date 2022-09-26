package com.onlinesweetmart.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorInfo {

	private String errorMessage;
	
	private String status;
	
	private LocalDateTime localDateTime;
}
