
CREATE TABLE Persona (
                id_persona BIGINT AUTO_INCREMENT NOT NULL,
                nombres VARCHAR(50) NOT NULL,
                apellidos VARCHAR(80) NOT NULL,
                celular VARCHAR(13),
                email VARCHAR(60),
                telefono VARCHAR(13) NOT NULL,
                dni VARCHAR(8),
                direccion VARCHAR(100),
                fecha DATETIME,
                PRIMARY KEY (id_persona)
);


CREATE TABLE Usuario (
                id_usuario BIGINT AUTO_INCREMENT NOT NULL,
                usuario VARCHAR(50) NOT NULL,
                password VARCHAR(100) NOT NULL,
                id_persona BIGINT NOT NULL,
                PRIMARY KEY (id_usuario)
);


ALTER TABLE Usuario ADD CONSTRAINT persona_usuario_fk
FOREIGN KEY (id_persona)
REFERENCES Persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
