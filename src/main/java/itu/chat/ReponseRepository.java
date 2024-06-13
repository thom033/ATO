package itu.chat;

import itu.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
    @Query("select r from Reponse r where id_question =:idQuestion")
    List<Utilisateur> getReponseByQuestion(long idQuestion);

}