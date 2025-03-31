package com.tarefa.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.usuarios.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
