-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 05, 2022 alle 12:00
-- Versione del server: 10.1.32-MariaDB
-- Versione PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `circolovela`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `boat`
--

CREATE TABLE `boat` (
  `id_boat` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `length` float NOT NULL,
  `fk_socio` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `boat`
--

INSERT INTO `boat` (`id_boat`, `name`, `length`, `fk_socio`) VALUES
(1, 'SpingereCavallo', 15, 'PWGRYN96L10'),
(9, 'laGrandeOnda', 15, 'YWBPLN98B28');

-- --------------------------------------------------------

--
-- Struttura della tabella `competition`
--

CREATE TABLE `competition` (
  `id_competition` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `date` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `competition`
--

INSERT INTO `competition` (`id_competition`, `name`, `price`, `date`, `location`) VALUES
(4, 'GaraDiVelocita', 15, '2022-03-18', 'fiume_po'),
(5, 'Gara2', 30, '2022-06-13', 'lago_garda');

-- --------------------------------------------------------

--
-- Struttura della tabella `payment`
--

CREATE TABLE `payment` (
  `id_payment` int(11) NOT NULL,
  `method_payment` varchar(4) NOT NULL,
  `type_payment` varchar(255) NOT NULL,
  `import` float NOT NULL,
  `date` varchar(255) NOT NULL,
  `fk_partner` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `payment`
--

INSERT INTO `payment` (`id_payment`, `method_payment`, `type_payment`, `import`, `date`, `fk_partner`) VALUES
(5, '1', 'Iscrizione Gara', 16, '2022-02-15', 'YWBPLN98B28'),
(6, '0', 'Iscrizione Gara', 16, '2022-02-15', 'PWGRYN96L10'),
(7, '1', 'Iscrizione', 10, '2022-02-15', 'YWBPLN98B28'),
(8, '1', 'Pagamento Rimessaggio', 100, '2022-02-15', 'YWBPLN98B28'),
(9, '1', 'Iscrizione', 10, '2022-03-07', 'YWBPLN98B28'),
(10, '1', 'Iscrizione Gara', 16, '2022-03-07', 'YWBPLN98B28'),
(11, '1', 'Iscrizione Gara', 16, '2022-03-07', 'YWBPLN98B28'),
(27, '0', 'Iscrizione', 10, '2022-03-14', 'YWBPLN98B28'),
(34, '0', 'Iscrizione Gara', 16, '2022-03-17', 'YWBPLN98B28'),
(35, '1', 'Iscrizione Gara', 30, '2022-03-18', 'YWBPLN98B28');

-- --------------------------------------------------------

--
-- Struttura della tabella `race`
--

CREATE TABLE `race` (
  `fk_competition` int(11) NOT NULL,
  `fk_boat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `race`
--

INSERT INTO `race` (`fk_competition`, `fk_boat`) VALUES
(5, 9);

-- --------------------------------------------------------

--
-- Struttura della tabella `socio`
--

CREATE TABLE `socio` (
  `codice_fiscale` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `debit_card` varchar(255) NOT NULL,
  `iban` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `socio`
--

INSERT INTO `socio` (`codice_fiscale`, `username`, `password`, `first_name`, `last_name`, `address`, `debit_card`, `iban`) VALUES
('PWGRYN96L10', 'BigChicco', 'bg', 'Silvio', 'Ronca', 'Francesco Crispi', '1234 5678 9101 1121\r\n', 'IT03A0300203280558287728723'),
('SFHZRZ27C28H152R', 'Mauro', 'mr', 'Mauro', 'rossi', 'via dei bersaglieri', '176483279462', 'NL93ABNA1655314556'),
('YWBPLN98B28', 'Mala0000', 'ml', 'Alex', 'Malavolta', 'Villa Veneziano\r\n', '3456 7891 0111 1234', 'IT58J0300203280161874786849');

-- --------------------------------------------------------

--
-- Struttura della tabella `staff`
--

CREATE TABLE `staff` (
  `id_staff` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `passwd` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `staff`
--

INSERT INTO `staff` (`id_staff`, `first_name`, `last_name`, `passwd`) VALUES
(1, 'Sara', 'Ercole', 'sr'),
(2, 'Francesco', 'Ercole', 'fr');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `boat`
--
ALTER TABLE `boat`
  ADD PRIMARY KEY (`id_boat`),
  ADD KEY `fk_socio` (`fk_socio`);

--
-- Indici per le tabelle `competition`
--
ALTER TABLE `competition`
  ADD PRIMARY KEY (`id_competition`);

--
-- Indici per le tabelle `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id_payment`),
  ADD KEY `fk_partner` (`fk_partner`);

--
-- Indici per le tabelle `race`
--
ALTER TABLE `race`
  ADD KEY `fk_boat` (`fk_boat`),
  ADD KEY `fk_competition` (`fk_competition`);

--
-- Indici per le tabelle `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`codice_fiscale`);

--
-- Indici per le tabelle `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id_staff`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `boat`
--
ALTER TABLE `boat`
  MODIFY `id_boat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `competition`
--
ALTER TABLE `competition`
  MODIFY `id_competition` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `payment`
--
ALTER TABLE `payment`
  MODIFY `id_payment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `boat`
--
ALTER TABLE `boat`
  ADD CONSTRAINT `fk_socio` FOREIGN KEY (`fk_socio`) REFERENCES `socio` (`codice_fiscale`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_partner` FOREIGN KEY (`fk_partner`) REFERENCES `socio` (`codice_fiscale`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `race`
--
ALTER TABLE `race`
  ADD CONSTRAINT `fk_boat` FOREIGN KEY (`fk_boat`) REFERENCES `boat` (`id_boat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_competition` FOREIGN KEY (`fk_competition`) REFERENCES `competition` (`id_competition`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
