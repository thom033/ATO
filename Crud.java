package com.gdp.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.lang.reflect.Field;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import com.gbd.connexion.Connexion;

public class Crud{


    //CRUD Utilisateur
    public void createUtilisateur(Utilisateur u) throws Exception
    { 
        Connection connection = null;
        PreparedStatement ps = null;

        try 
        {
            connection = Connexion.getConnexion();
            String sql = "INSERT INTO Utilisateur (nom, prenom, date_naissance, adresse, mail, numero_telephone, etat_civil, profession, photo, point, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getDate_naissance());
            ps.setString(4, u.getAdresse());
            ps.setString(5, u.getMail());
            ps.setString(6, u.getNumero_telephone());
            ps.setString(7, u.getEtat_civil());
            ps.setString(8, u.getProfession());
            ps.setString(9, u.getPhoto());
            ps.setString(10, String.valueOf(u.getPoint()));
            ps.setString(11, String.valueOf(u.getLatitude()));
            ps.setString(12, String.valueOf(u.getLongitude()));

            ps.executeUpdate();
           
        } catch (Exception e)
        {
            System.out.println(e);
        }
        finally 
        {
            if (ps != null) {

                ps.close();

            }
        }

        Connexion.closeConnection(connection);

    }

    public void deleteUtilisateur(int id_utilisateur) throws Exception
    {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = Connexion.getConnexion();
            String sql = "DELETE FROM Utilisateur WHERE id_utilisateur = ?;";
            ps.setString(1, String.valueOf(id_utilisateur));
            ps.executeUpdate();
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally 
        {
            if (ps != null) {

                ps.close();

            }
        }

        Connexion.closeConnection(connection);

    }
    public void updateUtilisateur(Utilisateur u) throws Exception
    {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connexion.getConnexion();
           
            String sql = "UPDATE Utilisateur SET nom = ?, prenom = ?, date_naissance = ?, adresse = ?, mail= ?, numero_telephone = ?, " +
            "etat_civil = ?, profession = ?, photo = ?, point = ?, latitude = ?, longitude = ? " +
            "WHERE id_utilisateur = ?";

                        ps = connection.prepareStatement(sql);
                        ps.setString(1, u.getNom());
                        ps.setString(2, u.getPrenom());
                        ps.setString(3, u.getDate_naissance());
                        ps.setString(4, u.getAdresse());
                        ps.setString(5, u.getMail());
                        ps.setString(6, u.getNumero_telephone());
                        ps.setString(7, u.getEtat_civil());
                        ps.setString(8, u.getProfession());
                        ps.setString(9, u.getPhoto());
                        ps.setString(10, String.valueOf(u.getPoint()));
                        ps.setString(11, String.valueOf(u.getLatitude()));
                        ps.setString(12, String.valueOf(u.getLongitude()));
                        ps.setString(13, String.valueOf(u.getId_utilisateur()));
                
                    ps.executeUpdate();
                    
            } 
            catch (Exception e)
            {
                System.out.println(e);
            }
            finally 
            {
                if (ps != null) {
    
                    ps.close();
    
                }
            }
    
