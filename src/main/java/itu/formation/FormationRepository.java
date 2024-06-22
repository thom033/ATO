package itu.formation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import itu.utilisateur.Utilisateur;

public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> findByUtilisateurId(Long utilisateurId);
}
