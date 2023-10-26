DROP TABLE IF EXISTS TB_FACILITIES;
CREATE TABLE TB_FACILITIES (
    id          integer AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    guid        numeric(7) unique,
    name        varchar(45) not null COMMENT 'este campo es el nombre',
    description varchar(200),
    category    varchar(45) DEFAULT "Building",
    address     varchar(200) COMMENT 'la direccion',
    heigth		decimal (5,2),

  PRIMARY KEY(id)
);

INSERT INTO TB_FACILITIES (guid,name,category) values
(40,"uno","bunquer"),
(15,"tres","barraca"),
(2,"dos","chamizo"),
(32,"cuatro","fabela");

SELECT id,guid,name,category FROM TB_FACILITIES ORDER BY guid;