package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.DetalleAlquiler;

public interface DetalleAlquilerRepository 
        extends JpaRepository<DetalleAlquiler, String> {
}