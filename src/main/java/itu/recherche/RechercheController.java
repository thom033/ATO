package itu.recherche;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.competence.Competence;
import itu.competence.CompetenceRepository;
import itu.diplome.Diplome;
import itu.diplome.DiplomeRepository;
import itu.secteur.*;

@Controller
public class RechercheController {
    @Autowired
    SecteurRepository secteurRepository;

    @Autowired
    DiplomeRepository diplomeRepository;

    @Autowired
    CompetenceRepository competenceRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public RechercheController(SecteurRepository secteurRepository, DiplomeRepository diplomeRepository, CompetenceRepository competenceRepository, JdbcTemplate jdbcTemplate) {
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
            // Assuming diplome is a String, convert it to Long (bigint)
            sql.append(" AND id_diplome = ?");
            paramsList.add(Long.parseLong(diplome)); // Convert String to Long
        }
        if (secteur != null && !secteur.isEmpty()) {
            // Assuming secteur is a String, convert it to Long (bigint)
            sql.append(" AND id_secteur = ?");
            paramsList.add(Long.parseLong(secteur)); // Convert String to Long
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