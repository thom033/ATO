package itu.entretien;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienRepository extends JpaRepository<Entretien, Long> {

    @Query("select e from Entretien e where e.reussite IS null")
    List<Entretien> findAllCurrent();
}
