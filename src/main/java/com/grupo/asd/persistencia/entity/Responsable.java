package com.grupo.asd.persistencia.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Responsable {
    @Id
    private String identificacion;
    private String nombre;
    @Column(name = "id_tipo_responsable")
    private Integer idTipoResponsable;
    @Column(name = "id_ciudad")
    private Integer idCiudad;
    @ManyToOne //de muchos a uno
    @JoinColumn(name = "id_ciudad",insertable = false,updatable = false) //recuperar a que categoria pertenece un producto
    private Ciudad ciudad;
    @ManyToOne
    @JoinColumn(name = "id_tipo_responsable",insertable = false,updatable = false)
    private TipoResponsable tipoResponsable;
    @OneToMany(mappedBy = "responsable")
    private List<ActivoFijo> activoFijos;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoResponsable() {
        return idTipoResponsable;
    }

    public void setIdTipoResponsable(Integer idTipoResponsable) {
        this.idTipoResponsable = idTipoResponsable;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public TipoResponsable getTipoResponsable() {
        return tipoResponsable;
    }

    public void setTipoResponsable(TipoResponsable tipoResponsable) {
        this.tipoResponsable = tipoResponsable;
    }

    public List<ActivoFijo> getActivoFijos() {
        return activoFijos;
    }

    public void setActivoFijos(List<ActivoFijo> activoFijos) {
        this.activoFijos = activoFijos;
    }
}
