package itu.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import itu.diplome.Diplome;
import itu.diplome.DiplomeUtilisateur;
import itu.diplome.DiplomeUtilisateurRepository;
import itu.experience.Experience;
import itu.competence.*;
import itu.experience.ExperienceRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    HttpSession httpSession;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    DiplomeUtilisateurRepository diplomeUtilisateurRepository;

    
    @Autowired
    CompetenceRepository competenceRepository;

    @GetMapping("/")
    public ModelAndView splashscreen() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "splashScreen/index.jsp");
        return mv;
    }

    @GetMapping("/utilisateur/deconnexion")
    public ModelAndView deconnexion() {
        httpSession.removeAttribute("utilisateur");
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "splashScreen/index.jsp");
        return mv;
    }

    @GetMapping("/login")
    public String getMethodName() {
        return "login/login-register";
    }

    @GetMapping("/utilisateur/liste")
    public String lister(Model model) {
        model.addAttribute("listeUtilisateur", utilisateurRepository.getUtilisateur("Do", "do"));
        return "splashScreen/index";
    }

    @PostMapping("/login/test")
    public ModelAndView verificationLogin(@RequestParam HashMap<String, Object> login) {
        boolean validite = true;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail((String) login.get("mail"));
        utilisateur.setMotdepasse((String) login.get("mdp"));

        List<Utilisateur> recherche = utilisateurRepository.getUtilisateur(utilisateur.getMail(),
                utilisateur.getMotdepasse());
        validite = recherche.size() == 1;

        if (validite) {
            ModelAndView mv = new ModelAndView("template");

            Utilisateur user = recherche.get(0);
            httpSession.setAttribute("utilisateur", user);

            mv.addObject("utilisateur", user);
            mv.addObject("page", "splashScreen/index.jsp");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("login/login-register");
            return mv;
        }
    }

    @PostMapping("/utilisateur/inscription")
    public String inscription(@RequestParam HashMap<String, Object> login) {
        Utilisateur utilisateur = new Utilisateur();
        try {
            utilisateur.setNom((String) login.get("nom"));
            utilisateur.setPrenom((String) login.get("prenom"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        utilisateur.setMail((String) login.get("mail"));
        utilisateur.setMotdepasse((String) login.get("mdp"));

        utilisateurRepository.save(utilisateur);

        return "login/login-register";
    }

    @GetMapping("/utilisateur/profil")
    public String profil(Model model) {
        Utilisateur user = (Utilisateur) httpSession.getAttribute("utilisateur");
        List<Experience> experiences = new ArrayList<>();
        List<Diplome> diplomes = new ArrayList<>();
        List<Competence> competences = new ArrayList<>();
        int age = 0;

        if (user != null) {
            experiences = experienceRepository.findByUtilisateurId(user.getid());
            List<DiplomeUtilisateur> diplomeUtilisateurs = diplomeUtilisateurRepository.findByUtilisateur(user);
            for (DiplomeUtilisateur du : diplomeUtilisateurs) {
                diplomes.add(du.getDiplome());
            }
            competences = competenceRepository.findByUtilisateurId(user.getid());
            age = user.calculateAge();
        }

        model.addAttribute("utilisateur", user);
        model.addAttribute("experiences", experiences);
        model.addAttribute("diplomes", diplomes);
        model.addAttribute("competences", competences);
        model.addAttribute("age", age);

        return "profil/profil";
    }
    
    
     
}
