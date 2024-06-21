package itu.compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.file.Path;
import java.util.List;

@Repository
public interface ResultAcceuilRepository extends JpaRepository<ResultAcceuil, Long> {

    List<ResultAcceuil> findByIdUtilisateur(Long idUtilisateur);

    Page<ResultAcceuil> findByIdUtilisateur(Long idUtilisateur, Pageable pageable);

    @Query(value = "SELECT * FROM result_acceuil", nativeQuery = true)
    List<ResultAcceuil> getResultAcceuils();

    @Query(value = "SELECT * FROM result_acceuil WHERE id_poste=:idPoste", nativeQuery = true)
    ResultAcceuil getResultAcceuil(@Param("idPoste") Long idPoste);

    @Query(value = "SELECT * FROM result_acceuil WHERE id_utilisateur=:userId AND id_secteur=:idSecteur", nativeQuery = true)
    List<ResultAcceuil> getResultAcceuilSecteur(@Param("userId") Long idUtilisateur,@Param("idSecteur") Long idPoste);

    @Query("select ptsTotal from ResultAcceuil where idUtilisateur=:userId AND idPoste=:posteID")
    double getResultAcceuilsByIdPosteUser(Long userId, Long posteID);

    @Query("select ra from ResultAcceuil ra where idUtilisateur=:userId AND idPoste=:posteID")
    ResultAcceuil getResultAcceuilsRecherche(Long userId, Long posteID);

    @Query(value = "SELECT get_user_secteur(:idUser)")
    Long  getUserSecteur(@Param("idUser") Long idUtilisateur);
}
