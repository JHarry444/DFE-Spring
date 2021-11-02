package com.qa.dfe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No habitat found with that id")
public class HabitatNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7130901884657916297L;

	public HabitatNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HabitatNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HabitatNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HabitatNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HabitatNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
