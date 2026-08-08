package com.student.application.globalexception.entity;

import java.time.LocalDateTime;

public class ErrorResponse {
	private LocalDateTime dateTime;
	private int staus;
	private String error;
	private String message;

	public ErrorResponse(int staus, String error, String message) {
		super();
		this.dateTime = LocalDateTime.now();
		this.staus = staus;
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public int getStaus() {
		return staus;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

}
