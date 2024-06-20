package itu.statistique;

import itu.poste.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatistiqueRepository extends JpaRepository<StatistiqueSecteur, Long> {

    @Query("SELECT secteur, count(secteur) AS embauche FROM StatistiqueSecteur \n" +
            "where disponibilite = false\n" +
            "group by secteur")
    List<StatistiqueSecteur> statPosteIndisponible();

    @Query("SELECT s FROM StatistiqueSecteur s\n" +
            "where s.disponibilite = true\n" +
            "group by s.secteur")
    List<StatistiqueSecteur> statPosteDisponible();

    @Query("SELECT secteur, count(secteur) AS embauche FROM StatistiqueSecteur")
    List<StatistiqueSecteur> statSecteurPostule();
}
