package modelo;

import java.util.ArrayList;

/**
 * @author DavidGG
 * @version 1.0
 */
public class Producto {
    private int id;
    private String nombre,ruta_img, tipo;
    private double precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public Producto(int id, String nombre, double precio, String fotoAlimento, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ruta_img = fotoAlimento;
        this.tipo = tipo;
    }

    public Producto(int id, String nombre, double precio, String fotoAlimento, String tipo, ArrayList<Ingrediente> ingredientes) {
        this.ingredientes.clear();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ruta_img = fotoAlimento;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
    }
    
    public Producto(String nombre, double precio, String fotoAlimento, String tipo, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ruta_img = fotoAlimento;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
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

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        if (this.ingredientes == null) {
            return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ruta_img='" + ruta_img + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
   //             ", ingredientes=" + ingredientes.toString() +
                '}';
        }
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ruta_img='" + ruta_img + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
              ", ingredientes=" + ingredientes.toString() +
                '}';
    }
}
