-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 22, 2022 at 01:15 AM
-- Server version: 8.0.17
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bodyhealth`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrador`
--

CREATE TABLE `administrador` (
  `documentoA` int(11) NOT NULL,
  `tipodocumento` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `administrador`
--

INSERT INTO `administrador` (`documentoA`, `tipodocumento`, `nombre`, `apellido`, `telefono`, `fecha_nacimiento`, `email`, `password`, `id_rol`) VALUES
(123, 'sda', 'dsad', 'dsa', 'w32322', '2022-11-03', 'dsadad', 'sada', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `documentoC` int(15) NOT NULL,
  `tipo_documento` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaN` date DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `foto` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `jornada` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`documentoC`, `tipo_documento`, `nombre`, `apellido`, `telefono`, `fechaN`, `email`, `password`, `foto`, `jornada`, `id_rol`) VALUES
(9999, 'cedula', 'Androlo', 'CAROLO', '320343433', '2022-11-01', 'amnas@gmail.com', 'adasda', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `cliente_detalle`
--

CREATE TABLE `cliente_detalle` (
  `documentoC` int(11) NOT NULL,
  `id_detalle` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `id_metodopago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `cliente_detalle`
--

INSERT INTO `cliente_detalle` (`documentoC`, `id_detalle`, `fecha_inicio`, `fecha_fin`, `id_metodopago`) VALUES
(9999, 1, '2022-11-01', '2022-11-04', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cliente_rutina`
--

CREATE TABLE `cliente_rutina` (
  `id_clienterutina` int(11) NOT NULL,
  `documentoC` int(15) DEFAULT NULL,
  `id_rutina` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `cliente_rutina`
--

INSERT INTO `cliente_rutina` (`id_clienterutina`, `documentoC`, `id_rutina`) VALUES
(1, 9999, 1);

-- --------------------------------------------------------

--
-- Table structure for table `cliente_rutina_ejercicio`
--

CREATE TABLE `cliente_rutina_ejercicio` (
  `id_cliente_rutina_ejercicio` int(11) NOT NULL,
  `id_cliente_rutina` int(11) DEFAULT NULL,
  `id_rutina_ejercicio` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `cliente_rutina_ejercicio`
--

INSERT INTO `cliente_rutina_ejercicio` (`id_cliente_rutina_ejercicio`, `id_cliente_rutina`, `id_rutina_ejercicio`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_metodopago` int(15) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `control_cliente`
--

CREATE TABLE `control_cliente` (
  `documentoC` int(11) NOT NULL,
  `peso` double DEFAULT NULL,
  `estatura` double DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `control_cliente`
--

INSERT INTO `control_cliente` (`documentoC`, `peso`, `estatura`, `fecha`) VALUES
(9999, 60, 1.8, '2022-11-02');

-- --------------------------------------------------------

--
-- Table structure for table `control_entrenador`
--

CREATE TABLE `control_entrenador` (
  `documentoE` int(11) NOT NULL,
  `peso` double DEFAULT NULL,
  `estatura` double DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detalle`
--

CREATE TABLE `detalle` (
  `id_detalle` int(11) NOT NULL,
  `id_plan` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `meses` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `detalle`
--

INSERT INTO `detalle` (`id_detalle`, `id_plan`, `precio`, `meses`) VALUES
(1, 1, 567, 3);

-- --------------------------------------------------------

--
-- Table structure for table `dias_semana`
--

CREATE TABLE `dias_semana` (
  `id_diasemana` int(11) NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ejercicio`
--

CREATE TABLE `ejercicio` (
  `id_ejercicio` int(11) NOT NULL,
  `id_musculo` int(11) DEFAULT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `series` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `repeticiones` int(2) DEFAULT NULL,
  `url_video` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `ejercicio`
--

INSERT INTO `ejercicio` (`id_ejercicio`, `id_musculo`, `descripcion`, `series`, `repeticiones`, `url_video`) VALUES
(1, 1, 'dadsa', '3', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `entrenador`
--

CREATE TABLE `entrenador` (
  `documentoE` int(15) NOT NULL,
  `tipo_documento` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaN` date DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `experiencia` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hoja_vida` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `titulo_académico` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `documentoA` int(11) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `horario`
--

CREATE TABLE `horario` (
  `id_horario` int(11) NOT NULL,
  `jornada` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_diasemana` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `horario_entrenador`
--

CREATE TABLE `horario_entrenador` (
  `documentoE` int(15) NOT NULL,
  `id_horario` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `h_entrenadorcliente`
--

CREATE TABLE `h_entrenadorcliente` (
  `documentoE` int(15) NOT NULL,
  `documentoC` int(15) NOT NULL,
  `id_horarioentrenador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `maquina`
--

CREATE TABLE `maquina` (
  `id_maquina` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `observacion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `id_metodopago` int(11) NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `metodo_pago`
--

INSERT INTO `metodo_pago` (`id_metodopago`, `descripcion`) VALUES
(1, 'efectivo');

-- --------------------------------------------------------

--
-- Table structure for table `musculo`
--

CREATE TABLE `musculo` (
  `id_musculo` int(15) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `musculo`
--

INSERT INTO `musculo` (`id_musculo`, `descripcion`) VALUES
(1, 'asdads');

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `plan`
--

CREATE TABLE `plan` (
  `id_plan` int(11) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `plan`
--

INSERT INTO `plan` (`id_plan`, `descripcion`) VALUES
(1, 'algo');

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `stock` int(4) DEFAULT NULL,
  `precio` int(15) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre_empresa` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `descripcion` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`id_rol`, `descripcion`) VALUES
(0, NULL),
(1, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `rutina`
--

CREATE TABLE `rutina` (
  `id_rutina` int(15) NOT NULL,
  `nombre_rutina` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `rutina`
--

INSERT INTO `rutina` (`id_rutina`, `nombre_rutina`, `descripcion`) VALUES
(1, 'asafsd', 'fvgdgfdgd');

-- --------------------------------------------------------

--
-- Table structure for table `rutina_ejercicio`
--

CREATE TABLE `rutina_ejercicio` (
  `id_rutina_ejercicio` int(11) NOT NULL,
  `id_rutina` int(15) DEFAULT NULL,
  `id_ejercicio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `rutina_ejercicio`
--

INSERT INTO `rutina_ejercicio` (`id_rutina_ejercicio`, `id_rutina`, `id_ejercicio`) VALUES
(1, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`documentoA`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`documentoC`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indexes for table `cliente_detalle`
--
ALTER TABLE `cliente_detalle`
  ADD PRIMARY KEY (`documentoC`,`id_detalle`,`fecha_inicio`),
  ADD KEY `id_detalle` (`id_detalle`),
  ADD KEY `id_metodopago` (`id_metodopago`);

--
-- Indexes for table `cliente_rutina`
--
ALTER TABLE `cliente_rutina`
  ADD PRIMARY KEY (`id_clienterutina`),
  ADD KEY `documentoC` (`documentoC`),
  ADD KEY `id_rutina` (`id_rutina`);

--
-- Indexes for table `cliente_rutina_ejercicio`
--
ALTER TABLE `cliente_rutina_ejercicio`
  ADD PRIMARY KEY (`id_cliente_rutina_ejercicio`),
  ADD KEY `id_cliente_rutina` (`id_cliente_rutina`),
  ADD KEY `id_rutina_ejercicio` (`id_rutina_ejercicio`);

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_metodopago` (`id_metodopago`);

--
-- Indexes for table `control_cliente`
--
ALTER TABLE `control_cliente`
  ADD PRIMARY KEY (`documentoC`,`fecha`);

--
-- Indexes for table `control_entrenador`
--
ALTER TABLE `control_entrenador`
  ADD PRIMARY KEY (`documentoE`,`fecha`);

--
-- Indexes for table `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `id_plan` (`id_plan`);

--
-- Indexes for table `dias_semana`
--
ALTER TABLE `dias_semana`
  ADD PRIMARY KEY (`id_diasemana`);

--
-- Indexes for table `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD PRIMARY KEY (`id_ejercicio`),
  ADD KEY `id_musculo` (`id_musculo`);

--
-- Indexes for table `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`documentoE`),
  ADD KEY `documentoA` (`documentoA`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`id_horario`),
  ADD KEY `id_diasemana` (`id_diasemana`);

--
-- Indexes for table `horario_entrenador`
--
ALTER TABLE `horario_entrenador`
  ADD PRIMARY KEY (`documentoE`,`id_horario`),
  ADD KEY `id_horario` (`id_horario`);

--
-- Indexes for table `h_entrenadorcliente`
--
ALTER TABLE `h_entrenadorcliente`
  ADD PRIMARY KEY (`documentoE`,`documentoC`,`id_horarioentrenador`),
  ADD KEY `id_horarioentrenador` (`id_horarioentrenador`),
  ADD KEY `documentoC` (`documentoC`);

--
-- Indexes for table `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`id_maquina`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indexes for table `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodopago`);

--
-- Indexes for table `musculo`
--
ALTER TABLE `musculo`
  ADD PRIMARY KEY (`id_musculo`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`,`id_producto`,`id_compra`),
  ADD KEY `id_compra` (`id_compra`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indexes for table `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id_plan`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indexes for table `rutina`
--
ALTER TABLE `rutina`
  ADD PRIMARY KEY (`id_rutina`);

--
-- Indexes for table `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD PRIMARY KEY (`id_rutina_ejercicio`),
  ADD KEY `id_ejercicio` (`id_ejercicio`),
  ADD KEY `id_rutina` (`id_rutina`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);

--
-- Constraints for table `cliente_detalle`
--
ALTER TABLE `cliente_detalle`
  ADD CONSTRAINT `cliente_detalle_ibfk_1` FOREIGN KEY (`id_detalle`) REFERENCES `detalle` (`id_detalle`),
  ADD CONSTRAINT `cliente_detalle_ibfk_2` FOREIGN KEY (`documentoC`) REFERENCES `cliente` (`documentoC`),
  ADD CONSTRAINT `cliente_detalle_ibfk_3` FOREIGN KEY (`id_metodopago`) REFERENCES `metodo_pago` (`id_metodopago`);

--
-- Constraints for table `cliente_rutina`
--
ALTER TABLE `cliente_rutina`
  ADD CONSTRAINT `cliente_rutina_ibfk_1` FOREIGN KEY (`documentoC`) REFERENCES `cliente` (`documentoC`),
  ADD CONSTRAINT `cliente_rutina_ibfk_2` FOREIGN KEY (`id_rutina`) REFERENCES `rutina` (`id_rutina`);

--
-- Constraints for table `cliente_rutina_ejercicio`
--
ALTER TABLE `cliente_rutina_ejercicio`
  ADD CONSTRAINT `cliente_rutina_ejercicio_ibfk_1` FOREIGN KEY (`id_cliente_rutina`) REFERENCES `cliente_rutina` (`id_clienterutina`),
  ADD CONSTRAINT `cliente_rutina_ejercicio_ibfk_2` FOREIGN KEY (`id_rutina_ejercicio`) REFERENCES `rutina_ejercicio` (`id_rutina_ejercicio`);

--
-- Constraints for table `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`documentoC`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_metodopago`) REFERENCES `metodo_pago` (`id_metodopago`);

--
-- Constraints for table `control_cliente`
--
ALTER TABLE `control_cliente`
  ADD CONSTRAINT `control_cliente_ibfk_1` FOREIGN KEY (`documentoC`) REFERENCES `cliente` (`documentoC`);

--
-- Constraints for table `control_entrenador`
--
ALTER TABLE `control_entrenador`
  ADD CONSTRAINT `control_entrenador_ibfk_1` FOREIGN KEY (`documentoE`) REFERENCES `entrenador` (`documentoE`);

--
-- Constraints for table `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id_plan`);

--
-- Constraints for table `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD CONSTRAINT `ejercicio_ibfk_1` FOREIGN KEY (`id_musculo`) REFERENCES `musculo` (`id_musculo`);

--
-- Constraints for table `entrenador`
--
ALTER TABLE `entrenador`
  ADD CONSTRAINT `entrenador_ibfk_1` FOREIGN KEY (`documentoA`) REFERENCES `administrador` (`documentoA`),
  ADD CONSTRAINT `entrenador_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);

--
-- Constraints for table `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`id_diasemana`) REFERENCES `dias_semana` (`id_diasemana`);

--
-- Constraints for table `horario_entrenador`
--
ALTER TABLE `horario_entrenador`
  ADD CONSTRAINT `horario_entrenador_ibfk_1` FOREIGN KEY (`documentoE`) REFERENCES `entrenador` (`documentoE`),
  ADD CONSTRAINT `horario_entrenador_ibfk_2` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`);

--
-- Constraints for table `h_entrenadorcliente`
--
ALTER TABLE `h_entrenadorcliente`
  ADD CONSTRAINT `h_entrenadorcliente_ibfk_1` FOREIGN KEY (`id_horarioentrenador`) REFERENCES `horario_entrenador` (`documentoE`),
  ADD CONSTRAINT `h_entrenadorcliente_ibfk_2` FOREIGN KEY (`documentoE`) REFERENCES `entrenador` (`documentoE`),
  ADD CONSTRAINT `h_entrenadorcliente_ibfk_3` FOREIGN KEY (`documentoC`) REFERENCES `cliente` (`documentoC`);

--
-- Constraints for table `maquina`
--
ALTER TABLE `maquina`
  ADD CONSTRAINT `maquina_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Constraints for table `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD CONSTRAINT `rutina_ejercicio_ibfk_1` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicio` (`id_ejercicio`),
  ADD CONSTRAINT `rutina_ejercicio_ibfk_2` FOREIGN KEY (`id_rutina`) REFERENCES `rutina` (`id_rutina`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
