package com.example.hamburgergg_android.Controlador;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamburgergg_android.Modelo.Conexion;
import com.example.hamburgergg_android.Modelo.Ingrediente;
import com.example.hamburgergg_android.Modelo.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Clase que hará peticiones a la tabla Productos.
 */
public class GestionProductos {
    private static ArrayList<Producto> hamburguesas = new ArrayList<>();



    /**
     * Método que obtendrá los menus que están disponibles en la BBDD
     * @param contexto
     * @return datos
     */
    public static String getMenus(Context contexto){

        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Productos/listarTipoProducto.php?tipoProducto=Menu", future, future);
        requestQueue.add(request);

        try {
            String test = future.get().toString();
            return test;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getProductosMenu(Context contexto, final int idMenu){

        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Menu_Productos/listarProductosMenu.php?idMenu="+idMenu, future, future){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idMenu", String.valueOf(idMenu));
                return params;
            }
        };
        requestQueue.add(request);

        try {
            String datos = future.get().toString();
            return datos;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return null;
    }


    /**
     * Método que obtendrá las bebidas que están disponibles en la BBDD
     * @param contexto
     * @return datos
     */
    public static String getBebidas(Context contexto){


        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Productos/listarTipoProducto.php?tipoProducto=Bebida", future, future);
        requestQueue.add(request);

        try {
            String bebidas = future.get().toString();
            System.out.print(bebidas);
            return bebidas;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que obtendrá las patatas que están disponibles en la BBDD
     * @param contexto
     * @return datos
     */
    public static String getPatatas(Context contexto){


        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Productos/listarTipoProducto.php?tipoProducto=Patatas", future, future);
        requestQueue.add(request);

        try {
            String test = future.get().toString();
            return test;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Método que obtendrá las hamburguesas que están disponibles en la BBDD
     * @param contexto
     * @return datos
     */
    public static String getHamburguesas(Context contexto){


        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Productos/listarTipoProducto.php?tipoProducto=Hamburguesa", future, future);
        requestQueue.add(request);

        try {
            String datos = future.get().toString();
            return datos;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getIngredientesHamburguesa(Context contexto, int idHamburguesa){

        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Ingredientes_Hamburguesa/listarIngredientesHamburguesa.php?idHamburguesa="+idHamburguesa, future, future){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idHamburguesa", "1");
                return params;
            }
        };
        requestQueue.add(request);

        try {
            String datos = future.get().toString();
            return datos;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return null;
    }



}
