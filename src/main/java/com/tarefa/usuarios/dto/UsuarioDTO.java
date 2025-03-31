package com.tarefa.usuarios.dto;

import java.util.ArrayList;
import java.util.List;

import com.tarefa.usuarios.entities.Usuario;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	
	private List<TarefaDTO> tarefa = new ArrayList<>();
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String nome, String email, List<TarefaDTO> tarefa) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public UsuarioDTO(Usuario s) {
		this.id = s.getId();
		this.nome = s.getNome();
		this.email = s.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TarefaDTO> getTarefa() {
		return tarefa;
	}

	public void setTarefa(List<TarefaDTO> tarefa) {
		this.tarefa = tarefa;
	}
	
	
	
}
