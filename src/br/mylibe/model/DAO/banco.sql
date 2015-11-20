-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema myLibe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema myLibe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `myLibe` DEFAULT CHARACTER SET utf8 ;
USE `myLibe` ;

-- -----------------------------------------------------
-- Table `myLibe`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myLibe`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `username` VARCHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `hash` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `myLibe`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myLibe`.`book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `pages` INT(11) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_book_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_book_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `myLibe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `myLibe`.`readBook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myLibe`.`readBook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `beginReadDate` DATE NULL DEFAULT NULL,
  `endReadDate` DATE NULL DEFAULT NULL,
  `book_id` INT(11) NOT NULL,
  `book_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `book_id`, `book_user_id`),
  INDEX `fk_readBook_book1_idx` (`book_id` ASC, `book_user_id` ASC),
  CONSTRAINT `fk_readBook_book1`
    FOREIGN KEY (`book_id` , `book_user_id`)
    REFERENCES `myLibe`.`book` (`id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `myLibe`.`wishList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myLibe`.`wishList` (
  `idwishList` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  `dateOfWish` DATE NULL DEFAULT NULL,
  `active` INT(1) NOT NULL,
  PRIMARY KEY (`idwishList`, `book_id`),
  INDEX `fk_wishList_book1_idx` (`book_id` ASC),
  CONSTRAINT `fk_wishList_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `myLibe`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
