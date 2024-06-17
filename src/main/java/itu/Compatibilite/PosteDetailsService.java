package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteDetailsService {

    @Autowired
    private PosteDetailsRepository posteDetailsRepository;

    // Méthode pour récupérer tous les détails des postes
    public List<PosteDetails> getAllinSecteur() {
        return posteDetailsRepository.getPosteDetails();
    }

    public PosteDetails getAllDetailsPoste(Long idPoste) {
        return posteDetailsRepository.getPosteDetails(idPoste);
    }

    // Méthode pour calculer la compatibilité entre un poste et un utilisateur
}
