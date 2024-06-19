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
    p.image AS poste_image,
    p.cout AS poste_cout,
    
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

    e.id_experience,
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
   u.id_diplome,

   p.id_secteur,
   p.id_poste,
   p.poste_salaire,
   p.poste_description,
   p.poste_titre,
   p.entreprise_nom,
   p.entreprise_point,
   get_point_total(u.id_utilisateur,p.id_poste) AS pts_total
FROM
   utilisateur_details u,
   postes_details p
ORDER BY pts_total DESC;

SELECT * FROM result_acceuil order by entreprise_point DESC limit 3;