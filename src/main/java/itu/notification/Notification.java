package itu.notification;

import itu.entretien.Entretien;
import itu.poste.Poste;
import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "Notification")
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notification")
    private Long id;

    String message;

    @Column(name = "date_notification")
    LocalDateTime dateNotification;

    @Column(name = "date_lu")
    LocalDateTime dateLu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    Poste poste;

    @ManyToOne
    @JoinColumn(name = "id_entretien")
    Entretien entretien;

    Boolean point;

    // ---- ---- CONSTRUCTEURS ------- ------
    public Notification() {
    }

    public Notification(Long idNotification, String message, LocalDateTime dateNotification, LocalDateTime dateLu,
            Utilisateur utilisateur, Poste poste, Boolean point, Entretien entretien) {
        this.id = idNotification;
        this.message = message;
        this.dateNotification = dateNotification;
        this.dateLu = dateLu;
        this.utilisateur = utilisateur;
        this.poste = poste;
        this.point = point;
        this.entretien = entretien;
    }
    // ------- ---------- --------- ------

    /* ----- ----- SETTERS --------- */
    public void setId(Long idNotification) {
        this.id = idNotification;
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

    public void setPoint(Boolean point) {
        this.point = point;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    /* ----- ----- ------- --------- */

    /* ----- ----- GETTERS --------- */
    public Boolean getPoint() {
        return point;
    }

    public Poste getPoste() {
        return poste;
    }

    public Long getId() {
        return id;
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

    public String stringDateNotif() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = getDateNotification().format(formatter);

        return formattedDate;
    }

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

    public int estDynamique() {
        if (getPoste() != null) {
            // return getPoste().getId();
            return 0;
        } else if (getPoint()) {
            return -1;
        }
        return -2;
    }

    /* ---- ------------------------------------------ --- */

    public static void main(String[] args) {
        Notification n = new Notification();
        n.setDateNotification(LocalDateTime.now());
        System.out.println(n.tempsEcoule());
    }

}
