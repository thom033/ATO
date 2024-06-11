package itu.contact;

import java.io.Serializable;
import java.util.Objects;

import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

@Embeddable
class UtilisateurContactId implements Serializable {
    private Long utilisateur;
    private Long contact;

    // Constructors, equals, and hashCode methods

    public UtilisateurContactId() {
    }

    public UtilisateurContactId(Long utilisateur, Long contact) {
        this.utilisateur = utilisateur;
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurContactId that = (UtilisateurContactId) o;
        return Objects.equals(utilisateur, that.utilisateur) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, contact);
    }
}

@Entity
public class UtilisateurContact {
    @EmbeddedId
    private UtilisateurContactId id = new UtilisateurContactId();

    @ManyToOne
    @MapsId("utilisateur")
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("contact")
    @JoinColumn(name = "id_contact", nullable = false)
    private Contact contact;

    // Getters and Setters

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

