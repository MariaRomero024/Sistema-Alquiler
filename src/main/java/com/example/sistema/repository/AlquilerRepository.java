package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, String> {
    // JpaRepository te da acceso a todas las operaciones CRUD automáticamente.
}

