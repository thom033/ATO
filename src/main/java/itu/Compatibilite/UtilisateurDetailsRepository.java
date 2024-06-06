package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UtilisateurDetailsRepository extends JpaRepository<UtilisateurDetails, Long> {

    @Query("select u from utilisateur_details u where id_utilisateur= :id_user")
    List<PosteDetails> getPosteDetails(int id_user);
}