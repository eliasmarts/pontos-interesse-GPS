package com.desafio.pontosgps.services.exceptions;

public class IllegalValueException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public IllegalValueException(String msg) {
		super(msg);
	}
}
