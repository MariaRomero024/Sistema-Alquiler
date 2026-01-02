package com.example.sistema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistema.entity.Recurso;
import com.example.sistema.repository.RecursoRepository;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    // Guardar un recurso en la base de datos
    public Recurso guardarRecurso(Recurso recurso) {
        if(recurso.getIdRecurso() == null || recurso.getIdRecurso().trim().isEmpty()) {
            long nextNum = recursoRepository.count() + 1;
            String numId = "R" + String.format("%03d", nextNum);
            recurso.setIdRecurso(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + recurso.getIdRecurso());
        }
    return recursoRepository.save(recurso);
}

    // Obtener todos los recursos
    public List<Recurso> obtenerTodos() {
        return recursoRepository.findAll();
    }
}
