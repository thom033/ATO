-- statistique de poste indisponible par secteur
SELECT * FROM statSecteur;

SELECT id_secteur, count(id_secteur) AS embauche FROM statSecteur
where disponibilite = false
group by id_secteur;

-- statistique de poste disponible par secteur
SELECT id_secteur, count(id_secteur) AS dispo FROM statSecteur
where disponibilite = true
group by id_secteur;

-- statistique de poste be mi-postule
SELECT id_secteur, count(id_secteur) AS total FROM poste
JOIN secteur_diplome sd ON poste.id_diplome = sd.id_diplome
group by id_secteur;


-- statistique par categorie de point
SELECT cout, count(cout) AS total FROM poste
group by cout;

-- statistique par point vendu par mois
SELECT Sum(quantite) AS total FROM point_vendu
WHERE extract(Month FROM date_vente) = ?