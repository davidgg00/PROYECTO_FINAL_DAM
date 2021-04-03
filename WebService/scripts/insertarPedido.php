<?php
require_once '../MyWebService.php';
$email_cliente = $_REQUEST['email_cliente'];
$total_a_pagar = $_REQUEST['total_a_pagar'];

if (isset($email_cliente) && isset($total_a_pagar)) {
    $cbd = new ConexionBD();
    $fecha = new DateTime();
    $sql = "INSERT into pedidos(id,email_cliente,total_a_pagar,pedidoNumero,fecha,entregado) VALUES(null,?,?,null,?,0)";
    $parametros = array($email_cliente, $total_a_pagar, $fecha->getTimestamp());
    $resultado = $cbd->consultaManipulacion_retornarFila($sql, $parametros);

    if (!isset($resultado)) {
        $resultado = array("estado" => "error");
        echo json_encode($resultado);
    } else {
        echo json_encode($resultado);
    }
}
