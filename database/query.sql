-- Table Utilisateur
INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, etat_civil, photo, point, latitude, longitude, motdepasse) 
VALUES 
('Doe', 'John', '1990-01-01', '123 Main St', 'john.doe@example.com', 'Single', 'john_photo.png', 100, 40.7128, -74.0060, 'password123'),
('Smith', 'Jane', '1985-05-15', '456 Elm St', 'jane.smith@example.com', 'Married', 'jane_photo.png', 200, 34.0522, -118.2437, 'securepassword'),
('Brown', 'Alice', '1995-10-20', '789 Pine St', 'alice.brown@example.com', 'Single', 'alice_photo.png', 300, 51.5074, -0.1278, 'password1234'),
('Wilson', 'Bob', '1980-03-10', '101 Oak St', 'bob.wilson@example.com', 'Married', 'bob_photo.png', 400, 37.7749, -122.4194, 'securepassword123');

-- Table Admin
INSERT INTO administrateur(mail,mot_de_passe) VALUES('Ryan@gmail.com','1234');

-- Table Secteur
INSERT INTO Secteur (secteur) 
VALUES 
('Technology'), 
('Healthcare'),
('Finance'),
('Education'),
('Retail');

-- Table Diplome
INSERT INTO Diplome (diplome, niveau) 
VALUES 
('Bachelor of Science', 1), 
('Master of Arts', 2),
('Doctor of Philosophy', 3),
('Associate of Arts', 1),
('Master of Business Administration', 2),
('Doctor of Medicine', 3),
('Bachelor of Education', 1),
('Master of Science', 2),
('Doctor of Engineering', 3),
('Associate of Applied Science', 1);

-- Table Entreprise
INSERT INTO Entreprise (entreprise, point, type, date_creation, adresse, site_web, mail, latitude, longitude, image) 
VALUES 
('TechCorp', 500, 'Technology', '2000-01-01', '789 Oak St', 'http://techcorp.com', 'contact@techcorp.com', 37.7749, -122.4194, 'techcorp.png'),
('HealthInc', 300, 'Healthcare', '1995-06-15', '101 Maple St', 'http://healthinc.com', 'info@healthinc.com', 51.5074, -0.1278, 'healthinc.png'),
('FinanceCo', 200, 'Finance', '1990-12-01', '456 Pine St', 'http://financeco.com', 'xx@xx.com', 34.0522, -118.2437, 'financeco.png'),
('EduTech', 100, 'Education', '1985-03-10', '123 Elm St', 'http://edutech.com', 'aa@aa.com', 40.7128, -74.0060, 'edutech.png'),
('RetailMart', 50, 'Retail', '1980-08-20', '789 Main St', 'http://retailmart.com', 'rr@rr.com', 40.7128, -74.0060, 'retailmart.png');

-- Table poste
INSERT INTO poste (description, salaire, titre, annee_experience, annee_formation, age_min, age_max, id_diplome, id_entreprise) 
VALUES 
('Software Developer', 70000.00, 'Developer', 2, 4, 22, 35, 1, 1),
('Nurse', 50000.00, 'Registered Nurse', 3, 4, 25, 40, 2, 2),
('Financial Analyst', 80000.00, 'Analyst', 3, 4, 25, 40, 3, 3),
('Teacher', 60000.00, 'Educator', 3, 4, 25, 40, 1, 4),
('Sales Associate', 40000.00, 'Associate', 2, 3, 20, 30, 2, 5),
('Software Engineer', 90000.00, 'Engineer', 4, 5, 25, 40, 3, 1),
('Nurse Practitioner', 70000.00, 'Practitioner', 4, 5, 25, 40, 1, 2),
('Financial Advisor', 100000.00, 'Advisor', 5, 6, 30, 45, 2, 3),
('Professor', 80000.00, 'Professor', 5, 6, 30, 45, 3, 4),
('Store Manager', 60000.00, 'Manager', 4, 5, 25, 40, 1, 5),
('Senior Software Developer', 100000.00, 'Senior Developer', 6, 7, 30, 45, 2, 1),
('Nurse Manager', 80000.00, 'Manager', 6, 7, 30, 45, 3, 2),
('Financial Manager', 120000.00, 'Manager', 7, 8, 35, 50, 1, 3),
('Principal', 100000.00, 'Principal', 7, 8, 35, 50, 2, 4),
('Retail Manager', 70000.00, 'Manager', 6, 7, 30, 45, 3, 5),
('Lead Software Engineer', 120000.00, 'Lead Engineer', 8, 9, 35, 50, 1, 1),
('Nurse Supervisor', 90000.00, 'Supervisor', 8, 9, 35, 50, 2, 2),
('Financial Director', 140000.00, 'Director', 9, 10, 40, 55, 3, 3),
('Dean', 120000.00, 'Dean', 9, 10, 40, 55, 1, 4),
('Retail Director', 80000.00, 'Director', 8, 9, 35, 50, 2, 5),
('Chief Technology Officer', 150000.00, 'CTO', 10, 11, 45, 60, 3, 1),
('Nurse Director', 100000.00, 'Director', 10, 11, 45, 60, 1, 2),
('Chief Financial Officer', 160000.00, 'CFO', 11, 12, 50, 65, 2, 3),
('Provost', 140000.00, 'Provost', 11, 12, 50, 65, 3, 4),
('Retail Vice President', 90000.00, 'Vice President', 10, 11, 45, 60, 1, 5);

