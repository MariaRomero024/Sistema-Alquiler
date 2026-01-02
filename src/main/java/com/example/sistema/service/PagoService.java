package com.example.sistema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistema.entity.Pago;
import com.example.sistema.repository.PagoRepository;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    // Guardar un Pago en la base de datos
    public Pago guardarPago(Pago pago) {
        if(pago.getIdPago() == null || pago.getIdPago().trim().isEmpty()) {
            long nextNum = pagoRepository.count() + 1;
            String numId = "T" + String.format("%03d", nextNum);
            pago.setIdPago(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + pago.getIdPago());
        }
    return pagoRepository.save(pago);
}

    // Obtener todos los Pagos
    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }
}
