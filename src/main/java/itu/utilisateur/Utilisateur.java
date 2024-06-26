package itu.utilisateur;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import itu.competence.Competence;
import itu.contact.Contact;
import itu.diplome.Diplome;
import itu.notification.*;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    Long id;

    String nom;
    String prenom;
    Date dateNaissance;
    String adresse;
    String mail;

    @OneToMany(mappedBy = "utilisateur")
    List<Notification> notifications;

    @ManyToMany
    @JoinTable(
        name = "diplome_utilisateur",
        joinColumns = @JoinColumn(name = "id_utilisateur"),
        inverseJoinColumns = @JoinColumn(name = "id_diplome")
    )
    private Set<Diplome> diplomes;

    @ManyToMany
    @JoinTable(
        name = "utilisateur_contact",
        joinColumns = @JoinColumn(name = "id_utilisateur"),
        inverseJoinColumns = @JoinColumn(name = "id_contact")
    )
    private Set<Contact> contacts;

    @ManyToMany
    @JoinTable(
        name = "competence_utilisateur",
        joinColumns = @JoinColumn(name = "id_utilisateur"),
        inverseJoinColumns = @JoinColumn(name = "id_competence")
    )
    private Set<Competence> competences;

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(Set<Diplome> diplomes) {
        this.diplomes = diplomes;
    }

    // List<String> numeroTelephone;
    String etatCivil;
    String photo;
    int point;
    float latitude;
    float longitude;
    String motdepasse;
    String description;
    @Column(columnDefinition = "NUMERIC(15,2) DEFAULT 0")
    float salaireRecherche;

    // ---- ---- CONSTRUCTEURS ------- ------

    public Utilisateur() {

    }

    public Utilisateur(Long id, String nom, String prenom, Date dateNaissance, String adresse, String mail,
            String etat_civil, String photo, int point, float longitude,
            float latitude, String motdepasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.mail = mail;
        this.etatCivil = etat_civil;
        this.photo = photo;
        this.point = point;
        this.longitude = longitude;
        this.latitude = latitude;
        this.motdepasse = motdepasse;
    }

    // ------- setters -------------
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) throws Exception {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setEtat_civil(String etat_civil) {
        this.etatCivil = etat_civil;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalaireRecherche(float salaireRecherche) {
        this.salaireRecherche = salaireRecherche;
    }
    /* ---- ------ FIN CONSTRUCTOR --------- - */

    // ------ gettters ------- ---------
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public String getEtat_civil() {
        return etatCivil;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPoint() {
        return point;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getDescription() {
        return description;
    }

    public float getSalaireRecherche() {
        return salaireRecherche;
    }

    public int calculateAge() {
        if (this.dateNaissance == null) {
            return 0;
        }
        LocalDate birthDate = this.dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public String MD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // public static void main(String[] args) {
    //     Utilisateur utilisateur = new Utilisateur();
    //     System.out.println(utilisateur.MD5("password123"));
    // }
}
