package itu.recherche;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itu.model.*;
import itu.repository.*;

@Controller
public class RechercheController {

    private final SecteurRepository secteurRepository;
    private final DiplomeRepository diplomeRepository;
    private final CompetenceRepository competenceRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RechercheController(SecteurRepository secteurRepository, DiplomeRepository diplomeRepository, CompetenceRepository competenceRepository, JdbcTemplate jdbcTemplate) {
        this.secteurRepository = secteurRepository;
        this.diplomeRepository = diplomeRepository;
        this.competenceRepository = competenceRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/recherche")
    public String recherche(Model model) {
        List<Secteur> allSec = secteurRepository.findAll();
        List<Diplome> allDip = diplomeRepository.findAll();
        List<Competence> allComp = competenceRepository.findAll();
        model.addAttribute("allSecteurs", allSec);
        model.addAttribute("allDiplomes", allDip);
        model.addAttribute("allCompetences", allComp);
        return "recherche/recherche-form"; // Correspond à /WEB-INF/jsp/recherche/recherche.jsp
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
        
        if (title != null && !title.isEmpty()) {
            sql.append(" AND poste_titre LIKE ?");
            title = "%" + title + "%";
        }
        if (diplome != null && !diplome.isEmpty()) {
            sql.append(" AND id_diplome = ?");
        }
        if (secteur != null && !secteur.isEmpty()) {
            sql.append(" AND id_secteur = ?");
        }
        if (competence != null && !competence.isEmpty()) {
            sql.append(" AND competence_requise LIKE ?");
            competence = "%" + competence + "%";
        }
        if (ageMin != null && !ageMin.isEmpty()) {
            sql.append(" AND age_requise >= ?");
        }
        if (ageMax != null && !ageMax.isEmpty()) {
            sql.append(" AND age_requise <= ?");
        }
        if (salaireMin != null && !salaireMin.isEmpty()) {
            sql.append(" AND poste_salaire >= ?");
        }
        if (salaireMax != null && !salaireMax.isEmpty()) {
            sql.append(" AND poste_salaire <= ?");
        }
        if (distance != null && !distance.isEmpty()) {
            // Assuming there is a distance field or logic to calculate it
            sql.append(" AND distance <= ?");
        }
        if (anneeExperience != null && !anneeExperience.isEmpty()) {
            sql.append(" AND nbr_annee_experience >= ?");
        }

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql.toString(), getSqlParameters(params, title, diplome, secteur, competence, ageMin, ageMax, salaireMin, salaireMax, distance, anneeExperience));
        model.addAttribute("results", results);
        
        return "splashScreen/splash"; // the name of the result JSP page
    }

    private Object[] getSqlParameters(Map<String, String> params, String... dynamicParams) {
        return dynamicParams;
    }
}
