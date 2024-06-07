package itu.secteur;

import itu.diplome.Diplome;
import jakarta.persistence.*;

@Entity
@Table(name = "secteur_diplome")
public class SecteurDiplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_secteur", nullable = false)
    private Secteur secteur;

    @ManyToOne
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome diplome;

    // Constructeur par défaut
    public SecteurDiplome() {
    }

    // Constructeur avec tous les champs
    public SecteurDiplome(Secteur secteur, Diplome diplome) {
        this.secteur = secteur;
        this.diplome = diplome;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }
}
