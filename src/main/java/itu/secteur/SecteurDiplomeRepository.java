package itu.secteur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecteurDiplomeRepository extends JpaRepository<Secteur, Long> {
}
