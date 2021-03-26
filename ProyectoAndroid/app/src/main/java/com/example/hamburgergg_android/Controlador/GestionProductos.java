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
     * Método que obtendrá las hamburguesas que están disponibles en la BBDD
     * @param contexto
     * @return
     */
    public static ArrayList<Producto> getHamburguesas(final Context contexto){
        hamburguesas.clear();

        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "listarHamburguesas.php", future, future);
        requestQueue.add(request);

        try {
            String test = future.get().toString();

            JSONArray jsonArray = new JSONArray(test);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject e = jsonArray.getJSONObject(i);
                ArrayList<Ingrediente> ingred = getIngredientesHamburguesa(contexto, Integer.parseInt(e.get("id").toString()));
                hamburguesas.add(new Producto(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), e.get("ruta_img").toString(), e.get("tipo").toString(),ingred));
            }
            return hamburguesas;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static ArrayList<Ingrediente> getIngredientesHamburguesa(final Context contexto, final int idHamburguesa){
        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "listarIngredientesHamburguesa.php?idHamburguesa="+idHamburguesa, future, future){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idHamburguesa", "1");
                return params;
            }
        };
        requestQueue.add(request);

        try {
            String test = future.get().toString();
            JSONArray jsonArray = new JSONArray(test);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject e = jsonArray.getJSONObject(i);
                ingredientesHamburguesa.add(new Ingrediente(Integer.parseInt(e.get("id").toString()),e.get("nombre").toString()));
            }
            return ingredientesHamburguesa;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }



        public static String xd (Context contexto){
            String response = new String();



            RequestQueue requestQueue = Volley.newRequestQueue(contexto);

            RequestFuture<String> future = RequestFuture.newFuture();
            StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "listarHamburguesas.php", future, future);
            requestQueue.add(request);

            try {
                response = future.get().toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return response;
        }
}
