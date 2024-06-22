package itu.faq;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value="select id_question as idQuestion,count(id_question) as nbQuestion,question from question natural join historique_question group by id_question,question limit 3",nativeQuery = true)
    List<StatistiqueQuestion> getStatistiqueQuestion();
}
