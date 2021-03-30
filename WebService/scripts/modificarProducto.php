<?php
require_once '../MyWebService.php';
$id = $_REQUEST['id'];
$nombre = $_REQUEST['nombre'];
$precio = $_REQUEST['precio'];

if (isset($id) && isset($nombre) && isset($precio)) {
    $cbd = new ConexionBD();
    $sql = "UPDATE producto SET nombre = ?, precio = ? where id = ?";
    $parametros = array($nombre, $precio, $id);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }

    echo $resultado;
}
