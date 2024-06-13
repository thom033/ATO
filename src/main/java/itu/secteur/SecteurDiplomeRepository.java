package itu.secteur;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecteurDiplomeRepository extends JpaRepository<SecteurDiplome, SecteurDiplomeId> {
    List<SecteurDiplome> findByDiplomeId(Long diplomeId);
}

