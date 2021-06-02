package controlador;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.ArrayList;
import modelo.Json;
import java.lang.reflect.Type;
import modelo.Ingrediente;
import utilidades.Constantes;

/**
 * @author DavidGG
 * @version 1.0
 */
public class GestionIngrediente {

    /**
     * Método que añade un ingrediente a la base de datos
     *
     * @param nombre
     * @return
     */
    public static boolean add(String nombre) {
        String values = "nombre=" + nombre;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_INSERT_INGREDIENTE, values);
        Gson gson = new Gson();
        Json json = gson.fromJson(resultado, Json.class);
        return json.getCodigo().equals(Constantes.CR_OK);
    }

    /**
     * Método que obtiente todos los ingredientes a la base de datos
     *
     * @return
     */
    public static ArrayList<Ingrediente> getAll() {
        String values = "";

        String json = utilidades.HttpRequest.GET_REQUEST(Constantes.URL_LISTAR_INGREDIENTES, values);

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Ingrediente>>() {
        }.getType();
        ArrayList<Ingrediente> ingredientes = gson.fromJson(json, listType);

        return ingredientes;
    }

    /**
     * Método que obtiente edita un ingrediente en la base de datos
     *
     * @param id
     * @param nombre
     * @return
     */
    public static boolean editar(int id, String nombre) {
        String values = "id=" + id + "&nombre=" + nombre;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_MODIFY_INGREDIENTE, values);
         System.out.println(resultado);
         System.out.println(values);
        Gson gson = new Gson();
        Json json = gson.fromJson(resultado, Json.class);

        return json.getCodigo().equals(Constantes.CR_OK);
    }

    /**
     * Método que obtiente borra un ingrediente en la base de datos
     *
     * @param id
     * @return
     */
    public static boolean borrar(int id) {
        String values = "id=" + id;
        String resultado = utilidades.HttpRequest.POST_REQUEST(Constantes.URL_DELETE_INGREDIENTE, values);
        Gson gson = new Gson();
       
        Json json = gson.fromJson(resultado, Json.class);

        return json.getCodigo().equals(Constantes.CR_OK);
    }
}
