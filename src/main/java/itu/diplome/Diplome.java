package itu.diplome;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import itu.secteur.Secteur;
import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

@Entity
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diplome")
    private Long id;

    @Column(name = "diplome")
    private String diplome;

    @Column(name = "niveau")
    private Integer niveau;

    @ManyToMany
    @JoinTable(
        name = "secteur_diplome",
        joinColumns = @JoinColumn(name = "id_diplome"),
        inverseJoinColumns = @JoinColumn(name = "id_secteur")
    )
    private Set<Secteur> secteur;

    public Set<Secteur> getSecteur() {
        return secteur;
    }
    public void setSecteur(Set<Secteur> secteur) {
        this.secteur = secteur;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDiplome() {
        return diplome;
    }
    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
    public Integer getNiveau() {
        return niveau;
    }
    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

}

