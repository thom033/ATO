-- Données pour la table Utilisateur
INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, etat_civil, photo, point, latitude, longitude, motdepasse, description, salaire_recherche)
VALUES
('Dupont', 'Jean', '1985-06-15', '123 Rue Principale, Paris', 'jean.dupont@example.com', 'Célibataire', 'photo1.jpg', 100, 48.8566, 2.3522, MD5('password123'), 'Développeur Full Stack', 45000),
('Martin', 'Sophie', '1990-11-20', '456 Rue Secondaire, Lyon', 'sophie.martin@example.com', 'Marié', 'photo2.jpg', 200, 45.7640, 4.8357, MD5('securepass'), 'Chef de projet', 55000),
('Leroy', 'Julien', '1978-04-05', '789 Rue Tertiaire, Marseille', 'julien.leroy@example.com', 'Divorcé', 'photo3.jpg', 150, 43.2965, 5.3698, MD5('password789'), 'Analyste', 50000);

INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, etat_civil, photo, point, latitude, longitude, motdepasse, description, salaire_recherche)
VALUES
('Dupont', 'Jean', '1985-06-15', '123 Rue Principale, Paris', 'jjean.dupont@example.com', 'Célibataire', 'photo1.jpg', 100, 48.8566, 2.3522, MD5('password123'), 'Développeur Full Stack', 45000);

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
INSERT INTO poste (description, date_insertion, salaire, titre, annee_experience, annee_formation, age_min, age_max, image, id_diplome, id_entreprise,cout, disponibilite)
VALUES
('Développement de logiciels', CURRENT_DATE, 40000, 'Développeur', 2, 4, 25, 35, 'poste1.jpg', 2, 1,3, FALSE),
('Analyse financière', CURRENT_DATE, 50000, 'Analyste', 3, 5, 30, 40, 'poste2.jpg', 3, 2,2, FALSE),
('Gestion de projet marketing', CURRENT_DATE, 45000, 'Chef de Projet', 4, 6, 28, 38, 'poste3.jpg', 2, 3,5, TRUE);

