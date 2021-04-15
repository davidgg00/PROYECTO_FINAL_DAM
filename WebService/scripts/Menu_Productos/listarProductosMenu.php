<?php
require_once '../MyWebService.php';

$idMenu = $_REQUEST['idMenu'];
if (isset($idMenu)) {
    $sql = "Select producto.* FROM productos_menu INNER JOIN producto ON productos_menu.idProducto = producto.id INNER JOIN menus ON menus.id = productos_menu.idMenu WHERE menus.id= ?";
    $cbd = new ConexionBD();
    $parametros = array($idMenu);
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    $resultado = json_encode($resultado);

    echo !empty($resultado) ? $resultado : "sin_ProductosMenu";
}
