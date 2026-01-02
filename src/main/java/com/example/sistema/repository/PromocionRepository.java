package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, String> {
    // JpaRepository te da acceso a todas las operaciones CRUD automáticamente.
}

