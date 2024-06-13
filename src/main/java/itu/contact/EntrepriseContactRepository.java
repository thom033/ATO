package itu.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseContactRepository extends JpaRepository<EntrepriseContact, EntrepriseContactId> {
    List<EntrepriseContact> findByEntrepriseId(Long entrepriseId);
}