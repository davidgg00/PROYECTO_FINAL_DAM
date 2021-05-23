<?php
require_once '../MyWebService.php';

$sql = "SELECT pedidos.*, GROUP_CONCAT(producto.nombre) as pedido FROM pedidos INNER JOIN detalle_pedido ON detalle_pedido.idPedido = pedidos.id INNER JOIN producto ON detalle_pedido.idProducto = producto.id WHERE entregado = 0 GROUP BY pedidos.id";
$cbd = new ConexionBD();
$resultado = $cbd->consultaSeleccion($sql);

$resultado = json_encode($resultado);

echo $resultado;
