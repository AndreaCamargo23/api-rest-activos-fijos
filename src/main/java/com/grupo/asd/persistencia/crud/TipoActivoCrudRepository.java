package com.grupo.asd.persistencia.crud;


import com.grupo.asd.persistencia.entity.TipoActivo;
import org.springframework.data.repository.CrudRepository;

public interface TipoActivoCrudRepository extends CrudRepository<TipoActivo,Integer> {
    TipoActivo findByTipoActivo(String tipoActivo);
}
