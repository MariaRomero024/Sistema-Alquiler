package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sistema.service.PagoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pago")
public class PagoController {


    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    // Mostrar formulario para agregar turistas
    @GetMapping("/gestionar")
    public String mostrarFormulario(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("pagos", pagoService.obtenerTodos()); // Mostrar lista de turistas
        return "GestionarPago"; // Este es el nombre del archivo HTML
    }

}