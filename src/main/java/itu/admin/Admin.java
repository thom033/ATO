package itu.admin;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="administrateur")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_administrateur")
    private Long idAdmin;
    String mail;
    @Column(name="mot_de_passe")
    String motDePasse;
    public Admin(Long idAdmin, String mail, String motDePasse) {
        this.idAdmin = idAdmin;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }
    public Admin() {
    }
    public Admin(String mail, String motDePasse) {
        this.mail = mail;
        this.motDePasse = motDePasse;
    }
    public Long getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
