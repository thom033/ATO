package itu.notification;

import itu.poste.Poste;
import itu.user.Utilisateur;
import jakarta.persistence.*;

@Entity
@Table(name = "typeNotification")
public class TypeNotification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_notification")
    private Long id_type_notification;
    @ManyToOne
    @JoinColumn(name = "id_poste")
    Poste poste;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;


    /* --- ---- CONTRUCTEURS------ */
        public TypeNotification(Long id_type_notification, Poste poste, Utilisateur utilisateur) {
            this.id_type_notification = id_type_notification;
            this.poste = poste;
            this.utilisateur = utilisateur;
        }

        public TypeNotification() {
        }
    /* --- ---- ------------------ */


    /* ---- SETTERS ---------- */
        public void setId_type_notification(Long id_type_notification) {
            this.id_type_notification = id_type_notification;
        }
        public void setPoste(Poste poste) {
            this.poste = poste;
        }
        public void setUtilisateur(Utilisateur utilisateur) {
            this.utilisateur = utilisateur;
        }
    /* ---- ------- ---------- */


    /* ---- GETTERS ---------- */
        public Long getId_type_notification() {
            return id_type_notification;
        }
        public Poste getPoste() {
            return poste;
        }
        public Utilisateur getUtilisateur() {
            return utilisateur;
        }
    /* ---- ------- ---------- */
}
