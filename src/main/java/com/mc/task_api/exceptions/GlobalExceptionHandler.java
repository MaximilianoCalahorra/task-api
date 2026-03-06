package com.mc.task_api.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//Tarea no encontrada:
	@ExceptionHandler(TaskNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> handlerNotFound(TaskNotFoundException ex) {
		return Map.of("error", ex.getMessage());
	}
	
	//Estado inválido:
	@ExceptionHandler(InvalidTaskStateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handlerInvalidState(InvalidTaskStateException ex) {
		return Map.of("error", ex.getMessage());
	}
	
	//Argumento inválido:
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handlerInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return errors;
	}
}
