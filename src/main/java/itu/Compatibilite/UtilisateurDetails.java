package itu.Compatibilite;

import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "utilisateur_details")
public class UtilisateurDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    @Column(name = "date_naissance")
    private Date dateNaissance;
    private String adresse;
    private String mail;
    @Column(name = "etat_civil")
    private String etatCivil;
    private String photo;
    private int point;
    private double latitude;
    private double longitude;
    private String motdepasse;

    @Column(name = "id_experience")
    private Long idExperience;
    @Column(name = "experience_date_debut")
    private Date experienceDateDebut;
    @Column(name = "experience_date_fin")
    private Date experienceDateFin;
    @Column(name = "experience_description")
    private String experienceDescription;

    @Column(name = "id_formation")
    private Long idFormation;
    @Column(name = "formation_date_debut")
    private Date formationDateDebut;
    @Column(name = "formation_date_fin")
    private Date formationDateFin;
    @Column(name = "formation_description")
    private String formationDescription;

    @Column(name = "id_competence")
    private Long idCompetence;

    @Column(name = "id_diplome")
    private Long idDiplome;

    public UtilisateurDetails(){

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,1994);
        cal.set(Calendar.MONTH,7);
        cal.set(Calendar.DAY_OF_MONTH,3);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR,2005);
        cal2.set(Calendar.MONTH,7);
        cal2.set(Calendar.DAY_OF_MONTH,3);

        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.YEAR,2005);
        cal3.set(Calendar.MONTH,7);
        cal3.set(Calendar.DAY_OF_MONTH,3);

        Calendar cal4 = Calendar.getInstance();
        cal4.set(Calendar.YEAR,2005);
        cal4.set(Calendar.MONTH,7);
        cal4.set(Calendar.DAY_OF_MONTH,3);

        Calendar cal5 = Calendar.getInstance();
        cal5.set(Calendar.YEAR,2005);
        cal5.set(Calendar.MONTH,7);
        cal5.set(Calendar.DAY_OF_MONTH,3);

        this.dateNaissance = cal.getTime();
        this.experienceDateDebut = cal2.getTime();
        this.experienceDateFin = cal3.getTime();
        this.formationDateDebut = cal4.getTime();
        this.formationDateFin = cal5.getTime();
        this.idDiplome = (long) 1;
        this.idExperience =(long) 1;
        this.idFormation = (long) 1;
        this.idUtilisateur =(long) 1;
        this.latitude = 11;
        this.longitude = 12;
    }
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

    public double[] ListCompatibility(List<PosteDetails> p){
        UtilisateurDetails u = new UtilisateurDetails();
        double[] compatibility = new double[p.size()];
        for (int i = 0; i < p.size(); i++) {
            
            // compatibility[i] = p.get(i).getCompatibilityPourcentage(u);
            compatibility[i] = p.get(i).getPointTotal(u);
        }
        return compatibility;
    }
}
