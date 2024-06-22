package itu.faq;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class QuestionController {


    @GetMapping("/question/crud")
    public ModelAndView crud() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/question.jsp");
        return mv;
    }
    
}
