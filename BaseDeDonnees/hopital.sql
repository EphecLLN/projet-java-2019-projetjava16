-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2019 at 12:15 AM
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

--
-- Dumping data for table `admission`
--

INSERT INTO `admission` (`idPatient`, `idService`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(6, 3),
(15, 16),
(14, 15),
(17, 15);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `idPatient` int(11) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `prenom` varchar(32) NOT NULL,
  `naissance` date DEFAULT NULL,
  `genre` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`idPatient`, `nom`, `prenom`, `naissance`, `genre`) VALUES
(1, 'Streignard', 'Mathieu', '1996-04-02', 'm'),
(2, 'Temmerman', 'François', '1998-08-13', 'm'),
(3, 'Namurois', 'Thomas', '1998-07-12', 'm'),
(4, 'Delvigne', 'Yves', '1963-04-12', 'm'),
(6, 'Devleeshouwer', 'Michel', '1954-12-23', 'm'),
(14, 'Augustin', 'Jean-Kevin', '1993-02-28', 'm'),
(15, 'Vandenschriek', 'Virginie', '1984-11-24', 'f'),
(17, 'Bouterfa', 'Youcef', '1966-07-09', 'm'),
(19, 'Kevlin', 'Claude', '2005-01-01', 'f'),
(20, 'Suzeron', 'Jean-Baptiste', '1989-05-20', 'm'),
(21, 'Tesla', 'Kevin', '1996-07-23', 'm');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `idService` int(11) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `litTot` int(11) NOT NULL,
  `litRest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`idService`, `nom`, `litTot`, `litRest`) VALUES
(1, 'Urgences', 15, 15),
(2, 'Cardio', 10, 10),
(3, 'Pédiatrie', 15, 15),
(15, 'Gériatrie', 10, 10),
(16, 'Mamographie', 5, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admission`
--
ALTER TABLE `admission`
  ADD KEY `idPatient` (`idPatient`),
  ADD KEY `idService` (`idService`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`idPatient`);

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
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `idPatient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `idService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admission`
--
ALTER TABLE `admission`
  ADD CONSTRAINT `admission_ibfk_1` FOREIGN KEY (`idPatient`) REFERENCES `patient` (`idPatient`),
  ADD CONSTRAINT `admission_ibfk_2` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
