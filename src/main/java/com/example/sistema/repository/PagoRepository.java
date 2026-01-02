package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, String> {
    // JpaRepository te da acceso a todas las operaciones CRUD automáticamente.
}

