CREATE TABLE Person (
    id INTEGER AUTO_INCREMENT NOT NULL,
    fornavn VARCHAR(15),
    etternavn VARCHAR(20),
    fodselsdato VARCHAR(10),
    personnr CHAR(11),
    telefonnr CHAR(8),
    email VARCHAR(30),
    by VARCHAR(15),
    gatenavn VARCHAR(30),
    PRIMARY KEY (id)
);