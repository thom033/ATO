package itu.diplome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class DiplomeUtilisateurService {
    @Autowired
    private DiplomeRepository diplomeRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    // @Transactional
    // public void removeUtilisateurFromDiplome(Long idUtilisateur, Long idDiplome) {
    //     Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
    //         .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        
    //     Diplome diplome = diplomeRepository.findById(idDiplome)
    //         .orElseThrow(() -> new EntityNotFoundException("Diplome not found"));

    //     utilisateur.getDiplomes().remove(diplome);
    //     diplome.getUtilisateurs().remove(utilisateur);

    //     utilisateurRepository.save(utilisateur);
    //     diplomeRepository.save(diplome);
    // }
    // @Transactional
    // public void addDiplomeToUtilisateur(Long idUtilisateur, Long idDiplome) {
    //     Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
    //         .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        
    //     Diplome diplome = diplomeRepository.findById(idDiplome)
    //         .orElseThrow(() -> new EntityNotFoundException("Diplome not found"));

    //     utilisateur.getDiplomes().add(diplome);
    //     diplome.getUtilisateurs().add(utilisateur);

    //     utilisateurRepository.save(utilisateur);
    //     diplomeRepository.save(diplome);
    // }
    // @Transactional
    // public void replaceDiplomeForUtilisateur(Long utilisateurId, Long oldDiplomeId, Long newDiplomeId) {
    //     Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
    //         .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));

    //     Diplome oldDiplome = diplomeRepository.findById(oldDiplomeId)
    //         .orElseThrow(() -> new EntityNotFoundException("Old diplome not found"));

    //     Diplome newDiplome = diplomeRepository.findById(newDiplomeId)
    //         .orElseThrow(() -> new EntityNotFoundException("New diplome not found"));

    //     utilisateur.getDiplomes().remove(oldDiplome);
    //     oldDiplome.getUtilisateurs().remove(utilisateur);

    //     utilisateur.getDiplomes().add(newDiplome);
    //     newDiplome.getUtilisateurs().add(utilisateur);

    //     utilisateurRepository.save(utilisateur);
    //     diplomeRepository.save(newDiplome);
    // }
}
