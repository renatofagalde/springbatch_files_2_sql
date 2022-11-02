DROP TABLE IF EXISTS migracao_dados.pessoa;
CREATE TABLE migracao_dados.pessoa(id INT, nome VARCHAR(500),email VARCHAR(500),data_nascimento DATETIME,idade INT, PRIMARY KEY(id));
DROP TABLE IF EXISTS migracao_dados.dados_bancarios;
CREATE TABLE migracao_dados.dados_bancarios(id INT, pessoa_id INT,agencia INT, conta INT, banco INT , PRIMARY KEY(id));
