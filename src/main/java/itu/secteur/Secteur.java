package itu.secteur;

import jakarta.persistence.*;

@Entity
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secteur")
    private Long id;

    private String secteur;

    public Secteur() {
    }

    public Secteur(String secteur) {
        this.secteur = secteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
}

