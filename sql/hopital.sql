-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2019 at 04:51 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hopital`
--
CREATE DATABASE IF NOT EXISTS `hopital` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hopital`;

-- --------------------------------------------------------

--
-- Table structure for table `admission`
--

DROP TABLE IF EXISTS `admission`;
CREATE TABLE `admission` (
  `idPatient` int(11) NOT NULL,
  `idService` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `attente`
--

DROP TABLE IF EXISTS `attente`;
CREATE TABLE `attente` (
  `idPatient` int(11) NOT NULL,
  `idService` int(11) DEFAULT NULL,
  `enregistrement` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
CREATE TABLE `chambre` (
  `idChambre` int(11) NOT NULL,
  `idService` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chambre`
--

INSERT INTO `chambre` (`idChambre`, `idService`, `numero`) VALUES
(9, 25, 30),
(10, 25, 31),
(11, 25, 32),
(12, 25, 33),
(13, 25, 34),
(14, 25, 35),
(15, 25, 36),
(16, 25, 37),
(17, 25, 38),
(18, 25, 39),
(19, 26, 40),
(20, 26, 41),
(21, 26, 42),
(22, 26, 43),
(23, 26, 44),
(24, 26, 45),
(25, 26, 46),
(26, 26, 47),
(27, 27, 24),
(28, 27, 25),
(29, 27, 26),
(30, 27, 27),
(31, 27, 28),
(32, 27, 29),
(33, 30, 71),
(34, 30, 72),
(35, 30, 73),
(36, 30, 74),
(37, 30, 75),
(38, 28, 83),
(39, 28, 84),
(40, 28, 85),
(41, 28, 86),
(42, 28, 87),
(43, 28, 88),
(44, 28, 89),
(45, 28, 90),
(46, 29, 10),
(47, 29, 11),
(48, 29, 12),
(49, 29, 13),
(50, 29, 14),
(51, 29, 15),
(52, 29, 16),
(53, 29, 17),
(54, 29, 18),
(55, 29, 19),
(56, 32, 120),
(57, 32, 121),
(58, 32, 122),
(59, 32, 123),
(60, 32, 124),
(61, 32, 125),
(62, 32, 126),
(63, 32, 127),
(64, 32, 128),
(65, 32, 129),
(66, 33, 130),
(67, 33, 131),
(68, 33, 132),
(69, 33, 133),
(70, 33, 134),
(71, 33, 135),
(72, 33, 136),
(73, 33, 137),
(74, 33, 138),
(75, 33, 139),
(76, 31, 1),
(77, 31, 2),
(78, 31, 3),
(79, 31, 4),
(80, 31, 5),
(81, 31, 6),
(82, 31, 7),
(83, 31, 8),
(84, 31, 9);

-- --------------------------------------------------------

--
-- Table structure for table `chambrelits`
--

DROP TABLE IF EXISTS `chambrelits`;
CREATE TABLE `chambrelits` (
  `idChambre` int(11) NOT NULL,
  `nombreLitsTotal` int(11) NOT NULL,
  `nombreLitsRestants` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chambrelits`
--

INSERT INTO `chambrelits` (`idChambre`, `nombreLitsTotal`, `nombreLitsRestants`) VALUES
(9, 1, 1),
(10, 1, 1),
(11, 1, 1),
(12, 1, 1),
(13, 1, 1),
(14, 1, 1),
(15, 1, 1),
(16, 1, 1),
(17, 1, 1),
(18, 1, 1),
(19, 2, 2),
(20, 2, 2),
(21, 2, 2),
(22, 2, 2),
(23, 2, 2),
(24, 2, 2),
(25, 2, 2),
(26, 1, 1),
(27, 1, 1),
(28, 1, 1),
(29, 1, 1),
(30, 1, 1),
(31, 1, 1),
(32, 1, 1),
(33, 1, 1),
(34, 1, 1),
(35, 1, 1),
(36, 1, 1),
(37, 1, 1),
(38, 1, 1),
(39, 1, 1),
(40, 1, 1),
(41, 1, 1),
(42, 1, 1),
(43, 1, 1),
(44, 1, 1),
(45, 1, 1),
(46, 2, 2),
(47, 2, 2),
(48, 2, 2),
(49, 2, 2),
(50, 2, 2),
(51, 1, 1),
(52, 1, 1),
(53, 1, 1),
(54, 1, 1),
(55, 1, 1),
(56, 2, 2),
(57, 2, 2),
(58, 2, 2),
(59, 2, 2),
(60, 2, 2),
(61, 1, 1),
(62, 1, 1),
(63, 1, 1),
(64, 1, 1),
(65, 1, 1),
(66, 2, 2),
(67, 2, 2),
(68, 2, 2),
(69, 2, 2),
(70, 2, 2),
(71, 1, 1),
(72, 1, 1),
(73, 1, 1),
(74, 1, 1),
(75, 1, 1),
(76, 4, 4),
(77, 2, 2),
(78, 2, 2),
(79, 2, 2),
(80, 2, 2),
(81, 2, 2),
(82, 2, 2),
(83, 2, 2),
(84, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `nombrelits`
--

DROP TABLE IF EXISTS `nombrelits`;
CREATE TABLE `nombrelits` (
  `idService` int(11) NOT NULL,
  `nombreLitsTotal` int(11) NOT NULL,
  `nombreLitsRestants` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nombrelits`
--

INSERT INTO `nombrelits` (`idService`, `nombreLitsTotal`, `nombreLitsRestants`) VALUES
(25, 10, 10),
(26, 15, 15),
(27, 6, 6),
(28, 8, 8),
(29, 15, 15),
(30, 5, 5),
(31, 20, 20),
(32, 15, 15),
(33, 15, 15);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `idPatient` int(11) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `prenom` varchar(32) NOT NULL,
  `genre` varchar(1) NOT NULL,
  `naissance` date DEFAULT NULL,
  `numTel` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`idPatient`, `nom`, `prenom`, `genre`, `naissance`, `numTel`) VALUES
(22, 'Streignard', 'Mathieu', 'M', '1996-04-02', '0471/60.95.08'),
(23, 'Temmerman', 'Fran?ois', 'M', '1998-05-24', '0470/60.78.54'),
(24, 'Namurois', 'Thomas', 'M', '1998-07-14', '0473/52.24.78'),
(25, 'Delvignes', 'Yves', 'M', '1963-08-27', '0471/58.21.63'),
(26, 'Bouterfa', 'Youcef', 'M', '1966-03-17', '02/754.22.87'),
(27, 'Devleeshouwer', 'Michel', 'M', '1959-08-13', '02/578.35.47'),
(28, 'Vandermael', 'Louis', 'M', '1979-12-04', '02/543.25.48'),
(29, 'Kevlin', 'Jerome', 'T', '1997-02-18', '0471/58.22.47'),
(30, 'Vandenschriek', 'Virginie', 'F', '1985-07-23', '02/579.26.33'),
(31, 'Tesla', 'Kevin', 'M', '1965-05-24', '0473/52.24.78'),
(32, 'Augustin', 'Jean-Kevin', 'N', '1988-09-23', '02/534.87.59'),
(33, 'Messeline', 'Chantal', 'F', '1964-07-25', '02/845.25.36'),
(34, 'Thevenin', 'Hugo', 'M', '1957-04-11', '0460/54.23.58'),
(35, 'Than?s', 'Brigitte', 'F', '1988-08-04', '02/549.63.25'),
(36, 'Tenor', 'Jessica', 'F', '1999-05-19', '1971/52.35.84'),
(37, 'Tenard', 'Florian', 'T', '1992-04-03', '02/348.26.24'),
(38, 'Francis', 'Jonathan', 'M', '1958-09-27', '02/478.35.69'),
(39, 'Hubert', 'Elise', 'F', '2002-12-30', '02/543.89.65');

-- --------------------------------------------------------

--
-- Table structure for table `patientchambre`
--

DROP TABLE IF EXISTS `patientchambre`;
CREATE TABLE `patientchambre` (
  `idPatient` int(11) NOT NULL,
  `idChambre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `idService` int(11) NOT NULL,
  `nom` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`idService`, `nom`) VALUES
(25, 'Cardiologie'),
(26, 'Gériatrie'),
(27, 'Maternité'),
(30, 'Pédopsychiatrie'),
(28, 'Psychiatrie'),
(29, 'Revalidation'),
(32, 'Soins intensifs'),
(33, 'Soins palliatifs'),
(31, 'Urgences');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admission`
--
ALTER TABLE `admission`
  ADD PRIMARY KEY (`idPatient`),
  ADD KEY `idService` (`idService`),
  ADD KEY `idPatient` (`idPatient`,`idService`);

--
-- Indexes for table `attente`
--
ALTER TABLE `attente`
  ADD PRIMARY KEY (`idPatient`),
  ADD KEY `serviceAttendu` (`idService`);

--
-- Indexes for table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`idChambre`),
  ADD KEY `idService` (`idService`);

--
-- Indexes for table `chambrelits`
--
ALTER TABLE `chambrelits`
  ADD PRIMARY KEY (`idChambre`);

--
-- Indexes for table `nombrelits`
--
ALTER TABLE `nombrelits`
  ADD PRIMARY KEY (`idService`),
  ADD KEY `idService` (`idService`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`idPatient`);

--
-- Indexes for table `patientchambre`
--
ALTER TABLE `patientchambre`
  ADD PRIMARY KEY (`idPatient`),
  ADD KEY `idPatient` (`idPatient`),
  ADD KEY `idChambre` (`idChambre`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`idService`),
  ADD UNIQUE KEY `nom` (`nom`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `idChambre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `idPatient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `idService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admission`
--
ALTER TABLE `admission`
  ADD CONSTRAINT `admission_ibfk_1` FOREIGN KEY (`idPatient`) REFERENCES `patient` (`idPatient`),
  ADD CONSTRAINT `admission_ibfk_2` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`);

--
-- Constraints for table `attente`
--
ALTER TABLE `attente`
  ADD CONSTRAINT `attente_ibfk_1` FOREIGN KEY (`idPatient`) REFERENCES `patient` (`idPatient`),
  ADD CONSTRAINT `attente_ibfk_2` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`);

--
-- Constraints for table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `chambre_ibfk_1` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`);

--
-- Constraints for table `chambrelits`
--
ALTER TABLE `chambrelits`
  ADD CONSTRAINT `chambrelits_ibfk_1` FOREIGN KEY (`idChambre`) REFERENCES `chambre` (`idChambre`);

--
-- Constraints for table `nombrelits`
--
ALTER TABLE `nombrelits`
  ADD CONSTRAINT `nombrelits_ibfk_1` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`);

--
-- Constraints for table `patientchambre`
--
ALTER TABLE `patientchambre`
  ADD CONSTRAINT `patientchambre_ibfk_2` FOREIGN KEY (`idPatient`) REFERENCES `patient` (`idPatient`),
  ADD CONSTRAINT `patientchambre_ibfk_3` FOREIGN KEY (`idChambre`) REFERENCES `chambre` (`idChambre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
