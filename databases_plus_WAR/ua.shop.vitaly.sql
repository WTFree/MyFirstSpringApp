-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.35-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for onlinewebshop
CREATE DATABASE ONLINEWEBSHOP/*!40100 DEFAULT CHARACTER SET utf8 */;
USE ONLINEWEBSHOP

-- Dumping structure for table onlinewebshop.user
  CREATE TABLE IF NOT EXISTS `onlinewebshop1`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  -- Dumping data for table onlinewebshop.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `password`) VALUES
	(1, 'admin', '21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
  
  -- Dumping structure for table onlinewebshop.product
  CREATE TABLE IF NOT EXISTS `onlinewebshop1`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `img` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  -- Dumping data for table onlinewebshop.products: ~1 rows (approximately)
DELETE FROM `products`;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `name`, `price`,`type`,`img`) VALUES
	(1, 'Sumsung', '4$','Phone','views/images/product/s1');
    /*!40000 ALTER TABLE `products` ENABLE KEYS */;

  
  -- Dumping structure for table onlinewebshop.basket
  CREATE TABLE IF NOT EXISTS `onlinewebshop1`.`basket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL,
  `id_product` INT NULL,
  PRIMARY KEY (`id`));
  
   -- Dumping data for table onlinewebshop.basket: ~1 rows (approximately)
DELETE FROM `basket`;
/*!40000 ALTER TABLE `basket` DISABLE KEYS */;
INSERT INTO `basket` (`id`, `id_user`, `id_product`) VALUES
	(1, '1', '1');
    /*!40000 ALTER TABLE `basket` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;




