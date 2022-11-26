-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-11-2022 a las 22:10:04
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bodyhealth`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `documentoA` int(11) NOT NULL,
  `tipodocumento` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`documentoA`, `tipodocumento`, `nombre`, `apellido`, `telefono`, `fecha_nacimiento`, `email`, `password`, `id_rol`) VALUES
(123313, 'cedula', 'Androlo', 'dsdads', '34243', '2022-11-01', 'dsadsad', 'saad', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(15) NOT NULL,
  `documentoC` int(15) NOT NULL,
  `tipo_documento` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaN` date DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `foto` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `jornada` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `documentoC`, `tipo_documento`, `nombre`, `apellido`, `telefono`, `fechaN`, `email`, `password`, `foto`, `jornada`, `estado`, `id_rol`) VALUES
(10, 999, 'CC', 'Anderson', 'Orozco', '3219238493', '2022-11-17', 'anderson07rolon@gmail.com', '12345', NULL, 'mañana', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_detalle`
--

CREATE TABLE `cliente_detalle` (
  `id_factura` int(11) NOT NULL,
  `documentoC` int(11) NOT NULL,
  `id_detalle` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `id_metodopago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente_detalle`
--

INSERT INTO `cliente_detalle` (`id_factura`, `documentoC`, `id_detalle`, `fecha_inicio`, `fecha_fin`, `id_metodopago`) VALUES
(0, 1004, 2, '2022-11-24', '2022-12-24', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_rutina`
--

CREATE TABLE `cliente_rutina` (
  `id_clienterutina` int(11) NOT NULL,
  `documentoC` int(15) DEFAULT NULL,
  `id_rutina` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente_rutina`
--

INSERT INTO `cliente_rutina` (`id_clienterutina`, `documentoC`, `id_rutina`) VALUES
(1, 999, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_rutina_ejercicio`
--

CREATE TABLE `cliente_rutina_ejercicio` (
  `id_cliente_rutina_ejercicio` int(11) NOT NULL,
  `id_cliente_rutina` int(11) DEFAULT NULL,
  `id_rutina_ejercicio` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente_rutina_ejercicio`
--

INSERT INTO `cliente_rutina_ejercicio` (`id_cliente_rutina_ejercicio`, `id_cliente_rutina`, `id_rutina_ejercicio`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_metodopago` int(15) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id_compra`, `id_cliente`, `id_metodopago`, `fecha_compra`) VALUES
(1, 999, 3, '2022-11-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_cliente`
--

CREATE TABLE `control_cliente` (
  `documentoC` int(11) NOT NULL,
  `peso` double DEFAULT NULL,
  `estatura` double DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `control_cliente`
--

INSERT INTO `control_cliente` (`documentoC`, `peso`, `estatura`, `fecha`) VALUES
(1004, 80, 180, '2022-11-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_entrenador`
--

CREATE TABLE `control_entrenador` (
  `documentoE` int(11) NOT NULL,
  `peso` double DEFAULT NULL,
  `estatura` double DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id_detalle` int(11) NOT NULL,
  `plan` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `meses` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id_detalle`, `plan`, `precio`, `meses`) VALUES
(2, 'Plan Intermedio', 80000, 3),
(3, 'Plan Avanzado', 80000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio`
--

CREATE TABLE `ejercicio` (
  `id_ejercicio` int(11) NOT NULL,
  `id_musculo` int(11) DEFAULT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `series` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `repeticiones` int(2) DEFAULT NULL,
  `url_video` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ejercicio`
--

INSERT INTO `ejercicio` (`id_ejercicio`, `id_musculo`, `descripcion`, `series`, `repeticiones`, `url_video`) VALUES
(1, 1, 'Ejercicios para biceps- bla bla', '4', 12, 'VIDEO EXPLICATIVO'),
(2, 2, 'Ejercicios para Cuadriceps - BLA BLA', '4', 15, 'VIDEO EXPLICATIVO'),
(3, 1, 'Ejercicios para biceps 2', '4', 12, 'VIDEO 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `documentoE` int(15) NOT NULL,
  `tipo_documento` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaN` date DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `experiencia` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `hoja_vida` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `titulo_academico` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `jornada` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `documentoA` int(11) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`documentoE`, `tipo_documento`, `nombre`, `apellido`, `telefono`, `fechaN`, `email`, `password`, `experiencia`, `hoja_vida`, `titulo_academico`, `jornada`, `documentoA`, `id_rol`) VALUES
(4535, 'cedula', 'trainer pepito', 'perez', '546456', '2022-11-03', 'affsd', 'fssfsf', 'adsads', 'adsada', 'dadsa', 'tarde', 123313, 2),
(9589, 'CC', 'Trainer', 'Dos', '3212323322', '2003-10-15', 'trainer2@gmail.com', '123', '3', 'hoja', 'full', 'Tarde', 123313, 3),
(95892, 'CC', 'Trainer', 'Tres', '3212323322', '2003-10-15', 'trainer2@gmail.com', '123', '3', 'hoja', 'full', 'Tarde', 123313, 3),
(95894, 'CC', 'Trainer', 'Cuatro', '3212323322', '2003-10-15', 'trainer4@gmail.com', '123', '3', 'hoja', 'full', 'Mañana', 123313, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador_cliente`
--

CREATE TABLE `entrenador_cliente` (
  `documentoE` int(15) NOT NULL,
  `documentoC` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `entrenador_cliente`
--

INSERT INTO `entrenador_cliente` (`documentoE`, `documentoC`) VALUES
(95892, 999),
(95892, 1004),
(4535, 9991),
(4535, 9992);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquina`
--

CREATE TABLE `maquina` (
  `id_maquina` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `observacion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `maquina`
--

INSERT INTO `maquina` (`id_maquina`, `nombre`, `estado`, `observacion`, `id_proveedor`) VALUES
(1, 'Maquina A', 'Bueno', 'N/A', 2),
(3, 'prueba', 'Bien', 'SI', 1),
(4, 'Anderson', 'Bien', 'no', 1),
(5, 'prueba', 'Bien', 'no', 1),
(6, 'Anderson', 'Bien', 'no', 1),
(7, 'Anderson', 'Bien', 'no', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `id_metodopago` int(11) NOT NULL,
  `descripcion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`id_metodopago`, `descripcion`) VALUES
(1, 'PSE'),
(2, 'Efectivo'),
(3, 'Tarjeta de Credito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musculo`
--

CREATE TABLE `musculo` (
  `id_musculo` int(15) NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `musculo`
--

INSERT INTO `musculo` (`id_musculo`, `descripcion`) VALUES
(1, 'Biceps'),
(2, 'Cuadriceps');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `id_producto`, `id_compra`, `cantidad`) VALUES
(99, 1, 1, 3),
(100, 3, 1, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `stock` int(4) DEFAULT NULL,
  `precio` int(15) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `stock`, `precio`, `id_proveedor`) VALUES
(1, 'Producto 1', 50, 15000, 1),
(3, 'prueba2', 12, 80000, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre_empresa` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre_empresa`, `telefono`, `direccion`) VALUES
(1, 'Empresa Gimnasio2', '3219238493', 'Av 3A #12-22 La Playa'),
(2, 'Empresa4', '23223', 'sdsd'),
(5, 'UFPS2', '3219238493', 'Calle 1 #4-49 CECI'),
(6, 'UFPS 2', '3219238493', 'Calle 1 #4-49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `descripcion` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `descripcion`) VALUES
(1, 'Admin'),
(2, 'User'),
(3, 'Trainer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina`
--

CREATE TABLE `rutina` (
  `id_rutina` int(15) NOT NULL,
  `nombre_rutina` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rutina`
--

INSERT INTO `rutina` (`id_rutina`, `nombre_rutina`, `descripcion`) VALUES
(1, 'Rutina para Biceps', 'A continuacion se enseñará una rutina completa para biceps'),
(2, 'Rutina para Cuadriceps', 'A continuacion se enseñará una rutina completa para cuadriceps');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio`
--

CREATE TABLE `rutina_ejercicio` (
  `id_rutina_ejercicio` int(11) NOT NULL,
  `id_rutina` int(15) DEFAULT NULL,
  `id_ejercicio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rutina_ejercicio`
--

INSERT INTO `rutina_ejercicio` (`id_rutina_ejercicio`, `id_rutina`, `id_ejercicio`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`documentoA`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`) USING BTREE,
  ADD UNIQUE KEY `documentoC` (`documentoC`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `cliente_detalle`
--
ALTER TABLE `cliente_detalle`
  ADD PRIMARY KEY (`id_factura`) USING BTREE,
  ADD KEY `id_detalle` (`id_detalle`),
  ADD KEY `id_metodopago` (`id_metodopago`),
  ADD KEY `cliente_detalle_ibfk_2` (`documentoC`);

--
-- Indices de la tabla `cliente_rutina`
--
ALTER TABLE `cliente_rutina`
  ADD PRIMARY KEY (`id_clienterutina`),
  ADD KEY `documentoC` (`documentoC`),
  ADD KEY `id_rutina` (`id_rutina`);

--
-- Indices de la tabla `cliente_rutina_ejercicio`
--
ALTER TABLE `cliente_rutina_ejercicio`
  ADD PRIMARY KEY (`id_cliente_rutina_ejercicio`),
  ADD KEY `id_cliente_rutina` (`id_cliente_rutina`),
  ADD KEY `id_rutina_ejercicio` (`id_rutina_ejercicio`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_metodopago` (`id_metodopago`);

--
-- Indices de la tabla `control_cliente`
--
ALTER TABLE `control_cliente`
  ADD PRIMARY KEY (`documentoC`,`fecha`);

--
-- Indices de la tabla `control_entrenador`
--
ALTER TABLE `control_entrenador`
  ADD PRIMARY KEY (`documentoE`,`fecha`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id_detalle`);

--
-- Indices de la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD PRIMARY KEY (`id_ejercicio`),
  ADD KEY `id_musculo` (`id_musculo`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`documentoE`),
  ADD KEY `documentoA` (`documentoA`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `entrenador_cliente`
--
ALTER TABLE `entrenador_cliente`
  ADD PRIMARY KEY (`documentoE`,`documentoC`),
  ADD KEY `documentoC` (`documentoC`),
  ADD KEY `documentoE` (`documentoE`);

--
-- Indices de la tabla `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`id_maquina`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodopago`);

--
-- Indices de la tabla `musculo`
--
ALTER TABLE `musculo`
  ADD PRIMARY KEY (`id_musculo`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`) USING BTREE,
  ADD KEY `id_compra` (`id_compra`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `rutina`
--
ALTER TABLE `rutina`
  ADD PRIMARY KEY (`id_rutina`);

--
-- Indices de la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD PRIMARY KEY (`id_rutina_ejercicio`),
  ADD KEY `id_ejercicio` (`id_ejercicio`),
  ADD KEY `id_rutina` (`id_rutina`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `maquina`
--
ALTER TABLE `maquina`
  MODIFY `id_maquina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);

--
-- Filtros para la tabla `cliente_detalle`
--
ALTER TABLE `cliente_detalle`
  ADD CONSTRAINT `cliente_detalle_ibfk_1` FOREIGN KEY (`id_detalle`) REFERENCES `detalle` (`id_detalle`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_detalle_ibfk_3` FOREIGN KEY (`id_metodopago`) REFERENCES `metodo_pago` (`id_metodopago`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente_rutina`
--
ALTER TABLE `cliente_rutina`
  ADD CONSTRAINT `cliente_rutina_ibfk_2` FOREIGN KEY (`id_rutina`) REFERENCES `rutina` (`id_rutina`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `cliente_rutina_ejercicio`
--
ALTER TABLE `cliente_rutina_ejercicio`
  ADD CONSTRAINT `cliente_rutina_ejercicio_ibfk_1` FOREIGN KEY (`id_cliente_rutina`) REFERENCES `cliente_rutina` (`id_clienterutina`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_rutina_ejercicio_ibfk_2` FOREIGN KEY (`id_rutina_ejercicio`) REFERENCES `rutina_ejercicio` (`id_rutina_ejercicio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_metodopago`) REFERENCES `metodo_pago` (`id_metodopago`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `control_entrenador`
--
ALTER TABLE `control_entrenador`
  ADD CONSTRAINT `control_entrenador_ibfk_1` FOREIGN KEY (`documentoE`) REFERENCES `entrenador` (`documentoE`);

--
-- Filtros para la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD CONSTRAINT `ejercicio_ibfk_1` FOREIGN KEY (`id_musculo`) REFERENCES `musculo` (`id_musculo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD CONSTRAINT `entrenador_ibfk_1` FOREIGN KEY (`documentoA`) REFERENCES `administrador` (`documentoA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `entrenador_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `entrenador_cliente`
--
ALTER TABLE `entrenador_cliente`
  ADD CONSTRAINT `entrenador_cliente_ibfk_2` FOREIGN KEY (`documentoE`) REFERENCES `entrenador` (`documentoE`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `maquina`
--
ALTER TABLE `maquina`
  ADD CONSTRAINT `maquina_proveedor_fk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pedido_producto_fk` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_proveedor_fk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD CONSTRAINT `rutina_ejercicio_ibfk_1` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicio` (`id_ejercicio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rutina_ejercicio_ibfk_2` FOREIGN KEY (`id_rutina`) REFERENCES `rutina` (`id_rutina`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
