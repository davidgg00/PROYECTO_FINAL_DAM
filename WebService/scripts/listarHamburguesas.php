<?php
require_once '../MyWebService.php';

//$resultado=consultar($dni);
$sql = "SELECT * FROM producto where tipo = 'Hamburguesa'";
$cbd = new ConexionBD();
$resultado = $cbd->consultaSeleccion($sql);

//if ($resultado){
$resultado = json_encode($resultado);
//}


echo $resultado;
