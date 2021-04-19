/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import modelo.Ingrediente;
import modelo.Json;
import modelo.Menu;
import modelo.Producto;
import utilidades.Constantes;

/**
 *
 * @author DavidGG
 */
public class GestionMenu {

    /**
     * Método que obtiente todos los Menús de la base de datos
     *
     * @return
     */
    public static ArrayList<Menu> getAll() {
        String values = "tipoProducto=Menu";

        String json = utilidades.HttpRequest.GET_REQUEST(Constantes.URL_LISTAR_MENUS, values);

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Menu>>() {
        }.getType();
        ArrayList<Menu> menus = gson.fromJson(json, listType);

        ArrayList<Menu> menus_completo = getProductos(menus);
        return menus_completo;
    }

    /**
     * Método que obtiente todos los productos de un Menú
     *
     * @return
     */
    public static ArrayList<Menu> getProductos(ArrayList<Menu> menus) {
        for (Menu menu : menus) {
            String values = "idMenu=" + menu.getId();

            String json = utilidades.HttpRequest.GET_REQUEST(Constantes.URL_LISTAR_PRODUCTOS_MENU, values);

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Producto>>() {
            }.getType();

            ArrayList<Producto> productos = gson.fromJson(json, listType);

            menu.setProductos(productos);
        }
        return menus;

    }

    /**
     * Método que añade un menú en la base de datos justo con sus productos
     *
     * @param p
     * @param ingredientesSel
     * @return
     */
    public static boolean add(Menu menu) {
        String values = "nombre=" + menu.getNombre() + "&precio=" + menu.getPrecio() + "&ruta_img=" + menu.getRuta_img() + "&tipo=Menu";
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_PRODUCTO, values);
        Gson gson = new Gson();
        System.out.println(resultado);
        Json json = null;
        for (Producto producto : menu.getProductos()) {
            values = "idProducto=" + producto.getId() + "&idMenu=" + Integer.parseInt(resultado);
            System.out.println(values);
            String resultado2 = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_PRODUCTOS_MENU, values);
            System.out.println(resultado2);
            json = gson.fromJson(resultado2, Json.class);
        }
        return json.getCodigo().equals(Constantes.CR_OK);
    }
    
    /**
     * Método que borra todos los productos de un menu. Se ejecuta cuando
     * vamos a cambiar los ingredientes de un producto
     *
     * @param id
     */
    public static boolean borrarTodosProductos(int id) {
        String values = "idMenu=" + id;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_DELETE_PRODUCTOS_MENU, values);
        Gson gson = new Gson();
        System.out.println(resultado);
        Json json = gson.fromJson(resultado, Json.class);
        return json.getCodigo().equals(Constantes.CR_OK);
    }
    
    public static boolean editar(Menu menu) {
        String values = "id=" + menu.getId() + "&nombre=" + menu.getNombre() + "&precio=" + menu.getPrecio() + "&ruta_img=" + menu.getRuta_img();
        System.out.println(values);
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_MODIFY_MENU, values);
        Gson gson = new Gson();
        System.out.println(resultado);
        Json json = gson.fromJson(resultado, Json.class);

        for (Producto producto : menu.getProductos()) {
            System.out.println("a");
            values = "idProducto=" + producto.getId() + "&idMenu=" + menu.getId();
            String resultado2 = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_PRODUCTOS_MENU, values);
            System.out.println(resultado2);
            json = gson.fromJson(resultado2, Json.class);
        }
        return json.getCodigo().equals(Constantes.CR_OK);
    }
    
    public static boolean remove(int id) {
        String values = "id=" + id;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_DELETE_MENU, values);
        System.out.println(resultado);
        Gson gson = new Gson();
        Json json = gson.fromJson(resultado, Json.class);
        return json.getCodigo().equals(Constantes.CR_OK);
    }
}
