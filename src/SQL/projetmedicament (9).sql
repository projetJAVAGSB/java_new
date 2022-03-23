-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 23 mars 2022 à 21:49
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetmedicament`
--

-- --------------------------------------------------------

--
-- Structure de la table `composant`
--

CREATE TABLE `composant` (
  `CODE` int(11) NOT NULL,
  `CMP_LIBELLE` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `composant`
--

INSERT INTO `composant` (`CODE`, `CMP_LIBELLE`) VALUES
(1, 'Alginate de sodium '),
(2, 'Bicarbonate de sodium '),
(3, 'Ibuprofène'),
(4, 'Acide acétylsalicylique '),
(5, ' Métopimazine'),
(6, 'Paracétamol '),
(7, 'Pseudoéphédrine chlorhydrate ');

-- --------------------------------------------------------

--
-- Structure de la table `constituer`
--

CREATE TABLE `constituer` (
  `DEPOTLEGAL` int(10) NOT NULL,
  `CODE` int(5) NOT NULL,
  `CST_QTE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `constituer`
--

INSERT INTO `constituer` (`DEPOTLEGAL`, `CODE`, `CST_QTE`) VALUES
(2, 1, 500),
(2, 2, 267),
(4, 4, 100),
(4, 5, 500),
(5, 3, 200),
(6, 6, 500),
(6, 7, 30),
(10, 6, 300);

-- --------------------------------------------------------

--
-- Structure de la table `dosage`
--

