package itu.compatibilite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.contact.Contact;
import itu.contact.EntrepriseContact;
import itu.contact.EntrepriseContactRepository;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@Controller
public class PosteDetailsController {
    @Autowired
    PosteDetailsService posteDetailsService;

    @Autowired
    EntrepriseContactRepository entrepriseContactRepository;

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    @Autowired
    ResultAcceuilService resultAcceuilService;

    /*
     * @GetMapping("/postedetails")
     * public String lister(Model model) {
     * List<PosteDetails> listPost = posteDetailsService.getAllinSecteur();
     * model.addAttribute("listPost", listPost);
     * model.addAttribute("isEmpty", listPost.isEmpty());
     * return "test";
     * }
     */

    @GetMapping("/compatibility-poste/{idPoste}")
    public ModelAndView detailPoste(@PathVariable Long idPoste, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("/template");
        String pages = "acceuil/compatibilite";
        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
        String[] positifBase = posteDetailsService.getPositif(utilisateur.getId(), idPoste);
        String[] positif = ResultAcceuil.splitByComma(positifBase[0]);
        String[] NegatifBase = posteDetailsService.getNegatif(utilisateur.getId(), idPoste);
        String[] negatif = ResultAcceuil.splitByComma(NegatifBase[0]);

        mv.addObject("data", resultAcceuilService.getResult(idPoste));
        mv.addObject("positif", positif);
        mv.addObject("negatif", negatif);

        mv.addObject("page", pages);

        return mv;
    }

    @GetMapping("/postetest")
    public String test(Model model) {
        model.addAttribute("listPost", "CC TEST TEST");
        return "test";
    }

    @GetMapping("/poste/details")
    public ModelAndView rechargeSoldeUtilisateur(
            @RequestParam(name = "idPoste", required = false, defaultValue = "0") Long IdPoste,
            HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("template");
        Utilisateur user = (Utilisateur) httpSession.getAttribute("utilisateur");

        PosteDetails pd = posteDetailsService.getAllDetailsPoste(IdPoste);
        List<Contact> contacts = new ArrayList<>();

        List<EntrepriseContact> entreprisecontacts = entrepriseContactRepository
                .findByEntrepriseId(pd.getPosteEntreprise());
        for (EntrepriseContact uc : entreprisecontacts) {
            contacts.add(uc.getContact());
        }

        double pourcentage = resultAcceuilRepository.getResultAcceuilsByIdPosteUser(user.getId(), IdPoste);

        mv.addObject("details", pd);
        mv.addObject("contacts", contacts);
        mv.addObject("pourcentage", pourcentage);

        mv.addObject("page", "poste-details/details");

        return mv;
    }

    @GetMapping("/poste/details/show")
    public ModelAndView voirPoste(@RequestParam(name = "idPoste", required = false, defaultValue = "0") String IdPoste,
            HttpSession session) {
        ModelAndView mv = new ModelAndView("template");

        Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
        if (user == null) {
            mv.setViewName("login/login-register");
            session.setAttribute("nextPage", "/poste/details/show?idPoste=" + IdPoste);
            return mv;
        }

        PosteDetails pd = posteDetailsService.getAllDetailsPoste(Long.valueOf(IdPoste));
        List<Contact> contacts = new ArrayList<>();

        List<EntrepriseContact> entreprisecontacts = entrepriseContactRepository
                .findByEntrepriseId(pd.getPosteEntreprise());
        for (EntrepriseContact uc : entreprisecontacts) {
            contacts.add(uc.getContact());
        }

        double pourcentage = resultAcceuilRepository.getResultAcceuilsByIdPosteUser(user.getId(),
                Long.valueOf(IdPoste));

        mv.addObject("details", pd);
        mv.addObject("contacts", contacts);
        mv.addObject("pourcentage", pourcentage);

        mv.addObject("page", "poste-details/details");

        return mv;
    }
}