INSERT INTO poste (description, date_insertion, salaire, titre, annee_experience, annee_formation, age_min, age_max, image, id_diplome, id_entreprise, cout, disponibilite)
VALUES
('Ingénierie réseau', CURRENT_DATE, 42000, 'Ingénieur Réseau', 3, 5, 27, 37, 'poste4.jpg', 2, 1, 4, TRUE),
('Administration de base de données', CURRENT_DATE, 48000, 'Administrateur BD', 4, 6, 29, 39, 'poste5.jpg', 3, 2, 3, FALSE),
('Développement Web', CURRENT_DATE, 39000, 'Développeur Web', 2, 4, 24, 34, 'poste6.jpg', 1, 3, 2, TRUE),
('Support technique', CURRENT_DATE, 35000, 'Technicien Support', 1, 3, 22, 32, 'poste7.jpg', 2, 1, 3, FALSE),
('Rédaction technique', CURRENT_DATE, 37000, 'Rédacteur Technique', 2, 4, 26, 36, 'poste8.jpg', 1, 2, 1, TRUE),
('Consultation en gestion', CURRENT_DATE, 55000, 'Consultant en Gestion', 5, 7, 32, 42, 'poste9.jpg', 3, 3, 4, FALSE),
('Conception graphique', CURRENT_DATE, 41000, 'Graphiste', 3, 5, 25, 35, 'poste10.jpg', 2, 1, 2, TRUE),
('Analyse de données', CURRENT_DATE, 46000, 'Analyste de Données', 4, 6, 28, 38, 'poste11.jpg', 3, 2, 3, FALSE),
('Gestion des ressources humaines', CURRENT_DATE, 50000, 'Responsable RH', 5, 7, 30, 40, 'poste12.jpg', 2, 3, 4, TRUE),
('Enseignement informatique', CURRENT_DATE, 38000, 'Formateur Informatique', 2, 4, 26, 36, 'poste13.jpg', 1, 1, 2, FALSE),
('Développement mobile', CURRENT_DATE, 43000, 'Développeur Mobile', 3, 5, 25, 35, 'poste14.jpg', 2, 2, 3, TRUE),
('Gestion des opérations', CURRENT_DATE, 51000, 'Manager Opérations', 5, 7, 32, 42, 'poste15.jpg', 3, 3, 4, FALSE),
('Rédaction de contenu', CURRENT_DATE, 36000, 'Rédacteur de Contenu', 2, 4, 24, 34, 'poste16.jpg', 1, 1, 2, TRUE),
('Consultation en finance', CURRENT_DATE, 57000, 'Consultant Finance', 6, 8, 34, 44, 'poste17.jpg', 3, 2, 5, FALSE),
('Développement de jeux vidéo', CURRENT_DATE, 42000, 'Développeur Jeux', 3, 5, 27, 37, 'poste18.jpg', 2, 3, 3, TRUE),
('Marketing digital', CURRENT_DATE, 45000, 'Spécialiste Marketing', 4, 6, 28, 38, 'poste19.jpg', 3, 1, 3, FALSE),
('Analyse de sécurité', CURRENT_DATE, 49000, 'Analyste Sécurité', 5, 7, 31, 41, 'poste20.jpg', 2, 2, 4, TRUE),
('Gestion des ventes', CURRENT_DATE, 52000, 'Directeur des Ventes', 6, 8, 33, 43, 'poste21.jpg', 3, 3, 5, FALSE),
('Enseignement mathématiques', CURRENT_DATE, 37000, 'Professeur Maths', 2, 4, 26, 36, 'poste22.jpg', 1, 1, 2, TRUE),
('Consultation en IT', CURRENT_DATE, 60000, 'Consultant IT', 7, 9, 35, 45, 'poste23.jpg', 3, 2, 6, FALSE),
('Développement frontend', CURRENT_DATE, 44000, 'Développeur Frontend', 3, 5, 25, 35, 'poste24.jpg', 2, 3, 3, TRUE),
('Gestion de produit', CURRENT_DATE, 54000, 'Chef de Produit', 5, 7, 30, 40, 'poste25.jpg', 3, 1, 4, FALSE),
('Support aux utilisateurs', CURRENT_DATE, 35000, 'Technicien Support', 1, 3, 22, 32, 'poste26.jpg', 2, 1, 2, TRUE),
('Rédaction web', CURRENT_DATE, 36000, 'Rédacteur Web', 2, 4, 24, 34, 'poste27.jpg', 1, 2, 2, FALSE),
('Consultation stratégique', CURRENT_DATE, 59000, 'Consultant Stratégie', 6, 8, 34, 44, 'poste28.jpg', 3, 3, 5, TRUE),
('Développement backend', CURRENT_DATE, 46000, 'Développeur Backend', 4, 6, 28, 38, 'poste29.jpg', 2, 2, 3, FALSE),
('Gestion de la qualité', CURRENT_DATE, 53000, 'Manager Qualité', 5, 7, 31, 41, 'poste30.jpg', 3, 1, 4, TRUE),
('Enseignement physique', CURRENT_DATE, 38000, 'Professeur Physique', 2, 4, 26, 36, 'poste31.jpg', 1, 2, 2, FALSE),
('Consultation juridique', CURRENT_DATE, 61000, 'Consultant Juridique', 7, 9, 35, 45, 'poste32.jpg', 3, 1, 6, TRUE),
('Développement logiciel embarqué', CURRENT_DATE, 47000, 'Développeur Embarqué', 4, 6, 29, 39, 'poste33.jpg', 2, 3, 3, FALSE);

INSERT INTO poste (description, date_insertion, salaire, titre, annee_experience, annee_formation, age_min, age_max, image, id_diplome, id_entreprise, cout, disponibilite)
VALUES
('Gestion des opérations', CURRENT_DATE, 51000, 'Manager Opérations', 5, 7, 32, 42, 'poste15.jpg', 3, 3, 4, FALSE);



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
INSERT INTO Formation (date_debut, description, date_fin, id_utilisateur,id_diplome)
VALUES
('2006-09-01', 'Licence en Informatique', '2009-06-30', 1,1);
('2010-09-01', 'Master en Gestion', '2012-06-30', 2,2),
('2000-09-01', 'Baccalaureat en Economie', '2003-06-30', 3,3);

