package itu.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.achat.Argent;
import itu.achat.ArgentRepository;
import itu.competence.Competence;
import itu.competence.CompetenceUtilisateur;
import itu.competence.CompetenceUtilisateurRepository;
import itu.contact.Contact;
import itu.contact.UtilisateurContact;
import itu.contact.UtilisateurContactRepository;
import itu.diplome.Diplome;
import itu.diplome.DiplomeUtilisateur;
import itu.diplome.DiplomeUtilisateurRepository;
import itu.experience.Experience;
import itu.experience.ExperienceRepository;
import itu.formation.Formation;
import itu.formation.FormationRepository;
import itu.secteur.Secteur;
import itu.secteur.SecteurDiplome;
import itu.secteur.SecteurDiplomeRepository;
import itu.secteur.SecteurRepository;
import itu.secteur.StatistiqueSecteur;
import jakarta.servlet.http.HttpSession;

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ArgentRepository argentRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    DiplomeUtilisateurRepository diplomeUtilisateurRepository;

    @Autowired
    CompetenceUtilisateurRepository competenceUtilisateurRepository;

    @Autowired
    UtilisateurContactRepository utilisateurContactRepository;

    @Autowired
    SecteurDiplomeRepository secteurDiplomeRepository;

    @Autowired
    SecteurRepository secteurRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    public ModelAndView splashscreen() {
        ModelAndView mv = new ModelAndView("template");
        List<StatistiqueSecteur> recep=secteurRepository.getStatistiqueSecteurPosteDispo();
        StatistiqueSecteur[] secteurs=new StatistiqueSecteur[3];
        double pourcentage=0;
        int nbSecteur=0;
        for(int i=0;i<2;i++){
            secteurs[i]=recep.get(i);
            pourcentage+=recep.get(i).getPourcentage();
        }
        for(int i=2;i<recep.size();i++){
            nbSecteur+=recep.get(i).getNbSecteur();
        }
        final double pourcentages=100.0-pourcentage;
        final int nbSecteurs=nbSecteur;
        secteurs[2]=new StatistiqueSecteur() {
            int idSecteur=0;
            int nbSecteur=nbSecteurs;
            double pourcentage=pourcentages;
            String secteur="Autres";
            @Override
            public int getIdSecteur(){
                return idSecteur;
            }
            @Override
            public int getNbSecteur(){
                return nbSecteur;
            }
            @Override
            public double getPourcentage(){
                return pourcentage;
            }
            @Override
            public String getSecteur(){
                return secteur;
            }
        };
        mv.addObject("secteurs",secteurs);
        mv.addObject("page", "splashScreen/index");
        return mv;
    }

    @GetMapping("/utilisateur/deconnexion")
    public ModelAndView deconnexion(HttpSession httpSession) {
        httpSession.removeAttribute("utilisateur");
        ModelAndView mv = new ModelAndView("template");
        List<StatistiqueSecteur> recep=secteurRepository.getStatistiqueSecteurPosteDispo();
        StatistiqueSecteur[] secteurs=new StatistiqueSecteur[3];
        double pourcentage=0;
        int nbSecteur=0;
        for(int i=0;i<2;i++){
            secteurs[i]=recep.get(i);
            pourcentage+=recep.get(i).getPourcentage();
        }
        for(int i=2;i<recep.size();i++){
            nbSecteur+=recep.get(i).getNbSecteur();
        }
        final double pourcentages=100.0-pourcentage;
        final int nbSecteurs=nbSecteur;
        secteurs[2]=new StatistiqueSecteur() {
            int idSecteur=0;
            int nbSecteur=nbSecteurs;
            double pourcentage=pourcentages;
            String secteur="Autres";
            @Override
            public int getIdSecteur(){
                return idSecteur;
            }
            @Override
            public int getNbSecteur(){
                return nbSecteur;
            }
            @Override
            public double getPourcentage(){
                return pourcentage;
            }
            @Override
            public String getSecteur(){
                return secteur;
            }
        };
        mv.addObject("secteurs",secteurs);
        mv.addObject("page", "splashScreen/index");
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
    public String verificationLogin(@RequestParam HashMap<String, Object> login, HttpSession session) {
        boolean validite = true;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail((String) login.get("mail"));
        String hashMdp = utilisateur.MD5((String) login.get("mdp"));
        utilisateur.setMotdepasse(hashMdp);

        List<Utilisateur> recherche = utilisateurRepository.getUtilisateur(utilisateur.getMail(),
                utilisateur.getMotdepasse());
        validite = recherche.size() == 1;

        if (validite) {
            ModelAndView mv = new ModelAndView("template");

            Utilisateur user = recherche.get(0);
            session.setAttribute("utilisateur", user);

            mv.addObject("page", session.getAttribute("nextPage"));
            if (session.getAttribute("nextPage") == null)
                return "redirect:/";

            String nextPage = (String) session.getAttribute("nextPage");
            session.removeAttribute("nextPage");
            return "redirect:" + nextPage;
        } else {
            return "login/login-register";
        }
    }

    @PostMapping("/utilisateur/inscription")
    public String inscription(@RequestParam HashMap<String, Object> login) {
        Utilisateur utilisateur = new Utilisateur();
        Argent argUser = new Argent();
        try {
            utilisateur.setNom((String) login.get("nom"));
            utilisateur.setPrenom((String) login.get("prenom"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        utilisateur.setMail((String) login.get("mail"));
        String hashMdp = utilisateur.MD5((String) login.get("mdp"));
        utilisateur.setMotdepasse(hashMdp);

        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        argUser.setIdUtilisateur(savedUtilisateur.getId());
        argentRepository.save(argUser);

        return "login/login-register";
    }

    @GetMapping("/utilisateur/profil")
    public ModelAndView profil() {
        ModelAndView model = new ModelAndView("template");
        Utilisateur user = (Utilisateur) httpSession.getAttribute("utilisateur");
        List<Experience> experiences = new ArrayList<>();
        List<Formation> formations = new ArrayList<>();
        List<Diplome> diplomes = new ArrayList<>();
        List<Competence> competences = new ArrayList<>();
        List<Secteur> secteurs = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        Argent argentUser = new Argent();

        if (user != null) {
            experiences = experienceRepository.findByUtilisateurId(user.getId());
            formations = formationRepository.findByUtilisateurId(user.getId());
            List<DiplomeUtilisateur> diplomeUtilisateurs = diplomeUtilisateurRepository
                    .findByUtilisateurId(user.getId());
            for (DiplomeUtilisateur du : diplomeUtilisateurs) {
                diplomes.add(du.getDiplome());
                List<SecteurDiplome> secteurDiplome = secteurDiplomeRepository.findByDiplomeId(du.getDiplome().getId());
                for (SecteurDiplome sd : secteurDiplome) {
                    secteurs.add(sd.getSecteur());
                }
            }
            List<CompetenceUtilisateur> competencesUtilisateurs = competenceUtilisateurRepository
                    .findByUtilisateurId(user.getId());
            for (CompetenceUtilisateur cu : competencesUtilisateurs) {
                competences.add(cu.getCompetence());
            }
            List<UtilisateurContact> usercontacts = utilisateurContactRepository.findByUtilisateurId(user.getId());
            for (UtilisateurContact uc : usercontacts) {
                contacts.add(uc.getContact());
            }

            argentUser = argentRepository.getArgentUser(user.getId());
        }

        else {
            ModelAndView mv = new ModelAndView("login/login-register");
            return mv;
        }

        model.addObject("utilisateur", user);
        model.addObject("experiences", experiences);
        model.addObject("formations", formations);
        model.addObject("diplomes", diplomes);
        model.addObject("competences", competences);
        model.addObject("secteurs", secteurs);
        model.addObject("argent", argentUser);
        model.addObject("contacts", contacts);
        model.addObject("page", "profil/profil");

        return model;
    }

    @GetMapping("/admin/utilisateur/profil/{idUtilisateur}")
    public ModelAndView adminAccess(@PathVariable("idUtilisateur") String idUtilisateur) {
        ModelAndView model = new ModelAndView("template");
        Utilisateur user = utilisateurRepository.getById(Long.valueOf(idUtilisateur));
        List<Experience> experiences = new ArrayList<>();
        List<Diplome> diplomes = new ArrayList<>();
        List<Competence> competences = new ArrayList<>();
        List<Secteur> secteurs = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        Argent argentUser = new Argent();

        if (user != null) {
            experiences = experienceRepository.findByUtilisateurId(user.getId());
            List<DiplomeUtilisateur> diplomeUtilisateurs = diplomeUtilisateurRepository
                    .findByUtilisateurId(user.getId());
            for (DiplomeUtilisateur du : diplomeUtilisateurs) {
                diplomes.add(du.getDiplome());
                List<SecteurDiplome> secteurDiplome = secteurDiplomeRepository.findByDiplomeId(du.getDiplome().getId());
                for (SecteurDiplome sd : secteurDiplome) {
                    secteurs.add(sd.getSecteur());
                }
            }
            List<CompetenceUtilisateur> competencesUtilisateurs = competenceUtilisateurRepository
                    .findByUtilisateurId(user.getId());
            for (CompetenceUtilisateur cu : competencesUtilisateurs) {
                competences.add(cu.getCompetence());
            }
            List<UtilisateurContact> usercontacts = utilisateurContactRepository.findByUtilisateurId(user.getId());
            for (UtilisateurContact uc : usercontacts) {
                contacts.add(uc.getContact());
            }

            argentUser = argentRepository.getArgentUser(user.getId());
        }

        else {
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
        model.addObject("page", "profil/profil");

        return model;
    }

    @GetMapping("/utilisateur/parametre")
    public ModelAndView parametre() {
        ModelAndView modelAndView = new ModelAndView("template");
        modelAndView.addObject("page", "profil/modify");
        return modelAndView;
    }

    @GetMapping("/utilisateur/parametre/diplome")
    public ModelAndView parametreDiplome() {
        ModelAndView modelAndView = new ModelAndView("template");
        modelAndView.addObject("page", "profil/modifyDiplome");
        return modelAndView;
    }

    @GetMapping("/utilisateur/parametre/competence")
    public ModelAndView parametreCompetence() {
        ModelAndView modelAndView = new ModelAndView("template");
        modelAndView.addObject("page", "profil/modifyCompetence");
        return modelAndView;
    }

    @GetMapping("/utilisateur/parametre/contact")
    public ModelAndView parametreContact() {
        ModelAndView modelAndView = new ModelAndView("template");
        modelAndView.addObject("page", "profil/modifyContact");
        return modelAndView;
    }

    @GetMapping("/utilisateur/parametre/experience")
    public ModelAndView parametreExperience() {
        ModelAndView modelAndView = new ModelAndView("template");
        modelAndView.addObject("page", "profil/modifyExperience");
        return modelAndView;
    }

    @GetMapping("/utilisateur/parametre/formation")
    public ModelAndView parametreFormation() {
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page","profil/modifyFormation");
        return modelAndView;
    }
}