package itu.poste;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itu.utilisateur.Utilisateur;

public interface PosteDetailsRepository extends JpaRepository<PosteDetails, Integer> {
    @Query("Select pd from Postes_details pd WHERE id_poste = :posteId")
    List<PosteDetails> getDetailsPoste(Long posteId);
}
