-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Сен 26 2016 г., 05:20
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `test`
--

-- --------------------------------------------------------

--
-- Структура таблицы `account`
--

CREATE TABLE `account` (
  `id` int(3) NOT NULL,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `account`
--

INSERT INTO `account` (`id`, `login`, `password`) VALUES
(1, 'ncremo01@tut.by', 'avtotest_2016'),
(2, 'neman2016@tut.by', 'avtotest_2016'),
(3, 'nemanskaja39_10@tut.by', 'avtotest_2016'),
(4, 'nemanskaja39_3@tut.by', 'avtotest_25082016'),
(5, 'nemanskaja39_4@tut.by', 'avtotest_26082016'),
(6, 'nemanskaja39_5@tut.by', 'avtotest_2016'),
(7, 'nemanskaja39_6@tut.by', 'avtotest_2016'),
(8, 'nemanskaja39_7@tut.by', 'avtotest_2016'),
(9, 'nemanskaja39_8@tut.by', 'avtotest_2016'),
(10, 'nemanskaja39_9@tut.by', 'avtotest_2016');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
