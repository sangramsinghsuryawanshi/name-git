package com.student.application.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.student.application.globalexception.entity.ErrorResponse;
import com.student.application.globalexception.entity.StudentNotFoundException;

@RestControllerAdvice
public class GlobalException {
	private ErrorResponse errorResponse;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> globalException(Exception exception) {
		errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong",
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> studentNotFoundException(StudentNotFoundException studentNotFoundException) {
		errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Student not found",
				studentNotFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorResponse);
	}

}