            Connexion.closeConnection(connection);
    
    }

    public Utilisateur readUtilisateur(int id_utilisateur)
    {
        Connection connection = null;
        PreparedStatement ps = null;

        Utilisateur utilisateur = null;

        try 
        {
            connection = Connex.getConnection();
            String sql = "SELECT * FROM Utilisateur WHERE id_utilisateur = ?";
            ps.setString(1, String.valueOf(id_utilisateur));

            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {    
                    utilisateur = new Utilisateur();
                    utilisateur.setId_utilisateur(rs.getInt("id_utilisateur"));
                    utilisateur.setNom(rs.getString("nom"));
                    utilisateur.setPrenom(rs.getString("prenom"));
                    utilisateur.setDate_naissance(rs.getString("date_naissance"));
                    utilisateur.setAdresse(rs.getString("adresse"));
                    utilisateur.setMail(rs.getString("mail"));
                    utilisateur.setNumero_telephone(rs.getString("numero_telephone"));
                    utilisateur.setEtat_civil(rs.getString("etat_civil"));
                    utilisateur.setProfession(rs.getString("profession"));
                    utilisateur.setPhoto(rs.getString("photo"));
                    utilisateur.setPoint(rs.getLong("point"));
                    utilisateur.setLatitude(rs.getDouble("latitude"));
                    utilisateur.setLongitude(rs.getDouble("longitude"));

                }
            }
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        finally 
        {
            if (ps != null) {

                ps.close();

            }
        }

        Connexion.closeConnection(connection);

        return utilisateur;
    }
    //

    //CRUD Secteur

    public void createSecteur(Secteur secteur) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "INSERT INTO Secteur (nom_secteur) VALUES (?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, secteur.getNom_secteur());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public Secteur readSecteur(int id_secteur) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Secteur secteur = null;

        try {
            connection = Connex.getConnection();
            String sql = "SELECT * FROM Secteur WHERE id_secteur = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_secteur);

            rs = ps.executeQuery();
            if (rs.next()) {
                secteur = new Secteur();
                secteur.setId_secteur(rs.getInt("id_secteur"));
                secteur.setNom_secteur(rs.getString("nom_secteur"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }

        return secteur;
    }

    public void updateSecteur(Secteur secteur) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "UPDATE Secteur SET nom_secteur = ? WHERE id_secteur = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, secteur.getNom_secteur());
            ps.setInt(2, secteur.getId_secteur());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void deleteSecteur(int id_secteur) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "DELETE FROM Secteur WHERE id_secteur = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_secteur);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    //

    //CRUD Diplome 
    public void createDiplome(Diplome diplome) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "INSERT INTO Diplome (diplome, id_secteur) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, diplome.getDiplome());
            ps.setInt(2, diplome.getId_secteur());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public Diplome readDiplome(int id_diplome) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Diplome diplome = null;

        try {
            connection = Connex.getConnection();
            String sql = "SELECT * FROM Diplome WHERE id_diplome = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_diplome);

            rs = ps.executeQuery();
            if (rs.next()) {
                diplome = new Diplome();
                diplome.setId_diplome(rs.getInt("id_diplome"));
                diplome.setDiplome(rs.getString("diplome"));
                diplome.setId_secteur(rs.getInt("id_secteur"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }

        return diplome;
    }

    public void updateDiplome(Diplome diplome) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "UPDATE Diplome SET diplome = ?, id_secteur = ? WHERE id_diplome = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, diplome.getDiplome());
            ps.setInt(2, diplome.getId_secteur());
            ps.setInt(3, diplome.getId_diplome());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void deleteDiplome(int id_diplome) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "DELETE FROM Diplome WHERE id_diplome = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_diplome);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }
    //


    //CRUD Enterprise
    public void createEntreprise(Entreprise entreprise) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "INSERT INTO Entreprise (entreprise, point, type, date_creation, adresse, site_web, mail, num_telephone, latitude, longitude, image) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entreprise.getEntreprise());
            ps.setString(2, String.valueOf(entreprise.getPoint()));
            ps.setString(3, entreprise.getType());
            ps.setString(4, entreprise.getDate_creation());
            ps.setString(5, entreprise.getAdresse());
            ps.setString(6, entreprise.getSite_web());
            ps.setString(7, entreprise.getMail());
            ps.setString(8, entreprise.getNum_telephone());
            ps.setString(9, String.valueOf(entreprise.getLatitude()));
            ps.setString(10,String.valueOf(entreprise.getLongitude()));
            ps.setString(11, entreprise.getImage());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void deleteEntreprise(int id_entreprise) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "DELETE FROM Entreprise WHERE id_entreprise = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_entreprise);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void updateEntreprise(Entreprise entreprise) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "UPDATE Entreprise SET entreprise = ?, point = ?, type = ?, date_creation = ?, adresse = ?, " +
                         "site_web = ?, mail = ?, num_telephone = ?, latitude = ?, longitude = ?, image = ? " +
                         "WHERE id_entreprise = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entreprise.getEntreprise());
            ps.setString(2, String.valueOf(entreprise.getPoint()));
            ps.setString(3, entreprise.getType());
            ps.setString(4, entreprise.getDate_creation());
            ps.setString(5, entreprise.getAdresse());
            ps.setString(6, entreprise.getSite_web());
            ps.setString(7, entreprise.getMail());
            ps.setString(8, entreprise.getNum_telephone());
            ps.setString(9, String.valueOf(entreprise.getLatitude()));
            ps.setString(10,String.valueOf(entreprise.getLongitude()));
            ps.setString(11, entreprise.getImage());
            ps.setInt(12, entreprise.getId_entreprise());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public Entreprise readEntreprise(int id_entreprise) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Entreprise entreprise = null;

        try {
            connection = Connex.getConnection();
            String sql = "SELECT * FROM Entreprise WHERE id_entreprise = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_entreprise);

            rs = ps.executeQuery();
            if (rs.next()) {
                entreprise = new Entreprise();
                entreprise.setId_entreprise(rs.getInt("id_entreprise"));
                entreprise.setEntreprise(rs.getString("entreprise"));
                entreprise.setPoint(rs.getLong("point"));
                entreprise.setType(rs.getString("type"));
                entreprise.setDate_creation(rs.getDate("date_creation"));
                entreprise.setAdresse(rs.getString("adresse"));
                entreprise.setSite_web(rs.getString("site_web"));
                entreprise.setMail(rs.getString("mail"));
                entreprise.setNum_telephone(rs.getString("num_telephone"));
                entreprise.setLatitude(rs.getDouble("latitude"));
                entreprise.setLongitude(rs.getDouble("longitude"));
                entreprise.setImage(rs.getString("image"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }

        return entreprise;
    }
    //

    //CRUD Poste 

    public void createPoste(Poste poste) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "INSERT INTO Poste (description, salaire, titre, id_diplome, id_entreprise) " +
                         "VALUES (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, poste.getDescription());
            ps.setDouble(2, poste.getSalaire());
            ps.setString(3, poste.getTitre());
            ps.setInt(4, poste.getId_diplome());
            ps.setInt(5, poste.getId_entreprise());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void deletePoste(int id_post) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "DELETE FROM Poste WHERE id_post = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_post);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void updatePoste(Poste poste) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "UPDATE Poste SET description = ?, salaire = ?, titre = ?, id_diplome = ?, id_entreprise = ? " +
                         "WHERE id_post = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, poste.getDescription());
            ps.setDouble(2, poste.getSalaire());
            ps.setString(3, poste.getTitre());
            ps.setInt(4, poste.getId_diplome());
            ps.setInt(5, poste.getId_entreprise());
            ps.setInt(6, poste.getId_post());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public Poste readPoste(int id_post) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Poste poste = null;

        try {
            connection = Connex.getConnection();
            String sql = "SELECT * FROM Poste WHERE id_post = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_post);

            rs = ps.executeQuery();
            if (rs.next()) {
                poste = new Poste();
                poste.setId_post(rs.getInt("id_post"));
                poste.setDescription(rs.getString("description"));
                poste.setSalaire(rs.getDouble("salaire"));
                poste.setTitre(rs.getString("titre"));
                poste.setId_diplome(rs.getInt("id_diplome"));
                poste.setId_entreprise(rs.getInt("id_entreprise"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }

        return poste;
    }

    //

    //CRUD Competence 

    public void createCompetence(Competence competence) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "INSERT INTO Competence (competence, description, id_utilisateur) " +
                         "VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, competence.getCompetence());
            ps.setString(2, competence.getDescription());
            ps.setInt(3, competence.getId_utilisateur());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void deleteCompetence(int id_competence) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "DELETE FROM Competence WHERE id_competence = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_competence);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public void updateCompetence(Competence competence) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Connex.getConnection();
            String sql = "UPDATE Competence SET competence = ?, description = ?, id_utilisateur = ? " +
                         "WHERE id_competence = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, competence.getCompetence());
            ps.setString(2, competence.getDescription());
            ps.setInt(3, competence.getId_utilisateur());
            ps.setInt(4, competence.getId_competence());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }
    }

    public Competence readCompetence(int id_competence) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Competence competence = null;

        try {
            connection = Connex.getConnection();
            String sql = "SELECT * FROM Competence WHERE id_competence = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_competence);

            rs = ps.executeQuery();
            if (rs.next()) {
                competence = new Competence();
                competence.setId_competence(rs.getInt("id_competence"));
                competence.setCompetence(rs.getString("competence"));
                competence.setDescription(rs.getString("description"));
                competence.setId_utilisateur(rs.getInt("id_utilisateur"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            Connexion.closeConnection(connection);
        }

        return competence;
    }

    //

}