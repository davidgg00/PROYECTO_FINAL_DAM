package com.example.hamburgergg_android.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
    private int id;
    private String nombre;
    private double precio;
    private ArrayList<Producto> productos;

    public Menu(int id, String nombre, double precio, ArrayList<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.productos = productos;
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

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
