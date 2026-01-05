package com.example.sistema.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Alquiler;
import com.example.sistema.entity.Promocion;
import com.example.sistema.entity.Turista;
import com.example.sistema.entity.Usuario;
import com.example.sistema.service.AlquilerService;
import com.example.sistema.service.PromocionService;
import com.example.sistema.service.TuristaService;
import com.example.sistema.service.UsuarioService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/alquiler")
public class AlquilerController {

    private final AlquilerService alquilerService;
    private final TuristaService turistaService;
    private final PromocionService promocionService;
    private final UsuarioService usuarioService;

    // Inyección por constructor (Igual que tu TuristaController)
    
    public AlquilerController(AlquilerService alquilerService, 
                              TuristaService turistaService, 
                              PromocionService promocionService,UsuarioService usuarioService) {
        this.alquilerService = alquilerService;
        this.turistaService = turistaService;
        this.promocionService = promocionService;
        this.usuarioService = usuarioService;
    }

    // Mostrar formulario y lista de alquileres
    @GetMapping("/gestionar")
    public String mostrarFormulario(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("alquileres", alquilerService.obtenerTodos());
        model.addAttribute("turistas", turistaService.obtenerTodos()); // Para llenar el select de turistas
        model.addAttribute("promociones", promocionService.obtenerTodos()); // Para el select de promociones
        return "GestionarAlquiler"; // Nombre del archivo HTML
    }
    @GetMapping("/nuevo")
    public String nuevoAlquiler(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("turistas", turistaService.obtenerTodos());
        model.addAttribute("promociones", promocionService.obtenerTodos());
        return "NuevoAlquiler";
    }

    // Procesar el formulario de alquiler
    @PostMapping("/guardar")
    public String guardarAlquiler(
        @RequestParam String idUsuario,
        @RequestParam String dniPasaporte,
        @RequestParam(required = false) String idPromocion,
        @RequestParam Integer montoBruto,
        @RequestParam Integer montoTotal,
        @RequestParam String estado) {

        // 🔹 Buscar objetos completos
        Usuario usuario = usuarioService.buscarPorId(idUsuario);
        Turista turista = turistaService.buscarPorDniPasaporte(dniPasaporte);
        Promocion promocion = null;

        if (idPromocion != null && !idPromocion.isEmpty()) {
            promocion = promocionService.buscarPorId(idPromocion);
        }

        // 🔹 Crear alquiler
        Alquiler alquiler = new Alquiler();
        alquiler.setIdUsuario(usuario);
        alquiler.setIdTurista(turista);
        alquiler.setIdPromocion(promocion);
        alquiler.setFecha(new Date());
        alquiler.setMontoBruto(montoBruto);
        alquiler.setMontoTotal(montoTotal);
        alquiler.setEstado(estado);

        alquilerService.guardarAlquiler(alquiler);

        return "redirect:/alquiler/gestionar";
    }

}