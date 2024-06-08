package itu.achat;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArgentRepository extends JpaRepository<Argent, Integer> {
    Optional<Argent> findByIdUtilisateur(Long long1);
}
