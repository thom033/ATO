package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilisateurDetailsController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    HttpSession httpSession;
    @Autowired
    private UtilisateurDetails utilisateurDetails;

    @PostMapping("/compatibility")
    public String calculateCompatibility(@RequestBody PosteDetails[] p, Model model) {
        double[] compatibility = utilisateurDetails.ListCompatibility(p);
        model.addAttribute("compatibility", compatibility);
        return "index"; // Nom de la vue JSP à afficher
    }
    @GetMapping("/acceuil")
    public ModelAndView deconnexion() {
        httpSession.removeAttribute("utilisateur");
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("page", "acceuil/index.jsp");
        return mv;
    }
}
