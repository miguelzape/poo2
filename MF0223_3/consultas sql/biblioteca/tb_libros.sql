--Esta es la TERCERA tabla que se debe crear

DROP TABLE IF EXISTS tb_libros;
CREATE TABLE tb_libros (
    id            INTEGER AUTO_INCREMENT COMMENT 'identificador autoincrementable',
    titulo        VARCHAR(20),
    autor         VARCHAR(20),
    precio        NUMERIC(4,2),
    fk_biblio_id  INTEGER NOT NULL,
    
    
    PRIMARY KEY(id),
    FOREIGN KEY(fk_biblio_id)REFERENCES tb_bibliotecas (id)
);

INSERT INTO tb_libros (titulo,autor,fk_biblio_id,precio) VALUES

("Regenta","Clarin",1,9.5),
("Quijote","Cervantes",2,14.2),
("Fortunata","Galdos",3,25.8),
("Soledad","Marquez",2,10.0),
("Montecristo","Dantes",1,15.7),
("Hobbit","Tolkien",3,11.9);


-- SELECT * FROM tb_libros ORDER BY id;

-- *****   Soliticar los datos de todos los libros de una biblioteca   *****
-- *****   ? es el id de la biblioteca   *****

-- SELECT id, titulo, autor FROM tb_libros WHERE fk_biblio_id = ?


-- *****   Comprobar si existe un libro determinado en la biblioteca   *****
-- *****   primer ?: el titulo del libro, segundo ?: el id de la biblioteca *****


-- SELECT * FROM tb_libros WHERE titulo = ? AND fk_biblio_id = ?

-- *****   Insertar un libro en la biblioteca   *****
-- *****   primer ?:tilo , segundo ?:autor, tercer ?:id de la biliblioteca   *****

-- INSERT INTO tb_libros (titulo, autor, fk_biblio_id) VALUES (?, ?, ?)

-- *****   Borrar un libro de la biblioteca   *****
-- *****   ? es el titulo del libro   *****

-- DELETE FROM tb_libros WHERE titulo = ?

-- *****   Modificar los datos de un libro   *****
-- *****   Requiere dos condsultas. los parametros de cada una son   *****
-- *****   primer ?:titulo del libro, segundo ?: id de la bilioteca   *****
-- *****   primer ?:nuevo titulo, segundo ?:nuevo auto, tercer ?:el id obtenido en la primera consulta

-- SELECT id FROM tb_libros WHERE titulo = ? AND fk_biblio_id = ?
-- UPDATE tb_libros SET titulo = ?, autor = ? WHERE id = ?

-- *****   Modificar la tabla para que tenga un campo 'precio' que no puede ser nulo

-- ALTER TABLE tb_libros ADD precio numeric(4)DEFAULT 1;
-- UPDATE tb_libros SET precio=14.1 WHERE titulo='Mosqueteros';
-- ALTER TABLE tb_libros MODIFY precio NUMERIC (4,2) NOT NULL DEFAULT 1; 
-- UPDATE tb_libros SET precio=12.5 WHERE autor='Torres';
-- SELECT * FROM tb_libros ORDER BY id;

-- ***** Calcular precio medio de los libros y cuantos libros hay (de todas las bilbiotecas)   *****
-- ***** ordenada por precio medio descendente   *****

-- SELECT tb_bibliotecas.nombre AS 'Biblioteca', COUNT(precio) AS 'cantidad', FORMAT(AVG(precio),2) AS 'precio_medio' 
-- FROM tb_libros INNER JOIN tb_bibliotecas ON tb_libros.fk_biblio_id=tb_bibliotecas.id GROUP BY fk_biblio_id
-- ORDER BY AVG(precio) ASC;

