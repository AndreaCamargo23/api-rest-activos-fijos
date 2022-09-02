package com.grupo.asd.persistencia.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_responsable")
public class TipoResponsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//se le incluye una estrategia, que le da identidad a los registros de la tabla producto
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Column(name = "nombre_tipo")
    private String nombre;
    //Por quien esta mappeado o que relacion respalda este nuevo atributo, lo respalda la variable de la otra clase con la relacion
    @OneToMany(mappedBy = "tipoResponsable")
    private List<Responsable> responsables;

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }
}
