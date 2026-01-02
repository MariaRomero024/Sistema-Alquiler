package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @Column(name = "idUsuario", length = 20, nullable = false)
    private String idUsuario;
    
    private String nombres;
    private String apellidos;
    private Integer telefono;
    private String rol;
    // Getters y Setters

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setIdUsuario(String id) {
        this.idUsuario = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}