package itu.question;

import itu.reponse.Reponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_question")
    Long idQuestion;
    String question;
    public Question(Long idQuestion, String question) {
        this.idQuestion = idQuestion;
        this.question = question;
    }
    public Question() {
    }
    public Long getIdQuestion() {
        return idQuestion;
    }
    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

}