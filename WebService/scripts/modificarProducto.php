<?php
require_once '../MyWebService.php';
$id = $_REQUEST['id'];
$nombre = $_REQUEST['nombre'];
$precio = $_REQUEST['precio'];
$ruta_img = $_REQUEST['ruta_img'];

if (isset($id) && isset($nombre) && isset($precio) && isset($ruta_img)) {
    $cbd = new ConexionBD();
    $sql = "UPDATE producto SET nombre = ?, precio = ?, ruta_img = ? where id = ?";
    $parametros = array($nombre, $precio, $ruta_img, $id);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }

    echo $resultado;
}
