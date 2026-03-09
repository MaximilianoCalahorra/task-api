package com.mc.task_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mc.task_api.model.Task;

@Repository
public interface TaskRepositoryI extends JpaRepository<Task, Long> {}
