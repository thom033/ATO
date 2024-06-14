package itu.poste;

import jakarta.persistence.*;

@Entity
@Table(name = "Postes_details")
public class PosteDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Long idPoste;
    @Column(name = "poste_description")
    private String posteDescription;
    @Column(name = "poste_date_insertion")
    private String posteDateInsertion;
    @Column(name = "poste_salaire")
    private double posteSalaire;
    @Column(name = "poste_titre")
    private String posteTitre;
    @Column(name = "poste_diplome")
    private Long posteDiplome;
    @Column(name = "poste_entreprise")
    private Long posteEntreprise;
    @Column(name = "nbr_annee_experience")
    private int nbrAnneeExperience;
    @Column(name = "nbr_annee_formation")
    private int nbrAnneeFormation;
    @Column(name = "poste_age_min")
    private int posteAgeMin;
    @Column(name = "poste_age_max")
    private int posteAgeMax;
    @Column(name = "id_diplome")
    private Long idDiplome;
    @Column(name = "diplome_nom")
    private String diplomeNom;
    @Column(name = "diplome_niveau")
    private String diplomeNiveau;
    @Column(name = "entreprise_nom")
    private String entrepriseNom;
    @Column(name = "entreprise_point")
    private int entreprisePoint;
    @Column(name = "entreprise_type")
    private String entrepriseType;
    @Column(name = "entreprise_date_creation")
    private String entrepriseDateCreation;
    @Column(name = "entreprise_adresse")
    private String entrepriseAdresse;
    @Column(name = "entreprise_site_web")
    private String entrepriseSiteWeb;
    @Column(name = "entreprise_mail")
    private String entrepriseMail;
    @Column(name = "entreprise_latitude")
    private double entrepriseLatitude;
    @Column(name = "entreprise_longitude")
    private double entrepriseLongitude;
    @Column(name = "entreprise_image")
    private String entrepriseImage;
    @Column(name = "id_secteur")
    private int idSecteur;
    @Column(name = "secteur_diplome_id_diplome")
    private int secteurDiplomeIdDiplome;

    // ---- CONSTRUCTEURS ----
    public PosteDetails() {}

    public PosteDetails(Long idPoste, String posteDescription, String posteDateInsertion, double posteSalaire, String posteTitre, Long posteDiplome, Long posteEntreprise, int nbrAnneeExperience, int nbrAnneeFormation, int posteAgeMin, int posteAgeMax, Long idDiplome, String diplomeNom, String diplomeNiveau, String entrepriseNom, int entreprisePoint, String entrepriseType, String entrepriseDateCreation, String entrepriseAdresse, String entrepriseSiteWeb, String entrepriseMail, double entrepriseLatitude, double entrepriseLongitude, String entrepriseImage, int idSecteur, int secteurDiplomeIdDiplome) {
        this.idPoste = idPoste;
        this.posteDescription = posteDescription;
        this.posteDateInsertion = posteDateInsertion;
        this.posteSalaire = posteSalaire;
        this.posteTitre = posteTitre;
        this.posteDiplome = posteDiplome;
        this.posteEntreprise = posteEntreprise;
        this.nbrAnneeExperience = nbrAnneeExperience;
        this.nbrAnneeFormation = nbrAnneeFormation;
        this.posteAgeMin = posteAgeMin;
        this.posteAgeMax = posteAgeMax;
        this.idDiplome = idDiplome;
        this.diplomeNom = diplomeNom;
        this.diplomeNiveau = diplomeNiveau;
        this.entrepriseNom = entrepriseNom;
        this.entreprisePoint = entreprisePoint;
        this.entrepriseType = entrepriseType;
        this.entrepriseDateCreation = entrepriseDateCreation;
        this.entrepriseAdresse = entrepriseAdresse;
        this.entrepriseSiteWeb = entrepriseSiteWeb;
        this.entrepriseMail = entrepriseMail;
        this.entrepriseLatitude = entrepriseLatitude;
        this.entrepriseLongitude = entrepriseLongitude;
        this.entrepriseImage = entrepriseImage;
        this.idSecteur = idSecteur;
        this.secteurDiplomeIdDiplome = secteurDiplomeIdDiplome;
    }

    // ---- GETTERS ET SETTERS ----
    public Long getIdPoste() { return idPoste; }
    public void setIdPoste(Long idPoste) { this.idPoste = idPoste; }

    public String getPosteDescription() { return posteDescription; }
    public void setPosteDescription(String posteDescription) { this.posteDescription = posteDescription; }

    public String getPosteDateInsertion() { return posteDateInsertion; }
    public void setPosteDateInsertion(String posteDateInsertion) { this.posteDateInsertion = posteDateInsertion; }

    public int getPosteSalaire() { return (int)posteSalaire; }
    public void setPosteSalaire(double posteSalaire) { this.posteSalaire = posteSalaire; }

    public String getPosteTitre() { return posteTitre; }
    public void setPosteTitre(String posteTitre) { this.posteTitre = posteTitre; }

    public Long getPosteDiplome() { return posteDiplome; }
    public void setPosteDiplome(Long posteDiplome) { this.posteDiplome = posteDiplome; }

    public Long getPosteEntreprise() { return posteEntreprise; }
    public void setPosteEntreprise(Long posteEntreprise) { this.posteEntreprise = posteEntreprise; }

    public int getNbrAnneeExperience() { return nbrAnneeExperience; }
    public void setNbrAnneeExperience(int nbrAnneeExperience) { this.nbrAnneeExperience = nbrAnneeExperience; }

    public int getNbrAnneeFormation() { return nbrAnneeFormation; }
    public void setNbrAnneeFormation(int nbrAnneeFormation) { this.nbrAnneeFormation = nbrAnneeFormation; }

    public int getPosteAgeMin() { return posteAgeMin; }
    public void setPosteAgeMin(int posteAgeMin) { this.posteAgeMin = posteAgeMin; }

    public int getPosteAgeMax() { return posteAgeMax; }
    public void setPosteAgeMax(int posteAgeMax) { this.posteAgeMax = posteAgeMax; }

    public Long getIdDiplome() { return idDiplome; }
    public void setIdDiplome(Long idDiplome) { this.idDiplome = idDiplome; }

    public String getDiplomeNom() { return diplomeNom; }
    public void setDiplomeNom(String diplomeNom) { this.diplomeNom = diplomeNom; }

    public String getDiplomeNiveau() { return diplomeNiveau; }
    public void setDiplomeNiveau(String diplomeNiveau) { this.diplomeNiveau = diplomeNiveau; }

    public String getEntrepriseNom() { return entrepriseNom; }
    public void setEntrepriseNom(String entrepriseNom) { this.entrepriseNom = entrepriseNom; }

    public int getEntreprisePoint() { return entreprisePoint; }
    public void setEntreprisePoint(int entreprisePoint) { this.entreprisePoint = entreprisePoint; }

    public String getEntrepriseType() { return entrepriseType; }
    public void setEntrepriseType(String entrepriseType) { this.entrepriseType = entrepriseType; }

    public String getEntrepriseDateCreation() { return entrepriseDateCreation; }
    public void setEntrepriseDateCreation(String entrepriseDateCreation) { this.entrepriseDateCreation = entrepriseDateCreation; }

    public String getEntrepriseAdresse() { return entrepriseAdresse; }
    public void setEntrepriseAdresse(String entrepriseAdresse) { this.entrepriseAdresse = entrepriseAdresse; }

    public String getEntrepriseSiteWeb() { return entrepriseSiteWeb; }
    public void setEntrepriseSiteWeb(String entrepriseSiteWeb) { this.entrepriseSiteWeb = entrepriseSiteWeb; }

    public String getEntrepriseMail() { return entrepriseMail; }
    public void setEntrepriseMail(String entrepriseMail) { this.entrepriseMail = entrepriseMail; }

    public double getEntrepriseLatitude() { return entrepriseLatitude; }
    public void setEntrepriseLatitude(double entrepriseLatitude) { this.entrepriseLatitude = entrepriseLatitude; }

    public double getEntrepriseLongitude() { return entrepriseLongitude; }
    public void setEntrepriseLongitude(double entrepriseLongitude) { this.entrepriseLongitude = entrepriseLongitude; }

    public String getEntrepriseImage() { return entrepriseImage; }
    public void setEntrepriseImage(String entrepriseImage) { this.entrepriseImage = entrepriseImage; }

    public int getIdSecteur() { return idSecteur; }
    public void setIdSecteur(int idSecteur) { this.idSecteur = idSecteur; }

    public int getSecteurDiplomeIdDiplome() { return secteurDiplomeIdDiplome; }
    public void setSecteurDiplomeIdDiplome(int secteurDiplomeIdDiplome) { this.secteurDiplomeIdDiplome = secteurDiplomeIdDiplome; }

   
}
