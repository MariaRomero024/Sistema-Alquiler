package com.example.sistema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistema.entity.Turista;
import com.example.sistema.repository.TuristaRepository;

@Service
public class TuristaService {

    private final TuristaRepository turistaRepository;

    public TuristaService(TuristaRepository turistaRepository) {
        this.turistaRepository = turistaRepository;
    }

    // Guardar un turista en la base de datos
    public Turista guardarTurista(Turista turista) {
        if(turista.getIdTurista() == null || turista.getIdTurista().trim().isEmpty()) {
            long nextNum = turistaRepository.count() + 1;
            String numId = "T" + String.format("%03d", nextNum);
            turista.setIdTurista(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + turista.getIdTurista());
        }
    return turistaRepository.save(turista);
}

    // Obtener todos los turistas
    public List<Turista> obtenerTodos() {
        return turistaRepository.findAll();
    }
    public Turista buscarPorDniPasaporte(String dniPasaporte) {
    return turistaRepository.findByDniPasaporte(dniPasaporte).orElse(null);
}
}
