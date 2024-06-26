package itu.achat;

import java.util.List;

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

    @Autowired
    private NombrePromotionRepository nombrePromotionRepository; 
    
    @GetMapping("/achat")
    public ModelAndView getPageAchat(@RequestParam(name = "type", required = false, defaultValue = "0") int type,
    @RequestParam(name = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("template");
        Double prix_point = argentRepository.getPrixPoint();
        NombrePromotion nbr = nombrePromotionRepository.getPromotionActuel();
        mv.addObject("type", type);
        if (error != null) {
            mv.addObject("error", error);
        }
        mv.addObject("page", "achat/achat");
        mv.addObject("prix", prix_point);
        mv.addObject("promotion", nbr);

        return mv;
    }

    @GetMapping("/utilisateur/achat")
    public RedirectView achatPointUtilisateur(
        @RequestParam(name = "quantite", required = false, defaultValue = "0") int quantite,
        @RequestParam(name = "reduction", required = false, defaultValue = "") String reduction) {

        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
        RedirectView redirectView = new RedirectView();

        Double prix_point = argentRepository.getPrixPoint();

        if (utilisateur != null && quantite > 0) {
            double montantTotal;

            if (reduction != null && !reduction.isEmpty()) {
                if (quantite == 5) {
                    montantTotal = (prix_point-((prix_point * 4)/100))*5;
                } else {
                    montantTotal = (prix_point-((prix_point * 8)/100))*10;
                }
            } else {
                montantTotal = quantite * prix_point;
            }

            Argent arg = argentRepository.getArgentUser(utilisateur.getId());

            if (arg.getSolde() < montantTotal) {
                redirectView.setUrl("/achat?error=Votre + Solde + est + insuffisant");
                return redirectView;
            }
            else{
                utilisateur.setPoint(utilisateur.getPoint() + quantite);
                utilisateurRepository.updatePoints(utilisateur.getId(), quantite);
                argentRepository.updateArgentUser(utilisateur.getId(), montantTotal);
                argentRepository.insertAchat(utilisateur.getId(), quantite);
                // Enregistrer l'utilisateur mis à jour dans la session
                httpSession.setAttribute("utilisateur", utilisateur);
                redirectView.setUrl("/utilisateur/profil");
            }
        }
        else{
            redirectView.setUrl("/achat?error=Quantite invalide");
            return redirectView;
        }

        return redirectView;
    }

    @GetMapping("/utilisateur/solde")
    public RedirectView rechargeSoldeUtilisateur(
        @RequestParam(name = "valeur", required = false, defaultValue = "0") double montant,
        @RequestParam(name = "reduction", required = false, defaultValue = "") String reduction) {

        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
        RedirectView redirectView = new RedirectView();

        argentRepository.rechargeSoldeUser(utilisateur.getId(), montant);
        // Enregistrer l'utilisateur mis à jour dans la session
        httpSession.setAttribute("utilisateur", utilisateur);
        redirectView.setUrl("/utilisateur/profil");

        return redirectView;
    }
}

