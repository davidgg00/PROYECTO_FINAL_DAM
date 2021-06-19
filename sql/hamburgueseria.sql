-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: hamburgueseria
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `hamburgueseria`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hamburgueseria` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `hamburgueseria`;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('antonio@gmail.com','e10adc3949ba59abbe56e057f20f883e','Antonio'),('davidguisado2000@gmail.com','e10adc3949ba59abbe56e057f20f883e','David'),('invitado@invitado.com','','invitado'),('marta@gmail.com','e10adc3949ba59abbe56e057f20f883e','Marta');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comida_menu`
--

DROP TABLE IF EXISTS `comida_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comida_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idProductoMenu` int(11) NOT NULL,
  `idProductoAlimento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idProductoMenu` (`idProductoMenu`,`idProductoAlimento`),
  KEY `idProductoAlimento` (`idProductoAlimento`),
  CONSTRAINT `comida_menu_ibfk_1` FOREIGN KEY (`idProductoMenu`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comida_menu_ibfk_2` FOREIGN KEY (`idProductoAlimento`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comida_menu`
--

LOCK TABLES `comida_menu` WRITE;
/*!40000 ALTER TABLE `comida_menu` DISABLE KEYS */;
INSERT INTO `comida_menu` VALUES (1,14,1),(2,14,6),(3,14,11),(4,15,2),(5,15,7),(6,15,12),(7,16,3),(8,16,8),(9,16,13),(10,17,4),(11,17,5),(12,17,9),(13,17,13);
/*!40000 ALTER TABLE `comida_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idPedido` (`idPedido`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido`
--

LOCK TABLES `detalle_pedido` WRITE;
/*!40000 ALTER TABLE `detalle_pedido` DISABLE KEYS */;
INSERT INTO `detalle_pedido` VALUES (1,1,2),(2,1,10),(4,2,7),(3,2,15),(5,3,16),(7,4,3),(6,4,8),(8,5,7),(9,6,11),(10,6,12),(12,7,7),(11,7,15),(14,8,12),(13,8,15),(15,9,6);
/*!40000 ALTER TABLE `detalle_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` VALUES (1,'Pollo'),(2,'Ternera'),(3,'Lechuga'),(4,'Mayonesa'),(5,'Ketchup'),(6,'Tomate'),(7,'Pepinillos'),(8,'Bacon'),(9,'mostazaa');
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes_hamburguesa`
--

DROP TABLE IF EXISTS `ingredientes_hamburguesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientes_hamburguesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idHamburguesa` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idAlimento` (`idHamburguesa`,`idIngrediente`),
  KEY `idIngrediente` (`idIngrediente`),
  CONSTRAINT `ingredientes_hamburguesa_ibfk_1` FOREIGN KEY (`idHamburguesa`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ingredientes_hamburguesa_ibfk_2` FOREIGN KEY (`idIngrediente`) REFERENCES `ingredientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes_hamburguesa`
--

LOCK TABLES `ingredientes_hamburguesa` WRITE;
/*!40000 ALTER TABLE `ingredientes_hamburguesa` DISABLE KEYS */;
INSERT INTO `ingredientes_hamburguesa` VALUES (1,1,1),(2,1,3),(3,2,2),(4,2,4),(5,3,2),(6,3,6),(7,3,7),(8,4,3),(9,4,5),(10,4,8),(11,5,1),(12,5,4),(13,5,5),(14,5,6);
/*!40000 ALTER TABLE `ingredientes_hamburguesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_cliente` varchar(50) NOT NULL,
  `total_a_pagar` double NOT NULL,
  `pedidoNumero` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `entregado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `email_cliente` (`email_cliente`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`email_cliente`) REFERENCES `cliente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'invitado@invitado.com',7.98,1,'2021-06-13 20:38:32',1),(2,'davidguisado2000@gmail.com',9.49,2,'2021-06-13 20:38:44',1),(3,'antonio@gmail.com',8.99,3,'2021-06-13 18:40:06',1),(4,'invitado@invitado.com',7.98,4,'2021-06-13 21:49:59',1),(5,'invitado@invitado.com',1.5,5,'2021-06-13 21:50:48',1),(6,'invitado@invitado.com',2.98,6,'2021-06-13 23:56:22',1),(7,'davidguisado2000@gmail.com',9.49,7,'2021-06-13 23:59:17',1),(8,'davidguisado2000@gmail.com',8.98,8,'2021-06-14 08:26:28',1),(9,'invitado@invitado.com',0.99,9,'2021-06-14 10:28:14',1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcularPedidoNumero` BEFORE INSERT ON `pedidos` FOR EACH ROW BEGIN
DECLARE lastNPedido INT;

SET lastNPedido = (SELECT pedidoNumero FROM `pedidos` WHERE pedidoNumero IS NOT null ORDER BY fecha DESC LIMIT 1);

IF (lastNPedido <= 98) THEN

SET NEW.pedidoNumero = (lastNPedido + 1);

ELSE 

SET NEW.pedidoNumero =  1;


END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `tipo` enum('Hamburguesa','Bebida','Patatas','Menu') NOT NULL,
  `ruta_img` varchar(125) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Hamburguesa 1',4.99,'Hamburguesa','2021.06.13.20.13.22.jpg'),(2,'Hamburguesa 2',5.99,'Hamburguesa','2021.06.13.20.13.40.jpg'),(3,'Hamburguesa 3',5.99,'Hamburguesa','2021.06.13.20.14.04.jpg'),(4,'Hamburguesa 4',5.99,'Hamburguesa','2021.06.13.20.14.20.jpg'),(5,'Hamburguesa 5',5.99,'Hamburguesa','2021.06.13.20.14.33.jpg'),(6,'Coca cola 30cl',0.99,'Bebida','2021.06.13.20.14.56.jpg'),(7,'Agua 50cl',1.5,'Bebida','2021.06.13.20.15.18.jpg'),(8,'Fanta 30cl',1.99,'Bebida','2021.06.13.20.15.35.jpg'),(9,'Nestea 30cl',0.99,'Bebida','2021.06.13.20.15.52.jpg'),(10,'Sprite 30cl',1.99,'Bebida','2021.06.13.20.16.18.jpg'),(11,'Patatas deluxe',1.99,'Patatas','2021.06.13.20.16.35.png'),(12,'Patatas rizos',0.99,'Patatas','2021.06.13.20.16.49.jpg'),(13,'Patatas classic',0.99,'Patatas','2021.06.13.20.17.01.jpg'),(14,'Menu1',6.99,'Menu','2021.06.13.20.18.27.png'),(15,'Menu 2',7.99,'Menu','2021.06.13.20.18.45.jpg'),(16,'Menu 3',8.99,'Menu','2021.06.13.20.19.03.jpg'),(17,'Menu 4',9.99,'Menu','2021.06.13.20.19.24.jpg');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-16  0:16:37
