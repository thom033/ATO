CREATE OR REPLACE FUNCTION calculate_age(birth_date DATE)
RETURNS INT AS $$
BEGIN
    RETURN DATE_PART('year', AGE(birth_date));
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION check_age(user_id BIGINT, poste_id BIGINT)
RETURNS BOOLEAN AS $$
DECLARE
    user_age INT;
    poste_age_min INT;
    poste_age_max INT;
BEGIN
    SELECT calculate_age(date_naissance) INTO user_age
    FROM utilisateur
    WHERE id_utilisateur = user_id;

    SELECT age_min, age_max INTO poste_age_min, poste_age_max
    FROM poste
    WHERE id_poste = poste_id;

    RETURN user_age BETWEEN poste_age_min AND poste_age_max;
END;
$$ LANGUAGE plpgsql;

select check_age(1,1) from utilisateur;