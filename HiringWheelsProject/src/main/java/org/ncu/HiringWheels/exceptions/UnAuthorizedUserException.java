package org.ncu.HiringWheels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnAuthorizedUserException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public UnAuthorizedUserException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "UnAuthorizedUserException [message=" + message + "]";
	}
	
}
