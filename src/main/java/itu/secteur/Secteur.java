package itu.secteur;

import jakarta.persistence.*;

@Entity
@Table(name = "Secteur")
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secteur")
    private Long idSecteur;

    @Column(name = "secteur", nullable = false)
    private String nomSecteur;

    public Secteur() {
    }

    public Secteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public Long getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Long idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }
}

