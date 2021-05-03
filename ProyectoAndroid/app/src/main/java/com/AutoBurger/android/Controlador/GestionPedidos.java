package com.AutoBurger.android.Controlador;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.AutoBurger.android.Modelo.Conexion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class GestionPedidos {

    public static String getPedidosAntiguos(Context contexto, final String email_cliente){

        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Pedido/listarPedidosAntiguosCliente.php?email="+email_cliente, future, future){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email_cliente);
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
