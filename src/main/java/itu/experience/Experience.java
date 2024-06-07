package itu.experience;

import jakarta.persistence.*;
import java.util.Date;

import itu.utilisateur.Utilisateur;

@Entity
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_experience;
    
    @Column(nullable = false)
    Date date_debut;
    
    Date date_fin;
    
    @Column(nullable = false)
    String description;
    
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    Utilisateur utilisateur;

    public Long getId_experience() {
        return id_experience;
    }

    public void setId_experience(Long id_experience) {
        this.id_experience = id_experience;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
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
