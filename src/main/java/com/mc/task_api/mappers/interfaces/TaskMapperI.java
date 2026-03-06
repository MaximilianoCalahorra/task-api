package com.mc.task_api.mappers.interfaces;

import com.mc.task_api.dtos.TaskCreateRequest;
import com.mc.task_api.dtos.TaskResponse;
import com.mc.task_api.dtos.TaskUpdateRequest;
import com.mc.task_api.model.Task;

public interface TaskMapperI {
	//Solicitud de nueva tarea a entidad:
	public Task toEntity(TaskCreateRequest request);
	
	//Entidad a respuesta:
	public TaskResponse toResponse(Task task);
	
	//Modificar entidad:
	public void updateEntity(Task task, TaskUpdateRequest request);
}
