CREATE TABLE Utilisateur(
   id_utilisateur SERIAL,
   nom VARCHAR(255)  NOT NULL,
   prenom VARCHAR(255)  NOT NULL,
   date_naissance DATE CHECK(date_naissance < CURRENT_DATE),
   adresse VARCHAR(255) ,
   mail VARCHAR(255)  NOT NULL UNIQUE,
   etat_civil VARCHAR(255) ,
   photo VARCHAR(255)  ,
   point BIGINT NOT NULL DEFAULT 0 CHECK(point >= 0 ),
   latitude NUMERIC(15,2)  ,
   longitude NUMERIC(15,2)  ,
   motdepasse VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_utilisateur)
);
-- date naissance, photo,  peut etre null
-- mail unique
-- ajouter nationalite?

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
   image VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_entreprise)
);
-- pourquoi il n'y a pas de secteur

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
   id_diplome INTEGER NOT NULL,
   id_entreprise INTEGER NOT NULL,
   PRIMARY KEY(id_poste),
   FOREIGN KEY(id_diplome) REFERENCES Diplome(id_diplome),
   FOREIGN KEY(id_entreprise) REFERENCES Entreprise(id_entreprise)
);
-- ajouter cout de postulation
-- disponibilite boolean

CREATE TABLE competence(
   id_competence SERIAL,
   competence VARCHAR(255)  NOT NULL,
   description TEXT,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_competence),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE experience(
   id_experiecne SERIAL,
   date_debut DATE NOT NULL,
   date_fin DATE,
   description TEXT NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_experiecne),
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

CREATE TABLE Question(
   id_question SERIAL,
   question TEXT NOT NULL,
   PRIMARY KEY(id_question)
);
-- ajouter nbre de fois posée

CREATE TABLE Reponse(
   id_reponse SERIAL,
   reponse TEXT NOT NULL,
   id_question INTEGER NOT NULL,
   PRIMARY KEY(id_reponse),
   FOREIGN KEY(id_question) REFERENCES Question(id_question)
);

CREATE TABLE type_notification(
   id_type_notification SERIAL,
   poste INTEGER,
   point BOOLEAN,
   FOREIGN KEY(poste) REFERENCES poste(id_poste),
   PRIMARY KEY(id_type_notification)
);
-- nosoloiko foreign key

CREATE TABLE Contact(
   id_contact SERIAL,
   num_telephone VARCHAR(20) ,
   id_entreprise INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_contact),
   UNIQUE(num_telephone),
   FOREIGN KEY(id_entreprise) REFERENCES Entreprise(id_entreprise),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Notification(
   id_notification SERIAL,
   message TEXT NOT NULL,
   date_notification TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
   date_lu TIMESTAMP,
   id_type_notification INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_notification),
   FOREIGN KEY(id_type_notification) REFERENCES type_notification(id_type_notification),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);
-- enlevé le default date_lu = current_date

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