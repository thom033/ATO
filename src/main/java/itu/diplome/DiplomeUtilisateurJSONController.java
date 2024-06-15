package itu.diplome;

import java.util.List;
import java.util.HashMap;

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

    @Autowired
    DiplomeRepository diplomeRepository;
    
    @GetMapping("/diplomeUtilisateur/liste")
    public HashMap<String,Object> liste(HttpSession session) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        map.put("diplomeUtilisateurs", diplomeUtilisateurRepository.findByUtilisateurId(utilisateur.getId()));
        map.put("diplomeExists",diplomeRepository.findAll());
        return map;
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
    public List<DiplomeUtilisateur> modifier(@RequestBody DiplomeUtilisateur diplomeUtilisateur) {
        diplomeUtilisateurRepository.deleteById(diplomeUtilisateur.getId());
        //diplomeUtilisateurRepository.save(diplomeUtilisateur);
        return diplomeUtilisateurRepository.findByUtilisateurId(diplomeUtilisateur.getUtilisateur().getId());
    }
}
