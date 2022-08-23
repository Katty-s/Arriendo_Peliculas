-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 23-08-2022 a las 21:26:54
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jparelaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arriendo`
--

CREATE TABLE `arriendo` (
  `id` int(11) NOT NULL,
  `duracion` int(11) DEFAULT NULL,
  `inicio` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `pelicula_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `arriendo`
--

INSERT INTO `arriendo` (`id`, `duracion`, `inicio`, `cliente_id`, `pelicula_id`) VALUES
(1, 120, '2022-08-23', 1, 1),
(2, 125, '2022-08-25', 3, 2),
(3, 130, '2022-08-27', 4, 3),
(4, 124, '2022-08-23', 5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`) VALUES
(1, 'Katherine Salinas'),
(2, 'Katherine Salinas'),
(3, 'Mel Gibson'),
(4, 'Jennifer Conelly'),
(5, 'Charlize Theron');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id`, `descripcion`, `duracion`, `titulo`) VALUES
(1, 'Crimen Drama', 120, 'El Perfecto Asesino'),
(2, 'Accion Post-Apocaliptico', 125, 'Mad Max 2'),
(3, 'Drama ', 130, 'Requiem for a Dream'),
(4, ' Drama', 124, 'Another Round');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sq_arriendo`
--

CREATE TABLE `sq_arriendo` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sq_arriendo`
--

INSERT INTO `sq_arriendo` (`next_val`) VALUES
(5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sq_cliente`
--

CREATE TABLE `sq_cliente` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sq_cliente`
--

INSERT INTO `sq_cliente` (`next_val`) VALUES
(6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sq_pelicula`
--

CREATE TABLE `sq_pelicula` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sq_pelicula`
--

INSERT INTO `sq_pelicula` (`next_val`) VALUES
(5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `arriendo`
--
ALTER TABLE `arriendo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK93cip1i0hk6jkbe62y9cawlyt` (`cliente_id`),
  ADD KEY `FKep5lnt6hcsu0kqf520md6vnb5` (`pelicula_id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `arriendo`
--
ALTER TABLE `arriendo`
  ADD CONSTRAINT `FK93cip1i0hk6jkbe62y9cawlyt` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKep5lnt6hcsu0kqf520md6vnb5` FOREIGN KEY (`pelicula_id`) REFERENCES `pelicula` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
