<?php
require_once '../MyWebService.php';
$idHamburguesa = $_REQUEST['idHamburguesa'];

if (isset($idHamburguesa)) {
    $cbd = new ConexionBD();
    $sql = "DELETE FROM ingredientes_hamburguesa WHERE idHamburguesa = ?";
    $parametros = array($idHamburguesa);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }
    echo $resultado;
}
