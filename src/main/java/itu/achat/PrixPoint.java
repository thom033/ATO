package itu.achat;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prix_point")
public class PrixPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prix_point")
    Long id;
    double prix;
    @Column(name="date_changement")
    LocalDate dateChangement;
    public PrixPoint() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public LocalDate getDateChangement() {
        return dateChangement;
    }
    public void setDateChangement(LocalDate dateChangement) {
        this.dateChangement = dateChangement;
    }
}
