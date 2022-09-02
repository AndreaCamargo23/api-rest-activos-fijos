package com.grupo.asd.persistencia.mapper;

import com.grupo.asd.domain.dto.FixedAsset;
import com.grupo.asd.persistencia.entity.ActivoFijo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ManagerMapper.class, TypeActiveMapper.class})
public interface FixedAssetMapper {
    @Mappings({
            @Mapping(source = "serial",target = "idFixed"),
            @Mapping(source = "numeroInventario",target = "number"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "descripcion",target = "description"),
            @Mapping(source = "idTipoActivo",target = "idTypeActive"),
            @Mapping(source = "valorCompra",target = "price"),
            @Mapping(source = "fechaCompra",target = "date"),
            @Mapping(source = "idResponsable",target = "idManager"),
            @Mapping(source = "tipoActivo",target = "typeActive"),
            @Mapping(source = "responsable",target = "manager")
    })

    FixedAsset toFixedAsset(ActivoFijo activoFijo);

    List<FixedAsset> toFixedAssets(List<ActivoFijo> activosFijos);

    @InheritInverseConfiguration
    ActivoFijo toActivoFijo(FixedAsset fixedAsset);

}
