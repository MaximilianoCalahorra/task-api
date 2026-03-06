package com.mc.task_api.mappers.implementations;

import org.springframework.stereotype.Component;

import com.mc.task_api.dtos.TaskCreateRequest;
import com.mc.task_api.dtos.TaskResponse;
import com.mc.task_api.dtos.TaskUpdateRequest;
import com.mc.task_api.mappers.interfaces.TaskMapperI;
import com.mc.task_api.model.Task;

@Component
public class TaskMapper implements TaskMapperI {
	//Solicitud de nueva tarea a entidad:
	@Override
	public Task toEntity(TaskCreateRequest request) {
		return new Task(request.title(), request.description());
	}
	
	//Entidad a respuesta:
	@Override
	public TaskResponse toResponse(Task task) {
		return new TaskResponse(
				task.getId(),
				task.getTitle(),
				task.getDescription(),
				task.getStatus());
	}
	
	//Modificar entidad:
	@Override
	public void updateEntity(Task task, TaskUpdateRequest request) {
		task.setTitle(request.title());
		task.setDescription(request.description());
	}
}
