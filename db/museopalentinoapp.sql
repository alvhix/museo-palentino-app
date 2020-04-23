-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 24-10-2019 a las 12:13:26
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.19-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Uh1tfliSvm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `numIdentificacion` int(10) UNSIGNED NOT NULL,
  `numSeguridadSocial` bigint(11) DEFAULT NULL,
  `tipo` char(14) DEFAULT 'Administrador',
  `dniAdministrador` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`numIdentificacion`, `numSeguridadSocial`, `tipo`, `dniAdministrador`) VALUES
(2, 1111111, 'Administrador', '12345678g');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(10) UNSIGNED NOT NULL,
  `dniCliente` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `dniCliente`) VALUES
(6, '01010300W'),
(9, '05930011J'),
(7, '53114937W'),
(8, '55647074T');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `numeroEntrada` int(10) UNSIGNED NOT NULL,
  `fechaReserva` date NOT NULL,
  `hora` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `guiada` tinyint(1) UNSIGNED NOT NULL DEFAULT '0',
  `precio` float NOT NULL DEFAULT '6.85',
  `suplementoGuia` float DEFAULT '4.95',
  `idCliente` int(10) UNSIGNED NOT NULL,
  `fechaTransaccion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`numeroEntrada`, `fechaReserva`, `hora`, `guiada`, `precio`, `suplementoGuia`, `idCliente`) VALUES
(98, '2019-06-21', '12:00', 0, 6.85, 4.95, 7),
(99, '2019-06-23', '8:00', 1, 11.8, 4.95, 8),
(100, '2019-10-23', '8:00', 0, 6.85, 4.95, 8),
(101, '2019-06-22', '18:00', 0, 6.85, 4.95, 7),
(102, '2019-06-21', '12:00', 1, 11.8, 4.95, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exposicion`
--

