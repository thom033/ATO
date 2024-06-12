package itu.contact;

import java.io.Serializable;
import java.util.Objects;

import itu.entreprise.Entreprise;
import jakarta.persistence.*;

@Embeddable
class EntrepriseContactId implements Serializable {
    private Long entreprise;
    private Long contact;

    // Constructors, equals, and hashCode methods

    public EntrepriseContactId() {
    }

    public EntrepriseContactId(Long entreprise, Long contact) {
        this.entreprise = entreprise;
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrepriseContactId that = (EntrepriseContactId) o;
        return Objects.equals(entreprise, that.entreprise) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entreprise, contact);
    }
}

@Entity
public class EntrepriseContact {
    @EmbeddedId
    private EntrepriseContactId id = new EntrepriseContactId();

    @ManyToOne
    @MapsId("entreprise")
    @JoinColumn(name = "id_entreprise", nullable = false)
    private Entreprise entreprise;

    @ManyToOne
    @MapsId("contact")
    @JoinColumn(name = "id_contact", nullable = false)
    private Contact contact;

    // Getters and Setters

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

