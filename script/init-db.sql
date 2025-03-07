SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS `monAnnuaire` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `monAnnuaire`;

-- --------------------------------------------------------

--
-- Structure de la table `personnes`
--

CREATE TABLE `Compte` (
 `id` bigint(20) NOT NULL,
 `solde` int(11) NOT NULL,
 `idClient` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;