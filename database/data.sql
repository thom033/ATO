INSERT INTO Secteur (secteur) VALUES
('Finance'),
('Technologie'),
('Santé');

INSERT INTO Diplome (diplome, id_secteur) VALUES
('Baccalaureat', 1),
('Licence', 1),
('Master', 2);

INSERT INTO Competence (competence, description, id_secteur) VALUES
('Programmation Java', 'Développement d applications Java', 2),
('Analyse de données', 'Traitement et analyse des données', 3),
('Conception de bases de données', 'Modélisation et conception de bases de données', 1);


