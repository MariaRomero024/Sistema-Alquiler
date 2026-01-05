package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Usuario;
import com.example.sistema.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Mostrar formulario para agregar Recursos
    @GetMapping("/gestionar")
    public String mostrarFormulario(HttpSession session,Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }
        model.addAttribute("usuarios", usuarioService.obtenerTodos()); // Mostrar lista de Recursos
        return "GestionarUsuario"; // Este es el nombre del archivo HTML
    }

    // Procesar el formulario de Recurso
    @PostMapping("/guardar")
    public String guardarUsuario(@RequestParam String nombres, @RequestParam String apellidos, @RequestParam Integer telefono,@RequestParam String rol,@RequestParam String contrasenia) {
        Usuario usuario = new Usuario();
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setTelefono(telefono);
        usuario.setRol(rol);
        usuario.setContrasenia(contrasenia);
        usuarioService.guardarUsuario(usuario);  // Guardamos el Recurso
        return "redirect:/usuario/gestionar";  // Redirigimos al formulario con la lista actualizada
    }

}