--Esta es la PRIMERA tabla que se debe crear

DROP TABLE IF EXISTS tb_direcciones;
CREATE TABLE tb_direcciones (
    id            INTEGER AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    calle         VARCHAR(20),
    numero        NUMERIC(3),

    PRIMARY KEY(id)
);

INSERT INTO tb_direcciones (calle, numero) VALUES

("Mayor",5),
("Arenal",21),
("Alcala",120),
("Princesa",3);

SELECT * FROM tb_direcciones ORDER BY id;