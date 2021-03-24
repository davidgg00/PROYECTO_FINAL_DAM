<?php
require_once '../MyWebService.php';
$nombre = $_REQUEST['nombre'];
$email = $_REQUEST['email'];
$password = $_REQUEST['password'];

if (isset($nombre) && isset($email) && isset($password)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into cliente(email,nombre,password) VALUES(?,?,?)";
    $parametros = array($email, $nombre, md5($password));
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado == 0) {
        $resultado = array("estado" => "error");
    } else {
        $resultado = array("estado" => "exito");
    }

    echo json_encode($resultado);
}
