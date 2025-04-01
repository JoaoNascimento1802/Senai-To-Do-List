package com.tarefa.usuarios.dto;

import java.time.LocalDate;

import com.tarefa.usuarios.entities.Prioridade;
import com.tarefa.usuarios.entities.StatusDaTarefa;
import com.tarefa.usuarios.entities.Tarefa;

/**
 * DTO (Data Transfer Object) para representar uma Tarefa.
 * Facilita a transferência de dados entre camadas da aplicação.
 */
public class TarefaDTO {

	private Long id;
	private String nomeSetor;
	private String descricaoTarefa;
	private LocalDate dataCadastro;
	private Prioridade prioridade;
	private StatusDaTarefa status;
	private Long clienteid; // ID do cliente associado à tarefa

	/**
	 * Construtor padrão sem parâmetros.
	 */
	public TarefaDTO() {
	}

	/**
	 * Construtor para inicializar um objeto TarefaDTO com valores específicos.
	 *
	 * @param id              ID da tarefa
	 * @param nomeSetor       Nome do setor responsável pela tarefa
	 * @param descricaoTarefa Descrição da tarefa
	 * @param dataCadastro    Data de cadastro da tarefa
	 * @param prioridade      Prioridade da tarefa (BAIXA, MÉDIA, ALTA)
	 * @param status          Status da tarefa (A_FAZER, FAZENDO, PRONTO)
	 * @param clienteid       ID do cliente associado à tarefa
	 */
	public TarefaDTO(Long id, String nomeSetor, String descricaoTarefa, LocalDate dataCadastro, Prioridade prioridade,
					 StatusDaTarefa status, Long clienteid) {
		this.id = id;
		this.nomeSetor = nomeSetor;
		this.descricaoTarefa = descricaoTarefa;
		this.dataCadastro = dataCadastro;
		this.prioridade = prioridade;
		this.status = status;
		this.clienteid = clienteid;
	}

	/**
	 * Construtor que recebe uma entidade Tarefa e converte para DTO.
	 *
	 * @param t Objeto Tarefa que será convertido em DTO.
	 */
	public TarefaDTO(Tarefa t) {
		this.id = t.getId();
		this.nomeSetor = t.getNomeSetor();
		this.descricaoTarefa = t.getDescricaoTarefa();
		this.dataCadastro = t.getDataCadastro();
		this.prioridade = t.getPrioridade();
		this.status = t.getStatus();
		this.clienteid = t.getCliente().getId();
	}

	// Métodos Getters e Setters

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

	public Long getClienteid() {
		return clienteid;
	}

	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}
}
