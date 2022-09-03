package com.grupo.asd.domain.services;

import com.grupo.asd.domain.dto.FixedAsset;
import com.grupo.asd.domain.repository.FixedAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


@Service
public class FixedAssetService {
    @Autowired
    private FixedAssetRepository fixedAssetRepository;
    private boolean bandera;

    public List<FixedAsset> getAll(){
        if(!fixedAssetRepository.getAll().isEmpty()){
            return fixedAssetRepository.getAll();
        }
            return null;
    }

    public ResponseEntity<?> findByDate(String date){
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaCompra = LocalDate.parse(date,formato);
        if(fixedAssetRepository.findByDate(fechaCompra).isEmpty()){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(fixedAssetRepository.findByDate(fechaCompra),HttpStatus.OK);
    }

    public ResponseEntity<?> findByIdTypeActive(int idTipoActivo){
        if(fixedAssetRepository.findByIdTypeActive(idTipoActivo).isEmpty()){
            throw new RuntimeException();
        }
            return new ResponseEntity<>(fixedAssetRepository.findByIdTypeActive(idTipoActivo),HttpStatus.OK);
    }

    public ResponseEntity<?> findByNameTypeActive(String name){
        if(name.equals("")){
            throw new RuntimeException();
        }else{
            return new ResponseEntity<>(fixedAssetRepository.findByIdTypeActive(fixedAssetRepository.findByNameTypeActive(name).getIdTypeActive()),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> getFixedAsset(String fixedAssetId){
        if(fixedAssetRepository.exists(fixedAssetId) && !fixedAssetId.equals("")){
            return new ResponseEntity<>(fixedAssetRepository.getFixedAsset(fixedAssetId),HttpStatus.OK);
        }else{
            throw new RuntimeException();
        }
    }
    public ResponseEntity<?> save(FixedAsset fixedAsset){
        String msj = validacionDatos(fixedAsset);
        if(bandera){
            return new ResponseEntity<>(fixedAssetRepository.save(fixedAsset), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(Map.of("Error","¡Datos incompletos!, por favor verifique "+msj), HttpStatus.BAD_REQUEST);
    }



    public String validacionDatos(FixedAsset fixedAsset){
        bandera=true;
        String respuesta="";
        if(fixedAsset.getIdFixed()==null || fixedAsset.getIdFixed().equals("") ){
            respuesta+="el serial del activo ";
            bandera=false;
        }
        if(fixedAsset.getNumber() == 0){
            respuesta+="el número de inventario ";
            bandera=false;
        }
        if(fixedAsset.getName() == null || fixedAsset.getName().equals("")){
            respuesta+="el nombre ";
            bandera=false;
        }
        if(fixedAsset.getDescription()==null || fixedAsset.getDescription().equals("") ){
            respuesta+="la descripcion ";
            bandera=false;
        }
        if(fixedAsset.getIdTypeActive() == 0 ){
            respuesta+=" Id del tipo de activo ";
            bandera=false;
        }
        if(fixedAsset.getAlto() == 0 || fixedAsset.getPeso()==0 || fixedAsset.getAncho()==0){
            respuesta+=" especificaciones de alto, peso y ancho ";
            bandera=false;
        }
        if(fixedAsset.getPrice()==0){
            respuesta+=" valor de la compra ";
            bandera=false;
        }
        if(fixedAsset.getDate() == null || fixedAsset.getDate().equals("")){
            respuesta+=" Fecha de compra ";
            bandera=false;
        }
        if(fixedAsset.getIdManager()==null || fixedAsset.getIdManager().equals("")){
            respuesta+=" identificacion del area o persona responsable ";
            bandera=false;
        }
        return respuesta;
    }

}
