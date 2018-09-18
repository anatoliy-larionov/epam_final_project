-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital` DEFAULT CHARACTER SET utf8 ;
USE `hospital` ;

-- -----------------------------------------------------
-- Table `hospital`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`users` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(20) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `patronymic` VARCHAR(20) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_users`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`role` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `personal_role` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`patient` (
  `id_patient` INT NOT NULL AUTO_INCREMENT,
  `patient_id_user` INT NOT NULL,
  PRIMARY KEY (`id_patient`),
  INDEX `fk_patient_users1_idx` (`patient_id_user` ASC) VISIBLE,
  CONSTRAINT `fk_patient_users1`
    FOREIGN KEY (`patient_id_user`)
    REFERENCES `hospital`.`users` (`id_users`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`treatment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`treatment` (
  `id_treatment` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  `date_reception` DATE NOT NULL,
  `preliminary_diagnosis` VARCHAR(45) NOT NULL,
  `name_medicines` VARCHAR(45) NULL,
  `type_treatment` VARCHAR(15) NULL,
  `date_discharge` DATE NULL,
  `final_diagnosis` VARCHAR(45) NULL,
  PRIMARY KEY (`id_treatment`),
  INDEX `fk_treatment_patient1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_treatment_role1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_treatment_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital`.`patient` (`id_patient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_treatment_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `hospital`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`role_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`role_users` (
  `role_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `users_id`),
  INDEX `fk_role_has_users_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_role_has_users_role1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_has_users_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `hospital`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `hospital`.`users` (`id_users`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
