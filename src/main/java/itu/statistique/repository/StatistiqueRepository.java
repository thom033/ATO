package itu.statistique.repository;

import itu.poste.Poste;
import itu.statistique.StatistiqueSecteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatistiqueRepository extends JpaRepository<StatistiqueSecteur, Long> {

    @Query("SELECT secteur, count(secteur) AS total FROM StatistiqueSecteur \n" +
            "where disponibilite = false")
    List<StatistiqueSecteur> statPosteIndisponible();

    @Query("SELECT s FROM StatistiqueSecteur s\n" +
            "where s.disponibilite = true")
    List<StatistiqueSecteur> statPosteDisponible();

    @Query("SELECT secteur, total FROM StatistiqueSecteur")
    List<Object[]> statSecteurPostule();
}
