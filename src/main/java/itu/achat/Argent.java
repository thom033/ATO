package itu.achat;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "argent")
public class Argent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_argent")
    int id;

    @Column(name = "solde", nullable = false, columnDefinition = "NUMERIC(15,2) DEFAULT 0.0")
    Double solde = 0.0;
    
    @Column(name = "id_utilisateur")
    Long idUtilisateur;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modification", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date dateModification = new Date();

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Date getDate() {
        return dateModification;
    }

    public void setDate(Date date) {
        this.dateModification = date;
    }
}
