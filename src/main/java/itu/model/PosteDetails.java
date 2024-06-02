package itu.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name ="postes_details")
public class PosteDetails {

    @Id
    @Column(name = "id_poste")
    private int idPoste;

    @Column(name = "poste_description")
    private String posteDescription;

    @Column(name = "poste_date_insertion")
    private Date posteDateInsertion;

    @Column(name = "poste_salaire")
    private double posteSalaire;

    @Column(name = "poste_titre")
    private String posteTitre;

    @Column(name = "id_diplome")
    private int idDiplome;

    @Column(name = "diplome_nom")
    private String diplomeNom;

    @Column(name = "id_secteur")
    private int idSecteur;

    @Column(name = "secteur_nom")
    private String secteurNom;

    @Column(name = "id_entreprise")
    private int idEntreprise;

    @Column(name = "entreprise_nom")
    private String entrepriseNom;

    @Column(name = "entreprise_point")
    private long entreprisePoint;

    @Column(name = "entreprise_type")
    private String entrepriseType;

    @Column(name = "entreprise_date_creation")
    private Date entrepriseDateCreation;

    @Column(name = "entreprise_adresse")
    private String entrepriseAdresse;

    @Column(name = "entreprise_site_web")
    private String entrepriseSiteWeb;

    @Column(name = "entreprise_mail")
    private String entrepriseMail;

    @Column(name = "entreprise_num_telephone")
    private String entrepriseNumTelephone;

    @Column(name = "entreprise_latitude")
    private float entrepriseLatitude;

    @Column(name = "entreprise_longitude")
    private float entrepriseLongitude;

    @Column(name = "entreprise_image")
    private String entrepriseImage;

    @Column(name = "competence_requise")
    private String competenceRequise;

    // Constructors
    public PosteDetails() {}

    public PosteDetails(int idPoste, String posteDescription, java.sql.Date posteDateInsertion, double posteSalaire, 
                        String posteTitre, int idDiplome, String diplomeNom, int idSecteur, String secteurNom, 
                        int idEntreprise, String entrepriseNom, long entreprisePoint, String entrepriseType, 
                        java.sql.Date entrepriseDateCreation, String entrepriseAdresse, String entrepriseSiteWeb, 
                        String entrepriseMail, String entrepriseNumTelephone, float entrepriseLatitude, 
                        float entrepriseLongitude, String entrepriseImage,String competenceRequise) {
        this.idPoste = idPoste;
        this.posteDescription = posteDescription;
        this.posteDateInsertion = posteDateInsertion;
        this.posteSalaire = posteSalaire;
        this.posteTitre = posteTitre;
        this.idDiplome = idDiplome;
        this.diplomeNom = diplomeNom;
        this.idSecteur = idSecteur;
        this.secteurNom = secteurNom;
        this.idEntreprise = idEntreprise;
        this.entrepriseNom = entrepriseNom;
        this.entreprisePoint = entreprisePoint;
        this.entrepriseType = entrepriseType;
        this.entrepriseDateCreation = entrepriseDateCreation;
        this.entrepriseAdresse = entrepriseAdresse;
        this.entrepriseSiteWeb = entrepriseSiteWeb;
        this.entrepriseMail = entrepriseMail;
        this.entrepriseNumTelephone = entrepriseNumTelephone;
        this.entrepriseLatitude = entrepriseLatitude;
        this.entrepriseLongitude = entrepriseLongitude;
        this.entrepriseImage = entrepriseImage;
        this.competenceRequise = competenceRequise;
    }

