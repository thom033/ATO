package itu.entretien;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import itu.compatibilite.PosteDetails;
import itu.poste.Poste;
import itu.utilisateur.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "entretien")
public class Entretien {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_entretien")
    Long id;

    @Column(name = "date_envoi")
    LocalDateTime dateEnvoi;

    @Column(name = "date_entretien")
    LocalDateTime dateEntretien;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    PosteDetails poste;

    boolean reussite;

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public LocalDateTime getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(LocalDateTime dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public PosteDetails getPoste() {
        return poste;
    }

    public void setPoste(PosteDetails poste) {
        this.poste = poste;
    }

    public boolean isReussite() {
        return reussite;
    }

    public void setReussite(boolean reussite) {
        this.reussite = reussite;
    }

    // Constructeur
    public Entretien() {
    }

    // fonctions

}
