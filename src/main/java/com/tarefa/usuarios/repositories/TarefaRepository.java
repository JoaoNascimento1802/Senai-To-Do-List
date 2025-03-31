package com.tarefa.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.usuarios.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
