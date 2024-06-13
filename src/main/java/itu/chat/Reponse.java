package itu.chat;

import jakarta.persistence.*;

@Entity
@Table(name = "Reponse")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reponse")
    long idReponse;
    String reponse;
    @OneToMany(mappedBy = "id_question")
    Question question;

    /* ------ Constructor ------ */
        public Reponse(long idReponse, String reponse, Question question) {
            this.idReponse = idReponse;
            this.reponse = reponse;
            this.question = question;
        }
    /* ------ ----------- ------ */


    /* ------ -- SETTERS -- ------ */
        public void setIdReponse(long idReponse) {
            this.idReponse = idReponse;
        }
        public void setReponse(String reponse) {
            this.reponse = reponse;
        }
        public void setQuestion(Question question) {
            this.question = question;
        }
    /* ------ ----------- ------ */


    /* ------ -- GETTERS -- ------ */
        public long getIdReponse() {
            return idReponse;
        }
        public String getReponse() {
            return reponse;
        }
        public Question getQuestion() {
            return question;
        }
    /* ------ ----------- ------ */
}
