CREATE TABLE Person (
    id INTEGER AUTO_INCREMENT NOT NULL,
    fornavn VARCHAR(15),
    etternavn VARCHAR(20),
    fodselsdato DATE NOT NULL,
    personnr CHAR(11),
    telefonnr CHAR(8),
    email VARCHAR(30),
    by VARCHAR(15),
    gatenavn VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE Bruker (
    id INTEGER AUTO_INCREMENT NOT NULL,
    brukernavn VARCHAR(30),
    passord VARCHAR(255),
    PRIMARY KEY (id)
);