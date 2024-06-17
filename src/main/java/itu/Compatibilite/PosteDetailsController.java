package itu.Compatibilite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import itu.contact.Contact;
import itu.contact.EntrepriseContact;
import itu.contact.EntrepriseContactRepository;
import itu.contact.UtilisateurContact;
import itu.contact.UtilisateurContactRepository;
import itu.entreprise.Entreprise;
import itu.utilisateur.Utilisateur;
import itu.utilisateur.UtilisateurRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class PosteDetailsController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    PosteDetailsService posteDetailsService;

    @Autowired
    EntrepriseContactRepository entrepriseContactRepository;

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
    
    @GetMapping("/poste/details")
    public  ModelAndView rechargeSoldeUtilisateur(@RequestParam(name = "idPoste", required = false, defaultValue = "0") Long IdPoste,
    @RequestParam(name = "pourcentage", required = false, defaultValue = "0") double pourcentage) {
        ModelAndView  mv = new  ModelAndView("template");

        PosteDetails pd = posteDetailsService.getAllDetailsPoste(IdPoste);
        List<Contact> contacts = new ArrayList<>();

        List<EntrepriseContact> entreprisecontacts = entrepriseContactRepository.findByEntrepriseId(pd.getPosteEntreprise());
        for (EntrepriseContact uc : entreprisecontacts) {
            contacts.add(uc.getContact());
        }

        mv.addObject("details", pd);
        mv.addObject("contacts", contacts);
        mv.addObject("pourcentage", pourcentage);

        mv.addObject("page", "poste-details/details");

        return  mv;
    }
}
