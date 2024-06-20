package itu.statistique;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "point_vendu")
public class PointVendu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id_vente;
    int quantite;
    Date date_vente;

    public PointVendu(long id_vente, int quantite, Date date_vente) {
        this.id_vente = id_vente;
        this.quantite = quantite;
        this.date_vente = date_vente;
    }

    public PointVendu() {
    }

    public long getId_vente() {
        return id_vente;
    }

    public int getQuantite() {
        return quantite;
    }

    public Date getDate_vente() {
        return date_vente;
    }

    public void setId_vente(long id_vente) {
        this.id_vente = id_vente;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }
}
