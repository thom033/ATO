package itu.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/admin/index")
    public String index() {
        return "admin/index";
    }

    @PostMapping("/admin/login")
    public ModelAndView login(@RequestParam HashMap<String, Object> login) {
        Admin admin = new Admin();
        admin.setMail((String) login.get("mail"));
        admin.setMotDePasse((String) login.get("mdp"));

        List<Admin> recherche = adminRepository.getAdmin(admin.getMail(),
                admin.getMotDePasse());
        boolean validite = recherche.size() == 1;

        if (validite) {
            ModelAndView mv = new ModelAndView("admin/template");

            admin = recherche.get(0);
            httpSession.setAttribute("administrateur", admin);

            mv.addObject("administrateur", admin);
            mv.addObject("page", "crud/index.jsp");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("/admin/index");
            return mv;
        }
    }

    @GetMapping("/admin/CRUD")
    public ModelAndView crud() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/admin.jsp");
        return mv;
    }

    @GetMapping("/diplome/crud")
    public ModelAndView crudDiplome() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/diplome.jsp");
        return mv;
    }

    @GetMapping("/admin/poste")
    public ModelAndView getMethodName() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "postulation/insertPost.jsp");
        return mv;
    }
    
    
}
