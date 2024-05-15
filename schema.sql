-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ip_web_shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ip_web_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ip_web_shop` DEFAULT CHARACTER SET utf8 ;
USE `ip_web_shop` ;

-- -----------------------------------------------------
-- Table `ip_web_shop`.`admin_customer_support`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`admin_customer_support` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `is_admin` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`attribute` (
  `id_category` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `id_category`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_parent_category` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKggadc5c0v0ghv8c5fvi2x0c5q` (`id_parent_category` ASC) VISIBLE,
  CONSTRAINT `FKggadc5c0v0ghv8c5fvi2x0c5q`
    FOREIGN KEY (`id_parent_category`)
    REFERENCES `ip_web_shop`.`category` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `avatar` VARCHAR(500) NULL DEFAULT NULL,
  `city` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `is_activated` BIT(1) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `pin` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NOT NULL,
  `contact` VARCHAR(45) NOT NULL,
  `description` LONGTEXT NOT NULL,
  `is_new` BIT(1) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(9,2) NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK5cxv31vuhc7v32omftlxa8k3c` (`id_category` ASC) VISIBLE,
  CONSTRAINT `FK5cxv31vuhc7v32omftlxa8k3c`
    FOREIGN KEY (`id_category`)
    REFERENCES `ip_web_shop`.`category` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`offer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `is_active` BIT(1) NOT NULL,
  `id_product` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKt7f2o0ewb1dgb2vxagove1gqe` (`id_product` ASC) VISIBLE,
  CONSTRAINT `FKt7f2o0ewb1dgb2vxagove1gqe`
    FOREIGN KEY (`id_product`)
    REFERENCES `ip_web_shop`.`product` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` LONGTEXT NOT NULL,
  `id_offer` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKtqhedt58w9weroxqq2kekmou` (`id_offer` ASC) VISIBLE,
  INDEX `FK3xl9c4qhiqfaqybv4pb94tevv` (`id_user` ASC) VISIBLE,
  CONSTRAINT `FK3xl9c4qhiqfaqybv4pb94tevv`
    FOREIGN KEY (`id_user`)
    REFERENCES `ip_web_shop`.`user` (`id`),
  CONSTRAINT `FKtqhedt58w9weroxqq2kekmou`
    FOREIGN KEY (`id_offer`)
    REFERENCES `ip_web_shop`.`offer` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(500) NOT NULL,
  `id_product` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKebv5p4e8gjysj4vdgkom261ru` (`id_product` ASC) VISIBLE,
  CONSTRAINT `FKebv5p4e8gjysj4vdgkom261ru`
    FOREIGN KEY (`id_product`)
    REFERENCES `ip_web_shop`.`product` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` LONGTEXT NOT NULL,
  `date_time` VARCHAR(255) NOT NULL,
  `id_user` INT NOT NULL,
  `is_read` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`payment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`purchase` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `card_number` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(255) NOT NULL,
  `id_offer` INT NOT NULL,
  `id_payment_type` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK7vg81eoqh97ob011bjo9v0500` (`id_offer` ASC) VISIBLE,
  INDEX `FKe78ia4bexaa87x3hbmrkdwmf5` (`id_payment_type` ASC) VISIBLE,
  INDEX `FK8cgl6hcbgxhwk29lqnm24nv9` (`id_user` ASC) VISIBLE,
  CONSTRAINT `FK7vg81eoqh97ob011bjo9v0500`
    FOREIGN KEY (`id_offer`)
    REFERENCES `ip_web_shop`.`offer` (`id`),
  CONSTRAINT `FK8cgl6hcbgxhwk29lqnm24nv9`
    FOREIGN KEY (`id_user`)
    REFERENCES `ip_web_shop`.`user` (`id`),
  CONSTRAINT `FKe78ia4bexaa87x3hbmrkdwmf5`
    FOREIGN KEY (`id_payment_type`)
    REFERENCES `ip_web_shop`.`payment_type` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ip_web_shop`.`value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_web_shop`.`value` (
  `id_product` INT NOT NULL,
  `id_category` INT NOT NULL,
  `id_attribute` INT NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_attribute`, `id_category`, `id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
