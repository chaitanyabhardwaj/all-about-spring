CREATE DATABASE IF NOT EXISTS `myrestappdb`;
USE `myrestappdb`;

---
--- Table structure for animal java object
---

DROP TABLE IF EXISTS animal;

CREATE TABLE animal (
 id INT NOT NULL AUTO_INCREMENT,
 breed VARCHAR(100) DEFAULT NULL UNIQUE,
 intelligence DECIMAL NOT NULL CHECK (intelligence >= 0 AND intelligence <= 1),
 PRIMARY KEY(id));
 
 CREATE TABLE plant (
 id INT NOT NULL AUTO_INCREMENT,
 species VARCHAR(100) DEFAULT NULL UNIQUE,
 isWaterType BOOLEAN NOT NULL,
 PRIMARY KEY(id));
 
