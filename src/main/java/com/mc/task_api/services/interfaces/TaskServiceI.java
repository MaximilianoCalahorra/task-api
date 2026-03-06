package com.mc.task_api.services.interfaces;

import java.util.List;

import com.mc.task_api.dtos.TaskCreateRequest;
import com.mc.task_api.dtos.TaskResponse;
import com.mc.task_api.dtos.TaskUpdateRequest;

public interface TaskServiceI {
	//Obtener todas las tareas:
	public List<TaskResponse> getAll();
	
	//Obtener tarea por id:
	public TaskResponse getById(Long id);
	
	//Crear tarea:
	public TaskResponse create(TaskCreateRequest request);
	
	//Modificar tarea:
	public TaskResponse update(Long id, TaskUpdateRequest request);
	
	//Eliminar tarea:
	public void delete(Long id);
	
	//Comenzar tarea:
	public TaskResponse startTask(Long id);
	
	//Completar tarea:
	public TaskResponse completeTask(Long id);
	
	//Cancelar tarea:
	public TaskResponse cancelTask(Long id);
}
