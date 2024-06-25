package itu.postulation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import itu.compatibilite.PosteDetails;
import itu.poste.Poste;
import itu.utilisateur.Utilisateur;

@Repository
public interface PostulationRepository extends JpaRepository<Postulation, Long> {
    @Query("select u from Postulation u where utilisateur= :utilisateur and poste= :poste")
    List<Postulation> listePostulation(Utilisateur utilisateur, PosteDetails poste);
}