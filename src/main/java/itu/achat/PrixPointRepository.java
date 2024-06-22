package itu.achat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrixPointRepository extends JpaRepository<PrixPoint,Long> {
    @Query(value="SELECT p FROM PrixPoint p WHERE p.dateChangement = (SELECT MAX(p2.dateChangement) FROM PrixPoint p2 WHERE p2.dateChangement <= :date) order by p.id desc limit 1")
    PrixPoint getPrixPoint(@Param("date") LocalDate date);

    @Query(value="with argent_entrant as (select sum(salaire) as prix from entretien natural join poste where :dateMin <date_entretien and date_entretien< :dateMax and reussite union select sum(get_price(date)*point) as prix from point_vendu where :dateMin <date and date< :dateMax) select sum(prix) as prix from argent_entrant",nativeQuery=true)
    Optional<Double> getMonnaieDate(@Param("dateMin") LocalDate dateMin,@Param("dateMax") LocalDate dateMax);

    @Query(value="with argent_entrant as(select extract(month from date_entretien) as mois, sum(salaire) as prix from entretien natural join poste where extract(year from date_entretien)= :annee and reussite group by extract(month from date_entretien) union select extract(month from date) as mois,sum(get_price(date)*point) as prix from point_vendu where extract(year from date)= :annee group by extract(month from date)) select sum(prix) as monnaie,mois from argent_entrant group by mois order by mois",nativeQuery=true)
    List<StatistiqueArgentEntrant> getStatistiqueArgentEntrants(@Param("annee") int annee);

}
