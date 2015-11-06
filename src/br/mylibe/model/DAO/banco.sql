DROP DATABASE mylibe;

CREATE DATABASE myLibe;

USE myLibe;

CREATE TABLE user (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  lastname varchar(45),
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE book (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  autor varchar(50) NOT NULL,
  listaDesejos
  descricao varchar(100) NOT NULL,
  numeroPaginas int(10) NOT NULL,
  idUsuario int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY fk_idUsuario (idUsuario),
  CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);
