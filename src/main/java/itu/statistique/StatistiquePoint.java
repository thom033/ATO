package itu.statistique;

import jakarta.persistence.*;

@Entity
@Table(name = "statPoint")
public class StatistiquePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cout")
    int point;
    int total;

    public StatistiquePoint(){
    }
    public StatistiquePoint(int point, int total) throws Exception{
        this.setPoint(point);
        this.setTotal(total);
    }


    /* --- Getters ------*/
        public int getPoint() {
            return point;
        }
        public int getTotal() {
            return total;
        }
    /* --- ----- ------*/


    /* --- Setters ------*/
        public void setPoint(int point) {
            this.point = point;
        }
        public void setTotal(int total) throws Exception {
            if (total < 0) throw new Exception("La total ne peut pas ête négative");
            this.total = total;
        }
    /* --- ----- ------*/
}
