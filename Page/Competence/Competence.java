package itu.competence;

import jakarta.persistence.*;
import jakarta.validation.*;

@Entity
@Table(name = "competence")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competence")
    private Long idCompetence;

    @Column(name = "competence", nullable = false)
    private String competence;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Constructors, getters, and setters
    // Constructor
    public Competence() {
    }

    public Competence(String competence, String description) {
        this.competence = competence;
        this.description = description;
    }

    // Getters and setters
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
}
