package com.example.navigator.entidades;

import java.io.Serializable;

public class Puntoventa implements Serializable {
    private Integer id;
    private String nombre;
    private String codigo;
    private String direccion;
    private Double latitude;
    private Double longitude;

    public Puntoventa(Integer id, String nombre, String codigo, String direccion, Double latitude, Double longitude) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Puntoventa() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
