CREATE DATABASE  IF NOT EXISTS `2cyglotepa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `2cyglotepa`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: 2cyglotepa
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrador` (
  `numIdentificacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numSeguridadSocial` bigint(11) DEFAULT NULL,
  `tipo` char(14) DEFAULT 'Administrador',
  `dniAdministrador` varchar(9) NOT NULL,
  `nombreMuseo` char(50) NOT NULL,
  PRIMARY KEY (`numIdentificacion`),
  UNIQUE KEY `numIdentificacion_UNIQUE` (`numIdentificacion`),
  UNIQUE KEY `dniAdministrador_UNIQUE` (`dniAdministrador`),
  KEY `dniAdministrador_fk1` (`dniAdministrador`),
  KEY `nombreMuseo_idx` (`nombreMuseo`),
  CONSTRAINT `dniAdministrador_fk1` FOREIGN KEY (`dniAdministrador`) REFERENCES `persona` (`dni`),
  CONSTRAINT `nombreMuseo_fk1` FOREIGN KEY (`nombreMuseo`) REFERENCES `museo` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (2,1111111,'Administrador','12345678g','Museo Palentino');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `idCliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tarjeta` bigint(20) unsigned DEFAULT NULL,
  `dniCliente` varchar(9) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  UNIQUE KEY `dniCliente_UNIQUE` (`dniCliente`),
  KEY `dniCliente_idx` (`dniCliente`),
  CONSTRAINT `dniCliente_fk1` FOREIGN KEY (`dniCliente`) REFERENCES `persona` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,NULL,'71970430a'),(4,NULL,'11111111I'),(5,NULL,'71955241v'),(6,NULL,'01010300W');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `entrada` (
  `numeroEntrada` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fechaReserva` date NOT NULL,
  `hora` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `guiada` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `precio` float NOT NULL DEFAULT '6.85',
  `suplementoGuia` float DEFAULT '4.95',
  `idCliente` int(10) unsigned NOT NULL,
  `fechaTransaccion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`numeroEntrada`),
  UNIQUE KEY `numeroentrada_UNIQUE` (`numeroEntrada`),
  KEY `idCliente_idx` (`idCliente`) USING BTREE,
  CONSTRAINT `idCliente_fk1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (50,'2019-06-15','8:00',1,11.8,4.95,3,'2019-06-17 19:33:22'),(51,'2019-06-23','16:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(53,'2019-06-23','16:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(54,'2019-06-13','16:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(55,'2019-06-29','16:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(56,'2019-06-22','12:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(57,'2019-06-02','16:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(58,'2019-06-15','8:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(59,'2019-06-12','10:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(60,'2019-06-16','12:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(61,'2019-06-18','14:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(62,'2019-06-21','16:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(63,'2019-06-29','18:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(64,'2019-06-30','8:00',1,11.8,4.95,6,'2019-06-17 19:33:22'),(65,'2019-06-15','8:00',0,6.85,4.95,6,'2019-06-17 19:33:22'),(66,'2019-06-23','8:00',0,6.85,4.95,6,'2019-06-17 19:33:22');
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exposicion`
--

