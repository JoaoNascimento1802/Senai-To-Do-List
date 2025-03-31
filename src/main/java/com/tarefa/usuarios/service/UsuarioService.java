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
	
	public List<UsuarioDTO> buscarTodos(){
		List<Usuario> list = usuarioRepository.findAll();
		return list.stream().map(x -> new UsuarioDTO(x)).toList();
	}
	
	public Page<UsuarioDTO> findPagina(Pageable pagina){
		Page<Usuario> busca = usuarioRepository.findAll(pagina);
		return busca.map(x -> new UsuarioDTO(x));
	}
	
	@Transactional
	public UsuarioDTO inserir(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity = usuarioRepository.save(entity);
		return new UsuarioDTO(entity);
	}
}
