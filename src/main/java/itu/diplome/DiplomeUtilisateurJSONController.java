package itu.diplome;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.secteur.SecteurDiplome;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@RestController
public class DiplomeUtilisateurJSONController {
    @Autowired
    DiplomeUtilisateurRepository diplomeUtilisateurRepository;

    @Autowired
    DiplomeRepository diplomeRepository;

    private final DiplomeUtilisateurService diplomeUtilisateurService;

    // Injection via le constructeur
    @Autowired
    public DiplomeUtilisateurJSONController(DiplomeUtilisateurService diplomeUtilisateur) {
        this.diplomeUtilisateurService = diplomeUtilisateur;
    }
    
    @GetMapping("/diplomeUtilisateur/liste")
    public List<Diplome> liste(HttpSession session) {
        List<Diplome> diplomes=diplomeRepository.findAllSpecial();
        return diplomes;
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
    public DiplomeUtilisateur getUtilisateur(@RequestParam("idDiplome") Long idDiplome
                                            ,@RequestParam("idUtilisateur") Long idUtilisateur) {
        DiplomeUtilisateurId diplomeUtilisateurId=new DiplomeUtilisateurId(idUtilisateur,idDiplome);
        return diplomeUtilisateurRepository.findById(diplomeUtilisateurId).get();
    }
    
    @PostMapping("/diplomeUtilisateur/update")
    public List<DiplomeUtilisateur> modifier(@RequestBody Map<String, Long> identifiant) {
        Long idOldDiplome=identifiant.get("idOldDiplome");
        Long idNewDiplome=identifiant.get("idNewDiplome");
        Long idUtilisateur=identifiant.get("idUtilisateur");
        //this.diplomeUtilisateurService.replaceDiplomeForUtilisateur(idUtilisateur,idOldDiplome,idNewDiplome);
        //diplomeUtilisateurRepository.save(diplomeUtilisateur);
        return diplomeUtilisateurRepository.findByUtilisateurId(idUtilisateur);
    }
}
