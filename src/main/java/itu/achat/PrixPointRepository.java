package itu.achat;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrixPointRepository extends JpaRepository<PrixPoint,Long> {
    @Query(value="SELECT p FROM PrixPoint p WHERE p.dateChangement = (SELECT MAX(p2.dateChangement) FROM PrixPoint p2 WHERE p2.dateChangement < :date)")
    PrixPoint getPrixPoint(@Param("date") LocalDate date);
}
