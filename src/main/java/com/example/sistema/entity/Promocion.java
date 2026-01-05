package com.example.sistema.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Promocion")

public class Promocion {

    @Id
    @Column(name = "idPromocion", length = 20, nullable = false)
    private String idPromocion;

    
    private String descripcion;
    private String tipo;
    private Integer valor_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    // Getters y Setters

    public String getIdPromocion() {
        return idPromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getValor_descuento() {
        return valor_descuento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setIdPromocion(String id) {
        this.idPromocion = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor_descuento(Integer valor_descuento) {
        this.valor_descuento = valor_descuento;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}