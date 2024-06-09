package itu.utilisateur;

import java.sql.Date; // Use java.sql.Date for SQL DATE type

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "utilisateur") // Maps the class to the 'utilisateur' table
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur") // Maps to the 'id_utilisateur' column
    private Long idUtilisateur;

    @NotNull
    @Size(max = 255)
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Size(max = 255)
    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Past // Ensures the date is in the past
    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Size(max = 255)
    @Column(name = "adresse", nullable = true) // This column can be null
    private String adresse;

    @NotNull
    @Size(max = 255)
    @Email
    @Column(name = "mail", nullable = false, unique = true) // Enforces uniqueness on the 'mail' column
    private String mail;

    @Size(max = 15)
    @Column(name = "numero_telephone", nullable = true) // This column can be null
    private String numeroTelephone;

    @Size(max = 255)
    @Column(name = "etat_civil", nullable = true) // This column can be null
    private String etatCivil;

    @Size(max = 255)
    @Column(name = "profession", nullable = true) // This column can be null
    private String profession;

    @Size(max = 255)
    @Column(name = "photo", nullable = true) // This column can be null
    private String photo;

    @NotNull
    @Column(name = "point", nullable = false, columnDefinition = "BIGINT default 0 CHECK(point >= 0)")
    private Long point;

    @Column(name = "latitude", precision = 15, scale = 2, nullable = true) // This column can be null
    private Double latitude;

    @Column(name = "longitude", precision = 15, scale = 2, nullable = true) // This column can be null
    private Double longitude;

    @NotNull
    @Size(max = 255)
    @Column(name = "motdepasse", nullable = false)
    private String motDePasse;

    @Column(name = "description", columnDefinition = "TEXT", nullable = true) // This column can be null
    private String description;

    @Column(name = "salaire_recherche", precision = 15, scale = 2, nullable = true, columnDefinition = "NUMERIC(15,2) DEFAULT 0")
    private Double salaireRecherche;

    // Default constructor
    public Utilisateur() {
    }

    // Constructor with all fields excluding id (auto-generated)
    public Utilisateur(String nom, String prenom, Date dateNaissance, String adresse, String mail,
                       String numeroTelephone, String etatCivil, String profession, String photo,
                       Long point, Double latitude, Double longitude, String motDePasse, String description,
                       Double salaireRecherche) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.mail = mail;
        this.numeroTelephone = numeroTelephone;
        this.etatCivil = etatCivil;
        this.profession = profession;
        this.photo = photo;
        this.point = point;
        this.latitude = latitude;
        this.longitude = longitude;
        this.motDePasse = motDePasse;
        this.description = description;
        this.salaireRecherche = salaireRecherche;
    }

    // Getter and setter methods
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalaireRecherche() {
        return salaireRecherche;
    }

    public void setSalaireRecherche(Double salaireRecherche) {
        this.salaireRecherche = salaireRecherche;
    }
}
