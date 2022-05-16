package com.example.navigator.entidades;

import java.io.Serializable;

public class Producto implements Serializable {
    private Integer id;
    private String nombre;
    private Double precio;
    private Double pruta;
    private Integer stock;
    private Integer idTienda;

    public Producto() {
    }

    public Producto(Integer id, String nombre, Double precio, Double pruta, Integer stock, Integer idTienda) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.pruta = pruta;
        this.stock = stock;
        this.idTienda = idTienda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPruta() {
        return pruta;
    }

    public void setPruta(Double pruta) {
        this.pruta = pruta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }
}