-- Données pour la table Reponse
INSERT INTO Reponse (reponse)
VALUES
(1,'Le point c''est comme un droit de participation pour pouvoir postuler à un offre ou à un emploi'),
(2,'Illimté, c''est-à-dire que vous pouvez toujour acheter même si vous en avez déjà '),
(3,'Vous pouvez acheter des points si vous avez un compte, il suffit juste d''aller vers votre éspace pérsonnelle et trouver le bouton acheter point'),
(4,'Première étape : trouver le poste qui vous correspond le mieux, Deuxième étape : Cliquer sur le bouton postuler et remplir les informations nécéssaire, Troisième étape : Vous aller recevoir un notification pour l''entretien si votre profil correspond au profil rechercher'),
(5,'Premièrement, on collabore avec des entreprises reputés dans le monde professionnel. Deuxièmement, on facilite votre intégration dans les entreprises en partenariat avec nous parce que c''est nous qui séléctionne les dossiers et c''est encore nous qui fait les entretiens d''embauche'),
(6,'Le diplôme minimum est le BACC '),
(7,'Nous prenons le temps de comprendre la culture d''entreprise de nos clients et nous utilisons des entretiens comportementaux pour évaluer l''adéquation des candidats'),
(8,'Les termes et conditions incluent une description des services fournis, les obligations de chaque partie, et les politiques de remplacement et de remboursement'),
(9,'Nous effectuons des vérifications de références, évaluons la stabilité financière, et maintenons des relations étroites pour garantir des environnements de travail de qualité'),
(10,'Oui bien sur, vos points vous seront rendus dans le cas ou vous n''obtenez pas le poste.'),
(11,'Vous pouvez payer via votre carte bancaire ou optez pour les mobiles money');


-- Données pour la table Question
INSERT INTO Question (question, id_reponse)
VALUES
(1,'C''est quoi le point et à quoi ça sert ?',1),
(2,'quel est le maximum de points qu''on peut acheter ?',2),
(3,'Comment faire pour acheter des points ?',3),
(4,'Comment fait-on pour postuler ?',4),
(5,'Pourquoi on devrait vous faire confiance ?',5),
(6,'Quel est le diplôme minimum nécéssaire pour trouver un travail chez vous ?',6),
(7,'Comment assurez-vous que les candidats proposés sont en adéquation avec la culture d''entreprise de vos clients ?',7),
(8,'Quels sont les termes et conditions de votre contrat de service ?',8),
(9,'Comment assurez-vous la qualité et la fiabilité des entreprises avec lesquelles vous travaillez ?',9),
(10,'Si je ne suis pas recruter, est-ce qu''il y aura un remboursement ?',10),
(11,'Quelles sont les options de paiement acceptées ?',11);


INSERT INTO historique_question(id_question, id_utilisateur)
VALUES
(1,1);

-- Données pour la table type_notification
-- INSERT INTO type_notification (poste, point)
-- VALUES
-- (null, TRUE),
-- (2, FALSE),
-- (null, TRUE);

-- Données pour la table administrateur
INSERT INTO administrateur (mail, mot_de_passe)
VALUES
('admin@example.com', 'adminpass'),
('admin2@example.com', 'adminpass2'),
('admin3@example.com', 'adminpass3');

-- Données pour la table Notification
INSERT INTO Notification (message, date_notification, date_lu, id_utilisateur,id_poste, point, id_entretien)
VALUES
('Nouvelle offre d emploi disponible qui vous corresponds à 85%', CURRENT_TIMESTAMP, NULL, 1,1,FALSE,null),
('Votre profil a ete mis a jour', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1,null,FALSE,null),
('Vous avez acheté 25pts', CURRENT_TIMESTAMP, NULL, 1,null,TRUE ,null),
('Convocation à un entretien d embauche', CURRENT_TIMESTAMP, NULL, 1,null,FALSE, 1 );

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

