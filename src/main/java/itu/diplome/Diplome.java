package itu.diplome;

import itu.secteur.Secteur;
import jakarta.persistence.*;

@Entity
@Table(name = "Diplome")
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diplome")
    Long idDiplome;

    @Column(name = "diplome", nullable = false)
    String diplome;

    @Column(name = "niveau", nullable = false)
    Integer niveau;

    @ManyToOne
    @JoinColumn(name = "id_secteur", nullable = false)
    Secteur secteur;

    // Constructeur par défaut
    public Diplome() {
    }

    // Constructeur avec tous les champs
    public Diplome(String diplome, Integer niveau, Secteur secteur) {
        this.diplome = diplome;
        this.niveau = niveau;
        this.secteur = secteur;
    }

    // Getters et setters
    public Long getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Long idDiplome) {
        this.idDiplome = idDiplome;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}

