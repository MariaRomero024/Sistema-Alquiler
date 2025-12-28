package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Turista;

public interface TuristaRepository extends JpaRepository<Turista, String> {
    // JpaRepository te da acceso a todas las operaciones CRUD automáticamente.
}

