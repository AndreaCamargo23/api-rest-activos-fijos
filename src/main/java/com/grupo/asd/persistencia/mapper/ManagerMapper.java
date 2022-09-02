package com.grupo.asd.persistencia.mapper;

import com.grupo.asd.domain.dto.Manager;
import com.grupo.asd.persistencia.entity.Responsable;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {TypeManagerMapper.class, CityMapper.class})
public interface ManagerMapper {
    @Mappings({
            @Mapping(source = "identificacion",target = "managerId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idTipoResponsable",target = "idType"),
            @Mapping(source = "idCiudad",target = "idCity"),
            @Mapping(source = "ciudad",target = "city"),
            @Mapping(source = "tipoResponsable", target = "typeManager")
    })
    Manager toManager(Responsable responsable);
    @InheritInverseConfiguration
    @Mapping(target = "activoFijos", ignore = true)
    Responsable toResponsable(Manager manager);
}
