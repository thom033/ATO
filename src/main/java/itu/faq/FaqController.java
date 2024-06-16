package itu.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@Controller
public class FaqController {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    HistoriqueQuestionRepository historiqueQuestionRepository;

    @GetMapping("/faq/index")
    public ModelAndView getMethodName() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "faq/faq");
        return mv;
    }

}
