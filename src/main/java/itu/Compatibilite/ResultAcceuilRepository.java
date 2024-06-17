package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultAcceuilRepository extends JpaRepository<ResultAcceuil, Long> {

    List<ResultAcceuil> findByIdUtilisateur(Long idUtilisateur);

    @Query(value = "SELECT * FROM result_acceuil WHERE id_utilisateur = :id_u AND id_poste = :id_poste", nativeQuery = true)
    List<ResultAcceuil> getByUtilisateurPoste(@Param("id_u") int id_u, @Param("id_poste") int id_poste);
}
