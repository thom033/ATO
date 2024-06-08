package itu.achat;

import jakarta.persistence.*;

@Entity
@Table(name = "argent")
public class Argent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_argent")
    int id;

    @Column(name = "solde")
    Double solde;

    @Column(name = "id_utilisateur")
    Long idUtilisateur;

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
}
