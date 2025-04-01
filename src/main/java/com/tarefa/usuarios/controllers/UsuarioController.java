package com.tarefa.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.usuarios.dto.UsuarioDTO;
import com.tarefa.usuarios.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {


	@Autowired
	UsuarioService usuarioService;

	// Endpoint para listar usuarios
	@GetMapping

	public ResponseEntity<List<UsuarioDTO>> buscar(){
		return ResponseEntity.ok(usuarioService.buscarTodos());
	}

	// Endpoint para inserir um novo usuario
	@PostMapping

	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto){
		 dto = usuarioService.inserir(dto);
		 return ResponseEntity.ok(dto);
	}
	
	
}
