package com.example.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "Alquiler")

public class Alquiler{

    @Id
    @Column(name = "idAlquiler", length = 20, nullable = false)
    private String idAlquiler;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTurista")
    private Turista turista;

    @ManyToOne
    @JoinColumn(name = "idPromocion")
    private Promocion promocion;
    
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

    public Usuario getUsuario() {
        return usuario;
    }

    public Turista getTurista() {
        return turista;
    }

    public Promocion getPromocion() {
        return promocion;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
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