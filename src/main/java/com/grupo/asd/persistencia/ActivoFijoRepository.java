package com.grupo.asd.persistencia;

import com.grupo.asd.domain.dto.FixedAsset;
import com.grupo.asd.domain.dto.TypeActive;
import com.grupo.asd.domain.repository.FixedAssetRepository;
import com.grupo.asd.persistencia.crud.ActivoFijoCrudRepository;
import com.grupo.asd.persistencia.crud.TipoActivoCrudRepository;
import com.grupo.asd.persistencia.entity.ActivoFijo;
import com.grupo.asd.persistencia.entity.TipoActivo;
import com.grupo.asd.persistencia.mapper.FixedAssetMapper;
import com.grupo.asd.persistencia.mapper.TypeActiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ActivoFijoRepository implements FixedAssetRepository {
    @Autowired
    private ActivoFijoCrudRepository activoFijoCrudRepository;
    @Autowired
    private TipoActivoCrudRepository tipoActivoCrudRepository;
    @Autowired
    private TypeActiveMapper mapperType;
    @Autowired
    private FixedAssetMapper mapper;
    @Override
    public List<FixedAsset> getAll() {
        List<ActivoFijo> activoFijos = (List<ActivoFijo>) activoFijoCrudRepository.findAll();
        return mapper.toFixedAssets(activoFijos);
    }

    @Override
    public List<FixedAsset> findByDate(LocalDate fechaCompra) {
        List<ActivoFijo> activoFijoList=activoFijoCrudRepository.findByFechaCompra(fechaCompra);
        return mapper.toFixedAssets(activoFijoList);
    }

    @Override
    public List<FixedAsset> findByIdTypeActive(int idTipoActivo) {
        List<ActivoFijo> activosFijos= activoFijoCrudRepository.findByIdTipoActivo(idTipoActivo);
        return mapper.toFixedAssets(activosFijos);
    }

    @Override
    public TypeActive findByNameTypeActive(String nombre) {
        return mapperType.toTypeActive(tipoActivoCrudRepository.findByTipoActivo(nombre));
    }


    @Override
    public Optional<FixedAsset> getFixedAsset(String fixedAssetId) {
        return activoFijoCrudRepository.findById(fixedAssetId).map(activo -> mapper.toFixedAsset(activo));
    }

    @Override
    public FixedAsset save(FixedAsset fixedAsset) {
        ActivoFijo activoFijo = mapper.toActivoFijo(fixedAsset);
        return mapper.toFixedAsset(activoFijoCrudRepository.save(activoFijo));
    }

    @Override
    public boolean exists(String fixedAssetId) {
        if(activoFijoCrudRepository.existsById(fixedAssetId)){
            return true;
        }else{
            return false;
        }
    }

    //Falta Actualizar
}
