package com.example.flights.exception;

public class DataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String exceptionMsg;

	public DataException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
