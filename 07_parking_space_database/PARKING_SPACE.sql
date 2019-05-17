-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 17 Maj 2019, 14:19
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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARKING_SPOT`
--

CREATE TABLE `PARKING_SPOT` (
  `id` int(11) NOT NULL,
  `number` int(3) NOT NULL,
  `street_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARKING_TICKET`
--

CREATE TABLE `PARKING_TICKET` (
  `id` int(11) NOT NULL,
  `parking_spot_id` int(11) NOT NULL,
  `ticket_type_id` int(11) DEFAULT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` int(11) DEFAULT NULL,
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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `TICKET_TYPE`
--

CREATE TABLE `TICKET_TYPE` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `duration_hours` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `PARKING_SPOT`
--
ALTER TABLE `PARKING_SPOT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `PARKING_TICKET`
--
ALTER TABLE `PARKING_TICKET`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `STREET`
--
ALTER TABLE `STREET`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `TICKET_TYPE`
--
ALTER TABLE `TICKET_TYPE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `ZONE`
--
ALTER TABLE `ZONE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
