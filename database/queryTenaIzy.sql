INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, etat_civil, photo, point, latitude, longitude, motdepasse, description, salaire_recherche)
VALUES
('RAKOTO', 'Andry', '1985-06-15', '123 Rue Principale, Antananarivo', 'Andry.Rak@gmail.com', 'Celibataire', 'photo1.jpg', 100, -18.8667, 47.5167, MD5('password123'), 'Développeur Full Stack', 150000000),
('RAZAFIMANDIMBY', 'Sophie', '1990-11-20', '456 Rue Secondaire, Toamasina', 'sophie.martin@example.com', 'Mariée', 'photo2.jpg', 200, -18.1667, 49.3833, MD5('securepass'), 'Chef de projet', 180000000),
('RALAMBO', 'Julien', '1978-04-05', '789 Rue Tertiaire, Mahajanga', 'julien.leroy@example.com', 'Divorcé', 'photo3.jpg', 150, -15.7167, 46.3167, MD5('password789'), 'Analyste', 165000000);

-- Donnees pour la table Secteur
INSERT INTO Secteur (secteur)
VALUES
('Informatique'),
('Finance'),
('Marketing'),
('Droit'),
('Agroalimentaire');

-- Donnees pour la table Diplome
INSERT INTO Diplome (diplome, niveau)
VALUES
('Baccalaureat', 4),
('Licence', 6),
('Master', 7);

