package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // JpaRepository te da acceso a todas las operaciones CRUD automáticamente.
}

