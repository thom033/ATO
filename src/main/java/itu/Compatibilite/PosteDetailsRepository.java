package itu.Compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteDetailsRepository extends JpaRepository<PosteDetails, Long> {

//     @Query("select p from postes_details p where id_secteur= :id_secteur")
//     List<PosteDetails> getPosteDetails(int id_secteur);
}