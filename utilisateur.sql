-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 24 oct. 2023 à 21:08
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `devapps`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT 'USER',
  `age` date NOT NULL,
  `username` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `bloquer` int(11) NOT NULL DEFAULT 0,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `password`, `email`, `adresse`, `role`, `age`, `username`, `photo`, `bloquer`, `code`) VALUES
(1, 'mama', 'yassine', 'xdYBVs0YI1vdyO+3T6ZfXQ==', 'mama@mama.com', 'houmt 9ouraych', 'ROLE_USER', '2018-01-01', '+21625555505', 'aebccda2b4040db02a7531cd3329659c.jpg', 1, 25555505),
(162, 'baha', 'baha', 'Qb5pjYEpx1ChrL5RE/+/xA==', 'gg', '789 rue palastine', 'ROLE_ADMIN', '2018-01-01', 'baha', 'e7203d782eec040f478fbc0adbc8449d.jpg', 0, 9458),
(173, 'esprance sportive de tunis mmmmm', 'esprance sportive de tunis mmmmm', 'GJKxP41HzXH0lVJTtxm28w==', 'mejdi.mohamed@esprit.tn', 'esprance sportive de tunis', 'ROLE_USER', '2018-01-19', 'esprance sportive de tunis', 'esprance sportive de tunis ', 0, NULL),
(175, 'mejdi', 'mohamed', 'A9wAMxzRgc7Glizj8Z0UOA==', 'mejdi.mohamed@esprit.tn', 'houmt 9ouraych', 'ROLE_ADMIN', '2019-01-01', 'Hama', 'aebccda2b4040db02a7531cd3329659c.jpg', 1, 25555505),
(176, 'yassine', 'boulares', 'buXH3U1+ORRXGqN70kAsYA==', 'yassine.boulares9@gmail.com', 'rue turkie', 'ROLE_ADMIN', '2020-04-04', 'yassine boularess', '7074a123095ccb093b84a576ae344a05.jpg', 0, 3120),
(177, 'mahdi', 'romdhani', 'JhVy5glJgl1WNjfI/jcZxw==', 'marouen.romdhani@esprit.tn', 'rue tunis', 'ROLE_ADMIN', '2020-10-19', 'mahdiro', '73082afdf6e8f400fa4de1a0c3b6ea16.jpg', 1, 2662),
(178, 'mahdi', 'romdhani', '16k+mj5tdcoSZcgkXQ5ArA==', 'mejdi.mohamed@esprit.tn', 'rue tunisie', 'ROLE_USER', '2018-01-01', 'Medmejdi', 'e85235516d27c1e2a17d65a0b189c850.jpg', 1, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=179;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
