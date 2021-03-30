<?php
require_once '../MyWebService.php';
$nombre = $_REQUEST['nombre'];
$precio = $_REQUEST['precio'];
$tipo = $_REQUEST['tipo'];
$ruta_img = $_REQUEST['ruta_img'];

if (isset($nombre) && isset($precio) && isset($tipo) && isset($ruta_img)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into producto(id,nombre,precio,tipo,ruta_img) VALUES(null,?,?,?,?)";
    $parametros = array($nombre, $precio, $tipo, $ruta_img);
    $resultado = $cbd->consultaManipulacion_retornalastID($sql, $parametros);

    if ($resultado == 0) {
        $resultado = array("estado" => "error");
        echo json_encode($resultado);
    } else {
        echo $resultado;
    }
}
