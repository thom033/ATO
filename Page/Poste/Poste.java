package itu.poste;

import itu.diplome.Diplome;
import itu.entreprise.Entreprise;

import jakarta.persistence.*;
import jakarta.validation.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "poste")
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Long idPoste;

    @Column(name = "description")
    private String description;

    @Column(name = "date_insertion", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateInsertion;

    @Column(name = "salaire", nullable = false, columnDefinition = "NUMERIC(15,2) DEFAULT 0")
    private BigDecimal salaire;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "annee_experience", columnDefinition = "INTEGER DEFAULT 0")
    private Integer anneeExperience;

    @Column(name = "annee_formation", columnDefinition = "INTEGER DEFAULT 0")
    private Integer anneeFormation;

    @Column(name = "age_min")
    private Integer ageMin;

    @Column(name = "age_max")
    private Integer ageMax;

    @Column(name = "image", length = 250)
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome diplome;

    @ManyToOne
    @JoinColumn(name = "id_entreprise", nullable = false)
    private Entreprise entreprise;

    // Constructors, getters, and setters
    // Constructor
    public Poste() {
    }

    public Poste(String description, Date dateInsertion, BigDecimal salaire, String titre, Integer anneeExperience, Integer anneeFormation, Integer ageMin, Integer ageMax, String image, Diplome diplome, Entreprise entreprise) {
        this.description = description;
        this.dateInsertion = dateInsertion;
        this.salaire = salaire;
        this.titre = titre;
        this.anneeExperience = anneeExperience;
        this.anneeFormation = anneeFormation;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.image = image;
        this.diplome = diplome;
        this.entreprise = entreprise;
    }

    // Getters and setters
    public Long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Long idPoste) {
        this.idPoste = idPoste;
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

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
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
}
