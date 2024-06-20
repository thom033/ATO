package itu.chat;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    long idQuestion;
    String question;

    public Question() {
    }
    public Question(int idQuestion, String question) {
        this.idQuestion = idQuestion;
        this.question = question;
    }
    /* --- SETTERS ------ */
    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setQuestion(String question)throws Exception {
        if (question.trim().isEmpty()){
            throw new Exception("Le champ question est obligatoire");
        }
        this.question = question;
    }
    /* ---- ----- ------ */


    /* ---- GETTERS ------ */
    public long getIdQuestion() {
        return idQuestion;
    }

    public String getQuestion() {
        return question;
    }
    /* ---- ----- ------ */
}