    // Getters and Setters
    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public String getPosteDescription() {
        return posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public java.sql.Date getPosteDateInsertion() {
        return posteDateInsertion;
    }

    public void setPosteDateInsertion(java.sql.Date posteDateInsertion) {
        this.posteDateInsertion = posteDateInsertion;
    }

    public double getPosteSalaire() {
        return posteSalaire;
    }

    public void setPosteSalaire(double posteSalaire) {
        this.posteSalaire = posteSalaire;
    }

    public String getPosteTitre() {
        return posteTitre;
    }

    public void setPosteTitre(String posteTitre) {
        this.posteTitre = posteTitre;
    }

    public int getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(int idDiplome) {
        this.idDiplome = idDiplome;
    }

    public String getDiplomeNom() {
        return diplomeNom;
    }

    public void setDiplomeNom(String diplomeNom) {
        this.diplomeNom = diplomeNom;
    }

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getSecteurNom() {
        return secteurNom;
    }

    public void setSecteurNom(String secteurNom) {
        this.secteurNom = secteurNom;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getEntrepriseNom() {
        return entrepriseNom;
    }

    public void setEntrepriseNom(String entrepriseNom) {
        this.entrepriseNom = entrepriseNom;
    }

    public long getEntreprisePoint() {
        return entreprisePoint;
    }

    public void setEntreprisePoint(long entreprisePoint) {
        this.entreprisePoint = entreprisePoint;
    }

    public String getEntrepriseType() {
        return entrepriseType;
    }

    public void setEntrepriseType(String entrepriseType) {
        this.entrepriseType = entrepriseType;
    }

    public java.sql.Date getEntrepriseDateCreation() {
        return entrepriseDateCreation;
    }

    public void setEntrepriseDateCreation(java.sql.Date entrepriseDateCreation) {
        this.entrepriseDateCreation = entrepriseDateCreation;
    }

    public String getEntrepriseAdresse() {
        return entrepriseAdresse;
    }

    public void setEntrepriseAdresse(String entrepriseAdresse) {
        this.entrepriseAdresse = entrepriseAdresse;
    }

    public String getEntrepriseSiteWeb() {
        return entrepriseSiteWeb;
    }

    public void setEntrepriseSiteWeb(String entrepriseSiteWeb) {
        this.entrepriseSiteWeb = entrepriseSiteWeb;
    }

    public String getEntrepriseMail() {
        return entrepriseMail;
    }

    public void setEntrepriseMail(String entrepriseMail) {
        this.entrepriseMail = entrepriseMail;
    }

    public String getEntrepriseNumTelephone() {
        return entrepriseNumTelephone;
    }

    public void setEntrepriseNumTelephone(String entrepriseNumTelephone) {
        this.entrepriseNumTelephone = entrepriseNumTelephone;
    }

    public float getEntrepriseLatitude() {
        return entrepriseLatitude;
    }

    public void setEntrepriseLatitude(float entrepriseLatitude) {
        this.entrepriseLatitude = entrepriseLatitude;
    }

    public float getEntrepriseLongitude() {
        return entrepriseLongitude;
    }

    public void setEntrepriseLongitude(float entrepriseLongitude) {
        this.entrepriseLongitude = entrepriseLongitude;
    }

    public String getEntrepriseImage() {
        return entrepriseImage;
    }

    public void setEntrepriseImage(String entrepriseImage) {
        this.entrepriseImage = entrepriseImage;
    }

    public String getCompetenceRequise() {
        return competenceRequise;
    }

    public void setCompetenceRequise(String competenceRequise) {
        this.competenceRequise = competenceRequise;
    }

    // Function to search for PosteDetails based on a list of column names and values
    public static List<PosteDetails> search(Connection connection, List<String> columns, List<Object> values) throws SQLException {
        List<PosteDetails> results = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM PosteDetails WHERE ");
        
        // Build the SQL query dynamically based on the columns
        for (int i = 0; i < columns.size(); i++) {
            queryBuilder.append(columns.get(i))
                        .append(" = ?");
            
            if (i < columns.size() - 1) {
                queryBuilder.append(" AND ");
            }
        }
        
        String query = queryBuilder.toString();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the values for the prepared statement
            for (int i = 0; i < values.size(); i++) {
                preparedStatement.setObject(i + 1, values.get(i));
            }
            
            // Execute the query and process the results
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    PosteDetails posteDetails = new PosteDetails();
                    posteDetails.setIdPoste(resultSet.getInt("id_poste"));
                    posteDetails.setPosteDescription(resultSet.getString("description"));
                    posteDetails.setPosteDateInsertion(resultSet.getDate("date_insertion"));
                    posteDetails.setPosteSalaire(resultSet.getDouble("salaire"));
                    posteDetails.setPosteTitre(resultSet.getString("titre"));
                    posteDetails.setIdDiplome(resultSet.getInt("id_diplome"));
                    posteDetails.setDiplomeNom(resultSet.getString("diplome"));
                    posteDetails.setIdSecteur(resultSet.getInt("id_secteur"));
                    posteDetails.setSecteurNom(resultSet.getString("secteur"));
                    posteDetails.setIdEntreprise(resultSet.getInt("id_entreprise"));
                    posteDetails.setEntrepriseNom(resultSet.getString("entreprise"));
                    posteDetails.setEntreprisePoint(resultSet.getLong("point"));
                    posteDetails.setEntrepriseType(resultSet.getString("type"));
                    posteDetails.setEntrepriseDateCreation(resultSet.getDate("date_creation"));
                    posteDetails.setEntrepriseAdresse(resultSet.getString("adresse"));
                    posteDetails.setEntrepriseSiteWeb(resultSet.getString("site_web"));
                    posteDetails.setEntrepriseMail(resultSet.getString("mail"));
                    posteDetails.setEntrepriseNumTelephone(resultSet.getString("num_telephone"));
                    posteDetails.setEntrepriseLatitude(resultSet.getFloat("latitude"));
                    posteDetails.setEntrepriseLongitude(resultSet.getFloat("longitude"));
                    posteDetails.setEntrepriseImage(resultSet.getString("image"));
                    posteDetails.setCompetenceRequise(resultSet.getString("competence"));
                    results.add(posteDetails);
                }
            }
        }
        
        return results;
    }
}
