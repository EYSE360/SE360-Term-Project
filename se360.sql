-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 26 Ara 2019, 11:08:58
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
(1, 'asdasdsadadsa', 'izmir', 1),
(2, 'erelin barı', 'denizli', 0),
(3, 'asd', 'izmir', 0),
(4, 'asd', 'izmir', 0);

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
(1, 'smguy9', 'mybeteth', '15847749746', 'Yağızcan Arslan', '05071223053', 'manager', 1),
(2, 'eray', '123456', '12312312312', 'Eray Aslan', '05551231212', 'waiter', 1),
(3, 'yag', 'merhaba', '15847749746', 'yağızcan arslan', '0 507 122 30 53', 'waiter', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `beverages`
--

CREATE TABLE `beverages` (
  `product` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL,
  `brand` varchar(255) NOT NULL,
  `alcoholVolume` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `beverages`
--

INSERT INTO `beverages` (`product`, `name`, `price`, `description`, `brand`, `alcoholVolume`) VALUES
(6, 'efes malt', 0, 'lezzetli bira		', 'efes', 4.5),
(7, 'gold', 0, 'dan', 'tuborg', 5),
(8, 'JB', 30, 'JBJBJBJB', 'JB', 30);

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
(1, 1, 2, 1, 1577316801, 0);

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
(1, 2, 2),
(1, 6, 5),
(1, 7, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `foods`
--

CREATE TABLE `foods` (
  `product` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `foods`
--

INSERT INTO `foods` (`product`, `name`, `price`, `description`) VALUES
(2, 'Tavuklu Pizza', 20, 'Özel pizza sosu, tavuk parçaları, mantar ve mozarella');

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
(2, 2, 'Tavuklu Pizza', 20, 'Özel pizza sosu, tavuk parçaları, mantar ve mozarella', NULL, NULL, 'food', 1),
(6, 1, 'efes malt', 20, 'lezzet', 'efes', 4.5, 'beverage', 1),
(7, 1, 'gold', 20, 'dan', 'tuborg', 5, 'beverage', 1),
(8, 5, 'JB', 30, 'JBJBJB', 'jb', 30, 'beverage', 1);

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
(1, 'Bira', 'Biralar', 'beverage', 1),
(2, 'Pizza', 'Özenle hazırlanmış müthiş pizzalarımız', 'food', 1),
(3, 'Meşrubat', 'Soğuk ...', 'beverage', 1),
(4, 'Hamburgerler', 'Lezzetli hamburgerlerimiz', 'food', 1),
(5, 'Viski', 'out of ideas', 'beverage', 1);

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
(1, 'G1', 'GARDEN 1', 15, 1),
(2, 'G2', 'GARDEN 2', 0, 1),
(5, 'G5', 'GARDEN 5', 0, 1),
(6, 'G6', 'GARDEN 6', 0, 1),
(8, 'g12123', 'GARDEN4', 0, 1);

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
-- Tablo için indeksler `beverages`
--
ALTER TABLE `beverages`
  ADD PRIMARY KEY (`product`);

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
  ADD PRIMARY KEY (`id_check`,`id_product`);

--
-- Tablo için indeksler `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`product`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `checks`
--
ALTER TABLE `checks`
  MODIFY `id_check` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `product_categories`
--
ALTER TABLE `product_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `tables`
--
ALTER TABLE `tables`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `bar_users`
--
ALTER TABLE `bar_users`
  ADD CONSTRAINT `bar_id` FOREIGN KEY (`bar`) REFERENCES `bars` (`id`);

--
-- Tablo kısıtlamaları `beverages`
--
ALTER TABLE `beverages`
  ADD CONSTRAINT `product_id_fk` FOREIGN KEY (`product`) REFERENCES `products` (`id`);

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
  ADD CONSTRAINT `check_logs_check_id_fk` FOREIGN KEY (`id_check`) REFERENCES `checks` (`id_check`);

--
-- Tablo kısıtlamaları `foods`
--
ALTER TABLE `foods`
  ADD CONSTRAINT `foods_product_id_fk2` FOREIGN KEY (`product`) REFERENCES `products` (`id`);

--
-- Tablo kısıtlamaları `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_bar_id_fk` FOREIGN KEY (`bar`) REFERENCES `bars` (`id`),
  ADD CONSTRAINT `products_category_id_fk` FOREIGN KEY (`category`) REFERENCES `product_categories` (`id`);

--
-- Tablo kısıtlamaları `product_categories`
--
ALTER TABLE `product_categories`
  ADD CONSTRAINT `product_categories_bar_id_fk` FOREIGN KEY (`id_bar`) REFERENCES `bars` (`id`);

--
-- Tablo kısıtlamaları `tables`
--
ALTER TABLE `tables`
  ADD CONSTRAINT `bar` FOREIGN KEY (`id_bar`) REFERENCES `bars` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
