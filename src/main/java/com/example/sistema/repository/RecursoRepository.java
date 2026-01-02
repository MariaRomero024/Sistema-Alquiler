package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, String> {
    // JpaRepository te da acceso a todas las operaciones CRUD automáticamente.
}

