package itu.Compatibilite;

import jakarta.persistence.*;


@Entity
@Table(name = "result_acceuil")
public class ResultAcceuil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;
    @Column(name = "id_diplome")
    private Long idDiplome;
    @Column(name = "id_secteur")
    private Long idSecteur;
    @Column(name = "id_poste")
    private Long idPoste;
    @Column(name = "poste_salaire")
    private Double posteSalaire;
    @Column(name = "poste_description")
    private String posteDescription;
    @Column(name = "poste_titre")
    private String posteTitre;
    @Column(name = "entreprise_nom")
    private String entrepriseNom;
    @Column(name = "entreprise_point")
    private int entreprisePoints;
    @Column(name = "pts_total")
    private double ptsTotal;

    // Getters and Setters

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Long idDiplome) {
        this.idDiplome = idDiplome;
    }

    public Long getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Long idSecteur) {
        this.idSecteur = idSecteur;
    }

    public Long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Long idPoste) {
        this.idPoste = idPoste;
    }

    public Double getPosteSalaire() {
        return posteSalaire;
    }

    public void setPosteSalaire(Double posteSalaire) {
        this.posteSalaire = posteSalaire;
    }

    public String getPosteDescription() {
        return posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public String getPosteTitre() {
        return posteTitre;
    }

    public void setPosteTitre(String posteTitre) {
        this.posteTitre = posteTitre;
    }

    public String getEntrepriseNom() {
        return entrepriseNom;
    }

    public void setEntrepriseNom(String entrepriseNom) {
        this.entrepriseNom = entrepriseNom;
    }

    public double getPtsTotal() {
        return ptsTotal;
    }

    public void setPtsTotal(double ptsTotal) {
        this.ptsTotal = ptsTotal;
    }

    public int getEntreprisePoints() {
        return entreprisePoints;
    }

    public void setEntreprisePoints(int entreprisePoints) {
        this.entreprisePoints = entreprisePoints;
    }
}
