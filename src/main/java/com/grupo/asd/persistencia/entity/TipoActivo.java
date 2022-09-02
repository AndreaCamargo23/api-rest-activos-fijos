package com.grupo.asd.persistencia.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_activo")
public class TipoActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_activo")
    private Integer idTipoActivo;
    @Column(name="tipo_activo")
    private String tipoActivo;
    @OneToMany(mappedBy = "tipoActivo")
    private List<ActivoFijo> activosFijos;

    public Integer getIdTipoActivo() {
        return idTipoActivo;
    }

    public void setIdTipoActivo(Integer idTipoActivo) {
        this.idTipoActivo = idTipoActivo;
    }

    public String getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(String tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    public List<ActivoFijo> getActivosFijos() {
        return activosFijos;
    }

    public void setActivosFijos(List<ActivoFijo> activosFijos) {
        this.activosFijos = activosFijos;
    }

}
