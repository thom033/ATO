package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Integer getUserSecteur(Integer idUtilisateur) {
        return posteDetailsRepository.getUserSecteur(idUtilisateur);
    }

    // Méthode pour calculer la compatibilité entre un poste et un utilisateur
}
