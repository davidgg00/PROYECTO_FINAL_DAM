<?php
require_once '../MyWebService.php';
$idPedido = $_REQUEST['idPedido'];
$idProducto = $_REQUEST['idProducto'];

if (isset($idPedido) && isset($idProducto)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into detalle_pedido(id,idPedido,idProducto) VALUES(null,?,?)";
    $parametros = array($idPedido, $idProducto);
    $resultado = $cbd->consultaManipulacion($sql, $parametros);

    if ($resultado) {
        $resultado = array("estado" => "exito");
    } else {
        $resultado = array("estado" => "error");
    }
    echo json_encode($resultado);
}
