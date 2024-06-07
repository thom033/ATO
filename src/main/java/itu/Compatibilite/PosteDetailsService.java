package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteDetailsService {

    @Autowired
    private PosteDetailsRepository posteDetailsRepository;

    // Méthode pour récupérer tous les détails des postes
    public List<PosteDetails> getAllinSecteur(int id_secteur) {
        return posteDetailsRepository.getPosteDetails(id_secteur);
    }

    // Méthode pour calculer la compatibilité entre un poste et un utilisateur
}
