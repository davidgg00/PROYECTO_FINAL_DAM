<?php
require_once '../MyWebService.php';
$nombre = $_REQUEST['nombre'];
$email = $_REQUEST['email'];
$passwordActual = $_REQUEST['passwordActual'];
if (isset($_REQUEST['passwordNueva'])) {
    $passwordNueva = $_REQUEST['passwordNueva'];
}

if (isset($nombre) && isset($email) && isset($passwordActual)) {
    if (isset($passwordNueva)) {
        $cbd = new ConexionBD();
        $sql = "UPDATE cliente set nombre = ?, password=? where email = ? AND password = ?";
        $parametros = array($nombre, md5($passwordNueva), $email, md5($passwordActual));
        $resultado = $cbd->consultaManipulacion($sql, $parametros);
    } else {
        $cbd = new ConexionBD();
        $sql = "UPDATE cliente set nombre = ? where email = ?";
        $parametros = array($nombre, $email);
        $resultado = $cbd->consultaManipulacion($sql, $parametros);
    }

    if ($resultado) {
        $resultado = Protocolo::CR_OK_MANIPULACION;
    } else {
        $resultado = Protocolo::CR_ERROR_MANIPULACION;
    }

    echo $resultado;
}
