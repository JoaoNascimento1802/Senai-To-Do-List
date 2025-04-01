package com.tarefa.usuarios.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "cliente")
	private Set<Tarefa> items = new HashSet<>();

	public Usuario() {
	}

	public Usuario(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
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
}
