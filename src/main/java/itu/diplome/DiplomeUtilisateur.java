package itu.diplome;

import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class DiplomeUtilisateurId implements Serializable {
    private Long utilisateur;
    private Long diplome;

    // Constructors, equals, and hashCode methods

    public DiplomeUtilisateurId() {
    }

    public DiplomeUtilisateurId(Long utilisateur, Long diplome) {
        this.utilisateur = utilisateur;
        this.diplome = diplome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiplomeUtilisateurId that = (DiplomeUtilisateurId) o;
        return Objects.equals(utilisateur, that.utilisateur) && Objects.equals(diplome, that.diplome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, diplome);
    }
}

@Entity
public class DiplomeUtilisateur {
    @EmbeddedId
    private DiplomeUtilisateurId id = new DiplomeUtilisateurId();

    @ManyToOne
    @MapsId("utilisateur")
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("diplome")
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome diplome;

    // Getters et Setters

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }
}

