package itu.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name ="notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_notification")
    int idNotification;
    @Column(name = "message")
    String message;
    @Column(name = "date_notification")
    Timestamp dateNotification;
    @Column(name = "date_lu")
    Timestamp dateLu;
    @Column(name = "id_utilisateur")
    int idUtilisateur;
    public Notification(int idNotification, String message, Timestamp dateNotification, Timestamp dateLu,
            int idUtilisateur) {
        this.idNotification = idNotification;
        this.message = message;
        this.dateNotification = dateNotification;
        this.dateLu = dateLu;
        this.idUtilisateur = idUtilisateur;
    }
    public Notification(String message, Timestamp dateNotification, Timestamp dateLu, int idUtilisateur) {
        this.message = message;
        this.dateNotification = dateNotification;
        this.dateLu = dateLu;
        this.idUtilisateur = idUtilisateur;
    }
    public Notification() {
    }
    public int getIdNotification() {
        return idNotification;
    }
    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Timestamp getDateNotification() {
        return dateNotification;
    }
    public void setDateNotification(Timestamp dateNotification) {
        this.dateNotification = dateNotification;
    }
    public Timestamp getDateLu() {
        return dateLu;
    }
    public void setDateLu(Timestamp dateLu) {
        this.dateLu = dateLu;
    }
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
