package itu.secteur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

@RestController
public class SecteurJSONController {

    @Autowired
    SecteurRepository secteurRepository;

    @Autowired
    HttpSession httpSession;

    // Fetch all secteurs
    @GetMapping("/secteur/liste")
    public List<Secteur> liste() {
        return secteurRepository.findAll();
    }

    // Insert a new secteur
    @PostMapping("/secteur/insert")
    public List<Secteur> insert(@RequestBody Secteur secteur) {
        secteurRepository.save(secteur);
        return secteurRepository.findAll();
    }

    // Delete a secteur by id
    @GetMapping("/secteur/delete")
    public List<Secteur> delete(@RequestParam("idSecteur") Long idSecteur) {
        secteurRepository.deleteById(idSecteur);
        return secteurRepository.findAll();
    }

    // Fetch a specific secteur by id
    @GetMapping("/secteur/information")
    public Secteur getSecteur(@RequestParam("idSecteur") Long idSecteur) {
        return secteurRepository.findById(idSecteur).orElse(null);
    }

    // Update an existing secteur
    @PostMapping("/secteur/update")
    public List<Secteur> update(@RequestBody Secteur secteur) {
        secteurRepository.save(secteur);
        return secteurRepository.findAll();
    }
}
