package itu.Compatibilite;

import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import jakarta.persistence.*;

@Entity

public class UtilisateurDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String mail;
    private String etatCivil;
    private String photo;
    private int point;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String motdepasse;

    private Long idExperience;
    private Date experienceDateDebut;
    private Date experienceDateFin;
    private String experienceDescription;

    private Long idFormation;
    private Date formationDateDebut;
    private Date formationDateFin;
    private String formationDescription;

    private Long idCompetence;

    private Long idDiplome;

    // Getters and setters

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

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    // public double getLatitude() {
    //     return latitude;
    // }

    // public void setLatitude(double latitude) {
    //     this.latitude = latitude;
    // }

    // public double getLongitude() {
    //     return longitude;
    // }

    // public void setLongitude(double longitude) {
    //     this.longitude = longitude;
    // }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Long getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Long idExperience) {
        this.idExperience = idExperience;
    }

    public Date getExperienceDateDebut() {
        return experienceDateDebut;
    }

    public void setExperienceDateDebut(Date experienceDateDebut) {
        this.experienceDateDebut = experienceDateDebut;
    }

    public Date getExperienceDateFin() {
        return experienceDateFin;
    }

    public void setExperienceDateFin(Date experienceDateFin) {
        this.experienceDateFin = experienceDateFin;
    }

    public String getExperienceDescription() {
        return experienceDescription;
    }

    public void setExperienceDescription(String experienceDescription) {
        this.experienceDescription = experienceDescription;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public Date getFormationDateDebut() {
        return formationDateDebut;
    }

    public void setFormationDateDebut(Date formationDateDebut) {
        this.formationDateDebut = formationDateDebut;
    }

    public Date getFormationDateFin() {
        return formationDateFin;
    }

    public void setFormationDateFin(Date formationDateFin) {
        this.formationDateFin = formationDateFin;
    }

    public String getFormationDescription() {
        return formationDescription;
    }

    public void setFormationDescription(String formationDescription) {
        this.formationDescription = formationDescription;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public Long getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Long idDiplome) {
        this.idDiplome = idDiplome;
    }

    public int calculateAge() {
        if (this.getDateNaissance() == null) {
            return 0;
        }
        LocalDate birthDate = this.getDateNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int calculateExperienceYears() {
        if (this.getExperienceDateDebut() == null || this.getExperienceDateFin() == null) {
            return 0;
        }
        LocalDate startDate = this.getExperienceDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = this.getExperienceDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(startDate, endDate).getYears();
    }

    public int calculateFormationYears() {
        if (this.getFormationDateDebut() == null || this.getFormationDateFin() == null) {
            return 0;
        }
        LocalDate startDate = formationDateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = formationDateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(startDate, endDate).getYears();
    }
}
