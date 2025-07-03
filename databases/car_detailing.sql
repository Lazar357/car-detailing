-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for car_detailing
CREATE DATABASE IF NOT EXISTS `car_detailing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `car_detailing`;

-- Dumping structure for table car_detailing.booking
DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `service` varchar(255) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `deleted_at` datetime DEFAULT NULL,
  `time` time(6) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `vehicle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlnnelfsha11xmo2ndjq66fvro` (`customer_id`),
  CONSTRAINT `FKlnnelfsha11xmo2ndjq66fvro` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_detailing.booking: ~4 rows (approximately)
INSERT INTO `booking` (`id`, `date`, `service`, `customer_id`, `created_at`, `deleted_at`, `time`, `updated_at`, `vehicle`) VALUES
	(5, '2025-07-01', 'PREMIUM', 7, '2025-06-30 21:24:34', NULL, '17:00:00.000000', '2025-06-30 21:46:58.000000', 'Audi A3'),
	(6, '2025-07-01', 'BASIC', 7, '2025-06-30 21:34:04', '2025-06-30 21:45:07', '13:30:00.000000', '2025-06-30 21:45:07.000000', 'Audi A6'),
	(7, '2025-07-26', 'STANDARD', 8, '2025-06-30 21:51:18', NULL, '15:30:00.000000', NULL, 'BMW X3'),
	(8, '2025-07-07', 'BASIC', 9, '2025-07-01 20:43:09', NULL, '14:00:00.000000', NULL, 'Mercedes E220d');

-- Dumping structure for table car_detailing.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `deleted_at` datetime DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_detailing.customer: ~6 rows (approximately)
INSERT INTO `customer` (`id`, `email`, `name`, `phone`, `created_at`, `deleted_at`, `updated_at`) VALUES
	(4, 'lazar.danic@singimail.rs', 'Lazar Danić', '0601234567', '2025-06-30 17:51:51', NULL, '2025-07-01 20:58:09.000000'),
	(5, 'mmarkovic357@singimail.rs', 'Marko Markovic', '0601333467', '2025-06-30 17:52:27', NULL, NULL),
	(6, 'iivanovic357@singimail.rs', 'Ivan Ivanovic', '060654321', '2025-06-30 19:01:24', '2025-06-30 21:34:30', '2025-06-30 21:34:30.000000'),
	(7, 'iivanovic357@singimail.rs', 'Ivan Ivanovic', '065654321', '2025-06-30 21:24:34', NULL, NULL),
	(8, 'imilosavljevic357@gmail.com', 'Ivana Milosavljevic', '065787878', '2025-06-30 21:49:33', NULL, NULL),
	(9, 'milos.andjelic.23@gmail.com', 'Milos Andjelic', '061763452', '2025-07-01 20:43:09', NULL, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
