package itu.poste;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PosteRepository extends JpaRepository<Poste,Long> {
    
}
