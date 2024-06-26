CREATE DATABASE ato;
\c ato;

CREATE TABLE Utilisateur(
   id_utilisateur SERIAL,
   nom VARCHAR(255)  NOT NULL,
   prenom VARCHAR(255)  NOT NULL,
   date_naissance DATE CHECK(date_naissance < CURRENT_DATE),
   adresse VARCHAR(255) ,
   mail VARCHAR(255)  NOT NULL,
   etat_civil VARCHAR(255) ,
   photo VARCHAR(255)  DEFAULT 'none.jpg',
   point BIGINT NOT NULL DEFAULT 0 CHECK(point >= 0 ),
   latitude NUMERIC(15,2)  ,
   longitude NUMERIC(15,2)  ,
   motdepasse VARCHAR(255)  NOT NULL,
   description TEXT,
   salaire_recherche NUMERIC(15,2)   DEFAULT 0,
   PRIMARY KEY(id_utilisateur),
   UNIQUE(mail)
);

CREATE TABLE Secteur(
   id_secteur SERIAL,
   secteur VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_secteur)
);

CREATE TABLE Diplome(
   id_diplome SERIAL,
   diplome VARCHAR(255)  NOT NULL,
   niveau INTEGER NOT NULL,
   PRIMARY KEY(id_diplome)
);

CREATE TABLE Entreprise(
   id_entreprise SERIAL,
   entreprise VARCHAR(255)  NOT NULL,
   point BIGINT NOT NULL DEFAULT 0 CHECK(point >= 0 ),
   type VARCHAR(255) ,
   date_creation DATE NOT NULL,
   adresse VARCHAR(255)  NOT NULL,
   site_web VARCHAR(255) ,
   mail VARCHAR(255)  NOT NULL,
   latitude NUMERIC(15,2)  ,
   longitude NUMERIC(15,2)  ,
   image VARCHAR(255)  DEFAULT 'none.jpg',
   PRIMARY KEY(id_entreprise),
   UNIQUE(mail)
);

CREATE TABLE poste(
   id_poste SERIAL,
   description VARCHAR(255) ,
   date_insertion DATE NOT NULL DEFAULT CURRENT_DATE,
   salaire NUMERIC(15,2)   NOT NULL CHECK(salaire >= 0)  DEFAULT 0,
   titre VARCHAR(255)  NOT NULL,
   annee_experience INTEGER DEFAULT 0,
   annee_formation INTEGER DEFAULT 0,
   age_min INTEGER,
   age_max INTEGER,
   image VARCHAR(250) ,
   cout INTEGER NOT NULL,
   disponibilite BOOLEAN NOT NULL,
   id_diplome INTEGER NOT NULL,
   id_entreprise INTEGER NOT NULL,
   PRIMARY KEY(id_poste),
   FOREIGN KEY(id_diplome) REFERENCES Diplome(id_diplome),
   FOREIGN KEY(id_entreprise) REFERENCES Entreprise(id_entreprise)
);

CREATE TABLE experience(
   id_experience SERIAL,
   date_debut DATE NOT NULL,
   date_fin DATE,
   description TEXT NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_experience),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Formation(
   id_formation SERIAL,
   date_debut DATE NOT NULL,
   description TEXT NOT NULL,
   date_fin DATE,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_formation),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE diplome_utilisateur(
   id_utilisateur INTEGER,
   id_diplome INTEGER,
   PRIMARY KEY(id_utilisateur, id_diplome),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_diplome) REFERENCES Diplome(id_diplome)
);

CREATE TABLE secteur_diplome(
   id_secteur INTEGER,
   id_diplome INTEGER,
   PRIMARY KEY(id_secteur, id_diplome),
   FOREIGN KEY(id_secteur) REFERENCES Secteur(id_secteur),
   FOREIGN KEY(id_diplome) REFERENCES Diplome(id_diplome)
);

CREATE TABLE competence(
   id_competence SERIAL,
   competence VARCHAR(255)  NOT NULL,
   description TEXT,
   PRIMARY KEY(id_competence)
);

CREATE TABLE competence_utilisateur(
   id_utilisateur INTEGER,
   id_competence INTEGER,
   PRIMARY KEY(id_utilisateur, id_competence),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_competence) REFERENCES competence(id_competence)
);

CREATE TABLE competence_secteur(
   id_secteur INTEGER,
   id_competence INTEGER,
   PRIMARY KEY(id_secteur, id_competence),
   FOREIGN KEY(id_secteur) REFERENCES Secteur(id_secteur),
   FOREIGN KEY(id_competence) REFERENCES competence(id_competence)
);


<<<<<<< HEAD
CREATE OR REPLACE VIEW postes_details AS
SELECT
    p.id_poste,
    p.description AS poste_description,
    p.date_insertion AS poste_date_insertion,
    p.salaire AS poste_salaire,
    p.titre AS poste_titre,
    p.id_diplome AS poste_diplome,
    p.id_entreprise AS poste_entreprise,
    p.annee_experience AS nbr_annee_experience,
    p.annee_formation AS nbr_annee_formation,
    p.age_min AS poste_age_min,
    p.age_max AS poste_age_max,

    d.id_diplome,
    d.diplome AS diplome_nom,
    d.niveau AS diplome_niveau,

    e.entreprise AS entreprise_nom,
    e.point AS entreprise_point,
    e.type AS entreprise_type,
    e.date_creation AS entreprise_date_creation,
    e.adresse AS entreprise_adresse,
    e.site_web AS entreprise_site_web,
    e.mail AS entreprise_mail,
    e.latitude AS entreprise_latitude,
    e.longitude AS entreprise_longitude,
    e.image AS entreprise_image,
    
    sd.id_secteur,
    sd.id_diplome AS secteur_diplome_id_diplome
FROM
   poste p
JOIN
   diplome d ON p.id_diplome = d.id_diplome
JOIN
   entreprise e ON p.id_entreprise = e.id_entreprise
JOIN
   secteur_diplome sd ON d.id_diplome = sd.id_diplome;
=======
>>>>>>> main
