package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author DavidGG
 * @version 1.0
 */
public class Constantes {

    public static String ipDatabase = "localhost";
    public static String userDatabase = "root";
    public static String passwordDatabase = "";
    public static int puertoSocket = 8000;
    public static String servidorFTP = "files.000webhost.com";
    public static String usuarioFTP = "autoburger";
    public static String claveFTP = "Proyecto_Final_2020";
    public static String nombreBBDD = "hamburgueseria";

    //URLS
    public static String SERVER = "http://" + ipDatabase + "/WebService/scripts/";
    public static final String URL_INSERT_PRODUCTO = SERVER + "Productos/insertarProducto.php";
    public static final String URL_INSERT_INGREDIENTES_PRODUCTO = SERVER + "Ingredientes_Hamburguesa/insertarIngredientesHamburguesa.php";
    public static final String URL_INSERT_INGREDIENTE = SERVER + "Ingredientes/insertarIngrediente.php";
    public static final String URL_INSERT_PRODUCTOS_MENU = SERVER + "Menu_Productos/insertarProductoMenu.php";
    public static final String URL_LISTAR_INGREDIENTES = SERVER + "Ingredientes/listarIngredientes.php";
    public static final String URL_LISTAR_INGREDIENTES_HAMBURGUESA = SERVER + "Ingredientes_Hamburguesa/listarIngredientesHamburguesa.php";
    public static final String URL_LISTAR_PRODUCTO = SERVER + "Productos/listarProductos.php";
    public static final String URL_LISTAR_MENUS = SERVER + "Productos/listarTipoProducto.php";
    public static final String URL_LISTAR_PRODUCTOS_MENU = SERVER + "Menu_Productos/listarProductosMenu.php";
    public static final String URL_MODIFY_PRODUCTO = SERVER + "Productos/modificarProducto.php";
    public static final String URL_MODIFY_MENU = SERVER + "Productos/modificarProducto.php";
    public static final String URL_MODIFY_INGREDIENTE = SERVER + "Ingredientes/modificarIngrediente.php";
    public static final String URL_DELETE_PRODUCTO = SERVER + "Productos/eliminarProducto.php";
    public static final String URL_DELETE_INGREDIENTES_PRODUCTO = SERVER + "Ingredientes_Hamburguesa/eliminarTodosIngredientesProducto.php";
    public static final String URL_DELETE_PRODUCTOS_MENU = SERVER + "Menu_Productos/eliminarTodosProductosMenu.php";
    public static final String URL_DELETE_INGREDIENTE = SERVER + "Ingredientes/eliminarIngrediente.php";
    public static final String URL_PEDIDO_ENTREGADO = SERVER + "Pedido/pedidoEntregado.php";
    public static final String URL_LISTAR_PEDIDOS_PENDIENTRES = SERVER + "Pedido/listarPedidosPendientes.php";
    public static final String URL_DELETE_MENU = SERVER + "Productos/eliminarProducto.php";
    public static final String CR_OK = "CR_OK";
    public static final String CR_ERROR = "CR_ERROR";
}
