package itu.compatibilite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PosteDetailsController {
    @Autowired
    PosteDetailsRepository posteDetailsRepository;

    @Autowired
    PosteDetailsService posteDetailsService;

    @GetMapping("/postedetails")
public String lister(Model model) {
    List<PosteDetails> listPost = posteDetailsService.getAllinSecteur();
    model.addAttribute("listPost", listPost);
    model.addAttribute("isEmpty", listPost.isEmpty());
    return "test";
}



    @GetMapping("/postetest")
    public String test(Model model) {
        model.addAttribute("listPost", "CC TEST TEST");
        return "test";
    }

    
}
