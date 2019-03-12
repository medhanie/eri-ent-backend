package io.medhanie.erient.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ApplicationException(String message, ErrorLevel level, ErrorType type) {
		super(message);
	}

}
