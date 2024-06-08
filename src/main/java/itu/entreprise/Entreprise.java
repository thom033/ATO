package itu.entreprise;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entreprise")
    private Long idEntreprise;
    String entreprise;
    String mail;
    int point;
    String type;
    @Column(name = "date_creation")
    Timestamp dateCreation;
    String adresse;
    @Column(name="site_web")
    String siteWeb;
    double latitude;
    double longitude;
    String image;
    public Entreprise(Long idEntreprise, String entreprise, String mail, int point, String type, Timestamp dateCreation,
            String adresse, String siteWeb, double latitude, double longitude, String image) {
        this.idEntreprise = idEntreprise;
        this.entreprise = entreprise;
        this.mail = mail;
        this.point = point;
        this.type = type;
        this.dateCreation = dateCreation;
        this.adresse = adresse;
        this.siteWeb = siteWeb;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }
    public Entreprise() {
    }
    public Entreprise(String entreprise, int point, String type, Timestamp dateCreation, String adresse, String siteWeb,
            double latitude, double longitude, String image) {
        this.entreprise = entreprise;
        this.point = point;
        this.type = type;
        this.dateCreation = dateCreation;
        this.adresse = adresse;
        this.siteWeb = siteWeb;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }
    public Entreprise(Long idEntreprise, String entreprise, int point, String type, Timestamp dateCreation,
            String adresse, String siteWeb, double latitude, double longitude, String image) {
        this.idEntreprise = idEntreprise;
        this.entreprise = entreprise;
        this.point = point;
        this.type = type;
        this.dateCreation = dateCreation;
        this.adresse = adresse;
        this.siteWeb = siteWeb;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }
    public Long getIdEntreprise() {
        return idEntreprise;
    }
    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
    public String getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Timestamp getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getSiteWeb() {
        return siteWeb;
    }
    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
