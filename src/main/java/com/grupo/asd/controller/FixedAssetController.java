package com.grupo.asd.controller;

import com.grupo.asd.domain.dto.FixedAsset;
import com.grupo.asd.domain.services.FixedAssetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/FixedAsset")
public class FixedAssetController {
    @Autowired
    private FixedAssetService fixedAssetService;
    @GetMapping("/all")
    @ApiOperation("Consultar todos los activos fijos.")
    @ApiResponse(code=200,message = "Consulta realizada con exito.")
    public ResponseEntity<List<FixedAsset>> getAll(){
        return new ResponseEntity<>(fixedAssetService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{serial}")
    @ApiOperation("Búsqueda de activo fijo por serial")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code=404,message = "Entrada erronea o busqueda sin resultados")
    })
    public ResponseEntity<?> getFixedAsset(@ApiParam(value = "Serial del activo fijo", required = true, example = "1556DG")
                                               @PathVariable("serial") String fixedAssetId){
            return fixedAssetService.getFixedAsset(fixedAssetId);
    }

    @GetMapping("/fechacompra/{fecha}")
    @ApiOperation("Búsqueda de activos fijos por fecha de compra")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code=404,message = "Búsqueda sin resultados")
    })
    public ResponseEntity<?> findByDate(@ApiParam(value = "Fecha de compra del activo", required = true, example = "2022-09-01")
                                            @PathVariable("fecha") String date){
        return fixedAssetService.findByDate(date);
    }

    @GetMapping("/tipoactivo/idtipo/{tipo}")
    @ApiOperation("Búsqueda de activos fijos por id del tipo de activo.")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code=404,message = "Búsqueda sin resultados")
    })
    public ResponseEntity<?> findByIdTypeActive(@ApiParam(value = "Id del tipo del activo", required = true, example = "2")
                                                    @PathVariable("tipo") int idTipoActivo){
            return fixedAssetService.findByIdTypeActive(idTipoActivo);
    }
    @GetMapping("/tipoactivo/name/{name}")
    @ApiOperation("Búsqueda de activos fijos por tipo de activo.")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code=404,message = "Búsqueda sin resultados")
    })
    public ResponseEntity<?> findByNameTypeActive(@ApiParam(value = "Nombre del tipo del activo", required = true, example = "Bienes inmuebles")
                                                      @PathVariable("name") String name){
        return fixedAssetService.findByNameTypeActive(name);
    }


    @PostMapping("/save")
    @ApiOperation("Crear nuevos activos")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code=500,message = "Error al realizar la creación del activo, verifique las llaves foraneas")
    })
    public ResponseEntity<?> save(@RequestBody FixedAsset fixedAsset){
        return  fixedAssetService.save(fixedAsset);
    }

    @PutMapping("/update")
    @ApiOperation("Actualizar activos fijos")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code=500,message = "Error al realizar la creación del activo, verifique las llaves foraneas")
    })
    public ResponseEntity<?> update(@RequestBody FixedAsset fixedAsset){
        return fixedAssetService.save(fixedAsset);
    }

}