CREATE TABLE `exposicion` (
  `idExposicion` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tiempoRecorrido` int(10) UNSIGNED NOT NULL,
  `imagen` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `exposicion`
--

INSERT INTO `exposicion` (`idExposicion`, `nombre`, `tiempoRecorrido`, `imagen`) VALUES
(1, 'Temporal', 30, 'recursos/imagenes/exposiciones/temporal.png'),
(2, 'Permanente', 30, 'recursos/imagenes/exposiciones/permanente.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia`
--

CREATE TABLE `guia` (
  `numIdentificacion` int(10) UNSIGNED NOT NULL,
  `numGuia` int(10) UNSIGNED NOT NULL,
  `numSeguridadSocial` bigint(11) DEFAULT NULL,
  `tipo` char(14) DEFAULT 'Guía',
  `dniGuia` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `guia`
--

INSERT INTO `guia` (`numIdentificacion`, `numGuia`, `numSeguridadSocial`, `tipo`, `dniGuia`) VALUES
(8, 1, 231245535388, 'Guía', '50164674H'),
(9, 2, 535367755511, 'Guía', '66552361K');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia_entrada`
--

CREATE TABLE `guia_entrada` (
  `numEntrada` int(10) UNSIGNED NOT NULL,
  `numGuia` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `guia_entrada`
--

INSERT INTO `guia_entrada` (`numEntrada`, `numGuia`) VALUES
(99, 1),
(102, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE `obra` (
  `idObra` int(10) UNSIGNED NOT NULL,
  `titulo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `estilo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `autor` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `año` varchar(20) NOT NULL,
  `tipo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'cuadro',
  `imagen` varchar(200) DEFAULT NULL,
  `idExposicion` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`idObra`, `titulo`, `estilo`, `autor`, `año`, `tipo`, `imagen`, `idExposicion`) VALUES
(24, 'El Grito', 'Expresionismo', 'Edvard Munch', '1893', 'Cuadro', 'recursos/imagenes/obras/elgrito.jpg', 1),
(25, 'La Gioconda', 'Renacimiento', 'Leonardo da Vinci', '1503', 'Cuadro', 'recursos/imagenes/obras/gioconda.jpg', 1),
(26, 'Guernica', 'Cubismo', 'Pablo Picasso', '1937', 'Cuadro', 'recursos/imagenes/obras/guernica.jpg', 2),
(27, 'La ultima cena', 'Renacimiento', 'Leonardo da Vinci', '1495', 'Cuadro', 'recursos/imagenes/obras/ultimacena.jpg', 1),
(28, 'La noche estrellada', 'Impresionismo', 'Vincent van Gogh', '1889', 'Cuadro', 'recursos/imagenes/obras/nocheestrellada.jpg', 1),
(29, 'La persistencia de la memoria', 'Surrealismo', 'Salvador Dali', '1931', 'Cuadro', 'recursos/imagenes/obras/memoria.jpg', 2),
(30, 'La ronda de noche', 'Barroco', 'Rembrandt', '1642', 'Cuadro', 'recursos/imagenes/obras/rondanoche.jpg', 1),
(31, 'Las meninas', 'Barroco', 'Diego Velazquez', '1656', 'Cuadro', 'recursos/imagenes/obras/meninas.jpg', 2),
(32, 'El jardin de las delicias', 'Pintura flamenca', 'El Bosco', '1505', 'Cuadro', 'recursos/imagenes/obras/jardindelicias.jpg', 2),
(33, 'La joven de la perla', 'Barroco', 'Johannes Vermeer', '1667', 'Cuadro', 'recursos/imagenes/obras/jovenperla.jpg', 1),
(34, 'El nacimiento de Venus', 'Renacimiento', 'Sandro Botticelli', '1486', 'Cuadro', 'recursos/imagenes/obras/nacimientovenus.jpg', 2),
(35, 'El beso', 'Simbolismo', 'Gustav Klimt', '1908', 'Cuadro', 'recursos/imagenes/obras/elbesoKlimt.jpg', 1),
(36, 'Discobolo', 'Griego Clasico', 'Miron', '460 a.C. - 450 a.C.', 'Escultura', 'recursos/imagenes/obras/discobolo.jpg', 2),
(37, 'El pensador', 'Impresionismo', 'Auguste Rodin', '1904', 'Escultura', 'recursos/imagenes/obras/pensador.jpg', 2),
(38, 'Venus de Milo', 'Helenista', 'Alejandro de Antioquia', '130 a.C. - 100 a.C.', 'Escultura', 'recursos/imagenes/obras/venusmilo.jpg', 2),
(39, 'El David', 'Renacimiento italiano', 'Miguel Angel', '1504', 'Escultura', 'recursos/imagenes/obras/david.jpg', 2),
(40, 'Extasis de la beata Ludovica', 'Barroco', 'Gian Lorenzo Bernini', '1674', 'Escultura', 'recursos/imagenes/obras/extasisludovica.jpg', 2),
(41, 'Apolo y Dafne', 'Barroco', 'Gian Lorenzo Bernini', '1625', 'Escultura', 'recursos/imagenes/obras/apolodafne.jpg', 2),
(42, 'El rapto de Proserpina', 'Barroco', 'Gian Lorenzo Bernini', '1622', 'Escultura', 'recursos/imagenes/obras/proserpina.jpg', 2),
(43, 'Moises', 'Renacimiento', 'Miguel Angel', '1515', 'Escultura', 'recursos/imagenes/obras/moises.jpg', 2),
(44, 'Cristo Velado', 'Barroco', 'Giuseppe Sanmartino', '1753', 'Escultura', 'recursos/imagenes/obras/cristovelado.jpg', 1),
(45, 'El beso', 'Realismo', 'Auguste Rodin', '1889', 'Escultura', 'recursos/imagenes/obras/elbesoRodin.jpg', 2),
(46, 'Perseo con la cabeza de Medusa', 'Manierismo', 'Benvenuto Cellini', '1554', 'Escultura', 'recursos/imagenes/obras/perseomedusa.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `dni` varchar(9) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `nombre` char(50) NOT NULL,
  `telefono` int(10) UNSIGNED DEFAULT NULL,
  `rol` char(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`dni`, `clave`, `nombre`, `telefono`, `rol`) VALUES
('01010300W', 'cefd62a6a14f4ad5feb65a471e646c7171a44cb8', 'Pedro Antonio', 678543256, 'cliente'),
('05930011J', '04ca87e04fe9fe188e4605db6f777ef4ddb47bb5', 'María López', 967443662, 'cliente'),
('12345678g', '7c222fb2927d828af22f592134e8932480637c0d', 'Guillermio', 989000000, 'administrador'),
('50164674H', '9c520b31899b14dff49f25fbe90e8c2136ef0da9', 'Iván Gonzalez', 979332032, 'guia'),
('53114937W', '929469a83455ec76fc403907f519f7afe0d1033a', 'Jon', 623459848, 'cliente'),
('55647074T', '01b677f8b34e8078dba20f446b7c646bb0bf14c5', 'Victor', 979889333, 'cliente'),
('66552361K', '0148d48cdfb71b2ec7101d02dd6e99710decb9ab', 'Elena Martinez', 978432266, 'guia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`numIdentificacion`),
  ADD UNIQUE KEY `numIdentificacion_UNIQUE` (`numIdentificacion`),
  ADD UNIQUE KEY `dniAdministrador_UNIQUE` (`dniAdministrador`),
  ADD KEY `dniAdministrador_fk1` (`dniAdministrador`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  ADD UNIQUE KEY `dniCliente_UNIQUE` (`dniCliente`),
  ADD KEY `dniCliente_idx` (`dniCliente`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`numeroEntrada`),
  ADD UNIQUE KEY `numeroentrada_UNIQUE` (`numeroEntrada`),
  ADD KEY `idCliente_idx` (`idCliente`) USING BTREE;

--
-- Indices de la tabla `exposicion`
--
ALTER TABLE `exposicion`
  ADD PRIMARY KEY (`idExposicion`),
  ADD UNIQUE KEY `idExposicion_UNIQUE` (`idExposicion`);

--
-- Indices de la tabla `guia`
--
ALTER TABLE `guia`
  ADD PRIMARY KEY (`numIdentificacion`),
  ADD UNIQUE KEY `numGuia_UNIQUE` (`numGuia`),
  ADD UNIQUE KEY `numIdentificacion_UNIQUE` (`numIdentificacion`),
  ADD UNIQUE KEY `dniGuia_UNIQUE` (`dniGuia`),
  ADD KEY `dni_idx` (`dniGuia`);

--
-- Indices de la tabla `guia_entrada`
--
ALTER TABLE `guia_entrada`
  ADD PRIMARY KEY (`numEntrada`),
  ADD UNIQUE KEY `numEntrada` (`numEntrada`),
  ADD KEY `numIdGuia_fk` (`numGuia`) USING BTREE;

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`idObra`),
  ADD UNIQUE KEY `idObra_UNIQUE` (`idObra`),
  ADD KEY `idExposicion_fk2` (`idExposicion`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`dni`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `numIdentificacion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `numeroEntrada` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT de la tabla `exposicion`
--
ALTER TABLE `exposicion`
  MODIFY `idExposicion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `guia`
--
ALTER TABLE `guia`
  MODIFY `numIdentificacion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `obra`
--
ALTER TABLE `obra`
  MODIFY `idObra` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `dniAdministrador_fk1` FOREIGN KEY (`dniAdministrador`) REFERENCES `persona` (`dni`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `dniCliente_fk1` FOREIGN KEY (`dniCliente`) REFERENCES `persona` (`dni`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `idCliente_fk1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `guia`
--
ALTER TABLE `guia`
  ADD CONSTRAINT `dniGuia_fk1` FOREIGN KEY (`dniGuia`) REFERENCES `persona` (`dni`);

--
-- Filtros para la tabla `guia_entrada`
--
ALTER TABLE `guia_entrada`
  ADD CONSTRAINT `numEntrada_fk` FOREIGN KEY (`numEntrada`) REFERENCES `entrada` (`numeroentrada`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `numGuia_fk` FOREIGN KEY (`numGuia`) REFERENCES `guia` (`numguia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `idExposicion_fk2` FOREIGN KEY (`idExposicion`) REFERENCES `exposicion` (`idexposicion`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
