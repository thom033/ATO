package itu.experience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import itu.secteur.Secteur;
import itu.secteur.SecteurRepository;
import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ExperienceJSONController {
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SecteurRepository secteurRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    @GetMapping("/experience/liste")
    public List<Experience> liste(HttpSession session) {
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return experienceRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/experience/secteur")
    public List<Secteur> listeSecteurs(HttpSession session) {
        return secteurRepository.findAll();
    }

    @PostMapping("/experience/insert")
    public List<Experience> insert(@RequestBody Experience experience,HttpSession session) {
        experienceRepository.save(experience);
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return experienceRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/experience/delete")
    public List<Experience> delete(@RequestParam("idExperience") Long idExperience,HttpSession session) {
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        experienceRepository.deleteById(idExperience);
        return experienceRepository.findByUtilisateurId(utilisateur.getId());
    }

    @GetMapping("/experience/information")
    public Experience getUtilisateur(@RequestParam("idExperience") Long idExperience) {
        return experienceRepository.findById(idExperience).get();
    }
    
    @PostMapping("/experience/update")
    public List<Experience> modifier(@RequestBody Experience experience,HttpSession session) {
        experienceRepository.save(experience);
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        utilisateur=utilisateurRepository.findById(utilisateur.getId()).get();
        session.setAttribute("utilisateur", utilisateur);
        return experienceRepository.findByUtilisateurId(utilisateur.getId());
    }
}
