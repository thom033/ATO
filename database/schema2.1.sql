CREATE DATABASE ato;
\c ato;

CREATE TABLE Utilisateur(
   id_utilisateur SERIAL,
   nom VARCHAR(255)  NOT NULL,
   prenom VARCHAR(255)  NOT NULL,
   date_naissance DATE NOT NULL CHECK(date_naissance < CURRENT_DATE),
   adresse VARCHAR(255) ,
   mail VARCHAR(255)  NOT NULL,
   etat_civil VARCHAR(255) ,
   photo VARCHAR(255)  NOT NULL,
   point BIGINT NOT NULL DEFAULT 0 CHECK(point >= 0 ),
   latitude NUMERIC(15,2)  ,
   longitude NUMERIC(15,2)  ,
   motdepasse VARCHAR(255)  NOT NULL,
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

CREATE TABLE competence(
   id_competence SERIAL,
   competence VARCHAR(255)  NOT NULL,
   description TEXT,
   PRIMARY KEY(id_competence)
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

CREATE TABLE Reponse(
   id_reponse SERIAL,
   reponse TEXT NOT NULL,
   id_question INTEGER NOT NULL,
   PRIMARY KEY(id_reponse),
   FOREIGN KEY(id_question) REFERENCES Question(id_question)
);

CREATE TABLE type_notification(
   id_type_notification SERIAL,
   poste INTEGER REFERENCES poste(id_poste),
   point BOOLEAN,
   PRIMARY KEY(id_type_notification)
);

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
   date_notification TIMESTAMP NOT NULL DEFAULT CURRRENT_DATE,
   date_lu TIMESTAMP DEFAULT CURRENT_DATE,
   id_type_notification INTEGER NOT NULL,
   id_utilisateur INTEGER NOT NULL,
   PRIMARY KEY(id_notification),
   FOREIGN KEY(id_type_notification) REFERENCES type_notification(id_type_notification),
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

CREATE VIEW utilisateur_details AS
SELECT
    u.id_utilisateur,
    u.nom,
    u.prenom,
    u.date_naissance,
    u.adresse,
    u.mail,
    u.etat_civil,
    u.photo,
    u.point,
    u.latitude,
    u.longitude,
    u.motdepasse,

    e.id_experiecne,
    e.date_debut AS experience_date_debut,
    e.date_fin AS experience_date_fin,
    e.description AS experience_description,

    f.id_formation,
    f.date_debut AS formation_date_debut,
    f.date_fin AS formation_date_fin,
    f.description AS formation_description,

    cu.id_competence,
    
    d.id_diplome
FROM
    Utilisateur u
LEFT JOIN experience e ON u.id_utilisateur = e.id_utilisateur
LEFT JOIN Formation f ON u.id_utilisateur = f.id_utilisateur
LEFT JOIN competence_utilisateur cu ON u.id_utilisateur = cu.id_utilisateur
LEFT JOIN diplome_utilisateur du ON u.id_utilisateur = du.id_utilisateur
LEFT JOIN competence c ON cu.id_competence = c.id_competence
LEFT JOIN Diplome d ON du.id_diplome = d.id_diplome;


CREATE OR REPLACE VIEW result_Acceuil AS
SELECT
   u.id_utilisateur,

   p.id_poste,
   p.poste_salaire,
   p.entreprise_nom,
   get_point_total(u.id_utilisateur,p.id_poste) AS pts_total
FROM
   utilisateur_details u,
   postes_details p
ORDER BY pts_total DESC;

CREATE OR REPLACE FUNCTION check_age(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    u_age INT;
    age_min INT;
    age_max INT;
    dtn DATE;
BEGIN
    -- Récupérer la date de naissance de l'utilisateur
    SELECT date_naissance INTO dtn
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Vérifier la valeur de dtn
    RAISE NOTICE 'Date de naissance: %', dtn;

    -- Calculer l'âge de l'utilisateur
    SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, dtn)) INTO u_age;

    -- Vérifier la valeur de u_age
    RAISE NOTICE 'Âge de l''utilisateur: %', u_age;

    -- Récupérer les âges minimum et maximum pour le poste
    SELECT poste_age_min, poste_age_max INTO age_min, age_max
    FROM postes_details
    WHERE id_poste = poste_id;

    -- Vérifier les valeurs de age_min et age_max
    RAISE NOTICE 'Âge minimum du poste: %', age_min;
    RAISE NOTICE 'Âge maximum du poste: %', age_max;

    -- Vérifier si l'âge de l'utilisateur est dans la plage requise
    IF u_age BETWEEN age_min AND age_max THEN
        RAISE NOTICE 'Résultat: TRUE';
        RETURN TRUE;
    ELSE
        RAISE NOTICE 'Résultat: FALSE';
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION check_experience(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    u_exp INT;
    exp_min INT;
    user_start_date DATE;
BEGIN
    -- Récupérer la date de début de l'expérience de l'utilisateur
    SELECT experience_date_debut INTO user_start_date
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Vérifier la valeur de user_start_date
    RAISE NOTICE 'Date debut: %', user_start_date;

    -- Calculer les années d'expérience de l'utilisateur
    SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, user_start_date)) INTO u_exp;

    -- Vérifier la valeur de u_exp
    RAISE NOTICE 'Années d''expérience de l''utilisateur: %', u_exp;

    -- Récupérer le nombre d'années d'expérience minimum requis pour le poste
    SELECT nbr_annee_experience INTO exp_min
    FROM postes_details
    WHERE id_poste = poste_id;

    -- Vérifier la valeur de exp_min
    RAISE NOTICE 'Années d''expérience minimum requis pour le poste: %', exp_min;

    -- Vérifier si les années d'expérience de l'utilisateur sont suffisantes
    IF u_exp >= exp_min THEN
        RAISE NOTICE 'Résultat: TRUE';
        RETURN TRUE;
    ELSE
        RAISE NOTICE 'Résultat: FALSE';
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION check_formation(user_id INT, poste_id INT) RETURNS BOOLEAN AS $$
DECLARE
    u_form INT;
    form_min INT;
    user_start_date DATE;
