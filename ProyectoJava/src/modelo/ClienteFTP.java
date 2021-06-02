package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * @author DavidGG
 * @version 1.0
 */
public class ClienteFTP {

    private FTPClient cliente;
    private String directorioInicial;
    private int estadoConexion;

    /**
     * Crea cliente ftp y conecta un servidor ftp
     *
     * @param servidor nombre del servidor ftp
     */
    public ClienteFTP(String servidor) {
        // crea cliente FTPClient
        cliente = new FTPClient();

        // Abre conexion el cliente con el servidor
        try {
            cliente.connect(servidor);

            // Y comprobamos la conexion y guardamos su estado en 'estadoConexion'
            estadoConexion = cliente.getReplyCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Comprobamos el estado de la conexion al servidor FTP Si es satisfactoria
     * retorna true; false en caso contrario
     *
     * @return true si la conexion es correcta; false en caso contrario
     */
    public boolean comprobarConexion() {

        return FTPReply.isPositiveCompletion(estadoConexion);
        // si la conexion es satisfactoria

    }

    /**
     * Abre una sesion ftp con una cuenta de usuario pasada como parametro
     *
     * @param usuario
     * @param clave
     * @return true si se abre correctamente; false en caso contrario.
     */
    public boolean loguear(String usuario, String clave) {

        // loguear al usuario
        boolean login = false;
        try {
            login = cliente.login(usuario, clave);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // si se loguea correctamente guardar en la variable directorioIncial la
        // ruta de su directorio de trabajo
        if (login) {
            try {
                this.directorioInicial = cliente.printWorkingDirectory();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return login;

    }

    /**
     * Muestra el directorio actual de trabajo
     *
     * @return en forma de cadena
     */
    public String mostrarRutaDirectoriActual() {
        try {
            return cliente.printWorkingDirectory();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * Lista el numero de ficheros y carpetas, junto con los nombres de cada uno
     * del directorio actual de trabajo. Adem�s indica si cada elemento es un
     * fichero o un directorio.
     *
     * @return en forma de cadena
     */
    public String listaFicherosDirectorioActual() {

        StringBuilder datos = new StringBuilder();

        FTPFile[] files = null;

        try {
            files = cliente.listFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // cliente.listFiles();
        // cliente.listNames()
        // cliente.listDirectories()
        datos.append("Ficheros en el directorio actual: " + files.length + "\n");

        // array para visualizar el tipo de fichero
        String tipos[] = {"Fichero", "Directorio", "Enlace simb."};

        for (int i = 0; i < files.length; i++) {
            datos.append(files[i].getName() + " => " + tipos[files[i].getType()] + "\n");

        }

        return new String(datos);

    }

    /**
     * Este m�todo te permite cambiar de directorio
     *
     * @param directorio
     * @return
     */
    public boolean cambiarDeDirectorio(String directorio) {
        Boolean cambiarDirectorio = null;
        try {
            cambiarDirectorio = cliente.changeWorkingDirectory(directorio);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (cambiarDirectorio) {
            System.out.println("Cambiaste de escritorio correctamente!!");
        } else {
            System.out.println("Error, ese directorio no existe");
        }
        return cambiarDirectorio;

    }

    /**
     * M�todo que crea un directorio pasado por par�metro
     *
     * @param directorio
     * @return
     */
    public boolean crearDirecorio(String directorio) {
        boolean creado = false;
        try {
            creado = cliente.makeDirectory(directorio);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(creado);
        return creado;

    }

    /**
     * M�todo que elimina un directorio pasado por par�metro
     *
     * @param directorio
     * @return
     */
    public boolean eliminarDirectorio(String directorio) {
        boolean eliminado = false;
        try {
            eliminado = cliente.removeDirectory(directorio);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (eliminado) {
            System.out.println("Se elimin� el directorio correctamente!");
        } else {
            System.out.println("error, no existe directorio o el archivo seleccionado no es un directorio");
        }
        return eliminado;

    }

    /**
     * M�todo que sube un archivo al servidor FTP
     *
     * @param directorio
     * @return
     */
    public boolean subirArchivo(String rutaArchivoLocal) {
        FileInputStream fis;
        Boolean transferencia = false;
        try {
            fis = new FileInputStream(rutaArchivoLocal);
            transferencia = cliente.storeFile(rutaArchivoLocal, fis);
        } catch (FileNotFoundException e) {
            System.out.println("Error, no se ha encontrado el fichero a subir");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (transferencia) {
            System.out.println("Se subi� el fichero correctamente!");
        }
        return transferencia;

    }

    /**
     * M�todo que descarga un archivo del servidor FTP
     *
     * @param directorio
     * @return
     */
    public boolean descargarArchivo(String nombre, String rutaDestinoLocal) {

        Boolean transferencia = false;
        Boolean error = false;
        try (FileOutputStream fos = new FileOutputStream(rutaDestinoLocal + "\\" + nombre)) {
            transferencia = cliente.retrieveFile(nombre, fos);
        } catch (FileNotFoundException e) {
            error = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (transferencia && !error) {
            System.out.println("Se descarg� el archivo correctamente!");
        } else {
            System.out.println("Error, el archivo a descargar y/o el directorio a donde lo quieres llevar no existe");
        }
        return transferencia;
    }

    /**
     * M�todo que crea elimina un archivo del FTPs
     *
     * @param directorio
     * @return
     */
    public boolean eliminarArchivo(String nombre) {
        try {
            Boolean borrado = cliente.deleteFile(nombre);
            System.out.println(borrado);
            return borrado;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * M�todo que desconcecta el cliente del servidor FTP
     */
    public void desconectar() {
        try {
            cliente.disconnect();
        } catch (Exception e) {
        }
    }

    /**
     * M�todo que obtiene el directorio Inicial
     *
     * @return
     */
    public String getDirectorioInicial() {
        return directorioInicial;
    }

}
