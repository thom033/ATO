package itu.secteur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "secteur") // Maps the class to the 'secteur' table
public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs using database's identity strategy
    @Column(name = "id_secteur") // Maps to the 'id_secteur' column
    private Long idSecteur;

    @NotNull // Ensures that the 'secteur' field is not null
    @Size(max = 255) // Limits the size of 'secteur' to 255 characters
    @Column(name = "secteur", nullable = false) // Maps to the 'secteur' column and cannot be null
    private String secteur;

    // Default constructor
    public Secteur() {
    }

    // Constructor with fields (excluding id since it's auto-generated)
    public Secteur(String secteur) {
        this.secteur = secteur;
    }

    // Getter and setter methods
    public Long getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Long idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
}
