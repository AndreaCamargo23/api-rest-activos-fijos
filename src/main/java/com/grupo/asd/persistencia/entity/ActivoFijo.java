package com.grupo.asd.persistencia.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activo_fijo")
public class ActivoFijo {
    @Id
    @Column(name = "serial_activo")
    private String serial;
    @Column(name = "numero_inventario")
    private Integer numeroInventario;
    private String nombre;
    private String descripcion;
    @Column(name = "id_tipo_activo")
    private Integer idTipoActivo;
    private Double peso;
    private Double alto;
    private Double ancho;
    @Column(name = "valor_compra")
    private Double valorCompra;
    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;
    @Column(name = "id_responsable")
    private String idResponsable;
    @ManyToOne
    @JoinColumn(name = "id_tipo_activo", insertable = false,updatable = false)
    private TipoActivo tipoActivo;
    @ManyToOne
    @JoinColumn(name = "id_responsable", insertable = false,updatable = false)
    private Responsable responsable;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(Integer numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdTipoActivo() {
        return idTipoActivo;
    }

    public void setIdTipoActivo(Integer idTipoActivo) {
        this.idTipoActivo = idTipoActivo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }

    public TipoActivo getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(TipoActivo tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

}
