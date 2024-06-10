package itu.reponse;

import itu.question.Question;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reponse")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reponse")
    Long idReponse;
    String reponse;
    @ManyToOne
    @JoinColumn(name = "id_question")
    Question question;
    public Reponse(String reponse, Question question) {
        this.reponse = reponse;
        this.question = question;
    }
    public Reponse(Long idReponse, String reponse, Question question) {
        this.idReponse = idReponse;
        this.reponse = reponse;
        this.question = question;
    }
    public Reponse() {
    }
    public Long getIdReponse() {
        return idReponse;
    }
    public void setIdReponse(Long idReponse) {
        this.idReponse = idReponse;
    }
    public String getReponse() {
        return reponse;
    }
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
}
