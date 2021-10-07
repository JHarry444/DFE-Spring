package com.qa.dfe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No marsupial found with that id")
public class MarsupialNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 342493152181432543L;

	public MarsupialNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarsupialNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MarsupialNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MarsupialNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MarsupialNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
