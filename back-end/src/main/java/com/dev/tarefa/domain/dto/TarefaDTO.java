package com.dev.tarefa.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.dev.tarefa.domain.model.Tarefa;

public class TarefaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private boolean done;
	private LocalDateTime createdDate;
	private LocalDateTime doneDate;

	public TarefaDTO() {

	}

	public TarefaDTO(Long id, String description, boolean done, LocalDateTime createdDate, LocalDateTime doneDate) {
		this.id = id;
		this.description = description;
		this.done = done;
		this.createdDate = createdDate;
		this.doneDate = doneDate;
	}

	public TarefaDTO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.description = tarefa.getDescription();
		this.done = tarefa.isDone();
		this.createdDate = tarefa.getCreatedDate();
		this.doneDate = tarefa.getDoneDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(LocalDateTime doneDate) {
		this.doneDate = doneDate;
	}

}
