package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@Repository
public interface PosteDetailsRepository extends JpaRepository<PosteDetails, Long>, JpaSpecificationExecutor<PosteDetails> {

    @Query("select p from PosteDetails p where idSecteur=:id_secteur")
    List<PosteDetails> getPosteDetails(@Param("id_secteur") Long idSecteur);

    @Query("select pd from PosteDetails pd where idPoste=:idPoste")
    PosteDetails getPosteDetail(@Param("idPoste")Long idPostee);

    @Query(value = "SELECT get_positif(:idUser,:idPoste)")
    List<String>  getPositifxx(@Param("idUser") Long idUtilisateur,@Param("idPoste") Long idPoste);

    @Query(value = "SELECT get_negatif(:idUser,:idPoste)")
    String[]  getNegatif(@Param("idUser") Long idUtilisateur,@Param("idPoste") Long idPoste);

    @Query(value = "SELECT get_positif(:userId, :posteId)", nativeQuery = true)
    String[] getPositif(@Param("userId") Long userId, @Param("posteId") Long posteId);


}
