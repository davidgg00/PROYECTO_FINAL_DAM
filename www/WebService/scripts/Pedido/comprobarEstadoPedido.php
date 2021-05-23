<?php
require_once '../MyWebService.php';
$id = $_REQUEST['idPedido'];

if (isset($id)) {
    $cbd = new ConexionBD();
    $sql = "SELECT * FROM `pedidos` WHERE id = ? AND entregado = 1";
    $parametros = array($id);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_SELECCION;
    } else {
        $resultado = Protocolo::CR_ERROR_SELECCION;
    }

    echo $resultado;
}
