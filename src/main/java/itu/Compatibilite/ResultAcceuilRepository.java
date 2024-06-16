package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultAcceuilRepository extends JpaRepository<ResultAcceuil, Long> {

    @Query(value = "SELECT * FROM result_acceuil", nativeQuery = true)
    List<ResultAcceuil> getResultAcceuils();

    @Query(value = "SELECT get_user_secteur(:id_utilisateur)", nativeQuery = true)
    Integer getUserSecteur(@Param("id_utilisateur") Integer idUtilisateur);

    @Query(value = "SELECT * FROM result_acceuil order by entreprise_point DESC limit 3;", nativeQuery = true)
    List<ResultAcceuil> getBestPoint();

    @Query(value = "SELECT get_positif(:id_utilisateur, :id_poste)", nativeQuery = true)
    List<String> getPositif(@Param("id_utilisateur") Integer idUtilisateur, @Param("id_poste") Integer idPoste);

    @Query(value = "SELECT get_negatif(:id_utilisateur, :id_poste)", nativeQuery = true)
    List<String> getNegatif(@Param("id_utilisateur") Integer idUtilisateur, @Param("id_poste") Integer idPoste);
}
