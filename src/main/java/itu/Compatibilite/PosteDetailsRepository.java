package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteDetailsRepository extends JpaRepository<PosteDetails, Long> {

    @Query("select p from PosteDetails p where idSecteur =:id_secteur")
    List<PosteDetails> getPosteDetails(@Param("id_secteur") Long id_secteur);

    @Query(value = "SELECT get_user_secteur(:id_utilisateur)", nativeQuery = true)
    Integer getUserSecteur(@Param("id_utilisateur") Integer idUtilisateur);
}