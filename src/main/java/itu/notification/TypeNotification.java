package itu.notification;

import java.util.List;

import itu.poste.Poste;
import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

@Entity
@Table(name = "type_notification")
public class TypeNotification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_notification")
    private Long id_type_notification;

    @OneToMany
    @JoinColumn(name = "id_poste")
    List<Poste> poste;

    @OneToMany
    @JoinColumn(name = "id_notification")
    List<Notification> notification;

    /* --- ---- CONTRUCTEURS------ */
    public TypeNotification(Long id_type_notification, List<Poste> postes) {
        this.id_type_notification = id_type_notification;
        this.poste = postes;
    }

    public TypeNotification() {
    }
    /* --- ---- ------------------ */

    /* ---- SETTERS ---------- */
    public void setId_type_notification(Long id_type_notification) {
        this.id_type_notification = id_type_notification;
    }

    public void setPoste(List<Poste> poste) {
        this.poste = poste;
    }

    /* ---- ------- ---------- */

    /* ---- GETTERS ---------- */
    public Long getId_type_notification() {
        return id_type_notification;
    }

    public List<Poste> getPoste() {
        return poste;
    }

    /* ---- ------- ---------- */
}
