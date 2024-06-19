package itu.statistique;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatistiquePointRepository extends JpaRepository<StatistiquePoint, Long> {
    @Query("SELECT cout, count(cout) AS total FROM poste group by cout")
    List<StatistiqueSecteur> statPoint();
    @Query("SELECT Sum(quantite) AS total FROM point_vendu\n" +
            "    WHERE extract(Month FROM date_vente) = ?")
    int statPoint(String month);
}
