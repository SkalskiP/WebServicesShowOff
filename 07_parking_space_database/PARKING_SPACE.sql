-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 05 Cze 2019, 11:48
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
  `id_from_account_db` int(11) NOT NULL,
  `firebase_uid` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `EMPLOYEE`
--

INSERT INTO `EMPLOYEE` (`id`, `id_from_account_db`, `firebase_uid`) VALUES
(1, 1, 'keB5QeHn3mgApHOx6JmbmCyP8f73'),
(2, 2, '0lD1uCVW5rfBVdTY94ZNDmb9tg73'),
(3, 3, 'XrhTulUX0XXb6HwuYF5ZgO3h2Lh1');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARKING_SPOT`
--

CREATE TABLE `PARKING_SPOT` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `occupied` tinyint(1) NOT NULL DEFAULT '0',
  `trigger_event_uuid` varchar(36) DEFAULT NULL,
  `street_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `PARKING_SPOT`
--

INSERT INTO `PARKING_SPOT` (`id`, `number`, `occupied`, `trigger_event_uuid`, `street_id`) VALUES
(113, 1, 0, NULL, 1),
(114, 2, 0, NULL, 1),
(115, 3, 0, NULL, 1),
(116, 4, 0, NULL, 1),
(117, 5, 0, NULL, 1),
(118, 6, 0, NULL, 1),
(119, 7, 0, NULL, 1),
(120, 1, 1, '89f4012b-b1e4-4ac9-937a-0ebb6de5b714', 2),
(121, 2, 0, NULL, 2),
(122, 3, 0, NULL, 2),
(123, 4, 0, NULL, 2),
(124, 5, 0, NULL, 2),
(125, 1, 0, NULL, 3),
(126, 2, 0, NULL, 3),
(127, 3, 0, NULL, 3),
(128, 4, 0, NULL, 3),
(129, 5, 0, NULL, 3),
(130, 6, 0, NULL, 3),
(131, 1, 0, NULL, 4),
(132, 2, 0, NULL, 4),
(133, 3, 0, NULL, 4),
(134, 4, 0, NULL, 4),
(135, 1, 0, NULL, 5),
(136, 2, 0, NULL, 5),
(137, 3, 0, NULL, 5),
(138, 4, 0, NULL, 5),
(139, 5, 0, NULL, 5),
(140, 6, 0, NULL, 5),
(141, 1, 0, NULL, 6),
(142, 2, 0, NULL, 6),
(143, 3, 0, NULL, 6),
(144, 4, 0, NULL, 6),
(145, 5, 0, NULL, 6),
(146, 6, 0, NULL, 6),
(147, 7, 0, NULL, 6),
(148, 1, 0, NULL, 7),
(149, 2, 0, NULL, 7),
(150, 3, 1, 'f5164600-b98c-466d-817d-f02cc50e203d', 7),
(151, 4, 0, NULL, 7),
(152, 1, 0, NULL, 8),
(153, 2, 0, NULL, 8),
(154, 3, 0, NULL, 8),
(155, 4, 0, NULL, 8),
(156, 5, 0, NULL, 8),
(157, 6, 0, NULL, 8),
(158, 7, 0, NULL, 8),
(159, 8, 0, NULL, 8),
(160, 1, 0, NULL, 9),
(161, 2, 0, NULL, 9),
(162, 3, 0, NULL, 9),
(163, 4, 0, NULL, 9),
(164, 1, 0, NULL, 10),
(165, 2, 0, NULL, 10),
(166, 3, 0, NULL, 10),
(167, 4, 0, NULL, 10),
(168, 5, 0, NULL, 10),
(169, 6, 0, NULL, 10),
(170, 1, 0, NULL, 11),
(171, 2, 0, NULL, 11),
(172, 3, 0, NULL, 11),
(173, 4, 0, NULL, 11),
(174, 5, 0, NULL, 11),
(175, 1, 0, NULL, 12),
(176, 2, 0, NULL, 12),
(177, 3, 0, NULL, 12),
(178, 4, 0, NULL, 12),
(179, 1, 0, NULL, 13),
(180, 2, 0, NULL, 13),
(181, 3, 0, NULL, 13),
(182, 4, 0, NULL, 13),
(183, 5, 0, NULL, 13),
(184, 1, 0, NULL, 14),
(185, 2, 0, NULL, 14),
(186, 3, 0, NULL, 14),
(187, 4, 0, NULL, 14),
(188, 5, 0, NULL, 14),
(189, 6, 0, NULL, 14),
(190, 7, 0, NULL, 14),
(191, 1, 0, NULL, 15),
(192, 2, 0, NULL, 15),
(193, 3, 0, NULL, 15),
(194, 4, 0, NULL, 15),
(195, 5, 0, NULL, 15),
(196, 1, 0, NULL, 16),
(197, 2, 0, NULL, 16),
(198, 3, 0, NULL, 16),
(199, 4, 0, NULL, 16),
(200, 1, 0, NULL, 17),
(201, 2, 0, NULL, 17),
(202, 3, 0, NULL, 17),
(203, 4, 0, NULL, 17),
(204, 5, 0, NULL, 17),
(205, 1, 0, NULL, 18),
(206, 2, 0, NULL, 18),
(207, 3, 0, NULL, 18),
(208, 4, 0, NULL, 18),
(209, 5, 0, NULL, 18),
(210, 6, 0, NULL, 18),
(211, 7, 0, NULL, 18),
(212, 1, 0, NULL, 19),
(213, 2, 0, NULL, 19),
(214, 3, 0, NULL, 19),
(215, 4, 0, NULL, 19),
(216, 5, 0, NULL, 19),
(217, 1, 0, NULL, 20),
(218, 2, 0, NULL, 20),
(219, 3, 0, NULL, 20),
(220, 4, 0, NULL, 20),
(221, 5, 0, NULL, 20),
(222, 6, 0, NULL, 20),
(223, 7, 0, NULL, 20),
(224, 1, 0, NULL, 21),
(225, 2, 0, NULL, 21),
(226, 3, 0, NULL, 21),
(227, 4, 0, NULL, 21),
(228, 5, 0, NULL, 21),
(229, 1, 0, NULL, 22),
(230, 2, 0, NULL, 22),
(231, 3, 0, NULL, 22),
(232, 4, 0, NULL, 22),
(233, 1, 0, NULL, 23),
(234, 2, 0, NULL, 23),
(235, 3, 0, NULL, 23),
(236, 4, 0, NULL, 23),
(237, 5, 0, NULL, 23),
(238, 6, 0, NULL, 23),
(239, 7, 0, NULL, 23),
(240, 1, 0, NULL, 24),
(241, 2, 0, NULL, 24),
(242, 3, 0, NULL, 24),
(243, 1, 0, NULL, 25),
(244, 2, 0, NULL, 25),
(245, 3, 0, NULL, 25),
(246, 4, 0, NULL, 25),
(247, 5, 0, NULL, 25),
(248, 6, 0, NULL, 25);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARKING_TICKET`
--

CREATE TABLE `PARKING_TICKET` (
  `id` int(11) NOT NULL,
  `parking_spot_id` int(11) NOT NULL,
  `ticket_type_id` int(11) DEFAULT NULL,
  `arrival_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `payment_time` timestamp NULL DEFAULT NULL,
  `expiry_time` timestamp NULL DEFAULT NULL,
  `departure_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `PARKING_TICKET`
--

INSERT INTO `PARKING_TICKET` (`id`, `parking_spot_id`, `ticket_type_id`, `arrival_time`, `payment_time`, `expiry_time`, `departure_time`, `status`) VALUES
(37, 140, 1, '2019-05-30 21:31:07', '2019-05-30 21:31:45', '2019-05-30 22:31:45', '2019-05-30 21:32:26', 'CLOSED'),
(50, 150, 6, '2019-05-31 06:41:53', '2019-05-31 06:42:16', '2019-05-31 06:44:16', '2019-05-31 06:45:23', 'CLOSED'),
(57, 190, 5, '2019-05-31 07:04:12', '2019-05-31 07:04:19', '2019-05-31 07:05:19', '2019-05-31 07:04:25', 'CLOSED'),
(58, 200, 5, '2019-05-31 07:10:20', '2019-05-31 07:10:38', '2019-05-31 07:11:38', '2019-05-31 07:10:45', 'CLOSED'),
(59, 195, 5, '2019-05-31 07:24:13', '2019-05-31 07:24:23', '2019-05-31 07:25:23', '2019-05-31 07:24:29', 'CLOSED'),
(99, 113, 5, '2019-06-01 21:47:00', '2019-06-01 21:47:21', '2019-06-01 21:48:21', '2019-06-01 22:10:15', 'CLOSED'),
(101, 113, 5, '2019-06-03 17:45:20', '2019-06-03 17:48:20', '2019-06-03 17:49:20', '2019-06-03 20:36:50', 'CLOSED'),
(103, 200, 5, '2019-06-03 18:32:25', '2019-06-03 18:33:49', '2019-06-03 18:34:49', '2019-06-03 20:39:12', 'CLOSED'),
(105, 210, NULL, '2019-06-03 18:39:52', NULL, NULL, '2019-06-03 18:44:45', 'CLOSED'),
(106, 215, NULL, '2019-06-03 18:39:56', NULL, NULL, '2019-06-03 18:44:50', 'CLOSED'),
(107, 120, NULL, '2019-06-03 18:40:01', NULL, NULL, '2019-06-03 18:44:41', 'CLOSED'),
(108, 115, NULL, '2019-06-03 19:08:20', NULL, NULL, '2019-06-03 19:25:43', 'CLOSED'),
(109, 200, NULL, '2019-06-03 19:08:26', NULL, NULL, '2019-06-03 19:25:52', 'CLOSED'),
(110, 120, 5, '2019-06-03 19:33:34', '2019-06-03 19:34:01', '2019-06-03 19:35:01', '2019-06-03 19:35:19', 'CLOSED'),
(111, 130, NULL, '2019-06-03 19:33:39', NULL, NULL, '2019-06-03 19:35:33', 'CLOSED'),
(112, 120, NULL, '2019-06-04 22:37:50', NULL, NULL, NULL, 'UNPAID'),
(113, 140, NULL, '2019-06-05 09:21:32', NULL, NULL, '2019-06-05 09:23:35', 'CLOSED'),
(114, 150, 5, '2019-06-05 09:23:08', '2019-06-05 09:23:19', '2019-06-05 09:24:19', NULL, 'ALARM');

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
  `duration_minutes` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `TICKET_TYPE`
--

INSERT INTO `TICKET_TYPE` (`id`, `name`, `price`, `duration_minutes`) VALUES
(1, '1 hour parking time', 1.5, 60),
(2, '2 hour parking time', 3, 120),
(3, '3 hour parking time', 6, 180),
(4, '1 day parking time', 60, 1440),
(5, '1 minut TEST', 0, 1),
(6, '2 minut TEST', 0, 2);

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
  ADD UNIQUE KEY `duration_hours` (`duration_minutes`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;
--
-- AUTO_INCREMENT dla tabeli `STREET`
--
ALTER TABLE `STREET`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT dla tabeli `TICKET_TYPE`
--
ALTER TABLE `TICKET_TYPE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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
