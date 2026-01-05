package com.example.sistema.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Promocion;
import com.example.sistema.service.PromocionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/promocion")
public class PromocionController {

    private final PromocionService promocionService;

    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    // Mostrar formulario para agregar Promocions
    @GetMapping("/gestionar")
    public String mostrarFormulario(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("promociones", promocionService.obtenerTodos()); // Mostrar lista de Promocions
        return "GestionarPromocion"; // Este es el descripcion del archivo HTML
    }

    // Procesar el formulario de Promocion
    @PostMapping("/guardar")
    public String guardarPromocion(@RequestParam String descripcion, @RequestParam String tipo, @RequestParam Integer valor_descuento, @RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        Promocion promocion = new Promocion();
        promocion.setDescripcion(descripcion);
        promocion.setTipo(tipo);
        promocion.setValor_descuento(valor_descuento);
        promocion.setFechaInicio(fechaInicio);
        promocion.setFechaFin(fechaFin);
        promocionService.guardarPromocion(promocion);  // Guardamos el Promocion
        return "redirect:/promocion/gestionar";  // Redirigimos al formulario con la lista actualizada
    }
}