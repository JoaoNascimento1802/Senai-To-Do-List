package com.tarefa.usuarios.dto;

import java.util.ArrayList;
import java.util.List;

import com.tarefa.usuarios.entities.Usuario;

/**
 * DTO (Data Transfer Object) para representar um Usuário.
 * Facilita a transferência de dados entre camadas da aplicação.
 */
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;

	private List<TarefaDTO> tarefa = new ArrayList<>(); // Lista de tarefas associadas ao usuário

	/**
	 * Construtor padrão vazio.
	 */
	public UsuarioDTO() {
	}

	/**
	 * Construtor para inicializar o DTO com valores específicos.
	 *
	 * @param id     ID do usuário
	 * @param nome   Nome do usuário
	 * @param email  E-mail do usuário
	 * @param tarefa Lista de tarefas associadas ao usuário
	 */
	public UsuarioDTO(Long id, String nome, String email, List<TarefaDTO> tarefa) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tarefa = tarefa;
	}

	/**
	 * Construtor que recebe uma entidade Usuario e converte para DTO.
	 *
	 *  Objeto Usuario que será convertido em DTO.
	 */
	public UsuarioDTO(Usuario s) {
		this.id = s.getId();
		this.nome = s.getNome();
		this.email = s.getEmail();
	}

	// Métodos Getters e Setters

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
