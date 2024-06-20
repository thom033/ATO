package itu.statistique;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatistiquePointRepository extends JpaRepository<StatistiquePoint, Long> {
    @Query("SELECT s FROM StatistiquePoint s")
    List<StatistiquePoint> statPoint();
}
