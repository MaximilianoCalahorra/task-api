package com.mc.task_api.repositories.interfaces;

import java.util.List;
import java.util.Optional;

import com.mc.task_api.model.Task;

public interface TaskRepositoryI {
	//Obtener todas las tareas:
	public List<Task> findAll();
	
	//Obtener tarea por id:
	public Optional<Task> findById(Long id);
	
	//Crear o modificar tarea:
	public Task save(Task task);
	
	//Eliminar tarea:
	public void delete(Task task);
}
