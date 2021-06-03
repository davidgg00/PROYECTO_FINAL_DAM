package com.AutoBurger.app.Controlador;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class Validar {
    /**
     * Método que retorna true o false dependiendo de la respuesta del WebService
     * @param json
     * @return
     */
    public static boolean respuestaWebService(JSONObject json){
        try {
            String estado=json.get("code").toString();
            if (estado.equalsIgnoreCase("CR_OK")){
                return true;
            }
        } catch (JSONException e) {
            return false;
        }


        return false;
    }

    /**
     * Método que comprueba si el nombre de usuario es correcto
     * @param nombre
     * @return
     */
    public static boolean nombreUsuario(String nombre){
        if (nombre.length() <= 25 && nombre.matches("[a-zA-Z]+")){
            return true;
        }
        return false;
    }

    /**
     * Método que comprueba si el correo es correcto
     * @param correo
     * @return
     */
    public static boolean correo(String correo){
        if (correo.length() <= 50 && correo.matches("^(.+)@(.+)$")){
            return true;
        }
        return false;
    }

    /**
     * Método que comprueba si la password es correcta
     * @param password
     * @return
     */
    public static boolean password(String password){
        if (!password.isEmpty() && password.length() >= 6){
            return true;
        }
        return false;
    }
}
