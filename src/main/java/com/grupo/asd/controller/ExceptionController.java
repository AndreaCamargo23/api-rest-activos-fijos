package com.grupo.asd.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.format.DateTimeParseException;
import java.util.Map;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<?> handleDateTimeParseException(){
        return new ResponseEntity<>(Map.of("Error","Entrada erronea, formato de fecha correcto: dd-mm-yyyy"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(){
        return new ResponseEntity<>(Map.of("Error","Entrada erronea o búsqueda sin resultados"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(){
        return new ResponseEntity<>(Map.of("Error","Error al realizar la creación del activo, verifique las llaves foraneas"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
