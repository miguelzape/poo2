--Esta es la SEGUNDA tabla que se debe crear

DROP TABLE IF EXISTS tb_bibliotecas;
CREATE TABLE tb_bibliotecas (
    id            	INTEGER AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    nombre        	VARCHAR(20),
    fk_dir_id		INTEGER NOT NULL COMMENT 'enlace con la tabla de direcciones',

    PRIMARY KEY(id),
    FOREIGN KEY(fk_dir_id)REFERENCES tb_direcciones (id)
);

INSERT INTO tb_bibliotecas (nombre,fk_dir_id) VALUES

("Nueva",1),
("Vieja",2),
("Bus",3);


SELECT * FROM tb_bibliotecas ORDER BY id;