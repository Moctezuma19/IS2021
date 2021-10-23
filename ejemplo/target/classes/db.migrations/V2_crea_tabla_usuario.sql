CREATE TABLE `usuario` (
    `idUsuario` INT auto_increment NOT NULL,
    `nombre` VARCHAR (255) NOT NULL,
    `clave` VARCHAR (60) NOT NULL,
    PRIMARY KEY (`idUsuario`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4;