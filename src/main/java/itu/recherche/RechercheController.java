package itu.recherche;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.compatibilite.PosteDetails;
import itu.compatibilite.PosteDetailsRepository;
import itu.compatibilite.PosteDetailsService;
import itu.compatibilite.ResultAcceuil;
import itu.compatibilite.ResultAcceuilRepository;
import itu.compatibilite.ResultAcceuilService;
import itu.competence.Competence;
import itu.competence.CompetenceRepository;
import itu.diplome.Diplome;
import itu.diplome.DiplomeRepository;
import itu.secteur.*;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@Controller
public class RechercheController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    SecteurRepository secteurRepository;

    @Autowired
    DiplomeRepository diplomeRepository;

    @Autowired
    CompetenceRepository competenceRepository;

    @Autowired
    PosteDetailsService posteDetailsService;

    @Autowired
    PosteDetailsRepository posteDetailsRepository;

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    @Autowired
    ResultAcceuilService resultAcceuilService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public RechercheController(SecteurRepository secteurRepository, DiplomeRepository diplomeRepository,
            CompetenceRepository competenceRepository, JdbcTemplate jdbcTemplate) {
        this.secteurRepository = secteurRepository;
        this.diplomeRepository = diplomeRepository;
        this.competenceRepository = competenceRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/recherche")
    public ModelAndView recherche() {
        ModelAndView mv = new ModelAndView("template");
        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
        if (utilisateur == null) {
            mv.setViewName("login/login-register");
            httpSession.setAttribute("nextPage", "/recherche");
        }
        List<Secteur> allSec = secteurRepository.findAll();
        List<Diplome> allDip = diplomeRepository.findAll();
        List<Competence> allComp = competenceRepository.findAll();
        mv.addObject("allSecteurs", allSec);
        mv.addObject("allDiplomes", allDip);
        mv.addObject("allCompetences", allComp);

        mv.addObject("page", "recherche/recherche-form");
        return mv;
    }

    @GetMapping("/search")
    public ModelAndView searchResultRecherche(
            @RequestParam Map<String, String> params,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {
        
        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
        ModelAndView mv = new ModelAndView("template");

        // Extraction des paramètres de recherche
        String title = params.get("title");
        Long diplome = params.get("diplome") != null && !params.get("diplome").isEmpty() ? Long.valueOf(params.get("diplome")) : null;
        Integer secteur = params.get("secteur") != null && !params.get("secteur").isEmpty() ? Integer.valueOf(params.get("secteur")) : null;
        Long competence = params.get("competence") != null && !params.get("competence").isEmpty() ? Long.valueOf(params.get("competence")) : null;
        Integer ageMin = params.get("ageMin") != null && !params.get("ageMin").isEmpty() ? Integer.valueOf(params.get("ageMin")) : null;
        Integer ageMax = params.get("ageMax") != null && !params.get("ageMax").isEmpty() ? Integer.valueOf(params.get("ageMax")) : null;
        Double salaireMin = params.get("salaireMin") != null && !params.get("salaireMin").isEmpty() ? Double.valueOf(params.get("salaireMin")) : null;
        Double salaireMax = params.get("salaireMax") != null && !params.get("salaireMax").isEmpty() ? Double.valueOf(params.get("salaireMax")) : null;
        Double distance = params.get("distance") != null && !params.get("distance").isEmpty() ? Double.valueOf(params.get("distance")) : null;
        Integer anneeExperience = params.get("anneeExperience") != null && !params.get("anneeExperience").isEmpty() ? Integer.valueOf(params.get("anneeExperience")) : null;

        // Recherche des postes
        List<PosteDetails> resultPoste = posteDetailsService.searchPostes(title, diplome, secteur, competence, ageMin, ageMax, salaireMin, salaireMax, anneeExperience);
        List<ResultAcceuil> result = new ArrayList<>();

        for (PosteDetails poste : resultPoste) {
            result.add(resultAcceuilRepository.getResultAcceuilsRecherche(utilisateur.getId(), poste.getIdPoste()));
            System.out.println("distance : " + posteDetailsRepository.calculateDistance(utilisateur.getId(), poste.getIdPoste()));
            System.out.println("id poste : " + poste.getIdPoste());
        }

        // Filtrer par distance
        if (distance != null) {
            Iterator<ResultAcceuil> iterator = result.iterator();
            while (iterator.hasNext()) {
                ResultAcceuil resultAcceuil = iterator.next();
                if (distance < posteDetailsRepository.calculateDistance(utilisateur.getId(), resultAcceuil.getIdPoste())) {
                    System.out.println("id posteee : " + resultAcceuil.getIdPoste());
                    iterator.remove();
                }
            }
        }

        // Pagination des résultats
        List<ResultAcceuil> paginatedResults = resultAcceuilService.getPaginatedResultsRecherche(result, page, size);

        // Ajout des attributs au ModelAndView
        mv.addObject("currentPage", page);
        mv.addObject("totalPages", (int) Math.ceil((double) result.size() / size));
        mv.addObject("size", size);
        mv.addObject("data", paginatedResults);

        // Ajouter les paramètres de recherche pour qu'ils puissent être utilisés dans les liens de pagination
        mv.addObject("params", params);

        mv.addObject("page", "acceuil/index");
        return mv;
    }


    @GetMapping("/recherche_result")
    public String searchResult(@RequestParam Map<String, String> params, Model model) {
        String title = params.get("title");
        String diplome = params.get("diplome");
        String secteur = params.get("secteur");
        String competence = params.get("competence");
        String ageMin = params.get("ageMin");
        String ageMax = params.get("ageMax");
        String salaireMin = params.get("salaireMin");
        String salaireMax = params.get("salaireMax");
        String distance = params.get("distance");
        String anneeExperience = params.get("anneeExperience");
    
        StringBuilder sql = new StringBuilder("SELECT * FROM postes_details WHERE 1=1");
        List<Object> paramsList = new ArrayList<>();
    
        
        if (title != null && !title.isEmpty()) {
            sql.append(" AND poste_titre LIKE ?");
            paramsList.add("%" + title + "%");
        }
        if (diplome != null && !diplome.isEmpty()) {
            sql.append(" AND id_diplome = ?");
            paramsList.add(Long.parseLong(diplome));
        }
        if (secteur != null && !secteur.isEmpty()) {
            sql.append(" AND id_secteur = ?");
            paramsList.add(Long.parseLong(secteur));
        }
        if (competence != null && !competence.isEmpty()) {
            sql.append(" AND competence_requise LIKE ?");
            paramsList.add("%" + competence + "%");
        }
        if (ageMin != null && !ageMin.isEmpty()) {
            sql.append(" AND (age_requise IS NULL OR age_requise >= ?)");
            paramsList.add(Integer.parseInt(ageMin));
        }
        if (ageMax != null && !ageMax.isEmpty()) {
            sql.append(" AND (age_requise IS NULL OR age_requise <= ?)");
            paramsList.add(Integer.parseInt(ageMax));
        }
        if (salaireMin != null && !salaireMin.isEmpty()) {
            sql.append(" AND poste_salaire >= ?");
            paramsList.add(Double.parseDouble(salaireMin));
        }
        if (salaireMax != null && !salaireMax.isEmpty()) {
            sql.append(" AND poste_salaire <= ?");
            paramsList.add(Double.parseDouble(salaireMax));
        }
        if (distance != null && !distance.isEmpty()) {
            sql.append(" AND distance <= ?");
            paramsList.add(Double.parseDouble(distance));
        }
        if (anneeExperience != null && !anneeExperience.isEmpty()) {
            sql.append(" AND nbr_annee_experience >= ?");
            paramsList.add(Integer.parseInt(anneeExperience));
        }
    
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql.toString(), paramsList.toArray());
        model.addAttribute("results", results);
    
        return "recherche/resultat";
    }
    
    
}
