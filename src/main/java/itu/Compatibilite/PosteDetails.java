package itu.Compatibilite;

import jakarta.persistence.*;

@Entity
public class PosteDetails {
    @Id
    private Long idPoste;
    private String posteDescription;
    private String posteDateInsertion;
    private double posteSalaire;
    private String posteTitre;
    private Long posteDiplome;
    private Long posteEntreprise;
    private int nbrAnneeExperience;
    private int nbrAnneeFormation;
    private int posteAgeMin;
    private int posteAgeMax;
    private Long idDiplome;
    private String diplomeNom;
    private String diplomeNiveau;
    private String entrepriseNom;
    private int entreprisePoint;
    private String entrepriseType;
    private String entrepriseDateCreation;
    private String entrepriseAdresse;
    private String entrepriseSiteWeb;
    private String entrepriseMail;
    private double entrepriseLatitude;
    private double entrepriseLongitude;
    private String entrepriseImage;

    // ---- CONSTRUCTEURS ----
    public PosteDetails() {}

    public PosteDetails(Long idPoste, String posteDescription, String posteDateInsertion, double posteSalaire, String posteTitre, Long posteDiplome, Long posteEntreprise, int nbrAnneeExperience, int nbrAnneeFormation, int posteAgeMin, int posteAgeMax, Long idDiplome, String diplomeNom, String diplomeNiveau, String entrepriseNom, int entreprisePoint, String entrepriseType, String entrepriseDateCreation, String entrepriseAdresse, String entrepriseSiteWeb, String entrepriseMail, double entrepriseLatitude, double entrepriseLongitude, String entrepriseImage) {
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
    }

    // ---- GETTERS ET SETTERS ----
    public Long getIdPoste() { return idPoste; }
    public void setIdPoste(Long idPoste) { this.idPoste = idPoste; }

    public String getPosteDescription() { return posteDescription; }
    public void setPosteDescription(String posteDescription) { this.posteDescription = posteDescription; }

    public String getPosteDateInsertion() { return posteDateInsertion; }
    public void setPosteDateInsertion(String posteDateInsertion) { this.posteDateInsertion = posteDateInsertion; }

    public double getPosteSalaire() { return posteSalaire; }
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

    public boolean checkAge(UtilisateurDetails u){
        int uAge = u.calculateAge();
        if (uAge >= this.getPosteAgeMin() && uAge <= this.getPosteAgeMax()) {
            return true;
        }
        return false;
    }

    public boolean checkExp(UtilisateurDetails u){
        int uExp = u.calculateExperienceYears();
        if (uExp >= this.getNbrAnneeExperience()) {
            return true;
        }
        return false;
    }

    public boolean checkFormation(UtilisateurDetails u){
        int uForm = u.calculateFormationYears();
        if (uForm >= this.getNbrAnneeFormation()) {
            return true;
        }
        return false;
    }

    public boolean checkDiplome(UtilisateurDetails u){
        if (u.getIdDiplome() == this.getIdDiplome()) {
            return true;
        }
        return false;
    }

    public double calculateDistance(UtilisateurDetails u) {
        double uLatitude = u.getLatitude();
        double uLongitude = u.getLongitude();

        double pLatitude = this.getEntrepriseLatitude();
        double pLongitude = this.getEntrepriseLongitude();

        final int R = 6371; // Rayon de la Terre en kilomètres

        double latDistance = Math.toRadians(uLatitude - pLatitude);
        double lonDistance = Math.toRadians(uLongitude - pLongitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(pLatitude)) * Math.cos(Math.toRadians(uLatitude))
                + Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance en kilomètres
    }

    // public double getCompatibility(UtilisateurDetails u){
    //     double val;

    //     int uAge = u.calculateAge();
        
    //     return val;
    // }
}
