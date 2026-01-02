package com.example.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema.entity.DetalleAlquiler;
import com.example.sistema.repository.DetalleAlquilerRepository;

@Service
public class DetalleAlquilerService {

    @Autowired
    private DetalleAlquilerRepository detalleAlquilerRepository;

    public List<DetalleAlquiler> obtenerPorAlquiler(String idAlquiler) {
        return detalleAlquilerRepository.findAll()
                .stream()
                .filter(d -> d.getIdAlquiler().equals(idAlquiler))
                .toList();
    }

    public DetalleAlquiler guardar(DetalleAlquiler detalle) {
          if(detalle.getIdDetalleAlquiler() == null || detalle.getIdDetalleAlquiler().trim().isEmpty()) {
            long nextNum = DetalleAlquilerRepository.count() + 1;
            String numId = "DA" + String.format("%03d", nextNum);
            detalle.setIdDetalleAlquiler(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + detalle.getIdDetalleAlquiler());
        }
        return detalleAlquilerRepository.save(detalle);
    }
}
