DROP TABLE IF EXISTS TB_GUERREROS;
CREATE TABLE TB_GUERREROS (
    id            INTEGER AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    nombre        VARCHAR(20),
    tipo          VARCHAR(15),
    fuerza        NUMERIC(2) NOT NULL,
    resistencia   NUMERIC(2) NOT NULL,
    fk_vehiculo_id   INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(fk_vehiculo_id)REFERENCES tb_vehiculos_guerra (id)
);

INSERT INTO TB_GUERREROS (nombre,tipo,fuerza,resistencia,fk_vehiculo_id) VALUES

("asesino","humano",9,1,1),
("luchador","humano",7,3,1),
("ninja","humano",5,5,1),
("mercenario","humano",3,7,1),
("karateka","humano",6,4,1),
("pulpo","cefalopodo",2,8,1),
("perro","canino",5,5,1),
("asesino","humano",9,1,2),
("luchador","humano",7,3,2),
("ninja","humano",5,5,2),
("mercenario","humano",3,7,2),
("karateka","humano",6,4,2),
("pulpo","cefalopodo",2,8,2),
("perro","canino",5,5,2);

SELECT * FROM TB_GUERREROS ORDER BY id;