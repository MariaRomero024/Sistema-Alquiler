package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Turista;
import com.example.sistema.service.TuristaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/turista")
public class TuristaController {

    private final TuristaService turistaService;

    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
    }

    // Mostrar formulario para agregar turistas
    @GetMapping("/gestionar")
    public String mostrarFormulario(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("turistas", turistaService.obtenerTodos()); // Mostrar lista de turistas
        return "GestionarTurista"; // Este es el nombre del archivo HTML
    }

    // Procesar el formulario de turista
    @PostMapping("/guardar")
    public String guardarTurista(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String dniPasaporte, @RequestParam Integer telefono, @RequestParam String correo) {
        Turista turista = new Turista();
        turista.setNombre(nombre);
        turista.setApellido(apellido);
        turista.setDniPasaporte(dniPasaporte);
        turista.setTelefono(telefono);
        turista.setCorreo(correo);
        turistaService.guardarTurista(turista);  // Guardamos el turista
        return "redirect:/turista/gestionar";  // Redirigimos al formulario con la lista actualizada
    }
}
