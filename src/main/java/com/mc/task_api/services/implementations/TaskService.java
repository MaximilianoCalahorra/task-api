package com.mc.task_api.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.task_api.dtos.TaskCreateRequest;
import com.mc.task_api.dtos.TaskResponse;
import com.mc.task_api.dtos.TaskUpdateRequest;
import com.mc.task_api.exceptions.TaskNotFoundException;
import com.mc.task_api.mappers.interfaces.TaskMapperI;
import com.mc.task_api.model.Task;
import com.mc.task_api.repositories.TaskRepositoryI;
import com.mc.task_api.services.interfaces.TaskServiceI;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService implements TaskServiceI {
	//Atributos:
	private final TaskRepositoryI taskRepository;
	private final TaskMapperI taskMapper;
	
	//Obtener todas las tareas:
	@Override
	public List<TaskResponse> getAll() {
		return taskRepository.findAll()
				.stream()
				.map(taskMapper::toResponse)
				.toList();
	}
	
	
	//Obtener tarea por id:
	@Override
	public TaskResponse getById(Long id) {
		return taskRepository.findById(id)
				.map(taskMapper::toResponse)
				.orElseThrow(() -> new TaskNotFoundException(id));
	}
	
	//Crear tarea:
	@Override
	public TaskResponse create(TaskCreateRequest request) {
		Task task = taskMapper.toEntity(request);
		Task saved = taskRepository.save(task);
		return taskMapper.toResponse(saved);
	}
	
	//Modificar tarea:
	@Override
	public TaskResponse update(Long id, TaskUpdateRequest request) {
		Task task = taskRepository.findById(id)
						.orElseThrow(() -> new TaskNotFoundException(id));
		
		taskMapper.updateEntity(task, request);
		
		Task updated = taskRepository.save(task);
		
		return taskMapper.toResponse(updated);
	}
	
	//Eliminar tarea:
	@Override
	public void delete(Long id) {
		Task task = taskRepository.findById(id)
						.orElseThrow(() -> new TaskNotFoundException(id));
		
		taskRepository.delete(task);
	}
	
	//Comenzar tarea:
	@Override
	public TaskResponse startTask(Long id) {
		Task task = taskRepository.findById(id)
						.orElseThrow(() -> new TaskNotFoundException(id));
		
		task.start();
		
		Task saved = taskRepository.save(task);
		
		return taskMapper.toResponse(saved);
	}
	
	//Completar tarea:
	@Override
	public TaskResponse completeTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));

		task.complete();
		
		Task saved = taskRepository.save(task);
		
		return taskMapper.toResponse(saved);
	}
	
	//Cancelar tarea:
	@Override
	public TaskResponse cancelTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));

		task.cancel();
		
		Task saved = taskRepository.save(task);
		
		return taskMapper.toResponse(saved);
	}
}
