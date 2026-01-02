package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Promocion")

public class Promocion {

    @Id
    @Column(name = "idPromocion", length = 20, nullable = false)
    private String idPromocion;

    
    private String descripcion;
    private String tipo;
    private Integer valor_descuento;
    private Date fechaInicio;
    private Date fechaFin;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
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

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}