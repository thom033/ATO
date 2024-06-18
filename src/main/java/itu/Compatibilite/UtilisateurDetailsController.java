package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;

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

    /*@GetMapping("/acceuilxxl")
    public ModelAndView calculateCompatibility() {
        double[] compatibility = utilisateurDetails.ListCompatibility(posteDetailsRepository.getPosteDetails());
        ModelAndView mv = new ModelAndView("/template");
        String pages = "acceuil/index";
        mv.addObject("compatibility", compatibility);
        mv.addObject("posteDetails", posteDetailsRepository.getPosteDetails());

        mv.addObject("page", pages);

        // Debug log to check the value
        System.out.println("Pages value: " + pages);
        return mv;
    }*/
}
