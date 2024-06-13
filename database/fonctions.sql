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

