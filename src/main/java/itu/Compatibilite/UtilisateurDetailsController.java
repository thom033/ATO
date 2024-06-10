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
    UtilisateurDetailsRepository utilisateurRepository;
@Autowired
PosteDetailsRepository posteDetailsRepository;
    @Autowired
    HttpSession httpSession;
    @Autowired
    private UtilisateurDetails utilisateurDetails;

    @GetMapping("/acceuil")
    public ModelAndView calculateCompatibility() {
        double[] compatibility = utilisateurDetails.ListCompatibility(posteDetailsRepository.getPosteDetails());
        ModelAndView mv = new ModelAndView("acceuil/index");

        mv.addObject("compatibility", compatibility);
        mv.addObject("posteDetails", posteDetailsRepository.getPosteDetails());
        return mv;
    }

}
