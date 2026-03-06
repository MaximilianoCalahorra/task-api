package com.mc.task_api.exceptions;

public class InvalidTaskStateException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidTaskStateException() {
	    super("Transición inválida de estado de la tarea");
	}
	
	public InvalidTaskStateException(String message) {
		super(message);
	}
}
