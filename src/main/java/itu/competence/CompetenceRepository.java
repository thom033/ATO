package itu.competence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itu.utilisateur.Utilisateur;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findByUtilisateurId(Long idUtilisateur);
}
