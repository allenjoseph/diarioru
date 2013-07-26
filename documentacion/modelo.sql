SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`REQUERIMIENTO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`REQUERIMIENTO` (
  `requerimiento_id` INT NOT NULL ,
  `codigo` VARCHAR(11) NOT NULL ,
  `titulo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`requerimiento_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`USUARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`USUARIO` (
  `usuario_id` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`usuario_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DIARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`DIARIO` (
  `diario_id` INT NOT NULL ,
  `usuario_id` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`diario_id`) ,
  INDEX `usuario_fk` () ,
  CONSTRAINT `usuario_fk`
    FOREIGN KEY ()
    REFERENCES `mydb`.`USUARIO` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ITEMDIARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ITEMDIARIO` (
  `itemdiario_id` INT NOT NULL ,
  `diario_id` INT NOT NULL ,
  `requerimiento_id` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `comentario` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`itemdiario_id`) ,
  INDEX `requerimiento_fk` (`requerimiento_id` ASC) ,
  INDEX `diario_fk` (`diario_id` ASC) ,
  CONSTRAINT `requerimiento_fk`
    FOREIGN KEY (`requerimiento_id` )
    REFERENCES `mydb`.`REQUERIMIENTO` (`requerimiento_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `diario_fk`
    FOREIGN KEY (`diario_id` )
    REFERENCES `mydb`.`DIARIO` (`diario_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
