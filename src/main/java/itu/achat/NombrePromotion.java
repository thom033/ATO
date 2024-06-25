package itu.achat;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nombre_promotion")
public class NombrePromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nombre_promotion")
    Long id;

    @Column(name="nombre_promotion1")    
    int nombrePromotion1;

    double pourcentage1;

    @Column(name="nombre_promotion2")    
    int nombrePromotion2;
    
    double pourcentage2;

    @Column(name = "date_changement")
    LocalDate dateChangement;

    public NombrePromotion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombrePromotion1() {
        return nombrePromotion1;
    }

    public void setNombrePromotion1(int nombrePromotion1) {
        this.nombrePromotion1 = nombrePromotion1;
    }

    public double getPourcentage1() {
        return pourcentage1;
    }

    public void setPourcentage1(double pourcentage1) {
        this.pourcentage1 = pourcentage1;
    }

    public int getNombrePromotion2() {
        return nombrePromotion2;
    }

    public void setNombrePromotion2(int nombrePromotion2) {
        this.nombrePromotion2 = nombrePromotion2;
    }

    public double getPourcentage2() {
        return pourcentage2;
    }

    public void setPourcentage2(double pourcentage2) {
        this.pourcentage2 = pourcentage2;
    }

    public LocalDate getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(LocalDate dateChangement) {
        this.dateChangement = dateChangement;
    }
}