<?php
require_once '../MyWebService.php';
//Esperamos los siguientes parámetros
$email = $_REQUEST['email'];
$password = $_REQUEST['password'];

//Comprobamos si los hemos recibido
if (isset($email) && isset($password)) {
    $cbd = new ConexionBD();
    $sql = "Select * FROM cliente where email = ? AND password = ?";
    $parametros = array($email, MD5($password));
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    if ($resultado) {
        $respuesta = array("code" => "CR_OK", "email" => $email, "nombre" => $resultado[0]->nombre, "password" => $resultado[0]->password);
    } else {
        $respuesta = array(
            "estado" => "error",
            "datos" => ""
        );
    }
    echo json_encode($respuesta);
}
