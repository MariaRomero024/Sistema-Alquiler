package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Turista;
import com.example.sistema.service.TuristaService;

@Controller
public class TuristaController {

    private final TuristaService turistaService;

    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
    }

    // Mostrar formulario para agregar turistas
    @GetMapping("/gestionar-turista")
    public String mostrarFormulario(Model model) {
        model.addAttribute("turistas", turistaService.obtenerTodos()); // Mostrar lista de turistas
        return "GestionarTurista"; // Este es el nombre del archivo HTML
    }

    // Procesar el formulario de turista
    @PostMapping("/guardar")
    public String guardarTurista(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String dni_pasaporte, @RequestParam Integer telefono, @RequestParam String correo) {
        Turista turista = new Turista();
        turista.setNombre(nombre);
        turista.setApellido(apellido);
        turista.setDni_pasaporte(dni_pasaporte);
        turista.setTelefono(telefono);
        turista.setCorreo(correo);
        turistaService.guardarTurista(turista);  // Guardamos el turista
        return "redirect:/gestionar-turista";  // Redirigimos al formulario con la lista actualizada
    }
}
