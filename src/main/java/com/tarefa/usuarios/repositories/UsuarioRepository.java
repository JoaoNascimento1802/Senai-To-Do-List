package com.tarefa.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.usuarios.entities.Usuario;

/**
 * Interface de repositório para a entidade Tarefa.
 * Extende a interface JpaRepository, permitindo o uso de operações CRUD
 * básicas (salvar, buscar, excluir, etc.) para a entidade Tarefa.
 */
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

}
