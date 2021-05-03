/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.AutoBurger.android.Modelo.Pedido;
import com.google.gson.Gson;
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
    
}
