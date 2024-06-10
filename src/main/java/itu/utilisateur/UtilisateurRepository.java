package itu.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("select u from Utilisateur u where mail= :nomUtilisateur and motdepasse= :motpasse")
    List<Utilisateur> getUtilisateur(String nomUtilisateur, String motpasse);

    @Modifying
    @Transactional
    @Query("UPDATE Utilisateur u SET u.point = u.point + :quantite WHERE u.id = :utilisateurId")
    void updatePoints(Long utilisateurId, int quantite);
    
}
