<?php
require_once '../MyWebService.php';

$email_cliente = $_REQUEST['email'];
if (isset($email_cliente)) {
    $sql = "SELECT producto.*,pedidos.fecha,pedidos.total_a_pagar,pedidos.id as idPedido FROM `pedidos` INNER JOIN detalle_pedido ON detalle_pedido.idPedido = pedidos.id INNER JOIN producto ON producto.id = detalle_pedido.idProducto WHERE pedidos.email_cliente = ?";
    $cbd = new ConexionBD();
    $parametros = array($email_cliente);
    $resultado = $cbd->consultaSeleccionParam($sql, $parametros);

    $resultado = json_encode($resultado);

    echo $resultado;
}
