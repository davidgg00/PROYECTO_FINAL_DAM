package com.AutoBurger.app.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
    private int id;
    private String nombre,ruta_img;
    private double precio;
    private ArrayList<Producto> productos;
    private static final long serialVersionUID = 1L;
    public Menu(int id, String nombre, double precio, ArrayList<Producto> productos, String ruta_img) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.productos = productos;
        this.ruta_img = ruta_img;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
    }

    public String getRuta_img() {
        return ruta_img;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ruta_img='" + ruta_img + '\'' +
                ", precio=" + precio +
                ", productos=" + productos +
                '}';
    }
}
