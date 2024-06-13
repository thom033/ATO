package itu.utilisateur;

import org.springframework.web.bind.annotation.RestController;

import itu.competence.CompetenceUtilisateurRepository;
import itu.contact.UtilisateurContactRepository;
import itu.diplome.DiplomeUtilisateurRepository;
import itu.experience.ExperienceRepository;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UtilisateurJSONController {
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    DiplomeUtilisateurRepository diplomeUtilisateurRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    CompetenceUtilisateurRepository competenceUtilisateurRepository;

    @Autowired
    UtilisateurContactRepository utilisateurContactRepository;

    @GetMapping("/utilisateur/parametre/modify")
    public HashMap<String,Object> parametreGlobal(HttpSession session) {
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        //Utilisateur utilisateur=utilisateurRepository.findById(idUtilisateur).get();
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        hashMap.put("utilisateur",utilisateur);
        hashMap.put("diplome",diplomeUtilisateurRepository.findByUtilisateurId(utilisateur.getId()));
        hashMap.put("contact",utilisateurContactRepository.findByUtilisateurId(utilisateur.getId()));
        hashMap.put("experience",experienceRepository.findByUtilisateurId(utilisateur.getId()));
        return hashMap;
    }
    
}
