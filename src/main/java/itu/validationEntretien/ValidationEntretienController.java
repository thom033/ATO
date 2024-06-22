package itu.validationEntretien;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValidationEntretienController {
    // @GetMapping("/admin/entretien/encours")
    // public ModelAndView enCours() {
    // ModelAndView mv = new ModelAndView("admin/template");
    // mv.addObject("page", "entretien/entretienEnCours.jsp");
    // return mv;
    // }

    @GetMapping("/admin/validation/entretien/{idEntretien}")
    public ModelAndView validerEntretien(@PathVariable("idNotification") String idNotification) {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("succes", "Validation d'entretien effectué");
        mv.addObject("page", "entretien/entretienEnCours.jsp");
        return mv;
    }

}
