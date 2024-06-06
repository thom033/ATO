package itu.notification;

import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "Notification")
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notification")
    private Long idNotification;

    String message;

    @Column(name = "date_notification")
    LocalDateTime dateNotification;

    @Column(name = "date_lu")
    LocalDateTime dateLu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_type_notification")
    TypeNotification type;

    // ---- ---- CONSTRUCTEURS ------- ------
    public Notification() {
    }

    public Notification(Long idNotification, String message, LocalDateTime dateNotification, LocalDateTime dateLu,
            Utilisateur utilisateur, TypeNotification type) {
        this.idNotification = idNotification;
        this.message = message;
        this.dateNotification = dateNotification;
        this.dateLu = dateLu;
        this.utilisateur = utilisateur;
        this.type = type;
    }
    // ------- ---------- --------- ------

    /* ----- ----- SETTERS --------- */
    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateNotification(LocalDateTime dateNotification) {
        this.dateNotification = dateNotification;
    }

    public void setDateLu(LocalDateTime dateLu) {
        this.dateLu = dateLu;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setType(TypeNotification type) {
        this.type = type;
    }
    /* ----- ----- ------- --------- */

    /* ----- ----- GETTERS --------- */
    public TypeNotification getType() {
        return type;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateNotification() {
        return dateNotification;
    }

    public LocalDateTime getDateLu() {
        return dateLu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    /* ----- ----- ------- --------- */

    /* ---- calcule le temps écoulé d'une notification --- */
    public String tempsEcoule() {
        // Obtient la date et l'heure actuelles
        LocalDateTime cur_date = LocalDateTime.now();

        // Calcule la durée écoulée
        Duration duration = Duration.between(this.dateNotification, cur_date);

        // Convertit la durée en secondes
        long seconds = duration.getSeconds();
        // Détermine le nombre de minutes, d'heures, de jours, etc., en fonction de la
        // durée
        int minutes = (int) TimeUnit.SECONDS.toMinutes(seconds);
        int hours = (int) TimeUnit.MINUTES.toHours(minutes);
        int days = (int) TimeUnit.HOURS.toDays(hours);

        // Gère les cas spéciaux pour les messages
        String message = " il y a ";
        if (days > 0) {
            message += days + " jours";
        } else if (hours > 0) {
            message += hours + " heures";
        } else if (minutes > 0) {
            message += minutes + " minutes";
        } else {
            message = "juste maintenant";
        }

        // Affiche le message
        return message;
    }
    /* ---- ------------------------------------------ --- */

    public static void main(String[] args) {
        Notification n = new Notification();
        n.setDateNotification(LocalDateTime.now());
        System.out.println(n.tempsEcoule());
    }
}
