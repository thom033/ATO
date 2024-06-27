package itu.compatibilite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.pattern.Util;

import org.springframework.data.domain.Page;

import itu.admin.Admin;
import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

@RestController
public class ResultAcceuilController {

    @Autowired
    ResultAcceuilService resultAcceuilService;

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    PosteDetailsRepository posteDetailsRepository;

    @GetMapping("/acceuil")
    public ModelAndView calculateCompatibility(HttpSession session,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {
        ModelAndView mv = new ModelAndView("/template");
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            mv.setViewName("login/login-register");
            session.setAttribute("nextPage", "/acceuil");
        } else {
            String pages = "acceuil/index";
            Long idUser = utilisateur.getId();
            Long idSector = resultAcceuilService.getUserSecteur(utilisateur.getId());
            List<ResultAcceuil> paginatedResults = resultAcceuilService.getPaginatedResults(idUser, idSector, page,
                    size);
            mv.addObject("data", paginatedResults);
            mv.addObject("page", pages);
            mv.addObject("currentPage", page);
            mv.addObject("totalPages", (int) Math
                    .ceil((double) resultAcceuilService.getResultAcceuil_Secteur_User(idUser, idSector).size() / size));
            mv.addObject("size", size);
            System.out.println("idSector: " + idSector);
            System.out.println("paginatedResults: " + paginatedResults);
            System.out.println("page: " + page);
            System.out.println("size: " + size);
            System.out.println("totalPages: " + (int) Math
                    .ceil((double) resultAcceuilService.getResultAcceuil_Secteur_User(idUser, idSector).size() / size));
        }

        return mv;
    }

    @GetMapping("/admin/acceuil")
    public ModelAndView adminAcceuil(HttpSession session,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {
        ModelAndView mv = new ModelAndView("admin/template");
        Admin admin = (Admin) session.getAttribute("administrateur");
        if (admin == null) {
            mv.setViewName("redirect:/admin/index");
            return mv;
        }

        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            utilisateur = utilisateurRepository.findById(Long.valueOf(1)).get();
            // mv.setViewName("login/login-register");
            // session.setAttribute("nextPage", "/acceuil");
        }
        String pages = "acceuil/index2.jsp";
        Long idUser = utilisateur.getId();
        Long idSector = resultAcceuilService.getUserSecteur(utilisateur.getId());
        List<PosteDetails> paginatedResults = posteDetailsRepository.findAll();
        mv.addObject("data", paginatedResults);
        mv.addObject("page", pages);
        mv.addObject("currentPage", page);
        mv.addObject("totalPages", (int) Math
                .ceil((double) resultAcceuilService.getResultAcceuil_Secteur_User(idUser, idSector).size() / size));
        mv.addObject("size", size);

        return mv;
    }

    // @GetMapping("/acceuil/bestPoint")
    // public ModelAndView DisplayBestPoint(HttpSession session,
    // @RequestParam(defaultValue = "0") int page,
    // @RequestParam(defaultValue = "8") int size) {
    // ModelAndView mv = new ModelAndView("/template");
    // Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
    // if (utilisateur == null) {
    // mv.setViewName("login/login-register");
    // session.setAttribute("nextPage", "/acceuil");
    // }
    // else{
    // String pages = "acceuil/index";
    // Long idUser = utilisateur.getId();
    // Long idSector = resultAcceuilService.getUserSecteur(utilisateur.getId());
    // List<ResultAcceuil> paginatedResults =
    // resultAcceuilService.getPaginatedBestPoint(idUser,page, size);
    // mv.addObject("data", paginatedResults);
    // mv.addObject("page", pages);
    // mv.addObject("currentPage", page);
    // mv.addObject("totalPages", (int) Math.ceil((double)
    // resultAcceuilService.getBestPoint(idUser).size() / size));
    // mv.addObject("size", size);
    // System.out.println("idSector: " + idSector);
    // System.out.println("paginatedResults: " + paginatedResults);
    // System.out.println("page: " + page);
    // System.out.println("size: " + size);
    // System.out.println("totalPages: " + (int) Math.ceil((double)
    // resultAcceuilService.getBestPoint(idUser).size() / size));
    // }

    // return mv;
    // }

}
