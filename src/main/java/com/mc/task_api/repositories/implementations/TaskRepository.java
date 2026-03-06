package com.mc.task_api.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mc.task_api.model.Task;
import com.mc.task_api.repositories.interfaces.TaskRepositoryI;

@Repository
public class TaskRepository implements TaskRepositoryI {
	//Atributos:
	private final Map<Long, Task> tasks = new HashMap<>();
	private Long currentId = 1L;
	
	//Obtener todas las tareas:
	@Override
	public List<Task> findAll() {
		return new ArrayList<>(tasks.values());
	}
	
	//Obtener tarea por id:
	@Override
	public Optional<Task> findById(Long id) {
		return Optional.ofNullable(tasks.get(id));
	}
	
	//Crear o modificar tarea:
	@Override
	public Task save(Task task) {
		if (task.getId() == null) {
			task.setId(currentId++);
		}
		tasks.put(task.getId(), task);
		return task;
	}
	
	//Eliminar tarea:
	@Override
	public void delete(Task task) {
		tasks.remove(task.getId());
	}
}
