package itu.diplome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.diplome.DiplomeUtilisateur;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@RestController
public class DiplomeUtilisateurJSONController {
    @Autowired
    DiplomeUtilisateurRepository diplomeUtilisateurRepository;

    @Autowired
    DiplomeUtilisateurIdRepository diplomeUtilisateurIdRepository;
    
    @GetMapping("/diplomeUtilisateur/liste")
    public List<DiplomeUtilisateur> liste(HttpSession session) {
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return diplomeUtilisateurRepository.findByUtilisateurId(utilisateur.getId());
    }

    @PostMapping("/diplomeUtilisateur/insert")
    public List<DiplomeUtilisateur> insert(@RequestBody DiplomeUtilisateur diplomeUtilisateur) {
        diplomeUtilisateurRepository.save(diplomeUtilisateur);
        return diplomeUtilisateurRepository.findByUtilisateurId(diplomeUtilisateur.getUtilisateur().getId());
    }

    @GetMapping("/diplomeUtilisateur/delete")
    public List<DiplomeUtilisateur> delete(@RequestParam("idDiplomeUtilisateur") Long id,HttpSession session) {
        diplomeUtilisateurIdRepository.deleteById(id);
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return diplomeUtilisateurRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/diplomeUtilisateur/information")
    public DiplomeUtilisateur getUtilisateur(@RequestParam("idDiplomeUtilisateur") DiplomeUtilisateurId diplomeUtilisateurId) {
        return diplomeUtilisateurRepository.findById(diplomeUtilisateurId).get();
    }
    
    @PostMapping("/diplomeUtilisateur/update")
    public List<DiplomeUtilisateur> modifier(@RequestBody DiplomeUtilisateur diplomeUtilisateur) {
        diplomeUtilisateurRepository.save(diplomeUtilisateur);
        return diplomeUtilisateurRepository.findAll();
    }
}
