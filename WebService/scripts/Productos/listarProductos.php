<?php
require_once '../MyWebService.php';

$sql = "SELECT * FROM producto where tipo != 'menu'";
$cbd = new ConexionBD();
$resultado = $cbd->consultaSeleccion($sql);

$resultado = json_encode($resultado);

echo !empty($resultado) ? $resultado : "sin_Productos";
