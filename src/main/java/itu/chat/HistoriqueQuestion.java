package itu.chat;

import itu.utilisateur.Utilisateur;
import jakarta.persistence.*;

@Entity
@Table(name = "historique_question")
public class HistoriqueQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historique")
    long id_historique;
    @Column(name = "id_question")
    long question;
    @Column(name = "id_question")
    long utilisateur;
}