-- Table competence
INSERT INTO competence (competence, description, id_utilisateur) 
VALUES 
('Java Programming', 'Proficient in Java development', 1),
('Patient Care', 'Experienced in patient care and nursing', 2),
('Financial Analysis', 'Skilled in financial analysis and reporting', 3),
('Teaching', 'Knowledgeable in teaching and education', 4),
('Sales', 'Experienced in sales and customer service', 5),
('Software Development', 'Experienced in software development and engineering', 1),
('Nursing', 'Experienced in nursing and patient care', 2),
('Finance', 'Skilled in financial analysis and reporting', 3),
('Education', 'Knowledgeable in teaching and education', 4),
('Retail', 'Experienced in retail management and sales', 5);

-- Table experience
INSERT INTO experience (date_debut, date_fin, description, id_utilisateur) 
VALUES 
('2015-01-01', '2018-12-31', 'Worked as a software developer at TechCorp', 1),
('2010-03-01', '2015-03-31', 'Worked as a nurse at HealthInc', 2),
('2015-06-01', '2018-09-30', 'Worked as a financial analyst at FinanceCo', 3),
('2010-09-01', '2015-06-30', 'Worked as a teacher at EduTech', 4),
('2015-12-01', '2019-12-31', 'Worked as a sales associate at RetailMart', 5),
('2019-01-01', '2022-12-31', 'Worked as a software engineer at TechCorp', 1),
('2015-03-01', '2019-03-31', 'Worked as a nurse practitioner at HealthInc', 2),
('2019-06-01', '2023-09-30', 'Worked as a financial advisor at FinanceCo', 3),
('2015-09-01', '2019-06-30', 'Worked as a professor at EduTech', 4),
('2020-01-01', '2023-12-31', 'Worked as a store manager at RetailMart', 5);

-- Table Formation
INSERT INTO Formation (date_debut, description, date_fin, id_utilisateur) 
VALUES 
('2014-09-01', 'Completed Bachelor s degree in Computer Science', '2018-06-01', 1),
('2008-09-01', 'Completed Bachelor s degree in Nursing', '2012-06-01', 2),
('2014-09-01', 'Completed Bachelor s degree in Finance', '2018-06-01', 3),
('2009-09-01', 'Completed Bachelor s degree in Education', '2013-06-01', 4),
('2018-09-01', 'Completed Master s degree in Computer Science', '2020-06-01', 1),
('2012-09-01', 'Completed Master s degree in Nursing', '2014-06-01', 2),
('2018-09-01', 'Completed Master s degree in Finance', '2020-06-01', 3),
('2013-09-01', 'Completed Master s degree in Education', '2015-06-01', 4),
('2018-09-01', 'Completed Master s degree in Business Administration', '2020-06-01', 5);


-- Table Contact
INSERT INTO Contact (num_telephone, id_entreprise, id_utilisateur) 
VALUES 
('123-456-7890', 1, 1),
('987-654-3210', 2, 2),
('555-555-5555', 3, 3),
('111-222-3333', 4, 4),
('444-444-4444', 5, 5),
('123-456-7890', 1, 1),
('987-654-3210', 2, 2),
('555-555-5555', 3, 3),
('111-222-3333', 4, 4),
('444-444-4444', 5, 5);

-- Table diplome_utilisateur
INSERT INTO diplome_utilisateur (id_utilisateur, id_diplome) 
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(1, 16),
(2, 17),
(3, 18),
(4, 19);
-- Table secteur_diplome
INSERT INTO secteur_diplome (id_secteur, id_diplome) 
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(1, 16),
(2, 17),
(3, 18),
(4, 19),
(5, 20);

-- Table competence_secteur
INSERT INTO competence_secteur (id_secteur, id_competence) 
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(1, 16),
(2, 17),
(3, 18),
(4, 19),
(5, 20);

SELECT AGE(CURRENT_DATE, date_of_birth) AS age
FROM your_table;

SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_naissance)) AS age
FROM utilisateur_details;

SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_naissance)) AS age1,EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_naissance))AS age2
FROM utilisateur_details;

SELECT check_age(1, 1) AS age_check_result;
SELECT check_experience(1, 1) AS age_check_result;
SELECT check_formation(1, 1) AS age_check_result;
SELECT check_diplome(1, 1) AS age_check_result;
SELECT calculate_distance(1, 1) AS age_check_result;
SELECT point_distance(1, 1) AS age_check_result;
SELECT get_point_total(1,1) AS pts_total;

