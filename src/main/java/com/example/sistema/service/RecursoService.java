package com.example.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema.entity.Recurso;
import com.example.sistema.repository.RecursoRepository;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> obtenerPorAlquiler(String idAlquiler) {
        return recursoRepository.findAll()
                .stream()
                .filter(d -> d.getIdAlquiler().equals(idAlquiler))
                .toList();
    }

    public Recurso guardar(Recurso recurso) {
          if(recurso.getIdRecurso() == null || recurso.getIdRecurso().trim().isEmpty()) {
            long nextNum = RecursoRepository.count() + 1;
            String numId = "DA" + String.format("%03d", nextNum);
            recurso.setIdRecurso(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + recurso.getIdRecurso());
        }
        return RecursoRepository.save(recurso);
    }
}
