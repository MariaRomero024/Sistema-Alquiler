package com.example.sistema.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sistema.entity.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

     @GetMapping("/dashboard")
     public String dashboard(HttpSession session, Model model) {

     Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

     if (usuario == null) {
          return "redirect:/";
     }

     LocalDate hoy = LocalDate.now();

     DateTimeFormatter formatter =
               DateTimeFormatter.ofPattern(
                         "EEEE, d 'de' MMMM yyyy",
                         Locale.forLanguageTag("es-ES")
               );

     String fechaFormateada = hoy.format(formatter);

     model.addAttribute("usuario", usuario);
     model.addAttribute("fechaActual", fechaFormateada);

     return "dashboard";
     }

}
