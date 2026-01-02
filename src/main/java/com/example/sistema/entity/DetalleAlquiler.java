package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class DetalleAlquiler {

    @Id
    @Column(name = "idDetalleAlquiler", length = 20, nullable = false)
    private String idDetalleAlquiler;
    
    @ManyToOne
    @JoinColumn(name = "idAlquiler")
    private Alquiler alquiler;

    @ManyToOne
    @JoinColumn(name = "idRecurso")
    private Recurso recurso;

    private Date fechaInicio;
    private Date fechaFin;
    private String subtotal;
    // Getters y Setters

    public String getIdDetalleAlquiler() {
        return idDetalleAlquiler;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public java.util.Date getFechaFin() {
        return fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getSubTotal() {
        return subtotal;
    }

    public void setIdDetalleAlquiler(String id) {
        this.idDetalleAlquiler = id;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setSubTotal(String subTotal) {
        this.subtotal = subTotal;
    }

    }