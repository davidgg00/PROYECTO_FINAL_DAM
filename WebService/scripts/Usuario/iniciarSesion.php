<?php
require_once '../MyWebService.php';
//Esperamos los siguientes parámetros
$email = $_REQUEST['email'];
$password = $_REQUEST['password'];

//Comprobamos si los hemos recibido
if (isset($email) && isset($password)) {
    $cbd = new ConexionBD();
    $sql = "Select nombre FROM cliente where email = ? AND password = ?";
    $parametros = array($email, MD5($password));
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    if ($resultado) {
        $respuesta = array("estado" => "exito", "email" => $email, "nombre" => $resultado[0]->nombre);
    } else {
        $respuesta = array(
            "estado" => "error",
            "datos" => ""
        );
    }
    echo json_encode($respuesta);
}
