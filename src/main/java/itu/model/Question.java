package itu.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_question")
    int idQuestion;
    @Column(name = "question")
    String question;
    public Question(int idQuestion, String question) {
        this.idQuestion = idQuestion;
        this.question = question;
    }
    public Question(String question) {
        this.question = question;
    }
    public Question() {
    }
    public int getIdQuestion() {
        return idQuestion;
    }
    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
}
