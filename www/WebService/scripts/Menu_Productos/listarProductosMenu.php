<?php
require_once '../MyWebService.php';

$idMenu = $_REQUEST['idMenu'];
if (isset($idMenu)) {
    $sql = "SELECT producto.* FROM producto INNER JOIN comida_menu ON producto.id = comida_menu.idProductoAlimento WHERE comida_menu.idProductoMenu = ?";
    $cbd = new ConexionBD();
    $parametros = array($idMenu);
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    $resultado = json_encode($resultado);

    echo $resultado;

    // echo !empty($resultado) ? $resultado : "menu_noexiste";
}
