package com.tarefa.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tarefa.usuarios.dto.UsuarioDTO;
import com.tarefa.usuarios.entities.Usuario;
import com.tarefa.usuarios.repositories.TarefaRepository;
import com.tarefa.usuarios.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	/**
	 * Método para buscar todos os usuários do banco de dados.
	 * Lista de objetos UsuarioDTO representando todos os usuários.
	 */
	public List<UsuarioDTO> buscarTodos() {
		List<Usuario> list = usuarioRepository.findAll(); // Busca todos os usuários no banco
		return list.stream().map(x -> new UsuarioDTO(x)).toList(); // Converte a lista de entidades para DTOs
	}

	/**
	 * Método para buscar usuários paginados.
	 *  pagina Objeto Pageable contendo as informações de paginação.
	 *  Página de objetos UsuarioDTO.
	 */
	public Page<UsuarioDTO> findPagina(Pageable pagina) {
		Page<Usuario> busca = usuarioRepository.findAll(pagina); // Busca os usuários paginados
		return busca.map(x -> new UsuarioDTO(x)); // Converte as entidades para DTOs antes de retornar
	}

	/**
	 * Método para inserir um novo usuário no banco de dados.
	 *  UsuarioDTO contendo as informações do usuário a ser cadastrado.
	 *  Um novo objeto UsuarioDTO representando o usuário salvo.
	 */
	@Transactional // Garante que a operação ocorra dentro de uma transação
	public UsuarioDTO inserir(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity = usuarioRepository.save(entity); // Salva o usuário no banco de dados
		return new UsuarioDTO(entity); // Retorna um DTO do usuário salvo
	}
}
