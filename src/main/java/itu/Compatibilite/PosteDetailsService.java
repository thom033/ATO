package itu.compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteDetailsService {

    @Autowired
    private PosteDetailsRepository posteDetailsRepository;

    // Méthode pour récupérer tous les détails des postes
    public List<PosteDetails> getAllinSecteur(Long idSecteur) {
        return posteDetailsRepository.getPosteDetails(idSecteur);
    }

    /*public Integer getUserSecteur(Integer idUtilisateur) {
        return posteDetailsRepository.getUserSecteur(idUtilisateur);
    }*/

    public PosteDetails getAllDetailsPoste(Long idPoste) {
        return posteDetailsRepository.getPosteDetail(idPoste);
    }

    public List<String> getPositifx(Long idUser,Long idPoste){
        return posteDetailsRepository.getPositifxx(idUser,idPoste);
    }

    public String[] getPositif(Long userId, Long posteId) {
        return posteDetailsRepository.getPositif(userId, posteId);
    }

    public String[] getNegatif(Long idUser,Long idPoste){
        return posteDetailsRepository.getNegatif(idUser,idPoste);
    }

    // Méthode pour calculer la compatibilité entre un poste et un utilisateur
<<<<<<< HEAD

    public List<PosteDetails> searchPostes(String title, Long diplome, Integer secteur, Long competence, Integer ageMin, Integer ageMax, Double salaireMin, Double salaireMax, Integer distance, Integer anneeExperience) {
=======
    public List<PosteDetails> searchPostes(String title, Long diplome, Integer secteur, String competence, Integer ageMin, Integer ageMax, Double salaireMin, Double salaireMax, Integer distance, Integer anneeExperience) {
>>>>>>> Thomis
        Specification<PosteDetails> spec = Specification.where(PosteDetailsSpecifications.withTitre(title))
                .and(PosteDetailsSpecifications.withIdDiplome(diplome))
                .and(PosteDetailsSpecifications.withSecteur(secteur))
                .and(PosteDetailsSpecifications.withCompetence(competence))
                .and(PosteDetailsSpecifications.withAgeRange(ageMin, ageMax))
                .and(PosteDetailsSpecifications.withSalaireRange(salaireMin, salaireMax))
                .and(PosteDetailsSpecifications.withDistance(distance))
                .and(PosteDetailsSpecifications.withAnneeExperience(anneeExperience));

        return posteDetailsRepository.findAll(spec);
    }
}
