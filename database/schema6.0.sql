CREATE DATABASE rohy
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       LC_COLLATE = 'fr_FR.UTF-8'
       LC_CTYPE = 'fr_FR.UTF-8'
       TEMPLATE = template0;
\c rohy

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
   latitude NUMERIC(17,15)  ,
   longitude NUMERIC(17,15)  ,
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
   latitude NUMERIC(17,15)  ,
   longitude NUMERIC(17,15)  ,
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

CREATE TABLE competence(
   id_competence SERIAL,
   competence VARCHAR(255)  NOT NULL,
   description TEXT,
   PRIMARY KEY(id_competence)
);

CREATE TABLE experience(
   id_experience SERIAL,
   date_debut DATE NOT NULL,
   date_fin DATE,
   description TEXT NOT NULL,
   id_secteur INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_experience),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE formation(
   id_formation SERIAL,
   date_debut DATE NOT NULL,
   description TEXT NOT NULL,
   id_diplome INTEGER NOT NULL,
   date_fin DATE,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_formation),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Reponse(
   id_reponse SERIAL,
   reponse TEXT NOT NULL,
   PRIMARY KEY(id_reponse)
);

CREATE TABLE Question(
   id_question SERIAL,
   question TEXT NOT NULL,
   id_reponse integer,
   PRIMARY KEY(id_question),
   FOREIGN KEY(id_reponse) REFERENCES reponse(id_reponse)
);
-- inversment dans question qu'il a reponse 
-- donc dans question on met id_reponse

CREATE TABLE Contact(
   id_contact SERIAL,
   num_telephone VARCHAR(20) ,
   PRIMARY KEY(id_contact),
   UNIQUE(num_telephone)
);

CREATE TABLE administrateur(
   id_administrateur SERIAL,
   mail VARCHAR(250)  NOT NULL,
   mot_de_passe VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_administrateur)
);

CREATE TABLE argent(
   id_argent SERIAL,
   solde NUMERIC(15,2)   NOT NULL DEFAULT 0,
   date_modification TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_argent),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE historique_question(
   id_historique SERIAL,
   id_question INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   date TIMESTAMP DEFAULT CURRENT_DATE,
   PRIMARY KEY(id_historique),
   FOREIGN KEY(id_question) REFERENCES Question(id_question),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE competence_utilisateur(
   id_utilisateur INTEGER,
   id_competence INTEGER,
   PRIMARY KEY(id_utilisateur, id_competence),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_competence) REFERENCES competence(id_competence)
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

CREATE TABLE competence_secteur(
   id_secteur INTEGER,
   id_competence INTEGER,
   PRIMARY KEY(id_secteur, id_competence),
   FOREIGN KEY(id_secteur) REFERENCES Secteur(id_secteur),
   FOREIGN KEY(id_competence) REFERENCES competence(id_competence)
);

CREATE TABLE utilisateur_contact(
   id_utilisateur INTEGER,
   id_contact INTEGER,
   PRIMARY KEY(id_utilisateur, id_contact),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_contact) REFERENCES Contact(id_contact)
);

CREATE TABLE entreprise_contact(
   id_entreprise INTEGER,
   id_contact INTEGER,
   PRIMARY KEY(id_entreprise, id_contact),
   FOREIGN KEY(id_entreprise) REFERENCES Entreprise(id_entreprise),
   FOREIGN KEY(id_contact) REFERENCES Contact(id_contact)
);

-- modifications
CREATE TABLE entretien(
   id_entretien SERIAL,
   date_envoi TIMESTAMP DEFAULT CURRENT_DATE,
   date_entretien TIMESTAMP,
   id_utilisateur INTEGER,
   id_poste INTEGER,
   reussite BOOLEAN DEFAULT NULL,
   PRIMARY KEY(id_entretien),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_poste) REFERENCES poste(id_poste)
);
-- default null

CREATE TABLE postulation(
   id_postulation SERIAL PRIMARY KEY,
   id_utilisateur integer,
   id_poste integer,
   date TIMESTAMP DEFAULT CURRENT_DATE,
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_poste) REFERENCES poste(id_poste)
);

create table point_vendu(
   id_point_vendu serial PRIMARY key,
   id_utilisateur integer,
   point integer,
   date TIMESTAMP DEFAULT CURRENT_DATE,
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur)
);
select count(entretien) as nbEntretien,extract(month from date_entretien) as mois from entretien where reussite and extract(year from date_entretien)=2024 group by extract(month from date_entretien);
CREATE TABLE Notification(
   id_notification SERIAL,
   message TEXT NOT NULL,
   date_notification TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
   date_lu TIMESTAMP DEFAULT NULL,
   point BOOLEAN,
   id_poste INTEGER,
   id_utilisateur INTEGER NOT NULL,
   id_entretien integer,
   reussite BOOLEAN,
   PRIMARY KEY(id_notification),
   FOREIGN KEY(id_poste) REFERENCES poste(id_poste),
   FOREIGN KEY(id_entretien) REFERENCES entretien(id_entretien),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);
-- ajout de id_entretien

create table prix_point(
   id_prix_point serial,
   prix numeric(10,2),
   date_changement date,
   PRIMARY KEY(id_prix_point)
);

create table nombre_promotion(
   id_nombre_promotion serial,
   nombre_promotion1 int,
   pourcentage1 numeric(4,2),
   nombre_promotion2 int,
   pourcentage2 numeric(4,2),
   date_changement date,
   PRIMARY KEY(id_nombre_promotion)
);