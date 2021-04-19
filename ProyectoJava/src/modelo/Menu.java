/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.example.hamburgergg_android.Modelo.*;
import java.io.Serializable;
import modelo.*;
import java.util.ArrayList;

/**
 *
 * @author DavidGG
 */
public class Menu implements Serializable{
    private int id;
    private String nombre;
    private double precio;
    private String ruta_img;
    private ArrayList<Producto> productos;
    private static final long serialVersionUID = 1L;

    public Menu(String nombre, double precio, String ruta_img, ArrayList<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ruta_img = ruta_img;
        this.productos = productos;
    }
    
    public Menu(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Menu(int id, String nombre, double precio, String ruta_img,ArrayList<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ruta_img = ruta_img;
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

    public String getRuta_img() {
        return ruta_img;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", ruta_img=" + ruta_img + ", productos=" + productos + '}';
    }
    
    
    
}
