package itu.postulation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.Compatibilite.PosteDetails;
import itu.Compatibilite.PosteDetailsRepository;
import itu.Compatibilite.PosteDetailsService;
import itu.Compatibilite.ResultAcceuilRepository;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@Controller
public class PostulationController {

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    @Autowired
    PostulationRepository postulationRepository;

    @Autowired
    PosteDetailsRepository posteDetailsRepository;

    @GetMapping("/postuler/{idPoste}")
    public String getMethodName(@PathVariable("idPoste") String idTravail, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        Postulation postulation = new Postulation();

        PosteDetails posteDetails = posteDetailsRepository
                .findById(Long.valueOf(idTravail)).orElseThrow(() -> new RuntimeException("PosteDetails not found"));

        postulation.setDate(LocalDateTime.now());
        postulation.setPoste(posteDetails);
        postulation.setUtilisateur(utilisateur);

        postulationRepository.save(postulation);
        return "redirect:/notification/index";
    }

    @GetMapping("/admin/postulation")
    public ModelAndView getMethodName() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "admin/postulation/index");
        return mv;
    }

}
