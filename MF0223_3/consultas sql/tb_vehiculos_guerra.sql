
DROP TABLE IF EXISTS tb_vehiculos_guerra;
CREATE TABLE tb_vehiculos_guerra (
    id          INTEGER AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    nombre      VARCHAR(20),
    tipo        ENUM('acorazado','fragata') NOT NULL,
    ataque      NUMERIC(2) NOT NULL,
    defensa     NUMERIC(2) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO tb_vehiculos_guerra (nombre,tipo,ataque,defensa) VALUES

("ticonderoga","acorazado",9,1),
("egpaniola","fragata",7,3);

SELECT * FROM tb_vehiculos_guerra;