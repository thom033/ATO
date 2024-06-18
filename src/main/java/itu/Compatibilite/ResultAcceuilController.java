package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import itu.utilisateur.Utilisateur;
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
        Utilisateur user = (Utilisateur) httpSession.getAttribute("utilisateur");
        Long userSecteur = resultAcceuilService.getUserSecteur(user.getId());
        mv.addObject("data", resultAcceuilService.getAllResults(user.getId(),userSecteur));
        List<ResultAcceuil> rs = resultAcceuilService.getAllResults(user.getId(),userSecteur);
        /*for (int i = 0; i < resultAcceuilService.getAllResults(user.getId(),userSecteur).size(); i++) {
            System.out.println("Nom entreprise "+ rs.get(i).getEntrepriseNom());
        }*/

        mv.addObject("page", pages);

        return mv;
    }
}
