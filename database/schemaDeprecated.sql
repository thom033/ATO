CREATE DATABASE ATO;

CREATE TABLE Utilisateur
(
    id_utilisateur   SERIAL,
    nom              VARCHAR(255) NOT NULL,
    prenom           VARCHAR(255) NOT NULL,
    date_naissance   DATE         CHECK (date_naissance < CURRENT_DATE),
    adresse          VARCHAR(255),
    mail             VARCHAR(255) NOT NULL,
    numero_telephone VARCHAR(15),
    etat_civil       VARCHAR(255),
    profession       TEXT,
    photo            VARCHAR(255) ,
    point            BIGINT       NOT NULL DEFAULT 0 CHECK (point >= 0 ),
    latitude         NUMERIC(15, 2),
    longitude        NUMERIC(15, 2),
    motdepasse       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_utilisateur)
);

CREATE TABLE Secteur
(
    id_secteur  SERIAL,
    nom_secteur VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_secteur)
);

CREATE TABLE Diplome
(
    id_diplome SERIAL,
    diplome    VARCHAR(255) NOT NULL,
    id_secteur INTEGER      NOT NULL,
    PRIMARY KEY (id_diplome),
    UNIQUE (id_secteur),
    FOREIGN KEY (id_secteur) REFERENCES Secteur (id_secteur)
);

CREATE TABLE Entreprise
(
    id_entreprise SERIAL,
    entreprise    VARCHAR(255) NOT NULL,
    point         BIGINT       NOT NULL DEFAULT 0 CHECK (point >= 0 ),
    type          VARCHAR(255),
    date_creation DATE         NOT NULL,
    adresse       VARCHAR(255) NOT NULL,
    site_web      VARCHAR(255),
    mail          VARCHAR(255) NOT NULL,
    num_telephone VARCHAR(15),
    latitude      NUMERIC(15, 2),
    longitude     NUMERIC(15, 2),
    image         VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_entreprise)
);

CREATE TABLE poste
(
    id_post        SERIAL,
    description    VARCHAR(255),
    date_insertion DATE           NOT NULL                      DEFAULT CURRENT_DATE,
    salaire        NUMERIC(15, 2) NOT NULL CHECK (salaire >= 0) DEFAULT 0,
    titre          VARCHAR(255)   NOT NULL,
    id_diplome     INTEGER        NOT NULL,
    id_entreprise  INTEGER        NOT NULL,
    PRIMARY KEY (id_post),
    FOREIGN KEY (id_diplome) REFERENCES Diplome (id_diplome),
    FOREIGN KEY (id_entreprise) REFERENCES Entreprise (id_entreprise)
);

CREATE TABLE competence
(
    id_competence  SERIAL,
    competence     VARCHAR(255) NOT NULL,
    description    TEXT,
    id_utilisateur INTEGER      NOT NULL,
    PRIMARY KEY (id_competence),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur (id_utilisateur)
);

CREATE TABLE experience
(
    id_experiecne  SERIAL,
    date_debut     DATE    NOT NULL,
    date_fin       DATE,
    description    TEXT    NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    PRIMARY KEY (id_experiecne),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur (id_utilisateur)
);

CREATE TABLE Formation
(
    id_formation   SERIAL,
    date_debut     DATE    NOT NULL,
    date_fin       DATE,
    description    TEXT    NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    PRIMARY KEY (id_formation),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur (id_utilisateur)
);

CREATE TABLE Notification
(
    id_notification   SERIAL,
    message           TEXT      NOT NULL,
    date_notification TIMESTAMP NOT NULL DEFAULT CURRRENT_DATE,
    date_lu           TIMESTAMP          DEFAULT CURRENT_DATE,
    id_utilisateur    INTEGER   NOT NULL,
    PRIMARY KEY (id_notification),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur (id_utilisateur)
);

CREATE TABLE Question
(
    id_question SERIAL,
    question    TEXT NOT NULL,
    PRIMARY KEY (id_question)
);

CREATE TABLE Reponse
(
    id_reponse  SERIAL,
    reponse     TEXT    NOT NULL,
    id_question INTEGER NOT NULL,
    PRIMARY KEY (id_reponse),
    FOREIGN KEY (id_question) REFERENCES Question (id_question)
);

CREATE TABLE diplome_utilisateur
(
    id_utilisateur INTEGER,
    id_diplome     INTEGER,
    PRIMARY KEY (id_utilisateur, id_diplome),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur (id_utilisateur),
    FOREIGN KEY (id_diplome) REFERENCES Diplome (id_diplome)
);
