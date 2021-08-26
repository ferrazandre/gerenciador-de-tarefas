package com.dev.tarefa.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.tarefa.domain.dto.TarefaDTO;
import com.dev.tarefa.domain.model.Tarefa;
import com.dev.tarefa.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;

	@Transactional
	public TarefaDTO save(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa(null, dto.getDescription(), false, LocalDateTime.now(), null);
		tarefa = repository.save(tarefa);
		return new TarefaDTO(tarefa);
	}

	@Transactional(readOnly = true)
	public List<TarefaDTO> findAll() {
		List<Tarefa> list = repository.findAll();
		return list.stream().map(dto -> new TarefaDTO(dto)).collect(Collectors.toList());
	}

	@Transactional
	public TarefaDTO findById(Long id) {
		Optional<Tarefa> tarefaOpt = repository.findById(id);
		return new TarefaDTO(tarefaOpt.get());
	}

	@Transactional
	public TarefaDTO setTarefa(Long id) {
		Tarefa tarefa = repository.getById(id);
		tarefa.setDone(true);
		tarefa.setDoneDate(LocalDateTime.now());
		repository.save(tarefa);
		return new TarefaDTO(tarefa);
	}

	@Transactional
	public TarefaDTO remove(Long id) {
		Optional<Tarefa> t = repository.findById(id);
		if (t.isEmpty()) {
			throw new IllegalArgumentException("Tarefa inválida");
		}
		repository.delete(t.get());
		return new TarefaDTO(t.get());
	}
}
