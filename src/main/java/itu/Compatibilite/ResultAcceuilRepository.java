package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultAcceuilRepository extends JpaRepository<ResultAcceuil, Long> {

    @Query(value = "SELECT * FROM result_acceuil where id_utilisateur =:idUtilisateur AND id_secteur =:idSecteur", nativeQuery = true)
    List<ResultAcceuil> getResultAcceuils(@Param("idUtilisateur") Long id_utilisateur, @Param("idSecteur") Long idSecteur);

    @Query(value = "SELECT get_user_secteur(:id_utilisateur)", nativeQuery = true)
    Long getUserSecteur(@Param("id_utilisateur") Long id_utilisateur);
}
