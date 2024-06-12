package itu.experience;

import jakarta.persistence.*;
import jakarta.validation.*;
import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experience")
    private Long idExperience;

    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    // Constructors
    public Experience() {
    }

    public Experience(Date dateDebut, Date dateFin, String description, Integer idUtilisateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.idUtilisateur = idUtilisateur;
    }

    // Getters and setters
    public Long getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Long idExperience) {
        this.idExperience = idExperience;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
