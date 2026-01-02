package com.example.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema.entity.Alquiler;
import com.example.sistema.repository.AlquilerRepository;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    // LISTAR TODOS LOS ALQUILERES
    public List<Alquiler> obtenerTodos() {
        return alquilerRepository.findAll();
    }

    // GUARDAR ALQUILER
    public Alquiler guardarAlquiler(Alquiler alquiler) {
     if(alquiler.getIdAlquiler() == null || alquiler.getIdAlquiler().trim().isEmpty()) {
          long nextNum = AlquilerRepository.count() + 1;
          String numId = "A" + String.format("%03d", nextNum);
          alquiler.setIdAlquiler(numId);
          System.out.println("ID GENERADO EXITOSAMENTE: " + alquiler.getIdAlquiler());
     }
        return alquilerRepository.save(alquiler);
    }
}
