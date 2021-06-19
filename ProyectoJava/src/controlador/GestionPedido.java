package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import modelo.Json;
import modelo.Pedido;
import utilidades.Constantes;

/**
 * @author DavidGG           
 * @version 1.0
 */
public class GestionPedido {

    /**
     * Método que actualiza un pedido existente como entregado
     * @param pedido
     * @return 
     */
    public static boolean entregado(Pedido pedido) {
        String values = "id=" + pedido.getId();
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_PEDIDO_ENTREGADO, values);
        Gson gson = new Gson();
        Json json = gson.fromJson(resultado, Json.class);;
        return json.getCodigo().equals(Constantes.CR_OK);
    }
    
    /**
     * Método que obtiene todos los pedidos que están pendientes
     * @return 
     */
    public static JsonArray getPedidosPendientes(){
        String values = "";
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_LISTAR_PEDIDOS_PENDIENTRES, values);
        System.out.println(resultado);
        JsonArray jsonarray = (JsonArray) new JsonParser().parse(resultado);

        return jsonarray;
    }

}
