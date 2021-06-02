package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DavidGG
 * @version 1.0
 */
public class Validar {

    /**
     * Método que valida si un nombre no está vacio y si contiene menos de 20 caracteres
     * @param nombre
     * @return 
     */
    public static boolean nombreCorrecto(String nombre){
        if (nombre.isEmpty() || nombre.length() > 20 || nombre == "") {
            return false;
        }
        
        return true;
    }
    
    /**
     * Valida si un precio no es vacio, si es un numero y si es mayor que 0
     * @param precio
     * @return 
     */
    public static boolean precioCorrecto(String precio){
        if (precio.isEmpty()) {
            return false;
        }
        
        try {
            double precioDouble = Double.parseDouble(precio);
            if (precioDouble <= 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean imagenCorrecta(String imagen){
        String extension = imagen.substring(imagen.lastIndexOf("."));
        System.out.println("aa: " + extension);
        if (extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpeg")) {
            return true;
        }
        return false;
    }
    
    
    public static boolean validarPatron(String cadena, String patron) {
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(cadena);

        //cadena.matches(patron)
        if (m.matches()) {
            return true;
        }

        return false;
    }
}