CREATE TABLE `dosage` (
  `CODE` int(10) NOT NULL,
  `FORME` varchar(255) NOT NULL,
  `QUANTITE` float DEFAULT NULL,
  `UNITE` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dosage`
--

INSERT INTO `dosage` (`CODE`, `FORME`, `QUANTITE`, `UNITE`) VALUES
(1, 'GEL1000', 1000, 'mg'),
(2, 'GEL500', 500, 'mg'),
(3, 'PDR100', 100, 'mg'),
(4, 'PDR150', 150, 'mg'),
(5, 'PDR200', 200, 'mg'),
(6, 'PDR300', 300, 'mg'),
(7, 'PDR500', 500, 'mg'),
(8, 'SUP100', 100, 'mg'),
(9, 'SUP1000', 1000, 'mg'),
(10, 'SUP150', 150, 'mg'),
(11, 'SUP200', 200, 'mg'),
(12, 'SUP300', 300, 'mg'),
(13, 'CPRM1000', 1000, 'mg'),
(14, 'CPRM500', 500, 'mg'),
(15, 'CPRM300', 300, 'mg'),
(16, 'SRP150', 250, 'cl');

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

CREATE TABLE `famille` (
  `CODE` int(3) NOT NULL,
  `LIBELLE` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `famille`
--

INSERT INTO `famille` (`CODE`, `LIBELLE`) VALUES
(1, 'anticoagulant'),
(2, 'antiémétique'),
(3, 'antalgique'),
(4, 'antispasmodique'),
(5, 'antiacide'),
(6, 'anti-inflammatoire');

-- --------------------------------------------------------

--
-- Structure de la table `formuler`
--

CREATE TABLE `formuler` (
  `CODE` int(5) NOT NULL,
  `DEPOTLEGAL` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formuler`
--

INSERT INTO `formuler` (`CODE`, `DEPOTLEGAL`) VALUES
(1, 1),
(1, 2),
(1, 4),
(1, 5),
(1, 7),
(2, 5),
(3, 5),
(4, 5),
(5, 3),
(5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `interagir`
--

CREATE TABLE `interagir` (
  `PERTURBATEUR` int(10) NOT NULL,
  `PERTURBER` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `interagir`
--

INSERT INTO `interagir` (`PERTURBATEUR`, `PERTURBER`) VALUES
(1, 4),
(1, 6),
(1, 7),
(5, 6),
(6, 1),
(10, 5),
(11, 10);

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `DEPOTLEGAL` int(10) NOT NULL,
  `NOMCOMMERCIAL` varchar(25) DEFAULT NULL,
  `COMPOSITION` varchar(400) DEFAULT NULL,
  `EFFETS` varchar(500) DEFAULT NULL,
  `CONTREINDIC` varchar(255) DEFAULT NULL,
  `PRIXECHANTILLON` float DEFAULT NULL,
  `CODE` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`DEPOTLEGAL`, `NOMCOMMERCIAL`, `COMPOSITION`, `EFFETS`, `CONTREINDIC`, `PRIXECHANTILLON`, `CODE`) VALUES
(1, 'actifed rhume', 'amidon de maïs modifié, povidone, crospovidone, acide stéarique, cellulose microcristalline, silice colloïdale, magnésium stéarate', 'effet asséchant sur les sécrétions nasales, de la pseudoéphédrine, un vasoconstricteur décongestionnant et du paracétamol, qui a une action antipyrétique et antalgique.\r\n\r\nIl est utilisé pour soulager les symptômes du rhume : nez bouché, écoulement nasal, maux de tête et/ou fièvre.', 'Actifed Rhume® et Dolirhume® ne doivent surtout pas être pris en même temps car ils peuvent entraîner une augmentation de la fréquence cardiaque (palpitations, tachycardie) et de la tension artérielle (hypertension)', 4.9, 6),
(2, 'Maalox', 'acide chlorhydrique à 10 %, acide citrique monohydraté, huile essentielle de menthe poivrée, mannitol, bromure de domiphène, saccharine sodique, sorbitol liquide (non cristallisable) (E420), peroxyde d\'hydrogène, eau purifiée.', 'Ils agissent en neutralisant l\'acidité de l\'estomac. Ce médicament est utilisé pour soulager les brûlures d\'estomac et les remontées acides.', 'A ne pas mélanger avec du doliprane', 7.09, 5),
(3, 'gaviscon', 'carbonate de calcium, carbomère (974 P), saccharine sodique, arôme fenouil (anéthol de fenouil, alcool benzylique), hydroxyde de sodium, érythrosine (E 127), eau purifiée. Conservateurs : parahydroxybenzoate de méthyle (E 218) et parahydroxybenzoate de propyle (E 216)', ' Il forme un gel visqueux qui surnage dans l\'estomac et protège l\'œsophage en cas de reflux du contenu de l\'estomac.', NULL, 3.04, 5),
(4, 'aspirine', 'amidon de maïs, cellulose poudre.', 'antalgique (contre la douleur), antipyrétique (contre la fièvre), anti-inflammatoire à forte dose et antiagrégant plaquettaire (fluidifiant du sang).', 'ne pas mélanger avec  ibuprofene', 2.6, 1),
(5, 'Doliprane', 'gélatine, azorubine (E122), jaune de quinoléine (E104), oxyde de fer jaune (E172). Excipient à effet notoire : azorubine (E122)(0,135 mg/gélule). Excipients : benzoate de sodium, povidone K30, monoglycérides acétylés, arôme orange (eau, maltodextrine, gomme arabique, huile essentielle d\\\'orange), saccharose', 'utilisé pour traiter la douleur et/ou la fièvre, par exemple en cas de maux de tête, d\'état grippal, de douleurs dentaires, de courbatures, de règles douloureuses.', 'il faut éviter de le mélanger avec un autre médicament ultra courant: le Maalox® (sels d’aluminium) prescrit dans le traitement des brûlures d’estomac et des remontées acides.', 2.18, 3),
(6, 'dolirhume', 'amidon de blé, amidon de pomme de terre, carboxyméthylamidon sodique, lactose, stéarate de magnésium', 'Il est utilisé pour soulager les symptômes du rhume : nez bouché, maux de tête et/ou fièvre.', 'Actifed Rhume® et Dolirhume® ne doivent surtout pas être pris en même temps car ils peuvent entraîner une augmentation de la fréquence cardiaque (palpitations, tachycardie) et de la tension artérielle (hypertension)', 6.5, 6),
(7, 'spasfon', 'mannitol, dextran 70, sucralose, macrogol 15 hydroxystéarate', 'apaisent les spasmes des fibres musculaires et atténuent les douleurs', '', 2.14, 4),
(8, 'vogalene', 'sodium citrate, sodium chlorure, acide chlorhydrique concentré, eau ppi', 'chargées d\'apaiser le système nerveux.', '', 7.7, 2),
(9, 'ibuprofene', 'amidon prégélatinisé, sodium carboxyméthylamidon, acide stéarique, silice colloïdale anhydre, povidone K 90', ' Il prévient ou diminue la sensation de douleur légère à modérée.', 'Ne pas mélanger avec de l\'aspirine.', 3.01, 6),
(10, 'Klipal ', 'gélatine, carmellose calcique, cellulose microcristalline, talc, magnésium stéarate', 'Apaise, apporte des démangeaisons, des rougeur de peaux, somnolence, vertige   ', 'Doliprane', 1.62, 3),
(11, 'Contramal', ' cellulose microcristalline, carboxyméthylamidon sodique, stéarate de magnésium, silice colloïdale anhydre', 'vertige, démangeaison, vomissement', 'Klipal', 3.42, 3),
(12, 'Helicidine', 'gomme xanthane, saccharine sodique, maltitol liquide, arôme framboise*, parahydroxybenzoate de méthyle, sorbate de potassium, eau purifiée.\r\n*Composition de l\'arôme framboise : jus concentré de framboise, vanilline, acétate d\'héliotropyle, oxyphénylon, ionones, acide lactique.', 'Calme les toux sèches et les toux d\'irritation.\r\nPeut induire un surencombrement bronchique chez le nourrisson.Elle ne doit donc pas être utilisée chez le nourrisson', NULL, 1.83, 6),
(13, 'test', 'test', 'test', 'test', 1, 1),
(14, 'test', 'test', 'test', 'test', 1.3, 3),
(15, 'tesst23/03', 'test23', 'effet23', 'contre', 555, 5);

-- --------------------------------------------------------

--
-- Structure de la table `prescrire`
--

CREATE TABLE `prescrire` (
  `CODE` int(5) NOT NULL,
  `DOS_CODE` int(10) NOT NULL,
  `DEPOTLEGAL` int(10) NOT NULL,
  `POSSOLOGIE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `prescrire`
--

INSERT INTO `prescrire` (`CODE`, `DOS_CODE`, `DEPOTLEGAL`, `POSSOLOGIE`) VALUES
(1, 1, 1, 'test1'),
(1, 1, 2, 'test1'),
(1, 1, 3, 'test3'),
(1, 1, 4, 'test david'),
(1, 2, 3, 'test20'),
(1, 6, 3, 'test20'),
(1, 13, 5, 'test20'),
(1, 13, 10, 'Prendre 2 comprimé tout les 4heures. Ne '),
(2, 1, 3, 'test3'),
(2, 4, 3, 'test3'),
(2, 7, 3, 'test3'),
(2, 7, 5, 'Prendre 2 sachets par jour'),
(2, 7, 8, 'test6'),
(2, 7, 12, 'test6'),
(3, 1, 2, 'test7'),
(3, 1, 7, 'test9'),
(3, 5, 12, 'test10'),
(3, 6, 1, 'test23 '),
(3, 7, 1, 'test7'),
(3, 8, 1, 'test24'),
(4, 4, 7, 'test45'),
(4, 5, 1, 'test11'),
(4, 5, 4, 'test12'),
(4, 7, 7, 'test46'),
(4, 7, 11, 'test14'),
(4, 14, 7, 'Prendre 1comprimé 3fois par jour '),
(5, 3, 7, 'test15'),
(5, 3, 9, 'test15'),
(5, 4, 9, 'test45'),
(5, 4, 10, 'test46'),
(5, 8, 10, 'test46'),
(5, 9, 10, 'test47'),
(5, 11, 10, 'test48');

-- --------------------------------------------------------

--
-- Structure de la table `presentation`
--

CREATE TABLE `presentation` (
  `CODE` int(5) NOT NULL,
  `LIBELLE` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `presentation`
--

INSERT INTO `presentation` (`CODE`, `LIBELLE`) VALUES
(1, 'Comprimé'),
(2, 'Gelule'),
(3, 'Poudre'),
(4, 'Suppositoire'),
(5, 'Sirop');

-- --------------------------------------------------------

--
-- Structure de la table `type_individu`
--

CREATE TABLE `type_individu` (
  `TIN_CODE` int(5) NOT NULL,
  `TIN_LIBELLE` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_individu`
--

INSERT INTO `type_individu` (`TIN_CODE`, `TIN_LIBELLE`) VALUES
(1, 'adulte'),
(2, 'enfant'),
(3, 'jeune adulte'),
(4, 'jeune enfant'),
(5, 'nourisson');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `pseudo`, `mdp`) VALUES
(1, 'orel', '*2230EA3C81E6056FF32D7CF3BBCF9694AA831594'),
(2, 'nathane', '*ABEF03D1AC3AC26E7B700D65445ED12F776FA4B9'),
(3, 'anaia', '*B7BA4104BEE4E94E00566C4371C3FEEEA047D0F1'),
(4, 'david ', '*8201E0C1BD05201452E12ECFD5B8AFE4AEFBD053'),
(5, 'nathan', '*BD9D530A86BCBAD6BC28B3BF40EAA76F71969E1B'),
(6, 'gam', '*2B77963303C4E9BC154DF13C3BB4BDDCF5B23729'),
(12, 'Nat_5', 'azerty'),
(78, 'azertyu', 'zertyu'),
(79, 'orel', 'azerty'),
(81, 'medecin', 'admin'),
(82, 'David', '1234');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `composant`
--
ALTER TABLE `composant`
  ADD PRIMARY KEY (`CODE`);

--
-- Index pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD PRIMARY KEY (`DEPOTLEGAL`,`CODE`),
  ADD KEY `CODE` (`CODE`);

--
-- Index pour la table `dosage`
--
ALTER TABLE `dosage`
  ADD PRIMARY KEY (`CODE`);

--
-- Index pour la table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`CODE`);

--
-- Index pour la table `formuler`
--
ALTER TABLE `formuler`
  ADD PRIMARY KEY (`CODE`,`DEPOTLEGAL`),
  ADD KEY `DEPOTLEGAL` (`DEPOTLEGAL`);

--
-- Index pour la table `interagir`
--
ALTER TABLE `interagir`
  ADD PRIMARY KEY (`PERTURBATEUR`,`PERTURBER`),
  ADD KEY `PERTURBATEUR` (`PERTURBATEUR`),
  ADD KEY `PERTURBER` (`PERTURBER`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`DEPOTLEGAL`),
  ADD KEY `FAM_CODE` (`CODE`);

--
-- Index pour la table `prescrire`
--
ALTER TABLE `prescrire`
  ADD PRIMARY KEY (`CODE`,`DOS_CODE`,`DEPOTLEGAL`),
  ADD KEY `DEPOTLEGAL` (`DEPOTLEGAL`),
  ADD KEY `DOS_CODE` (`DOS_CODE`);

--
-- Index pour la table `presentation`
--
ALTER TABLE `presentation`
  ADD PRIMARY KEY (`CODE`);

--
-- Index pour la table `type_individu`
--
ALTER TABLE `type_individu`
  ADD PRIMARY KEY (`TIN_CODE`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `constituer`
--
ALTER TABLE `constituer`
  MODIFY `DEPOTLEGAL` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `famille`
--
ALTER TABLE `famille`
  MODIFY `CODE` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `formuler`
--
ALTER TABLE `formuler`
  MODIFY `DEPOTLEGAL` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `DEPOTLEGAL` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `prescrire`
--
ALTER TABLE `prescrire`
  MODIFY `DEPOTLEGAL` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `type_individu`
--
ALTER TABLE `type_individu`
  MODIFY `TIN_CODE` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `composant`
--
ALTER TABLE `composant`
  ADD CONSTRAINT `composant_ibfk_1` FOREIGN KEY (`CODE`) REFERENCES `constituer` (`CODE`);

--
-- Contraintes pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD CONSTRAINT `constituer_ibfk_1` FOREIGN KEY (`DEPOTLEGAL`) REFERENCES `medicament` (`DEPOTLEGAL`);

--
-- Contraintes pour la table `formuler`
--
ALTER TABLE `formuler`
  ADD CONSTRAINT `formuler_ibfk_1` FOREIGN KEY (`DEPOTLEGAL`) REFERENCES `medicament` (`DEPOTLEGAL`);

--
-- Contraintes pour la table `prescrire`
--
ALTER TABLE `prescrire`
  ADD CONSTRAINT `prescrire_ibfk_2` FOREIGN KEY (`DOS_CODE`) REFERENCES `dosage` (`CODE`),
  ADD CONSTRAINT `prescrire_ibfk_4` FOREIGN KEY (`DEPOTLEGAL`) REFERENCES `medicament` (`DEPOTLEGAL`);

--
-- Contraintes pour la table `presentation`
--
ALTER TABLE `presentation`
  ADD CONSTRAINT `presentation_ibfk_1` FOREIGN KEY (`CODE`) REFERENCES `formuler` (`CODE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
