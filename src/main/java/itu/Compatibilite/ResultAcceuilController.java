package itu.compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
public class ResultAcceuilController {

    @Autowired
    ResultAcceuilService resultAcceuilService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/acceuil")
    public ModelAndView calculateCompatibility() {
        ModelAndView mv = new ModelAndView("/template");
        String pages = "acceuil/index";
        mv.addObject("data", resultAcceuilService.getAllResults());

        mv.addObject("page", pages);

        return mv;
    }
}
