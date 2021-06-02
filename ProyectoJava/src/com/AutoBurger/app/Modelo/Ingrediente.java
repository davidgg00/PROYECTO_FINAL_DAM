package com.AutoBurger.app.Modelo;

import java.io.Serializable;

/**
 * @author DavidGG
 * @version 1.0
 */
public class Ingrediente implements Serializable{
    private int id;
    private String nombre;
    private static final long serialVersionUID = 1L;

    public Ingrediente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
