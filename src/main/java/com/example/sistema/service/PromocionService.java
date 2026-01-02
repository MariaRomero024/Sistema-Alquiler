package com.example.sistema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistema.entity.Promocion;
import com.example.sistema.repository.PromocionRepository;

@Service
public class PromocionService {

    private final PromocionRepository promocionRepository;

    public PromocionService(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    // Guardar un Promocion en la base de datos
    public Promocion guardarPromocion(Promocion promocion) {
        if(promocion.getIdPromocion() == null || promocion.getIdPromocion().trim().isEmpty()) {
            long nextNum = promocionRepository.count() + 1;
            String numId = "P" + String.format("%03d", nextNum);
            promocion.setIdPromocion(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + promocion.getIdPromocion());
        }
    return promocionRepository.save(promocion);
}

    // Obtener todos los Promocions
    public List<Promocion> obtenerTodos() {
        return promocionRepository.findAll();
    }
}
