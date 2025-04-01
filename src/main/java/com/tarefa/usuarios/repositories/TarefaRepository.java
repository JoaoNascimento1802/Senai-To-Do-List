package com.tarefa.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tarefa.usuarios.entities.Tarefa;

/**
 * Interface de repositório para a entidade Tarefa.
 * Extende a interface JpaRepository, permitindo o uso de operações CRUD
 * básicas (salvar, buscar, excluir, etc.) para a entidade Tarefa.
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
