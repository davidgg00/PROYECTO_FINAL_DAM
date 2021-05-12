<?php
require_once '../MyWebService.php';

$tipoProducto = $_REQUEST['tipoProducto'];
if (isset($tipoProducto)) {
    $sql = "SELECT * FROM producto where tipo = ?";
    $cbd = new ConexionBD();
    $parametros = array($tipoProducto);
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    $resultado = json_encode($resultado);

    echo !empty($resultado) ? $resultado : "sin_tipoproducto";
}
