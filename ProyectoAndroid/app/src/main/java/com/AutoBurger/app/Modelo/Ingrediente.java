package com.AutoBurger.app.Modelo;

import java.io.Serializable;

/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class Ingrediente implements Serializable{
    private int id;
    private String nombreINGR;
    private static final long serialVersionUID = 1L;

    public Ingrediente(int id, String nombre) {
        this.id = id;
        this.nombreINGR = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombreINGR;
    }

    public void setNombre(String nombre) {
        this.nombreINGR = nombre;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", nombreINGR='" + nombreINGR + '\'' +
                '}';
    }
}
