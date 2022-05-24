SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema DBPIMartesGrupo5

-- -----------------------------------------------------
-- Schema DBPIMartesGrupo5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBPIMartesGrupo5` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;
USE `DBPIMartesGrupo5` ;

-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`residente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`residente` (
  `idresidente` INT NOT NULL AUTO_INCREMENT,
  `iddepartamento` INT NULL DEFAULT NULL,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `dni` INT NULL DEFAULT NULL,
  `correo` VARCHAR(45) NOT NULL,
`idmascota` INT NOT NULL ,
  `telefono` INT NOT NULL ,
   `fechaNac` DATE NULL DEFAULT NULL,
  `fechaReg` DATE NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idresidente`),

    FOREIGN KEY (`iddepartamento`)
    REFERENCES `DBPIMartesGrupo5`.`departamento` (`iddepartamento`),
     FOREIGN KEY (`idmascota`)
    REFERENCES `DBPIMartesGrupo5`.`mascota` (`idmascota`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`propietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`propietario` (
  `idpropietario` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `dni` INT NULL DEFAULT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL ,
  `fechaNac` DATE NULL DEFAULT NULL,
  `fechaReg` DATETIME DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idpropietario`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`departamento` (
 `iddepartamento` INT NOT NULL AUTO_INCREMENT,
  `idpropietario` INT NULL DEFAULT NULL,
  `numdepartamento` char(3) NULL DEFAULT NULL,
  `habitaciones` INT NULL DEFAULT NULL,
  `area` double NULL DEFAULT NULL,
  `banos` INT NULL DEFAULT NULL,
  `fechareg` DATE NULL DEFAULT NULL,
  `estado` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`iddepartamento`),
  FOREIGN KEY (`idpropietario`)
    REFERENCES `DBPIMartesGrupo5`.`propietario` (`idpropietario`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`servicio` (
  `idservicio` INT NOT NULL AUTO_INCREMENT,
  `iddepartamento` INT NULL DEFAULT NULL,
  `nombreserv` VARCHAR(35) NOT NULL,
  `precioserv` DOUBLE NOT NULL,
  `fechareg` DATE NULL DEFAULT NULL,
  `estado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idservicio`),
  INDEX `iddepartamento` (`iddepartamento` ASC) ,
  CONSTRAINT `servicio_ibfk_1`
    FOREIGN KEY (`iddepartamento`)
    REFERENCES `DBPIMartesGrupo5`.`departamento` (`iddepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`boleta` (
  `idboleta` INT NOT NULL AUTO_INCREMENT,
  `idservicio` INT NULL DEFAULT NULL,
  `idpropietario` INT NULL DEFAULT NULL,
  `preciototal` DOUBLE NULL DEFAULT NULL,
  `fechaEmision` DATE NULL DEFAULT NULL,
  `fechaVenc` DATE NULL DEFAULT NULL,
  `estado` varchar(15) not NULL DEFAULT 'Pendiente',
  PRIMARY KEY (`idboleta`),
  INDEX `idservicio` (`idservicio` ASC) ,
  CONSTRAINT `boleta_ibfk_1`
    FOREIGN KEY (`idservicio`)
    REFERENCES `DBPIMartesGrupo5`.`servicio` (`idservicio`),
  CONSTRAINT `boleta_ibfk_2`
    FOREIGN KEY (`idpropietario`)
    REFERENCES `DBPIMartesGrupo5`.`propietario` (`idpropietario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`users` (
  `id` INT NOT NULL ,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `enable` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)  )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`insidencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`insidencia` (
  `idincidencia` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NULL DEFAULT NULL,
  `idresidente` INT NULL DEFAULT NULL,
  `tipo` VARCHAR(35) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT(1) NOT NULL,
  `fechareg` DATE NULL DEFAULT NULL,
  `fechaatencion` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idincidencia`),
  INDEX `iduser` (`iduser` ASC),
  INDEX `idresidente` (`idresidente` ASC)  ,
  CONSTRAINT `insidencia_ibfk_1`
    FOREIGN KEY (`iduser`)
    REFERENCES `DBPIMartesGrupo5`.`users` (`id`),
  CONSTRAINT `insidencia_ibfk_2`
    FOREIGN KEY (`idresidente`)
    REFERENCES `DBPIMartesGrupo5`.`residente` (`idresidente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`mascota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`mascota` (
  `idmascota` INT NOT NULL AUTO_INCREMENT,
  
  `nombre` VARCHAR(35) NULL DEFAULT NULL,
   `edad` varchar(10) not null,
  `tipo` VARCHAR(40) not  null ,
  `raza` VARCHAR(40) not NULL,
  `vacunacion` VARCHAR(25) not NULL,
  `fechareg` DATE NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`idmascota`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `rolname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_rol_unique` (`user_id` ASC, `rolname` ASC)  ,
  CONSTRAINT `rk_rol_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `DBPIMartesGrupo5`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`visitante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`visitante` (
  `idvisitante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
   `fechanac` date not NULL,
  `dni` INT NOT NULL,
   `correo` VARCHAR(45) NOT NULL,
    `telefono` VARCHAR(45) NOT NULL,
  `fechareg` DATETIME NULL DEFAULT NULL,
  `activo` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idvisitante`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`visita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`visita` (
  `idvisita` INT NOT NULL AUTO_INCREMENT,
  `idvisitante` INT NULL DEFAULT NULL,
  `iddepartamento` INT NULL DEFAULT NULL,
  `idresidente` INT NULL DEFAULT NULL,
  `horaentrada` DATETIME NULL DEFAULT NULL,
  `horasalida` DATETIME NULL,
  PRIMARY KEY (`idvisita`),
  INDEX `idresidente` (`idresidente` ASC)  ,
  INDEX `idvisitante` (`idvisitante` ASC)  ,
  CONSTRAINT `visita_ibfk_1`
    FOREIGN KEY (`idresidente`)
    REFERENCES `DBPIMartesGrupo5`.`residente` (`idresidente`),
  CONSTRAINT `visita_ibfk_2`
    FOREIGN KEY (`idvisitante`)
    REFERENCES `DBPIMartesGrupo5`.`visitante` (`idvisitante`),
    CONSTRAINT `visita_ibfk_3`
    FOREIGN KEY (`iddepartamento`)
    REFERENCES `DBPIMartesGrupo5`.`departamento` (`iddepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci;











-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`pago` (
  `idpago` INT  not NULL,
   `idboleta` INT  not NULL,
  `iduser` INT not null,
  `idresidente` INT not NULL,
  `fechapago` DATETIME  not NULL,
  PRIMARY KEY (`idpago`),
  INDEX `fk2_idx` (`iduser` ASC) ,
  INDEX `fk3_idx` (`idresidente` ASC) ,
  CONSTRAINT `fk2`
    FOREIGN KEY (`iduser`)
    REFERENCES `DBPIMartesGrupo5`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk3`
    FOREIGN KEY (`idresidente`)
    REFERENCES `DBPIMartesGrupo5`.`residente` (`idresidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk4`
    FOREIGN KEY (`idboleta`)
    REFERENCES `DBPIMartesGrupo5`.`boleta` (`idboleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBPIMartesGrupo5`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPIMartesGrupo5`.`historial` (
  `idhistorial` INT NOT NULL,
   `idincidencia` INT NOT NULL,
  `idusuario` INT not NULL,
  `iddepartamento` INT not NULL,
  `descripcion` VARCHAR(45) not NULL,
  `estado` BIGINT(1) NULL,
  `fechareg` DATE NULL,
  PRIMARY KEY (`idhistorial`),
  INDEX `fk_idx` (`idusuario` ASC)  ,
  INDEX `fk2_idx` (`iddepartamento` ASC)  ,
  CONSTRAINT `fk`
    FOREIGN KEY (`idusuario`)
    REFERENCES `DBPIMartesGrupo5`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_depart`
    FOREIGN KEY (`iddepartamento`)
    REFERENCES `DBPIMartesGrupo5`.`departamento` (`iddepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `fk_insidencia`
    FOREIGN KEY (`idincidencia`)
    REFERENCES `DBPIMartesGrupo5`.`incidencia` (`idincidencia`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;







insert into users(id,username, password, enable) values(1,'admin','$2a$10$C/kXzIeCg7CIUMpgDL5P/OjHhS3XTZsCYd5aqYdTwdjMIgfleBQoG',1);
insert into users(id,username, password, enable) values(2,'user','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);
insert into users(id,username, password, enable) values(3,'gerente','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);
insert into users(id,username, password, enable) values(4,'cajero','$2a$10$BZDSDkLnA3/U0vH9Lkjmg.fXvypyAGU.mUAvUDeA1CsiZ9QUZLyX2',1);


insert into roles(user_id, rolname) values(1, 'ROLE_USER');
insert into roles(user_id, rolname) values(1, 'ROLE_ADMIN');
insert into roles(user_id, rolname) values(1, 'ROLE_GERENTE');
insert into roles(user_id, rolname) values(1, 'ROLE_CAJERO');
insert into roles(user_id, rolname) values(2, 'ROLE_USER');
insert into roles(user_id, rolname) values(3, 'ROLE_GERENTE');
insert into roles(user_id, rolname) values(3, 'ROLE_USER');
insert into roles(user_id, rolname) values(4, 'ROLE_CAJERO');
select * from users;

SELECT r.user_id, r.rolname FROM roles r inner join users u 
on r.user_id=u.id where u.username='admin';

insert into propietario values
(null,"Maritza Patricia","Lavi Tuanama",74543223,"user1@gmail.com",980598055,"2000-05-03","2020-05-05",1);
insert into propietario  values
(null,"Juan Aron","Urbina Pacheco",56576734,"user2@gmail.com",956432356,"1997-04-03","2020-05-05",1);
insert into propietario  values
(null,"Marcela","Ricardo Palma",56576763,"user3@gmail.com",967687542,"1990-04-03","2020-07-05",1);
insert into propietario  values
(null,"Francisco","Mendoza Hinostroza",67434235,"user4@gmail.com",956574231,"1997-07-08","2022-05-05",1);
insert into propietario  values
(null,"Jose Carlos","Perez Rodriguez",65734234,"user5@gmail.com",963563255,"1979-04-02","2022-03-03",1);


-- INSERT DEPARTAMENTO
insert into departamento values
(null,1,101,3,120,2,"2020-05-12",1);
insert into departamento values
(null,2,102,2,90,2,"2021-10-11",1);
insert into departamento values
(null,3,201,1,100,1,"2020-01-25",1);
insert into departamento values
(null,4,202,2,100,1,"2022-02-28",1);
insert into departamento values
(null,5,301,3,240,3,"2021-06-13",1);

insert into mascota values(null,"DUBI","1 año","PERRO ","PITBULL","Vacunacion-InCompleta","1999-05-08",1);
insert into mascota values(null,"BEEN","1 año","GATO ","GATO BENGALA","Vacunacion-Completa","1995-05-08",1);
insert into mascota values(null,"MEYKI","2 años","GATO ","GATO PERSA","Vacunacion-InCompleta","1998-05-08",1);
insert into mascota values(null,"FRAN","4 años","PERRO ","CHIHUAHUA","Vacunacion-Completa","2000-05-08",1);

SELECT * FROM mascota;

insert into residente values
(null,1,"Maritza Patricia","Lavi Tuanama",77865433,"user1@gmail.com",1,980598055,"1999-05-03","2020-05-05",1);
insert into residente values
(null,2,"Juan Aron","Urbina Pacheco",56546742,"user2@gmail.com",1,990456789,"2000-04-03","2020-05-05",1);
insert into residente values
(null,3,"Marcela","Ricardo Palma",04567465,"user3@gmail.com",4,975456852,"2001-04-03","2020-07-05",1);
insert into residente values
(null,4,"Francisco","Mendoza Hinostroza",74584854,"user4@gmail.com",3,982632145,"2002-05-08","2022-05-05",3);

select*from propietario ;