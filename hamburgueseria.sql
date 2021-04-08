-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2021 a las 20:01:18
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hamburgueseria`
--
CREATE DATABASE IF NOT EXISTS `hamburgueseria` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hamburgueseria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`email`, `password`, `nombre`) VALUES
('invitado@invitado.com', '', 'invitado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientes`
--

CREATE TABLE `ingredientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ingredientes`
--

INSERT INTO `ingredientes` (`id`, `nombre`) VALUES
(1, 'Queso'),
(2, 'Ketchup'),
(3, 'Pollo'),
(4, 'Ternera');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientes_hamburguesa`
--

CREATE TABLE `ingredientes_hamburguesa` (
  `id` int(11) NOT NULL,
  `idHamburguesa` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menus`
--

CREATE TABLE `menus` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `precio` double NOT NULL,
  `ruta_img` varchar(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `email_cliente` varchar(50) NOT NULL,
  `total_a_pagar` double NOT NULL,
  `pedidoNumero` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `entregado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `pedidos`
--
DELIMITER $$
CREATE TRIGGER `calcularPedidoNumero` BEFORE INSERT ON `pedidos` FOR EACH ROW BEGIN
DECLARE lastNPedido INT;

SET lastNPedido = (SELECT pedidoNumero FROM `pedidos` WHERE pedidoNumero IS NOT null ORDER BY fecha DESC LIMIT 1);

IF (lastNPedido <= 98) THEN

SET NEW.pedidoNumero = (lastNPedido + 1);

ELSE 

SET NEW.pedidoNumero =  1;


END IF;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `tipo` enum('Hamburguesa','Bebida','Patatas','') NOT NULL,
  `ruta_img` varchar(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_menu`
--

CREATE TABLE `productos_menu` (
  `id` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPedido` (`idPedido`,`idProducto`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ingredientes_hamburguesa`
--
ALTER TABLE `ingredientes_hamburguesa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idAlimento` (`idHamburguesa`,`idIngrediente`),
  ADD KEY `idIngrediente` (`idIngrediente`);

--
-- Indices de la tabla `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email_cliente` (`email_cliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos_menu`
--
ALTER TABLE `productos_menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProducto` (`idProducto`,`idMenu`),
  ADD KEY `idMenu` (`idMenu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ingredientes_hamburguesa`
--
ALTER TABLE `ingredientes_hamburguesa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menus`
--
ALTER TABLE `menus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos_menu`
--
ALTER TABLE `productos_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ingredientes_hamburguesa`
--
ALTER TABLE `ingredientes_hamburguesa`
  ADD CONSTRAINT `ingredientes_hamburguesa_ibfk_1` FOREIGN KEY (`idHamburguesa`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ingredientes_hamburguesa_ibfk_2` FOREIGN KEY (`idIngrediente`) REFERENCES `ingredientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`email_cliente`) REFERENCES `cliente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_menu`
--
ALTER TABLE `productos_menu`
  ADD CONSTRAINT `productos_menu_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_menu_ibfk_2` FOREIGN KEY (`idMenu`) REFERENCES `menus` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
