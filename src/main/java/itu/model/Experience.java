package itu.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name ="experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_experience")
    int idExperience;
    @Column(name = "date_debut")
    LocalDate dateDebut;
    @Column(name = "date_fin")
    LocalDate dateFin;
    @Column(name = "description")
    String descprition;
    @Column(name = "id_secteur")
    int idSecteur;
    public int getIdSecteur() {
        return idSecteur;
    }
    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }
    @Column(name = "id_utilisateur")
    int idUtilisateur;
    public Experience(LocalDate dateDebut, LocalDate dateFin, String descprition, int idSecteur, int idUtilisateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.descprition = descprition;
        this.idSecteur = idSecteur;
        this.idUtilisateur = idUtilisateur;
    }
    public Experience(LocalDate dateDebut, LocalDate dateFin, String descprition, int idUtilisateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.descprition = descprition;
        this.idUtilisateur = idUtilisateur;
    }
    public Experience(int idExperience, LocalDate dateDebut, LocalDate dateFin, String descprition, int idUtilisateur) {
        this.idExperience = idExperience;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.descprition = descprition;
        this.idUtilisateur = idUtilisateur;
    }
    public Experience() {
    }
    public int getIdExperience() {
        return idExperience;
    }
    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public String getDescprition() {
        return descprition;
    }
    public void setDescprition(String descprition) {
        this.descprition = descprition;
    }
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
