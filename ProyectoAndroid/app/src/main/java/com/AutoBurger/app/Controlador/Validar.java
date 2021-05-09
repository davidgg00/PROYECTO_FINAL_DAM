package com.AutoBurger.app.Controlador;

import org.json.JSONException;
import org.json.JSONObject;

public class Validar {
    public static boolean respuestaWebService(JSONObject json){
        try {
            System.out.println(json.toString());
            System.out.println(json.toString());
            System.out.println(json.toString());
            System.out.println(json.toString());
            System.out.println(json.toString());
            String estado=json.get("code").toString();
            if (estado.equalsIgnoreCase("CR_OK")){
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }


        return false;
    }

    public static boolean nombreUsuario(String nombre){
        if (nombre.length() <= 25 && nombre.matches("[a-zA-Z]+")){
            return true;
        }
        return false;
    }

    public static boolean correo(String correo){
        if (correo.length() <= 50 && correo.matches("^(.+)@(.+)$")){
            return true;
        }
        return false;
    }

    public static boolean password(String password){
        if (!password.isEmpty()){
            return true;
        }
        return false;
    }
}
