package itu.entreprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntrepriseController {
    @GetMapping("/entreprise/CRUD")
    public ModelAndView crud() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/entreprise.jsp");
        return mv;
    }
}
