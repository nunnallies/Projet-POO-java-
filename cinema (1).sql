-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 02 avr. 2022 à 23:07
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `billet`
--

DROP TABLE IF EXISTS `billet`;
CREATE TABLE IF NOT EXISTS `billet` (
  `NumeroBillet` int(11) NOT NULL AUTO_INCREMENT,
  `Categorie` char(1) NOT NULL,
  `NumeroClient` int(11) NOT NULL,
  `NumeroSeance` int(11) NOT NULL,
  `Rangee` char(5) NOT NULL,
  `allee` int(11) NOT NULL,
  PRIMARY KEY (`NumeroBillet`),
  UNIQUE KEY `BILLET_Siege_AK` (`Rangee`,`allee`),
  KEY `BILLET_Client_FK` (`NumeroClient`),
  KEY `BILLET_SEANCE0_FK` (`NumeroSeance`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `NumeroClient` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `Adresse` varchar(50) NOT NULL,
  `Mail` varchar(50) NOT NULL,
  PRIMARY KEY (`NumeroClient`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`NumeroClient`, `Nom`, `Prenom`, `Age`, `Adresse`, `Mail`) VALUES
(4, 'client 4', 'prenom 4', 0, 'none', 'non'),
(5, 'snoopy', 'snoop', 14, 'non', 'doudou');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `NumeroCompte` int(11) NOT NULL AUTO_INCREMENT,
  `MotDePasse` varchar(50) NOT NULL,
  `Pseudonyme` varchar(50) NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `NumeroClient` int(11) NOT NULL,
  PRIMARY KEY (`NumeroCompte`),
  UNIQUE KEY `COMPTE_Client_AK` (`NumeroClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `matriculeemploye` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `debutcontrat` date NOT NULL,
  `login` varchar(50) NOT NULL,
  `motdepasse` varchar(50) NOT NULL,
  PRIMARY KEY (`matriculeemploye`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`matriculeemploye`, `Nom`, `prenom`, `debutcontrat`, `login`, `motdepasse`) VALUES
(1, 'Mongolo', 'Anais', '2022-03-12', 'denkipez', 'snoopy');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `NumeroFacture` int(11) NOT NULL AUTO_INCREMENT,
  `Prix` decimal(15,3) NOT NULL,
  `Date` date NOT NULL,
  `Lieu` varchar(50) NOT NULL,
  `IDREDUCTION` int(11) DEFAULT NULL,
  `NumeroClient` int(11) NOT NULL,
  `NumeroBillet` int(11) NOT NULL,
  PRIMARY KEY (`NumeroFacture`),
  KEY `FACTURE_REDUCTION_FK` (`IDREDUCTION`),
  KEY `FACTURE_Client0_FK` (`NumeroClient`),
  KEY `FACTURE_Billet_FK` (`NumeroBillet`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `IDFILM` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `Realisateur` varchar(50) NOT NULL,
  `DateDeParution` date NOT NULL,
  `Synopsis` text NOT NULL,
  `NoteDePresse` float NOT NULL,
  `NoteDeSpectateurs` float NOT NULL,
  `NombreSpec` int(11) DEFAULT NULL,
  `matriculeemploye` int(11) NOT NULL,
  `duree` time DEFAULT NULL,
  `path` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`IDFILM`),
  KEY `FILM_EMPLOYE_FK` (`matriculeemploye`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`IDFILM`, `Nom`, `Realisateur`, `DateDeParution`, `Synopsis`, `NoteDePresse`, `NoteDeSpectateurs`, `NombreSpec`, `matriculeemploye`, `duree`, `path`) VALUES
(2, 'Film4', 'Snoopy', '2022-03-12', 'Deux synopsis. ', 8.6, 7.5, NULL, 1, '00:07:00', 'C:\\Users\\Naiss\\Desktop\\ING3\\S6\\java\\TD\\ProjetJava\\src\\Vue\\Medea_01.jpg'),
(4, 'Une histoire nulle', 'Anais Mongolo', '2022-03-12', 'Un synopsis #2', 8.8, 6, NULL, 1, '00:16:00', 'meme.jpg'),
(5, 'Shang-Chi et la légende des dix anneaux', 'Destin Daniel Creton', '2021-09-01', 'Shang-Chi va devoir affronter un passé qu’il pensait avoir laissé derrière lui lorsqu’il est pris dans la toile de la mystérieuse organisation des dix anneaux.', 3.3, 3.9, 0, 1, '02:01:20', 'ShangChi.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `projeter`
--

DROP TABLE IF EXISTS `projeter`;
CREATE TABLE IF NOT EXISTS `projeter` (
  `NumeroSeance` int(11) NOT NULL,
  `IDFILM` int(11) NOT NULL,
  `matriculeemploye` int(11) NOT NULL,
  PRIMARY KEY (`NumeroSeance`,`IDFILM`,`matriculeemploye`),
  KEY `PROJETER_FILM0_FK` (`IDFILM`),
  KEY `PROJETER_EMPLOYE1_FK` (`matriculeemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projeter`
--

INSERT INTO `projeter` (`NumeroSeance`, `IDFILM`, `matriculeemploye`) VALUES
(2, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reduction`
--

DROP TABLE IF EXISTS `reduction`;
CREATE TABLE IF NOT EXISTS `reduction` (
  `IDREDUCTION` int(11) NOT NULL AUTO_INCREMENT,
  `Pourcentage` int(11) NOT NULL,
  PRIMARY KEY (`IDREDUCTION`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reduction`
--

INSERT INTO `reduction` (`IDREDUCTION`, `Pourcentage`) VALUES
(1, 30);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `NumeroSalle` int(11) NOT NULL AUTO_INCREMENT,
  `CapaciteMax` int(11) NOT NULL,
  PRIMARY KEY (`NumeroSalle`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`NumeroSalle`, `CapaciteMax`) VALUES
(1, 12),
(2, 12),
(3, 12),
(4, 12),
(5, 12),
(6, 12);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `NumeroSeance` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Heure` time NOT NULL,
  `NumeroSalle` int(11) NOT NULL,
  `DureeSeance` time DEFAULT NULL,
  PRIMARY KEY (`NumeroSeance`),
  KEY `SEANCE_SALLE_FK` (`NumeroSalle`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`NumeroSeance`, `Date`, `Heure`, `NumeroSalle`, `DureeSeance`) VALUES
(1, '2022-06-13', '00:00:02', 1, '00:00:02'),
(2, '2022-12-03', '16:00:00', 1, '20:12:00');

-- --------------------------------------------------------

--
-- Structure de la table `siege`
--

DROP TABLE IF EXISTS `siege`;
CREATE TABLE IF NOT EXISTS `siege` (
  `Rangee` char(5) NOT NULL,
  `allee` int(11) NOT NULL,
  `NumeroSalle` int(11) NOT NULL,
  `reserver` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Rangee`,`allee`,`NumeroSalle`) USING BTREE,
  KEY `Siege_SALLE_FK` (`NumeroSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `siege`
--

INSERT INTO `siege` (`Rangee`, `allee`, `NumeroSalle`, `reserver`) VALUES
('A', 1, 1, NULL),
('A', 1, 2, NULL),
('A', 1, 3, NULL),
('A', 1, 4, NULL),
('A', 1, 5, NULL),
('A', 2, 1, NULL),
('A', 2, 2, NULL),
('A', 2, 3, NULL),
('A', 2, 4, NULL),
('A', 2, 5, NULL),
('B', 1, 1, NULL),
('B', 1, 2, NULL),
('B', 1, 3, NULL),
('B', 1, 4, NULL),
('B', 1, 5, NULL),
('B', 2, 1, NULL),
('B', 2, 2, NULL),
('B', 2, 3, NULL),
('B', 2, 4, NULL),
('B', 2, 5, NULL),
('C', 1, 1, NULL),
('C', 1, 2, NULL),
('C', 1, 3, NULL),
('C', 1, 4, NULL),
('C', 1, 5, NULL),
('C', 2, 1, NULL),
('C', 2, 2, NULL),
('C', 2, 3, NULL),
('C', 2, 4, NULL),
('C', 2, 5, NULL),
('D', 1, 1, NULL),
('D', 1, 2, NULL),
('D', 1, 3, NULL),
('D', 1, 4, NULL),
('D', 1, 5, NULL),
('D', 2, 1, NULL),
('D', 2, 2, NULL),
('D', 2, 3, NULL),
('D', 2, 4, NULL),
('D', 2, 5, NULL),
('E', 1, 1, NULL),
('E', 1, 2, NULL),
('E', 1, 3, NULL),
('E', 1, 4, NULL),
('E', 1, 5, NULL),
('E', 2, 1, NULL),
('E', 2, 2, NULL),
('E', 2, 3, NULL),
('E', 2, 4, NULL),
('E', 2, 5, NULL),
('F', 1, 1, NULL),
('F', 1, 2, NULL),
('F', 1, 3, NULL),
('F', 1, 4, NULL),
('F', 1, 5, NULL),
('F', 2, 1, NULL),
('F', 2, 2, NULL),
('F', 2, 3, NULL),
('F', 2, 4, NULL),
('F', 2, 5, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `billet`
--
ALTER TABLE `billet`
  ADD CONSTRAINT `BILLET_Client_FK` FOREIGN KEY (`NumeroClient`) REFERENCES `client` (`NumeroClient`),
  ADD CONSTRAINT `BILLET_SEANCE0_FK` FOREIGN KEY (`NumeroSeance`) REFERENCES `seance` (`NumeroSeance`),
  ADD CONSTRAINT `BILLET_Siege1_FK` FOREIGN KEY (`Rangee`,`allee`) REFERENCES `siege` (`Rangee`, `allee`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `COMPTE_Client_FK` FOREIGN KEY (`NumeroClient`) REFERENCES `client` (`NumeroClient`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FACTURE_Client0_FK` FOREIGN KEY (`NumeroClient`) REFERENCES `client` (`NumeroClient`),
  ADD CONSTRAINT `FACTURE_REDUCTION_FK` FOREIGN KEY (`IDREDUCTION`) REFERENCES `reduction` (`IDREDUCTION`);

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FILM_EMPLOYE_FK` FOREIGN KEY (`matriculeemploye`) REFERENCES `employe` (`matriculeemploye`);

--
-- Contraintes pour la table `projeter`
--
ALTER TABLE `projeter`
  ADD CONSTRAINT `PROJETER_EMPLOYE1_FK` FOREIGN KEY (`matriculeemploye`) REFERENCES `employe` (`matriculeemploye`),
  ADD CONSTRAINT `PROJETER_FILM0_FK` FOREIGN KEY (`IDFILM`) REFERENCES `film` (`IDFILM`),
  ADD CONSTRAINT `PROJETER_SEANCE_FK` FOREIGN KEY (`NumeroSeance`) REFERENCES `seance` (`NumeroSeance`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `SEANCE_SALLE_FK` FOREIGN KEY (`NumeroSalle`) REFERENCES `salle` (`NumeroSalle`);

--
-- Contraintes pour la table `siege`
--
ALTER TABLE `siege`
  ADD CONSTRAINT `Siege_SALLE_FK` FOREIGN KEY (`NumeroSalle`) REFERENCES `salle` (`NumeroSalle`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
