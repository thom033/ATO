package itu.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name ="formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_formation")
    int idFormation;
    @Column(name = "date_debut")
    LocalDate dateDebut;
    @Column(name = "date_fin")
    LocalDate dateFin;
    @Column(name = "description")
    String description;
    @Column(name = "id_utilisateur")
    int idUtilisateur;
    @Column(name = "id_secteur")
    int idSecteur;
    public Formation(LocalDate dateDebut, LocalDate dateFin, String description, int idUtilisateur, int idSecteur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.idUtilisateur = idUtilisateur;
        this.idSecteur = idSecteur;
    }
    public Formation(int idFormation, LocalDate dateDebut, LocalDate dateFin, String description, int idUtilisateur,
            int idSecteur) {
        this.idFormation = idFormation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.idUtilisateur = idUtilisateur;
        this.idSecteur = idSecteur;
    }
    public Formation() {
    }
    public int getIdFormation() {
        return idFormation;
    }
    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    public int getIdSecteur() {
        return idSecteur;
    }
    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }
}
