package com.accenture.codingtest.springbootcodingtest.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "title", length = 250, nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "project_id", nullable = false)
	private UUID projectId;

	@Column(name = "user_id", nullable = false)
	private UUID userId;

}
