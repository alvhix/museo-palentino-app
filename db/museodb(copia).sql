-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 15-06-2019 a las 19:48:59
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `2CygLOTEPa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `numIdentificacion` int(10) UNSIGNED NOT NULL,
  `numSeguridadSocial` bigint(11) DEFAULT NULL,
  `tipo` char(14) DEFAULT 'Administrador',
  `dniAdministrador` varchar(9) NOT NULL,
  `nombreMuseo` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`numIdentificacion`, `numSeguridadSocial`, `tipo`, `dniAdministrador`, `nombreMuseo`) VALUES
(2, 1111111, 'Administrador', '12345678g', 'Museo Palentino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(10) UNSIGNED NOT NULL,
  `tarjeta` bigint(20) UNSIGNED DEFAULT NULL,
  `dniCliente` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `tarjeta`, `dniCliente`) VALUES
(3, NULL, '71970430a'),
(4, NULL, '11111111I'),
(5, NULL, '71955241v'),
(6, NULL, '01010300W');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `numeroEntrada` int(10) UNSIGNED NOT NULL,
  `fechaReserva` date NOT NULL,
  `hora` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `guiada` tinyint(1) UNSIGNED DEFAULT '0',
  `precio` float UNSIGNED NOT NULL DEFAULT '9.25',
  `suplementoGuia` float UNSIGNED NOT NULL DEFAULT '3.55',
  `idCliente` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exposicion`
--

