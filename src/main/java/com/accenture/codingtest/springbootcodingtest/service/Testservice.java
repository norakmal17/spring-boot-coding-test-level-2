package com.accenture.codingtest.springbootcodingtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.codingtest.springbootcodingtest.entity.Project;
import com.accenture.codingtest.springbootcodingtest.entity.Task;
import com.accenture.codingtest.springbootcodingtest.entity.User;
import com.accenture.codingtest.springbootcodingtest.repository.ProjectRepository;
import com.accenture.codingtest.springbootcodingtest.repository.TaskRepository;
import com.accenture.codingtest.springbootcodingtest.repository.UserRepository;

@Service
public class Testservice {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	TaskRepository taskRepository;

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}

	public User getUserById(UUID id) {
		return userRepository.findById(id).get();
	}

	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	public void updateById(User user, UUID id) {
		Optional<User> userRes = userRepository.findById(id);
		if (userRes.isPresent()) {
			userRes.get().setPassword(user.getPassword());
			userRes.get().setUserName(user.getUserName());
			userRepository.save(userRes.get());
		}

	}

	public void delete(UUID id) {
		userRepository.deleteById(id);
	}

	public List<Project> getProjects() {
		List<Project> projects = new ArrayList<Project>();
		projectRepository.findAll().forEach(project -> projects.add(project));
		return projects;
	}

	public void saveOrUpdate(Project project) {
		projectRepository.save(project);
	}

	public void updateById(Project project, UUID id) {
		Optional<Project> projectRes = projectRepository.findById(id);
		if (projectRes.isPresent()) {
			projectRes.get().setName(project.getName());
			projectRepository.save(projectRes.get());
		}
	}

	public Project getProjectById(UUID id) {
		return projectRepository.findById(id).get();
	}

	public void deleteProject(UUID id) {
		projectRepository.deleteById(id);
	}

	public List<Task> getTasks() {
		List<Task> tasks = new ArrayList<Task>();
		taskRepository.findAll().forEach(task -> tasks.add(task));
		return tasks;
	}

	public List<Task> getTasksByUserId(UUID userId) {
		List<Task> taskRes = taskRepository.findByUserId(userId);
		List<Task> tasks = new ArrayList<Task>();
		if (!taskRes.isEmpty()) {
			taskRes.forEach(task -> tasks.add(task));
		}
		return tasks;
	}

	public void saveOrUpdate(Task task) {
		taskRepository.save(task);
	}

	public void updateById(Task task, UUID id) {
		Optional<Task> taskRes = taskRepository.findById(id);
		if (taskRes.isPresent()) {
			taskRes.get().setStatus(task.getStatus());
			taskRes.get().setDescription(task.getDescription());
			taskRes.get().setTitle(task.getTitle());
			taskRes.get().setProjectId(task.getProjectId());
			taskRes.get().setUserId(task.getUserId());
			taskRepository.save(taskRes.get());
		}
	}

	public void updateById(Task task, UUID id, UUID userId) {
		Optional<Task> taskRes = taskRepository.findById(id);
		if (taskRes.isPresent()) {
			if (taskRes.get().getUserId() == userId) {
				taskRes.get().setStatus(task.getStatus());
				taskRepository.save(taskRes.get());
			}
		}
	}

	public Task getTaskById(UUID id) {
		return taskRepository.findById(id).get();
	}

	public void deleteTask(UUID id) {
		taskRepository.deleteById(id);
	}

}
