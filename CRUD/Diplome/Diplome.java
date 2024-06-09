package itu.diplome;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "diplome")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diplome")
    private Long idDiplome;

    @NotNull
    @Size(max = 255)
    @Column(name = "diplome")
    private String diplome;

    @NotNull
    @Column(name = "niveau")
    private int niveau;

    // Default constructor
    public Diplome() {
    }

    // Constructor with all fields
    public Diplome(String diplome, int niveau) {
        this.diplome = diplome;
        this.niveau = niveau;
    }

    // Getter and setter methods
    public Long getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Long idDiplome) {
        this.idDiplome = idDiplome;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