BEGIN
    -- Récupérer la date de début de la formation de l'utilisateur
    SELECT formation_date_debut INTO user_start_date
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Vérifier la valeur de user_start_date
    RAISE NOTICE 'Date debut formation: %', user_start_date;

    -- Calculer les années de formation de l'utilisateur
    SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, user_start_date)) INTO u_form;

    -- Vérifier la valeur de u_form
    RAISE NOTICE 'Années de formation de l''utilisateur: %', u_form;

    -- Récupérer le nombre d'années de formation minimum requis pour le poste
    SELECT nbr_annee_formation INTO form_min
    FROM postes_details
    WHERE id_poste = poste_id;

    -- Vérifier la valeur de form_min
    RAISE NOTICE 'Années de formation minimum requis pour le poste: %', form_min;

    -- Vérifier si les années de formation de l'utilisateur sont suffisantes
    IF u_form >= form_min THEN
        RAISE NOTICE 'Résultat: TRUE';
        RETURN TRUE;
    ELSE
        RAISE NOTICE 'Résultat: FALSE';
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

    -- Vérifier la valeur de user_diplome
    RAISE NOTICE 'Diplôme de l''utilisateur: %', user_diplome;

    -- Récupérer le diplôme requis pour le poste
    SELECT id_diplome INTO poste_diplome
    FROM postes_details
    WHERE id_poste = poste_id;

    -- Vérifier la valeur de poste_diplome
    RAISE NOTICE 'Diplôme requis pour le poste: %', poste_diplome;

    -- Vérifier si le diplôme de l'utilisateur correspond au diplôme requis
    IF user_diplome = poste_diplome THEN
        RAISE NOTICE 'Résultat: TRUE';
        RETURN TRUE;
    ELSE
        RAISE NOTICE 'Résultat: FALSE';
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calculate_distance(user_id INT, poste_id INT) RETURNS DOUBLE PRECISION AS $$
DECLARE
    u_latitude DOUBLE PRECISION;
    u_longitude DOUBLE PRECISION;
    p_latitude DOUBLE PRECISION;
    p_longitude DOUBLE PRECISION;

    R CONSTANT DOUBLE PRECISION := 6371; -- Rayon de la Terre en kilomètres
    lat_distance DOUBLE PRECISION;
    lon_distance DOUBLE PRECISION;
    a DOUBLE PRECISION;
    c DOUBLE PRECISION;
