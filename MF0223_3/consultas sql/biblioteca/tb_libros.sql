--Esta es la TERCERA tabla que se debe crear

DROP TABLE IF EXISTS tb_libros;
CREATE TABLE tb_libros (
    id            INTEGER AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    titulo        VARCHAR(20),
    autor         VARCHAR(20),
    fk_biblio_id  INTEGER NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(fk_biblio_id)REFERENCES tb_bibliotecas (id)
);

INSERT INTO tb_libros (titulo,autor,fk_biblio_id) VALUES

("Regenta","Clarin",1),
("Quijote","Cervantes",2),
("Fortunata","Galdos",3),
("Soledad","Marquez",2),
("Montecristo","Dantes",1),
("Hobbit","Tolkien",3);


SELECT * FROM tb_libros ORDER BY id;