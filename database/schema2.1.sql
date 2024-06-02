create DATABASE ato;
\c ato

CREATE TABLE Utilisateur(
   id_utilisateur SERIAL,
   nom VARCHAR(255)  NOT NULL,
   prenom VARCHAR(255)  NOT NULL,
   date_naissance DATE NOT NULL CHECK(date_naissance < CURRENT_DATE),
   adresse VARCHAR(255) ,
   mail VARCHAR(255)  NOT NULL,
   numero_telephone VARCHAR(15) ,
   etat_civil VARCHAR(255) ,
   profession VARCHAR(255),
   photo VARCHAR(255)  NOT NULL,
   point INTEGER NOT NULL DEFAULT 0 CHECK(point >= 0 ),
   latitude NUMERIC(15,2)  ,
   longitude NUMERIC(15,2)  ,
   PRIMARY KEY(id_utilisateur)
);

CREATE TABLE Secteur(
   id_secteur SERIAL,
   secteur VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_secteur)
);

CREATE TABLE Diplome(
   id_diplome SERIAL,
   diplome VARCHAR(255)  NOT NULL,
   id_secteur INTEGER NOT NULL,
   PRIMARY KEY(id_diplome),
   FOREIGN KEY(id_secteur) REFERENCES Secteur(id_secteur)
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
   num_telephone VARCHAR(15) ,
   latitude NUMERIC(15,6)  ,
   longitude NUMERIC(15,6)  ,
   image VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_entreprise)
);

CREATE TABLE poste(
   id_poste SERIAL,
   description VARCHAR(255) ,
   date_insertion DATE NOT NULL DEFAULT CURRENT_DATE,
   salaire NUMERIC(15,2)   NOT NULL CHECK(salaire >= 0)  DEFAULT 0,
   titre VARCHAR(255)  NOT NULL,
   id_diplome INTEGER NOT NULL,
   id_secteur INTEGER NOT NULL,
   id_entreprise INTEGER NOT NULL,
   nbr_annee_experience INTEGER NOT NULL,
   nbr_annee_formation INTEGER NOT NULL,
   age INTEGER NOT NULL,
   PRIMARY KEY(id_poste),
   FOREIGN KEY(id_diplome) REFERENCES Diplome(id_diplome),
   FOREIGN KEY(id_entreprise) REFERENCES Entreprise(id_entreprise)
);

CREATE TABLE Competence(
   id_competence SERIAL,
   competence VARCHAR(255)  NOT NULL,
   description VARCHAR(255),
   id_secteur INTEGER NOT NULL,
   PRIMARY KEY(id_competence),
   FOREIGN KEY(id_secteur) REFERENCES Secteur(id_secteur)
);

CREATE TABLE experience(
   id_experience SERIAL,
   date_debut DATE NOT NULL,
   date_fin DATE,
   description VARCHAR(255) NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   id_secteur INTEGER NOT NULL,
   PRIMARY KEY(id_experience),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Formation(
   id_formation SERIAL,
   date_debut DATE NOT NULL,
   date_fin DATE,
   description VARCHAR(255) NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   id_secteur INTEGER NOT NULL,
   PRIMARY KEY(id_formation),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_secteur) REFERENCES Secteur(id_secteur)
);

CREATE TABLE Notification(
   id_notification SERIAL,
   message VARCHAR(255) NOT NULL,
   date_notification TIMESTAMP NOT NULL,
   date_lu TIMESTAMP DEFAULT CURRENT_DATE,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_notification),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Question(
   id_question SERIAL,
   question VARCHAR NOT NULL,
   PRIMARY KEY(id_question)
);

CREATE TABLE Reponse(
   id_reponse SERIAL,
   reponse VARCHAR NOT NULL,
   id_question INTEGER NOT NULL,
   PRIMARY KEY(id_reponse),
   FOREIGN KEY(id_question) REFERENCES Question(id_question)
);

CREATE TABLE diplome_utilisateur(
   id_diplome_utilisateur SERIAL,
   id_utilisateur INTEGER,
   id_diplome INTEGER,
   PRIMARY KEY(id_utilisateur, id_diplome),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_diplome) REFERENCES Diplome(id_diplome)
);

CREATE OR REPLACE VIEW postes_details AS
SELECT 
    p.id_poste,
    p.description AS poste_description,
    p.date_insertion AS poste_date_insertion,
    p.salaire AS poste_salaire,
    p.titre AS poste_titre,
    p.nbr_annee_experience AS nbr_annee_experience,
    p.nbr_annee_formation AS nbr_annee_formation,
    p.age AS age_requise,
    d.id_diplome,
    d.diplome AS diplome_nom,
    s.id_secteur,
    s.secteur AS secteur_nom,
    e.id_entreprise,
    e.entreprise AS entreprise_nom,
    e.point AS entreprise_point,
    e.type AS entreprise_type,
    e.date_creation AS entreprise_date_creation,
    e.adresse AS entreprise_adresse,
    e.site_web AS entreprise_site_web,
    e.mail AS entreprise_mail,
    e.num_telephone AS entreprise_num_telephone,
    e.latitude AS entreprise_latitude,
    e.longitude AS entreprise_longitude,
    e.image AS entreprise_image,
    c.competence AS competence_requise
FROM 
    poste p
JOIN 
    diplome d ON p.id_diplome = d.id_diplome
JOIN 
    secteur s ON d.id_secteur = s.id_secteur
JOIN 
    entreprise e ON p.id_entreprise = e.id_entreprise
JOIN
    competence c ON s.id_secteur = c.id_secteur;