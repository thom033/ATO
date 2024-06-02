package itu.model;

import jakarta.persistence.*;

@Entity
@Table(name ="reponse")
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_reponse")
    int idReponse;
    @Column(name = "reponse")
    String reponse;
    @Column(name = "id_question")
    int idQuestion;
    public Reponse(int idReponse, String reponse, int idQuestion) {
        this.idReponse = idReponse;
        this.reponse = reponse;
        this.idQuestion = idQuestion;
    }
    public Reponse(String reponse, int idQuestion) {
        this.reponse = reponse;
        this.idQuestion = idQuestion;
    }
    public Reponse() {
    }
    public int getIdReponse() {
        return idReponse;
    }
    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }
    public String getReponse() {
        return reponse;
    }
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    public int getIdQuestion() {
        return idQuestion;
    }
    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }
}
