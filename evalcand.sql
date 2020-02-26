-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3305
-- Généré le :  mer. 26 fév. 2020 à 17:36
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `evalcand`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE IF NOT EXISTS `candidat` (
  `id_candidat` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `niveau` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_candidat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `candidat`
--

INSERT INTO `candidat` (`id_candidat`, `email`, `niveau`, `nom`, `prenom`) VALUES
(2, NULL, 4, 'amor', 'aissa'),
(29, 'jassem@gmail.com', 4, 'Jassem', 'Abdaddaiem'),
(30, 'jassem@gmail.com', 4, 'Jassem', 'Abdaddaiem');

-- --------------------------------------------------------

--
-- Structure de la table `coach`
--

DROP TABLE IF EXISTS `coach`;
CREATE TABLE IF NOT EXISTS `coach` (
  `id_coach` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id_coach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `coach`
--

INSERT INTO `coach` (`id_coach`, `email`, `nom`, `password`, `prenom`, `username`) VALUES
(8, 'amor.aissa1993@gmail.com', 'amor', '$2a$10$1G19OMqTcEZBfShp1vC8uOS1v.6Nq3//CohFhHBWghPKCvC3W0uxe', 'aissa', 'admin'),
(10, 'jassem@gmail.com', 'jassem', '$2a$10$UHvOzcnnLN1ERAPjzyIeW.Sutp0yCEUYfBuCn909nhgs.0qxY71Ci', 'jassem', 'jassem');

-- --------------------------------------------------------

--
-- Structure de la table `codage`
--

DROP TABLE IF EXISTS `codage`;
CREATE TABLE IF NOT EXISTS `codage` (
  `id_codage` int(11) NOT NULL,
  `reponse_candidat` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `enonce` varchar(255) DEFAULT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  `evaluation_id_evaluation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_codage`),
  KEY `FK8yxgaw53w566dr5arev0wvfr6` (`evaluation_id_evaluation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `id_candidat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_evaluation`),
  KEY `FK49b5de734vlwvgvhjrqaplkcd` (`id_candidat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id_evaluation`, `duree`, `etat`, `titre`, `id_candidat`) VALUES
(3, 1, 'en cours', 'FivePoints test', NULL),
(11, 1, 'en cours', 'FivePoints test', NULL),
(13, 1, 'en cours', 'FivePoints test', NULL),
(15, 1, 'en cours', 'FivePoints test', NULL),
(17, 1, 'en cours', 'FivePoints test', NULL),
(19, 1, 'en cours', 'FivePoints test', NULL),
(21, 1, 'en cours', 'FivePoints test', NULL),
(23, 1, 'en cours', 'FivePoints test', NULL),
(25, 1, 'en cours', 'FivePoints test', NULL),
(27, 1, 'en cours', 'FivePoints test', NULL),
(31, 1, 'en cours', 'FivePoints test', NULL),
(33, 1, 'en cours', 'FivePoints test', NULL),
(35, 1, 'en cours', 'FivePoints test', NULL),
(37, 1, 'en cours', 'FivePoints test', NULL),
(39, 1, 'en cours', 'FivePoints test', NULL),
(41, 1, 'en cours', 'FivePoints test', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(43),
(43),
(43),
(43),
(43),
(43),
(43);

-- --------------------------------------------------------

--
-- Structure de la table `language`
--

DROP TABLE IF EXISTS `language`;
CREATE TABLE IF NOT EXISTS `language` (
  `id_language` int(11) NOT NULL,
  `reponse_candidat` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `enonce` varchar(255) DEFAULT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  `evaluation_id_evaluation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_language`),
  KEY `FKafub4me6jy4ca6k6gqymqkn29` (`evaluation_id_evaluation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `id_projet` int(11) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `enonce` varchar(255) DEFAULT NULL,
  `lien_git` varchar(255) DEFAULT NULL,
  `evaluation_id_evaluation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_projet`),
  KEY `FK9brfhbuu9kuketelpvcke9b5s` (`evaluation_id_evaluation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `qr`
--

DROP TABLE IF EXISTS `qr`;
CREATE TABLE IF NOT EXISTS `qr` (
  `id_qr` int(11) NOT NULL,
  `question` varchar(255) DEFAULT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  `reponse_candidat` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `remarque` varchar(255) DEFAULT NULL,
  `id_evaluation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `FKouaslvvuk5duioov1xko82ryt` (`id_evaluation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `qr`
--

INSERT INTO `qr` (`id_qr`, `question`, `reponse`, `reponse_candidat`, `titre`, `remarque`, `id_evaluation`) VALUES
(4, 'Question2', 'Reponse 2', NULL, 'js', NULL, 3),
(12, 'Question2', 'Reponse 2', NULL, 'js', NULL, 11),
(14, 'Question2', 'Reponse 2', NULL, 'js', NULL, 13),
(16, 'Question2', 'Reponse 2', NULL, 'js', NULL, 15),
(18, 'Question2', 'Reponse 2', NULL, 'js', NULL, 17),
(20, 'Question2', 'Reponse 2', NULL, 'js', NULL, 19),
(22, 'Question2', 'Reponse 2', NULL, 'js', NULL, 21),
(24, 'Question2', 'Reponse 2', NULL, 'js', NULL, 23),
(26, 'Question2', 'Reponse 2', NULL, 'js', NULL, 25),
(28, 'Question2', 'Reponse 2', NULL, 'js', NULL, 27),
(32, 'Question2', 'Reponse 2', NULL, 'js', NULL, 31),
(34, 'Question2', 'Reponse 2', NULL, 'js', NULL, 33),
(36, 'Question2', 'Reponse 2', NULL, 'js', NULL, 35),
(38, 'Question2', 'Reponse 2', NULL, 'js', NULL, 37),
(40, 'Question2', 'Reponse 2', NULL, 'js', NULL, 39),
(42, 'Question2', 'Reponse 2', NULL, 'js', NULL, 41);

-- --------------------------------------------------------

--
-- Structure de la table `reset_password`
--

DROP TABLE IF EXISTS `reset_password`;
CREATE TABLE IF NOT EXISTS `reset_password` (
  `id` int(11) NOT NULL,
  `new_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `codage`
--
ALTER TABLE `codage`
  ADD CONSTRAINT `FK8yxgaw53w566dr5arev0wvfr6` FOREIGN KEY (`evaluation_id_evaluation`) REFERENCES `evaluation` (`id_evaluation`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FK49b5de734vlwvgvhjrqaplkcd` FOREIGN KEY (`id_candidat`) REFERENCES `candidat` (`id_candidat`);

--
-- Contraintes pour la table `language`
--
ALTER TABLE `language`
  ADD CONSTRAINT `FKafub4me6jy4ca6k6gqymqkn29` FOREIGN KEY (`evaluation_id_evaluation`) REFERENCES `evaluation` (`id_evaluation`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `FK9brfhbuu9kuketelpvcke9b5s` FOREIGN KEY (`evaluation_id_evaluation`) REFERENCES `evaluation` (`id_evaluation`);

--
-- Contraintes pour la table `qr`
--
ALTER TABLE `qr`
  ADD CONSTRAINT `FKouaslvvuk5duioov1xko82ryt` FOREIGN KEY (`id_evaluation`) REFERENCES `evaluation` (`id_evaluation`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
