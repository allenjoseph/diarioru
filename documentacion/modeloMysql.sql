SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `diarioru` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `diarioru` ;

-- -----------------------------------------------------
-- Table `diarioru`.`REQUERIMIENTO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `diarioru`.`REQUERIMIENTO` (
  `requerimiento_id` INT NOT NULL ,
  `codigo` VARCHAR(11) NOT NULL ,
  `titulo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`requerimiento_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `diarioru`.`USUARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `diarioru`.`USUARIO` (
  `usuario_id` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`usuario_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `diarioru`.`DIARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `diarioru`.`DIARIO` (
  `diario_id` INT NOT NULL ,
  `usuario_id` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`diario_id`) ,
  INDEX `usuario_fk` (`usuario_id` ASC) ,
  CONSTRAINT `usuario_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `diarioru`.`USUARIO` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `diarioru`.`ITEMDIARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `diarioru`.`ITEMDIARIO` (
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
    REFERENCES `diarioru`.`REQUERIMIENTO` (`requerimiento_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `diario_fk`
    FOREIGN KEY (`diario_id` )
    REFERENCES `diarioru`.`DIARIO` (`diario_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
