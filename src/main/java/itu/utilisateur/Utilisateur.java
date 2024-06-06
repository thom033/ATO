package itu.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.regex.Pattern;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_utilisateur")
    private Long idUser;
    String nom;
    String prenom;
    Date dateNaissance;
    String adresse;
    String mail;
    // List<String> numeroTelephone;
    String etat_civil;
    String photo;
    int point;
    float longitude;
    float latitude;
    String motdepasse;

    // ---- ---- CONSTRUCTEURS ------- ------

    public Utilisateur() {

    }

    public Utilisateur(Long idUser, String nom, String prenom, Date dateNaissance, String adresse, String mail,
            String etat_civil, String photo, int point, float longitude,
            float latitude, String motdepasse) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.mail = mail;
        // this.numeroTelephone = numeroTelephone;
        this.etat_civil = etat_civil;
        this.photo = photo;
        this.point = point;
        this.longitude = longitude;
        this.latitude = latitude;
        this.motdepasse = motdepasse;
    }

    // ------- setters -------------
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) throws Exception {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // public void setNumeroTelephone(String numeroTelephone) {
    // this.numeroTelephone = numeroTelephone;
    // }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
    /* ---- ------ FIN CONSTRUCTOR --------- - */

    // ------ gettters ------- ---------
    public Long getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    // public String getNumeroTelephone() {
    // return numeroTelephone;
    // }

    public String getEtat_civil() {
        return etat_civil;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPoint() {
        return point;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getMotdepasse() {
        return motdepasse;
    }
}
