package com.dev.tarefa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.tarefa.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
}
