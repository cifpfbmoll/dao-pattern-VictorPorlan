DROP TABLE IF EXISTS Espada;
CREATE TABLE Espada
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    nombre VARCHAR (255) NOT NULL,
    longitud FLOAT NOT NULL,
    afilada BOOLEAN,
    PRIMARY KEY (id)
);
INSERT INTO Espada (id, nombre, longitud,afilada) VALUES (1000, 'Dragonslayer', 200.0,false);
INSERT INTO Espada (id, nombre, longitud,afilada) VALUES (2000, 'Frostmourne', 100.0,false);