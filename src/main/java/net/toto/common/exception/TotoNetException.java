package net.toto.common.exception;

import org.springframework.http.HttpStatus;

import net.toto.common.exception.Constants.ExceptionClass;


public class TotoNetException extends Exception{

	private static final long serialVersionUID = 3559343732120682032L;
	
	private Constants.ExceptionClass exceptionClass;
	private HttpStatus httpStatus;
	
	public TotoNetException(ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
		super(exceptionClass.toString() + message);
		this.exceptionClass = exceptionClass;
		this.httpStatus = httpStatus;
	}
	
	public Constants.ExceptionClass getExceptionClass(){
		return exceptionClass;
	}
	
	public int getHttpStausCode() {
		return httpStatus.value();
	}
	
	public String getHttpStatusType() {
		return httpStatus.getReasonPhrase();
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
