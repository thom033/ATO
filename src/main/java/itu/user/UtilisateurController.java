package itu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    public String loginPage() {
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
            ModelAndView mv = new ModelAndView("splashScreen/index");

            Utilisateur user = recherche.get(0);
            httpSession.setAttribute("user", user);

            mv.addObject("user", user);
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

}
