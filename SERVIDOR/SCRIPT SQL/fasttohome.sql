-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2022 a las 02:54:06
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fasttohome`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarEstadoPedido` (IN `estado` VARCHAR(30), IN `id_pedido` INT(10))   BEGIN

DECLARE estadoSiguiente varchar(30);
CASE estado
    when 'pendiente_pago' then
        SET estadoSiguiente = 'pagado';
       when 'pagado' then
        SET estadoSiguiente = 'en_preparacion';
    when 'en_preparacion' then
        SET estadoSiguiente = 'enviando';
    when 'enviando' then
        SET estadoSiguiente = 'recibido';
    END CASE;
       UPDATE pedido SET estado = estadoSiguiente WHERE id = id_pedido;
END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `totalPrecioPedido` (`id_ped` INT) RETURNS DOUBLE(10,2)  BEGIN

DECLARE totalProducto double(10,2);
SET totalProducto = (SELECT SUM(c.cantidad * prod.precio) FROM cesta c INNER JOIN producto prod ON c.id_producto = prod.id
WHERE c.id_pedido = id_ped);

RETURN totalProducto;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_negocio`
--

CREATE TABLE `categoria_negocio` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria_negocio`
--

INSERT INTO `categoria_negocio` (`id`, `Nombre`) VALUES
(1, 'Panaderia'),
(2, 'Farmacia'),
(3, 'Alimento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cesta`
--

CREATE TABLE `cesta` (
  `id` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cesta`
--

INSERT INTO `cesta` (`id`, `Cantidad`, `id_pedido`, `id_producto`) VALUES
(17, 4, 20, 29),
(18, 2, 21, 40),
(19, 1, 21, 29),
(20, 6, 22, 29),
(21, 17, 23, 40),
(22, 7, 23, 29),
(23, 2, 24, 29),
(24, 3, 25, 40),
(25, 4, 25, 29),
(26, 2, 26, 42),
(27, 2, 27, 42),
(28, 12, 28, 42),
(29, 4, 29, 42),
(30, 1, 30, 42);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `id` int(11) NOT NULL,
  `Calle` varchar(70) NOT NULL,
  `Numero` int(4) NOT NULL,
  `Ciudad` varchar(60) NOT NULL,
  `CP` int(10) NOT NULL,
  `Otros` varchar(150) DEFAULT NULL,
  `Coordenadas` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`id`, `Calle`, `Numero`, `Ciudad`, `CP`, `Otros`, `Coordenadas`) VALUES
(1, '22', 23, 'fadsfdfa', 23, '22tcde', ' '),
(23, 'Pedro', 15, 'Villanueva', 3455, 'No dejen la puerta abierta', '4'),
(24, 'Pizarro', 4, 'Zafra', 1234, 'puerta con verja', '5'),
(25, 'Pizarro', 6, 'Villanueva', 9876, 'Cuidado con el perro', '34'),
(26, 'Simon', 56, 'La Haba', 3456, 'Cerrar la puerta al salir', '45'),
(27, 'Beneficio', 45, 'Campanario', 6439, 'Casa con patio', '0'),
(28, 'Nueva Plaza', 23, 'Castuera', 12345, '', '0'),
(29, 'Buendia', 89, 'Campanario', 98765, 'Fachada verde y blanca', '0'),
(30, 'Buendia', 70, 'Campanario', 45673, 'Tejado rojo', '0'),
(31, 'Buendia', 70, 'Campanario', 45673, 'Tejado rojo', '0'),
(32, 'Ancha', 56, 'Lobón', 23456, 'Fachada azul y gris', '0'),
(33, 'Porro', 45, 'Almendralejo', 45678, 'Puerta gris', '0'),
(34, 'La Maritima', 67, 'Huelva', 89065, 'Patio al aire libre', '0'),
(35, 'San Jose', 13, 'La Guarda', 67845, 'Casa beis', '0'),
(36, 'Plaza España', 27, 'Zalamea', 4292, 'Casa con patio', '0'),
(37, 'San Pedro', 30, 'Caceres', 97578, 'Balcón amplio', '0'),
(38, 'Beneficio', 46, 'Zalamea', 14598, 'Puerta azul con patio', '0'),
(39, 'Hierro', 12, 'Merida', 29345, 'Sin balcon, cuarto piso', '0'),
(40, 'Miraver', 8, 'Lobon', 65423, 'Cruz significativa de farmacia con luces rojas', '0'),
(41, 'Castañeda', 2, 'Los Vinos', 76345, 'Puerta verde, casa gris', '0'),
(42, 'El Mochuelo', 24, 'Caceres', 92105, 'Casa gris con puerta roja', '0'),
(43, 'Hernandez', 12, 'Zalamea', 52849, 'Casa de aspecto romano con patio', '0'),
(44, 'La Botica', 61, 'Guareña', 25720, 'Edificio con ventanas azules y tejado de madera', '0'),
(45, 'la corte 3', 34, 'Don Benito', 6400, 'paco', NULL),
(46, 'la corte 3', 34, 'Don Benito', 6400, 'paco', NULL),
(47, 'la corte 3', 34, 'Don Benito', 6400, 'paco', NULL),
(48, 'la corte 3', 34, 'Don Benito', 6400, 'paco', NULL),
(49, '3243', 34, 'Don Benito', 6400, 'asdf', ' '),
(50, '3243', 34, 'Don Benito', 6400, 'asdf', ' '),
(51, 'La corte', 3, 'Don Benito', 6400, 'asfsdf', ' '),
(52, 'La corte', 3, 'Don Benito', 6400, 'asfsdf', ' '),
(53, 'La corte', 3, 'Don Benito', 6400, 'asfsdf', ' '),
(54, 'la corte', 3, 'Don Benito', 6400, 'asdf', '38.9605433,-5.877255'),
(55, 'la corte', 3, 'Don benito', 6400, 'sdrsert', '38.9585582,-5.871525'),
(56, 'La cuesta', 23, 'Don Benito', 6400, 'Bajo', '38.9555367,-5.8616133'),
(57, 'la corte', 34, 'Don Benito', 6400, 'askdfj', '38.955537, -5.861613');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagenes`
--

CREATE TABLE `imagenes` (
  `id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `imagenes`
--

INSERT INTO `imagenes` (`id`, `url`) VALUES
(1, 'imagenes/1653505188141.png'),
(2, 'imagenes/1653822609277.png'),
(3, 'imagenes/1653899892667.png'),
(4, 'imagenes/1653901531592.png'),
(5, 'imagenes/1653901923878.png'),
(6, 'imagenes/1654455453129.png'),
(7, 'imagenes/1654505890475.png'),
(8, 'imagenes/1654506190881.png'),
(9, 'imagenes/1654506304416.png'),
(10, 'imagenes/1654506725935.png'),
(11, 'imagenes/1654511063732.png'),
(12, 'imagenes/1654513202979.png'),
(13, 'imagenes/1654514581005.png'),
(14, 'imagenes/1654764357045.png'),
(15, 'imagenes/1654774014726.png'),
(16, 'imagenes/1654886476599.png'),
(17, 'imagenes/1655058407778.png'),
(18, 'imagenes/1655193484786.png'),
(19, 'imagenes/1655193627038.png'),
(20, 'imagenes/1655196140193.png'),
(21, 'imagenes/1655196695401.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `negocio`
--

CREATE TABLE `negocio` (
  `id` int(11) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_mercader` int(11) DEFAULT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `imagenes_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `negocio`
--

INSERT INTO `negocio` (`id`, `id_categoria`, `id_mercader`, `Nombre`, `Descripcion`, `direccion_id`, `imagenes_id`) VALUES
(1, 1, NULL, 'Negocio de prueba', 'Descripcion de prueba aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 1, 14),
(68, 1, 67, 'Negocio de prueba', 'Descripción de prueba', 55, 18),
(69, 3, 68, 'Ies donoso cortes', 'Insicituto', 57, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_negocio` int(11) DEFAULT NULL,
  `fecha_hora` datetime NOT NULL,
  `estado` enum('pendiente_pago','pagado','en_preparacion','enviando','recibido','incidencia') NOT NULL,
  `total` decimal(6,2) NOT NULL,
  `transporte` enum('repartidor','dron') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `id_usuario`, `id_negocio`, `fecha_hora`, `estado`, `total`, `transporte`) VALUES
(20, NULL, 1, '2022-06-13 02:30:32', 'recibido', '36.00', 'dron'),
(21, NULL, 1, '2022-06-13 08:36:32', 'en_preparacion', '693.00', 'dron'),
(22, NULL, 1, '2022-06-13 10:02:47', 'pagado', '54.00', 'dron'),
(23, NULL, 1, '2022-06-13 10:05:53', 'pagado', '5877.00', 'dron'),
(24, NULL, 1, '2022-06-13 10:28:52', 'recibido', '18.00', 'dron'),
(25, 67, 1, '2022-06-14 09:51:20', 'pagado', '1062.00', 'dron'),
(26, 67, 68, '2022-06-14 10:03:21', 'enviando', '2.68', 'dron'),
(27, 68, 68, '2022-06-14 10:36:56', 'recibido', '2.68', 'dron'),
(28, 67, 68, '2022-06-14 14:39:25', 'enviando', '16.08', 'dron'),
(29, 67, 68, '2022-06-14 14:52:43', 'enviando', '5.36', 'dron'),
(30, 67, 68, '2022-06-14 22:00:27', 'pagado', '1.34', 'dron');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `id_negocio` int(11) DEFAULT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Precio` decimal(5,2) NOT NULL,
  `Descripcion` varchar(150) NOT NULL,
  `Stock` int(11) NOT NULL,
  `imagenes_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `id_negocio`, `Nombre`, `Precio`, `Descripcion`, `Stock`, `imagenes_id`) VALUES
(29, 1, 'Pan BIMBO', '9.00', 'Rico pangsdfgsdg', 0, 2),
(40, 1, 'sdfg', '342.00', 'sdgh', 0, 16),
(42, 68, 'Paracetamol', '1.34', 'asfaer', 0, 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `Dni` varchar(9) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `tlf` int(11) NOT NULL,
  `Rol` enum('cliente','mercader','admin') NOT NULL,
  `password` varchar(100) NOT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `imagenes_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Nombre`, `apellidos`, `Dni`, `Email`, `tlf`, `Rol`, `password`, `direccion_id`, `imagenes_id`) VALUES
(67, 'Jose Miguel', 'Calderón De La Barca Gutiérrez', '08697351Q', 'jmcbg01@gmail.com', 644170867, 'mercader', '$2a$10$lyV.q5wzs5gJHaps4P22k.vKqSQJR9t0xdrEeBSV6wv6LRF8rhNiu', 54, NULL),
(68, 'Siso', 'Donoso Cortes', '08697451Q', 'mail@test.es', 644170866, 'admin', '$2a$10$lyV.q5wzs5gJHaps4P22k.vKqSQJR9t0xdrEeBSV6wv6LRF8rhNiu', 56, NULL),
(70, 'Jesus', 'Rueda', '0869wer1s', 'clientes@test.es', 644170867, 'cliente', '$2a$10$lyV.q5wzs5gJHaps4P22k.vKqSQJR9t0xdrEeBSV6wv6LRF8rhNiu', 54, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria_negocio`
--
ALTER TABLE `categoria_negocio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cesta`
--
ALTER TABLE `cesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pedido` (`id_pedido`,`id_producto`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `imagenes`
--
ALTER TABLE `imagenes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `url_UNIQUE` (`url`);

--
-- Indices de la tabla `negocio`
--
ALTER TABLE `negocio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_mercader` (`id_mercader`),
  ADD KEY `fk_negocio_direccion1_idx` (`direccion_id`),
  ADD KEY `fk_negocio_imagenes1_idx` (`imagenes_id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`,`id_negocio`),
  ADD KEY `id_negocio` (`id_negocio`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_negocio` (`id_negocio`),
  ADD KEY `fk_producto_imagenes1_idx` (`imagenes_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Dni` (`Dni`),
  ADD KEY `fk_usuarios_direccion1_idx` (`direccion_id`),
  ADD KEY `fk_usuarios_imagenes1_idx` (`imagenes_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria_negocio`
--
ALTER TABLE `categoria_negocio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cesta`
--
ALTER TABLE `cesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT de la tabla `imagenes`
--
ALTER TABLE `imagenes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `negocio`
--
ALTER TABLE `negocio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cesta`
--
ALTER TABLE `cesta`
  ADD CONSTRAINT `cesta_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `cesta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `negocio`
--
ALTER TABLE `negocio`
  ADD CONSTRAINT `fk_negocio_categoria_negocio1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria_negocio` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `fk_negocio_direccion1` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_negocio_imagenes1` FOREIGN KEY (`imagenes_id`) REFERENCES `imagenes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `negocio_ibfk_3` FOREIGN KEY (`id_mercader`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_negocio`) REFERENCES `negocio` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_imagenes1` FOREIGN KEY (`imagenes_id`) REFERENCES `imagenes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_negocio`) REFERENCES `negocio` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_direccion1` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuarios_imagenes1` FOREIGN KEY (`imagenes_id`) REFERENCES `imagenes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
