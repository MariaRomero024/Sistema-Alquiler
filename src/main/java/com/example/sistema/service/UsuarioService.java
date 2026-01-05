package com.example.sistema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistema.entity.Usuario;
import com.example.sistema.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Guardar un usuario en la base de datos
    public Usuario guardarUsuario(Usuario usuario) {
        if(usuario.getIdUsuario() == null || usuario.getIdUsuario().trim().isEmpty()) {
            long nextNum = usuarioRepository.count() + 1;
            String numId = "U" + String.format("%03d", nextNum);
            usuario.setIdUsuario(numId);
            System.out.println("ID GENERADO EXITOSAMENTE: " + usuario.getIdUsuario());
        }
    return usuarioRepository.save(usuario);
}

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
    public Usuario buscarPorId(String id) {
    return usuarioRepository.findById(id).orElse(null);
}

}
