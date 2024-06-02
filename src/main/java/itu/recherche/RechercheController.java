package itu.recherche;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import itu.model.*;
import itu.repository.*;

@Controller
public class RechercheController {
    private final SecteurRepository secteurRepository;
    private final DiplomeRepository diplomeRepository;
    private final CompetenceRepository competenceRepository;

    @Autowired
    public RechercheController(SecteurRepository secteurRepository,DiplomeRepository diplomeRepository,CompetenceRepository competenceRepository) {
        this.secteurRepository = secteurRepository;
        this.diplomeRepository = diplomeRepository;
        this.competenceRepository = competenceRepository;
    }

    @GetMapping("/recherche")
    public String recherche(Model model) throws Exception {
        List<Secteur> allSec = secteurRepository.findAll();
        List<Diplome> allDip = diplomeRepository.findAll();
        List<Competence> allComp = competenceRepository.findAll();
        model.addAttribute("allSecteurs", allSec);
        model.addAttribute("allDiplomes", allDip);
        model.addAttribute("allCompetences", allComp);
        return "recherche/recherche-form"; // Correspond à /WEB-INF/jsp/recherche/recherche.jsp
    }

    
}
