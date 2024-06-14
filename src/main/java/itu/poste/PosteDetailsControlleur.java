package itu.poste;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PosteDetailsControlleur {
    
    @Autowired
    private PosteDetailsRepository posteDetailsRepository; 

    @GetMapping("/poste/details")
    public ModelAndView profil(@RequestParam(name = "idPoste") Long idPoste) {
        ModelAndView model = new ModelAndView("template");

        // PosteDetails postd = posteDetailsRepository.getDetailsPoste(idPoste);
        // model.addObject("details", postd);
        model.addObject("page", "poste-details/details.jsp");

        return model;
    }

}
