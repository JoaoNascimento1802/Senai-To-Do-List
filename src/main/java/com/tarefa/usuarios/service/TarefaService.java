package com.tarefa.usuarios.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefa.usuarios.dto.TarefaDTO;
import com.tarefa.usuarios.entities.Prioridade;
import com.tarefa.usuarios.entities.StatusDaTarefa;
import com.tarefa.usuarios.entities.Tarefa;
import com.tarefa.usuarios.entities.Usuario;
import com.tarefa.usuarios.repositories.TarefaRepository;
import com.tarefa.usuarios.repositories.UsuarioRepository;

@Service  // Indica que esta classe é um serviço do Spring
public class TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	/**
	 * Método para inserir uma nova tarefa no banco de dados.
	 *  dto Objeto TarefaDTO contendo as informações da tarefa a ser criada.
	 * Um novo objeto TarefaDTO representando a tarefa salva.
	 */
	public TarefaDTO inserir(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		tarefa.setNomeSetor(dto.getNomeSetor());
		tarefa.setDescricaoTarefa(dto.getDescricaoTarefa());
		tarefa.setDataCadastro(LocalDate.now());
		tarefa.setStatus(StatusDaTarefa.A_FAZER);
		tarefa.setPrioridade(Prioridade.BAIXA);

		// Busca o usuário pelo ID fornecido no DTO e associa à tarefa
		Usuario user = usuarioRepository.getReferenceById(dto.getClienteid());
		tarefa.setCliente(user);

		// Salva a tarefa no banco de dados e retorna um DTO correspondente
		tarefa = tarefaRepository.save(tarefa);
		return new TarefaDTO(tarefa);
	}

	/**
	 * Método para buscar todas as tarefas cadastradas no banco de dados.
	 * @return Lista de objetos TarefaDTO representando todas as tarefas.
	 */
	public List<TarefaDTO> findAll() {

		List<Tarefa> lista = tarefaRepository.findAll();  // Busca todas as tarefas

		// Converte a lista de entidades Tarefa para DTOs e retorna
		return lista.stream().map(x -> new TarefaDTO(x)).toList();
	}
}
