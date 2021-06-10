<?php
require_once '../MyWebService.php';
$idMenu = $_REQUEST['idMenu'];

if (isset($idMenu)) {
    $cbd = new ConexionBD();
    $sql = "DELETE FROM comida_menu WHERE idProductoMenu = ?";
    $parametros = array($idMenu);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }
    echo $resultado;
}
