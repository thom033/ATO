package itu.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<itu.user.Utilisateur, Long> {
    @Query("select u from Utilisateur u where mail= :nomUtilisateur and motdepasse= :motpasse")
    List<itu.user.Utilisateur> getUtilisateur(String nomUtilisateur, String motpasse);
    @Query("select u from Utilisateur u where id_utilisateur = :id")
    List<itu.user.Utilisateur> getById(int id);
}