CREATE TABLE `exposicion` (
  `idExposicion` int(10) UNSIGNED NOT NULL,
  `nombre` char(50) NOT NULL,
  `duracion` date DEFAULT NULL,
  `tiempoRecorrido` int(10) UNSIGNED NOT NULL,
  `imagen` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `exposicion`
--

INSERT INTO `exposicion` (`idExposicion`, `nombre`, `duracion`, `tiempoRecorrido`, `imagen`) VALUES
(1, 'Temporal', '2000-01-20', 30, 'src/recursos/imagenes/iconos/temporal.png'),
(2, 'Permanente', NULL, 30, 'src/recursos/imagenes/iconos/permanente.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exposicion_obra`
--

CREATE TABLE `exposicion_obra` (
  `idObra` int(10) UNSIGNED NOT NULL,
  `idExposicion` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `exposicion_obra`
--

INSERT INTO `exposicion_obra` (`idObra`, `idExposicion`) VALUES
(24, 1),
(25, 1),
(27, 1),
(28, 1),
(30, 1),
(33, 1),
(35, 1),
(44, 1),
(46, 1),
(26, 2),
(29, 2),
(31, 2),
(32, 2),
(34, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(45, 2);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `guia`
--

INSERT INTO `guia` (`numIdentificacion`, `numGuia`, `numSeguridadSocial`, `tipo`, `dniGuia`) VALUES
(1, 48, 111111111, 'guia', '44444444e'),
(2, 33, 123456789, 'guia', '87654321A'),
(3, 13, 1112223334, 'Guía', '45612378x');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia_entrada`
--

CREATE TABLE `guia_entrada` (
  `numeroEntrada` int(10) UNSIGNED NOT NULL,
  `numeroIdentificacion` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `museo`
--

CREATE TABLE `museo` (
  `nombre` char(50) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `museo`
--

INSERT INTO `museo` (`nombre`, `direccion`) VALUES
('Museo Palentino', 'calle guillermina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `museo_exposicion`
--

CREATE TABLE `museo_exposicion` (
  `idExposicion` int(10) UNSIGNED NOT NULL,
  `nombreMuseo` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE `obra` (
  `idObra` int(10) UNSIGNED NOT NULL,
  `titulo` char(45) NOT NULL,
  `estilo` char(45) DEFAULT NULL,
  `autor` char(45) NOT NULL,
  `año` varchar(20) NOT NULL,
  `tipo` char(45) DEFAULT 'cuadro',
  `imagen` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`idObra`, `titulo`, `estilo`, `autor`, `año`, `tipo`, `imagen`) VALUES
(24, 'El Grito', 'Expresionismo', 'Edvard Munch', '1893', 'Cuadro', 'src/recursos/imagenes/obras/elgrito.jpg'),
(25, 'La Gioconda', 'Renacimiento', 'Leonardo da Vinci', '1503', 'Cuadro', 'src/recursos/imagenes/obras/gioconda.jpg'),
(26, 'Guernica', 'Cubismo', 'Pablo Picasso', '1937', 'Cuadro', 'src/recursos/imagenes/obras/guernica.jpg'),
(27, 'La ultima cena', 'Renacimiento', 'Leonardo da Vinci', '1495', 'Cuadro', 'src/recursos/imagenes/obras/ultimacena.jpg'),
(28, 'La noche estrellada', 'Impresionismo', 'Vincent van Gogh', '1889', 'Cuadro', 'src/recursos/imagenes/obras/nocheestrellada.jpg'),
(29, 'La persistencia de la memoria', 'Surrealismo', 'Salvador Dali', '1931', 'Cuadro', 'src/recursos/imagenes/obras/memoria.jpg'),
(30, 'La ronda de noche', 'Barroco', 'Rembrandt', '1642', 'Cuadro', 'src/recursos/imagenes/obras/rondanoche.jpg'),
(31, 'Las meninas', 'Barroco', 'Diego Velazquez', '1656', 'Cuadro', 'src/recursos/imagenes/obras/meninas.jpg'),
(32, 'El jardin de las delicias', 'Pintura flamenca', 'El Bosco', '1505', 'Cuadro', 'src/recursos/imagenes/obras/jardindelicias.jpg'),
(33, 'La joven de la perla', 'Barroco', 'Johannes Vermeer', '1667', 'Cuadro', 'src/recursos/imagenes/obras/jovenperla.jpg'),
(34, 'El nacimiento de Venus', 'Renacimiento', 'Sandro Botticelli', '1486', 'Cuadro', 'src/recursos/imagenes/obras/nacimientovenus.jpg'),
(35, 'El beso', 'Simbolismo', 'Gustav Klimt', '1908', 'Cuadro', 'src/recursos/imagenes/obras/elbesoKlimt.jpg'),
(36, 'Discobolo', 'Griego Clasico', 'Miron', '460 a.C. - 450 a.C.', 'Escultura', 'src/recursos/imagenes/obras/discobolo.jpg'),
(37, 'El pensador', 'Impresionismo', 'Auguste Rodin', '1904', 'Escultura', 'src/recursos/imagenes/obras/pensador.jpg'),
(38, 'Venus de Milo', 'Helenista', 'Alejandro de Antioquia', '130 a.C. - 100 a.C.', 'Escultura', 'src/recursos/imagenes/obras/venusmilo.jpg'),
(39, 'El David', 'Renacimiento italiano', 'Miguel Angel', '1504', 'Escultura', 'src/recursos/imagenes/obras/david.jpg'),
(40, 'Extasis de la beata Ludovica', 'Barroco', 'Gian Lorenzo Bernini', '1674', 'Escultura', 'src/recursos/imagenes/obras/extasisludovica.jpg'),
(41, 'Apolo y Dafne', 'Barroco', 'Gian Lorenzo Bernini', '1625', 'Escultura', 'src/recursos/imagenes/obras/apolodafne.jpg'),
(42, 'El rapto de Proserpina', 'Barroco', 'Gian Lorenzo Bernini', '1622', 'Escultura', 'src/recursos/imagenes/obras/proserpina.jpg'),
(43, 'Moises', 'Renacimiento', 'Miguel Angel', '1515', 'Escultura', 'src/recursos/imagenes/obras/moises.jpg'),
(44, 'Cristo Velado', 'Barroco', 'Giuseppe Sanmartino', '1753', 'Escultura', 'src/recursos/imagenes/obras/cristovelado.jpg'),
(45, 'El beso', 'Realismo', 'Auguste Rodin', '1889', 'Escultura', 'src/recursos/imagenes/obras/elbesoRodin.jpg'),
(46, 'Perseo con la cabeza de Medusa', 'Manierismo', 'Benvenuto Cellini', '1554', 'Escultura', 'src/recursos/imagenes/obras/perseomedusa.jpg');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`dni`, `clave`, `nombre`, `telefono`, `rol`) VALUES
('01010300W', 'cefd62a6a14f4ad5feb65a471e646c7171a44cb8', 'Pedro Antonio', 678543256, 'cliente'),
('11111111I', '7c222fb2927d828af22f592134e8932480637c0d', 'Ivan', 444444444, 'cliente'),
('12345678g', '7c222fb2927d828af22f592134e8932480637c0d', 'Guillermio', 989000000, 'administrador'),
('44444444e', '7c222fb2927d828af22f592134e8932480637c0d', 'Sergio', 555555555, 'guia'),
('45612378x', 'dfa094c6585106137a4e3aa979017d150abaa0b2', 'aaaaaaaa', 987654321, 'guia'),
('45678912x', 'dfa094c6585106137a4e3aa979017d150abaa0b2', 'wonse', 987654321, 'guia'),
('71955241v', 'dfa094c6585106137a4e3aa979017d150abaa0b2', 'caracol', 965865123, 'cliente'),
('71970430a', '7c222fb2927d828af22f592134e8932480637c0d', 'Victor', 999999999, 'cliente'),
('87654321A', '7c222fb2927d828af22f592134e8932480637c0d', 'Alvaro', 333333, 'guia');

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
  ADD KEY `dniAdministrador_fk1` (`dniAdministrador`),
  ADD KEY `nombreMuseo_idx` (`nombreMuseo`);

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
-- Indices de la tabla `exposicion_obra`
--
ALTER TABLE `exposicion_obra`
  ADD PRIMARY KEY (`idObra`),
  ADD KEY `idExposicion_idx` (`idExposicion`);

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
  ADD PRIMARY KEY (`numeroEntrada`),
  ADD KEY `numeroIdentificacion_idx` (`numeroIdentificacion`);

--
-- Indices de la tabla `museo`
--
ALTER TABLE `museo`
  ADD PRIMARY KEY (`nombre`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `museo_exposicion`
--
ALTER TABLE `museo_exposicion`
  ADD PRIMARY KEY (`idExposicion`),
  ADD KEY `nombreMuseo_idx` (`nombreMuseo`);

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`idObra`),
  ADD UNIQUE KEY `idObra_UNIQUE` (`idObra`);

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
  MODIFY `idCliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `numeroEntrada` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `exposicion`
--
ALTER TABLE `exposicion`
  MODIFY `idExposicion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `guia`
--
ALTER TABLE `guia`
  MODIFY `numIdentificacion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `obra`
--
ALTER TABLE `obra`
  MODIFY `idObra` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `dniAdministrador_fk1` FOREIGN KEY (`dniAdministrador`) REFERENCES `persona` (`dni`),
  ADD CONSTRAINT `nombreMuseo_fk1` FOREIGN KEY (`nombreMuseo`) REFERENCES `museo` (`nombre`);

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
-- Filtros para la tabla `exposicion_obra`
--
ALTER TABLE `exposicion_obra`
  ADD CONSTRAINT `idExposicion_fk1` FOREIGN KEY (`idExposicion`) REFERENCES `exposicion` (`idexposicion`),
  ADD CONSTRAINT `idObra_fk1` FOREIGN KEY (`idObra`) REFERENCES `obra` (`idobra`);

--
-- Filtros para la tabla `guia`
--
ALTER TABLE `guia`
  ADD CONSTRAINT `dniGuia_fk1` FOREIGN KEY (`dniGuia`) REFERENCES `persona` (`dni`);

--
-- Filtros para la tabla `guia_entrada`
--
ALTER TABLE `guia_entrada`
  ADD CONSTRAINT `numeroEntrada_fk` FOREIGN KEY (`numeroEntrada`) REFERENCES `entrada` (`numeroentrada`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `numeroIdentificacionGuia_fk` FOREIGN KEY (`numeroIdentificacion`) REFERENCES `guia` (`numidentificacion`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `museo_exposicion`
--
ALTER TABLE `museo_exposicion`
  ADD CONSTRAINT `idExposicion_fk2` FOREIGN KEY (`idExposicion`) REFERENCES `exposicion` (`idexposicion`),
  ADD CONSTRAINT `nombreMuseo_fk2` FOREIGN KEY (`nombreMuseo`) REFERENCES `museo` (`nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
