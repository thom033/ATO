package itu.secteur;

import java.io.Serializable;
import java.util.Objects;

import itu.diplome.Diplome;
import jakarta.persistence.*;

@Embeddable
class SecteurDiplomeId implements Serializable {
    private Long secteur;
    private Long diplome;

    // Constructeurs, méthodes equals et hashCode

    public SecteurDiplomeId() {
    }

    public SecteurDiplomeId(Long secteur, Long diplome) {
        this.secteur = secteur;
        this.diplome = diplome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecteurDiplomeId that = (SecteurDiplomeId) o;
        return Objects.equals(secteur, that.secteur) && Objects.equals(diplome, that.diplome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secteur, diplome);
    }
}

@Entity
public class SecteurDiplome {
    @EmbeddedId
    private SecteurDiplomeId id = new SecteurDiplomeId();

    @ManyToOne
    @MapsId("secteur")
    @JoinColumn(name = "id_secteur", nullable = false)
    private Secteur secteur;

    @ManyToOne
    @MapsId("diplome")
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome diplome;

    // Getters et Setters

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

