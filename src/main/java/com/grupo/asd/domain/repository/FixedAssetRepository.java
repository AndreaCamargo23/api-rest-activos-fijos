package com.grupo.asd.domain.repository;

import com.grupo.asd.domain.dto.FixedAsset;
import com.grupo.asd.domain.dto.TypeActive;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FixedAssetRepository {
    List<FixedAsset> getAll();
    List<FixedAsset> findByDate(LocalDate fechaCompra);
    List<FixedAsset> findByIdTypeActive(int idTipoActivo);

    TypeActive findByNameTypeActive(String nombre);
    Optional<FixedAsset> getFixedAsset(String fixedAssetId);
    FixedAsset save(FixedAsset fixedAsset);

    boolean exists(String fixedAssetId);

}
