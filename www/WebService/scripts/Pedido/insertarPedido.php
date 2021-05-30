<?php
require_once '../MyWebService.php';
$email_cliente = $_REQUEST['email_cliente'];
$total_a_pagar = $_REQUEST['total_a_pagar'];
$fecha = $_REQUEST['fecha'];

if (isset($email_cliente) && isset($total_a_pagar) && isset($fecha)) {
    $cbd = new ConexionBD();
    $sql = "INSERT into pedidos(id,email_cliente,total_a_pagar,pedidoNumero,fecha,entregado) VALUES(null,?,?,null,?,0)";
    $parametros = array($email_cliente, $total_a_pagar, $fecha);
    $resultado = $cbd->consultaManipulacion_retornarFila($sql, $parametros);

    if (!isset($resultado)) {
        $resultado = array("estado" => "error");
        echo json_encode($resultado);
    } else {
        echo json_encode($resultado);
    }
}
