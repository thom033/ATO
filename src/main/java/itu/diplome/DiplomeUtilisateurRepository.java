package itu.diplome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomeUtilisateurRepository extends JpaRepository<DiplomeUtilisateur, DiplomeUtilisateurId> {
    List<DiplomeUtilisateur> findByUtilisateurId(Long utilisateurId);
}

