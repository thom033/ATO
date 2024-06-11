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

CREATE OR REPLACE FUNCTION check_age(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    u_age INT;
    age_min INT;
    age_max INT;
    date_naissance DATE;
BEGIN
    -- Récupérer la date de naissance de l'utilisateur
    SELECT date_naissance INTO date_naissance
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Calculer l'âge de l'utilisateur
    SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_naissance)) INTO u_age;

    -- Récupérer les âges minimum et maximum pour le poste
    SELECT poste_age_min, poste_age_max INTO age_min, age_max
    FROM poste_details
    WHERE id_poste = poste_id;

    -- Vérifier si l'âge de l'utilisateur est dans la plage requise
    IF u_age >= age_min AND u_age <= age_max THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION check_experience(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    u_exp INT;
    exp_min INT;
    date_debut_experience DATE;
BEGIN
    -- Récupérer la date de début de l'expérience de l'utilisateur
    SELECT date_debut_experience INTO date_debut_experience
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Calculer les années d'expérience de l'utilisateur
    SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_debut_experience)) INTO u_exp;

    -- Récupérer le nombre d'années d'expérience minimum requis pour le poste
    SELECT nbr_annee_experience INTO exp_min
    FROM poste_details
    WHERE id_poste = poste_id;

    -- Vérifier si les années d'expérience de l'utilisateur sont suffisantes
    IF u_exp >= exp_min THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION check_formation(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    u_form INT;
    form_min INT;
    date_debut_formation DATE;
BEGIN
    -- Récupérer la date de début de la formation de l'utilisateur
    SELECT date_debut_formation INTO date_debut_formation
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Calculer les années de formation de l'utilisateur
    SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, date_debut_formation)) INTO u_form;

    -- Récupérer le nombre d'années de formation minimum requis pour le poste
    SELECT nbr_annee_formation INTO form_min
    FROM poste_details
    WHERE id_poste = poste_id;

    -- Vérifier si les années de formation de l'utilisateur sont suffisantes
    IF u_form >= form_min THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION check_diplome(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    user_diplome INT;
    poste_diplome INT;
BEGIN
    -- Récupérer le diplôme de l'utilisateur
    SELECT id_diplome INTO user_diplome
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Récupérer le diplôme requis pour le poste
    SELECT id_diplome INTO poste_diplome
    FROM poste_details
    WHERE id_poste = poste_id;

    -- Vérifier si le diplôme de l'utilisateur correspond au diplôme requis
    IF user_diplome = poste_diplome THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calculate_distance(
    u_latitude DOUBLE PRECISION,
    u_longitude DOUBLE PRECISION,
    p_latitude DOUBLE PRECISION,
    p_longitude DOUBLE PRECISION
) RETURNS DOUBLE PRECISION AS $$
DECLARE
    R CONSTANT DOUBLE PRECISION := 6371; -- Rayon de la Terre en kilomètres
    lat_distance DOUBLE PRECISION;
    lon_distance DOUBLE PRECISION;
    a DOUBLE PRECISION;
    c DOUBLE PRECISION;
BEGIN
    -- Calculer les différences en radians
    lat_distance := RADIANS(u_latitude - p_latitude);
    lon_distance := RADIANS(u_longitude - p_longitude);

    -- Formule de Haversine pour calculer la distance
    a := SIN(lat_distance / 2) * SIN(lat_distance / 2)
        + COS(RADIANS(p_latitude)) * COS(RADIANS(u_latitude))
        * SIN(lon_distance / 2) * SIN(lon_distance / 2);
    c := 2 * ATAN2(SQRT(a), SQRT(1 - a));

    -- Retourner la distance en kilomètres
    RETURN R * c;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION point_distance(
    u_latitude DOUBLE PRECISION,
    u_longitude DOUBLE PRECISION,
    p_latitude DOUBLE PRECISION,
    p_longitude DOUBLE PRECISION
) RETURNS INTEGER AS $$
DECLARE
    distance DOUBLE PRECISION;
BEGIN
    -- Calculer la distance en utilisant la fonction calculate_distance
    distance := calculate_distance(u_latitude, u_longitude, p_latitude, p_longitude);

    -- Déterminer les points en fonction de la distance
    IF distance > 50 THEN
        RETURN 50;
    ELSIF distance > 25 THEN
        RETURN 25;
    ELSIF distance > 5 THEN
        RETURN 5;
    ELSE
        RETURN 0;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_point_total(
    u_latitude numeric(15,2),
    u_longitude numeric(15,2),
    p_latitude numeric(15,2),
    p_longitude numeric(15,2),
    u_age INTEGER,
    u_experience INTEGER,
    u_formation INTEGER,
    u_diplome INTEGER
) RETURNS DOUBLE PRECISION AS $$
DECLARE
    point DOUBLE PRECISION := 0;
    distance DOUBLE PRECISION;
    distance_points INTEGER;
BEGIN
    -- Vérifier l'âge de l'utilisateur
    IF u_age >= poste_age_min AND u_age <= poste_age_max THEN
        point := point + 3;
    END IF;

    -- Vérifier l'expérience de l'utilisateur
    IF u_experience >= nbr_annee_experience THEN
        point := point + 5;
    END IF;

    -- Vérifier la formation de l'utilisateur
    IF u_formation >= nbr_annee_formation THEN
        point := point + 2;
    END IF;

    -- Vérifier le diplôme de l'utilisateur
    IF u_diplome = id_diplome THEN
        point := point + 5;
    END IF;

    -- Calculer la distance entre l'utilisateur et le poste
    distance := calculate_distance(u_latitude, u_longitude, p_latitude, p_longitude);

    -- Calculer les points en fonction de la distance
    IF distance > 0 THEN
        distance_points := point_distance(u_latitude, u_longitude, p_latitude, p_longitude);
        CASE
            WHEN distance_points = 5 THEN point := point + 5;
            WHEN distance_points = 25 THEN point := point + 2.5; -- 5 / 2
            WHEN distance_points = 50 THEN point := point + 1.25; -- 5 / 4
            ELSE point := point + 0;
        END CASE;
    END IF;

    -- Retourner le nombre total de points
    RETURN (point / 20.0) * 100.0;
END;
$$ LANGUAGE plpgsql;

SELECT get_point_total(
    u.latitude, 
    u.longitude, 
    p.entreprise_latitude, 
    p.entreprise_longitude,
    u.age,
    u.experience,
    u.formation,
    u.diplome
) AS total_points
FROM utilisateur_details u, poste_details p
WHERE u.id_utilisateur = :user_id AND p.id_poste = :poste_id;

SELECT get_point_total(
    u.latitude, --num
    u.longitude, --num
    p.entreprise_latitude, --double
    p.entreprise_longitude, --double
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, u.date_naissance)), --double
    EXTRACT(YEAR FROM AGE(u.experience_date_debut, u.experience_date_fin)), --double
    EXTRACT(YEAR FROM AGE(u.formation_date_debut, u.formation_date_fin)), --double
    u.id_diplome --integer
) AS total_points
FROM utilisateur_details u, postes_details p
WHERE u.id_utilisateur = 1 AND p.id_poste = 1;

