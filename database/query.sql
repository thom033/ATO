INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, etat_civil, photo, point, latitude, longitude, motdepasse, description, salaire_recherche)
VALUES 
('Dupont', 'Jean', '1985-05-20', '123 Rue de la République, Paris', 'jean.dupont@example.com', 'Célibataire', 'photo.jpg', 100, 48.8566, 2.3522, 'password123', 'Développeur expérimenté', 4000.00),
('Doe', 'John', '1990-01-01', '123 Main St, Paris, France', 'john.doe@example.com', 'Single', 'john_photo.png', 100, 40.7128, -74.0060, 'password', 'Chef de projet tres important', 5000.00);

-- Table Admin
INSERT INTO administrateur(mail,mot_de_passe) VALUES('Ryan@gmail.com','1234');

-- Table Secteur
INSERT INTO Secteur (secteur) 
VALUES 
('Technology'), 
('Healthcare');

-- Table Diplome
INSERT INTO Diplome (diplome, niveau) 
VALUES 
('Bachelor of Science', 1), 
('Master of Arts', 2);

-- Table Entreprise
INSERT INTO Entreprise (entreprise, point, type, date_creation, adresse, site_web, mail, latitude, longitude, image) 
VALUES 
('TechCorp', 500, 'Technology', '2000-01-01', '789 Oak St', 'http://techcorp.com', 'contact@techcorp.com', 37.7749, -122.4194, 'techcorp.png'),
('HealthInc', 300, 'Healthcare', '1995-06-15', '101 Maple St', 'http://healthinc.com', 'info@healthinc.com', 51.5074, -0.1278, 'healthinc.png');

-- Table poste
INSERT INTO poste (description, salaire, titre, annee_experience, annee_formation, age_min, age_max, id_diplome, id_entreprise) 
VALUES 
('Software Developer', 70000.00, 'Developer', 2, 4, 22, 35, 1, 1),
('Nurse', 50000.00, 'Registered Nurse', 3, 4, 25, 40, 2, 2);

-- Insertion de données de test pour la table Competence
INSERT INTO Competence (competence, description) VALUES
('Java', 'Maîtrise du langage de programmation Java'),
('Spring Boot', 'Développement d applications avec Spring Boot'),
('SQL', 'Connaissance avancée des bases de données SQL');

-- Table experience
INSERT INTO experience (date_debut, date_fin, description, id_utilisateur) 
VALUES 
('2015-01-01', '2018-12-31', 'Worked as a software developer at TechCorp', 1),
('2010-03-01', '2015-03-31', 'Worked as a nurse at HealthInc', 2);

-- Table Formation
INSERT INTO Formation (date_debut, description, date_fin, id_utilisateur) 
VALUES 
('2014-09-01', 'Completed Bachelor s degree in Computer Science', '2018-06-01', 1),
('2008-09-01', 'Completed Bachelor s degree in Nursing', '2012-06-01', 2);

-- Table Question
INSERT INTO Question (question) 
VALUES 
('What is your primary skill set?'),
('What is your highest level of education?');

-- Table Reponse
INSERT INTO Reponse (reponse, id_question) 
VALUES 
('Java Programming', 1),
('Bachelor of Science', 2);

-- Table type_notification
INSERT INTO type_notification (poste, point) 
VALUES 
(1, TRUE), 
(2, FALSE);
-- mila asina id_point aleha

-- Table Contact
INSERT INTO Contact (num_telephone, id_entreprise, id_utilisateur) 
VALUES 
('123-456-7890', 1, 1),
('987-654-3210', 2, 2);

-- Table Notification
INSERT INTO Notification (message, date_notification, id_type_notification, id_utilisateur) 
VALUES 
('Your profile has been updated', '2023-06-01 10:00:00', 1, 1),
('You have a new job offer', '2023-06-02 12:00:00', 2, 2);

-- Table diplome_utilisateur
INSERT INTO diplome_utilisateur (id_utilisateur, id_diplome) 
VALUES 
(1, 1),
(2, 2);

-- Table secteur_diplome
INSERT INTO secteur_diplome (id_secteur, id_diplome) 
VALUES 
(1, 1),
(2, 2);

-- Table competence_secteur
INSERT INTO competence_secteur (id_secteur, id_competence) 
VALUES 
(1, 1),
(2, 2);

-- Insérer des données de test dans la table argent
INSERT INTO argent (solde,date_modification, id_utilisateur)
VALUES (1000.00,'2024-06-10 10:00:00', 1);

INSERT INTO argent (solde, id_utilisateur)
VALUES (2000.00, 2);

-- Insertion de données de test pour la table CompetenceUtilisateur
INSERT INTO competence_utilisateur (id_utilisateur, id_competence) VALUES
(1, 1),
(1, 2), 
(2, 2), 
(2, 3); 

-- Insert test data into Contact table
INSERT INTO Contact (num_telephone) VALUES ('+1234567890');
INSERT INTO Contact (num_telephone) VALUES ('+0987654321');
INSERT INTO Contact (num_telephone) VALUES ('+1122334455');
INSERT INTO Contact (num_telephone) VALUES ('+5566778899');
INSERT INTO Contact (num_telephone) VALUES ('+6677889900');

-- Insert test data into utilisateur_contact table
INSERT INTO utilisateur_contact (id_utilisateur, id_contact) VALUES (1, 1);
INSERT INTO utilisateur_contact (id_utilisateur, id_contact) VALUES (1, 2);
INSERT INTO utilisateur_contact (id_utilisateur, id_contact) VALUES (2, 3);
INSERT INTO utilisateur_contact (id_utilisateur, id_contact) VALUES (2, 4);
INSERT INTO utilisateur_contact (id_utilisateur, id_contact) VALUES (2, 5);
