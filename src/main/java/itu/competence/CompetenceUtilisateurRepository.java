package itu.competence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompetenceUtilisateurRepository extends JpaRepository<CompetenceUtilisateur, CompetenceUtilisateurId> {
    List<CompetenceUtilisateur> findByUtilisateurId(Long utilisateurId);
}

