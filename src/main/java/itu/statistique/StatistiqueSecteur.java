package itu.statistique;

import itu.secteur.Secteur;
import itu.secteur.SecteurRepository;
import itu.secteur.SecteurService;
import jakarta.persistence.*;

@Entity
@Table(name = "stat_secteur")
public class StatistiqueSecteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secteur")
    long secteur;
    long total;
    boolean disponibilite;

    public StatistiqueSecteur() {
    }
    public StatistiqueSecteur(int secteur, long total, boolean disponibilite) {
        this.setSecteur(secteur);
        this.setTotal(total);
        this.setDisponibilite(disponibilite);
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setSecteur(long secteur) {
        this.secteur = secteur;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public long getSecteur() {
        return secteur;
    }
    public long getTotal() {
        return total;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }
}
