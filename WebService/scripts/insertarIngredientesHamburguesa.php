<?php
require_once '../MyWebService.php';
$idHamburguesa = $_REQUEST['idHamburguesa'];
$idIngrediente = $_REQUEST['idIngrediente'];

if (isset($idIngrediente) && isset($idHamburguesa)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into ingredientes_hamburguesa(id,idHamburguesa,idIngrediente) VALUES(null,?,?)";
    $parametros = array($idHamburguesa, $idIngrediente);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }
    echo $resultado;
}