-- Insert test data into entreprise_contact table
INSERT INTO entreprise_contact (id_entreprise, id_contact) VALUES (1, 1);
INSERT INTO entreprise_contact (id_entreprise, id_contact) VALUES (1, 2);
INSERT INTO entreprise_contact (id_entreprise, id_contact) VALUES (2, 3);
INSERT INTO entreprise_contact (id_entreprise, id_contact) VALUES (3, 4);

INSERT INTO entretien(date_envoi, date_entretien, id_utilisateur, id_poste) VALUES
('2024-06-10 10:00:00', '2024-06-15 14:30:00', 1, 3),
('2024-06-05 08:00:00', '2024-06-13 10:00:00',1, 2);

INSERT INTO historique_question(id_question,id_utilisateur) values(1,2);
INSERT INTO historique_question(id_question,id_utilisateur) values(2,3);
INSERT INTO historique_question(id_question,id_utilisateur) values(1,3);
INSERT INTO historique_question(id_question,id_utilisateur) values(2,1);
INSERT INTO historique_question(id_question,id_utilisateur) values(3,1);
INSERT INTO historique_question(id_question,id_utilisateur) values(4,1);
INSERT INTO historique_question(id_question,id_utilisateur) values(4,2);


INSERT INTO Question (question, id_reponse)
VALUES
('Comment ?',4);

INSERT INTO Reponse (reponse)
VALUES
('Comme ça');

insert into point_vendu(id_utilisateur,point,date) values(1,2,DEFAULT);
insert into point_vendu(id_utilisateur,point,date) values(2,4,DEFAULT);
insert into point_vendu(id_utilisateur,point,date) values(3,1,DEFAULT);

insert into point_vendu(id_utilisateur,point,date) values(1,1,'2024-06-21');
insert into point_vendu(id_utilisateur,point,date) values(1,3,'2024-05-21');
insert into point_vendu(id_utilisateur,point,date) values(2,3,'2024-05-21');
insert into point_vendu(id_utilisateur,point,date) values(3,4,'2024-05-21');
insert into point_vendu(id_utilisateur,point,date) values(2,4,'2024-04-21');
insert into point_vendu(id_utilisateur,point,date) values(1,3,'2024-03-21');
insert into point_vendu(id_utilisateur,point,date) values(3,2,'2024-02-21');
insert into point_vendu(id_utilisateur,point,date) values(1,5,'2024-01-21');

insert into point_vendu(id_utilisateur,point,date) values(2,3,'2023-12-21');
insert into point_vendu(id_utilisateur,point,date) values(1,1,'2023-11-21');
insert into point_vendu(id_utilisateur,point,date) values(3,2,'2023-10-21');
insert into point_vendu(id_utilisateur,point,date) values(1,0,'2023-09-21');
insert into point_vendu(id_utilisateur,point,date) values(2,5,'2023-08-21');
insert into point_vendu(id_utilisateur,point,date) values(1,4,'2023-07-21');
insert into point_vendu(id_utilisateur,point,date) values(3,1,'2023-06-21');
insert into point_vendu(id_utilisateur,point,date) values(1,8,'2023-05-21');
insert into point_vendu(id_utilisateur,point,date) values(2,6,'2023-04-21');
insert into point_vendu(id_utilisateur,point,date) values(1,5,'2023-03-21');
insert into point_vendu(id_utilisateur,point,date) values(3,10,'2023-02-21');
insert into point_vendu(id_utilisateur,point,date) values(1,3,'2023-01-21');

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-06-10','2024-06-21',2,1,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-06-10','2024-06-21',3,1,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-06-10','2024-06-21',1,2,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-06-10','2024-06-21',1,3,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-05-10','2024-05-21',1,4,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-05-10','2024-05-21',1,5,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-04-10','2024-04-21',1,6,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-04-10','2024-04-21',1,8,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-04-10','2024-04-21',1,9,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-04-10','2024-04-21',1,10,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,11,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,1,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,12,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,13,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,14,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,15,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,16,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-03-10','2024-03-21',1,17,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-02-10','2024-02-21',1,18,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-02-10','2024-02-21',1,19,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,20,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,21,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,31,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,22,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,23,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,24,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,25,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2024-01-10','2024-01-21',1,26,TRUE);



insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-12-10','2023-12-21',1,27,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-12-10','2023-12-21',1,28,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-12-10','2023-12-21',1,29,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-12-10','2023-12-21',1,30,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-12-10','2023-12-21',1,1,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-11-10','2023-11-21',1,10,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-11-10','2023-11-21',1,11,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-11-10','2023-11-21',1,12,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-11-10','2023-11-21',1,13,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-11-10','2023-11-21',1,14,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-10-10','2023-10-21',1,15,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,16,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,17,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,18,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-08-10','2023-08-21',1,19,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,21,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,31,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,1,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,2,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,3,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,4,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-09-10','2023-09-21',1,5,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-08-10','2023-08-21',1,6,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-08-10','2023-08-21',1,7,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-08-10','2023-08-21',1,8,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-08-10','2023-08-21',1,9,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-08-10','2023-08-21',1,10,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-07-10','2023-07-21',1,11,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-07-10','2023-07-21',1,12,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-07-10','2023-07-21',1,13,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-07-10','2023-07-21',1,14,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-06-10','2023-06-21',1,15,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-06-10','2023-06-21',1,16,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-06-10','2023-06-21',1,17,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,18,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,19,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,20,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,21,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,22,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,23,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,24,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-05-10','2023-05-21',1,25,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-03-10','2023-03-21',1,26,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-03-10','2023-03-21',1,27,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-03-10','2023-03-21',1,28,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-03-10','2023-03-21',1,29,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,30,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,31,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,32,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,33,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,1,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,2,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,3,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-02-10','2023-02-21',1,4,TRUE);

insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-01-10','2023-01-21',1,5,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-01-10','2023-01-21',1,6,TRUE);
insert into entretien(date_envoi,date_entretien,id_utilisateur,id_poste,reussite) VALUES('2023-01-10','2023-01-21',1,7,TRUE);

insert into prix_point(prix,date_changement) values(10000,'2023-01-01');
insert into prix_point(prix,date_changement) values(15000,'2023-06-01');
insert into prix_point(prix,date_changement) values(7000,'2023-11-01');
insert into prix_point(prix,date_changement) values(7500,'2024-04-01');

select sum(point) as point,extract(month from date) as mois from point_vendu where extract(year from date)=2024 group by extract(month from date);

select id_question,count(id_question) as nbQuestion,question from question natural join historique_question group by id_question,question limit 3;

select secteur.id_secteur,count(secteur.id_secteur) as nbSecteur,secteur.secteur from poste natural join diplome join secteur_diplome as secteurDip on secteurDip.id_diplome=diplome.id_diplome join secteur on secteur.id_secteur=secteurDip.id_secteur group by secteur.secteur,secteur.id_secteur;

select extract(month from date) as mois,sum(get_price(date)*point) as prix from point_vendu where extract(year from date)=2023 group by extract(month from date);

with argent_entrant as( 
   select extract(month from date_entretien) as mois, sum(salaire) as prix 
   from entretien 
   natural join poste 
   where extract(year from date_entretien)=2023 and reussite  
   group by extract(month from date_entretien) 
   union 
   select extract(month from date) as mois,sum(get_price(date)*point) as prix 
   from point_vendu 
   where extract(year from date)=2023 group by extract(month from date))
select sum(prix),mois from argent_entrant group by mois;

with argent_entrant as (select sum(salaire) as prix from entretien natural join poste where '2024-01-01'<date_entretien and date_entretien<'2024-06-01' and reussite union select sum(get_price(date)*point) as prix from point_vendu where '2024-01-01'<date and date<'2024-06-01') select sum(prix) as prix from argent_entrant;