DROP TABLE IF EXISTS `exposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exposicion` (
  `idExposicion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` char(50) NOT NULL,
  `duracion` date DEFAULT NULL,
  `tiempoRecorrido` int(10) unsigned NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idExposicion`),
  UNIQUE KEY `idExposicion_UNIQUE` (`idExposicion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exposicion`
--

LOCK TABLES `exposicion` WRITE;
/*!40000 ALTER TABLE `exposicion` DISABLE KEYS */;
INSERT INTO `exposicion` VALUES (1,'Temporal','2000-01-20',30,'src/recursos/imagenes/exposiciones/temporal.png'),(2,'Permanente',NULL,30,'src/recursos/imagenes/exposiciones/permanente.png');
/*!40000 ALTER TABLE `exposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exposicion_obra`
--

DROP TABLE IF EXISTS `exposicion_obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exposicion_obra` (
  `idObra` int(10) unsigned NOT NULL,
  `idExposicion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idObra`),
  KEY `idExposicion_idx` (`idExposicion`),
  CONSTRAINT `idExposicion_fk1` FOREIGN KEY (`idExposicion`) REFERENCES `exposicion` (`idExposicion`),
  CONSTRAINT `idObra_fk1` FOREIGN KEY (`idObra`) REFERENCES `obra` (`idObra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exposicion_obra`
--

LOCK TABLES `exposicion_obra` WRITE;
/*!40000 ALTER TABLE `exposicion_obra` DISABLE KEYS */;
INSERT INTO `exposicion_obra` VALUES (24,1),(25,1),(27,1),(28,1),(30,1),(33,1),(35,1),(44,1),(46,1),(26,2),(29,2),(31,2),(32,2),(34,2),(36,2),(37,2),(38,2),(39,2),(40,2),(41,2),(42,2),(43,2),(45,2);
/*!40000 ALTER TABLE `exposicion_obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia`
--

DROP TABLE IF EXISTS `guia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `guia` (
  `numIdentificacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numGuia` int(10) unsigned NOT NULL,
  `numSeguridadSocial` bigint(11) DEFAULT NULL,
  `tipo` char(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'guia',
  `dniGuia` varchar(9) NOT NULL,
  PRIMARY KEY (`numIdentificacion`),
  UNIQUE KEY `numGuia_UNIQUE` (`numGuia`),
  UNIQUE KEY `dniGuia_UNIQUE` (`dniGuia`),
  UNIQUE KEY `numIdentificacion_UNIQUE` (`numIdentificacion`),
  KEY `dni_idx` (`dniGuia`),
  CONSTRAINT `dniGuia_fk1` FOREIGN KEY (`dniGuia`) REFERENCES `persona` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia`
--

LOCK TABLES `guia` WRITE;
/*!40000 ALTER TABLE `guia` DISABLE KEYS */;
INSERT INTO `guia` VALUES (1,1,1112223334,'guia','45612378x'),(2,2,123456789,'guia','87654321A'),(3,3,111111111,'guia','44444444e');
/*!40000 ALTER TABLE `guia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia_cliente`
--

DROP TABLE IF EXISTS `guia_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `guia_cliente` (
  `idCliente` int(10) unsigned NOT NULL,
  `numGuia` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  KEY `idCliente_fk2` (`idCliente`),
  KEY `numeroGuia_fk1` (`numGuia`),
  CONSTRAINT `idCliente_fk2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `numeroGuia_fk1` FOREIGN KEY (`numGuia`) REFERENCES `guia` (`numGuia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia_cliente`
--

LOCK TABLES `guia_cliente` WRITE;
/*!40000 ALTER TABLE `guia_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museo`
--

DROP TABLE IF EXISTS `museo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `museo` (
  `nombre` char(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museo`
--

LOCK TABLES `museo` WRITE;
/*!40000 ALTER TABLE `museo` DISABLE KEYS */;
INSERT INTO `museo` VALUES ('Museo Palentino','calle guillermina');
/*!40000 ALTER TABLE `museo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museo_exposicion`
--

DROP TABLE IF EXISTS `museo_exposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `museo_exposicion` (
  `idExposicion` int(10) unsigned NOT NULL,
  `nombreMuseo` char(50) NOT NULL,
  PRIMARY KEY (`idExposicion`),
  KEY `nombreMuseo_idx` (`nombreMuseo`),
  CONSTRAINT `idExposicion_fk2` FOREIGN KEY (`idExposicion`) REFERENCES `exposicion` (`idExposicion`),
  CONSTRAINT `nombreMuseo_fk2` FOREIGN KEY (`nombreMuseo`) REFERENCES `museo` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museo_exposicion`
--

LOCK TABLES `museo_exposicion` WRITE;
/*!40000 ALTER TABLE `museo_exposicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `museo_exposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra`
--

DROP TABLE IF EXISTS `obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `obra` (
  `idObra` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` char(45) NOT NULL,
  `estilo` char(45) DEFAULT NULL,
  `autor` char(45) NOT NULL,
  `año` varchar(20) NOT NULL,
  `tipo` char(45) DEFAULT 'cuadro',
  `imagen` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idObra`),
  UNIQUE KEY `idObra_UNIQUE` (`idObra`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra`
--

LOCK TABLES `obra` WRITE;
/*!40000 ALTER TABLE `obra` DISABLE KEYS */;
INSERT INTO `obra` VALUES (24,'El Grito','Expresionismo','Edvard Munch','1893','Cuadro','src/recursos/imagenes/obras/elgrito.jpg'),(25,'La Gioconda','Renacimiento','Leonardo da Vinci','1503','Cuadro','src/recursos/imagenes/obras/gioconda.jpg'),(26,'Guernica','Cubismo','Pablo Picasso','1937','Cuadro','src/recursos/imagenes/obras/guernica.jpg'),(27,'La ultima cena','Renacimiento','Leonardo da Vinci','1495','Cuadro','src/recursos/imagenes/obras/ultimacena.jpg'),(28,'La noche estrellada','Impresionismo','Vincent van Gogh','1889','Cuadro','src/recursos/imagenes/obras/nocheestrellada.jpg'),(29,'La persistencia de la memoria','Surrealismo','Salvador Dali','1931','Cuadro','src/recursos/imagenes/obras/memoria.jpg'),(30,'La ronda de noche','Barroco','Rembrandt','1642','Cuadro','src/recursos/imagenes/obras/rondanoche.jpg'),(31,'Las meninas','Barroco','Diego Velazquez','1656','Cuadro','src/recursos/imagenes/obras/meninas.jpg'),(32,'El jardin de las delicias','Pintura flamenca','El Bosco','1505','Cuadro','src/recursos/imagenes/obras/jardindelicias.jpg'),(33,'La joven de la perla','Barroco','Johannes Vermeer','1667','Cuadro','src/recursos/imagenes/obras/jovenperla.jpg'),(34,'El nacimiento de Venus','Renacimiento','Sandro Botticelli','1486','Cuadro','src/recursos/imagenes/obras/nacimientovenus.jpg'),(35,'El beso','Simbolismo','Gustav Klimt','1908','Cuadro','src/recursos/imagenes/obras/elbesoKlimt.jpg'),(36,'Discobolo','Griego Clasico','Miron','460 a.C. - 450 a.C.','Escultura','src/recursos/imagenes/obras/discobolo.jpg'),(37,'El pensador','Impresionismo','Auguste Rodin','1904','Escultura','src/recursos/imagenes/obras/pensador.jpg'),(38,'Venus de Milo','Helenista','Alejandro de Antioquia','130 a.C. - 100 a.C.','Escultura','src/recursos/imagenes/obras/venusmilo.jpg'),(39,'El David','Renacimiento italiano','Miguel Angel','1504','Escultura','src/recursos/imagenes/obras/david.jpg'),(40,'Extasis de la beata Ludovica','Barroco','Gian Lorenzo Bernini','1674','Escultura','src/recursos/imagenes/obras/extasisludovica.jpg'),(41,'Apolo y Dafne','Barroco','Gian Lorenzo Bernini','1625','Escultura','src/recursos/imagenes/obras/apolodafne.jpg'),(42,'El rapto de Proserpina','Barroco','Gian Lorenzo Bernini','1622','Escultura','src/recursos/imagenes/obras/proserpina.jpg'),(43,'Moises','Renacimiento','Miguel Angel','1515','Escultura','src/recursos/imagenes/obras/moises.jpg'),(44,'Cristo Velado','Barroco','Giuseppe Sanmartino','1753','Escultura','src/recursos/imagenes/obras/cristovelado.jpg'),(45,'El beso','Realismo','Auguste Rodin','1889','Escultura','src/recursos/imagenes/obras/elbesoRodin.jpg'),(46,'Perseo con la cabeza de Medusa','Manierismo','Benvenuto Cellini','1554','Escultura','src/recursos/imagenes/obras/perseomedusa.jpg');
/*!40000 ALTER TABLE `obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `dni` varchar(9) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `nombre` char(50) NOT NULL,
  `telefono` int(10) unsigned DEFAULT NULL,
  `rol` char(14) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('01010300W','cefd62a6a14f4ad5feb65a471e646c7171a44cb8','Pedro Antonio',678543256,'cliente'),('11111111I','7c222fb2927d828af22f592134e8932480637c0d','Ivan',444444444,'cliente'),('12345678g','7c222fb2927d828af22f592134e8932480637c0d','Guillermio',989000000,'administrador'),('44444444e','7c222fb2927d828af22f592134e8932480637c0d','Sergio',555555555,'guia'),('45612378x','dfa094c6585106137a4e3aa979017d150abaa0b2','aaaaaaaa',987654321,'guia'),('45678912x','dfa094c6585106137a4e3aa979017d150abaa0b2','wonse',987654321,'guia'),('71955241v','dfa094c6585106137a4e3aa979017d150abaa0b2','caracol',965865123,'cliente'),('71970430a','7c222fb2927d828af22f592134e8932480637c0d','Victor',999999999,'cliente'),('87654321A','7c222fb2927d828af22f592134e8932480637c0d','Alvaro',333333,'guia');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17 22:28:12
