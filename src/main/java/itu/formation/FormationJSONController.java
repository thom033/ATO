package itu.formation;

import org.springframework.web.bind.annotation.RestController;

import itu.diplome.DiplomeRepository;
import itu.diplome.Diplome;
import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FormationJSONController {
    @Autowired
    FormationRepository formationRepository;

    @Autowired
    DiplomeRepository diplomeRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    @GetMapping("/formation/liste")
    public List<Formation> liste(HttpSession session) {
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return formationRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/formation/diplome")
    public List<Diplome> listeDiplomes(HttpSession session) {
        return diplomeRepository.findAll();
    }

    @PostMapping("/formation/insert")
    public List<Formation> insert(@RequestBody Formation formation,HttpSession session) {
        formationRepository.save(formation);
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return formationRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/formation/delete")
    public List<Formation> delete(@RequestParam("idFormation") Long idFormation,HttpSession session) {
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        formationRepository.deleteById(idFormation);
        return formationRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/formation/information")
    public Formation getUtilisateur(@RequestParam("idFormation") Long idFormation) {
        return formationRepository.findById(idFormation).get();
    }
    
    @PostMapping("/formation/update")
    public List<Formation> modifier(@RequestBody Formation formation,HttpSession session) {
        formationRepository.save(formation);
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        utilisateur=utilisateurRepository.findById(utilisateur.getId()).get();
        session.setAttribute("utilisateur", utilisateur);
        return formationRepository.findByUtilisateurId(utilisateur.getId());
    }
    
}
