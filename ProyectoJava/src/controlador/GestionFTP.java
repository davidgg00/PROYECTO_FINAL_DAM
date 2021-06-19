package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import utilidades.Constantes;

/**
 * @author DavidGG
 * @version 1.0
 */
public class GestionFTP {
    
    
    /**
     * Método que sube una imagen al servidor FTP
     * @param rutaLocal
     * @param timestamp
     * @return 
     */
    public static boolean subir(String rutaLocal, String timestamp){
        FTPClient cliente = new FTPClient();
        try {
            cliente.connect(Constantes.servidorFTP);
            
            if (cliente.login(Constantes.usuarioFTP, Constantes.claveFTP)) {
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
    
    /**
     * Método que borra una imagen del servidor FTP
     * @param ruta_img
     * @return 
     */
    public static boolean borrar(String ruta_img){
        FTPClient cliente = new FTPClient();
        try {
            cliente.connect(Constantes.servidorFTP);
            
            if (cliente.login(Constantes.usuarioFTP, Constantes.claveFTP)) {
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
