package com.mc.task_api.model;

import com.mc.task_api.exceptions.InvalidTaskStateException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Task {
	//Atributos:
	private Long id;
	private String title;
	private String description;
	private TaskStatus status;
	
	//Constructor:
	public Task(String title, String description) {
		this.title = title;
		this.description = description;
		this.status = TaskStatus.PENDING;
	}
	
	//Comenzar tarea:
	public void start() {
		if (this.status != TaskStatus.PENDING) {
			throw new InvalidTaskStateException("La tarea solo puede comenzar si está pendiente");
		}
		this.status = TaskStatus.IN_PROGRESS;
	}
	
	//Finalizar tarea:
	public void complete() {
		if (this.status != TaskStatus.IN_PROGRESS) {
			throw new InvalidTaskStateException("La tarea debe estar en progreso para ser completada");
		}
		this.status = TaskStatus.COMPLETED;
	}
	
	//Cancelar tarea:
	public void cancel() {
		if (this.status == TaskStatus.COMPLETED) {
			throw new InvalidTaskStateException("Una tarea completada no puede ser cancelada");
		}
		this.status = TaskStatus.CANCELLED;
	}
}
