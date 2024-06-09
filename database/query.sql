-- Données pour la table Utilisateur
INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, etat_civil, photo, point, latitude, longitude, motdepasse, description, salaire_recherche)
VALUES
('Dupont', 'Jean', '1985-06-15', '123 Rue Principale, Paris', 'jean.dupont@example.com', 'Célibataire', 'photo1.jpg', 100, 48.8566, 2.3522, 'password123', 'Développeur Full Stack', 45000),
('Martin', 'Sophie', '1990-11-20', '456 Rue Secondaire, Lyon', 'sophie.martin@example.com', 'Marié', 'photo2.jpg', 200, 45.7640, 4.8357, 'securepass', 'Chef de projet', 55000),
('Leroy', 'Julien', '1978-04-05', '789 Rue Tertiaire, Marseille', 'julien.leroy@example.com', 'Divorcé', 'photo3.jpg', 150, 43.2965, 5.3698, 'password789', 'Analyste', 50000);

-- Données pour la table Secteur
INSERT INTO Secteur (secteur)
VALUES
('Informatique'),
('Finance'),
('Marketing');

-- Données pour la table Diplome
INSERT INTO Diplome (diplome, niveau)
VALUES
('Baccalauréat', 4),
('Licence', 6),
('Master', 7);

-- Données pour la table Entreprise
INSERT INTO Entreprise (entreprise, point, type, date_creation, adresse, site_web, mail, latitude, longitude, image)
VALUES
('TechCorp', 300, 'Technologie', '2000-01-01', '12 Rue Tech, Paris', 'https://techcorp.com', 'contact@techcorp.com', 48.8566, 2.3522, 'techcorp.jpg'),
('FinanceInc', 150, 'Finance', '1995-05-15', '34 Rue Finance, Lyon', 'https://financeinc.com', 'info@financeinc.com', 45.7640, 4.8357, 'financeinc.jpg'),
('MarketLLC', 200, 'Marketing', '2010-09-10', '56 Rue Market, Marseille', 'https://marketllc.com', 'contact@marketllc.com', 43.2965, 5.3698, 'marketllc.jpg');

-- Données pour la table poste
INSERT INTO poste (description, date_insertion, salaire, titre, annee_experience, annee_formation, age_min, age_max, image, id_diplome, id_entreprise)
VALUES
('Développement de logiciels', CURRENT_DATE, 40000, 'Développeur', 2, 4, 25, 35, 'poste1.jpg', 2, 1),
('Analyse financière', CURRENT_DATE, 50000, 'Analyste', 3, 5, 30, 40, 'poste2.jpg', 3, 2),
('Gestion de projet marketing', CURRENT_DATE, 45000, 'Chef de Projet', 4, 6, 28, 38, 'poste3.jpg', 2, 3);

-- Données pour la table competence
INSERT INTO competence (competence, description)
VALUES
('Programmation', 'Capacité à écrire du code dans différents langages de programmation.'),
('Analyse financière', 'Compétence en évaluation et gestion des finances.'),
('Gestion de projet', 'Compétence en gestion et coordination de projets.');

-- Données pour la table experience
INSERT INTO experience (date_debut, date_fin, description, id_utilisateur)
VALUES
('2010-01-01', '2015-01-01', 'Développeur Junior chez TechCorp', 1),
('2015-02-01', '2020-02-01', 'Chef de Projet chez FinanceInc', 2),
('2005-03-01', '2010-03-01', 'Analyste chez MarketLLC', 3);

-- Données pour la table Formation
INSERT INTO Formation (date_debut, description, date_fin, id_utilisateur)
VALUES
('2006-09-01', 'Licence en Informatique', '2009-06-30', 1),
('2010-09-01', 'Master en Gestion', '2012-06-30', 2),
('2000-09-01', 'Baccalauréat en Économie', '2003-06-30', 3);

-- Données pour la table Question
INSERT INTO Question (question)
VALUES
('Quelles sont vos compétences principales ?'),
('Quel est votre niveau d expérience ?'),
('Quelle est votre formation académique ?');

-- Données pour la table Reponse
INSERT INTO Reponse (reponse, id_question)
VALUES
('Programmation, Gestion de projet', 1),
('5 ans en tant que Développeur', 2),
('Master en Informatique', 3);

-- Données pour la table type_notification
-- INSERT INTO type_notification (poste, point)
-- VALUES
-- (null, TRUE),
-- (2, FALSE),
-- (null, TRUE);

-- Données pour la table Contact
INSERT INTO Contact (num_telephone, id_entreprise, id_utilisateur)
VALUES
('0123456789', 1, 1),
('0987654321', 2, 2),
('0555123456', 3, 3);

-- Données pour la table administrateur
INSERT INTO administrateur (mail, mot_de_passe)
VALUES
('admin@example.com', 'adminpass'),
('admin2@example.com', 'adminpass2'),
('admin3@example.com', 'adminpass3');

-- Données pour la table argent
INSERT INTO argent (solde, id_utilisateur)
VALUES
(1000.00, 1),
(2000.00, 2),
(1500.00, 3);

-- Données pour la table Notification
INSERT INTO Notification (message, date_notification, date_lu, id_utilisateur,id_poste, point)
VALUES
('Vous avez un nouveau message', CURRENT_TIMESTAMP, NULL, 1,1,FALSE),
('Votre profil a ete mis a jour', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1,null,FALSE),
('Nouvelle offre d emploi disponible', CURRENT_TIMESTAMP, NULL, 1,null,TRUE );

-- Données pour la table competence_utilisateur
INSERT INTO competence_utilisateur (id_utilisateur, id_competence)
VALUES
(1, 1),
(2, 2),
(3, 3);

-- Données pour la table diplome_utilisateur
INSERT INTO diplome_utilisateur (id_utilisateur, id_diplome)
VALUES
(1, 2),
(2, 3),
(3, 1);

-- Données pour la table secteur_diplome
INSERT INTO secteur_diplome (id_secteur, id_diplome)
VALUES
(1, 2),
(2, 3),
(3, 1);

-- Données pour la table competence_secteur
INSERT INTO competence_secteur (id_secteur, id_competence)
VALUES
(1, 1),
(2, 2),
(3, 3);
