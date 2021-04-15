<?php
require_once '../MyWebService.php';

$sql = "SELECT * FROM menus";
$cbd = new ConexionBD();
$resultado = $cbd->consultaSeleccion($sql);

$resultado = json_encode($resultado);

echo !empty($resultado) ? $resultado : "sin_menus";
