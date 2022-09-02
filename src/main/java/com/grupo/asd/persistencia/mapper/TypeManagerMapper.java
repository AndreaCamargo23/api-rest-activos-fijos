package com.grupo.asd.persistencia.mapper;

import com.grupo.asd.domain.dto.TypeManager;
import com.grupo.asd.persistencia.entity.TipoResponsable;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TypeManagerMapper {
    @Mappings({
            @Mapping(source = "idTipo", target = "typeId"),
            @Mapping(source = "nombre", target = "type")
    })
    TypeManager toTypeManager(TipoResponsable tipoResponsable);

    @InheritInverseConfiguration
    @Mapping(target = "responsables", ignore = true)
    TipoResponsable toTipoResponsable(TypeManager typeManager);

}
