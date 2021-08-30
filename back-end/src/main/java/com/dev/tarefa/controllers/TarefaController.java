package com.dev.tarefa.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.tarefa.domain.dto.TarefaDTO;
import com.dev.tarefa.services.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService service;

	@PostMapping
	public ResponseEntity<TarefaDTO> save(@RequestBody TarefaDTO dto) {
		dto = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TarefaDTO> remove(@PathVariable Long id) {
		TarefaDTO dto = service.remove(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll() {
		List<TarefaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TarefaDTO> findById(@PathVariable Long id) {
		TarefaDTO dto = service.findById(id);
		return dto != null ? ResponseEntity.ok().body(dto) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/finished")
	public ResponseEntity<TarefaDTO> setTarefa(@PathVariable Long id) {
		TarefaDTO dto = service.setTarefa(id);
		return dto != null ? ResponseEntity.ok().body(dto) : ResponseEntity.notFound().build();
	}
}
