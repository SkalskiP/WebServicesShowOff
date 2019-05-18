-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 18 Maj 2019, 23:19
-- Wersja serwera: 5.7.25-0ubuntu0.18.04.2
-- Wersja PHP: 7.0.33-5+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `PARKING_SPACE`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `EMPLOYEE`
--

CREATE TABLE `EMPLOYEE` (
  `id` int(11) NOT NULL,
  `id_from_account_db` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `EMPLOYEE`
--

INSERT INTO `EMPLOYEE` (`id`, `id_from_account_db`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARKING_SPOT`
--

CREATE TABLE `PARKING_SPOT` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `occupied` tinyint(1) NOT NULL DEFAULT '0',
  `street_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `PARKING_SPOT`
--

INSERT INTO `PARKING_SPOT` (`id`, `number`, `occupied`, `street_id`) VALUES
(113, 1, 0, 1),
(114, 2, 0, 1),
(115, 3, 0, 1),
(116, 4, 0, 1),
(117, 5, 0, 1),
(118, 6, 0, 1),
(119, 7, 0, 1),
(120, 1, 0, 2),
(121, 2, 0, 2),
(122, 3, 0, 2),
(123, 4, 0, 2),
(124, 5, 0, 2),
(125, 1, 0, 3),
(126, 2, 0, 3),
(127, 3, 0, 3),
(128, 4, 0, 3),
(129, 5, 0, 3),
(130, 6, 0, 3),
(131, 1, 0, 4),
(132, 2, 0, 4),
(133, 3, 0, 4),
(134, 4, 0, 4),
(135, 1, 0, 5),
(136, 2, 0, 5),
(137, 3, 0, 5),
(138, 4, 0, 5),
(139, 5, 0, 5),
(140, 6, 0, 5),
(141, 1, 0, 6),
(142, 2, 0, 6),
(143, 3, 0, 6),
(144, 4, 0, 6),
(145, 5, 0, 6),
(146, 6, 0, 6),
(147, 7, 0, 6),
(148, 1, 0, 7),
(149, 2, 0, 7),
(150, 3, 0, 7),
(151, 4, 0, 7),
(152, 1, 0, 8),
(153, 2, 0, 8),
(154, 3, 0, 8),
(155, 4, 0, 8),
(156, 5, 0, 8),
(157, 6, 0, 8),
(158, 7, 0, 8),
(159, 8, 0, 8),
(160, 1, 0, 9),
(161, 2, 0, 9),
(162, 3, 0, 9),
(163, 4, 0, 9),
(164, 1, 0, 10),
(165, 2, 0, 10),
(166, 3, 0, 10),
(167, 4, 0, 10),
(168, 5, 0, 10),
(169, 6, 0, 10),
(170, 1, 0, 11),
(171, 2, 0, 11),
(172, 3, 0, 11),
(173, 4, 0, 11),
(174, 5, 0, 11),
(175, 1, 0, 12),
(176, 2, 0, 12),
(177, 3, 0, 12),
(178, 4, 0, 12),
(179, 1, 0, 13),
(180, 2, 0, 13),
(181, 3, 0, 13),
(182, 4, 0, 13),
(183, 5, 0, 13),
(184, 1, 0, 14),
(185, 2, 0, 14),
(186, 3, 0, 14),
(187, 4, 0, 14),
(188, 5, 0, 14),
(189, 6, 0, 14),
(190, 7, 0, 14),
(191, 1, 0, 15),
(192, 2, 0, 15),
(193, 3, 0, 15),
(194, 4, 0, 15),
(195, 5, 0, 15),
(196, 1, 0, 16),
(197, 2, 0, 16),
(198, 3, 0, 16),
(199, 4, 0, 16),
(200, 1, 0, 17),
(201, 2, 0, 17),
(202, 3, 0, 17),
(203, 4, 0, 17),
(204, 5, 0, 17),
(205, 1, 0, 18),
(206, 2, 0, 18),
(207, 3, 0, 18),
(208, 4, 0, 18),
(209, 5, 0, 18),
(210, 6, 0, 18),
(211, 7, 0, 18),
(212, 1, 0, 19),
(213, 2, 0, 19),
(214, 3, 0, 19),
(215, 4, 0, 19),
(216, 5, 0, 19),
(217, 1, 0, 20),
(218, 2, 0, 20),
(219, 3, 0, 20),
(220, 4, 0, 20),
(221, 5, 0, 20),
(222, 6, 0, 20),
(223, 7, 0, 20),
(224, 1, 0, 21),
(225, 2, 0, 21),
(226, 3, 0, 21),
(227, 4, 0, 21),
(228, 5, 0, 21),
(229, 1, 0, 22),
(230, 2, 0, 22),
(231, 3, 0, 22),
(232, 4, 0, 22),
(233, 1, 0, 23),
(234, 2, 0, 23),
(235, 3, 0, 23),
(236, 4, 0, 23),
(237, 5, 0, 23),
(238, 6, 0, 23),
(239, 7, 0, 23),
(240, 1, 0, 24),
(241, 2, 0, 24),
(242, 3, 0, 24),
(243, 1, 0, 25),
(244, 2, 0, 25),
(245, 3, 0, 25),
(246, 4, 0, 25),
(247, 5, 0, 25),
(248, 6, 0, 25);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARKING_TICKET`
--

CREATE TABLE `PARKING_TICKET` (
  `id` int(11) NOT NULL,
  `parking_spot_id` int(11) NOT NULL,
  `ticket_type_id` int(11) DEFAULT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `STREET`
--

CREATE TABLE `STREET` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `zone_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `STREET`
--

INSERT INTO `STREET` (`id`, `name`, `zone_id`) VALUES
(1, 'Ulica Augustiańska', 1),
(2, 'Ulica Bartosza', 1),
(3, 'Ulica Bonifraterska', 1),
(4, 'Ulica Adama Chmielowskiego', 1),
(5, 'Ulica Dajwór', 2),
(6, 'Ulica Estery', 2),
(7, 'Plac Nowy', 2),
(8, 'Ulica Starowiślna', 2),
(9, 'Ulica Długa', 3),
(10, 'Ulica Krowoderska', 3),
(11, 'Ulica Słowiańska', 3),
(12, 'Ulica Krótka', 4),
(13, 'Ulica Krzywa', 4),
(14, 'Ulica św. Filipa', 4),
(15, 'Ulica Szlak', 5),
(16, 'Ulica Pędzichów', 5),
(17, 'Ulica Stefana Staszica', 5),
(18, 'Ulica Łobzowska', 5),
(19, 'Ulica Sienna', 8),
(20, 'Mały Rynek', 8),
(21, 'Ulica Mikołajska', 8),
(22, 'Ulica Szpitalna', 8),
(23, 'Ulica św. Tomasza', 9),
(24, 'Ulica św. Krzyża', 9),
(25, 'Plac św. Ducha', 9);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `TICKET_TYPE`
--

CREATE TABLE `TICKET_TYPE` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `duration_hours` int(3) NOT NULL,
  `duration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `TICKET_TYPE`
--

INSERT INTO `TICKET_TYPE` (`id`, `name`, `price`, `duration_hours`, `duration`) VALUES
(1, '1 hour parking time', 1.5, 1, 0),
(2, '2 hour parking time', 3, 2, 0),
(3, '3 hour parking time', 6, 3, 0),
(4, '1 day parking time', 60, 24, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ZONE`
--

CREATE TABLE `ZONE` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `ZONE`
--

INSERT INTO `ZONE` (`id`, `name`, `employee_id`) VALUES
(1, 'Kazimierz strefa 1', 1),
(2, 'Kazimierz strefa 2', 1),
(3, 'Kleparz strefa 1', 2),
(4, 'Kleparz strefa 2', 2),
(5, 'Kleparz strefa 3', 2),
(8, 'Stare Miasto strefa 1', 3),
(9, 'Stare Miasto strefa 2', 3);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `EMPLOYEE`
--
ALTER TABLE `EMPLOYEE`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `PARKING_SPOT`
--
ALTER TABLE `PARKING_SPOT`
  ADD PRIMARY KEY (`id`),
  ADD KEY `street_id` (`street_id`);

--
-- Indexes for table `PARKING_TICKET`
--
ALTER TABLE `PARKING_TICKET`
  ADD PRIMARY KEY (`id`),
  ADD KEY `parking_spot_id` (`parking_spot_id`),
  ADD KEY `ticket_type_id` (`ticket_type_id`);

--
-- Indexes for table `STREET`
--
ALTER TABLE `STREET`
  ADD PRIMARY KEY (`id`),
  ADD KEY `zone_id` (`zone_id`);

--
-- Indexes for table `TICKET_TYPE`
--
ALTER TABLE `TICKET_TYPE`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `duration_hours` (`duration_hours`);

--
-- Indexes for table `ZONE`
--
ALTER TABLE `ZONE`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `EMPLOYEE`
--
ALTER TABLE `EMPLOYEE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `PARKING_SPOT`
--
ALTER TABLE `PARKING_SPOT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=249;
--
-- AUTO_INCREMENT dla tabeli `PARKING_TICKET`
--
ALTER TABLE `PARKING_TICKET`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `STREET`
--
ALTER TABLE `STREET`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT dla tabeli `TICKET_TYPE`
--
ALTER TABLE `TICKET_TYPE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `ZONE`
--
ALTER TABLE `ZONE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `PARKING_SPOT`
--
ALTER TABLE `PARKING_SPOT`
  ADD CONSTRAINT `FK25d5vkebmro1qtvuisbhalo6c` FOREIGN KEY (`street_id`) REFERENCES `STREET` (`id`);

--
-- Ograniczenia dla tabeli `PARKING_TICKET`
--
ALTER TABLE `PARKING_TICKET`
  ADD CONSTRAINT `FK6jf8x6tvmi6cfvtk5pc3nairl` FOREIGN KEY (`ticket_type_id`) REFERENCES `TICKET_TYPE` (`id`),
  ADD CONSTRAINT `FKhy73v0dkg87d4fqkh4htm41hd` FOREIGN KEY (`parking_spot_id`) REFERENCES `PARKING_SPOT` (`id`);

--
-- Ograniczenia dla tabeli `STREET`
--
ALTER TABLE `STREET`
  ADD CONSTRAINT `FK33h8kypmu937k28m5bqiu6af2` FOREIGN KEY (`zone_id`) REFERENCES `ZONE` (`id`);

--
-- Ograniczenia dla tabeli `ZONE`
--
ALTER TABLE `ZONE`
  ADD CONSTRAINT `FK7finhvmw3erxui3yfm24pirh5` FOREIGN KEY (`employee_id`) REFERENCES `EMPLOYEE` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
