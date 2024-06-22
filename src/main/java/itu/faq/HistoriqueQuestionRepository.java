package itu.faq;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itu.utilisateur.Utilisateur;

@Repository
public interface HistoriqueQuestionRepository extends JpaRepository<HistoriqueQuestion, Long> {

    List<HistoriqueQuestion> findByUtilisateur(Utilisateur utilisateur);

    @Query(value="select id_question,count(id_question) as nbQuestion,question from question natural join historique_question group by id_question,question",nativeQuery=true)
    List<Map<String,Object>> getStatistiqueQuestion();
}
