/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

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
			// TODO Auto-generated catch block
			System.out.println("Error, no se ha encontrado el fichero a subir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!transferencia) {
			System.out.println("Error de subida");
		}
                cliente.disconnect();
		return transferencia;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
}
