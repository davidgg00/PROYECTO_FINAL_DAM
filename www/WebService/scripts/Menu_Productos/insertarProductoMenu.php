<?php
require_once '../MyWebService.php';
$idProducto = $_REQUEST['idProducto'];
$idMenu = $_REQUEST['idMenu'];

if (isset($idProducto) && isset($idMenu)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into comida_menu(id,idProductoMenu,idProductoAlimento) VALUES(null,?,?)";
    $parametros = array($idMenu, $idProducto);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }
    echo $resultado;
}
