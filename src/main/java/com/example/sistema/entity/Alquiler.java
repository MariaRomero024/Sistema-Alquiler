package com.example.sistema.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Alquiler")

public class Alquiler{

    @Id
    @Column(name = "idAlquiler", length = 20, nullable = false)
    private String idAlquiler;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idTurista")
    private Turista idTurista;

    @ManyToOne
    @JoinColumn(name = "idPromocion")
    private Promocion idPromocion;
    
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "montoBruto")
    private Integer montoBruto;

    @Column(name = "montoTotal")
    private Integer montoTotal;

    @Column(name = "estado")
    private String estado;


    public String getIdAlquiler() {
        return idAlquiler;
    }

    public Usuario getIdIdUsuario() {
        return idUsuario;
    }

    public Turista getIdTurista() {
        return idTurista;
    }

    public Promocion getIdPromocion() {
        return idPromocion;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public Integer getMontoBruto() {
        return montoBruto;
    }

    public Integer getMontoTotal() {
        return montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdAlquiler(String id) {
        this.idAlquiler = id;
    }

    public void setIdUsuario(Usuario IdUsuario) {
        this.idUsuario = IdUsuario;
    }

    public void setIdTurista(Turista IdTurista) {
        this.idTurista = IdTurista;
    }

    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMontoBruto(Integer montoBruto) {
        this.montoBruto = montoBruto;
    }

    public void setMontoTotal(Integer montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}