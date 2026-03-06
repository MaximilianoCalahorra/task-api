package com.mc.task_api.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Solicitud para modificar una tarea")
public record TaskUpdateRequest(
	@Schema(description = "Título de la tarea", example = "Estudiar geografía")
	@NotBlank
	@Size(min = 3, max = 100)
	String title,
	
	@Schema(description = "Descripción de la tarea")
	String description
) {}
