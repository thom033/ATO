package itu.statistique.repository;

import itu.statistique.PointVendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PointVenduRepository extends JpaRepository<PointVendu, Long> {
    @Query(value = "SELECT SUM(quantite) AS quantite FROM PointVendu " +
            " WHERE date_vente BETWEEN :date_debut AND :date_fin ")
    Integer statPointVendu(@Param("date_debut") Date date_debut, @Param("date_fin") Date date_fin);
}
