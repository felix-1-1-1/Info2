-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Jul 2021 um 11:03
-- Server-Version: 10.4.18-MariaDB
-- PHP-Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `informatik projekt`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `dienstag`
--

CREATE TABLE `dienstag` (
  `PK` int(11) NOT NULL,
  `Stunde` int(11) NOT NULL,
  `Fach` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `dienstag`
--

INSERT INTO `dienstag` (`PK`, `Stunde`, `Fach`) VALUES
(1, 1, 'Deutsch'),
(2, 2, 'Latein'),
(3, 3, 'Geschichte'),
(4, 4, 'Sozialkunde'),
(5, 5, 'Deutsch'),
(6, 6, 'Sozialkunde'),
(7, 8, 'Englisch'),
(8, 9, 'Wirtschaft'),
(9, 10, 'Französisch'),
(10, 11, 'Sozialkunde');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `donnerstag`
--

CREATE TABLE `donnerstag` (
  `PK` int(11) NOT NULL,
  `Stunde` int(11) NOT NULL,
  `Fach` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `donnerstag`
--

INSERT INTO `donnerstag` (`PK`, `Stunde`, `Fach`) VALUES
(1, 1, 'P-Seminar'),
(2, 2, 'Mathe'),
(3, 3, 'Deutsch'),
(4, 4, 'Geographie'),
(5, 5, 'Russisch'),
(6, 6, 'Wirtschaft'),
(7, 8, 'P-Seminar'),
(8, 9, 'W-Seminar');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `freitag`
--

CREATE TABLE `freitag` (
  `PK` int(11) NOT NULL,
  `Stunde` int(11) NOT NULL,
  `Fach` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `freitag`
--

INSERT INTO `freitag` (`PK`, `Stunde`, `Fach`) VALUES
(1, 1, 'Informatik'),
(2, 2, 'W-Seminar'),
(3, 3, 'Russisch'),
(4, 4, 'Physik'),
(5, 5, 'Wirtschaft'),
(6, 6, 'Geschichte');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kalendar`
--

CREATE TABLE `kalendar` (
  `PI` int(11) NOT NULL,
  `Datum` date NOT NULL,
  `Termin` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kalendar`
--

INSERT INTO `kalendar` (`PI`, `Datum`, `Termin`) VALUES
(1, '2020-04-13', 'Französisch Vokabeltest'),
(2, '2021-11-28', 'Englisch Vokabeltest'),
(3, '2022-04-03', 'Mathe Klausur'),
(4, '2022-08-19', 'Sozialkunde Ex'),
(5, '2021-06-04', 'P-Seminar Treffen'),
(6, '2020-09-11', 'Wirtschaft Test'),
(7, '2022-09-21', 'Russisch Vokabeltest'),
(8, '2020-10-25', 'Französisch Vokabeltest'),
(9, '2020-12-09', 'Wirtschaft Test'),
(10, '2021-12-19', 'Geschichte Exkursion'),
(11, '2022-07-08', 'Latein Vokabeltest'),
(12, '2021-07-08', 'Latein Vokabeltest'),
(13, '2021-07-07', 'W-Seminar Besprechung'),
(14, '2022-01-25', 'Russisch Vokabeltest'),
(15, '2020-08-02', 'Physik Abfrage'),
(16, '2021-12-11', 'Mathe Klausur'),
(17, '2022-12-22', 'Geographie Klausur'),
(18, '2021-06-10', 'Russisch Vokabeltest'),
(19, '2022-08-11', 'Russisch Vokabeltest'),
(20, '2020-12-24', 'Physik Abfrage'),
(21, '2020-08-13', 'P-Seminar Treffen'),
(22, '2020-08-10', 'Geschichte Exkursion'),
(23, '2021-05-21', 'Physik Abfrage'),
(24, '2021-05-14', 'Französisch Vokabeltest'),
(25, '2022-06-24', 'Geschichte Exkursion');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mittwoch`
--

CREATE TABLE `mittwoch` (
  `PK` int(11) NOT NULL,
  `Stunde` int(11) NOT NULL,
  `Fach` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `mittwoch`
--

INSERT INTO `mittwoch` (`PK`, `Stunde`, `Fach`) VALUES
(1, 1, 'Geschichte'),
(2, 2, 'Sozialkunde'),
(3, 3, 'Deutsch'),
(4, 4, 'Russisch'),
(5, 5, 'Englisch'),
(6, 6, 'Mathe');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `montag`
--

CREATE TABLE `montag` (
  `PK` int(11) NOT NULL,
  `Stunde` int(11) NOT NULL,
  `Fach` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `montag`
--

INSERT INTO `montag` (`PK`, `Stunde`, `Fach`) VALUES
(1, 1, 'Geschichte'),
(2, 2, 'Geographie'),
(3, 3, 'Englisch'),
(4, 4, 'W-Seminar'),
(5, 5, 'W-Seminar'),
(6, 6, 'Latein'),
(7, 8, 'Englisch'),
(8, 9, 'Deutsch'),
(9, 10, 'Geschichte'),
(10, 11, 'Französisch');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `noten`
--

CREATE TABLE `noten` (
  `PK` int(11) NOT NULL,
  `Fach` enum('Deutsch','Mathe','Englisch','P-Seminar','W-Seminar','Informatik','Physik','Wirtschaft','Geographie','Geschichte','Sozialkunde','Französisch','Latein','Russisch') NOT NULL,
  `Datum` date NOT NULL,
  `Punktzahl` int(2) NOT NULL,
  `Typ` enum('Mündlich','Schriftlich') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `noten`
--

INSERT INTO `noten` (`PK`, `Fach`, `Datum`, `Punktzahl`, `Typ`) VALUES
(1, 'Englisch', '2021-07-08', 2, 'Schriftlich'),
(2, 'Informatik', '2021-07-08', 11, 'Schriftlich'),
(3, 'Physik', '2021-07-08', 11, 'Mündlich'),
(4, 'Physik', '2021-07-08', 0, 'Schriftlich'),
(5, 'Englisch', '2021-07-08', 14, 'Schriftlich'),
(6, 'Physik', '2021-07-08', 4, 'Schriftlich'),
(7, 'Französisch', '2021-07-08', 7, 'Mündlich'),
(8, 'Französisch', '2021-07-08', 2, 'Mündlich'),
(9, 'Geschichte', '2021-07-08', 10, 'Schriftlich'),
(10, 'Russisch', '2021-07-08', 12, 'Schriftlich'),
(11, 'Physik', '2021-07-08', 5, 'Mündlich'),
(12, 'Russisch', '2021-07-08', 6, 'Mündlich'),
(13, 'Wirtschaft', '2021-07-08', 2, 'Schriftlich'),
(14, 'Französisch', '2021-07-08', 8, 'Mündlich'),
(15, 'Geographie', '2021-07-08', 1, 'Schriftlich'),
(16, 'Sozialkunde', '2021-07-08', 8, 'Schriftlich'),
(17, 'Sozialkunde', '2021-07-08', 2, 'Schriftlich'),
(18, 'Mathe', '2021-07-08', 4, 'Schriftlich'),
(19, 'Wirtschaft', '2021-07-08', 9, 'Mündlich'),
(20, 'Geschichte', '2021-07-08', 7, 'Mündlich'),
(21, 'W-Seminar', '2021-07-08', 5, 'Schriftlich'),
(22, 'Sozialkunde', '2021-07-08', 2, 'Mündlich'),
(23, 'Sozialkunde', '2021-07-08', 9, 'Mündlich'),
(24, 'Geographie', '2021-07-08', 0, 'Mündlich'),
(25, 'Mathe', '2021-07-08', 6, 'Mündlich'),
(26, 'Latein', '2021-07-08', 1, 'Schriftlich'),
(27, 'Geographie', '2021-07-08', 4, 'Schriftlich'),
(28, 'Deutsch', '2021-07-08', 15, 'Mündlich'),
(29, 'Deutsch', '2021-07-08', 1, 'Mündlich'),
(30, 'Englisch', '2021-07-08', 0, 'Schriftlich'),
(31, 'Geographie', '2021-07-08', 8, 'Mündlich'),
(32, 'Informatik', '2021-07-08', 6, 'Schriftlich'),
(33, 'W-Seminar', '2021-07-08', 6, 'Schriftlich'),
(34, 'W-Seminar', '2021-07-08', 14, 'Mündlich'),
(35, 'Englisch', '2021-07-08', 10, 'Mündlich'),
(36, 'Geschichte', '2021-07-08', 1, 'Mündlich'),
(37, 'Wirtschaft', '2021-07-08', 14, 'Mündlich'),
(38, 'Französisch', '2021-07-08', 12, 'Mündlich'),
(39, 'W-Seminar', '2021-07-08', 15, 'Mündlich'),
(40, 'Sozialkunde', '2021-07-08', 14, 'Schriftlich'),
(41, 'Englisch', '2021-07-08', 14, 'Schriftlich'),
(42, 'Französisch', '2021-07-08', 0, 'Mündlich'),
(43, 'W-Seminar', '2021-07-08', 15, 'Mündlich'),
(44, 'Englisch', '2021-07-08', 1, 'Schriftlich'),
(45, 'Französisch', '2021-07-08', 7, 'Schriftlich'),
(46, 'Mathe', '2021-07-08', 8, 'Mündlich'),
(47, 'Physik', '2021-07-08', 14, 'Schriftlich'),
(48, 'Deutsch', '2021-07-08', 7, 'Schriftlich'),
(49, 'Deutsch', '2021-07-08', 14, 'Mündlich'),
(50, 'Deutsch', '2021-07-08', 15, 'Mündlich'),
(51, 'Physik', '2021-07-08', 5, 'Mündlich'),
(52, 'Wirtschaft', '2021-07-08', 7, 'Schriftlich'),
(53, 'Physik', '2021-07-08', 7, 'Mündlich'),
(54, 'Mathe', '2021-07-08', 13, 'Mündlich'),
(55, 'Wirtschaft', '2021-07-08', 13, 'Mündlich'),
(56, 'Physik', '2021-07-08', 13, 'Mündlich'),
(57, 'W-Seminar', '2021-07-08', 13, 'Mündlich'),
(58, 'Physik', '2021-07-08', 6, 'Schriftlich'),
(59, 'Englisch', '2021-07-08', 10, 'Mündlich'),
(60, 'Deutsch', '2021-07-08', 10, 'Mündlich'),
(61, 'Russisch', '2021-07-08', 7, 'Schriftlich'),
(62, 'Französisch', '2021-07-08', 8, 'Schriftlich'),
(63, 'Englisch', '2021-07-08', 13, 'Schriftlich'),
(64, 'Deutsch', '2021-07-08', 2, 'Schriftlich'),
(65, 'Mathe', '2021-07-08', 9, 'Schriftlich'),
(66, 'Physik', '2021-07-08', 9, 'Mündlich'),
(67, 'Geschichte', '2021-07-08', 1, 'Mündlich'),
(68, 'Informatik', '2021-07-08', 14, 'Mündlich'),
(69, 'Mathe', '2021-07-08', 2, 'Mündlich'),
(70, 'W-Seminar', '2021-07-08', 6, 'Schriftlich'),
(71, 'P-Seminar', '2021-07-08', 9, 'Mündlich'),
(72, 'Deutsch', '2021-07-08', 11, 'Schriftlich'),
(73, 'Russisch', '2021-07-08', 14, 'Schriftlich'),
(74, 'Mathe', '2021-07-08', 8, 'Schriftlich'),
(75, 'Französisch', '2021-07-08', 5, 'Schriftlich'),
(76, 'Wirtschaft', '2021-07-08', 1, 'Mündlich'),
(77, 'Informatik', '2021-07-08', 9, 'Mündlich'),
(78, 'Mathe', '2021-07-08', 15, 'Schriftlich'),
(79, 'Deutsch', '2021-07-08', 6, 'Mündlich'),
(80, 'Geographie', '2021-07-08', 2, 'Mündlich');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `dienstag`
--
ALTER TABLE `dienstag`
  ADD PRIMARY KEY (`PK`);

--
-- Indizes für die Tabelle `donnerstag`
--
ALTER TABLE `donnerstag`
  ADD PRIMARY KEY (`PK`);

--
-- Indizes für die Tabelle `freitag`
--
ALTER TABLE `freitag`
  ADD PRIMARY KEY (`PK`);

--
-- Indizes für die Tabelle `kalendar`
--
ALTER TABLE `kalendar`
  ADD PRIMARY KEY (`PI`);

--
-- Indizes für die Tabelle `mittwoch`
--
ALTER TABLE `mittwoch`
  ADD PRIMARY KEY (`PK`);

--
-- Indizes für die Tabelle `montag`
--
ALTER TABLE `montag`
  ADD PRIMARY KEY (`PK`);

--
-- Indizes für die Tabelle `noten`
--
ALTER TABLE `noten`
  ADD PRIMARY KEY (`PK`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `dienstag`
--
ALTER TABLE `dienstag`
  MODIFY `PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `donnerstag`
--
ALTER TABLE `donnerstag`
  MODIFY `PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT für Tabelle `freitag`
--
ALTER TABLE `freitag`
  MODIFY `PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `kalendar`
--
ALTER TABLE `kalendar`
  MODIFY `PI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT für Tabelle `mittwoch`
--
ALTER TABLE `mittwoch`
  MODIFY `PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `montag`
--
ALTER TABLE `montag`
  MODIFY `PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `noten`
--
ALTER TABLE `noten`
  MODIFY `PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
