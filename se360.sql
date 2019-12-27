-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 27 Ara 2019, 10:05:58
-- Sunucu sürümü: 10.4.8-MariaDB
-- PHP Sürümü: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `se360`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bars`
--

CREATE TABLE `bars` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `alcoholPermission` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `bars`
--

INSERT INTO `bars` (`id`, `name`, `city`, `alcoholPermission`) VALUES
(1, 'yağızın barı', 'izmir', 1),
(2, 'erelin barı', 'denizli', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bar_users`
--

CREATE TABLE `bar_users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `SSN` varchar(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `phoneNumber` varchar(255) NOT NULL,
  `userRole` enum('manager','waiter') NOT NULL,
  `bar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `bar_users`
--

INSERT INTO `bar_users` (`id`, `username`, `password`, `SSN`, `fullName`, `phoneNumber`, `userRole`, `bar`) VALUES
(1, 'smguy9', 'y1234', '15847749746', 'Yağızcan Arslan', '05071223053', 'manager', 1),
(2, 'eray', '123456', '12312312312', 'Eray Aslan', '05551231212', 'waiter', 1),
(3, 'yag', 'merhaba', '15847749746', 'yağızcan arslan', '0 507 122 30 53', 'waiter', 1),
(4, 'erel', '1234', '12312312311', 'erel öztürk', '5334126585', 'manager', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `checks`
--

CREATE TABLE `checks` (
  `id_check` int(11) NOT NULL,
  `id_table` int(11) NOT NULL,
  `id_waiter` int(11) NOT NULL,
  `is_open` tinyint(1) NOT NULL,
  `time` int(11) NOT NULL,
  `close_time` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `checks`
--

INSERT INTO `checks` (`id_check`, `id_table`, `id_waiter`, `is_open`, `time`, `close_time`) VALUES
(1, 1, 2, 1, 1577316801, 0),
(3, 6, 3, 0, 1577316801, 1577390216),
(4, 6, 1, 0, 1577390426, 1577390492),
(5, 6, 1, 0, 1577390498, 1577390675),
(6, 6, 1, 0, 1577390679, 1577391031),
(7, 2, 1, 0, 1577390692, 1577390700),
(8, 2, 1, 1, 1577390732, 0),
(9, 10, 4, 0, 1577393121, 1577394437),
(10, 10, 4, 0, 1577394641, 1577396434),
(11, 5, 1, 0, 1577399468, 1577403926),
(12, 6, 1, 0, 1577404003, 1577404051),
(13, 6, 1, 1, 1577404053, 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `check_contents`
--

CREATE TABLE `check_contents` (
  `id_check` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `check_contents`
--

INSERT INTO `check_contents` (`id_check`, `id_product`, `quantity`) VALUES
(3, 6, 3),
(5, 6, 1),
(6, 6, 1),
(6, 7, 3),
(7, 7, 1),
(8, 6, 2),
(11, 21, 1),
(12, 6, 2),
(12, 15, 1),
(13, 6, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `alcoholVolume` double DEFAULT NULL,
  `type` enum('beverage','food') NOT NULL,
  `bar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `products`
--

INSERT INTO `products` (`id`, `category`, `name`, `price`, `description`, `brand`, `alcoholVolume`, `type`, `bar`) VALUES
(6, 1, 'Efes malt', 20, 'lezzet', 'efes', 4.5, 'beverage', 1),
(7, 1, 'Tuborg Gold', 20, 'dan', 'Tuborg', 5, 'beverage', 1),
(10, 16, 'Carlsberg 50cl', 20, '', 'Carlsberg', 5, 'beverage', 2),
(11, 18, 'Chips', 12, 'Delicious chips, usually prefered with beers.', NULL, NULL, 'food', 1),
(12, 18, 'nuts', 8, 'Very fresh nuts.	', NULL, NULL, 'food', 1),
(13, 4, 'Meat Hamburger', 22, 'Very delicious hamburger with very fresh ingredients.', NULL, NULL, 'food', 1),
(14, 4, 'Chicken Hamburger', 20, 'Satisfying hamburger with unbelieveable taste!', NULL, NULL, 'food', 1),
(15, 17, 'Margarita', 16, 'With plenty of cheese', NULL, NULL, 'food', 1),
(16, 17, 'Mixed Pizza', 22, 'Ingredients: Anything you can imagine!	', NULL, NULL, 'food', 1),
(17, 20, 'Latte', 11, 'with milk	', '-', 0, 'beverage', 1),
(18, 20, 'Tea', 4.5, 'Hot tea', '-', 0, 'beverage', 1),
(19, 19, 'Whiskey In The Jar', 35, 'Very delicious whiskey', 'Johhny Walker', 45.5, 'beverage', 1),
(20, 19, 'Scotch', 40, 'Really tough whiskey.', 'Red Label', 47.5, 'beverage', 1),
(21, 3, 'Cola&Whiskey', 20, 'Very delicious blend', 'Coca Cola & JB', 12.5, 'beverage', 1),
(22, 3, 'Fanta', 6, '-', 'Fanta', 0, 'beverage', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product_categories`
--

CREATE TABLE `product_categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `type` enum('beverage','food') NOT NULL,
  `id_bar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `product_categories`
--

INSERT INTO `product_categories` (`id`, `name`, `description`, `type`, `id_bar`) VALUES
(1, 'Beers', 'Many kinds of beers from different regions...', 'beverage', 1),
(3, 'Cold Beverages', 'All kind of alcohol-free beverages.', 'beverage', 1),
(4, 'Hamburgers', 'Delicious hamburgers!', 'food', 1),
(16, 'Beer', 'cold very cold beers', 'food', 2),
(17, 'Pizza', 'Delicious Pizzas', 'food', 1),
(18, 'Snacks', 'Cheap and satisfying', 'food', 1),
(19, 'Whiskeys', 'A real MAN drink!', 'beverage', 1),
(20, 'Hot Beverages', 'Coffes, teas and more!', 'beverage', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tables`
--

CREATE TABLE `tables` (
  `id` int(11) NOT NULL,
  `shortcode` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `customerCount` int(10) NOT NULL,
  `id_bar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `tables`
--

INSERT INTO `tables` (`id`, `shortcode`, `name`, `customerCount`, `id_bar`) VALUES
(1, 'G1', 'GARDEN 1', 2, 1),
(2, 'G2', 'GARDEN 2', 0, 1),
(5, 'G5', 'GARDEN 5', 0, 1),
(6, 'G6', 'GARDEN 6', 5, 1),
(10, 'b1', 'bahçe 1', 2, 2);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `bars`
--
ALTER TABLE `bars`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `bar_users`
--
ALTER TABLE `bar_users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bar_id` (`bar`);

--
-- Tablo için indeksler `checks`
--
ALTER TABLE `checks`
  ADD PRIMARY KEY (`id_check`),
  ADD KEY `table_check_table_id_fk` (`id_table`),
  ADD KEY `table_check_waiter_id_fk` (`id_waiter`);

--
-- Tablo için indeksler `check_contents`
--
ALTER TABLE `check_contents`
  ADD PRIMARY KEY (`id_check`,`id_product`),
  ADD KEY `check_logs_product_id_fk` (`id_product`);

--
-- Tablo için indeksler `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `products_category_id_fk` (`category`),
  ADD KEY `products_bar_id_fk` (`bar`);

--
-- Tablo için indeksler `product_categories`
--
ALTER TABLE `product_categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_categories_bar_id_fk` (`id_bar`);

--
-- Tablo için indeksler `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bar` (`id_bar`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `bars`
--
ALTER TABLE `bars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `bar_users`
--
ALTER TABLE `bar_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `checks`
--
ALTER TABLE `checks`
  MODIFY `id_check` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Tablo için AUTO_INCREMENT değeri `product_categories`
--
ALTER TABLE `product_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Tablo için AUTO_INCREMENT değeri `tables`
--
ALTER TABLE `tables`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `bar_users`
--
ALTER TABLE `bar_users`
  ADD CONSTRAINT `bar_id` FOREIGN KEY (`bar`) REFERENCES `bars` (`id`);

--
-- Tablo kısıtlamaları `checks`
--
ALTER TABLE `checks`
  ADD CONSTRAINT `table_check_table_id_fk` FOREIGN KEY (`id_table`) REFERENCES `tables` (`id`),
  ADD CONSTRAINT `table_check_waiter_id_fk` FOREIGN KEY (`id_waiter`) REFERENCES `bar_users` (`id`);

--
-- Tablo kısıtlamaları `check_contents`
--
ALTER TABLE `check_contents`
  ADD CONSTRAINT `check_logs_check_id_fk` FOREIGN KEY (`id_check`) REFERENCES `checks` (`id_check`),
  ADD CONSTRAINT `check_logs_product_id_fk` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`) ON DELETE CASCADE;

--
-- Tablo kısıtlamaları `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_bar_id_fk` FOREIGN KEY (`bar`) REFERENCES `bars` (`id`),
  ADD CONSTRAINT `products_category_id_fk` FOREIGN KEY (`category`) REFERENCES `product_categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `product_categories`
--
ALTER TABLE `product_categories`
  ADD CONSTRAINT `product_categories_bar_id_fk` FOREIGN KEY (`id_bar`) REFERENCES `bars` (`id`) ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `tables`
--
ALTER TABLE `tables`
  ADD CONSTRAINT `bar` FOREIGN KEY (`id_bar`) REFERENCES `bars` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
