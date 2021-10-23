CREATE TABLE `nota` (
    `idNota` int(11) NOT NULL AUTO_INCREMENT,
    `nota` varchar(1024) DEFAULT NULL,
    `creada` DATETIME DEFAULT NULL,
    PRIMARY KEY (`idNota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;