/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.ArrayList;
//import modelo.Json;
import modelo.Producto;
import java.lang.reflect.Type;
import modelo.Ingrediente;
import modelo.Json;
import utilidades.Constantes;

/**
 *
 * @author DavidGG
 */
public class GestionProducto {

    /**
     * Método que lista todos los productos de la base de datos
     *
     * @return
     */
    public static ArrayList<Producto> getAll() {
        String values = "";

        String json = utilidades.HttpRequest.GET_REQUEST(Constantes.URL_LISTAR_PRODUCTO, values);

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Producto>>() {
        }.getType();
        ArrayList<Producto> productos = gson.fromJson(json, listType);

        ArrayList<Producto> productos_todo = getAllIngredientesHamburguesa(productos);
        return productos_todo;
    }

    /**
     * Método que retorna todos los ingredientes de todas las hamburguesas
     *
     * @return
     */
    public static ArrayList<Producto> getAllIngredientesHamburguesa(ArrayList<Producto> productos) {

        for (Producto producto : productos) {
            if (producto.getTipo().equalsIgnoreCase("Hamburguesa")) {
                String values = "idHamburguesa=" + producto.getId();

                String json = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_LISTAR_INGREDIENTES_HAMBURGUESA, values);

                System.out.println(json);
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Ingrediente>>() {
                }.getType();
                ArrayList<Ingrediente> ingredientes = gson.fromJson(json, listType);
                producto.setIngredientes(ingredientes);
            }
        }

        return productos;
    }

    /**
     * Método que borra un producto de la base de datos
     *
     * @param id
     * @return
     */
//    public static boolean borrar(int id) {
//        String values = "id=" + id;
//        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_DELETE_PRODUCTO, values);
//        Gson gson = new Gson();
//        Json json = gson.fromJson(resultado, Json.class);
//
//        return json.getCodigo().equals(Constantes.CR_OK);
//    }
    /**
     * Método que añade un producto en la base de datos justo con sus
     * ingredientes
     *
     * @param p
     * @param ingredientesSel
     * @return
     */
    public static boolean add(Producto p) {
        String values = "nombre=" + p.getNombre() + "&precio=" + p.getPrecio() + "&tipo=" + p.getTipo() + "&ruta_img=" + p.getRuta_img();
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_PRODUCTO, values);
        Gson gson = new Gson();
        System.out.println(resultado);
        if (p.getTipo().equalsIgnoreCase("Hamburguesa")) {
            Json json = null;
            for (Ingrediente ingrediente : p.getIngredientes()) {
                values = "idHamburguesa=" + Integer.parseInt(resultado) + "&idIngrediente=" + ingrediente.getId();
                String resultado2 = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_INGREDIENTES_PRODUCTO, values);
                System.out.println(resultado2);
                json = gson.fromJson(resultado2, Json.class);
            }
            return json.getCodigo().equals(Constantes.CR_OK);
        } else {
            return true;
        }
    }

    /**
     * Método que borra todos los ingredientes de un producto. Se ejecuta cuando
     * vamos a cambiar los ingredientes de un producto
     *
     * @param id
     */
    public static boolean borrarTodosIngredientes(int id) {
        String values = "idHamburguesa=" + id;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_DELETE_INGREDIENTES_PRODUCTO, values);
        Gson gson = new Gson();
        Json json = gson.fromJson(resultado, Json.class);
        return json.getCodigo().equals(Constantes.CR_OK);

    }

    /**
     * Método que edita un producto de la base de datos
     *
     * @param id
     * @param p
     * @return
     */
    public static boolean editar(Producto p) {
        String values = "id=" + p.getId() + "&nombre=" + p.getNombre() + "&precio=" + p.getPrecio() + "&ruta_img=" + p.getRuta_img();
        System.out.println(values);
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_MODIFY_PRODUCTO, values);
        Gson gson = new Gson();
        System.out.println(resultado);
        Json json = gson.fromJson(resultado, Json.class);

        for (Ingrediente ingrediente : p.getIngredientes()) {
            System.out.println("a");
            values = "idHamburguesa=" + p.getId() + "&idIngrediente=" + ingrediente.getId();
            String resultado2 = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_INGREDIENTES_PRODUCTO, values);
            System.out.println(resultado2);
            json = gson.fromJson(resultado2, Json.class);
        }
        return json.getCodigo().equals(Constantes.CR_OK);
    }

    public static boolean remove(int id) {
        String values = "id=" + id;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_DELETE_PRODUCTO, values);
        System.out.println(resultado);
        Gson gson = new Gson();
        Json json = gson.fromJson(resultado, Json.class);
        return json.getCodigo().equals(Constantes.CR_OK);
    }
}
