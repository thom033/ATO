package itu.achat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class AchatController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UtilisateurRepository utilisateurRepository; 

    @Autowired
    private ArgentRepository argentRepository; 
    
    @GetMapping("/achat")
    public ModelAndView getPageAchat() {
        ModelAndView mv = new ModelAndView("achat/achat");

        return mv;
    }

    @GetMapping("/utilisateur/achat")
    public RedirectView achatPointUtilisateur(
        @RequestParam(name = "quantite", required = false, defaultValue = "0") int quantite,
        @RequestParam(name = "reduction", required = false, defaultValue = "") String reduction) {

        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");

        if (utilisateur != null && quantite > 0) {
            double montantTotal;

            if (reduction != null && !reduction.isEmpty()) {
                if (quantite == 5) {
                    montantTotal = 24000;
                } else {
                    montantTotal = 48000;
                }
            } else {
                montantTotal = quantite * 5000;
            }

            utilisateur.setPoint(utilisateur.getPoint() + quantite);

            utilisateurRepository.updatePoints(utilisateur.getIdUser(), quantite);
            argentRepository.updateArgentUser(utilisateur.getIdUser(), montantTotal);

            // Enregistrer l'utilisateur mis à jour dans la session
            httpSession.setAttribute("utilisateur", utilisateur);
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/utilisateur/profil");
        return redirectView;
    }
}

