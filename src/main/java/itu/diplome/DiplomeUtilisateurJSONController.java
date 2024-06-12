package itu.diplome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@RestController
public class DiplomeUtilisateurJSONController {
    @Autowired
    DiplomeUtilisateurRepository diplomeUtilisateurRepository;
    
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
    public List<DiplomeUtilisateur> delete(@RequestParam("idDiplome") Long idDiplome
                                            ,@RequestParam("idUtilisateur") Long idUtilisateur) {
        DiplomeUtilisateurId diplomeUtilisateurId=new DiplomeUtilisateurId(idUtilisateur,idDiplome);
        diplomeUtilisateurRepository.deleteById(diplomeUtilisateurId);
        return diplomeUtilisateurRepository.findByUtilisateurId(idUtilisateur);
    }

    @GetMapping("/diplomeUtilisateur/information")
    public DiplomeUtilisateur getUtilisateur(@RequestBody DiplomeUtilisateurId diplomeUtilisateurId) {
        return diplomeUtilisateurRepository.findById(diplomeUtilisateurId).get();
    }
    
    @PostMapping("/diplomeUtilisateur/update")
    public List<DiplomeUtilisateur> modifier(@RequestBody DiplomeUtilisateur diplomeUtilisateur) {
        diplomeUtilisateurRepository.save(diplomeUtilisateur);
        return diplomeUtilisateurRepository.findByUtilisateurId(diplomeUtilisateur.getUtilisateur().getId());
    }
}
