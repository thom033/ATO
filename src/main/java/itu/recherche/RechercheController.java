package itu.recherche;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.Compatibilite.PosteDetails;
import itu.Compatibilite.PosteDetailsService;
import itu.Compatibilite.ResultAcceuil;
import itu.Compatibilite.ResultAcceuilRepository;
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
    ResultAcceuilRepository resultAcceuilRepository;

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
    public ModelAndView searchResultRecherche(@RequestParam Map<String, String> params) {
        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
        ModelAndView mv = new ModelAndView("template");
        String title = params.get("title");
        Long diplome = params.get("diplome") != null && !params.get("diplome").isEmpty() ? Long.valueOf(params.get("diplome")) : null;
        Integer secteur = params.get("secteur") != null && !params.get("secteur").isEmpty() ? Integer.valueOf(params.get("secteur")) : null;
        String competence = params.get("competence");
        Integer ageMin = params.get("ageMin") != null && !params.get("ageMin").isEmpty() ? Integer.valueOf(params.get("ageMin")) : null;
        Integer ageMax = params.get("ageMax") != null && !params.get("ageMax").isEmpty() ? Integer.valueOf(params.get("ageMax")) : null;
        Double salaireMin = params.get("salaireMin") != null && !params.get("salaireMin").isEmpty() ? Double.valueOf(params.get("salaireMin")) : null;
        Double salaireMax = params.get("salaireMax") != null && !params.get("salaireMax").isEmpty() ? Double.valueOf(params.get("salaireMax")) : null;
        Integer distance = params.get("distance") != null && !params.get("distance").isEmpty() ? Integer.valueOf(params.get("distance")) : null;
        Integer anneeExperience = params.get("anneeExperience") != null && !params.get("anneeExperience").isEmpty() ? Integer.valueOf(params.get("anneeExperience")) : null;

        List<PosteDetails> resultPoste = posteDetailsService.searchPostes(title, diplome, secteur, competence, ageMin, ageMax, salaireMin, salaireMax, distance, anneeExperience);
        List<ResultAcceuil> result = new ArrayList<>();

        for (PosteDetails poste : resultPoste) {
            result.add(resultAcceuilRepository.getResultAcceuilsRecherche(utilisateur.getId(),poste.getIdPoste()));
        }

        mv.addObject("data", result);
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
            paramsList.add(diplome);
        }
        if (secteur != null && !secteur.isEmpty()) {
            sql.append(" AND id_secteur = ?");
            paramsList.add(secteur);
        }
        if (competence != null && !competence.isEmpty()) {
            sql.append(" AND competence_requise LIKE ?");
            paramsList.add("%" + competence + "%");
        }
        if (ageMin != null && !ageMin.isEmpty()) {
            sql.append(" AND age_requise >= ?");
            paramsList.add(ageMin);
        }
        if (ageMax != null && !ageMax.isEmpty()) {
            sql.append(" AND age_requise <= ?");
            paramsList.add(ageMax);
        }
        if (salaireMin != null && !salaireMin.isEmpty()) {
            sql.append(" AND poste_salaire >= ?");
            paramsList.add(salaireMin);
        }
        if (salaireMax != null && !salaireMax.isEmpty()) {
            sql.append(" AND poste_salaire <= ?");
            paramsList.add(salaireMax);
        }
        if (distance != null && !distance.isEmpty()) {
            sql.append(" AND distance <= ?");
            paramsList.add(distance);
        }
        if (anneeExperience != null && !anneeExperience.isEmpty()) {
            sql.append(" AND nbr_annee_experience >= ?");
            paramsList.add(anneeExperience);
        }

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql.toString(), paramsList.toArray());
        model.addAttribute("results", results);

        return "recherche/resultat";
    }
}
