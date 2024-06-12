package itu.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurContactRepository extends JpaRepository<UtilisateurContact, UtilisateurContactId> {
    List<UtilisateurContact> findByUtilisateurId(Long utilisateurId);
}
