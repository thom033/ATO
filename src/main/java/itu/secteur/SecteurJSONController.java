package itu.secteur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecteurJSONController {
    @Autowired
    SecteurRepository secteurRepository;
    
    @GetMapping("/secteur/liste")
    public List<Secteur> liste() {
        return secteurRepository.findAll();
    }
}
