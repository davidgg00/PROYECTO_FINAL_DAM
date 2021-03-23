package com.example.hamburgergg_android.Controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamburgergg_android.ActivityCartaAlimentos;
import com.example.hamburgergg_android.BienvenidaActivity;
import com.example.hamburgergg_android.MainActivity;
import com.example.hamburgergg_android.Modelo.Conexion;
import com.example.hamburgergg_android.Modelo.Producto;
import com.example.hamburgergg_android.Modelo.VolleyCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase que hará peticiones a la tabla Productos.
 */
public class GestionProductos {
    private static ArrayList<Producto> hamburguesas = new ArrayList<>();

    /**
     * Método que obtendrá las hamburguesas que están disponibles en la BBDD
     * @param contexto
     * @param callback
     */
    public static void getHamburguesas(Context contexto, final VolleyCallback callback){

        RequestQueue queue = Volley.newRequestQueue(contexto);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,
                Conexion.URL_WEB_SERVICES + "listarHamburguesas.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++){
                                JSONObject e = response.getJSONObject(i);
                                hamburguesas.add(new Producto(Integer.parseInt(e.get("id").toString()),e.get("nombre").toString(),Double.parseDouble(e.get("precio").toString()),e.get("ruta_img").toString(),e.get("tipo").toString()));
                            }
                            callback.onSuccess(hamburguesas);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
        };
        queue.add(jsonObjectRequest);
    }
}
