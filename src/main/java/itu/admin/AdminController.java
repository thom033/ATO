package itu.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.faq.QuestionRepository;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    QuestionRepository questionRepository;

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
        Utilisateur u = new Utilisateur();
        String hashMdp = u.MD5((String) login.get("mdp"));
        admin.setMotDePasse(hashMdp);
        
        List<Admin> recherche = adminRepository.getAdmin(admin.getMail(),
                admin.getMotDePasse());
        boolean validite = recherche.size() == 1;

        if (validite) {
            ModelAndView mv = new ModelAndView("admin/template");

            admin = recherche.get(0);
            httpSession.setAttribute("administrateur", admin);

            mv.setViewName("redirect:/admin/dashboard");
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

    @GetMapping("/admin/dashboard")
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("statistiqueQuestion", questionRepository.getStatistiqueQuestion());
        mv.addObject("page", "dashboard/index.jsp");
        return mv;
    }

    @GetMapping("/admin/dashboard/statistique/point")
    public ModelAndView getStatistiquePoint() {
        ModelAndView mv = new ModelAndView("admin/dashboard/statistique/point");
        return mv;
    }

    @GetMapping("/admin/dashboard/statistique/embauche")
    public ModelAndView getStatistiqueEntretien() {
        ModelAndView mv = new ModelAndView("admin/dashboard/statistique/embauche");
        return mv;
    }

    @GetMapping("/admin/dashboard/statistique/secteur")
    public ModelAndView getStatistiqueSecteur() {
        ModelAndView mv = new ModelAndView("admin/dashboard/statistique/secteur");
        return mv;
    }

    @GetMapping("/admin/dashboard/statistique/monnaie")
    public ModelAndView getStatistiqueMonnaie() {
        ModelAndView mv = new ModelAndView("admin/dashboard/statistique/monnaie");
        return mv;
    }

    @GetMapping("/admin/dashboard/prix_point/changer")
    public ModelAndView updatePrice() {
        ModelAndView mv = new ModelAndView("admin/dashboard/change_prix_point");
        return mv;
    }

    @GetMapping("/admin/dashboard/question/delete")
    public String deleteQuestion() {
        questionRepository.deleteHistorique();
        return "redirect:/admin/dashboard#!/point";
    }

}
