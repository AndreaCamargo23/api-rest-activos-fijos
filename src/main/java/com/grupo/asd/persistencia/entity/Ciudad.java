package com.grupo.asd.persistencia.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Integer idCiudad;
    private String ciudad;
    @OneToMany(mappedBy = "ciudad")
    private List<Responsable> responsables;

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }
}
