package itu.poste;

import java.time.LocalDate;

import itu.diplome.Diplome;
import itu.entreprise.Entreprise;
import jakarta.persistence.*;

@Entity
@Table(name = "Poste")
public class Poste {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_poste")
    long id;

    String description;

    @Column(name = "date_insertion")
    LocalDate dateInsertion;

    double salaire;

    String titre;

    @Column(name="annee_experience")
    int anneeExperience;

    @Column(name="annee_formation")
    int anneeFormation;

    @Column(name="age_min")
    int ageMin;

    @Column(name="age_max")
    int ageMax;

    @Column(name="image")
    String image;

    int cout;

    boolean disponibilite;

    @OneToOne
    @JoinColumn(name = "id_diplome")
    Diplome diplome;

    @OneToOne
    @JoinColumn(name = "id_entreprise")
    Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Poste() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(LocalDate dateInsertion) {
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

    public int getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(int anneeExperince) {
        this.anneeExperience = anneeExperince;
    }

    public int getAnneeFormation() {
        return anneeFormation;
    }

    public void setAnneeFormation(int anneeFormation) {
        this.anneeFormation = anneeFormation;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }
}
