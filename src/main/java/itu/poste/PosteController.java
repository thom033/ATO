package itu.poste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.compatibilite.PosteDetails;
import itu.compatibilite.PosteDetailsRepository;

@Controller
public class PosteController {

    @Autowired
    PosteDetailsRepository posteDetailsRepository;

    @Autowired
    PosteRepository posteRepository;

    @GetMapping("/admin/supprimer/{idPoste}")
    public String getMethodName(@PathVariable("idPoste") String idPoste) {
        PosteDetails posteDetails = posteDetailsRepository.findById(Long.valueOf(idPoste)).get();
        Poste poste = posteRepository.findById(posteDetails.getIdPoste()).get();
        posteRepository.delete(poste);

        // ModelAndView mv = new ModelAndView("admin/template");
        // mv.addObject("page", "acceuil/index2.jsp");
        // return mv;
        return "redirect:/admin/acceuil";
    }

}
