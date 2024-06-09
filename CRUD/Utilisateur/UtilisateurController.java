package itu.utilisateur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilisateurController {

    @GetMapping("/utilisateur/CRUD")
    public ModelAndView crud() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/utilisateur.jsp");
        return mv;
    }
}
