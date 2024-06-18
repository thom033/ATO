package itu.diplome;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    // @ManyToMany(mappedBy = "diplomes")
    // protected Set<Utilisateur> utilisateurs;

    // public Set<Utilisateur> getUtilisateurs() {
    //     return utilisateurs;
    // }

    // public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
    //     this.utilisateurs = utilisateurs;
    // }
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

