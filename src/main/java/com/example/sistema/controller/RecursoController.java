package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Recurso;
import com.example.sistema.service.RecursoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/recurso")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    // Mostrar formulario para agregar Recursos
    @GetMapping("/gestionar")
    public String mostrarFormulario(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("recursos", recursoService.obtenerTodos()); // Mostrar lista de Recursos
        return "GestionarRecurso"; // Este es el nombre del archivo HTML
    }

    // Procesar el formulario de Recurso
    @PostMapping("/guardar")
    public String guardarRecurso(@RequestParam String nombre, @RequestParam String tipo, @RequestParam Integer tarifa, @RequestParam String condiciones) {
        Recurso recurso = new Recurso();
        recurso.setNombre(nombre);
        recurso.setTipo(tipo);
        recurso.setTarifa(tarifa);
        recurso.setCondiciones(condiciones);
        recursoService.guardarRecurso(recurso);  // Guardamos el Recurso
        return "redirect:/recurso/gestionar";  // Redirigimos al formulario con la lista actualizada
    }
}