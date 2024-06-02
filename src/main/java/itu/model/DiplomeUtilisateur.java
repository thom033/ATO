package itu.model;

import jakarta.persistence.*;

@Entity
@Table(name ="diplome_utilisateur")
public class DiplomeUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_diplome_utilisateur")
    int idDiplomeUtilisateur;
    @Column(name = "id_utilisateur")
    int idUtilisateur;
    @Column(name = "id_diplome")
    int idDiplome;
    public DiplomeUtilisateur(int idDiplomeUtilisateur, int idUtilisateur, int idDiplome) {
        this.idDiplomeUtilisateur = idDiplomeUtilisateur;
        this.idUtilisateur = idUtilisateur;
        this.idDiplome = idDiplome;
    }
    public DiplomeUtilisateur(int idUtilisateur, int idDiplome) {
        this.idUtilisateur = idUtilisateur;
        this.idDiplome = idDiplome;
    }
    public DiplomeUtilisateur() {
    }
    public int getIdDiplomeUtilisateur() {
        return idDiplomeUtilisateur;
    }
    public void setIdDiplomeUtilisateur(int idDiplomeUtilisateur) {
        this.idDiplomeUtilisateur = idDiplomeUtilisateur;
    }
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    public int getIdDiplome() {
        return idDiplome;
    }
    public void setIdDiplome(int idDiplome) {
        this.idDiplome = idDiplome;
    }
}
