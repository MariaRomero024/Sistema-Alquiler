package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recurso {

    @Id
    @Column(name = "idRecurso", length = 20, nullable = false)
    private String idRecurso;
    
    private String nombre;
    private String tipo;
    private String estado;
    private Integer tarifa;
    private String condiciones;
    public String imagen;
    // Getters y Setters

    public String getIdRecurso() {
        return idRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setIdRecurso(String id) {
        this.idRecurso = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }
}   