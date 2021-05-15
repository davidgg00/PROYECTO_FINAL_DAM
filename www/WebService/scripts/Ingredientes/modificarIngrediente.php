<?php
require_once '../MyWebService.php';
$id = $_REQUEST['id'];
$nombre = $_REQUEST['nombre'];

if (isset($id) && isset($nombre)) {
    $cbd = new ConexionBD();
    $sql = "UPDATE ingredientes SET nombre = ? where id = ?";
    $parametros = array($nombre, $id);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }

    echo $resultado;
}