BEGIN
    -- Récupérer latitude et longitude de l'utilisateur
    SELECT latitude,longitude INTO u_latitude,u_longitude
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Récupérer latitude et longitude de l'entreprise
    SELECT entreprise_latitude,entreprise_longitude INTO p_latitude,p_longitude
    FROM postes_details
    WHERE id_poste = poste_id;

    -- Calculer les différences en radians
    lat_distance := RADIANS(u_latitude - p_latitude);
    lon_distance := RADIANS(u_longitude - p_longitude);

    -- Vérifier les valeurs de lat_distance et lon_distance
    RAISE NOTICE 'lat_distance: %', lat_distance;
    RAISE NOTICE 'lon_distance: %', lon_distance;

    -- Formule de Haversine pour calculer la distance
    a := SIN(lat_distance / 2) * SIN(lat_distance / 2)
        + COS(RADIANS(p_latitude)) * COS(RADIANS(u_latitude))
        * SIN(lon_distance / 2) * SIN(lon_distance / 2);

    -- Vérifier la valeur de a
    RAISE NOTICE 'a: %', a;

    c := 2 * ATAN2(SQRT(a), SQRT(1 - a));

    -- Vérifier la valeur de c
    RAISE NOTICE 'c: %', c;

    -- Retourner la distance en kilomètres
    RETURN R * c;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION point_distance(user_id INT, poste_id INT) RETURNS DOUBLE PRECISION AS $$
DECLARE
    u_latitude DOUBLE PRECISION;
    u_longitude DOUBLE PRECISION;
    p_latitude DOUBLE PRECISION;
    p_longitude DOUBLE PRECISION;
    distance DOUBLE PRECISION;
BEGIN
    -- Récupérer latitude et longitude de l'utilisateur
    SELECT latitude,longitude INTO u_latitude,u_longitude
    FROM utilisateur_details
    WHERE id_utilisateur = user_id;

    -- Récupérer latitude et longitude de l'entreprise
    SELECT entreprise_latitude,entreprise_longitude INTO p_latitude,p_longitude
    FROM postes_details
    WHERE id_poste = poste_id;
    
    -- Calculer la distance en utilisant la fonction calculate_distance
    distance := calculate_distance(user_id,poste_id);

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

CREATE OR REPLACE FUNCTION get_point_total(user_id INT, poste_id INT) RETURNS DOUBLE PRECISION AS $$
DECLARE
    point DOUBLE PRECISION := 0;
    distance DOUBLE PRECISION;
    distance_points INTEGER;
BEGIN
    -- Vérifier l'âge de l'utilisateur
    IF check_age(user_id, poste_id) = TRUE THEN
        point := point + 3;
    END IF;

    -- Vérifier l'expérience de l'utilisateur
    IF check_experience(user_id, poste_id) = TRUE THEN
        point := point + 5;
    END IF;

    -- Vérifier la formation de l'utilisateur
    IF check_formation(user_id, poste_id) = TRUE THEN
        point := point + 2;
    END IF;

    -- Vérifier le diplôme de l'utilisateur
    IF check_diplome(user_id, poste_id) = TRUE THEN
        point := point + 5;
    END IF;

    -- Calculer la distance entre l'utilisateur et le poste
    distance := calculate_distance(user_id,poste_id);

    -- Calculer les points en fonction de la distance
    IF distance > 0 THEN
        distance_points := point_distance(user_id,poste_id);
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

