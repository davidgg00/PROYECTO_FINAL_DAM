<?php
require_once '../MyWebService.php';
$id = $_REQUEST['id'];

if (isset($id)) {
    $cbd = new ConexionBD();
    $sql = "UPDATE pedidos SET entregado = true where id = ?";
    $parametros = array($id);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }

    echo $resultado;
}
