<?php

if (!defined('BT_ROOT')) {
    define('BT_ROOT',  dirname(__FILE__) . '/');
}

//echo BT_ROOT;

//Clases controlador

//require_once (BT_ROOT.'bd/WebSettings.php');
require_once(BT_ROOT . '../controlador/Config.php');
require_once(BT_ROOT . '../controlador/ConexionBD.php');
//require_once (BT_ROOT.'controlador/GestionFamilias.php');
//require_once (BT_ROOT.'controlador/GestionProductos.php');


//Clases modelo
//require_once(BT_ROOT . 'modelo/Producto.php');
//require_once (BT_ROOT.'modelo/Ordenador.php');
//require_once (BT_ROOT.'modelo/CestaCompra.php');

require_once(BT_ROOT . '../modelo/Protocolo.php');
