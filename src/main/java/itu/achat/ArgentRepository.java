package itu.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ArgentRepository extends JpaRepository<Argent, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Argent a SET a.solde = a.solde - :montant WHERE a.idUtilisateur = :utilisateurId")
    void updateArgentUser(Long utilisateurId, double montant);

    @Modifying
    @Transactional
    @Query("UPDATE Argent a SET a.solde = a.solde + :montant WHERE a.idUtilisateur = :utilisateurId")
    void rechargeSoldeUser(Long utilisateurId, double montant);

    @Query("Select a from Argent a WHERE a.idUtilisateur = :utilisateurId")
    Argent getArgentUser(Long utilisateurId);

    @Query(value = "select sum(point) as nombre,extract(month from date) as mois from point_vendu where extract(year from date)= :annee group by extract(month from date)",nativeQuery = true)
    List<StatistiquePoint> getStatistiquePoint(@Param("annee") int annee);

    @Modifying
    @Transactional
    @Query(value = "insert into point_vendu(id_utilisateur,point) values(:utilisateurId, :nbrPoints)",nativeQuery = true)
    void insertAchat(Long utilisateurId,int nbrPoints);
}
