package itu.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Diplome")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diplome")
    int idDiplome;

    @Column(name = "diplome", nullable = false)
    String diplome;
    
    @Column(name = "id_secteur")
    int idSecteur;

    public Diplome(String diplome, int idSecteur) {
        this.diplome = diplome;
        this.idSecteur = idSecteur;
    }
    public Diplome() {
    }
    public int getIdDiplome() {
        return idDiplome;
    }
    public void setIdDiplome(int idDiplome) {
        this.idDiplome = idDiplome;
    }
    public String getDiplome() {
        return diplome;
    }
    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
    public int getIdSecteur() {
        return idSecteur;
    }
    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }
}
