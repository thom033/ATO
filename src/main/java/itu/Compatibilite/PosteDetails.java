package itu.Compatibilite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.regex.Pattern;

import jakarta.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PosteDetails {
    @Id
    private Long idPoste;
    private String posteDescription;
    private String posteDateInsertion;
    private double posteSalaire;
    private String posteTitre;
    private Long posteDiplome;
    private Long posteEntreprise;
    private int nbrAnneeExperience;
    private int nbrAnneeFormation;
    private int posteAgeMin;
    private int posteAgeMax;
    private Long idDiplome;
    private String diplomeNom;
    private String diplomeNiveau;
    private String entrepriseNom;
    private int entreprisePoint;
    private String entrepriseType;
    private String entrepriseDateCreation;
    private String entrepriseAdresse;
    private String entrepriseSiteWeb;
    private String entrepriseMail;
    private double entrepriseLatitude;
    private double entrepriseLongitude;
    private String entrepriseImage;

    // Getters and setters
    public Long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Long idPoste) {
        this.idPoste = idPoste;
    }

    public String getPosteDescription() {
        return posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public String getPosteDateInsertion() {
        return posteDateInsertion;
    }

    public void setPosteDateInsertion(String posteDateInsertion) {
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

    public Long getPosteDiplome() {
        return posteDiplome;
    }

    public void setPosteDiplome(Long posteDiplome) {
        this.posteDiplome = posteDiplome;
    }

    public Long getPosteEntreprise() {
        return posteEntreprise;
    }

    public void setPosteEntreprise(Long posteEntreprise) {
        this.posteEntreprise = posteEntreprise;
    }

    public int getNbrAnneeExperience() {
        return nbrAnneeExperience;
    }

    public void setNbrAnneeExperience(int nbrAnneeExperience) {
        this.nbrAnneeExperience = nbrAnneeExperience;
    }

    public int getNbrAnneeFormation() {
        return nbrAnneeFormation;
    }

    public void setNbrAnneeFormation(int nbrAnneeFormation) {
        this.nbrAnneeFormation = nbrAnneeFormation;
    }

    public int getPosteAgeMin() {
        return posteAgeMin;
    }

    public void setPosteAgeMin(int posteAgeMin) {
        this.posteAgeMin = posteAgeMin;
    }

    public int getPosteAgeMax() {
        return posteAgeMax;
    }

    public void setPosteAgeMax(int posteAgeMax) {
        this.posteAgeMax = posteAgeMax;
    }

    public Long getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Long idDiplome) {
        this.idDiplome = idDiplome;
    }

    public String getDiplomeNom() {
        return diplomeNom;
    }

    public void setDiplomeNom(String diplomeNom) {
        this.diplomeNom = diplomeNom;
    }

    public String getDiplomeNiveau() {
        return diplomeNiveau;
    }

    public void setDiplomeNiveau(String diplomeNiveau) {
        this.diplomeNiveau = diplomeNiveau;
    }

    public String getEntrepriseNom() {
        return entrepriseNom;
    }

    public void setEntrepriseNom(String entrepriseNom) {
        this.entrepriseNom = entrepriseNom;
    }

    public int getEntreprisePoint() {
        return entreprisePoint;
    }

    public void setEntreprisePoint(int entreprisePoint) {
        this.entreprisePoint = entreprisePoint;
    }

    public String getEntrepriseType() {
        return entrepriseType;
    }

    public void setEntrepriseType(String entrepriseType) {
        this.entrepriseType = entrepriseType;
    }

    public String getEntrepriseDateCreation() {
        return entrepriseDateCreation;
    }

    public void setEntrepriseDateCreation(String entrepriseDateCreation) {
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

    public double getEntrepriseLatitude() {
        return entrepriseLatitude;
    }

    public void setEntrepriseLatitude(double entrepriseLatitude) {
        this.entrepriseLatitude = entrepriseLatitude;
    }

    public double getEntrepriseLongitude() {
        return entrepriseLongitude;
    }

    public void setEntrepriseLongitude(double entrepriseLongitude) {
        this.entrepriseLongitude = entrepriseLongitude;
    }

    public String getEntrepriseImage() {
        return entrepriseImage;
    }

    public void setEntrepriseImage(String entrepriseImage) {
        this.entrepriseImage = entrepriseImage;
    }

}
