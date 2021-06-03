package com.AutoBurger.app.Controlador;

import android.content.Context;

import com.AutoBurger.app.Modelo.Conexion;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class GestionPedidos {

    /**
     * Método que obtiene todos los pedidos antiguos de un cliente
     * @param contexto
     * @param email_cliente
     * @return
     */
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

    /**
     * Método que borra un pedido. Se ejecuta cuando hay error y no se establece la conexion con el servidor
     * @param idPedido
     * @param contexto
     * @return
     */
    public static boolean borrarPedido(final int idPedido, Context contexto){
        String datos = null;
        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Pedido/borrarPedido.php?idPedido="+idPedido, future, future){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idPedido", String.valueOf(idPedido));
                return params;
            }
        };
        requestQueue.add(request);

        try {
            datos = future.get().toString();
            System.out.println(datos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return datos.equalsIgnoreCase("{\"code\":\"CR_OK\", \"value\":\"OK_MANIPULACION\"}");
    }

    /**
     * Método que comprueba el estado del pedido del cliente
     * @param idPedido
     * @param contexto
     * @return
     */
    public static boolean pedidoCompletado(final int idPedido, Context contexto){
        String datos = null;
        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, Conexion.URL_WEB_SERVICES + "Pedido/comprobarEstadoPedido.php?idPedido="+idPedido, future, future){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idPedido", String.valueOf(idPedido));
                return params;
            }
        };
        requestQueue.add(request);

        try {
            datos = future.get().toString();
            System.out.println(datos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return datos.equalsIgnoreCase("{\"code\":\"CR_OK\", \"value\":\"OK_SELECCION\"}");
    }

}
