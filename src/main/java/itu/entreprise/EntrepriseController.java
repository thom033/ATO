package itu.entreprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class EntrepriseController {
    @Autowired
    private HttpSession session;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @GetMapping("/entreprise/CRUD")
    public ModelAndView crud() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/entreprise.jsp");
        return mv;
    }

    @GetMapping("/entreprise/contact")
    public ModelAndView update(@RequestParam("idEntreprise") Long idEntreprise) {
        Entreprise entreprise=entrepriseRepository.findById(idEntreprise).get();
        session.setAttribute("entreprise", entreprise);
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/entrepriseContact.jsp");
        return mv;
    }
}
