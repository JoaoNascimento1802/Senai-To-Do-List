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

@Service
public class TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	// Método para inserir tarefa
	public TarefaDTO inserir(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		tarefa.setNomeSetor(dto.getNomeSetor());  // Adicionado
		tarefa.setDescricaoTarefa(dto.getDescricaoTarefa());  // Adicionado
		tarefa.setDataCadastro(LocalDate.now());
		tarefa.setStatus(StatusDaTarefa.A_FAZER);
		tarefa.setPrioridade(Prioridade.BAIXA);

		// Associa o usuário
		Usuario user = usuarioRepository.getReferenceById(dto.getClienteid());
		tarefa.setCliente(user);

		// Salva a tarefa no banco de dados
		tarefa = tarefaRepository.save(tarefa);
		return new TarefaDTO(tarefa);  // Retorna o DTO da tarefa salva
	}

	// Método para buscar todas as tarefas
	public List<TarefaDTO> findAll() {
		List<Tarefa> lista = tarefaRepository.findAll();

		return lista.stream().map(x -> new TarefaDTO(x)).toList();
	}
}
