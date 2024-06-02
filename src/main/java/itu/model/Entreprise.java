package itu.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name ="entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_entreprise")
    private int idEntreprise;

    @Column(name = "entreprise")
    private String entreprise;

    @Column(name = "point")
    private int point;

    @Column(name = "type")
    private String type;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "adresse")
    private String addresse;

    @Column(name = "site_web")
    private String siteWeb;

    @Column(name = "mail")
    private String mail;

    @Column(name = "num_telephone")
    private String numTelephone;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "image")
    private String image;
    
    public Entreprise(String entreprise, int point, String type, LocalDate dateCreation, String addresse,
            String siteWeb, String mail, String numTelephone, double latitude, double longitude, String image) {
        this.entreprise = entreprise;
        this.point = point;
        this.type = type;
        this.dateCreation = dateCreation;
        this.addresse = addresse;
        this.siteWeb = siteWeb;
        this.mail = mail;
        this.numTelephone = numTelephone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }
    public Entreprise() {
    }
    public int getIdEntreprise() {
        return idEntreprise;
    }
    public void setIdEntreprise(int idEntreprise) {
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
    public LocalDate getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
    public String getAddresse() {
        return addresse;
    }
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    public String getSiteWeb() {
        return siteWeb;
    }
    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getNumTelephone() {
        return numTelephone;
    }
    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
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
}
