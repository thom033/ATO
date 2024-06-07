package itu.diplome;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itu.utilisateur.Utilisateur;

@Repository
public interface DiplomeUtilisateurRepository extends JpaRepository<DiplomeUtilisateur, Long> {
    List<DiplomeUtilisateur> findByUtilisateur(Utilisateur utilisateur);
}

