package itu.secteur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SecteurJSONController {
    @Autowired
    SecteurRepository secteurRepository;
    
    @GetMapping("/secteur/liste")
    public List<Secteur> liste() {
        return secteurRepository.findAll();
    }

    @GetMapping("/secteur/statistique")
    public List<StatistiqueSecteur> getStatistiqueSecteurs() {
        return secteurRepository.getStatistiquePost();
    }
    
}
