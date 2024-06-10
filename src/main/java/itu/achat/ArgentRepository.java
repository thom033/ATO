package itu.achat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ArgentRepository extends JpaRepository<Argent, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Argent a SET a.solde = a.solde - :montant WHERE a.idUtilisateur = :utilisateurId")
    void updateArgentUser(Long utilisateurId, double montant);
}