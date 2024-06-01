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

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/")
    public String loginPage() {
        return "login/login-register";
    }

    @GetMapping("/utilisateur/liste")
    public String getMethodName(Model model) {
        model.addAttribute("listeUtilisateur", utilisateurRepository.getUtilisateur("Do", "do"));
        return "splashScreen/index";
    }

    @PostMapping("/login/test")
    public String postMethodName(@RequestParam HashMap<String, Object> login) {
        boolean validite = true;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail((String) login.get("mail"));
        utilisateur.setMotdepasse((String) login.get("mdp"));

        List<Utilisateur> recherche = utilisateurRepository.getUtilisateur(utilisateur.getMail(),
                utilisateur.getMotdepasse());
        validite = recherche.size() == 1;

        if (validite) {
            return "splashScreen/splash";
        } else {
            return "login/login-register";
        }
    }

}