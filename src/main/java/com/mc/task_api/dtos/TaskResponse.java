package com.mc.task_api.dtos;

import com.mc.task_api.model.TaskStatus;

public record TaskResponse(
	Long id,
	String title,
	String description,
	TaskStatus status
) {}
