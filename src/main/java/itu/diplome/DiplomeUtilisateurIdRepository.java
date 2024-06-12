package itu.diplome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomeUtilisateurIdRepository extends JpaRepository<DiplomeUtilisateurId, Long> {
    List<DiplomeUtilisateurId> findByUtilisateurId(Long utilisateurId);
}