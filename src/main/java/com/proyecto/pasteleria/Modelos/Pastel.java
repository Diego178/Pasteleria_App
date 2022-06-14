package com.proyecto.pasteleria.Modelos;

public class Pastel {
    private int id;
    private String tipoPan;
    private String relleno;
    private String color;
    private String forma;
    private int pisos;
    private String tamano;
    private int precio;
    private String detalles;

    public Pastel(int id, String tipoPan, String relleno, String color, String forma, int pisos, String tamano, int precio, String detalles) {
        this.id = id;
        this.tipoPan = tipoPan;
        this.relleno = relleno;
        this.color = color;
        this.forma = forma;
        this.pisos = pisos;
        this.tamano = tamano;
        this.precio = precio;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
