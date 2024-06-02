package itu.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Secteur")
public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secteur")
    private int idSecteur;

    @Column(name = "secteur", nullable = false)
    private String secteur;

    // Getters and Setters

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
}
