CREATE TABLE test.TB_Alumnos (
 id int NOT NULL PRIMARY KEY,
 nombre varchar(50) NOT NULL,
 apellidos varchar(50) UNIQUE,
 edad int
);