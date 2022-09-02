package com.grupo.asd.persistencia.mapper;

import com.grupo.asd.domain.dto.TypeActive;
import com.grupo.asd.persistencia.entity.TipoActivo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TypeActiveMapper {
    @Mappings({
            @Mapping(source = "idTipoActivo",target = "idTypeActive"),
            @Mapping(source = "tipoActivo",target = "nameTypeActive")
    })
    TypeActive toTypeActive(TipoActivo tipoActivo);

    @InheritInverseConfiguration
    @Mapping(target = "activosFijos",ignore = true)
    TipoActivo toTipoActivo(TypeActive typeActive);
}
