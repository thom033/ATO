package itu.compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@RestController
public class ResultAcceuilController {

    @Autowired
    ResultAcceuilService resultAcceuilService;

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    @GetMapping("/acceuil")
    public ModelAndView calculateCompatibility(HttpSession session,
            @RequestParam(defaultValue = "0") int pagex,
            @RequestParam(defaultValue = "10") int size) {
        ModelAndView mv = new ModelAndView("/template");

        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            Page<ResultAcceuil> Lra = resultAcceuilService.getPaginatedResults(utilisateur.getId(), pagex, size);
            mv.addObject("data", Lra);
            mv.addObject("page", "acceuil/index");

            System.out.println("size:" + Lra.getSize());
            System.out.println("current pqge:" + Lra.getNumber());
            System.out.println("totalpages:" + Lra.getTotalPages());
        } else {
            session.setAttribute("nextPage", "/acceuil");
            mv.setViewName("login/login-register");
        }

        return mv;
    }
}
