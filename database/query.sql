-- Insert data into Utilisateur
INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, numero_telephone, etat_civil, profession, photo, point, latitude, longitude, motdepasse)
VALUES
('Doe', 'John', '1985-06-15', '123 Main St', 'john.doe@example.com', '1234567890', 'Single', 'Software Engineer', 'john_doe.jpg', 100, 40.7128, -74.0060, 'password123'),
('Smith', 'Jane', '1990-08-25', '456 Oak Ave', 'jane.smith@example.com', '0987654321', 'Married', 'Data Scientist', 'jane_smith.jpg', 200, 34.0522, -118.2437, 'securepassword');

-- Insert data into Secteur
INSERT INTO Secteur (nom_secteur)
VALUES
('Information Technology'),
('Healthcare');

-- Insert data into Diplome
INSERT INTO Diplome (diplome, id_secteur)
VALUES
('Bachelor of Science in Computer Science', 1),
('Master of Public Health', 2);

-- Insert data into Entreprise
INSERT INTO Entreprise (entreprise, point, type, date_creation, adresse, site_web, mail, num_telephone, latitude, longitude, image)
VALUES
('Tech Innovators', 500, 'Technology', '2010-04-25', '789 Tech Plaza', 'www.techinnovators.com', 'info@techinnovators.com', '1112223333', 37.7749, -122.4194, 'tech_innovators.jpg'),
('Health Solutions', 300, 'Healthcare', '2012-09-15', '321 Health Blvd', 'www.healthsolutions.com', 'contact@healthsolutions.com', '4445556666', 34.0522, -118.2437, 'health_solutions.jpg');

-- Insert data into poste
INSERT INTO poste (description, salaire, titre, id_diplome, id_entreprise)
VALUES
('Develop software solutions', 80000, 'Software Developer', 1, 1),
('Manage healthcare projects', 70000, 'Project Manager', 2, 2);

-- Insert data into competence
INSERT INTO competence (competence, description, id_utilisateur)
VALUES
('Java Programming', 'Expert in Java and related technologies', 1),
('Data Analysis', 'Skilled in data analysis and visualization', 2);

-- Insert data into experience
INSERT INTO experience (date_debut, date_fin, description, id_utilisateur)
VALUES
('2015-01-01', '2018-12-31', 'Worked as a junior developer', 1),
('2016-06-01', '2020-05-31', 'Worked as a data analyst', 2);

-- Insert data into Formation
INSERT INTO Formation (date_debut, date_fin, description, id_utilisateur)
VALUES
('2011-09-01', '2015-06-01', 'Completed Bachelor of Science in Computer Science', 1),
('2012-09-01', '2014-05-15', 'Completed Master of Public Health', 2);

-- Insert data into Notification
INSERT INTO Notification (message, date_notification, date_lu, id_utilisateur)
VALUES
('Welcome to our platform, John!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
('Welcome to our platform, Jane!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);

-- Insert data into Question
INSERT INTO Question (question)
VALUES
('What is the capital of France?'),
('What is the largest planet in our solar system?');

-- Insert data into Reponse
INSERT INTO Reponse (reponse, id_question)
VALUES
('Paris', 1),
('Jupiter', 2);

-- Insert data into diplome_utilisateur
INSERT INTO diplome_utilisateur (id_utilisateur, id_diplome)
VALUES
(1, 1),
(2, 2);
