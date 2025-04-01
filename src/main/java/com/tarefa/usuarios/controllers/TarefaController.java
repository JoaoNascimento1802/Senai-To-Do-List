package com.tarefa.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.usuarios.dto.TarefaDTO;
import com.tarefa.usuarios.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;

	// Endpoint para listar todas as tarefas
	@GetMapping

	public List<TarefaDTO> findAll() {
		return tarefaService.findAll();
	}

	// Endpoint para inserir uma nova tarefa
	@PostMapping

	public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO dto) {
		dto = tarefaService.inserir(dto);  // Chama o serviço para inserir a tarefa
		return ResponseEntity.ok(dto);  // Retorna a resposta com a tarefa criada
	}
}
