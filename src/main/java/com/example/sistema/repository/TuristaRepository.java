package com.example.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entity.Turista;

public interface TuristaRepository extends JpaRepository<Turista, String> {
     Optional<Turista> findByDniPasaporte(String dniPasaporte);
}

