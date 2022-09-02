package com.grupo.asd.persistencia.mapper;

import com.grupo.asd.domain.dto.City;
import com.grupo.asd.persistencia.entity.Ciudad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mappings({
            @Mapping(source = "idCiudad", target = "idCity"),
            @Mapping(source = "ciudad", target = "name")
    })
    City toCity(Ciudad ciudad);
    @InheritInverseConfiguration
    @Mapping(target = "responsables", ignore = true)
    Ciudad toCiudad(City city);
}
