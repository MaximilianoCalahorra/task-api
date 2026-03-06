package com.mc.task_api.exceptions;

public class TaskNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TaskNotFoundException() {
	    super("Tarea no encontrada");
	}
	
	public TaskNotFoundException(Long id) {
		super("Tarea con el id " + id + " no encontrada");
	}
}
