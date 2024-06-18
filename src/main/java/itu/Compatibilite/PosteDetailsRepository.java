package itu.compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@Repository
public interface PosteDetailsRepository extends JpaRepository<PosteDetails, Long>, JpaSpecificationExecutor<PosteDetails> {

    @Query("select p from PosteDetails p where idSecteur= 2")
    List<PosteDetails> getPosteDetails();

    @Query("select pd from PosteDetails pd where idPoste= :idPostee")
    PosteDetails getPosteDetails(Long idPostee);

}
