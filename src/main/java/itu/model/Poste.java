package itu.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name ="poste")
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_poste")
    int idPoste;
    @Column(name = "description")
    String description;
    @Column(name = "date_insertion")
    LocalDate dateInsertion;
    @Column(name = "salaire")
    float salaire;
    @Column(name = "titre")
    String titre;
    @Column(name = "id_diplome")
    int idDiplome;
    @Column(name = "id_entreprise")
    int idEntreprise;
    @Column(name = "nbr_annee_experience")
    int nbrAnneeExperience ;
    @Column(name = "nbr_annee_formation")
    int nbrAnneeFormation ;
    @Column(name = "age")
    int age;
}
