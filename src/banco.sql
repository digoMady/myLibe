DROP DATABASE myLibe;

CREATE DATABASE myLibe;

USE myLibe;

CREATE TABLE usuario (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  sobrenome varchar(50) NOT NULL,
  username varchar(10) NOT NULL,
  password varchar(10) NOT NULL,
  email varchar(10) NOT NULL,
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
