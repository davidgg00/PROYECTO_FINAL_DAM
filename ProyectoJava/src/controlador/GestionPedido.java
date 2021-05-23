/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.AutoBurger.app.Modelo.Pedido;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import modelo.Json;
import utilidades.Constantes;

/**
 *
 * @author DavidGG
 */
public class GestionPedido {

    public static boolean entregado(Pedido pedido) {
        String values = "id=" + pedido.getId();
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_PEDIDO_ENTREGADO, values);
        Gson gson = new Gson();
        System.out.println(resultado);
        Json json = gson.fromJson(resultado, Json.class);;
        return json.getCodigo().equals(Constantes.CR_OK);
    }
    
    public static JsonArray getPedidosPendientes(){
        String values = "";
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_LISTAR_PEDIDOS_PENDIENTRES, values);
        JsonArray jsonarray = (JsonArray) new JsonParser().parse(resultado);

        return jsonarray;
    }

}
