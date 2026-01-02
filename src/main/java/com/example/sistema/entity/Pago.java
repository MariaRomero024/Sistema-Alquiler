package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Pago {

    @Id
    @Column(name = "idPago", length = 20, nullable = false)
    private String idPago;
    
    @ManyToOne
    @JoinColumn(name = "idAlquiler")
    private Alquiler alquiler;

    private Date fecha;
    private Float monto;
    private String metodo;
    private String estado;
    // Getters y Setters

    public String getIdPago() {
        return idPago;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public Date getFecha() {
        return fecha;
    }

    public Float getMonto() {
        return monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdPago(String id) {
        this.idPago = id;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}