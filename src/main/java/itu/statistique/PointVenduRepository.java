package itu.statistique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointVenduRepository extends JpaRepository<PointVendu, Long> {
    @Query(value = "SELECT date_vente, SUM(quantite) AS quantite FROM point_vendu " +
            " WHERE EXTRACT(YEAR FROM date_vente) =:year AND EXTRACT(MONTH FROM date_vente) = :month " +
            " GROUP BY EXTRACT(YEAR FROM date_vente), EXTRACT(MONTH FROM date_vente)", nativeQuery = true)
    List<PointVendu> statPointVendu(@Param("year") Integer year, @Param("month") Integer month);
}
