package com.mc.task_api.model;

import com.mc.task_api.exceptions.InvalidTaskStateException;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
	//Atributos:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
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
