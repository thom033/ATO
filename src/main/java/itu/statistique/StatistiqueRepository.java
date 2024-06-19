package itu.statistique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatistiqueRepository extends JpaRepository<StatistiqueSecteur, Long> {

    @Query("SELECT id_secteur, count(id_secteur) AS embauche FROM poste\n" +
            "JOIN secteur_diplome sd on poste.id_diplome = sd.id_diplome\n" +
            "where disponibilite = false\n" +
            "group by id_secteur")
    List<StatistiqueSecteur> statPosteIndisponible();

    @Query("SELECT id_secteur, count(id_secteur) AS dispo FROM poste\n" +
            "JOIN secteur_diplome sd ON poste.id_diplome = sd.id_diplome\n" +
            "where disponibilite = true\n" +
            "group by id_secteur")
    List<StatistiqueSecteur> statPosteDisponible();

    @Query("SELECT id_secteur, count(id_secteur) AS total FROM poste\n" +
            "JOIN secteur_diplome sd ON poste.id_diplome = sd.id_diplome\n" +
            "group by id_secteur;")
    List<StatistiqueSecteur> statSecteurPostule();
}
