package itu.poste;


import jakarta.persistence.*;

@Entity
@Table(name = "Poste")
public class Poste {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notification")
    long id_poste;
}
