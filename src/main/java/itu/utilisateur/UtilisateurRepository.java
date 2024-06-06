package itu.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("select u from Utilisateur u where mail= :nomUtilisateur and motdepasse= :motpasse")
    List<Utilisateur> getUtilisateur(String nomUtilisateur, String motpasse);
}
