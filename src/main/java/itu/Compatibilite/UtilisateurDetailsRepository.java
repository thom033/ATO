package itu.compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurDetailsRepository extends JpaRepository<UtilisateurDetails, Long> {
    @Query("select u from UtilisateurDetails u where idUtilisateur= :id_user")
    List<UtilisateurDetails> getPosteDetails(int id_user);
}
