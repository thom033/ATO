package itu.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Competence")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competence")
    private int idCompetence;

    @Column(name = "competence")
    private String competence;

    @Column(name = "description")
    private String description;

    @Column(name = "id_secteur")
    int idSecteur;

    public Competence() {
    }
    public Competence(String competence, String description, int idSecteur) {
        this.competence = competence;
        this.description = description;
        this.idSecteur = idSecteur;
    }
    public int getIdCompetence() {
        return idCompetence;
    }
    public void setIdCompetence(int idCompetence) {
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
    public int getIdSecteur() {
        return idSecteur;
    }
    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }
}
