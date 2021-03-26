<?php
require_once '../MyWebService.php';

$idHamburguesa = $_REQUEST['idHamburguesa'];
//$resultado=consultar($dni);
if (isset($idHamburguesa)) {
    $sql = "SELECT ingredientes.* FROM ingredientes_hamburguesa INNER JOIN ingredientes ON ingredientes.id = ingredientes_hamburguesa.idIngrediente  where ingredientes_hamburguesa.idHamburguesa = ?";
    $cbd = new ConexionBD();
    $parametros = array($idHamburguesa);
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    $resultado = json_encode($resultado);


    echo $resultado;
}
