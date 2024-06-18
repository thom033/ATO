package itu.compatibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultAcceuilRepository extends JpaRepository<ResultAcceuil, Long> {

    @Query(value = "SELECT * FROM result_acceuil", nativeQuery = true)
    List<ResultAcceuil> getResultAcceuils();
}
