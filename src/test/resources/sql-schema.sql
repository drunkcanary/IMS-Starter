CREATE DATABASE `test`;
USE `test`;


DROP TABLE IF EXISTS `customers`;


CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items`(
`id` INT(20) AUTO_INCREMENT,`name` VARCHAR(30) NOT NULL, `value` FLOAT(5,2) NOT NULL, PRIMARY KEY(`id`));
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders`(
`id` INT(20) AUTO_INCREMENT,`customerID` INT(20) NOT NULL, `itemID` INT (20) NOT NULL, PRIMARY KEY(`id`));