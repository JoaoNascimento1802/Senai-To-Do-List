package com.tarefa.usuarios.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomeSetor;
	private String descricaoTarefa;
	private LocalDate dataCadastro;
	private Prioridade prioridade;
	private StatusDaTarefa status;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	public Tarefa() {
	}

	public Tarefa(Long id, String nomeSetor, String descricaoTarefa, LocalDate dataCadastro, Prioridade prioridade, StatusDaTarefa status) {
		this.id = id;
		this.nomeSetor = nomeSetor;
		this.descricaoTarefa = descricaoTarefa;
		this.dataCadastro = dataCadastro;
		this.prioridade = prioridade;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public StatusDaTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusDaTarefa status) {
		this.status = status;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
}
