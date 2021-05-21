<?php
require_once '../MyWebService.php';
$idPedido = $_REQUEST['idPedido'];

if (isset($idPedido)) {
    $cbd = new ConexionBD();
    $sql = "DELETE FROM pedidos WHERE id = ?";
    $parametros = array($idPedido);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }
    echo $resultado;
}
