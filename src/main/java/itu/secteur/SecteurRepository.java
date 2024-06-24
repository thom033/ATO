package itu.secteur;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long> {
    @Query(value="select secteur.id_secteur as idSecteur,count(secteur.id_secteur) as nbSecteur,secteur.secteur from poste natural join diplome join secteur_diplome as secteurDip on secteurDip.id_diplome=diplome.id_diplome join secteur on secteur.id_secteur=secteurDip.id_secteur where extract(month from date_insertion)= :mois and extract(year from date_insertion)= :annee group by secteur.secteur,secteur.id_secteur",nativeQuery=true)    
    List<StatistiqueSecteur> getStatistiquePost(@Param("annee") int annee,@Param("mois") int mois);
    
    @Query(value="select secteur.id_secteur as idSecteur,count(*) as nbSecteur,secteur.secteur,(COUNT(*) * 100.0 / nbPoste) AS pourcentage,nbPoste from poste natural join diplome join secteur_diplome as secteurDip on secteurDip.id_diplome=diplome.id_diplome join secteur on secteur.id_secteur=secteurDip.id_secteur,(SELECT COUNT(*) AS nbPoste FROM poste where extract(year from date_insertion)= :annee) AS total where extract(year from date_insertion)= :annee group by secteur.secteur,nbPoste,secteur.id_secteur order by count(secteur.id_secteur) desc",nativeQuery=true)    
    List<StatistiqueSecteur> getStatistiquePost(@Param("annee") int annee);

    @Query(value="select secteur.id_secteur as idSecteur,count(*) as nbSecteur,secteur.secteur,(COUNT(*) * 100.0 / nbPoste) AS pourcentage,nbPoste from poste natural join diplome join secteur_diplome as secteurDip on secteurDip.id_diplome=diplome.id_diplome join secteur on secteur.id_secteur=secteurDip.id_secteur,(SELECT COUNT(*) AS nbPoste FROM poste where disponibilite) AS total where disponibilite group by secteur.secteur,nbPoste,secteur.id_secteur order by pourcentage desc",nativeQuery=true)    
    List<StatistiqueSecteur> getStatistiqueSecteurPosteDispo();
}