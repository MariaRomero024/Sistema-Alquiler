package com.example.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistema.entity.Usuario;
import com.example.sistema.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

     private final UsuarioService usuarioService;
     public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
     }

    @GetMapping("/")
    public String login() {
        return "Login"; // Retorna login.html
    }

    @PostMapping("/login")
    public String autenticar(@RequestParam String idUsuario, 
                             @RequestParam String contrasenia, 
                             HttpSession session, 
                             Model model) {
        
        // Buscamos al usuario en la base de datos
        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        if(usuario != null){
            System.out.println("Usuario encontrado: " + usuario.getIdUsuario());
             if (usuario.getContrasenia().equals(contrasenia)) {
                // ¡ÉXITO! Guardamos el usuario completo en la sesión
                session.setAttribute("usuarioLogueado", usuario);
                return "redirect:/dashboard";
            } else {
                // ERROR
                model.addAttribute("error", "Credenciales incorrectas");
                return "Login";
            }
        } else {
            System.out.println("Usuario no encontrado con ID: " + idUsuario);
            model.addAttribute("error", "Credenciales incorrectas");
            return "Login";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Limpia toda la sesión (usuario y carrito)
        return "redirect:/";
    }
}
