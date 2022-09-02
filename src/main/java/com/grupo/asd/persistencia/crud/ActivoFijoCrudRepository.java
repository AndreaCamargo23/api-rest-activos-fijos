package com.grupo.asd.persistencia.crud;

import com.grupo.asd.persistencia.entity.ActivoFijo;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActivoFijoCrudRepository extends CrudRepository<ActivoFijo,String> {

    List<ActivoFijo> findByFechaCompra(LocalDate fechaCompra);
    List<ActivoFijo> findByIdTipoActivo(int idTipoActivo);

}
