package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Turista {

    @Id
    @Column(name = "idTurista", length = 20, nullable = false)
    private String idTurista;
    
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String dni_pasaporte;
    private String correo;
    // Getters y Setters

    public String getIdTurista() {
        return idTurista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDni_pasaporte() {
        return dni_pasaporte;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdTurista(String id) {
        this.idTurista = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setDni_pasaporte(String dni_pasaporte) {
        this.dni_pasaporte = dni_pasaporte;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    }
