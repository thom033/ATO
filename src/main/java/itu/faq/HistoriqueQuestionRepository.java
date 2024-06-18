package itu.faq;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import itu.utilisateur.Utilisateur;

@Repository
public interface HistoriqueQuestionRepository extends JpaRepository<HistoriqueQuestion, Long> {

    List<HistoriqueQuestion> findByUtilisateur(Utilisateur utilisateur);
}
