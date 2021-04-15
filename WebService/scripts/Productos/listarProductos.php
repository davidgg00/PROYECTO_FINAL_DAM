<?php
require_once '../MyWebService.php';

$sql = "SELECT * FROM producto";
$cbd = new ConexionBD();
$resultado = $cbd->consultaSeleccion($sql);

$resultado = json_encode($resultado);

echo !empty($resultado) ? $resultado : "sin_Productos";
