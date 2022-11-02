drop database if exists app;
create database app;

DROP TABLE IF EXISTS app.pessoa;
CREATE TABLE app.pessoa(id INT, nome VARCHAR(500),email VARCHAR(500),data_nascimento DATETIME,idade INT, PRIMARY KEY(id));
DROP TABLE IF EXISTS app.dados_bancarios;
CREATE TABLE dados_bancarios(id INT, pessoa_id INT,agencia INT, conta INT, banco INT , PRIMARY KEY(id));
