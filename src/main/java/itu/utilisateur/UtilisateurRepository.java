package itu.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("select u from Utilisateur u where mail= :nomUtilisateur and motdepasse= :motpasse")
    List<Utilisateur> getUtilisateur(String nomUtilisateur, String motpasse);

    @Modifying
    @Transactional
    @Query("UPDATE Utilisateur u SET u.point = u.point + :quantite WHERE u.id = :utilisateurId")
    void updatePoints(Long utilisateurId, int quantite);

/*    @Query("SELECT CASE\n" +
            "        WHEN AGE(CURRENT_DATE, date_naissance) < INTERVAL '20 years' THEN '< 20 ans'\n" +
            "        WHEN AGE(CURRENT_DATE, date_naissance) BETWEEN INTERVAL '20 years' AND INTERVAL '30 years' THEN '20-30 ans'\n" +
            "        WHEN AGE(CURRENT_DATE, date_naissance) BETWEEN INTERVAL '30 years' AND INTERVAL '40 years' THEN '30-40 ans'\n" +
            "        ELSE '40+ ans'\n" +
            "    END AS age_group,\n" +
            "    COUNT(*) AS total\n" +
            "FROM Utilisateur " +
            "GROUP BY age_group " +
            "ORDER BY age_group ASC")
    List<Integer> statistiqueAge();*/
}
