package com.accenture.codingtest.springbootcodingtest.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.accenture.codingtest.springbootcodingtest.entity.Task;

public interface TaskRepository extends CrudRepository<Task, UUID> {

	List<Task> findByUserId(UUID userId);

}
