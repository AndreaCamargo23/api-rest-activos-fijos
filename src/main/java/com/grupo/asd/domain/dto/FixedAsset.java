package com.grupo.asd.domain.dto;

import java.time.LocalDate;


public class FixedAsset {
    private String idFixed;
    private int number;
    private String name;
    private String description;
    private int idTypeActive;
    private double peso,alto,ancho;
    private double price;
    private LocalDate date;
    private String idManager;
    private TypeActive typeActive;
    private Manager manager;

    public String getIdFixed() {
        return idFixed;
    }

    public void setIdFixed(String idFixed) {
        this.idFixed = idFixed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdTypeActive() {
        return idTypeActive;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public void setIdTypeActive(int idTypeActive) {
        this.idTypeActive = idTypeActive;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TypeActive getTypeActive() {
        return typeActive;
    }

    public void setTypeActive(TypeActive typeActive) {
        this.typeActive = typeActive;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
