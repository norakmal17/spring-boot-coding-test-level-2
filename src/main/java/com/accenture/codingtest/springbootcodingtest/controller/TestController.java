package com.accenture.codingtest.springbootcodingtest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.codingtest.springbootcodingtest.common.enums.Role;
import com.accenture.codingtest.springbootcodingtest.entity.Project;
import com.accenture.codingtest.springbootcodingtest.entity.Task;
import com.accenture.codingtest.springbootcodingtest.entity.User;
import com.accenture.codingtest.springbootcodingtest.service.Testservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class TestController {

	private final Testservice testService;

	@GetMapping("/users/{role}")
	private List<User> getUsers(@PathVariable("role") String role) {
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			return testService.getUsers();
		}
		else {
			return null;
		}
	}

	@PostMapping("/users/{role}")
	private UUID saveUser(@RequestBody User user, @PathVariable("role") String role) {
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			testService.saveOrUpdate(user);
			return user.getId();
		}
		else {
			return null;
		}
	}

	@PutMapping("/users/{id}/{role}")
	private UUID updateUser(@RequestBody User user, @PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			testService.updateById(user, id);
			return user.getId();
		}
		else {
			return null;
		}
	}

	@PatchMapping("/users/{id}/{role}")
	private UUID patchUser(@RequestBody User user, @PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			testService.updateById(user, id);
			return user.getId();
		}
		else {
			return null;
		}
	}

	@GetMapping("/user/{id}/{role}")
	private User getUserById(@PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			return testService.getUserById(id);
		}
		else {
			return null;
		}
	}

	@DeleteMapping("/user/{id}/{role}")
	private void deleteUser(@PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			testService.delete(id);
		}
	}

	@GetMapping("/projects/{role}")
	private List<Project> getProjects(@PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			return testService.getProjects();
		}
		else {
			return null;
		}

	}

	@PostMapping("/projects/{role}")
	private UUID saveProject(@RequestBody Project project, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.saveOrUpdate(project);
			return project.getId();
		}
		else {
			return null;
		}
	}

	@PutMapping("/projects/{id}/{role}")
	private UUID updateUser(@RequestBody Project project, @PathVariable("id") UUID id,
			@PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.updateById(project, id);
			return project.getId();
		}
		else {
			return null;
		}
	}

	@PatchMapping("/projects/{id}/{role}")
	private UUID patchUser(@RequestBody Project project, @PathVariable("id") UUID id,
			@PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.updateById(project, id);
			return project.getId();
		}
		else {
			return null;
		}
	}

	@GetMapping("/project/{id}/{role}")
	private Project getProjectById(@PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			return testService.getProjectById(id);
		}
		else {
			return null;
		}

	}

	@DeleteMapping("/project/{id}/{role}")
	private void deleteProject(@PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.delete(id);
		}
	}

	@GetMapping("/tasks/{role}")
	private List<Task> getTasks(@PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			return testService.getTasks();
		}
		else {
			return null;
		}
	}

	@GetMapping("/tasks/{role}/{userId}")
	private List<Task> getTasksByUserId(@PathVariable("role") String role, @PathVariable("userId") UUID userId) {
		return testService.getTasksByUserId(userId);
	}

	@PostMapping("/tasks/{role}")
	private UUID saveTask(@RequestBody Task task, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.saveOrUpdate(task);
			return task.getId();
		}
		else {
			return null;
		}
	}

	@PutMapping("/tasks/{id}/{role}")
	private UUID updateTask(@RequestBody Task task, @PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.updateById(task, id);
			return task.getId();
		}
		else {
			return null;
		}
	}

	@PatchMapping("/tasks/{id}/{role}/{userId}")
	private UUID patchTask(@RequestBody Task task, @PathVariable("id") UUID id, @PathVariable("role") String role,
			@PathVariable("userId") UUID userId) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.updateById(task, id);
			return task.getId();
		}
		else {
			testService.updateById(task, id, userId);
			return task.getId();
		}
	}

	@GetMapping("/task/{id}/{role}")
	private Task getTaskById(@PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			return testService.getTaskById(id);
		}
		else {
			return null;
		}

	}

	@DeleteMapping("/task/{id}/{role}")
	private void deleteTask(@PathVariable("id") UUID id, @PathVariable("role") String role) {
		if (Role.PRODUCT_OWNER.name().equalsIgnoreCase(role)) {
			testService.delete(id);
		}
	}

}
