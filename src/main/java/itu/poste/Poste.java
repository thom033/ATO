package itu.poste;

import java.util.Date;

import itu.diplome.Diplome;
import itu.entreprise.Entreprise;
import jakarta.persistence.*;

@Entity
@Table(name = "Poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    Long id;

    String description;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date dateInsertion = new Date();

    @Column(nullable = false)
    double salaire = 0.0;

    @Column(nullable = false)
    String titre;

    Integer anneeExperience = 0;
    Integer anneeFormation = 0;
    Integer ageMin;
    Integer ageMax;
    String image;

    @Column(nullable = false)
    Integer cout;

    @Column(nullable = false)
    Boolean disponibilite;

    @ManyToOne
    @JoinColumn(name = "id_diplome", nullable = false)
    Diplome diplome;

    @ManyToOne
    @JoinColumn(name = "id_entreprise", nullable = false)
    Entreprise entreprise;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(Date dateInsertion) {
        this.dateInsertion = dateInsertion;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(Integer anneeExperience) {
        this.anneeExperience = anneeExperience;
    }

    public Integer getAnneeFormation() {
        return anneeFormation;
    }

    public void setAnneeFormation(Integer anneeFormation) {
        this.anneeFormation = anneeFormation;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCout() {
        return cout;
    }

    public void setCout(Integer cout) {
        this.cout = cout;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    // Getters and Setters
}
