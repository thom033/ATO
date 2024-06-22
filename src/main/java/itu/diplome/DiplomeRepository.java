package itu.diplome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
    @Query(value="Select id_diplome,diplome,niveau from diplome",nativeQuery = true)
    List<Diplome> findAllSpecial();
}