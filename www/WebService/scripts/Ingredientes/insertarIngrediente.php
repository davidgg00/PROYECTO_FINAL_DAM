<?php
require_once '../MyWebService.php';
$nombre = $_REQUEST['nombre'];

if (isset($nombre)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into ingredientes(id,nombre) VALUES(null,?)";
    $parametros = array($nombre);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }

    echo $resultado;
}
