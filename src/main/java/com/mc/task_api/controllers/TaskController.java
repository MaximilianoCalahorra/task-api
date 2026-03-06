package com.mc.task_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mc.task_api.dtos.TaskCreateRequest;
import com.mc.task_api.dtos.TaskResponse;
import com.mc.task_api.dtos.TaskUpdateRequest;
import com.mc.task_api.services.interfaces.TaskServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Tag(name = "Tareas", description = "Endpoints de gestión de tareas")
@RestController
@RequestMapping("/tasks")
public class TaskController {
	//Atributo:
	private final TaskServiceI taskService;
	
	//Obtener todas las tareas:
	@Operation(summary = "Obtener todas las tareas")
	@ApiResponse(responseCode = "200", description = "Tareas obtenidas")
	@GetMapping
	public List<TaskResponse> getAll() {
		return taskService.getAll();
	}
	
	//Obtener tarea por id:
	@Operation(summary = "Obtener tarea por su id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarea obtenida"),
			@ApiResponse(responseCode = "404", description = "Tarea inexistente")
	})
	@GetMapping("/{id}")
	public TaskResponse getById(@PathVariable Long id) {
		return taskService.getById(id);
	}
	
	//Crear tarea:
	@Operation(summary = "Crear tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Tarea creada"),
			@ApiResponse(responseCode = "400", description = "Argumento/s inválido/s")
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TaskResponse create(@Valid @RequestBody TaskCreateRequest request) {
		return taskService.create(request);
	}
	
	//Modificar tarea:
	@Operation(summary = "Modificar tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarea modificada"),
			@ApiResponse(responseCode = "400", description = "Argumento/s inválido/s"),
			@ApiResponse(responseCode = "404", description = "Tarea inexistente"),
	})
	@PutMapping("/{id}")
	public TaskResponse update(@PathVariable Long id, @Valid @RequestBody TaskUpdateRequest request) {
		return taskService.update(id, request);
	}
	
	//Eliminar tarea:
	@Operation(summary = "Eliminar tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Tarea eliminada"),
			@ApiResponse(responseCode = "404", description = "Tarea inexistente")
	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		taskService.delete(id);
	}
	
	//Comenzar tarea:
	@Operation(summary = "Comenzar tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarea comenzada"),
			@ApiResponse(responseCode = "400", description = "Transición de estado inválida"),
			@ApiResponse(responseCode = "404", description = "Tarea inexistente")
	})
	@PostMapping("/{id}/start")
	public TaskResponse start(@PathVariable Long id) {
		return taskService.startTask(id);
	}
	
	//Completar tarea:
	@Operation(summary = "Completar tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarea completada"),
			@ApiResponse(responseCode = "400", description = "Transición de estado inválida"),
			@ApiResponse(responseCode = "404", description = "Tarea inexistente")
	})
	@PostMapping("/{id}/complete")
	public TaskResponse complete(@PathVariable Long id) {
		return taskService.completeTask(id);
	}
	
	//Cancelar tarea:
	@Operation(summary = "Cancelar tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarea cancelada"),
			@ApiResponse(responseCode = "400", description = "Transición de estado inválida"),
			@ApiResponse(responseCode = "404", description = "Tarea inexistente")
	})
	@PostMapping("/{id}/cancel")
	public TaskResponse cancel(@PathVariable Long id) {
		return taskService.cancelTask(id);
	}
}
