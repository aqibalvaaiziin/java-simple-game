-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 13, 2019 at 03:45 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cr`
--

-- --------------------------------------------------------

--
-- Table structure for table `bag`
--

CREATE TABLE `bag` (
  `idBag` int(11) NOT NULL,
  `bagName` varchar(25) NOT NULL,
  `potion1` int(11) NOT NULL,
  `potion2` int(11) NOT NULL,
  `potion3` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bag`
--

INSERT INTO `bag` (`idBag`, `bagName`, `potion1`, `potion2`, `potion3`) VALUES
(441, 'Balance', 331, 332, 333),
(442, 'Speed', 332, 332, 332),
(443, 'Damage', 331, 331, 331),
(444, 'Tank', 333, 333, 333);

-- --------------------------------------------------------

--
-- Table structure for table `hero`
--

CREATE TABLE `hero` (
  `idHero` int(11) NOT NULL,
  `heroName` varchar(25) NOT NULL,
  `role` varchar(25) NOT NULL,
  `hp` int(11) NOT NULL,
  `atk` int(11) NOT NULL,
  `spd` int(11) NOT NULL,
  `dfc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hero`
--

INSERT INTO `hero` (`idHero`, `heroName`, `role`, `hp`, `atk`, `spd`, `dfc`) VALUES
(122, 'Barbarian', 'Melee', -880, 165, 128, 40),
(123, 'giant', 'Melee', 17050, 300, 89, 80),
(124, 'Prince', 'Melee', 5070, 1000, 70, 79),
(126, 'Pardi', 'Melee', 500, 3300, 50, 10);

-- --------------------------------------------------------

--
-- Table structure for table `potion`
--

CREATE TABLE `potion` (
  `idPotion` int(11) NOT NULL,
  `potionName` varchar(25) NOT NULL,
  `skill` int(11) NOT NULL,
  `desc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `potion`
--

INSERT INTO `potion` (`idPotion`, `potionName`, `skill`, `desc`) VALUES
(331, 'Rage', 10, 'Rage Spell is a spell to increase attack power around +10%'),
(332, 'Turbo', 20, 'Turbo Spell is a spell to increase Speed around +20%'),
(333, 'Barriers', 15, 'Barriers Spell is a spell to increase defence around +15%');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `idResult` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idHero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`idResult`, `idUser`, `idHero`) VALUES
(9, 463, 123),
(10, 456, 122);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `idHero` int(11) NOT NULL,
  `idBag` int(11) NOT NULL,
  `username` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `idHero`, `idBag`, `username`) VALUES
(456, 122, 441, 'lala\\'),
(463, 123, 442, 'lili'),
(466, 124, 444, 'lele'),
(467, 126, 443, 'Yoga');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bag`
--
ALTER TABLE `bag`
  ADD PRIMARY KEY (`idBag`),
  ADD UNIQUE KEY `potion3` (`potion3`,`potion1`,`potion2`),
  ADD KEY `potion1` (`potion1`),
  ADD KEY `potion2` (`potion2`);

--
-- Indexes for table `hero`
--
ALTER TABLE `hero`
  ADD PRIMARY KEY (`idHero`);

--
-- Indexes for table `potion`
--
ALTER TABLE `potion`
  ADD PRIMARY KEY (`idPotion`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`idResult`),
  ADD UNIQUE KEY `idUser` (`idUser`),
  ADD UNIQUE KEY `idHero` (`idHero`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `idHerro` (`idHero`),
  ADD UNIQUE KEY `idBag` (`idBag`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bag`
--
ALTER TABLE `bag`
  MODIFY `idBag` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=447;

--
-- AUTO_INCREMENT for table `hero`
--
ALTER TABLE `hero`
  MODIFY `idHero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=127;

--
-- AUTO_INCREMENT for table `potion`
--
ALTER TABLE `potion`
  MODIFY `idPotion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=334;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `idResult` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=468;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bag`
--
ALTER TABLE `bag`
  ADD CONSTRAINT `bag_ibfk_1` FOREIGN KEY (`potion1`) REFERENCES `potion` (`idPotion`),
  ADD CONSTRAINT `bag_ibfk_2` FOREIGN KEY (`potion2`) REFERENCES `potion` (`idPotion`),
  ADD CONSTRAINT `bag_ibfk_3` FOREIGN KEY (`potion3`) REFERENCES `potion` (`idPotion`);

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`idHero`) REFERENCES `hero` (`idHero`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idHero`) REFERENCES `hero` (`idHero`),
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`idBag`) REFERENCES `bag` (`idBag`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
