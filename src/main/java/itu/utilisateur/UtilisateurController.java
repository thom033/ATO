package itu.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    public ModelAndView splashscreen() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "splashScreen/index.jsp");
        return mv;
    }

    @GetMapping("/utilisateur/deconnexion")
    public ModelAndView deconnexion() {
        httpSession.removeAttribute("utilisateur");
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "splashScreen/index.jsp");
        return mv;
    }

    @GetMapping("/login")
    public String getMethodName() {
        return "login/login-register";
    }

    @GetMapping("/utilisateur/liste")
    public String lister(Model model) {
        model.addAttribute("listeUtilisateur", utilisateurRepository.getUtilisateur("Do", "do"));
        return "splashScreen/index";
    }

    @PostMapping("/login/test")
    public ModelAndView verificationLogin(@RequestParam HashMap<String, Object> login) {
        boolean validite = true;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail((String) login.get("mail"));
        utilisateur.setMotdepasse((String) login.get("mdp"));

        List<Utilisateur> recherche = utilisateurRepository.getUtilisateur(utilisateur.getMail(),
                utilisateur.getMotdepasse());
        validite = recherche.size() == 1;

        if (validite) {
            ModelAndView mv = new ModelAndView("template");

            Utilisateur user = recherche.get(0);
            httpSession.setAttribute("utilisateur", user);

            mv.addObject("utilisateur", user);
            mv.addObject("page", "splashScreen/index.jsp");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("login/login-register");
            return mv;
        }
    }

    @PostMapping("/utilisateur/inscription")
    public String inscription(@RequestParam HashMap<String, Object> login) {
        Utilisateur utilisateur = new Utilisateur();
        try {
            utilisateur.setNom((String) login.get("nom"));
            utilisateur.setPrenom((String) login.get("prenom"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        utilisateur.setMail((String) login.get("mail"));
        utilisateur.setMotdepasse((String) login.get("mdp"));

        utilisateurRepository.save(utilisateur);

        return "login/login-register";
    }

<<<<<<< Updated upstream
=======
    @GetMapping("/utilisateur/profil")
    public ModelAndView profil() {
        ModelAndView model = new ModelAndView("template");
        Utilisateur user = (Utilisateur) httpSession.getAttribute("utilisateur");
        List<Experience> experiences = new ArrayList<>();
        List<Diplome> diplomes = new ArrayList<>();
        List<Competence> competences = new ArrayList<>();
        List<Secteur> secteurs = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        Argent argentUser = new Argent();

        if (user != null) {
            experiences = experienceRepository.findByUtilisateurId(user.getId());
            List<DiplomeUtilisateur> diplomeUtilisateurs = diplomeUtilisateurRepository.findByUtilisateurId(user.getId());
            for (DiplomeUtilisateur du : diplomeUtilisateurs) {
                diplomes.add(du.getDiplome());
                List<SecteurDiplome> secteurDiplome = secteurDiplomeRepository.findByDiplomeId(du.getDiplome().getId());
                for (SecteurDiplome sd : secteurDiplome) {
                    secteurs.add(sd.getSecteur());
                }
            }
            List<CompetenceUtilisateur> competencesUtilisateurs = competenceUtilisateurRepository.findByUtilisateurId(user.getId());
            for (CompetenceUtilisateur cu : competencesUtilisateurs) {
                competences.add(cu.getCompetence());
            }
            List<UtilisateurContact> usercontacts = utilisateurContactRepository.findByUtilisateurId(user.getId());
            for (UtilisateurContact uc : usercontacts) {
                contacts.add(uc.getContact());
            }

            argentUser = argentRepository.getArgentUser(user.getId());
        }

        else{     
            ModelAndView mv = new ModelAndView("login/login-register");
            return mv;
        }

        model.addObject("utilisateur", user);
        model.addObject("experiences", experiences);
        model.addObject("diplomes", diplomes);
        model.addObject("competences", competences);
        model.addObject("secteurs", secteurs);
        model.addObject("argent", argentUser);   
        model.addObject("contacts", contacts);         
        model.addObject("page", "profil/profil.jsp");

        return model;
    }
    @GetMapping("/utilisateur/modify")
    public ModelAndView modify() {
        ModelAndView mv=new ModelAndView("template");
        mv.addObject("page", "profil/modify.jsp");
        return mv;
    }
    
    @GetMapping("/utilisateur/diplome")
    public ModelAndView modifyDiplome() {
        ModelAndView mv=new ModelAndView("template");
        Utilisateur utilisateur=(Utilisateur)httpSession.getAttribute("utilisateur");
        mv.addObject("utilisateur", utilisateur);
        mv.addObject("page", "profil/modifyDiplome.jsp");
        return mv;
    }
    
>>>>>>> Stashed changes
}
