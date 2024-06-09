package itu.competence;

import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class CompetenceUtilisateurId implements Serializable {
    private Long utilisateur;
    private Long competence;

    // Constructors, equals, and hashCode methods

    public CompetenceUtilisateurId() {
    }

    public CompetenceUtilisateurId(Long utilisateur, Long competence) {
        this.utilisateur = utilisateur;
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetenceUtilisateurId that = (CompetenceUtilisateurId) o;
        return Objects.equals(utilisateur, that.utilisateur) && Objects.equals(competence, that.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, competence);
    }
}

@Entity
public class CompetenceUtilisateur {
    @EmbeddedId
    private CompetenceUtilisateurId id = new CompetenceUtilisateurId();

    @ManyToOne
    @MapsId("utilisateur")
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("competence")
    @JoinColumn(name = "id_competence", nullable = false)
    private Competence competence;

    // Getters et Setters

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}
