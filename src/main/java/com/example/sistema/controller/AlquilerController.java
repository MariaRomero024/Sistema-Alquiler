package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Alquiler;
import com.example.sistema.service.AlquilerService;
import com.example.sistema.service.TuristaService;
import com.example.sistema.service.PromocionService;

import java.util.Date;

@Controller
public class AlquilerController {

    private final AlquilerService alquilerService;
    private final TuristaService turistaService;
    private final PromocionService promocionService;

    // Inyección por constructor (Igual que tu TuristaController)
    public AlquilerController(AlquilerService alquilerService, 
                              TuristaService turistaService, 
                              PromocionService promocionService) {
        this.alquilerService = alquilerService;
        this.turistaService = turistaService;
        this.promocionService = promocionService;
    }

    // Mostrar formulario y lista de alquileres
    @GetMapping("/gestionar-alquiler")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alquileres", alquilerService.obtenerTodos());
        model.addAttribute("turistas", turistaService.obtenerTodos()); // Para llenar el select de turistas
        model.addAttribute("promociones", promocionService.obtenerTodos()); // Para el select de promociones
        return "GestionarAlquiler"; // Nombre del archivo HTML
    }

    // Procesar el formulario de alquiler
    @PostMapping("/guardar-alquiler")
    public String guardarAlquiler(
            @RequestParam String idUsuario,
            @RequestParam String idTurista,
            @RequestParam(required = false) String idPromocion,
            @RequestParam Double montoBruto,
            @RequestParam Double montoTotal,
            @RequestParam String estado) {
        
        Alquiler alquiler = new Alquiler();
        alquiler.setIdUsuario(idUsuario);
        alquiler.setIdTurista(idTurista);
        alquiler.setIdPromocion(idPromocion);
        alquiler.setFecha(new Date()); // Se asigna la fecha actual automáticamente
        alquiler.setMontoBruto(montoBruto);
        alquiler.setMontoTotal(montoTotal);
        alquiler.setEstado(estado);

        alquilerService.guardarAlquiler(alquiler);
        
        return "redirect:/gestionar-alquiler";
    }
}