package itu.entretien;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EntretienRepository extends JpaRepository<Entretien, Long> {

    @Query(value = "select count(entretien) as nbEntretien,extract(month from date_entretien) as mois from entretien where reussite and extract(year from date_entretien)= :annee group by extract(month from date_entretien)", nativeQuery = true)
    List<StatistiqueEntretienReussi> getStatistiqueEntretien(@Param("annee") int annee);

    @Query("select e from Entretien e where e.reussite IS null")
    List<Entretien> findAllCurrent();
}
