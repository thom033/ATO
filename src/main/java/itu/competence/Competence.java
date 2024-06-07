package itu.competence;

import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

@Entity
@Table(name = "Competence")
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competence")
    private Long idCompetence;

    @Column(name = "competence", nullable = false)
    private String competence;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Constructeur par défaut
    public Competence() {
    }

    // Constructeur avec tous les champs
    public Competence(String competence, String description, Utilisateur utilisateur) {
        this.competence = competence;
        this.description = description;
        this.utilisateur = utilisateur;
    }

    // Getters et setters
    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
