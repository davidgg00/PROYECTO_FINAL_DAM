/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author DavidGG
 */
public class GestionFTP {
    static String servidor = "files.000webhost.com", usuario = "autoburger", clave = "Proyecto_Final_2020";
    
    public static boolean subir(String rutaLocal, String timestamp){
        FTPClient cliente = new FTPClient();
        try {
            cliente.connect(servidor);
            
            if (cliente.login(usuario, clave)) {
                cliente.changeWorkingDirectory("public_html");
                cliente.changeWorkingDirectory("imagenesProductos");
                cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
                FileInputStream fis;
		Boolean transferencia = false;
		try {
			fis = new FileInputStream(rutaLocal);
			transferencia = cliente.storeFile(timestamp, fis);
		} catch (FileNotFoundException e) {
                    e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
                        return false;
			
		}

		if (!transferencia) {
			return false;
		}
                cliente.disconnect();
		return transferencia;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public static boolean borrar(String ruta_img){
        FTPClient cliente = new FTPClient();
        try {
            cliente.connect(servidor);
            
            if (cliente.login(usuario, clave)) {
                cliente.changeWorkingDirectory("public_html");
                cliente.changeWorkingDirectory("imagenesProductos");
                cliente.setFileType(FTPClient.BINARY_FILE_TYPE);
                if (cliente.deleteFile(ruta_img)) {
                    return true;
                } 
                cliente.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
}
