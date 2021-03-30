package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    /**
     * Método que valida si un nombre de producto o ingrediente es correcto
     * @param ingrediente
     * @return 
     */
    public static boolean validarNombre(String ingrediente){
        if (!ingrediente.isEmpty() && ingrediente.length() <=50) {
            return true;
        }
        return false;
    }
    
    public static boolean validar(String cadena, String patron) {
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(cadena);

        //cadena.matches(patron)
        if (m.matches()) {
            return true;
        }

        return false;
    }
    
    /**
     * Método que valida si un precio es válido
     * @param precio
     * @return 
     */
    public static boolean precioValido(String precio) {
        if (precio.isEmpty()) {
            return false;
        }
        
        try {
            Float.parseFloat(precio);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
