package com.tarefa.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@GetMapping
	public List<TarefaDTO>findAll(){
		return tarefaService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO dto){
		 dto = tarefaService.inserir(dto);
		 return ResponseEntity.ok(dto);
	}
}
