package itu.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoriqueRepository extends JpaRepository<HistoriqueQuestion, long> {
    @Query("select count(id_question) as total from historique_question GROUP BY id_question")
    List<Integer> statQuestion();
}