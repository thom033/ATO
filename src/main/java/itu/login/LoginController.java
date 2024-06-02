package itu.login;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import itu.user.Utilisateur;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {
        return "login/login-register";
    }

    @PostMapping("/login/test")
    public String postMethodName(@RequestParam HashMap<String, Object> login) {
        boolean validite = true;
        Utilisateur utilisateur = new Utilisateur(0, null, null, null, null, null, null, null, null, null, 0, 0, 0,
                null);
        utilisateur.setMail((String) login.get("mail"));
        utilisateur.setMotdepasse((String) login.get("mdp"));

        if (validite) {
            return "splashScreen/splash";
        } else {
            return "login/login-register";
        }
    }
 
}
