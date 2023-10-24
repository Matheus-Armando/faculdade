create database musicologia


CREATE TABLE genero (
                idGenero BIGINT IDENTITY NOT NULL,
                nome VARCHAR(100) NOT NULL,
                CONSTRAINT genero_pk PRIMARY KEY (idGenero)
)

CREATE TABLE autor (
                idAutor BIGINT IDENTITY NOT NULL,
                nome VARCHAR(100) NOT NULL,
                biografia VARCHAR(200) NOT NULL,
                CONSTRAINT autor_pk PRIMARY KEY (idAutor)
)

CREATE TABLE musica (
                idMusica BIGINT IDENTITY NOT NULL,
                nome VARCHAR(100) NOT NULL,
                duracaoMinutos INT NOT NULL,
                idAutor BIGINT NOT NULL,
                idGenero BIGINT NOT NULL,
                CONSTRAINT musica_pk PRIMARY KEY (idMusica)
)

ALTER TABLE musica ADD CONSTRAINT categoria_musica_fk
FOREIGN KEY (idGenero)
REFERENCES genero (idGenero)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE musica ADD CONSTRAINT autor_musica_fk
FOREIGN KEY (idAutor)
REFERENCES autor (idAutor)
ON DELETE NO ACTION
ON UPDATE NO ACTION