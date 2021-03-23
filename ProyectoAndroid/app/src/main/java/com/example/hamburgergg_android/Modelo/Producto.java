package com.example.hamburgergg_android.Modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String nombre,ruta_img, tipo;
    private double precio;

    public Producto(int id, String nombre, double precio, String fotoAlimento, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ruta_img = fotoAlimento;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta_img() {
        return ruta_img;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}